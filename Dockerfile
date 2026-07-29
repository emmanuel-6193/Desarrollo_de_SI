# Fase 1: Compilar la aplicación Spring Boot
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# Entramos a la carpeta backend donde está el pom.xml
WORKDIR /app/backend
RUN mvn clean package -DskipTests

# Fase 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiamos el .jar generado desde dentro de la carpeta backend
COPY --from=build /app/backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
