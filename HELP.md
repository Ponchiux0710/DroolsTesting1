# Getting Started

### Description
This project is an example of how to use Drools in a Spring Boot application.
Drools is a business rules engine that allows you to define and apply rules dynamically in a Java application.

### Requirements
Make sure you have the following installed before running the project:

Java JDK 8 or higher
Maven 3.5 or higher




### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

To use the postman request, add a request to "POST" with the path http://localhost:8080/deadline 
Then use the following json to set the body for the request

* Month rule
{
"createdDate": "2023-06-26"
}
* Week rule
{
"createdDate": "2023-09-22"
}
* day rule
{
"createdDate": "2023-09-29"
}
* notice that the rule default parameters should be exactly the same as the ones mentioned before
* for the rules to work as expected.
