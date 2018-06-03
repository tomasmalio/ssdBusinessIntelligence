-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: ssd
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `apellidos` varchar(20) DEFAULT NULL,
  `nombre` varchar(10) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `tratamiento` varchar(25) DEFAULT NULL,
  `fechaDeNacimiento` datetime DEFAULT NULL,
  `fechaDeContratacion` datetime DEFAULT NULL,
  `dirección` varchar(60) DEFAULT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `codigoPostal` varchar(10) DEFAULT NULL,
  `pais` varchar(15) DEFAULT NULL,
  `telefono` varchar(24) DEFAULT NULL,
  `extension` varchar(4) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `notas` text,
  `jefe` int(11) DEFAULT NULL,
  PRIMARY KEY (`idempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Davolio','Nancy','Representante de ventas','Srta.','1968-12-08 00:00:00','1992-05-01 00:00:00','507 - 20th Ave. E.\r\nApt. 2A','Seattle','WA','98122','EE.UU.','(206) 555-9857','5467','EMPID1.BMP','Su formación incluye una licenciatura en Psicología por la Universidad del Estado de Colorado. También escribió \"El arte de la llamada en frío\". Nancy es miembro de Toastmasters International.',2),(2,'Fuller','Andrew','Vicepresidente comercial','Dr.','1952-02-19 00:00:00','1992-08-14 00:00:00','908 W. Capital Way','Tacoma','WA','98401','EE.UU.','(206) 555-9482','3457','EMPID2.BMP','Andrew completó su licenciatura en Comercio y un doctorado en Marketing Internacional de la Universidad de Dallas. Habla con fluidez en francés e italiano y lee el alemán. Ingresó en la empresa como representante de ventas, fue ascendido a gerente de cuentas y después fue nombrado vicepresidente comercial.\r\nAndrew es miembro de la Mesa redonda de administración de Ventas, la Cámara de comercio de Seattle y de la Asociación de importadores de la Cuenca del Pacífico.',NULL),(3,'Leverling','Janet','Representante de ventas','Srta.','1963-08-30 00:00:00','1992-04-01 00:00:00','722 Moss Bay Blvd.','Kirkland','WA','98033','EE.UU.','(206) 555-3412','3355','EMPID3.BMP','Janet es licenciada en Química por la Universidad de Boston. También ha completado un programa de formación en Gestión de minoristas de alimentación. Janet fue contratada como vendedora asociada y fue ascendida a representante de ventas.',2),(4,'Peacock','Margaret','Representante de ventas','Sra.','1958-09-19 00:00:00','1993-05-03 00:00:00','4110 Old Redmond Rd.','Redmond','WA','98052','EE.UU.','(206) 555-8122','5176','EMPID4.BMP','Margaret es licenciada en Literatura inglesa por el Colegio Universitario Concordia, y tiene un máster del Instituto Americano de Artes Culinarias. Estuvo asignada temporalmente a la oficina de Londres antes de regresar a su puesto permanente en Seattle.',2),(5,'Buchanan','Steven','Gerente de ventas','Sr.','1955-03-04 00:00:00','1993-10-17 00:00:00','14 Garrett Hill','Londres',NULL,'SW1 8JR','Reino Unido','(71) 555-4848','3453','EMPID5.BMP','Steven Buchanan se graduó en la Universidad de St. Andrews, Escocia. Tras su ingreso en la empresa dedicó 6 meses a un programa de orientación en la oficina de Seattle y luego volvió a su puesto permanente en Londres, donde fue ascendido a gerente de ventas. Completó con éxito los cursos de Telemarketing y Gestión de ventas internacional. Habla francés.',2),(6,'Suyama','Michael','Representante de ventas','Sr.','1963-07-02 00:00:00','1993-10-17 00:00:00','Coventry House\r\nMiner Rd.','Londres',NULL,'EC2 7JR','Reino Unido','(71) 555-7773','428','EMPID6.BMP','Michael se graduó en la Universidad de Sussex (MA, economía) y la Universidad de California en Los Angeles (MBA, marketing). También ha asistido a cursos de Ventas multiculturales y Administración del tiempo para profesionales de ventas. Habla\r\njaponés y lee y escribe en francés, portugués y español.',5),(7,'King','Robert','Representante de ventas','Sr.','1960-05-29 00:00:00','1994-01-02 00:00:00','Edgeham Hollow\r\nWinchester Way','Londres',NULL,'RG1 9SP','Reino Unido','(71) 555-5598','465','EMPID7.BMP','Robert King colaboró en la organización Peace Corps y viajó extensamente antes de completar su licenciatura en inglés en la Universidad de Michigan, el año en que ingresó en la empresa. Después de completar un curso denominado \"Ventas en Europa\", fue\r\ntransferido a la oficina de Londres.',5),(8,'Callahan','Laura','Coordinador ventas interno','Srta.','1958-01-09 00:00:00','1994-03-05 00:00:00','4726 - 11th Ave. N.E.','Seattle','WA','98105','EE.UU.','(206) 555-1189','2344','EMPID8.BMP','Laura se graduó en Psicología por la Universidad de Washington. También completó un curso de francés de negocios. Lee y escribe en francés.',2),(9,'Dodsworth','Anne','Representante de ventas','Srta.','1969-07-02 00:00:00','1994-11-15 00:00:00','7 Houndstooth Rd.','Londres',NULL,'WG2 7LT','Reino Unido','(71) 555-4444','452','EMPID9.BMP','Anne tiene una licenciatura en inglés por el  St. Lawrence College.  Habla con fluidez el francés y el alemán.',5);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-03 17:57:21
