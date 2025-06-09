# Use OpenJDK 21 as the base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Add a volume pointing to /tmp for temporary files
VOLUME /tmp

# Add a volume for logs
VOLUME /var/log/story-teller

# Copy the JAR file built by Maven
COPY target/story-teller-be-0.0.1-SNAPSHOT.jar app.jar

# Environment variables
ENV SPRING_PROFILES_ACTIVE=dev
# Database connection details should be provided at runtime
# ENV JDBC_DATABASE_URL=
# ENV JDBC_DATABASE_USERNAME=
# ENV JDBC_DATABASE_PASSWORD=
# ENV JWT_SECRET=

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]