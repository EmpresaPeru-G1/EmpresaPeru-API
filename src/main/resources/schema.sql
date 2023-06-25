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