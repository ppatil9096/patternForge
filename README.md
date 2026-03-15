# 📘 **PatternForge — Modern Java 25 + Spring Boot 4 Demonstration Project**

This project showcases **Modern Java (Records, Sealed Classes, Pattern Matching)** combined with **Spring Boot 4.0.3**, running on **Java 25 LTS**.

It demonstrates:

*   Sealed class hierarchies for event modeling
*   Record-based DTOs
*   Pattern matching for `switch`, type patterns, guarded patterns
*   Nested record deconstruction
*   A mini payment pipeline
*   A router built via pattern‑matching
*   Validation using record patterns
*   REST endpoints via Spring Boot 4
*   Fully Java 25‑compatible codebase

***

## 🚀 **Tech Stack (Verified Latest as of Feb 2026)**

*   **Java 25 LTS**
*   **Spring Boot 4.0.3** (latest stable release — Feb 19, 2026)
*   **Spring Framework 7** baseline
*   **Micrometer 2 + OpenTelemetry** support (Boot 4 default)
*   **Tomcat 11 (Servlet 6.1)** automatically via Boot 4

***

# 📂 **Project Structure**

    PatternForge/
    ├─ src/main/java/com/pravin/day2/
    │  ├─ Day2Application.java
    │  ├─ controller/
    │  ├─ model/   (records + sealed classes)
    │  ├─ service/ (pattern matching logic)
    │  ├─ validation/
    │  └─ http/
    └─ pom.xml

***

# ⚙️ **Prerequisites**

### **1. Java 25 (LTS)**

Ensure `java -version` prints something like:

    openjdk 25 2026-09-17 LTS

### **2. Maven 3.6+**

Spring Boot 4 supports Maven 3.6.3+

***

# 🧩 **Run the Application**

### **Via Maven**

```bash
mvn spring-boot:run
```

### **Via Jar**

```bash
mvn -q clean package
java --enable-preview -jar target/spring-boot-day2-1.0.0.jar
```

***

# 🧠 **IMPORTANT: Enable Java 25 Preview Features in IntelliJ IDEA**

Spring Boot 4 is compatible with Java 25 including preview language features like advanced pattern matching and record patterns.

**To enable preview in IntelliJ:**

### **Step 1 — Project Structure**

*   Open **File → Project Structure → Project**
*   Set:
    *   **Project SDK** → Java 25
    *   **Language Level** → *'Preview – Features from Java 25’* (or similar wording)

### **Step 2 — Compiler Settings**

*   Open **Settings → Build, Execution, Deployment → Compiler → Java Compiler**
*   Set:
    *   **Project bytecode version** → 25
    *   For your module:  
        **Add Compiler Flag:**
            --enable-preview

### **Step 3 — Run/Debug Configurations**

Edit your Spring Boot run config:

*   Open **Run → Edit Configurations**
*   Select your Spring Boot app
*   Add to JVM options:
        --enable-preview

### ✔ Preview Mode enabled successfully!

***

# 🧪 **API Reference**

Base URL:

    http://localhost:8080/api

***

## **1. Event Processing Demo**

### `GET /api/events/demo`

```bash
curl -X GET "http://localhost:8080/api/events/demo"
```

***

## **2. Signup Validation**

### `POST /api/signup`

```bash
curl -X POST "http://localhost:8080/api/signup" \
  -H "Content-Type: application/json" \
  -d '{
        "user": { "name": "Asha", "address": { "city": "Pune", "state": "MH" } },
        "email": "asha@example.com",
        "password": "s3cur3Pwd!"
      }'
```

***

## **3. Router (Pattern-Matching Based)**

### `POST /api/router`

#### Route GET `/health`

```bash
curl -X POST "http://localhost:8080/api/router" \
  -H "Content-Type: application/json" \
  -d '{ "path": "/health", "body": "" }'
```

#### Route POST `/payments`

```bash
curl -X POST "http://localhost:8080/api/router" \
  -H "Content-Type: application/json" \
  -d '{
        "path": "/payments",
        "body": "{ \"txnId\": \"TXN-777\", \"amount\": 25900 }"
      }'
```

***

## **4. Payment Capture**

### `POST /api/payments/capture`

```bash
curl -X POST "http://localhost:8080/api/payments/capture?txnId=TXN-100&amount=49900"
```

***

# 🎯 **What This Project Demonstrates**

### ✔ Modern Java 25 idioms

*   Pattern Matching for `switch`
*   Type + Record Patterns
*   Guarded Patterns
*   Records
*   Sealed Class Hierarchies

### ✔ Clean Spring Boot 4 Architecture

*   Fully up-to-date as of 2026
*   Boot 4 + Framework 7 + Tomcat 11 compatibility
*   No legacy JavaEE/Jakarta EE 10 artifacts
*   Runnable with zero warnings

### ✔ Domain Modeling Best Practices

*   Strongly typed event flows
*   Algebraic Data Type via `Result<T>`
*   Declarative validation using pattern deconstruction
