# Use an official Java 22 JDK runtime as a parent image
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/personal-finance-management-app.jar /app/personal-finance-management-app.jar

# Expose the port your app runs on
EXPOSE 4444

# Run the JAR file
ENTRYPOINT ["java", "-jar", "personal-finance-management-app.jar"]
