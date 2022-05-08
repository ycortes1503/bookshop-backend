# Book Shop Project

## Technology
This application uses the following key technologies:
- [Java 11](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8.4](https://maven.apache.org/download.cgi)
- [Liquibase 4.10.0](https://mvnrepository.com/artifact/org.liquibase/liquibase-core)

## Description
This application manages book information. Each book contains its particular attributes like title, author, and overview.
It has been built for academic purposes, to put into practice the knowledge about different technologies.

## Setup

### Docker
In the root of the project there is a folder named docker that contains a docker-compose.yml 
file that can be used to create an instance of MySQL using Docker.

After run the next command, the instance will be available:

```
sudo docker-compose up -d
```

### Swagger Documentation

- http://localhost:8080/api-docs.yaml
- http://localhost:8080/swagger-ui.html

Swagger and Springdoc-openapi have been integrated to the project to simplify the use of the APIs and testing 
of the application.