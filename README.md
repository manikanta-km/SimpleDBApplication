# Simple File-Based Database Application

This Spring Boot application implements a simple file-based one-table database system with Redis integration for success and failure counters.

## Overview

This project demonstrates a RESTful API for managing a file-based database:

- **Database Type**: File-based, single-table database
- **Backend**: Java Spring Boot
- **Database Management**: Metadata and table data stored in text files (`metadata.txt`, `table.txt`)
- **Counter Management**: Redis for counting success and failure operations

## Features

- **API Endpoints**: CRUD operations via RESTful endpoints
- **Redis Integration**: Success and failure counters stored in Redis
- **Swagger Documentation**: Access API documentation via Swagger UI

## Dockerization

### Prerequisites

- Docker installed on your system
- Maven for building the project locally

### Building the Docker Image

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd simple-file-based-db

2. Build the Docker image
   ```bash
   docker build -t simpledb-application .
   
### Running the Docker Container
Use Docker Compose for running the application stack (Spring Boot app and Redis):
1. Modify docker-compose.yml as needed (adjust ports, volumes).
2. Run the Docker containers:
   ```bash
   docker-compose up -d --build

### Accessing the Application
    Access the Swagger UI for API documentation:
    ```bash
    http://localhost:8080/swagger-ui/index.html

### Stopping the Docker Container
    To stop the Docker containers:
     ```bash
     docker-compose down


## Accessing the application locally


## Running the Application

### Locally with IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Make sure Java and Maven are properly configured.
3. Set up Redis locally or configure `application.properties` for Redis connection details.
4. Build and run `FileBasedDbApplication.java`.

### Locally with Redis in Docker

1. Make sure Docker is installed.
2. Run Redis in Docker:
   ```bash
   docker run -d -p 6379:6379 --name my-redis redis:alpine
3. Configure application.properties for Redis connection
     ```bash
     spring.redis.host=localhost
     spring.redis.port=6379
4. Open the project in IntelliJ IDEA.
5. Build and run FileBasedDbApplication.java.

### Contributions
    Manikanta Kotekal Methukula
