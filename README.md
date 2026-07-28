Markdown
# HelpDesk System - API Backend

Sistema de gestión de tickets de soporte técnico desarrollado con Java, Spring Boot y PostgreSQL.

---

## Requisitos Previos y Dependencias

Antes de ejecutar la aplicación, asegúrate de contar con lo siguiente:

### Dependencias Principales (Backend)
* **Java:** JDK 21
* **Framework:** Spring Boot 3.x
* **Módulos Spring:** 
  * *Spring Web* (para crear servicios REST)
  * *Spring Data JPA* (para el manejo de base de datos)
* **Base de Datos:** PostgreSQL Driver (`postgresql`)
* **Gestor de Construcción:** Maven (con Wrapper `./mvnw` incluido)

---

## Pasos e Instrucciones de Ejecución

### 1. Configuración de la Base de Datos
1. Abre **pgAdmin** o tu cliente SQL preferido.
2. Crea una base de datos vacía llamada `helpdesk_db`.
3. Ejecuta el script SQL de creación de tablas ubicado en:
   ```text
   db/schema.sql

2. Configuración de Credenciales
Verifica o edita las credenciales de conexión a PostgreSQL en:
backend/src/main/resources/application.properties

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/helpdesk_db
spring.datasource.username=postgres
spring.datasource.password=123456

3. Iniciar el servidor Backend
Abre una terminal dentro de la carpeta backend/ y ejecuta:

En Windows (CMD / PowerShell):
Bash
mvnw.cmd spring-boot:run
En Linux / macOS / Git Bash:
Bash
./mvnw spring-boot:run
La aplicación se iniciará en la URL base: http://localhost:8080

Prueba de Endpoints (API REST)
GET http://localhost:8080/api/tickets — Consultar lista de tickets.

POST http://localhost:8080/api/tickets — Crear un nuevo ticket de soporte.

GET http://localhost:8080/api/users — Listar usuarios del sistema.

Estructura del Proyecto
Plaintext
helpdesk/
├── backend/          # Código fuente de la API REST (Spring Boot)
├── db/               # Scripts DDL para PostgreSQL (schema.sql)
└── docs/             # Documentación, capturas e informe (.pdf)
