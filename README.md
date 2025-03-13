1. How I Built the Project

Spring Boot Project:

Using STS

Project Type: Maven

Language: Java

Spring Boot Version: 3.1+

Dependencies: Spring Web,devtools,Spring Data JPA, MySQL Driver,validator,Validation, Lombok 

Defined Project Structure: src/main/java/com/example

controller

entity

repository

service

impl Created Entity Class:

Used @Embedded for Address object

Used @ElementCollection for List<String> coursesOffered

Added validation using @Email, @Pattern, @NotBlank Created Repository Layer:

Extended JpaRepository

Added custom query methods Created Service Layer:

Implemented business logic using JPA methods Created Controller:

Created TrainingController.java

Used @PostMapping and @GetMapping Added Exception Handling:

Used @RestControllerAdvice

Created GlobalExceptionHandler.java


2. API Endpoints
    Method| Endpoint | Description
    POST | /traingpost | Add a new training center
    GET | /list | Get all training centers with filtering


3. Sample Request and Response
     POST /add Request: { "centerName": "Javacenter", "centerCode": "JAVANTR1234", "address": { "detailedAddress": "Sector 22, Noida", "city": "Noida", "state": "UP", "pincode": "201301" }, "studentCapacity": 100, "coursesOffered": ["Java", "Spring Boot"], "contactEmail": "info@javacenter.com", "contactPhone": "9876543210" }
     GET /list?city=Noida&state=UP&course=Java
     Response: [ { "id": 1, "centerName": "Java Center", "centerCode": "JAVACNTR1234", "address": { "detailedAddress": "Sector 22, Noida", "city": "Noida", "state": "UP", "pincode": "201301" }, "studentCapacity": 100, "coursesOffered": ["Java", "Spring Boot"], "contactEmail": "khushigupta.com", "contactPhone": "9876543210" } }


4. Conclusion

    Project created using Spring Boot and Hibernate

    Filtering and exception handling implemented


