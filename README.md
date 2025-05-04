# 📦 Service_A Microservice

A Spring Boot-based microservice that:

- Saves incoming messages to an in-memory H2 database.
- Sends the saved message to Apache Kafka.
- Exposes REST APIs with auto-generated Swagger documentation.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (H2 in-memory DB)
- Apache Kafka
- Springdoc OpenAPI (Swagger UI)
- Lombok
- ModelMapper
- SLF4J Logging

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.Service_A/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── exception/
│   │       ├── repository/
│   │       ├── serviceInterface/
│   │       ├── serviceImp/
│   │       └── utility/
│   └── resources/
│       └── application.yml
```

---

## ⚙️ Configuration (`application.yml`)

```yaml
server:
  port: 8082

spring:
  application:
    name: Service_A

  datasource:
    url: jdbc:h2:mem:ass2db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password:

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate.dialect: org.hibernate.dialect.H2Dialect

  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true

  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

---

## 🛠️ Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/23Logesh/Microservice_A.git
cd Service_A
```

### 2. Start Kafka (locally or via Docker)
If you're using Docker:
```bash
docker-compose up -d
```

> Make sure Kafka is running on `localhost:9092`.

### 3. Run the Spring Boot application
Using Maven:
```bash
./mvnw spring-boot:run
```

---

## 📑 API Documentation (Swagger UI)

Once the application is running, access the Swagger documentation:

🌐 [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)

---

## 🧪 H2 Database Console

You can inspect the database directly via the H2 console:

🌐 [http://localhost:8082/h2-console](http://localhost:8082/h2-console)

- **JDBC URL**: `jdbc:h2:mem:ass2db`
- **Username**: `sa`
- **Password**: _(leave blank)_

---

## 🧾 Sample API

### Save a message
```http
POST /api/v1/save
Content-Type: application/json

{
  "message": "Hello from Service_A"
}
```

---

## 📝 Logging Pattern

Logs follow the consistent format:
```
[SERVICE_A] - [MODULE] - [ACTION] - [STATUS]
```

Example:
```
[SERVICE_A] - [SAVE] - Entity saved with ID: 101 - [SUCCESS]
[SERVICE_A] - [KAFKA] - Message sent to topic: ServerA-topic | Key: 101 | Payload: {...} - [SUCCESS]
```

---

## ✅ Features

- Save messages to DB and forward to Kafka.
- API exposed via Swagger UI.
- H2 in-memory database with web console access.
- Centralized exception handling with `@RestControllerAdvice`.
- Clean code using ModelMapper and Lombok.

---

## 🔁 CI/CD

- **CI Jenkinsfile**: Builds the project, runs tests, and creates a Docker image.
- **CD Jenkinsfile**: Pulls the Docker image and runs it locally using Docker.

---

## 📬 Contact

For any questions or help, feel free to contact [23logeshwaran@gmail.com].
