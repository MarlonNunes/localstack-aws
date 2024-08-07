# Utilizando recursos do localstack com spring cloud aws

### 1. REQUISITOS
  - Docker e Docker Compose
  - Java 17
  - Postman (para testar as requisições)

### 2. Configurações
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.1. .env
```properties
AWS_SECRET_KEY=
AWS_QUEUE_NAME=
AWS_BUCKET_NAME=
```
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.2. application.yml
```yaml
spring:
  application:
    name: localstack
  cloud:
    aws:
      endpoint: http://localhost:4566 # Define o endpoint do LocalStack.
      sqs:
        queue:
          region: ${aws.region}
          auto-create: true # Isso é necessário para criar a fila automaticamente.
      s3:
        path-style-access-enabled: true # Isso é necessário para usar o acesso por caminho em vez do acesso por subdomínio.
  config:
    import: aws-secretsmanager:/secret/localstack # Importa as configurações do AWS Secrets Manager.
```
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.2 init-services.sh
&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; O docker compose sobe o localstack e após isso roda o script `init-services.sh` que cria o segredo e o bucket no localstack.

### 3. Executando o projeto
#### &nbsp; &nbsp;&nbsp;&nbsp; 3.1. Subindo o LocalStack
```shell
docker-compose up
```
Após isso é só rodar o projeto.

### 4. Testando as requisições
Para testar é só enviar uma requisição POST para `http://localhost:8080/upload` com o secret e o arquivo que deseja enviar.