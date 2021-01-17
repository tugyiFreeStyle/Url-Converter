# Trendyol Link Converter App

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
 

 ### DB Templates
 
Table Name: LINK_TEMPLATE
 
| PAGE_TYPE | WEB_URL_FORMAT |  DEEP_LINK_FORMAT |
| --------- | ------------------------- |  --------------------- |
| HOME      |                           |                        |
| SECTION   | /butik/liste/{SectionName}| &SectionId={SectionId} |
| PRODUCT   | /brand/name-p-{ContentId} | &ContentId={ContentId} |
| SEARCH    | q={QueryValue}            | &Query={QueryValue}    |
| OTHERS    |                           |                        |


Table Name: SECTION
 
| SECTION_ID |  SECTION_NAME |
| --------- | ------|
| 1         | kadın | 
| 2         | erkek | 
| 3         | supermarket |
| 4         | cocuk       |

Table Name: LINK
 
| ID | SHORT_LINK |  WEB_URL  | DEEP_LINK |
| --------- | ------------------------- |  --------------------- | ----- |
| 072e3c66-1a2a-4159-a2e9-479e | localhost:8080/abcdefgh | www.trendyol.com/butik/liste/kadin | ty://Page=Home&SectionId=1 |
| 992e3c66-1a2a-4159-a2e9-496  | localhost:8080/klmn |www.trendyol.com/casio/erkek-kol-saati-p-1925865 | ty://Page=Product&ContentId=1925865 |

Table Name: CONVERT_LINK_LOG
 
| REQUEST_URL | REQUEST_BODY |  RESPONSE_BODY  | CREATION_DATE |
| --------- | ------------------------- |  --------------------- | ----- |
|  | |  |  |



