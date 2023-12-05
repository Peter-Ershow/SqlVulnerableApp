# SqlVulnerableApp
SQL Vulnerable Application - README
Overview
This SQL Vulnerable Application is designed for educational purposes to demonstrate the risks and effects of SQL Injection vulnerabilities in web applications. This application is intentionally vulnerable and should only be used in a safe, controlled environment for learning and training.

Warning: This application contains severe security vulnerabilities. Do not deploy it in a production environment or expose it to the internet.

Setup
Clone the Repository: Clone this repository to your local machine.
Install Dependencies: Make sure you have Java and Spring Boot installed.
Database Setup: This application requires a SQL database. Configure the application.properties file with your database details.
`docker run --name mydb -e MYSQL_ROOT_PASSWORD=pw -p 3306:3306 -d mysql:5.7.44`
in DB do 
`CREATE DATABASE mydb;`

in application properties set spring.datasource.password to pw
Run the Application: Execute the Spring Boot application. It will be available at http://localhost:8080.
Endpoints
This application includes the following endpoints that demonstrate SQL injection vulnerabilities:

Safe Endpoint:

URL: `http://localhost:8080/users/testSafe/' OR '1'='1`
Description: This endpoint simulates a "safe" query, which, despite its name, is vulnerable to SQL injection. It provides a real-time example of how SQL injection can be exploited.

Unsafe Endpoint:

URL: `http://localhost:8080/users/testWrong/' OR '1'='1`
Description: This endpoint is an example of an incorrectly implemented query that is vulnerable to SQL injection. It shows the common mistakes that lead to these vulnerabilities.
How to Use
To test the vulnerabilities, you can use tools like curl, Postman, or your web browser.
Try modifying the SQL part (' OR '1'='1) in the URL to see how different inputs can manipulate the SQL query's behavior.
Learning Objectives
Understand how SQL Injection works.
Learn how to prevent SQL Injection vulnerabilities.
Identify common mistakes in handling user inputs.
Security Disclaimer
Again, this application is intentionally insecure. Use it only in a safe, isolated environment for educational purposes.

This README provides a basic structure and should be expanded with any specific setup instructions, dependencies, or additional details relevant to the application. The focus is on education and security awareness, underscoring the risks associated with SQL injection vulnerabilities.
