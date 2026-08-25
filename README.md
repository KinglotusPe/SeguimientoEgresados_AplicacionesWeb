# Sistema de Control de Multifuncionales

Sistema para la gestión, trazabilidad y control de equipos multifuncionales distribuidos en los diferentes **Distritos Fiscales**, **Sedes** y **Despachos**, permitiendo la asignación directa al **Personal** responsable y el registro del historial de **Mantenimientos técnicos** preventivos y correctivos.

---

## 📌 Propósito y Dominio del Sistema

El sistema resuelve la necesidad de administrar el parque de multifuncionales en dependencias fiscales mediante:
1. **Estructura Organizacional Fiscal**: Jerarquía de *Distrito Fiscal* ➔ *Sede* ➔ *Despacho* ➔ *Personal*.
2. **Catálogo de Equipos Multifuncionales**: Registro por *Marca*, *Modelo*, *Clasificación*, *Estado*, *Código Patrimonial* y *Número de Serie*.
3. **Control de Asignaciones**: Trazabilidad de qué multifuncional está asignada a qué despacho y funcionario (fecha inicio, fecha fin y observaciones).
4. **Gestión de Mantenimiento Técnico**: Control de diagnósticos, repuestos sustituidos, trabajos realizados y responsable del servicio técnico.
5. **Seguridad y Acceso**: Gestión de usuarios, credenciales y asignación de roles.

---

## 🚀 Tecnologías

- **Lenguaje:** Java 21
- **Framework:** Spring Boot (Spring Data JPA, Spring Web MVC)
- **Persistencia / ORM:** Hibernate / Jakarta Persistence API
- **Bases de Datos Compatibles:** PostgreSQL (Principal) y MySQL
- **Gestor de Dependencias:** Apache Maven
- **Control de Versiones:** Git & GitHub

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
│           │   │   └── entity/                    # Entidades JPA del Sistema
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
    ├── 01_create_tables_postgresql.sql            # Script DDL PostgreSQL
    └── 01_create_tables_mysql.sql                 # Script DDL MySQL
```

---

## 🗄️ Modelo Relacional y Entidades JPA

El sistema se compone de **16 entidades** organizadas según su función:

### 1. Estructura Institucional y Personal
- `distrito_fiscal` ([DistritoFiscal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/DistritoFiscal.java)): Jurisdicción o distrito fiscal.
- `sede` ([Sede](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Sede.java)): Sede física vinculada a un distrito fiscal.
- `despacho` ([Despacho](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Despacho.java)): Despacho o fiscalía perteneciente a una sede (tipo de proceso).
- `tipo_personal` ([TipoPersonal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/TipoPersonal.java)): Tipo o cargo del personal.
- `personal` ([Personal](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Personal.java)): Funcionarios y trabajadores (DNI, nombres, apellidos, contacto).

### 2. Catálogo de Multifuncionales
- `marca` ([Marca](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Marca.java)): Marca del fabricante (HP, Epson, Ricoh, Canon, etc.).
- `modelo` ([Modelo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Modelo.java)): Modelo técnico por marca.
- `clasificacion` ([Clasificacion](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Clasificacion.java)): Categoría o tipo de multifuncional.
- `estado_equipo` ([EstadoEquipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/EstadoEquipo.java)): Estado operativo (Operativo, Inoperativo, En Mantenimiento, Baja).
- `equipo` ([Equipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Equipo.java)): Ficha del equipo multifuncional con código patrimonial único, número de serie, modelo, estado y fecha de adquisición.

### 3. Operaciones: Asignaciones y Mantenimientos
- `asignacion_equipo` ([AsignacionEquipo](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/AsignacionEquipo.java)): Asignación del equipo al despacho y personal custodio con rango de fechas.
- `tipo_mantenimiento` ([TipoMantenimiento](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/TipoMantenimiento.java)): Preventivo, correctivo u overhaul.
- `mantenimiento` ([Mantenimiento](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Mantenimiento.java)): Registro de intervenciones técnicas, diagnóstico, trabajos efectuados, repuestos utilizados y técnico responsable.

### 4. Seguridad
- `rol` ([Rol](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Rol.java)): Perfiles y roles de usuario.
- `usuario` ([Usuario](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/Usuario.java)): Usuarios del sistema y estado de cuenta.
- `usuario_rol` ([UsuarioRol](file:///d:/aplicacionesWeb/SistemaInventario_AplicacionesWeb/backend/proyectoinventario/src/main/java/aplicacionesweb/proyectoinventario/entity/UsuarioRol.java)): Asignación de roles por usuario.

---

## 🛠️ Configuración y Ejecución

### 1. Base de Datos (PostgreSQL)
1. Conéctate a PostgreSQL y crea la base de datos:
   ```sql
   CREATE DATABASE bd_multifuncionales;
   ```
2. Ejecuta el script de creación de tablas:
   ```text
   database/01_create_tables_postgresql.sql
   ```

### 2. Configuración en `application.properties`
Ajusta tus credenciales en `backend/proyectoinventario/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bd_multifuncionales
spring.datasource.username=postgres
spring.datasource.password=tu_contrasena
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 3. Compilar y Ejecutar

Desde la carpeta `backend/proyectoinventario`:

```powershell
# Compilar proyecto
.\mvnw.cmd clean compile

# Iniciar servidor Spring Boot
.\mvnw.cmd spring-boot:run
```