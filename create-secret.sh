export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID
export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY
export AWS_DEFAULT_REGION=us-east-1

JSON=$(jq -n \
          --arg my_secret "$SECRET_KEY" \
          --arg aws_secret_key "$AWS_SECRET_ACCESS_KEY" \
          --arg aws_access_key "$AWS_ACCESS_KEY_ID" \
          --arg aws_queue_name "$AWS_QUEUE_NAME" \
          '{
              "my-secret-key": $my_secret,
              "aws.region": "us-east-1",
              "aws.secret_key": $aws_secret_key,
              "aws.access_key": $aws_access_key,
              "aws.queue-name": $aws_queue_name
          }')
aws --endpoint-url=http://localstack:4566 secretsmanager create-secret --name /secret/localstack --secret-string "$JSON"
