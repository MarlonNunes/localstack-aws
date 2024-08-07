export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
export AWS_DEFAULT_REGION=us-east-1

JSON='{"aws.secret-key": "my_secret", "aws.region": "us-east-1", "aws.queue-name": "my-queue", "aws.bucket-name": "my-bucket"}'

aws --endpoint-url=http://localstack:4566 secretsmanager create-secret --name /secret/localstack --secret-string "$JSON"
aws --endpoint-url=http://localstack:4566 s3api create-bucket --bucket $AWS_BUCKET_NAME
