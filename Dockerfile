# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file
COPY target/back_end-1.0.0.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
