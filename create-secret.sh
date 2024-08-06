export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
export AWS_DEFAULT_REGION=us-east-1

JSON=$(jq -n \
          --arg my_secret "$SECRET_KEY" \
          '{
              "my_secret_key": my_secret
          }')
aws --endpoint-url=http://localstack:4566 secretsmanager create-secret --name /secret/localstack --secret-string "$JSON"