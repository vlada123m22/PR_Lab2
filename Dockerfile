# Step 1: Use an official OpenJDK image to build the app
FROM openjdk:21-jdk-slim AS builder

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY target/lab2-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your Spring Boot application will run on
EXPOSE 8080

# Step 5: Set the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
