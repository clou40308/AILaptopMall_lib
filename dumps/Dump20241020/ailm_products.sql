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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int NOT NULL,
  `photo_url` varchar(300) DEFAULT NULL,
  `category` varchar(10) NOT NULL,
  `maker` varchar(60) NOT NULL,
  `description` varchar(300) NOT NULL DEFAULT '',
  `release_date` date NOT NULL DEFAULT (curdate()),
  `discount` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'LENOVO 聯想ThinkBook 商用AI筆電灰色',33990,45,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMO/l000002_1726123397.jpg','AI筆記型電腦','LENOVO','','2024-07-09',15),(2,'ACER 宏碁Swift 14吋AI輕薄筆電 藍',52900,40,'https://img.pchome.com.tw/cs/items/DHAEIWA900HSBIJ/l000002_1727746328.jpg','AI筆記型電腦','ACER','','2024-07-10',5),(3,'ASUS 華碩Zenbook S 14 OLED 14吋AI輕薄筆電灰色',58900,35,'https://img.pchome.com.tw/cs/items/DHAFSTA900HSBWX/l000004_1726648619.jpg','AI筆記型電腦','ASUS','','2024-07-11',5),(4,'HP 惠普EliteBook 13.3吋 商用AI筆電銀色',56900,30,'https://img.pchome.com.tw/cs/items/DHAG7IA900HJG1D/l000002_1725793523.jpg','AI筆記型電腦','HP','','2024-07-12',0),(5,'HP 惠普ProBook 14吋 商用AI筆電銀色',50900,32,'https://img.pchome.com.tw/cs/items/DHAG7KA900HIB09/l000003_1725776997.jpg','AI筆記型電腦','HP','','2024-07-13',0),(6,'DELL 戴爾Alienware m16 R2 16吋 電競AI筆電黑色',94990,9,'https://img.pchome.com.tw/cs/items/DHAI5JA900HB9ZB/l000003_1726798311.jpg','AI筆記型電腦','DELL','','2024-07-14',5),(7,'DELL 戴爾Latitude 7350 13.3吋 商用AI筆電黑色',69990,8,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC59M/l000003_1724222117.jpg','AI筆記型電腦','DELL','','2024-07-15',5),(8,'DELL 戴爾Latitude 5450 14吋 商用AI筆電灰色',53990,12,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC53X/l000002_1724222084.jpg','AI筆記型電腦','DELL','','2024-07-16',5),(9,'DELL 戴爾Latitude 7450 14吋 商用AI筆電黑色',71990,15,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC5GG/l000003_1726466159.jpg','AI筆記型電腦','DELL','','2024-07-17',5),(10,'DELL 戴爾Precision 3591 15.6吋 商用/繪圖AI筆電灰色',93990,18,'https://img.pchome.com.tw/cs/items/DHAI7RA900HDFV3/l000003_1724221517.jpg','AI筆記型電腦','DELL','','2024-07-18',5),(11,'MSI 微星Summit E13 AI Evo 13.3吋 輕薄AI翻轉筆電黑色',44900,17,'https://img.pchome.com.tw/cs/items/DHAK8RA900HC6RN/l000002_1728035181.jpg','AI筆記型電腦','MSI','','2024-07-19',0),(12,'MSI 微星Prestige 14 AI Studio 14吋 AI商用筆電黑色',49900,16,'https://img.pchome.com.tw/cs/items/DHAKB0A900HC6CP/l000001_1728033108.jpg','AI筆記型電腦','MSI','','2024-07-20',0),(13,'MSI 微星Prestige  AI Evo  輕薄AI筆電黑色',41900,14,'https://img.pchome.com.tw/cs/items/DHAK8AA900H00LU/l000003_1728035712.jpg','AI筆記型電腦','MSI','','2024-07-21',0),(14,'Microsoft 微軟Surface Laptop 第7版 13.8吋 AI觸控筆電',50888,11,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZZ6/l000004_1728032789.jpg','AI筆記型電腦','Microsoft','','2024-07-22',0),(15,'Microsoft 微軟Surface Pro 第11版 13吋 AI觸控筆電',54888,13,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZG8/l000004_1728033147.jpg','AI筆記型電腦','Microsoft','','2024-07-23',0),(16,'ASUS 華碩Zenbook 14 OLED 14吋AI輕薄筆電藍色',45900,10,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SDD/l000003_1727666134.jpg','AI筆記型電腦','ASUS','','2024-07-24',10),(17,'ASUS 華碩Zenbook 14 OLED 14吋AI輕薄筆電銀色',45900,8,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SWZ/l000003_1727071910.jpg','AI筆記型電腦','ASUS','','2024-07-25',10),(18,'ACER PredatorPredator 16吋 AI電競筆電銀色',66900,10,'https://img.pchome.com.tw/cs/items/DHAEGAA900HE4N3/l000001_1727776967.jpg','AI筆記型電腦','ACER','','2024-07-26',20),(19,'ACER 宏碁Swift X 14.5吋 AI繪圖OLED筆電灰色',55900,9,'https://img.pchome.com.tw/cs/items/DHAEHIA900HE4OL/l000004_1726473971.jpg','AI筆記型電腦','ACER','','2024-07-27',10),(20,'ACER 宏碁Swift GO 輕薄AI筆電銀色',48900,25,'https://img.pchome.com.tw/cs/items/DHAEILA900HPFJX/l000003_1724147028.jpg','AI筆記型電腦','ACER','','2024-07-28',30),(21,'LG 樂金gram  輕薄AI筆電',54900,23,'https://img.pchome.com.tw/cs/items/DHAM4JA900HFF57/l000003_1728202737.jpg','AI筆記型電腦','LG','','2024-07-29',10);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-20 14:06:33
