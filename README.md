# 🚀 Java REST API – User & Product Management  

This is a **REST API built with Spring Boot** for managing **users and products**.  

It includes:  
✅ CRUD endpoints  
✅ Database with **JPA/Hibernate**  
✅ API documentation with **Swagger**  
✅ Dockerfile for containerized deployment  
✅ Compatible with **H2 (in-memory)**, **MySQL** and **PostgreSQL**  

---

## 📦 Requirements  

- Java 17+  
- Maven 3.8+  
- (Optional) Docker  
- MySQL or PostgreSQL (if not using H2)  

---

## ▶️ Running the Project  

### 🔹 Windows (PowerShell/Command Prompt)  

```powershell
# Run with Maven
mvn spring-boot:run
```

### 🔹 Linux / MacOS (Bash)
```powershell
# Run with Maven Wrapper
./mvnw spring-boot:run
```
---
🗄️ Database Setup

The project supports H2 (default), MySQL, and PostgreSQL.
Schema and sample data are included in:

- src/main/resources/schema.sql

- src/main/resources/data.sql

---

1️⃣ Using H2 (default)

No configuration needed.
Access H2 console at:
👉 http://localhost:8080/h2-console

Login:

- JDBC URL: jdbc:h2:mem:testdb

- User: root

- Password: (empty)

---

2️⃣ Using MySQL

1. Create the database:
```powershell
mysql -u root -p
CREATE DATABASE java_rest_api;
```
2. Update src/main/resources/application.properties:
```powershell
spring.datasource.url=jdbc:mysql://localhost:3306/java_rest_api?useSSL=false&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
```

---

3️⃣ Using PostgreSQL

1. Create the database:
```powershell
psql -U postgres
CREATE DATABASE java_rest_api;
```
2. Update src/main/resources/application.properties:
```powershell
spring.datasource.url=jdbc:postgresql://localhost:5432/java_rest_api
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
```

---

📖 API Documentation

Once running, access Swagger at:
👉 http://localhost:8080/swagger-ui.html

---

🐳 Run with Docker

```powershell
# Build image
docker build -t java-rest-api .

# Run container
docker run -p 8080:8080 java-rest-api

```
---

👨‍💻 Endpoints
Users

- GET /users → list all users

- GET /users/{id} → get user by ID

- POST /users → create new user

- PUT /users/{id} → update user

- DELETE /users/{id} → delete user

Products

- GET /products → list all products

- GET /products/{id} → get product by ID

- POST /products → create new product

- PUT /products/{id} → update product

- DELETE /products/{id} → delete product

🗂️ Database Scripts

- schema.sql → creates tables users and products.

- data.sql → inserts sample data.

✨ Author

👨‍💻 Developed by Thiago Coghi

Motivated by technology, innovation, and problem solving.
Always looking to create scalable and intelligent solutions.





