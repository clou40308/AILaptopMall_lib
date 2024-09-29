-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: ailm
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `product_size_specs`
--

DROP TABLE IF EXISTS `product_size_specs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_size_specs` (
  `product_id` int NOT NULL,
  `size_name` varchar(25) NOT NULL,
  `spec_name` varchar(25) NOT NULL,
  `stock` int NOT NULL,
  `unit_price` double NOT NULL,
  `photo_url` varchar(300) DEFAULT NULL,
  `description_1` varchar(300) DEFAULT NULL,
  `description_2` varchar(300) DEFAULT NULL,
  `description_3` varchar(300) DEFAULT NULL,
  `ordinal` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`,`size_name`,`spec_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_size_specs`
--

LOCK TABLES `product_size_specs` WRITE;
/*!40000 ALTER TABLE `product_size_specs` DISABLE KEYS */;
INSERT INTO `product_size_specs` VALUES (1,'14','Ultra5',7,29990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMO/000001_1726123396.jpg','Intel® Core™ Ultra5 125H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.38 kg',1),(1,'14','Ultra7',6,33990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJM0/000001_1727063451.jpg','Intel® Core™ Ultra7 155H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.38 kg',2),(1,'16','Ultra5',8,29990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJN1/000001_1725956602.jpg','Intel® Core™ Ultra5 125H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.7 kg',1),(1,'16','Ultra7',9,33990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg','Intel® Core™ Ultra7 155H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.7 kg',2);
/*!40000 ALTER TABLE `product_size_specs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 20:21:49
