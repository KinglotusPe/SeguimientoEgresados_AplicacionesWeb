-- SISTEMA : CONTROL DE MULTIFUNCIONALES
-- BASE DE DATOS : MySQL
-- AUTOR : JENRY PARIONA

CREATE DATABASE IF NOT EXISTS bd_inventario CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bd_inventario;

-- =======================================================
-- CREACION DE LAS TABLAS MAESTRAS
-- =======================================================

-- TABLA DISTRITO FISCAL
CREATE TABLE IF NOT EXISTS distrito_fiscal (
    id_distrito_fiscal INT AUTO_INCREMENT PRIMARY KEY,
    nombre_distrito VARCHAR(150) NOT NULL
) ENGINE=InnoDB;

-- TIPO DE PERSONAL
CREATE TABLE IF NOT EXISTS tipo_personal (
    id_tipo_personal INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo_personal VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250)
) ENGINE=InnoDB;

-- MARCA
CREATE TABLE IF NOT EXISTS marca (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(150) NOT NULL
) ENGINE=InnoDB;

-- CLASIFICACION
CREATE TABLE IF NOT EXISTS clasificacion (
    id_clasificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre_clasificacion VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250)
) ENGINE=InnoDB;

-- ESTADO EQUIPO
CREATE TABLE IF NOT EXISTS estado_equipo (
    id_estado_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_estado VARCHAR(50) NOT NULL,
    descripcion VARCHAR(250)
) ENGINE=InnoDB;

-- TIPO MANTENIMIENTO
CREATE TABLE IF NOT EXISTS tipo_mantenimiento (
    id_tipo_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(250)
) ENGINE=InnoDB;

-- ROL
CREATE TABLE IF NOT EXISTS rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- USUARIO
CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(150) NOT NULL,
    correo_electronico VARCHAR(150),
    estado VARCHAR(20) DEFAULT 'ACTIVO',
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- =======================================================
-- TABLAS CON UNA DEPENDENCIA
-- =======================================================

-- SEDE
CREATE TABLE IF NOT EXISTS sede (
    id_sede INT AUTO_INCREMENT PRIMARY KEY,
    id_distrito_fiscal INT NOT NULL,
    nombre_sede VARCHAR(150) NOT NULL,
    direccion VARCHAR(300),
    CONSTRAINT fk_sede_distrito
        FOREIGN KEY (id_distrito_fiscal)
        REFERENCES distrito_fiscal(id_distrito_fiscal)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- MODELO
CREATE TABLE IF NOT EXISTS modelo (
    id_modelo INT AUTO_INCREMENT PRIMARY KEY,
    id_marca INT NOT NULL,
    nombre_modelo VARCHAR(150) NOT NULL,
    descripcion VARCHAR(250),
    CONSTRAINT fk_marca_modelo
        FOREIGN KEY (id_marca)
        REFERENCES marca(id_marca)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- PERSONAL
CREATE TABLE IF NOT EXISTS personal (
    id_personal INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_personal INT NOT NULL,
    dni VARCHAR(8) UNIQUE,
    nombres VARCHAR(50),
    apellido_paterno VARCHAR(50),
    apellido_materno VARCHAR(50),
    correo VARCHAR(120),
    telefono VARCHAR(20),
    CONSTRAINT fk_personal_tipo
        FOREIGN KEY (id_tipo_personal)
        REFERENCES tipo_personal(id_tipo_personal)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- =======================================================
-- TABLAS PRINCIPALES
-- =======================================================

-- DESPACHO
CREATE TABLE IF NOT EXISTS despacho (
    id_despacho INT AUTO_INCREMENT PRIMARY KEY,
    id_sede INT NOT NULL,
    nombre_despacho VARCHAR(250) NOT NULL,
    tipo_proceso VARCHAR(100),
    CONSTRAINT fk_id_sede
        FOREIGN KEY (id_sede)
        REFERENCES sede(id_sede)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- EQUIPO
CREATE TABLE IF NOT EXISTS equipo (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    id_modelo INT NOT NULL,
    id_clasificacion INT NOT NULL,
    id_estado_equipo INT NOT NULL,
    codigo_patrimonial VARCHAR(50) NOT NULL UNIQUE,
    numero_serie VARCHAR(100) UNIQUE,
    observacion VARCHAR(500),
    fecha_adquisicion DATE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_equipo_modelo
        FOREIGN KEY (id_modelo)
        REFERENCES modelo(id_modelo)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_equipo_clasificacion
        FOREIGN KEY (id_clasificacion)
        REFERENCES clasificacion(id_clasificacion)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_equipo_estado
        FOREIGN KEY (id_estado_equipo)
        REFERENCES estado_equipo(id_estado_equipo)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- =======================================================
-- TABLAS TRANSACCIONALES
-- =======================================================

-- ASIGNACION DE EQUIPO
CREATE TABLE IF NOT EXISTS asignacion_equipo (
    id_asignacion INT AUTO_INCREMENT PRIMARY KEY,
    id_equipo INT NOT NULL,
    id_despacho INT NOT NULL,
    id_personal INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    observacion VARCHAR(500),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_asignacion_equipo
        FOREIGN KEY (id_equipo)
        REFERENCES equipo(id_equipo)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_asignacion_despacho
        FOREIGN KEY (id_despacho)
        REFERENCES despacho(id_despacho)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_asignacion_personal
        FOREIGN KEY (id_personal)
        REFERENCES personal(id_personal)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- MANTENIMIENTO
CREATE TABLE IF NOT EXISTS mantenimiento (
    id_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_equipo INT NOT NULL,
    id_tipo_mantenimiento INT NOT NULL,
    fecha_mantenimiento DATE NOT NULL,
    diagnostico TEXT,
    trabajo_realizado TEXT,
    repuesto TEXT,
    responsable_mantenimiento VARCHAR(150),
    observacion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_mantenimiento_equipo
        FOREIGN KEY (id_equipo)
        REFERENCES equipo(id_equipo)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_mantenimiento_tipo
        FOREIGN KEY (id_tipo_mantenimiento)
        REFERENCES tipo_mantenimiento(id_tipo_mantenimiento)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

-- USUARIO ROL (TABLA INTERMEDIA)
CREATE TABLE IF NOT EXISTS usuario_rol (
    id_usuario_rol INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_rol INT NOT NULL,
    CONSTRAINT fk_usuario_rol_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_usuario_rol_rol
        FOREIGN KEY (id_rol)
        REFERENCES rol(id_rol)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT uq_usuario_rol
        UNIQUE (id_usuario, id_rol)
) ENGINE=InnoDB;
