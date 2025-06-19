#  Basic Spring Student Management API

A backend system built with Spring Boot that manages student data, handles secure user authentication (JWT), and supports emailing, SMS, and image upload functionality.

---

## Features

- Full CRUD operations for students
- Filter & search students by name, SAT, graduation score, date of birth, and more
- Upload and store student profile pictures to AWS S3
- Send email and SMS notifications to all students
- JWT-based user authentication
- Custom global exception handling
- Swagger integration for easy API exploration

---

## Tech Stack

- Java 17
- Spring Boot
- Maven
- JWT Security
- JPA / Hibernate
- AWS S3 (image upload)
- Apache Commons
- Swagger
- Joda-Time

---

## API Endpoints Overview

| Method | Endpoint                         | Description                               |
|--------|----------------------------------|-------------------------------------------|
| GET    | `/api/students`                  | Search students with filters & pagination |
| GET    | `/api/students/{id}`             | Get one student by ID                     |
| POST   | `/api/students`                  | Add a new student                         |
| PUT    | `/api/students/{id}`             | Update an existing student                |
| DELETE | `/api/students/{id}`             | Delete a student                          |
| POST   | `/api/students/email/all`        | Send email to all students                |
| POST   | `/api/students/sms/all`          | Send SMS to all students                  |
| PUT    | `/api/students/{id}/image`       | Upload a profile picture for a student    |
| GET    | `/api/students/highSat?sat=1000` | Get students with SAT > x                 |

---

## Project Structure

```
src/
├── main/
│   ├── java/com/handson/basic/
│   │   ├── controller/         → StudentsController
│   │   ├── jwt/                → Auth, filters, tokens
│   │   ├── model/              → Student DTOs and Entities
│   │   ├── util/               → Email, SMS, AWS, error handling
│   │   └── config/             → Swagger and WebSecurity config
│   └── resources/
│       └── application.properties
```


---

## Getting Started

### Prerequisites:
- Java
- Maven
- AWS S3 credentials (if using image upload)

### Run locally:
```bash
git clone https://github.com/Vadilat/basic-spring.git
cd basic-spring
mvn spring-boot:run
Access Swagger at:
📄 http://localhost:8080/swagger-ui/

📄 License
MIT License © Vadim Latsman

✨ Notes
Ensure AWS credentials are configured for the image upload to work.

Email and SMS services may require API key setup.
