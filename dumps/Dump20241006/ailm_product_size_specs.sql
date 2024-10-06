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
  `spec_name` varchar(40) NOT NULL,
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
INSERT INTO `product_size_specs` VALUES (1,'14','Ultra5',10,29990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMO/000001_1726123396.jpg','Intel® Core™ Ultra5 125H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.38 kg',1),(1,'14','Ultra7',12,33990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJM0/000001_1727063451.jpg','Intel® Core™ Ultra7 155H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.38 kg',2),(1,'16','Ultra5',9,29990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJN1/000001_1725956602.jpg','Intel® Core™ Ultra5 125H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.7 kg',1),(1,'16','Ultra7',14,33990,'https://img.pchome.com.tw/cs/items/DHAD6GA900HHJMX/000001_1725956651.jpg','Intel® Core™ Ultra7 155H/16G可擴充記憶體','512GB SSD/軍規認證MIL-STD-810H','Starting at 1.7 kg',2),(2,'','Ultra5',21,47900,'https://img.pchome.com.tw/cs/items/DHAEIWA900HSBHO/000001_1726213007.jpg','全新Intel Lunar Lake CPU，48 TOPs NPU','29小時超長效電池續航力 全機鋁合金1.26 kg','QHD IR臉部辨識相機+物理性遮罩',1),(2,'','Ultra7',19,52900,'https://img.pchome.com.tw/cs/items/DHAEIWA900HSBIJ/000001_1727746327.jpg','全新一代 Intel Lunar Lake CPU，48 TOPs NPU','可180度攤平, 內建AI Copilot+ PC','17.5小時超長效電池續航力，QHD IR臉部辨識相機+物理性遮罩',2),(3,'','Ultra5',17,53900,'https://img.pchome.com.tw/cs/items/DHAFSTA900HSBWC/000001_1725533926.jpg','14吋 3K (2880 x 1800) OLED 16:10 aspect ratio , 120Hz','Intel® Core™Ultra 5 Processor 226V 16GB 1.6 GHz','16GB LPDDR5X on board',1),(3,'','Ultra7',18,58900,'https://img.pchome.com.tw/cs/items/DHAFSTA900HSBWX/000001_1725533999.jpg','14吋 3K (2880 x 1800) OLED 16:10 aspect ratio , 120Hz','Intel® Core™Ultra 7 Processor 258V 32GB 1.8 GHz','32GB LPDDR5X on board',2),(4,'','Ultra5',20,47500,'https://img.pchome.com.tw/cs/items/DHAG7IA900HJ4SR/000001_1717322910.png','Core Ultra 5-125U // 16GB // 1TB SSD // 13.3吋WUXGA (1920 x 1200)','16:10黃金比例螢幕 //人臉辨識 // 更大容量長壽命電池','專業商務 // 19項軍規認證 // 3年全機保固(含電池)',1),(4,'','Ultra7',10,56900,'https://img.pchome.com.tw/cs/items/DHAG7IA900HJG1D/000001_1717570985.png','Core Ultra 7-155U // 32GB // 1TB SSD // 13.3吋WUXGA (1920 x 1200)','16:10黃金比例螢幕 //人臉辨識 // 更大容量長壽命電池','專業商務 // 19項軍規認證 // 3年全機保固(含電池)',2),(5,'','Ultra5',12,43900,'https://img.pchome.com.tw/cs/items/DHAG7KA900HIAT0/000001_1716540065.png','Core Ultra 5-125H // 16GB // 512G SSD // 14吋WUXGA (1920 x 1200)','16:10黃金比例螢幕 // 更大容量長壽命電池','專業商務 // 19項軍規認證 // 3年全機保固(含電池)',1),(5,'','Ultra7',20,50900,'https://img.pchome.com.tw/cs/items/DHAG7KA900HIB09/000001_1716541266.png','Core Ultra 7-155H // 16GB // 1TB SSD // 14吋WUXGA (1920 x 1200)','16:10黃金比例螢幕 // 低藍光 // 人臉辨識','專業商務 // 19項軍規認證 // 3年全機保固(含電池)',2),(6,'','Ultra7',5,74990,'https://img.pchome.com.tw/cs/items/DHAI5JA900HB9OQ/000001_1710503564.jpg','Intel® Core™ Ultra 7 processor 155H','NVIDIA® GeForce RTX™ 4060 8GB GDDR6 獨顯','QHD+電競級螢幕240Hz 刷新率',1),(6,'','Ultra9',4,94990,'https://img.pchome.com.tw/cs/items/DHAI5JA900HB9ZB/000001_1710510529.jpg','Intel® Core™ Ultra 9 processor 185H','NVIDIA® GeForce RTX™ 4070 8GB GDDR6 獨顯','QHD+電競級螢幕240Hz 刷新率',2),(7,'','Ultra5',3,63990,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC56N/000001_1717065048.jpg','Intel Core Ultra 5 135U vPro 處理器','32 GB: LPDDR5x, 6400 MT/s (內建) 記憶體','1TB M.2 2230 TLC PCIe Gen 4 NVMe SSD',1),(7,'','Ultra7',5,69990,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC59M/000001_1717065161.jpg','Intel Core Ultra 7 165U vPro 處理器','32 GB: LPDDR5x, 6400 MT/s (內建) 記憶體','1TB M.2 2230 TLC PCIe Gen 4 NVMe SSD',2),(8,'','Ultra5',7,47990,'https://img.pchome.com.tw/cs/items/DHAIA3A900HRKTY/000001_1724833785.jpg','Intel Core Ultra 5 135U vPro 處理器','1 x 16 GB, DDR5, 5600 MT/s 記憶體','512GB M.2 2230 TLC Gen 4 PCIe NVMe SSD',1),(8,'','Ultra7',5,53990,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC53X/000001_1717064950.jpg','Intel Core Ultra 7 165U vPro 處理器','1 x 16 GB, DDR5, 5600 MT/s 記憶體','512GB M.2 2230 TLC Gen 4 PCIe NVMe SSD',2),(9,'','Ultra5',8,65990,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC5AN/000001_1717065135.jpg','Intel Core Ultra 5 135U vPro 處理器','32 GB: LPDDR5x, 6400 MT/s (內建) 記憶體','1TB M.2 2230 TLC PCIe Gen 4 NVMe SSD',1),(9,'','Ultra7',7,71990,'https://img.pchome.com.tw/cs/items/DHAI6OA900HC5GG/000001_1717065078.jpg','Intel Core Ultra 7 165U vPro 處理器','32 GB: LPDDR5x, 6400 MT/s (內建) 記憶體','1TB M.2 2230 TLC PCIe Gen 4 NVMe SSD',2),(10,'','Ultra5',5,67990,'https://img.pchome.com.tw/cs/items/DHAI7RA900HF2X4/000001_1714124416.jpg','Intel Core Ultra 5 135H vPro 企業版 處理器','16 GB(1 x 16 GB) DDR5, 5600 MT/s 記憶體','Nvidia RTX 1000 Ada Generation, 6 GB GDDR6',1),(10,'','Ultra7',5,73990,'https://img.pchome.com.tw/cs/items/DHAI7RA900HDFUL/000001_1714124760.jpg','Intel Core Ultra 7 155H vPro Essentials 處理器','16 GB(1 x 16 GB) DDR5, 5600 MT/s 記憶體','Nvidia RTX 1000 Ada Generation, 6 GB GDDR6',2),(10,'','Ultra9',8,93990,'https://img.pchome.com.tw/cs/items/DHAI7RA900HDFV3/000001_1714124899.jpg','Intel Core Ultra 9 185H vPro 企業版 處理器','16 GB(1 x 16 GB) DDR5, 5600 MT/s 記憶體','Nvidia RTX 2000 Ada Generation, 8 GB GDDR6',3),(11,'','Ultra5',7,38900,'https://img.pchome.com.tw/cs/items/DHAKB11900HW9NY/000001_1728032934.jpg','搭載最新 Intel® Core™ Ultra 5 處理器 125H','搭載Intel® Arc™ 顯示卡','13.3吋 FHD+ (1920x1200) , 觸控面板, 100% sRGB, IPS等級, 支援MSI Pen 2',1),(11,'','Ultra7',10,44900,'https://img.pchome.com.tw/cs/items/DHAK8RA900HC6RN/000001_1725335099.jpg','搭載最新 Intel® Core™ Ultra 7 處理器 155H','搭載Intel® Arc™ 顯示卡','13.3吋 FHD+ (1920x1200) , 觸控面板, 100% sRGB, IPS等級, 支援MSI Pen 2',2),(12,'','Ultra5',6,31900,'https://img.pchome.com.tw/cs/items/DHAKB1A900HP0Y6/000001_1722323278.jpg','Intel® Evo™ Edition 搭載 Intel® Core™ Ultra 5 處理器 125H','搭載 GeForce RTX™ 3050 筆記型電腦 GPU 6GB GDDR6','14 吋 FHD+ (1920x1200), 16:10 黃金比例, 144Hz更新率, IPS等級面板',1),(12,'','Ultra7',10,49900,'https://img.pchome.com.tw/cs/items/DHAKB0A900HC6CP/000001_1725334648.jpg','Intel® Evo™ Edition 搭載 Intel® Core™ Ultra 7 處理器 155H','搭載 GeForce RTX™ 4050 筆記型電腦 GPU 6GB GDDR6','14 吋 2.8K (2880 x 1800), 16:10 黃金比例, 100% DCI-P3, IPS等級面板',2),(13,'13.3','Ultra7',6,41900,'https://img.pchome.com.tw/cs/items/DHAK8AA900H00LU/000001_1725335385.jpg','Intel® Evo™ 搭載Intel® Core™ Ultra 7 處理器155H','13.3吋 2.8K (2880 x 1800), 16:10, 100% DCI-P3色域範圍, OLED面板','Thunderbolt™ 4多工連接性能',1),(13,'14','Ultra5',8,28500,'https://img.pchome.com.tw/cs/items/DHAK8AA900HC652/000001_1725331437.jpg','Intel® Evo™ Edition 搭載 Intel® Core™ Ultra 5 處理器 125H','搭載 Intel® Arc™ 顯示卡','14 吋 FHD+ (1920 x 1200), 144 Hz更新率, 100% sRGB, IPS等級面板',2),(14,'','Snapdragon X Elite X1E 80 100',7,50888,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZZ6/000001_1718178500.jpg','亮眼的觸控螢幕 HDR 顯示器','極致的打字舒適度','AI 支援的 Surface Studio 相機',2),(14,'','Snapdragon X Plus X1P 64 100',4,43888,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZZU/000001_1718178187.jpg','亮眼的觸控螢幕 HDR 顯示器','極致的打字舒適度','AI 支援的 Surface Studio 相機',1),(15,'','Snapdragon X Elite X1E 80 100',6,54888,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZM6/000001_1718179018.jpg','此為單機賣場，不含鍵盤+筆','全天候的電池使用時間，呈現任何角度的彈性','領先業界的 AI',2),(15,'','Snapdragon X Plus X1P 64 100',7,43888,'https://img.pchome.com.tw/cs/items/DHAY6SA900HJZJM/000001_1718691777.jpg','此為單機賣場，不含鍵盤+筆','全天候的電池使用時間，呈現任何角度的彈性','領先業界的 AI',1),(16,'','Ultra5',6,39900,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SRO/000001_1723514367.jpg','Intel® Core™ Ultra 5 Processor 125H 1.2 GHz','16GB LPDDR5X on board','1TB M.2 NVMe™ PCIe® 4.0 SSD',1),(16,'','Ultra7',4,45900,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SDD/000001_1727666133.jpg','Intel® Core™ Ultra 7 Processor 155H 1.4 GHz','32GB LPDDR5X on board','1TB M.2 NVMe™ PCIe® 4.0 SSD',2),(17,'','Ultra5',5,39900,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SWZ/000001_1721721482.jpg','Intel® Core™ Ultra 5 Processor 125H 1.2 GHz','16GB LPDDR5X on board','1TB M.2 NVMe™ PCIe® 4.0 SSD',1),(17,'','Ultra7',3,45900,'https://img.pchome.com.tw/cs/items/DHAFR2A900H2SPA/000001_1724642876.jpg','Intel® Core™ Ultra 7 Processor 155H 1.4 GHz','32GB LPDDR5X on board','1TB M.2 NVMe™ PCIe® 4.0 SSD',2);
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

-- Dump completed on 2024-10-06 18:30:45
