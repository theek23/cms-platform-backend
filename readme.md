# 🧩 CMS Backend – Java Spring Boot API

This is the backend for a Content Management System (CMS) platform where users can register, manage their own blog websites, upload media, and integrate AI tools for writing and SEO.

Built with **Spring Boot** and **PostgreSQL**, this backend provides secure RESTful APIs, supports custom domains, and integrates with Stripe for paid subscriptions.

---

## 📦 Tech Stack

- **Java 17**
- **Spring Boot 3+**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Stripe API** (for subscriptions)
- **OpenAI API** (AI content tools)
- **AWS S3** (media uploads – optional)
- **Docker** (optional for local setup)

---

## 📂 Project Structure

src/main/java/com/cms/platform/backend

├── auth/             → Authentication & JWT logic  
├── config/           → Web, security, and CORS configuration  
├── controller/       → REST Controllers (User, Post, Site, Media, etc.)  
├── dto/              → Data Transfer Objects  
├── entity/           → JPA Entities (User, Site, Post, Media, etc.)  
├── repo/             → Spring Data JPA Repositories  
├── service/          → Interfaces for business logic  
├── service/impl/     → Implementations of service logic  
├── security/         → JWT filters, providers, password encoder  
└── advice/           → Global exception handling

---

## 🧰 Features

### ✅ Authentication
- JWT-based login
- Role-based access (USER, ADMIN)
- Registration, login, profile

### ✅ Site Management
- Create/update websites (blogs)
- Assign themes
- Connect custom domains

### ✅ Post Management
- Markdown or rich text content
- Draft/Publish control
- AI-powered writing & SEO (via OpenAI)

### ✅ Media Handling
- Upload images (to local or S3)
- Paginated media listing
- Size & type filtering

### ✅ Subscription (Stripe)
- Free vs Premium plan
- Webhook integration
- Tier-based usage restrictions

### ✅ Analytics
- Post views
- User insights

---

## 🛠️ API Endpoints (REST)

| Endpoint                      | Method | Description                        |
|------------------------------|--------|------------------------------------|
| `/api/auth/register`         | POST   | Register a new user                |
| `/api/auth/login`            | POST   | Login and receive JWT              |
| `/api/users/me`              | GET    | Get logged-in user profile         |
| `/api/sites`                 | CRUD   | Manage blog websites               |
| `/api/posts`                 | CRUD   | Manage blog posts                  |
| `/api/media`                 | GET    | Get paginated list of media files |
| `/api/media/upload`          | POST   | Upload new media                   |
| `/api/subscription`          | GET/POST | Stripe subscription handling     |

---

## 🚀 Getting Started

### 1. Clone and Setup
```bash
git clone https://github.com/yourname/cms-backend.git
cd cms-backend 
```

### 2. Configure Environment
Create application.yml or use environment variables for:
```bash
yaml
Copy
Edit
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/cms_db
    username: your_db_user
    password: your_db_pass

jwt:
  secret: your_jwt_secret
  expiration: 86400000

stripe:
  api-key: sk_test_...
  webhook-secret: whsec_...

openai:
  api-key: sk-...

aws:
  s3:
    bucket: your-bucket
    access-key: ...
    secret-key: ...
```

### 3. Run the App
```bash
./mvnw spring-boot:run
```

#### 🧪 API Testing
- Import Postman or Insomnia collections (not included here)

- Use Authorization: Bearer <token> for protected routes

#### 🛡️ DevSecOps Ready
- Passwords hashed with BCrypt

- JWT-based stateless auth

- Validations and global error handling

- CORS config for secure frontend access

#### 📄 License
- This project is MIT licensed. Use freely, but attribution is appreciated!

#### 📬 Contact
Built by Theekshana De Silva.
- 📧 LinkedIn: theekshanadesilva23@gmail.com
- 🌐 LinkedIn: https://linkedin.com/in/theekdesilva23

---

Let me know if you want:
- A `Dockerfile` and `docker-compose.yml`
- Swagger/OpenAPI docs added
- A matching frontend - Coming soon!

Ready to generate those too if needed.