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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombreproducto` varchar(40) NOT NULL,
  `idproveedor` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `cantidadporunidad` varchar(20) NOT NULL,
  `precioporunidad` double NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `idproveedor` (`idproveedor`),
  KEY `idcategoria` (`idcategoria`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Té Dharamsala',1,1,'10 cajas x 20 bolsas',18),(2,'Cerveza tibetana Barley',1,1,'24 - bot. 12 l',19),(3,'Sirope de regaliz',1,2,'12 - bot. 550 ml',10),(4,'Especias Cajun del chef Anton',2,2,'48 - frascos 6 l',22),(5,'Mezcla Gumbo del chef Anton',2,2,'36 cajas',21.35),(6,'Mermelada de grosellas de la abuela',3,2,'12 - frascos 8 l',25),(7,'Peras secas orgánicas del tío Bob',3,7,'12 - paq. 1 kg',30),(8,'Salsa de arándanos Northwoods',3,2,'12 - frascos 12 l',40),(9,'Buey Mishi Kobe',4,6,'18 - paq. 500 g',97),(10,'Pez espada',4,8,'12 - frascos 200 ml',31),(11,'Queso Cabrales',5,4,'paq. 1 kg',21),(12,'Queso Manchego La Pastora',5,4,'10 - paq. 500 g',38),(13,'Algas Konbu',6,8,'caja 2 kg',6),(14,'Cuajada de judías',6,7,'40 - paq. 100 g',23.25),(15,'Salsa de soja baja en sodio',6,2,'24 - bot. 250 ml',15.5),(16,'Postre de merengue Pavlova',7,3,'32 - cajas 500 g',17.45),(17,'Cordero Alice Springs',7,6,'20 - latas 1 kg',39),(18,'Langostinos tigre Carnarvon',7,8,'paq. 16 kg',62.5),(19,'Pastas de té de chocolate',8,3,'10 cajas x 12 piezas',9.2),(20,'Mermelada de Sir Rodney\'s',8,3,'30 cajas regalo',81),(21,'Bollos de Sir Rodney\'s',8,3,'24 paq. x 4 piezas',10),(22,'Pan de centeno crujiente estilo Gustaf\'s',9,5,'24 - paq. 500 g',21),(23,'Pan fino',9,5,'12 - paq. 250 g',9),(24,'Refresco Guaraná Fantástica',10,1,'12 - latas 355 ml',4.5),(25,'Crema de chocolate y nueces NuNuCa',11,3,'20 - vasos  450 g',14),(26,'Ositos de goma Gumbär',11,3,'100 - bolsas 250 g',31.23),(27,'Chocolate Schoggi',11,3,'100 - piezas 100 g',43.9),(28,'Col fermentada Rössle',12,7,'25 - latas 825 g',45.6),(29,'Salchicha Thüringer',12,6,'50 bolsas x 30 salch',123.79),(30,'Arenque blanco del noroeste',13,8,'10 - vasos 200 g',25.89),(31,'Queso gorgonzola Telino',14,4,'12 - paq. 100 g',12.5),(32,'Queso Mascarpone Fabioli',14,4,'24 - paq. 200 g',32),(33,'Queso de cabra',15,4,'500 g',2.5),(34,'Cerveza Sasquatch',16,1,'24 - bot. 12 l',14),(35,'Cerveza negra Steeleye',16,1,'24 - bot. 12 l',18),(36,'Escabeche de arenque',17,8,'24 - frascos 250 g',19),(37,'Salmón ahumado Gravad',17,8,'12 - paq. 500 g',26),(38,'Vino Côte de Blaye',18,1,'12 - bot. 75 cl',263.5),(39,'Licor verde Chartreuse',18,1,'750 cc por bot.',18),(40,'Carne de cangrejo de Boston',19,8,'24 - latas 4 l',18.4),(41,'Crema de almejas estilo Nueva Inglaterra',19,8,'12 - latas 12 l',9.65),(42,'Tallarines de Singapur',20,5,'32 - 1 kg paq.',14),(43,'Café de Malasia',20,1,'16 - latas 500 g',46),(44,'Azúcar negra Malacca',20,2,'20 - bolsas 2 kg',19.45),(45,'Arenque ahumado',21,8,'paq. 1k',9.5),(46,'Arenque salado',21,8,'4 - vasos 450 g',12),(47,'Galletas Zaanse',22,3,'10 - cajas 4 l',9.5),(48,'Chocolate holandés',22,3,'10 paq.',12.75),(49,'Regaliz',23,3,'24 - paq. 50 g',20),(50,'Chocolate blanco',23,3,'12 - barras 100 g',16.25),(51,'Manzanas secas Manjimup',24,7,'50 - paq. 300 g',53),(52,'Cereales para Filo',24,5,'16 - cajas 2 kg',7),(53,'Empanada de carne',24,6,'48 porc.',32.8),(54,'Empanada de cerdo',25,6,'16 tartas',7.45),(55,'Paté chino',25,6,'24 cajas x 2 tartas',24),(56,'Gnocchi de la abuela Alicia',26,5,'24 - paq. 250 g',38),(57,'Raviolis Angelo',26,5,'24 - paq. 250 g',19.5),(58,'Caracoles de Borgoña',27,8,'24 porc.',13.25),(59,'Raclet de queso Courdavault',28,4,'paq. 5 kg',55),(60,'Camembert Pierrot',28,4,'15 - paq. 300 g',34),(61,'Sirope de arce',29,2,'24 - bot. 500 ml',28.5),(62,'Tarta de azúcar',29,3,'48 tartas',49.3),(63,'Sandwich de vegetales',7,2,'15 - frascos 625 g',43.9),(64,'Bollos de pan de Wimmer',12,5,'20 bolsas x 4 porc.',33.25),(65,'Salsa de pimiento picante de Luisiana',2,2,'32 - bot. 8 l',21.05),(66,'Especias picantes de Luisiana',2,2,'24 - frascos 8 l',17),(67,'Cerveza Laughing Lumberjack',16,1,'24 - bot. 12 l',14),(68,'Barras de pan de Escocia',8,3,'10 cajas x 8 porc.',12.5),(69,'Queso Gudbrandsdals',15,4,'paq. 10 kg',36),(70,'Cerveza Outback',7,1,'24 - bot. 355 ml',15),(71,'Crema de queso Fløtemys',15,4,'10 - paq. 500 g',21.5),(72,'Queso Mozzarella Giovanni',14,4,'24 - paq. 200 g',34.8),(73,'Caviar rojo',17,8,'24 - frascos150 g',15),(74,'Queso de soja Longlife',4,7,'paq. 5 kg',10),(75,'Cerveza Klosterbier Rhönbräu',12,1,'24 - bot. 0,5 l',7.75),(76,'Licor Cloudberry',23,1,'500 ml',18),(77,'Salsa verde original Frankfurter',12,2,'12 cajas',13);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
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
