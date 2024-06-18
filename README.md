api/user/register:


curl --location 'http://localhost:8080/user/register' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjE6dXNlcjEyMw==' \
--header 'Cookie: JSESSIONID=3C9B2F0897F97ACC0BB4ACD069E8C6FC' \
--data '{
    "username": "String",
    "password": "String",
    "email": "String"

}'



api/user/fetch:


curl --location --request GET 'http://localhost:8080/user/fetch?username=' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjE6dXNlcjEyMw==' \
--header 'Cookie: JSESSIONID=3C9B2F0897F97ACC0BB4ACD069E8C6FC' \
--data '{
    "username": "user1"
}'
