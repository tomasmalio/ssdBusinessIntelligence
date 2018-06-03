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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `idciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreciudad` varchar(100) NOT NULL,
  `idpais` int(11) NOT NULL,
  PRIMARY KEY (`idciudad`),
  KEY `idpais` (`idpais`),
  CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Aachen',80),(2,'Albuquerque',230),(3,'Anchorage',230),(4,'Århus',56),(5,'Barcelona',202),(6,'Barquisimeto',236),(7,'Bérgamo',106),(8,'Berlín',80),(9,'Bern',209),(10,'Boise',230),(11,'Bräcke',210),(12,'Brandenburg',80),(13,'Bruxelles',21),(14,'Buenos Aires',10),(15,'Butte',230),(16,'Campinas',30),(17,'Caracas',236),(18,'Charleroi',21),(19,'Colchester',229),(20,'Cork',104),(21,'Cowes',229),(22,'Cunewalde',80),(23,'Elgin',230),(24,'Eugene',230),(25,'Frankfurt a.M. ',80),(26,'Genève',209),(27,'Graz',14),(28,'Helsinki',71),(29,'I. de Margarita',236),(30,'Kirkland',230),(31,'Köln',80),(32,'København',56),(33,'Lander',230),(34,'Leipzig',80),(35,'Lille',72),(36,'Lisboa',177),(37,'London',229),(38,'Luleå',210),(39,'Lyon',72),(40,'Madrid',202),(41,'Mannheim',80),(42,'Marseille',72),(43,'México D.F.',142),(44,'Montréal',38),(45,'München',80),(46,'Münster',80),(47,'Nantes',72),(48,'Oulu',71),(49,'Portland',230),(50,'Reggio Emilia',106),(51,'Reims',72),(52,'Resende',30),(53,'Río de Janeiro',30),(54,'Salzburg',14),(55,'San Cristóbal',236),(56,'San Francisco',230),(57,'São Paulo',30),(58,'Seattle',230),(59,'Sevilla',202),(60,'Stavern',165),(61,'Strasbourg',72),(62,'Stuttgart',80),(63,'Torino',106),(64,'Toulouse',72),(65,'Tsawassen',38),(66,'Vancouver',38),(67,'Walla Walla',230),(68,'Warszawa',176),(69,'París',72),(70,'Versailles',72),(71,'New Orleans',230),(72,'Ann Arbor',230),(73,'Tokyo',110),(74,'Oviedo',202),(75,'Osaka',110),(76,'Melbourne',13),(77,'Manchester',229),(78,'Göteborg',210),(79,'Frankfurt',80),(80,'Cuxhaven',80),(81,'Ravenna',106),(82,'Sandvika',165),(83,'Londres',229),(84,'Bend',230),(85,'Stockholm',110),(86,'Boston',230),(87,'Singapore',195),(88,'Lyngby',56),(89,'Zaandam',155),(90,'Lappeenranta',71),(91,'Sydney',13),(92,'Salerno',106),(93,'Montceau',72),(94,'Annecy',72),(95,'Ste-Hyacinthe',38);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
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
