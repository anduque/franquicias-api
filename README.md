# Franquicias API

API desarrollada en **Spring Boot** para manejar franquicia, sucursal y producto.
Utiliza **MySQL** como base de datos y está lista para correr con **Docker**.

## Tecnologías utilizadas

* Java 17
* Spring Boot 3.5.6
* Spring Data JPA
* MySQL 8
* Maven
* Docker / Docker Compose

## Estructura de carpetas

```
franquicias-api/
│
├── src/main/java/com/anduque/franquiciasapi/
│   ├── controller/       # Contiene los controllers de Franquicia, Sucursal, Producto
│   ├── dto/              # Contiene los DTOs de request y update
│   ├── model/            # Contiene las entidades: Franquicia, Sucursal, Producto
│   ├── repository/       # Repositorios JPA
│   ├── service/          # Servicios de negocio
│   └── exception/        # Manejo de errores y ApiResponse
│
├── src/main/resources/
│   └── application.properties
│
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## Cómo ejecutar localmente con Docker Compose

1. Construir y levantar los contenedores:

```
docker-compose up --build
```

2. La API estará disponible en: `http://localhost:8080`
3. La base de datos MySQL estará expuesta en el puerto `3307` de tu máquina local.

## Cómo ejecutar localmente sin Docker

### Requisitos

* Java 17+
* Maven 3.8+
* MySQL 8+ instalado localmente
* Git

### Configurar la base de datos

1. Crea una base de datos local en MySQL.
2. Configura `src/main/resources/application.properties` con tus credenciales locales, por ejemplo:

```
spring.datasource.url=jdbc:mysql://localhost:3306/mi_db
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

### Ejecutar con Maven

```
mvn clean install
mvn spring-boot:run
```

* La API estará disponible en `http://localhost:8080`.

### Ejecutar como JAR (opcional)

```
mvn clean package
java -jar target/tu-app-0.0.1-SNAPSHOT.jar
```

## Endpoints

### Franquicia

#### Crear una nueva franquicia

* **POST** `/franquicia`
* **Request Body**:

```json
{
  "nombre": "Nombre de la franquicia"
}
```

#### Obtener todas las franquicias

* **GET** `/franquicia`

#### Actualizar el nombre de una franquicia

* **PATCH** `/franquicia/{id}/nombre`
* **Request Body**:

```json
{
  "nuevoNombre": "Nombre actualizado"
}
```

#### Obtener productos con mayor stock por sucursal para una franquicia

* **GET** `/franquicia/{id}/productos-mayor-stock`

### Sucursal

#### Crear una nueva sucursal

* **POST** `/sucursal`
* **Request Body**:

```json
{
  "nombre": "Nombre de la sucursal",
  "franquiciaId": 1
}
```

#### Obtener todas las sucursales

* **GET** `/sucursal`

#### Actualizar el nombre de una sucursal

* **PATCH** `/sucursal/{id}/nombre`
* **Request Body**:

```json
{
  "nuevoNombre": "Nombre actualizado"
}
```

### Producto

#### Crear un nuevo producto

* **POST** `/producto`
* **Request Body**:

```json
{
  "nombre": "Nombre del producto",
  "stock": 10,
  "sucursalId": 1
}
```

#### Actualizar el nombre de un producto

* **PATCH** `/producto/{id}/nombre`
* **Request Body**:

```json
{
  "nuevoNombre": "Nombre actualizado"
}
```

#### Actualizar el stock de un producto

* **PATCH** `/producto/{id}/stock`
* **Request Body**:

```json
{
  "stock": 15
}
```

#### Eliminar un producto

* **DELETE** `/producto/{id}`

## Nota sobre los JSON de actualización

Para todos los endpoints que actualicen el nombre de una entidad (`franquicia`, `sucursal`, `producto`), el JSON debe contener el campo `nuevoNombre`.

Ejemplo:

```json
{
  "nuevoNombre": "Nombre actualizado"
}
```