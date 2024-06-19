This project is a Spring Boot application that utilizes a MySQL database. Here's how to get it running:

Prerequisites:

Java: Make sure you have Java installed on your system. You can check the version by running java -version in your terminal. Download and install Java from the official website (https://www.java.com/en/download/) if you don't have it.
MySQL: You'll need a MySQL database server running. You can install MySQL locally or use a cloud-based solution. Refer to the official MySQL documentation (https://dev.mysql.com/doc/) for installation instructions.
Database Setup:

Create a MySQL Database: 

Create a database specifically for this application on your MySQL server.


Application Configuration:

Configure app's connection to the MySQL database. Update the Application Configuration file with your specific database credentials:
spring.datasource.url: Set the JDBC URL for your MySQL database server.
spring.datasource.username: Enter your MySQL username.
spring.datasource.password: Enter your MySQL password.


Running the Application:

Navigate to Project Directory: Open your terminal and navigate to the directory where your Spring Boot application resides.
Build the Project: Use the command 'mvn package' to build the application. This will create an executable JAR file.
Run the Application: Run the application with the following command, replacing application.jar with the actual name of your JAR file:

Bash
'java -jar application.jar'

This will start the Spring Boot application and connect to your MySQL database based on the configuration provided.



cURL script for registering as a User:

curl --location --request POST 'api/user/register' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjE6dXNlcjEyMw==' \
--data '{
    "username": "String",
    "password": "String",
    "email": "String"

}'




cURL script for fetching user data securely:

curl --location --request GET 'api/user/fetch?username=username \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcjE6dXNlcjEyMw==' \
--data '{
    "username": "String"
}'
