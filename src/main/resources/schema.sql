CREATE TABLE cliente(
	id int NOT NULL PRIMARY KEY auto_increment,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	dni varchar(9) NOT NULL,
	correo_electronico varchar(50) NOT NULL,
	contrasenia varchar(50) NOT NULL,
    estado int NOT NULL
);

CREATE TABLE banco(
	id int NOT NULL PRIMARY KEY auto_increment,
	nombre varchar(100) NOT NULL,
	direccion varchar(200) NOT NULL,
	ciudad varchar(50) NOT NULL,
	pais varchar(50) NOT NULL,
	telefono varchar(20) NOT NULL,
	sitio_web varchar(100) NULL,
	fecha_creacion date NULL
);

CREATE TABLE moneda (
	id int NOT NULL PRIMARY KEY auto_increment,
    nombre_moneda varchar(50) NOT NULL,
    simbolo varchar(5) NOT NULL,
    tipo_cambio decimal(10) NOT NULL
);

CREATE TABLE cronograma_pago (
	id int NOT NULL PRIMARY KEY auto_increment,
    moneda_id int NOT NULL PRIMARY KEY,
    saldo_capital decimal(10) NOT NULL,
    amortizacion decimal(10) NOT NULL,
    interes decimal(10) NOT NULL,
    seguro_desgravamen decimal(10) NOT NULL,
    seguro_inmueble decimal(10) NOT NULL,
    portes decimal(10) NOT NULL,
    cuota decimal(10) NOT NULL,
    estado int NOT NULL
);

CREATE TABLE oferta_inmobiliaria (
	id int NOT NULL PRIMARY KEY auto_increment,
    cliente_id int NOT NULL PRIMARY KEY,
    moneda_id int NOT NULL PRIMARY KEY,
    direccion varchar(500) NOT NULL,
    valor_inmueble float NOT NULL,
    van float NOT NULL,
    tir float NOT NULL
);

CREATE TABLE prestamo (
	id int NOT NULL PRIMARY KEY auto_increment,
    cliente_id int NOT NULL PRIMARY KEY,
    oferta_inmobiliria int NOT NULL,
    moneda_id int NOT NULL,
    tipo_tasa_interes_id_tipo_tasa int NOT NULL,
    cronograma_pago_id int NOT NULL,
    importe_desembolsado float NOT NULL,
    dia_pago date NOT NULL,
    fecha_desembolso date NOT NULL,
    plazo_en_meses int NOT NULL,
    periodo_gracia int NOT NULL,
    periodo_pago int NOT NULL,
    tasa_seguro_inmueble float NOT NULL,
    tasa_seguro_inmueble float NOT NULL,
    portes decimal(10) NOT NULL,
    cuota decimal(10) NOT NULL
);

CREATE TABLE PrestamoCliente (
	prestamo_id INT NOT NULL PRIMARY KEY auto_increment,
    cliente_id INT NOT NULL PRIMARY KEY
);

CREATE TABLE PrestamoCronogramaPago (
	prestamo_id int NOT NULL PRIMARY KEY auto_increment,
    cronograma_pago_id int NOT NULL PRIMARY KEY auto_increment
);

CREATE TABLE PrestamoMoneda (
	prestamo_id int NOT NULL PRIMARY KEY,
    moneda_id int NOT NULL PRIMARY KEY 
);

CREATE TABLE PrestamoOfertaInmobiliaria (
	prestamo_id int NOT NULL PRIMARY KEY,
    oferta_inmobiliaria_id int NOT NULL PRIMARY KEY
);

CREATE TABLE PrestamoTipoInteres (
	prestamo_id int NOT NULL PRIMARY KEY,
    tipo_tasa_interes_id_tipo_tasa int NOT NULL PRIMARY KEY
);

CREATE TABLE tipo_tasa_interes (
	id_tipo_tasa int NOT NULL PRIMARY KEY auto_increment,
    nombre_tipo_tasa varchar(50) NOT NULL,
    valor_tipo_tasa float NOT NULL
);
