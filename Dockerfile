# Step 1: Use an official lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Maven wrapper and project configuration files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Step 4: Download dependencies (this caches them for faster builds later)
RUN ./mvnw dependency:go-offline

# Step 5: Copy the actual source code
COPY src ./src

# Step 6: Build the application inside the container
RUN ./mvnw clean package -DskipTests

# Step 7: Expose the port Spring Boot runs on
EXPOSE 8080

# Step 8: Run the application jar file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
