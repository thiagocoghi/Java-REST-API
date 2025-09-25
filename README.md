# Spring Boot REST CRUD (Users & Products)

Simple Spring Boot REST API with CRUD endpoints for Users and Products.
Features: Spring Boot, JPA/Hibernate, H2 (dev), Validation, Swagger (OpenAPI), Docker.
move inside the folder SpringBoot API than follow the steps below
## Run locally
1. Build:
   ```bash
   mvn clean package

2. mvn spring-boot:run

or

java -jar target/spring-boot-rest-crud-0.0.1-SNAPSHOT.jar

3. API docs (Swagger UI):
http://localhost:8080/swagger-ui.html

4. H2 Console:
http://localhost:8080/h2-console (jdbc:h2:mem:testdb, user=sa)
