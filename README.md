# 🌱 Carbon Footprint Calculator API  
A production-ready Spring Boot application that calculates carbon footprint, stores history in PostgreSQL, and runs fully in Docker.

## 🚀 Features
- REST API (Spring Boot 3.5)
- PostgreSQL persistence with JPA/Hibernate
- Swagger UI documentation
- Token-based Authentication
- Docker Compose support
- Footprint history logging

## 📌 Endpoints
### Calculate Footprint  
`GET /api/v1/footprint?distance=100&co2Emission=0.21`  
**Requires Token:** `X-API-KEY: your_token_here`

### Footprint History  
`GET /api/v1/footprint/history`

---

## 🐳 Docker Compose
Start full environment:
```bash
docker compose up -d
