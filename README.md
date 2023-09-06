![soviet.png](src/main/resources/images/soviet.png)

# The Universal Ticket Service :ticket:

The Universal Ticket Service is an API that provides managing ticket service. It offers a versatile platform for organizations to handle ticketing systems efficiently.

[UPDATED] -> Is not a simple CRUD application. 

# About

The tickets is composed by owner, and the worker or workers.

# Dependencies

1 - dynamodb access

list of tables :

    | table name |
    |------------|
    | r00_ticket |
    | r00_user   |


#  Local Enviroments

```bash
export UTS_ENDPOINT="http://localhost:8080"

```

# Cheatsheet 

```shell
curl -X POST \
    -H "Content-Type: application/json" \
    -u "root:root" \
    -d '{"description":"close terminal."}' $UTS_ENDPOINT/ticket
```

```shell
aws dynamodb create-table \
    --table-name r00_ticket \
    --attribute-definitions AttributeName=openedBy,AttributeType=S AttributeName=openedAt,AttributeType=N \
    --key-schema AttributeName=openedBy,KeyType=HASH AttributeName=openedAt,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
    --region sa-east-1 \
    --endpoint http://localhost:8000/
```

```shell
aws dynamodb create-table \
    --table-name r00_user \
    --attribute-definitions AttributeName=userId,AttributeType=S \
    --key-schema AttributeName=userId,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
    --region sa-east-1 \
    --endpoint http://localhost:8000/
```

```shell
aws dynamodb scan \
    --table-name r00_ticket \
    --region sa-east-1 \
    --endpoint http://localhost:8000/
```
