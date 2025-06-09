# Packaging Instructions for Story Teller Backend

This document provides instructions for packaging the Story Teller Backend application.

## Prerequisites

- Java 21 installed
- Maven installed (version 3.6 or higher recommended)
- Ensure your JAVA_HOME environment variable is set to point to Java 21

## Building the Package

To create a runnable JAR package of the application, follow these steps:

### 1. Clean and Package the Application

```bash
mvn clean package
```

This command will:
- Clean the target directory
- Compile the source code
- Run the tests
- Package the application into a JAR file

If you want to skip the tests during packaging, use:

```bash
mvn clean package -DskipTests
```

### 2. Package Location

After successful build, the packaged JAR file will be available at:

```
target/story-teller-be-0.0.1-SNAPSHOT.jar
```

### 3. Verifying the Package

To verify that the JAR file was created correctly:

```bash
# Check the file exists
dir target\story-teller-be-0.0.1-SNAPSHOT.jar

# Check the JAR file contents
jar tf target\story-teller-be-0.0.1-SNAPSHOT.jar | findstr "StoryTellerBeApplication"
```

You should see the main application class listed in the output, confirming that the JAR file contains the compiled application.

## Running the Packaged Application

### Basic Execution

To run the packaged application with default settings:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar
```

### Running with Specific Profile

The application supports multiple profiles: dev, test, local, and prod. To run with a specific profile:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

### Environment-Specific Configuration

#### Production Environment

When running in production mode, you need to provide database connection details:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar \
  --spring.profiles.active=prod \
  --JDBC_DATABASE_URL=jdbc:postgresql://your-db-host:5432/your-db-name \
  --JDBC_DATABASE_USERNAME=your-username \
  --JDBC_DATABASE_PASSWORD=your-password \
  --JWT_SECRET=your-jwt-secret
```

#### Development Environment

For development, you can use:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

#### Test Environment

For testing:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```

#### Local Environment

For local development:

```bash
java -jar target/story-teller-be-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```

## Accessing the Application

Once running, the application will be available at:

```
http://localhost:8080/api
```

The port and context path may vary based on the profile configuration.

## Logging

Logs will be written to the location specified in the active profile configuration. For the production profile, logs are written to:

```
/var/log/story-teller/application-prod.log
```

Make sure the directory exists and is writable by the user running the application.

## Troubleshooting

### Java Version Compatibility Issues

If you encounter errors related to class file version incompatibility (e.g., "class file has wrong version"), ensure that:

1. You are using Java 21 as specified in the pom.xml file
2. Your JAVA_HOME environment variable points to Java 21
3. Maven is using the correct Java version

To check which Java version Maven is using:

```bash
mvn -v
```

If Maven is not using Java 21, you can set it for the current session:

```bash
# For Windows
set JAVA_HOME=path\to\java21
# For Linux/Mac
export JAVA_HOME=/path/to/java21
```

### Dependency Issues

If you encounter dependency-related errors:

1. Try clearing your Maven repository cache:

```bash
mvn dependency:purge-local-repository
```

2. Update your Maven dependencies:

```bash
mvn dependency:resolve
```

### Build Errors

For other build errors, try:

```bash
mvn clean package -X
```

This will provide detailed debug information that can help identify the issue.
