# Prueba Técnica - [Carlos Munoz]

Este proyecto es la resolución de la prueba técnica de Java y Spring Boot.

## Requisitos
- Java 17+
- Maven 3.8+

## Cómo Ejecutar
1. Clona el repositorio: `git clone [https://github.com/carlosrmngucuenca/EvaluacionCarloMunoz.git]`
2. Navega a la raíz del proyecto.
3. Ejecuta el comando: `./mvnw spring-boot:run`
4. La aplicación estará disponible en `http://localhost:8080`.

## Ejercicios Implementados

### Lógica (Ejercicios 1, 2, 3)
Los resultados de estos ejercicios se imprimen en la consola al iniciar la aplicación, utilizando `CommandLineRunner`.

### Implementación 1 (Ejercicio 4)
- **Carga de datos:** Los datos de `https://jsonplaceholder.typicode.com/posts` se cargan en la base de datos H2 en memoria al iniciar.
- **Endpoint:** `GET /api/posts/user/{userId}/titles`
  - Consulta los títulos de los posts para un `userId` específico.
- **Consola H2:** Disponible en `http://localhost:8080/h2-console`

### Implementación 2 (Ejercicio 5)
- **Endpoint:** `GET /api/external/users`
  - Consulta en tiempo real la lista de usuarios de `https://jsonplaceholder.typicode.com/users` y la devuelve.
