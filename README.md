# Link Converter App

This project is developed by Java 8. The Spring boot project is preferred.

  - Java 8
  - Maven

## Frameworks & Libraries

  - SpringBoot
  - Lombok
  - Junit5
  - AssertJ
  - Mockito
  - Springfox (Swagger)
  - Hibernate
  
  ## Warming up

To run this project succesfully, database should be initialized. Db Migration is not part of this project. Api contracts easily can be viewed at http://localhost:8080//swagger-ui.html

 ## Structure
 Onion architecture  is used for project structure. DDD building blocks are also used for domain modelling.
 
 ## Features
 
 - Req-response logging handled by globally using “@ControllerAdvice” (Seperation of Concerns)
 - Global exception handling.
 - To Optimize query endpoint caching is used. (Redis can be implemented easily through spring provider)
 - Parameterized Testing to embrace DRY




