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
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `nombrecompania` varchar(40) DEFAULT NULL,
  `nombrecontacto` varchar(30) DEFAULT NULL,
  `cargocontacto` varchar(30) DEFAULT NULL,
  `idpais` int(11) DEFAULT NULL,
  `idciudad` int(11) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `codpostal` varchar(10) DEFAULT NULL,
  `telefono` varchar(24) DEFAULT NULL,
  `fax` varchar(24) DEFAULT NULL,
  `paginaprincipal` longtext,
  PRIMARY KEY (`idproveedor`),
  KEY `idciudad` (`idciudad`),
  KEY `idpais` (`idpais`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`idciudad`) REFERENCES `ciudad` (`idciudad`),
  CONSTRAINT `proveedor_ibfk_2` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Exotic Liquids','Charlotte Cooper','Gerente de compras',229,83,'49 Gilbert St.',NULL,'EC1 4SD','(171) 555-2222',NULL,NULL),(2,'New Orleans Cajun Delights','Shelley Burke','Administrador de pedidos',230,71,'P.O. Box 78934','LA','70117','(100) 555-4822',NULL,NULL),(3,'Grandma Kelly\'s Homestead','Regina Murphy','Representante de ventas',230,72,'707 Oxford Rd.','MI','48104','(313) 555-5735','(313) 555-3349',NULL),(4,'Tokyo Traders','Yoshi Nagase','Gerente de marketing',110,73,'9-8 Sekimai\r\nMusashino-shi',NULL,'100','(03) 3555-5011',NULL,NULL),(5,'Cooperativa de Quesos \'Las Cabras\'','Antonio del Valle Saavedra ','Administrador de exportaciones',202,74,'Calle del Rosal 4','Asturias','33007','(98) 598 76 54',NULL,NULL),(6,'Mayumi\'s','Mayumi Ohno','Representante de marketing',110,75,'92 Setsuko\r\nChuo-ku',NULL,'545','(06) 431-7877',NULL,NULL),(7,'Pavlova, Ltd.','Ian Devling','Gerente de marketing',13,76,'74 Rose St.\r\nMoonie Ponds','Victoria','3058','(03) 444-2343','(03) 444-6588',NULL),(8,'Specialty Biscuits, Ltd.','Peter Wilson','Representante de ventas',229,77,'29 King\'s Way',NULL,'M14 GSD','(161) 555-4448',NULL,NULL),(9,'PB Knäckebröd AB','Lars Peterson','Agente de ventas',210,78,'Kaloadagatan 13',NULL,'S-345 67','031-987 65 43','031-987 65 91',NULL),(10,'Refrescos Americanas LTDA','Carlos Diaz','Gerente de marketing',30,57,'Av. das Americanas 12.890',NULL,'5442','(11) 555 4640',NULL,NULL),(11,'Heli Süßwaren GmbH & Co. KG','Petra Winkler','Gerente de ventas',80,8,'Tiergartenstraße 5',NULL,'10785','(010) 9984510',NULL,NULL),(12,'Plutzer Lebensmittelgroßmärkte AG','Martin Bein','Ger. marketing internacional',80,79,'Bogenallee 51',NULL,'60439','(069) 992755',NULL,NULL),(13,'Nord-Ost-Fisch Handelsgesellschaft mbH','Sven Petersen','Coordinador de mercados',80,80,'Frahmredder 112a',NULL,'27478','(04721) 8713','(04721) 8714',NULL),(14,'Formaggi Fortini s.r.l.','Elio Rossi','Representante de ventas',106,81,'Viale Dante, 75',NULL,'48100','(0544) 60323','(0544) 60603',NULL),(15,'Norske Meierier','Beate Vileid','Gerente de marketing',165,82,'Hatlevegen 5',NULL,'1320','(0)2-953010',NULL,NULL),(16,'Bigfoot Breweries','Cheryl Saylor','Repr. de cuentas regional',230,84,'3400 - 8th Avenue\r\nSuite 210','OR','97101','(503) 555-9931',NULL,NULL),(17,'Svensk Sjöföda AB','Michael Björn','Representante de ventas',110,85,'Brovallavägen 231',NULL,'S-123 45','08-123 45 67',NULL,NULL),(18,'Aux joyeux ecclésiastiques','Guylène Nodier','Gerente de ventas',72,69,'203, Rue des Francs-Bourgeois',NULL,'75004','(1) 03.83.00.68','(1) 03.83.00.62',NULL),(19,'New England Seafood Cannery','Robb Merchant','Agente de cuentas al por mayor',230,86,'Order Processing Dept.\r\n2100 Paul Revere Blvd.','MA','02134','(617) 555-3267','(617) 555-3389',NULL),(20,'Leka Trading','Chandra Leka','Propietario',195,87,'471 Serangoon Loop, Suite #402',NULL,'0512','555-8787',NULL,NULL),(21,'Lyngbysild','Niels Petersen','Gerente de ventas',56,88,'Lyngbysild\r\nFiskebakken 10',NULL,'2800','43844108','43844115',NULL),(22,'Zaanse Snoepfabriek','Dirk Luchte','Gerente de contabilidad',155,89,'Verkoop\r\nRijnweg 22',NULL,'9999 ZZ','(12345) 1212','(12345) 1210',NULL),(23,'Karkki Oy','Anne Heikkonen','Gerente de producción',71,90,'Valtakatu 12',NULL,'53120','(953) 10956',NULL,NULL),(24,'G\'day, Mate','Wendy Mackenzie','Representante de ventas',13,91,'170 Prince Edward Parade\r\nHunter\'s Hill','NSW','2042','(02) 555-5914','(02) 555-4873',NULL),(25,'Ma Maison','Jean-Guy Lauzon','Gerente de marketing',38,44,'2960 Rue St. Laurent','Québec','H1J 1C3','(514) 555-9022',NULL,NULL),(26,'Pasta Buttini s.r.l.','Giovanni Giudici','Administrador de pedidos',106,92,'Via dei Gelsomini, 153',NULL,'84100','(089) 6547665','(089) 6547667',NULL),(27,'Escargots Nouveaux','Marie Delamare','Gerente de ventas',72,93,'22, rue H. Voiron',NULL,'71300','85.57.00.07',NULL,NULL),(28,'Gai pâturage','Eliane Noz','Representante de ventas',72,94,'Bat. B\r\n3, rue des Alpes',NULL,'74000','38.76.98.06','38.76.98.58',NULL),(29,'Forêts d\'érables','Chantal Goulet','Gerente de contabilidad',38,95,'148 rue Chasseur','Québec','J2S 7S8','(514) 555-2955','(514) 555-2921',NULL);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-03 17:57:20
