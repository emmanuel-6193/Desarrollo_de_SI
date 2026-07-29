# Fase 1: Compilar la aplicación Spring Boot
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# Buscar automáticamente dónde está el pom.xml y compilar allí
RUN POM_PATH=$(find /app -name "pom.xml" -maxdepth 3 | head -n 1) && \
    if [ -z "$POM_PATH" ]; then echo "ERROR: No se encontro pom.xml" && exit 1; fi && \
    POM_DIR=$(dirname "$POM_PATH") && \
    cd "$POM_DIR" && \
    mvn clean package -DskipTests

# Fase 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiar el .jar compilado sin importar dónde se generó
COPY --from=build /app/**/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
