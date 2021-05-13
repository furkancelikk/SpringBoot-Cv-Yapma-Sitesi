-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: db_cv
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `average` double NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `graduation_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `userid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb1db4renw5e479gvx88eq4mbn` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,3.46,'Bilgisayar Mühendisliği','Mühendislik Fakültesi','3','2022-06-10','2018-09-04','Düzce Üniversitesi',2),(2,3.45,'Elektrik Mühendisliği','Mühendislik Fakültesi','3','2016-06-15','2012-09-16','İstanbul Üniversitesi',3),(3,3.21,'Bilgisayar Mühendisliği','Mühendislik Fakültesi','3','2021-06-14','2017-09-16','Marmara Üniversitesi',3),(4,3.12,'Bilgisayar Mühendisliği','Mühendislik Fakültesi','3','2022-06-10','2018-09-04','Düzce Üniversitesi',4),(5,3.45,'Japon Dili ve Edebiyatı','Dil ve Tarih-Coğrafya Fakültesi','Mezun','2017-06-12','2013-09-16','Ankara Üniversitesi',4),(6,3.14,'Fizik','Fen Edebiyat Fakültesi','3','2020-06-04','2016-09-15','İTÜ',5),(7,3.45,'İşletme','İşletme Fakültesi','3','2019-06-14','2015-09-17','Boğaziçi Üniversitesi',6);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 19:35:39
