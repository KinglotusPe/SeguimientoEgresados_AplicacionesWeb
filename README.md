# Seguimiento de Egresados / Sistema de Inventario - Aplicaciones Web

Sistema desarrollado en **Spring Boot 4 / Java 21** con **PostgreSQL / MySQL** y **JPA / Hibernate** para la gestión de inventario, equipos multifuncionales, personal, sedes, despachos y asignaciones.

---

## 🚀 Tecnologías

- **Lenguaje:** Java 21
- **Framework:** Spring Boot (Spring Data JPA, Spring Web MVC)
- **Persistencia / ORM:** Hibernate / Jakarta Persistence API
- **Bases de Datos Compatibles:** PostgreSQL (Principal) y MySQL
- **Gestor de Dependencias:** Apache Maven
- **Control de Versiones:** Git & GitHub (`SeguimientoEgresados_AplicacionesWeb`)

---

## 📁 Estructura del Proyecto

```text
SeguimientoEgresados_AplicacionesWeb/
├── backend/
│   └── proyectoinventario/
│       ├── pom.xml
│       └── src/
│           ├── main/
│           │   ├── java/aplicacionesweb/proyectoinventario/
│           │   │   ├── ProyectoinventarioApplication.java
│           │   │   └── entity/                    # Entidades JPA
│           │   │       ├── AsignacionEquipo.java
│           │   │       ├── Clasificacion.java
│           │   │       ├── Despacho.java
│           │   │       ├── DistritoFiscal.java
│           │   │       ├── Equipo.java
│           │   │       ├── EstadoEquipo.java
│           │   │       ├── Mantenimiento.java
│           │   │       ├── Marca.java
│           │   │       ├── Modelo.java
│           │   │       ├── Personal.java
│           │   │       ├── Rol.java
│           │   │       ├── Sede.java
│           │   │       ├── TipoMantenimiento.java
│           │   │       ├── TipoPersonal.java
│           │   │       ├── Usuario.java
│           │   │       └── UsuarioRol.java
│           │   └── resources/
│           │       └── application.properties     # Configuración de BD
│           └── test/
└── database/
    ├── 01_create_tables_postgresql.sql            # Script para PostgreSQL
    └── 01_create_tables_mysql.sql                 # Script para MySQL
```

---

## 🗄️ Modelo de Datos y Entidades

El modelo relacional se compone de **16 entidades** organizadas en módulos:

### 1. Tablas Maestras y Catálogos
- `distrito_fiscal` ([DistritoFiscal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/DistritoFiscal.java)): Distritos fiscales para ubicación de sedes.
- `tipo_personal` ([TipoPersonal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/TipoPersonal.java)): Clasificación del personal (fiscales, asistentes, administrativos, etc.).
- `marca` ([Marca](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Marca.java)): Marcas de equipos (HP, Epson, Ricoh, etc.).
- `clasificacion` ([Clasificacion](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Clasificacion.java)): Categoría o tipo de equipo.
- `estado_equipo` ([EstadoEquipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/EstadoEquipo.java)): Estado operativo (Operativo, Inoperativo, En Mantenimiento, etc.).
- `tipo_mantenimiento` ([TipoMantenimiento](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/TipoMantenimiento.java)): Preventivo, Correctivo, etc.
- `rol` ([Rol](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Rol.java)): Roles de acceso (Administrador, Operador, etc.).
- `usuario` ([Usuario](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Usuario.java)): Usuarios del sistema y credenciales.

### 2. Dependencias Principales
- `sede` ([Sede](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Sede.java)): Sedes físicas vinculadas a un distrito fiscal.
- `modelo` ([Modelo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Modelo.java)): Modelos vinculados a una marca.
- `personal` ([Personal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Personal.java)): Datos del personal con tipo de contrato/cargo.
- `despacho` ([Despacho](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Despacho.java)): Despachos o áreas asociadas a cada sede.
- `equipo` ([Equipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Equipo.java)): Equipos con código patrimonial, número de serie, modelo, clasificación y estado.

### 3. Transaccionales y Seguridad
- `asignacion_equipo` ([AsignacionEquipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/AsignacionEquipo.java)): Asignación histórica y activa de un equipo a un despacho y personal.
- `mantenimiento` ([Mantenimiento](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Mantenimiento.java)): Registro de mantenimientos, diagnósticos, trabajos realizados y repuestos.
- `usuario_rol` ([UsuarioRol](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/UsuarioRol.java)): Asignación de roles por usuario.

---

## 🛠️ Configuración y Ejecución

### 1. Clonar el Repositorio
```bash
git clone https://github.com/KinglotusPe/SeguimientoEgresados_AplicacionesWeb.git
cd SeguimientoEgresados_AplicacionesWeb
```

### 2. Base de Datos (PostgreSQL)
1. Abre tu cliente PostgreSQL (pgAdmin, DBeaver o psql).
2. Crea la base de datos `bd_inventario`:
   ```sql
   CREATE DATABASE bd_inventario;
   ```
3. Ejecuta el script de creación:
   ```text
   database/01_create_tables_postgresql.sql
   ```

### 3. Configurar el Backend
Revisa el archivo `backend/proyectoinventario/src/main/resources/application.properties`:
```properties
spring.application.name=seguimiento-egresados

spring.datasource.url=jdbc:postgresql://localhost:5432/bd_inventario
spring.datasource.username=tu_usuario_postgres
spring.datasource.password=tu_contrasena_postgres
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Compilar y Ejecutar

Desde la carpeta `backend/proyectoinventario`:

```powershell
# Compilar
.\mvnw.cmd clean compile

# Ejecutar la aplicación
.\mvnw.cmd spring-boot:run
```

La aplicación se iniciará en `http://localhost:8080`.