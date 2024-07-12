# First stage: Build the application
FROM maven:3.8.1-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN mvn clean install

# Second stage: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the first stage
COPY --from=build /app/target/*.jar /app/payment-service.jar

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "payment-service.jar"]
