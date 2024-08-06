# Utilizando recursos do localstack

### 1. REQUISITOS
  - Docker e Docker Compose
  - Java 17
  - Postman (para testar as requisições)

### 2. Configurações
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.1. .env
```properties
    SECRET_KEY=
    AWS_SECRET_ACCESS_KEY=
    AWS_ACCESS_KEY_ID=
    AWS_QUEUE_NAME=
```
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.2. application.yml
```yaml
    spring:
    application:
      name: localstack
    cloud:
      aws:
        endpoint: http://localhost:4566
        sqs:
          queue:
            region: ${aws.region}
            auto-create: true
    config:
      import: aws-secretsmanager:/secret/localstack
```
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.2 create-sh
&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; O docker compose sobe o localstack e após isso roda o script `create.sh` que cria o segredo no localstack.

### 3. Executando o projeto