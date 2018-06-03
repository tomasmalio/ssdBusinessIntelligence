CREATE DATABASE ssd;

CREATE TABLE `ssd`.`cliente` (
	`idcliente` VARCHAR(5) NOT NULL,
	`nombrecompania` VARCHAR(150),
    `nombrecontacto` VARCHAR(150),
    `cargocontacto` VARCHAR(100),
    `direccion` VARCHAR(255),
    `ciudad` VARCHAR(255),
    `region` VARCHAR(255),
    `codpostal` VARCHAR(255),
    `pais` VARCHAR(255),
    `telefono` VARCHAR(255),
    `fax` VARCHAR(255),
	PRIMARY KEY (`idcliente`)
);

CREATE TABLE `ssd`.`categoria` (
	`idcategoria` INT NOT NULL,
	`nombrecategoria` VARCHAR(15) NOT NULL,
    `descripcion` TEXT NULL,
	PRIMARY KEY (`idcategoria`)
);

CREATE TABLE `ssd`.`proveedor` (
	`idproveedor` INT(11) NOT NULL,
	`nombrecompania` VARCHAR(40),
    `nombrecontacto` VARCHAR(30),
    `cargocontacto` VARCHAR(30),
    `idpais` INT(11),
    `idciudad` INT(11),
    `direccion` VARCHAR(60),
    `region` VARCHAR(15),
    `codpostal` VARCHAR(10),
    `telefono` VARCHAR(24),
    `fax` VARCHAR(24),
    `paginaprincipal` LONGTEXT,
	PRIMARY KEY (idproveedor),
    FOREIGN KEY (idciudad) REFERENCES ciudad(idciudad),
    FOREIGN KEY (idpais) REFERENCES pais(idpais)
    
);

CREATE TABLE `empleado` (
	`idempleado` INT NOT NULL,
    `apellidos` VARCHAR(20),
    `nombre` VARCHAR(10),
    `cargo` VARCHAR(30),
    `tratamiento` VARCHAR(25),
    `fechaDeNacimiento` DATETIME,
    `fechaDeContratacion` DATETIME,
    `dirección` VARCHAR(60),
    `ciudad` VARCHAR(15),
    `region` VARCHAR(15),
    `codigoPostal` VARCHAR(10),
    `pais` VARCHAR(15),
    `telefono` VARCHAR(24),
    `extension` VARCHAR(4),
    `foto` VARCHAR(255),
    `notas` TEXT,
    `jefe` INT,
    PRIMARY KEY (`idempleado`)
);

CREATE TABLE `formaDeEnvio` (
    `idformaenvio` INT NOT NULL,
	`nombre` VARCHAR(40),
	`telefono` VARCHAR(24),
    PRIMARY KEY (idformaenvio)
);

CREATE TABLE `ssd`.`producto` (
	`idproducto` INT NOT NULL,
	`nombreproducto` VARCHAR(40) NOT NULL,
	`idproveedor` INT NOT NULL,
	`idcategoria` INT NOT NULL,
	`cantidadporunidad` VARCHAR(20) NOT NULL,
    `precioporunidad` DOUBLE NOT NULL,
	PRIMARY KEY (idproducto),
	FOREIGN KEY (idproveedor) REFERENCES proveedor(idproveedor),
    FOREIGN KEY (idcategoria) REFERENCES categoria(idcategoria)
);

CREATE TABLE `ssd`.`factventa` (
	`idpedido` INT(11) NOT NULL,
	`idcliente` VARCHAR(5) NOT NULL,
    `idfechapedido` DATE NOT NULL,
    `idfechaentrega` DATE,
    `idfechaenvio` DATE,
    `idproducto` INT NOT NULL,
    `idempleado` INT NOT NULL,
    `idformaenvio` INT NOT NULL,
    `idciudaddestino` INT(11) NOT NULL,
    `precioUnidad` DOUBLE NOT NULL,
    `cantidad` INTEGER NOT NULL,
    `descuento` DOUBLE,
    `cargo` DOUBLE,
    FOREIGN KEY (idcliente) REFERENCES cliente(idcliente),
    FOREIGN KEY (idproducto) REFERENCES producto(idproducto),
    FOREIGN KEY (idfechapedido) REFERENCES fechas(idfecha),
    FOREIGN KEY (idfechaentrega) REFERENCES fechas(idfecha),
    FOREIGN KEY (idfechaenvio) REFERENCES fechas(idfecha),
    FOREIGN KEY (idempleado) REFERENCES empleado(idempleado),
    FOREIGN KEY (idformaenvio) REFERENCES formaDeEnvio(idformaenvio)
);

CREATE TABLE `ssd`.`factpresupuesto` (
	`idcategoria` INT(11) NOT NULL,
    `idfechapresupuesto` DATE NOT NULL,
    `idpais` INT(11),
    `total` INT NOT NULL,
    FOREIGN KEY (idpais) REFERENCES pais(idpais),
    FOREIGN KEY (idcategoria) REFERENCES categoria(idcategoria),
    FOREIGN KEY (idfechapresupuesto) REFERENCES fechas(idfecha)
);

