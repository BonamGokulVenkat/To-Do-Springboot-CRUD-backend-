# Step 1: Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Use JDK 21 to run the app
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]