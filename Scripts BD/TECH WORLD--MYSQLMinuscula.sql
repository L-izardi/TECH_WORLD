--nombre de entidades: todo mayuscula, separado por guion bajo (si fuese necesario) : nombretabla
--nombre de atributos: todo mayuscula, separado por guion bajo: nombretabla_atributo

-- -----------------------------------------------------
-- schema tech_world
-- -----------------------------------------------------
create database if not exists tech_world;
use tech_world ;

-- -----------------------------------------------------
-- table pais
-- -----------------------------------------------------
create table if not exists pais (
  pais_cod int not null auto_increment,
  pais_nombre varchar(45) null,
  primary key (pais_cod))
engine = innodb;


-- -----------------------------------------------------
-- table bodega
-- -----------------------------------------------------
create table if not exists bodega (
  bodega_cod int not null auto_increment,
  bodega_nombre varchar(45) null,
  bodega_direccion varchar(45) null,
  bodega_telefono varchar(45) null,
  bodega_pais_cod int not null,
  primary key (bodega_cod),
  constraint fk_bodega_pais
    foreign key (bodega_pais_cod)
    references pais (pais_cod))
engine = innodb;


-- -----------------------------------------------------
-- table sucursal
-- -----------------------------------------------------
create table if not exists sucursal (
  sucursal_cod int not null auto_increment,
  sucursal_nombre varchar(45) null,
  sucursal_direccion varchar(45) null,
  sucursal_pais_cod int not null,
  primary key (sucursal_cod),
  constraint fk_sucursal_pais
    foreign key (sucursal_pais_cod)
    references pais (pais_cod))
engine = innodb;


-- -----------------------------------------------------
-- table cliente
-- -----------------------------------------------------
create table if not exists cliente (
  cliente_cod int not null auto_increment,
  cliente_nombre varchar(45) null,
  cliente_apellido varchar(45) null,
  cliente_dpi int null,
  cliente_nick varchar(45) null,
  cliente_pass varchar(45) null,
  cliente_email varchar(45) null,
  primary key (cliente_cod))
engine = innodb;


-- -----------------------------------------------------
-- table proveedor
-- -----------------------------------------------------
create table if not exists proveedor (
  proveedor_cod int not null auto_increment,
  proveedor_nombre varchar(45) null,
  proveedor_telefono int null,
  proveedor_pais_cod int not null,
  primary key (proveedor_cod),
  constraint fk_proveedor_pais
    foreign key (proveedor_pais_cod)
    references pais (pais_cod))
engine = innodb;


-- -----------------------------------------------------
-- table categoria
-- -----------------------------------------------------
create table if not exists categoria (
  categoria_cod int not null auto_increment,
  categoria_descripcion varchar(45) null,
  primary key (categoria_cod))
engine = innodb;


-- -----------------------------------------------------
-- table marca
-- -----------------------------------------------------
create table if not exists marca (
  marca_cod int not null auto_increment,
  nombre varchar(45) null,
  primary key (marca_cod))
engine = innodb;


-- -----------------------------------------------------
-- table producto
-- -----------------------------------------------------
create table if not exists producto (
  producto_cod int not null auto_increment,
  producto_nombre varchar(45) null,
  producto_categoria_cod int not null,
  producto_marca_cod int not null,
  producto_imagen varchar(45) null,
  producto_precio float null,
  producto_garantia varchar(45) null,
  primary key (producto_cod),
  constraint fk_producto_categoria
    foreign key (producto_categoria_cod)
    references categoria (categoria_cod),
  constraint fk_producto_marca
    foreign key (producto_marca_cod)
    references marca (marca_cod))
engine = innodb;


-- -----------------------------------------------------
-- table producto_bodega
-- -----------------------------------------------------
create table if not exists producto_bodega (
  producto_bodega int not null auto_increment,
  pb_producto_cod int not null,
  pb_bodega_cod int not null,
  pb_cantidad int null,
   primary key (producto_bodega),
  constraint fk_producto_bodega_producto
    foreign key (pb_producto_cod)
    references producto (producto_cod),
  constraint fk_producto_bodega_bodega
    foreign key (pb_bodega_cod)
    references bodega (bodega_cod))
engine = innodb;


-- -----------------------------------------------------
-- table tipo_empleado
-- -----------------------------------------------------
create table if not exists tipo_empleado (
  tipo_cod int not null auto_increment,
  tipo_descripcion varchar(45) null,
  primary key (tipo_cod))
engine = innodb;


-- -----------------------------------------------------
-- table empleado
-- -----------------------------------------------------
create table if not exists empleado (
  empleado_cod int not null auto_increment,
  empleado_sucursal_cod int not null,
  empleado_nombre varchar(45) null,
  empleado_apellido varchar(45) null,
  empleado_salario float null,
  empleado_tipo_cod int not null,
  primary key (empleado_cod),
  constraint fk_empleado_tipo_empleado
    foreign key (empleado_tipo_cod)
    references tipo_empleado (tipo_cod))
engine = innodb;


-- -----------------------------------------------------
-- table pedido
-- -----------------------------------------------------
create table if not exists pedido (
  pedido_cod int not null auto_increment,
  pedido_cliente_cod int not null,
  pedido_empleado_cod int not null,
  pedido_sucursal_cod int not null,
  pedido_fechacompra date null,
  pedido_preciototal float null,
  primary key (pedido_cod),
  constraint fk_pedido_cliente
    foreign key (pedido_cliente_cod)
    references cliente (cliente_cod),
  constraint fk_pedido_sucursal
    foreign key (pedido_sucursal_cod)
    references sucursal (sucursal_cod),
  constraint fk_pedido_empleado
    foreign key (pedido_empleado_cod)
    references empleado (empleado_cod))
engine = innodb;


-- -----------------------------------------------------
-- table detalle_pedido
-- -----------------------------------------------------
create table if not exists detalle_pedido (
  dp_cod int not null auto_increment,
  dp_pedido_cod int not null,
  dp_producto_cod int not null,
  dp_cantidad int null,
  dp_garantiainicio varchar(45) null,
  dp_garantiafinal varchar(45) null,
  primary key (dp_cod),
  constraint fk_detalle_pedido_pedido
    foreign key (dp_pedido_cod)
    references pedido (pedido_cod),
  constraint fk_detalle_pedido_producto
    foreign key (dp_producto_cod)
    references producto (producto_cod))
engine = innodb;


-- -----------------------------------------------------
-- table sucursal_bodega
-- -----------------------------------------------------
create table if not exists sucursal_bodega (
  sucursal_bodega int not null auto_increment,
  sb_sucursal_cod int not null,
  sb_bodega_cod int not null,
  sb_producto_cod int not null,
  sb_cantidad int null,
  primary key (sucursal_bodega),
  constraint fk_sucursal_has_bodega_sucursal
    foreign key (sb_sucursal_cod)
    references sucursal (sucursal_cod),
  constraint fk_sucursal_has_bodega_bodega
    foreign key (sb_bodega_cod)
    references bodega (bodega_cod))
engine = innodb;


-- -----------------------------------------------------
-- table funcion
-- -----------------------------------------------------
create table if not exists funcion (
  funcion_cod int not null auto_increment,
  funcion_descripcion varchar(45) null,
  primary key (funcion_cod))
engine = innodb;


-- -----------------------------------------------------
-- table usuario
-- -----------------------------------------------------
create table if not exists usuario (
  usuario_cod int not null auto_increment,
  usuario_funcion_cod int not null,
  usuario_nombre varchar(45) null,
  usuario_apellido varchar(45) null,
  usuario_nick varchar(45) null,
  usuario_pass varchar(45) null,
  primary key (usuario_cod),
  constraint fk_usuario_funcion
    foreign key (usuario_funcion_cod)
    references funcion (funcion_cod))
engine = innodb;


-- -----------------------------------------------------
-- table orden_compra
-- -----------------------------------------------------
create table if not exists orden_compra (
  oc_cod int not null auto_increment,
  oc_empleado_cod int not null,
  oc_proveedor_cod int not null,
  oc_fecha date null,
  oc_preciototal float null,
  primary key (oc_cod),
  constraint fk_orden_compra_empleado
    foreign key (oc_empleado_cod)
    references empleado (empleado_cod),
  constraint fk_orden_compra_proveedor
    foreign key (oc_proveedor_cod)
    references proveedor (proveedor_cod))
engine = innodb;


-- -----------------------------------------------------
-- table detalle_orden
-- -----------------------------------------------------

create table if not exists detalle_orden (
  do_cod int not null auto_increment,
  do_oc_cod int not null,
  do_producto_cod int not null,
  do_cantidad int null,
  do_precio float null,
  primary key (do_cod),
  constraint fk_detalle_orden_orden_compra
    foreign key (do_oc_cod)
    references orden_compra (oc_cod),
  constraint fk_detalle_orden_producto
    foreign key (do_producto_cod)
    references producto (producto_cod))
engine = innodb;


-- -----------------------------------------------------
-- table producto_proveedor
-- -----------------------------------------------------
create table if not exists producto_proveedor (
  pp_producto_cod int not null,
  pp_proveedor_cod int not null,
  constraint fk_producto_has_proveedor_producto
    foreign key (pp_producto_cod)
    references producto (producto_cod),
  constraint fk_producto_has_proveedor_proveedor
    foreign key (pp_proveedor_cod)
    references proveedor (proveedor_cod))
engine = innodb;



-- -----------------------------------------------------
-- table orden_ingreso
-- -----------------------------------------------------
create table if not exists orden_ingreso (
  oi_cod int not null auto_increment,
  oc_bodega_cod int not null,
  oi_fechaingreso date null,
  primary key (oi_cod),
  constraint fk_orden_ingreso_bodega
    foreign key (oc_bodega_cod)
    references bodega (bodega_cod))
engine = innodb;


-- -----------------------------------------------------
-- table detalle_ingreso
-- -----------------------------------------------------
create table if not exists detalle_ingreso (
  di_cod int not null auto_increment,
  di_oi_cod int not null,
  di_producto_cod int not null,
  di_cantidad int null,
  di_variacion varchar(45) null,
  primary key (di_cod),
  constraint fk_detalle_ingreso_orden_ingreso
    foreign key (di_oi_cod)
    references orden_ingreso (oi_cod),
  constraint fk_detalle_ingreso_producto
    foreign key (di_producto_cod)
    references producto (producto_cod))
engine = innodb;
