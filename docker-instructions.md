# Docker Instructions for Story Teller Backend

This document provides instructions for building and running the Story Teller Backend application using Docker.

## Prerequisites

- Docker installed on your machine
- Java 21 and Maven installed (for building the application)

## Building the Application

Before creating the Docker image, you need to build the application using Maven:

```bash
mvn clean package -DskipTests
```

This will create a JAR file in the `target` directory.

## Building the Docker Image

To build the Docker image, run the following command from the project root directory:

```bash
docker build -t story-teller-be:latest .
```

## Running the Docker Container

To run the Docker container, use the following command:

```bash
docker run -d \
  --name story-teller-backend \
  -p 8080:8080 \
  -e JDBC_DATABASE_URL=jdbc:postgresql://your-db-host:5432/your-db-name \
  -e JDBC_DATABASE_USERNAME=your-username \
  -e JDBC_DATABASE_PASSWORD=your-password \
  -e JWT_SECRET=your-jwt-secret \
  story-teller-be:latest
```

Replace the placeholder values with your actual database connection details and JWT secret.

## Environment Variables

The application requires the following environment variables:

- `JDBC_DATABASE_URL`: JDBC URL for the PostgreSQL database
- `JDBC_DATABASE_USERNAME`: Database username
- `JDBC_DATABASE_PASSWORD`: Database password
- `JWT_SECRET`: Secret key for JWT token generation and validation

## Accessing the Application

Once the container is running, the application will be available at:

```
http://localhost:8080/api
```

## Viewing Logs

To view the application logs, you can use the following command:

```bash
docker logs story-teller-backend
```

## Stopping the Container

To stop the container, use:

```bash
docker stop story-teller-backend
```

To remove the container:

```bash
docker rm story-teller-backend
```