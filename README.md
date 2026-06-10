# Social Bookmarking and Discovery Backend

A production-style backend service for social bookmarking and content discovery built with Spring Boot, PostgreSQL, Redis, Docker, and JWT authentication.

## Features

* User registration and login
* JWT-based authentication
* BCrypt password hashing
* Bookmark creation and retrieval
* Feed retrieval with Redis-backed caching
* Cursor-based pagination
* PostgreSQL persistence with indexed queries
* Dockerized deployment
* Interactive API documentation with Swagger/OpenAPI
* Automated CI pipeline with GitHub Actions
* Load tested with k6

## Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security

### Database & Caching

* PostgreSQL
* Redis

### DevOps

* Docker
* Docker Compose
* GitHub Actions

### Testing & Documentation

* Swagger/OpenAPI
* k6 Load Testing

---

## Architecture

Client Applications interact with Spring Boot REST APIs.

The application uses:

* PostgreSQL for persistent storage
* Redis for feed caching
* JWT for authentication and authorization
* Docker Compose for local orchestration
* GitHub Actions for continuous integration

---

## API Endpoints

### Authentication

| Method | Endpoint             | Description                  |
| ------ | -------------------- | ---------------------------- |
| POST   | `/api/auth/register` | Register a new user          |
| POST   | `/api/auth/login`    | Authenticate and receive JWT |

### Users

| Method | Endpoint     | Description        |
| ------ | ------------ | ------------------ |
| GET    | `/api/users` | Retrieve all users |
| POST   | `/api/users` | Create user        |

### Bookmarks

| Method | Endpoint         | Description        |
| ------ | ---------------- | ------------------ |
| GET    | `/api/bookmarks` | Retrieve bookmarks |
| POST   | `/api/bookmarks` | Create bookmark    |

### Feed

| Method | Endpoint    | Description          |
| ------ | ----------- | -------------------- |
| GET    | `/api/feed` | Retrieve cached feed |

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/Jaiswal-Devpriya/Social-Bookmarking-Discovery-Backend.git
cd Social-Bookmarking-Discovery-Backend
```

### Start Application

```bash
docker compose up --build
```

Application will be available at:

```text
http://localhost:8080
```

---

## Swagger Documentation

Interactive API documentation:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Example Login Request

```http
POST /api/auth/login
```

```json
{
  "email": "docker@example.com",
  "password": "test123"
}
```

Response:

```json
{
  "token": "JWT_TOKEN"
}
```

---

## Performance Testing

Load testing was performed using k6.

Results:

* 100 concurrent virtual users
* 774K+ requests executed
* 0% request failures
* Sub-7ms p95 latency

---

## CI/CD

GitHub Actions automatically:

* Builds the Spring Boot application
* Packages the project
* Builds the Docker image
* Validates every push and pull request

---

## Future Improvements

* Role-based authorization
* Bookmark tagging and categorization
* Personalized feed ranking
* Cloud deployment
* Integration and unit testing

---

## Author

Devpriya Jaiswal

GitHub: https://github.com/Jaiswal-Devpriya
