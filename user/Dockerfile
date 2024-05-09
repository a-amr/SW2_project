# Use the official OpenJDK 11 image as the base image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/user-0.0.1-SNAPSHOT.jar /app/user-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "user-0.0.1-SNAPSHOT.jar"]
