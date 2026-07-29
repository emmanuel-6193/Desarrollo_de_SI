# Fase 1: Compilar la aplicación Spring Boot con Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

WORKDIR /app/backend
RUN mvn clean package -DskipTests

# Fase 2: Ejecutar la aplicación con Java 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
