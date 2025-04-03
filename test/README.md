
# 🛠️ Qima Backend API - Product & Category Management

REST API developed as a solution for the technical challenge, using **Spring Boot, Spring MVC, Spring Security, JPA/Hibernate** and **H2 Database** for in-memory persistence.

## 📄 Summary

- 🎯 Features
- ⚙️ Requirements
- 🚀 How to run
- 🗂️ Project structure
- 🔐 Security
- 📥 Main endpoints
- ✅ Data validation
- 📌 Technical considerations
- 📚 Technologies used

---

## 🎯 Features

- ✅ Full CRUD for products (create, edit, delete, list)
- ✅ Association of multiple categories per product (Many-to-Many relationship)
- ✅ Data validation and business rules enforcement
- ✅ RESTful API
- ✅ Access control with **Basic Authentication**
- ✅ H2 in-memory database
- ✅ CORS configuration for Angular front-end integration
- ✅ Structure ready for future category path implementation

---

## ⚙️ Requirements

- Java 17+
- Maven 3.8+
- (Optional) Postman or any HTTP client to test the API

---

## 🚀 How to run

1. **Clone the repository:**

```bash
git clone <your-repository>
cd backend
```

2. **Run the application:**

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

The application will be available at:

```
http://localhost:8080
```

---

## 🗂️ Project structure

```
src/
 ├── main/
 │   ├── java/com/test/qima/test
 │   │   ├── config            # Security and CORS configuration
 │   │   ├── controller        # REST controllers (Product, Category)
 │   │   ├── domain            # JPA entities (Product, Category)
 │   │   ├── dto               # Data Transfer Objects
 │   │   ├── repository        # JPA repositories
 │   │   └── service           # Business logic
 │   └── resources
 │       ├── application.properties # Spring Boot configuration
```

---

## 🔐 Security

The API is protected with **Spring Security - Basic Authentication**.  
Default access credentials:

| User  | Password | Role  |
|:----:|:-------:|:-----:|
| admin | admin123 | ADMIN |

All endpoints require authentication, except for the H2 console:

```
http://localhost:8080/h2-console
```

---

## 📥 Main endpoints

| Method | URL                         | Description                 |
|:-----:|:----------------------------:|:--------------------------:|
| GET   | `/api/products`              | List all products          |
| GET   | `/api/products/{id}`         | Get product by ID          |
| POST  | `/api/products`              | Create a new product       |
| PUT   | `/api/products/{id}`         | Update an existing product |
| DELETE| `/api/products/{id}`         | Delete a product           |

> **Note:** Category endpoints are also available but were not mandatory in the challenge.

---

## ✅ Data validation

The following business rules are enforced:

- **Product:**
    - `name`: cannot be empty
    - `price`: required and must be greater than zero
    - `quantityInStock`: required and must be greater than zero
    - `categoryIds`: required (at least one category)

In case of invalid data, the API returns status `400 Bad Request` with a list of validation messages.

---

## 📌 Technical considerations

- The data model is prepared for future implementation of **Category Path** through a Many-to-Many relationship.
- Good practices applied:
    - RESTful pattern
    - SOLID and Clean Code principles
    - Separation of concerns (Controller, Service, Repository)
    - DTO usage
    - Bean Validation API (`@NotBlank`, `@Positive`, etc.)
- In-memory H2 database: reset every time the application starts.

---

## 📚 Technologies used

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring MVC
- JPA / Hibernate
- H2 Database
- Jakarta Bean Validation

---

