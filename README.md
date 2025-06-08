# Announcement Service

A secure Spring Boot REST API for managing announcements.  
Authentication is handled via Keycloak, with MySQL as the database and Elasticsearch for full-text search.

---

## Tech Stack

- Java 8
- Spring Boot 2.7.18
- MySQL 8
- Keycloak 20.0.3
- Elasticsearch 7.17.10
- Docker & Docker Compose
- Maven

---

## Project Structure

announcement-service/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── src/

---

## Features

- CRUD operations on announcements
- Secured endpoints via Keycloak
- MySQL persistence
- Dockerized setup
- Full-text search with Elasticsearch

---

## Keycloak Configuration

Before running the app, ensure the following Keycloak setup:

1. Access Keycloak at [http://localhost:8080]
2. Login:
   - Username: 'admin'
   - Password: 'admin'
3. The file 'announcement-realm-export.json' is used to import realm configuration during startup
   - New realm: 'announcement-realm'
   - Client ID: 'announcement-client'
   - Access Type: 'bearer-only`
   - User: 'testuser'
   - Password: 'password'

---

## Running the App

### Prerequisites

- Java 8
- Maven
- Docker + Docker Compose

---

### 1. Build the App

mvn clean package

This creates 'target/announcement-service.jar'.

---

### 2. Start with Docker Compose

docker-compose up --build

Services:
- 'announcement-service' (Spring Boot)
- 'mysql'
- 'keycloak'
- 'elasticsearch'

---

### REST Endpoints

All endpoints require a valid Bearer Token from Keycloak.

| Method | Endpoint                    | Description              |
|--------|-----------------------------|--------------------------|
| GET    | '/api/announcements'        | List all announcements  |
| GET    | '/api/announcements/{id}'   | Get by ID                |
| POST   | '/api/announcements'        | Create announcement      |
| PUT    | '/api/announcements/{id}'   | Update announcement      |
| DELETE | '/api/announcements/{id}'   | Delete announcement      |
| GET    | '/api/announcements/search?keyword=...' | Search announcements |

---

## Sample Announcement JSON

json
{
  "title": "New Feature Launch",
  "content": "We have launched a new feature!"
}


---

## Authentication (Example with CURL)

1. Get token from Keycloak:
curl -X POST 'http://localhost:8080/auth/realms/announcement-realm/protocol/openid-connect/token' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'grant_type=password' \
  -d 'client_id=announcement-client' \
  -d 'username=<your-username>' \
  -d 'password=<your-password>'

2. Use token to call API:
curl -H "Authorization: Bearer <access_token>" http://localhost:8081/api/announcements

---

## Clean Up

docker-compose down

---

## Notes

- To access Keycloak admin UI: [http://localhost:8080]
- Elasticsearch dashboard: [http://localhost:9200](http://localhost:9200)
- Default MySQL port: 3306 with database 'announcement_db'
