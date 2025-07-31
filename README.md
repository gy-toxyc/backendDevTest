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

## Paso a Paso

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