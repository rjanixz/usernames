Username List Problem 
===================

This app is developed using Spring Boot and Angular4 for BE and FE

Prerequisites

 - [Angulr CLI](https://www.npmjs.com/package/@angular/cli/tutorial) (require Node 6.9.0 or higher, together with NPM 3 or higher)
 - Maven 3.x
 - Java 1.8

How to run it

 - Checkout the repo https://github.com/rjanixz/usernames.git
 - To Run the BE App go to *usernames/spring* directory
 - execute `mvn package` and then `java -jar target/usernames-0.0.1-SNAPSHOT.jar`
	 - http://localhost:8080/api/users and http://localhost:8080/api/restricted-words should be availabe
 - To Run the FE App go to *usernames/angula4-client* directory
 - execute `npm install` and then `ng serve`
	 - http://localhost:4200/users and http://localhost:4200/restricted-words should be availabe

> **Note:**

> - Since these apps are running in different ports. It is required a plugin in the browser to allow the comunication between them. In chrome you can install [this plugin](https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi) 



----------

Database

H2 database has been used for this app. To access to its console go to http://localhost:8080/console and login with the following info:

| Value | Setting |
| --------- |-------------|
| Driver | Class	org.h2.Driver |
| JDBC URL |	jdbc:h2:mem:testdb |
| User Name  | sa |
| Password | blank |