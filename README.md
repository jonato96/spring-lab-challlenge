# Spring Lab Challenge Application built with Spring Cloud

This microservices were made to practice a full architecture, this project was built with Spring Cloud Gateway, Spring Cloud Config, Resilience4j and the Eureka Service Discovery from the Spring Cloud Netflix stack.

## Starting services locally

Every microservice is a Spring Boot application and can be started locally using IDE (Lombok plugin has to be set up) or maven command `../mvnw spring-boot:run`. Is important that supporting services (Config and Discovery Server) must be started before any other application (Patient and Examinations)..
If everything goes well, you can access the following services at given location:
* Discovery Server - http://localhost:8761
* Config Server - http://localhost:8888
* Patient MCSV - http://localhost:9090
* Examination MCSV - http://localhost:9095
* API Gateway - http://localhost:8080
The Config Server fetches the configuration from a [GitHub Repository](https://github.com/jonato96/spring-lab-challenge-config)
Both MCSVs have a fixed port but you can also assign a different one by maven command `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=your-port` or by setting port 0 in the configuration.

## Database configuration

In its default configuration, Patient MCSV and Examination MCVS uses a PostgreSQL DB with a create-drop initialization and empty data.
Dependency for PostgreSQL JDBC driver is already included in the `pom.xml` files.

## Understanding the problem

In a prestigious laboratory of the city, a group of scientists, hopes to find the cure against an infectious disease that has been affecting the respiratory tract of patients for some years; one of the scientists found when examining the blood of patients, that those who had a sugar percentage higher than 70%, fat percentage higher than 88.5% and oxygen percentage lower than 60% had a HIGH risk of becoming seriously ill. 5% and oxygen percentage less than 60% had a HIGH risk of becoming seriously ill; those with sugar percentage between 50% and 70%, fat percentage between 62.2% and 88.5%, and oxygen percentage between 60% and 70% had a MEDIUM risk of becoming seriously ill; those with sugar percentage less than 50%, fat percentage less than 62.2% and oxygen percentage greater than 70% had a LOW risk of becoming seriously ill. It is important to understand that the percentage of each of the values must be a valid percentage [0-100], if it is not, the user should be given feedback with the error.

The laboratory needs a software solution to be written following best development practices, division of responsibilities and quality attributes such as scalability, maintainability and performance, which, given a blood test, calculates the level of risk that a patient has of becoming seriously ill by contracting this infectious disease.

In addition, the laboratory wants to be able to consult at any time, the information of the blood evaluated and the level of risk given by the system per patient; to draw reports and submit to the Ministry of Health, audit information if necessary.

## Deliverables

- Source code path of the application in any alternative code repository (this).
- Usability report of the application, in the way you want and that you consider maintainable and practical (README.md). 
- Perform the implementation of the REST services needed to get the software up and running. 
- Implement unit tests

## Architecture diagram of the Spring Lab Challenge Application

![image](https://user-images.githubusercontent.com/80604082/206969256-ce49a9ea-2c69-4c3e-ad1a-9852c834c851.png)
