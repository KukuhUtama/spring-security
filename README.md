REST with Spring

Needed Tools

- Eclipse IDE
- JDK 1.7
- Maven 3.x
- MySql
- Git
- Postman Extension

Steps

- Pull repository
- Set JRE System Library in java Build Path point to JDK 1.7
- Create new database with "hibernate" name
- Edit user and password for MySql database at application.properties file respectively
- Run command mvn clean install
- Deploy generated WAR file to Web container

URL

 -http://localhost:8080/spring-mvc/author/addauthor (POST)
 
 -http://localhost:8080/spring-mvc/author/updateauthor (POST)
 
 -http://localhost:8080/spring-mvc/author/deleteauthor (POST)
 
 -http://localhost:8080/spring-mvc/author/getallauthor (GET)
 
 -http://localhost:8080/spring-mvc/book/addbook (POST)
 
 -http://localhost:8080/spring-mvc/book/updatebook (POST)
 
 -http://localhost:8080/spring-mvc/book/deletebook (POST)
 
 -http://localhost:8080/spring-mvc/book/getallbook (GET)
 
 Hit all those API Url using Postman extension with proper input attribute and request method type.
 
