# BackEnd Dev Test

Este servicio posee un único endpoint que permite obtener una lista de productos similares a un producto dado.

```http request
GET /api/similar-products/:productId
```

## Versiones

- Java `23`
- Spring Boot `3.5.4`
- Maven Compiler `3.14.0`

<br>

## Toma de Decisiones

Para esta aplicación se ha decidido utilizar una Arquitectura Hexagonal, aplicando con ella los principios de SOLID, DDD y TDD.
- La capa de `infrastructure` se compone de dos partes, el controlador, que expone los endpoints de la API, 
y la parte externa, que se compone de todas las conexiones a dependencias externas, en este caso únicamente a la API proporcionada (utilizando la dependencia `Feign` y el patrón Facade).
- La capa de `application`, que contiene toda la lógica de negocio.
- La capa de `domain`, que establece el modelo de dominio y las interfaces que garantizan la inversión de dependencias.

Para el manejo de excepciones a nivel externo, es decir, las respuestas de error de la API, se utiliza un `ControllerAdvice` que centraliza el manejo de excepciones y errores.

Entre las capas, los objetos complejos sufren modificaciones/mapeos para lo que se utiliza `MapStruct`.

Los tests unitarios, utilizando `JUnit` y `Mockito`, están realizados siguiendo el principio de TDD.

<br>

## Guía de Ejecución

Para poder tener este proyecto funcionando en tu máquina local, se deben seguir los siguientes pasos.

1. Preparar la infraestructura.

```bash
docker-compose up -d simulado influxdb grafana
```

2. Instalar dependencias (requiere tener Maven instalado).

```bash
mvn clean install
```

3. Construir la aplicación.

```bash
mvn package
```

4. Ejecutar la aplicación.

```bash
java -jar target/products-1.0.0.jar
```