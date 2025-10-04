# SpringCinema

SpringCinema es una aplicación web desarrollada con Spring Boot para la gestión de cines, películas y reservas.

## Características

- Gestión de películas y funciones
- Reservas de asientos
- Administración de usuarios
- Interfaz web intuitiva

## Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Thymeleaf

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/springCinema.git
   ```
2. Accede al directorio:
   ```bash
   cd springCinema/cinema
   ```
3. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## Entidades

La aplicación gestiona las siguientes entidades principales:

- **Cine**: Representa un cine con sus salas y ubicación.
- **Sala**: Espacio dentro de un cine donde se proyectan películas.
- **Película**: Información sobre las películas disponibles.
- **Función**: Proyección de una película en una sala y horario específico.
- **Usuario**: Personas que pueden reservar asientos y administrar el sistema.
- **Reserva**: Registro de asientos reservados por los usuarios para una función.

## Uso

Accede a `http://localhost:8080` en tu navegador para comenzar a usar la aplicación.

## Contribución

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la licencia MIT.
