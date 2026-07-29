# Fase 1: Compilar la aplicación Spring Boot
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

WORKDIR /app/backend
# Forzamos codificación UTF-8 para evitar errores de compilación
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Fase 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
