--Nombre de entidades: todo mayuscula, separado por guion bajo (si fuese necesario) : NOMBRETABLA
--Nombre de atributos: todo mayuscula, separado por guion bajo: NOMBRETABLA_ATRIBUTO

-- -----------------------------------------------------
-- Schema TECH_WORLD
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS TECH_WORLD;
USE TECH_WORLD ;

-- -----------------------------------------------------
-- Table PAIS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PAIS (
  PAIS_COD INT NOT NULL AUTO_INCREMENT,
  PAIS_NOMBRE VARCHAR(45) NULL,
  PRIMARY KEY (PAIS_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table BODEGA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS BODEGA (
  BODEGA_COD INT NOT NULL AUTO_INCREMENT,
  BODEGA_NOMBRE VARCHAR(45) NULL,
  BODEGA_DIRECCION VARCHAR(45) NULL,
  BODEGA_TELEFONO VARCHAR(45) NULL,
  BODEGA_PAIS_COD INT NOT NULL,
  PRIMARY KEY (BODEGA_COD),
  CONSTRAINT fk_BODEGA_PAIS
    FOREIGN KEY (BODEGA_PAIS_COD)
    REFERENCES PAIS (PAIS_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table SUCURSAL
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS SUCURSAL (
  SUCURSAL_COD INT NOT NULL AUTO_INCREMENT,
  SUCURSAL_NOMBRE VARCHAR(45) NULL,
  SUCURSAL_DIRECCION VARCHAR(45) NULL,
  SUCURSAL_PAIS_COD INT NOT NULL,
  PRIMARY KEY (SUCURSAL_COD),
  CONSTRAINT fk_SUCURSAL_PAIS
    FOREIGN KEY (SUCURSAL_PAIS_COD)
    REFERENCES PAIS (PAIS_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table CLIENTE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CLIENTE (
  CLIENTE_COD INT NOT NULL AUTO_INCREMENT,
  CLIENTE_NOMBRE VARCHAR(45) NULL,
  CLIENTE_APELLIDO VARCHAR(45) NULL,
  CLIENTE_DPI INT NULL,
  CLIENTE_NICK VARCHAR(45) NULL,
  CLIENTE_PASS VARCHAR(45) NULL,
  CLIENTE_EMAIL VARCHAR(45) NULL,
  PRIMARY KEY (CLIENTE_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PROVEEDOR
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PROVEEDOR (
  PROVEEDOR_COD INT NOT NULL AUTO_INCREMENT,
  PROVEEDOR_NOMBRE VARCHAR(45) NULL,
  PROVEEDOR_TELEFONO INT NULL,
  PROVEEDOR_PAIS_COD INT NOT NULL,
  PRIMARY KEY (PROVEEDOR_COD),
  CONSTRAINT fk_PROVEEDOR_PAIS
    FOREIGN KEY (PROVEEDOR_PAIS_COD)
    REFERENCES PAIS (PAIS_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table CATEGORIA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CATEGORIA (
  CATEGORIA_COD INT NOT NULL AUTO_INCREMENT,
  CATEGORIA_DESCRIPCION VARCHAR(45) NULL,
  PRIMARY KEY (CATEGORIA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table MARCA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS MARCA (
  MARCA_COD INT NOT NULL AUTO_INCREMENT,
  NOMBRE VARCHAR(45) NULL,
  PRIMARY KEY (MARCA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PRODUCTO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PRODUCTO (
  PRODUCTO_COD INT NOT NULL AUTO_INCREMENT,
  PRODUCTO_NOMBRE VARCHAR(45) NULL,
  PRODUCTO_CATEGORIA_COD INT NOT NULL,
  PRODUCTO_MARCA_COD INT NOT NULL,
  PRODUCTO_IMAGEN VARCHAR(45) NULL,
  PRODUCTO_PRECIO FLOAT NULL,
  PRODUCTO_GARANTIA VARCHAR(45) NULL,
  PRIMARY KEY (PRODUCTO_COD),
  CONSTRAINT fk_PRODUCTO_CATEGORIA
    FOREIGN KEY (PRODUCTO_CATEGORIA_COD)
    REFERENCES CATEGORIA (CATEGORIA_COD),
  CONSTRAINT fk_PRODUCTO_MARCA
    FOREIGN KEY (PRODUCTO_MARCA_COD)
    REFERENCES MARCA (MARCA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PRODUCTO_BODEGA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PRODUCTO_BODEGA (
  PRODUCTO_BODEGA INT NOT NULL AUTO_INCREMENT,
  PB_PRODUCTO_COD INT NOT NULL,
  PB_BODEGA_COD INT NOT NULL,
  PB_CANTIDAD INT NULL,
   PRIMARY KEY (PRODUCTO_BODEGA),
  CONSTRAINT fk_PRODUCTO_BODEGA_PRODUCTO
    FOREIGN KEY (PB_PRODUCTO_COD)
    REFERENCES PRODUCTO (PRODUCTO_COD),
  CONSTRAINT fk_PRODUCTO_BODEGA_BODEGA
    FOREIGN KEY (PB_BODEGA_COD)
    REFERENCES BODEGA (BODEGA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table TIPO_EMPLEADO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TIPO_EMPLEADO (
  TIPO_COD INT NOT NULL AUTO_INCREMENT,
  TIPO_DESCRIPCION VARCHAR(45) NULL,
  PRIMARY KEY (TIPO_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table EMPLEADO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS EMPLEADO (
  EMPLEADO_COD INT NOT NULL AUTO_INCREMENT,
  EMPLEADO_SUCURSAL_COD INT NOT NULL,
  EMPLEADO_NOMBRE VARCHAR(45) NULL,
  EMPLEADO_APELLIDO VARCHAR(45) NULL,
  EMPLEADO_SALARIO FLOAT NULL,
  EMPLEADO_TIPO_COD INT NOT NULL,
  PRIMARY KEY (EMPLEADO_COD),
  CONSTRAINT fk_EMPLEADO_TIPO_EMPLEADO
    FOREIGN KEY (EMPLEADO_TIPO_COD)
    REFERENCES TIPO_EMPLEADO (TIPO_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PEDIDO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PEDIDO (
  PEDIDO_COD INT NOT NULL AUTO_INCREMENT,
  PEDIDO_CLIENTE_COD INT NOT NULL,
  PEDIDO_EMPLEADO_COD INT NOT NULL,
  PEDIDO_SUCURSAL_COD INT NOT NULL,
  PEDIDO_FECHACOMPRA DATE NULL,
  PEDIDO_PRECIOTOTAL FLOAT NULL,
  PRIMARY KEY (PEDIDO_COD),
  CONSTRAINT fk_PEDIDO_CLIENTE
    FOREIGN KEY (PEDIDO_CLIENTE_COD)
    REFERENCES CLIENTE (CLIENTE_COD),
  CONSTRAINT fk_PEDIDO_SUCURSAL
    FOREIGN KEY (PEDIDO_SUCURSAL_COD)
    REFERENCES SUCURSAL (SUCURSAL_COD),
  CONSTRAINT fk_PEDIDO_EMPLEADO
    FOREIGN KEY (PEDIDO_EMPLEADO_COD)
    REFERENCES EMPLEADO (EMPLEADO_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DETALLE_PEDIDO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DETALLE_PEDIDO (
  DP_COD INT NOT NULL AUTO_INCREMENT,
  DP_PEDIDO_COD INT NOT NULL,
  DP_PRODUCTO_COD INT NOT NULL,
  DP_CANTIDAD INT NULL,
  DP_GARANTIAINICIO VARCHAR(45) NULL,
  DP_GARANTIAFINAL VARCHAR(45) NULL,
  PRIMARY KEY (DP_COD),
  CONSTRAINT fk_DETALLE_PEDIDO_PEDIDO
    FOREIGN KEY (DP_PEDIDO_COD)
    REFERENCES PEDIDO (PEDIDO_COD),
  CONSTRAINT fk_DETALLE_PEDIDO_PRODUCTO
    FOREIGN KEY (DP_PRODUCTO_COD)
    REFERENCES PRODUCTO (PRODUCTO_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table SUCURSAL_BODEGA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS SUCURSAL_BODEGA (
  SUCURSAL_BODEGA INT NOT NULL AUTO_INCREMENT,
  SB_SUCURSAL_COD INT NOT NULL,
  SB_BODEGA_COD INT NOT NULL,
  SB_PRODUCTO_COD INT NOT NULL,
  SB_CANTIDAD INT NULL,
  PRIMARY KEY (SUCURSAL_BODEGA),
  CONSTRAINT fk_SUCURSAL_has_BODEGA_SUCURSAL
    FOREIGN KEY (SB_SUCURSAL_COD)
    REFERENCES SUCURSAL (SUCURSAL_COD),
  CONSTRAINT fk_SUCURSAL_has_BODEGA_BODEGA
    FOREIGN KEY (SB_BODEGA_COD)
    REFERENCES BODEGA (BODEGA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table FUNCION
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS FUNCION (
  FUNCION_COD INT NOT NULL AUTO_INCREMENT,
  FUNCION_DESCRIPCION VARCHAR(45) NULL,
  PRIMARY KEY (FUNCION_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table USUARIO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USUARIO (
  USUARIO_COD INT NOT NULL AUTO_INCREMENT,
  USUARIO_FUNCION_COD INT NOT NULL,
  USUARIO_NOMBRE VARCHAR(45) NULL,
  USUARIO_APELLIDO VARCHAR(45) NULL,
  USUARIO_NICK VARCHAR(45) NULL,
  USUARIO_PASS VARCHAR(45) NULL,
  PRIMARY KEY (USUARIO_COD),
  CONSTRAINT fk_USUARIO_FUNCION
    FOREIGN KEY (USUARIO_FUNCION_COD)
    REFERENCES FUNCION (FUNCION_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ORDEN_COMPRA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ORDEN_COMPRA (
  OC_COD INT NOT NULL AUTO_INCREMENT,
  OC_EMPLEADO_COD INT NOT NULL,
  OC_PROVEEDOR_COD INT NOT NULL,
  OC_FECHA DATE NULL,
  OC_PRECIOTOTAL FLOAT NULL,
  PRIMARY KEY (OC_COD),
  CONSTRAINT fk_ORDEN_COMPRA_EMPLEADO
    FOREIGN KEY (OC_EMPLEADO_COD)
    REFERENCES EMPLEADO (EMPLEADO_COD),
  CONSTRAINT fk_ORDEN_COMPRA_PROVEEDOR
    FOREIGN KEY (OC_PROVEEDOR_COD)
    REFERENCES PROVEEDOR (PROVEEDOR_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DETALLE_ORDEN
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS DETALLE_ORDEN (
  DO_COD INT NOT NULL AUTO_INCREMENT,
  DO_OC_COD INT NOT NULL,
  DO_PRODUCTO_COD INT NOT NULL,
  DO_CANTIDAD INT NULL,
  DO_PRECIO FLOAT NULL,
  PRIMARY KEY (DO_COD),
  CONSTRAINT fk_DETALLE_ORDEN_ORDEN_COMPRA
    FOREIGN KEY (DO_OC_COD)
    REFERENCES ORDEN_COMPRA (OC_COD),
  CONSTRAINT fk_DETALLE_ORDEN_PRODUCTO
    FOREIGN KEY (DO_PRODUCTO_COD)
    REFERENCES PRODUCTO (PRODUCTO_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PRODUCTO_PROVEEDOR
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS PRODUCTO_PROVEEDOR (
  PP_PRODUCTO_COD INT NOT NULL,
  PP_PROVEEDOR_COD INT NOT NULL,
  CONSTRAINT fk_PRODUCTO_has_PROVEEDOR_PRODUCTO
    FOREIGN KEY (PP_PRODUCTO_COD)
    REFERENCES PRODUCTO (PRODUCTO_COD),
  CONSTRAINT fk_PRODUCTO_has_PROVEEDOR_PROVEEDOR
    FOREIGN KEY (PP_PROVEEDOR_COD)
    REFERENCES PROVEEDOR (PROVEEDOR_COD))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table ORDEN_INGRESO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ORDEN_INGRESO (
  OI_COD INT NOT NULL AUTO_INCREMENT,
  OC_BODEGA_COD INT NOT NULL,
  OI_FECHAINGRESO DATE NULL,
  PRIMARY KEY (OI_COD),
  CONSTRAINT fk_ORDEN_INGRESO_BODEGA
    FOREIGN KEY (OC_BODEGA_COD)
    REFERENCES BODEGA (BODEGA_COD))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DETALLE_INGRESO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DETALLE_INGRESO (
  DI_COD INT NOT NULL AUTO_INCREMENT,
  DI_OI_COD INT NOT NULL,
  DI_PRODUCTO_COD INT NOT NULL,
  DI_CANTIDAD INT NULL,
  DI_VARIACION VARCHAR(45) NULL,
  PRIMARY KEY (DI_COD),
  CONSTRAINT fk_DETALLE_INGRESO_ORDEN_INGRESO
    FOREIGN KEY (DI_OI_COD)
    REFERENCES ORDEN_INGRESO (OI_COD),
  CONSTRAINT fk_DETALLE_INGRESO_PRODUCTO
    FOREIGN KEY (DI_PRODUCTO_COD)
    REFERENCES PRODUCTO (PRODUCTO_COD))
ENGINE = InnoDB;
