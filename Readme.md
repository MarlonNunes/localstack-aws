# Utilizando recursos do localstack

### 1. REQUISITOS
  - Docker e Docker Compose
  - Java 17
  - Postman (para testar as requisições)

### 2. Configurações
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.1. application.yml
```yaml
    spring:
      cloud:
        aws:
          secretsmanager:
            endpoint: http://localhost:4566 // Endpoint do localstack
      config:
        import: aws-secretsmanager:/secret/localstack // Importa o segredo do localstack
```
#### &nbsp; &nbsp;&nbsp;&nbsp; 2.2 create-sh
&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; O docker compose sobe o localstack e após isso roda o script `create.sh` que cria o segredo no localstack.

### 3. Executando o projeto