-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: thuvien
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `typeuser` varchar(45) DEFAULT NULL,
  `manv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('duy','123','TT',NULL),('duy2','123','QL',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuonsach`
--

DROP TABLE IF EXISTS `cuonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuonsach` (
  `MaCuon` int NOT NULL AUTO_INCREMENT,
  `MaSach` varchar(10) DEFAULT NULL,
  `ViTri` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaCuon`),
  KEY `cuonsach_ibfk_1` (`MaSach`),
  CONSTRAINT `cuonsach_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `dausach` (`MaSach`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuonsach`
--

LOCK TABLES `cuonsach` WRITE;
/*!40000 ALTER TABLE `cuonsach` DISABLE KEYS */;
INSERT INTO `cuonsach` VALUES (31,'1',''),(33,'1',''),(34,'1',''),(35,'1',''),(36,'1',''),(37,'1',''),(38,'1',''),(39,'1',''),(40,'1',''),(41,'4',''),(42,'4',''),(43,'4',''),(44,'4',''),(45,'4',''),(46,'4',''),(47,'4',''),(48,'4',''),(49,'4',''),(50,'4','');
/*!40000 ALTER TABLE `cuonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dausach`
--

DROP TABLE IF EXISTS `dausach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dausach` (
  `MaSach` varchar(10) NOT NULL,
  `TuaSach` varchar(45) DEFAULT NULL,
  `MaNXB` int NOT NULL,
  `GiaSach` int NOT NULL,
  PRIMARY KEY (`MaSach`),
  KEY `MaNXB_idx` (`MaNXB`) /*!80000 INVISIBLE */,
  CONSTRAINT `MaNXB` FOREIGN KEY (`MaNXB`) REFERENCES `nxb` (`MaNXB`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dausach`
--

LOCK TABLES `dausach` WRITE;
/*!40000 ALTER TABLE `dausach` DISABLE KEYS */;
INSERT INTO `dausach` VALUES ('1','test',1,0),('2','test33',1,50000),('4','test2',1,0),('5','test2',3,0);
/*!40000 ALTER TABLE `dausach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `MaDG` int NOT NULL AUTO_INCREMENT,
  `TenDG` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `SoDT` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`MaDG`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (2,'Trần Bảo Duy','An Giang','0481048134'),(3,'Test 2','An Giang','0481048144'),(4,'Test 3','An Giang','04810481444');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muon`
--

DROP TABLE IF EXISTS `muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muon` (
  `MaMuon` int NOT NULL AUTO_INCREMENT,
  `MaCuon` int NOT NULL,
  `MaDG` int NOT NULL,
  `NgayMuon` date DEFAULT NULL,
  `NgayTra` date DEFAULT NULL,
  PRIMARY KEY (`MaMuon`),
  KEY `MaCuon_idx` (`MaCuon`),
  KEY `MaDG_idx` (`MaDG`),
  CONSTRAINT `MaCuon` FOREIGN KEY (`MaCuon`) REFERENCES `cuonsach` (`MaCuon`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MaDG` FOREIGN KEY (`MaDG`) REFERENCES `docgia` (`MaDG`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muon`
--

LOCK TABLES `muon` WRITE;
/*!40000 ALTER TABLE `muon` DISABLE KEYS */;
INSERT INTO `muon` VALUES (1,31,2,'2021-11-03','2021-11-03'),(3,33,2,'2021-11-03',NULL),(4,31,2,'2021-12-04',NULL);
/*!40000 ALTER TABLE `muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nxb`
--

DROP TABLE IF EXISTS `nxb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nxb` (
  `MaNXB` int NOT NULL AUTO_INCREMENT,
  `TenNXB` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `SoDT` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`MaNXB`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nxb`
--

LOCK TABLES `nxb` WRITE;
/*!40000 ALTER TABLE `nxb` DISABLE KEYS */;
INSERT INTO `nxb` VALUES (1,'NXB Giáo Dục','Hà Nội','9085345'),(3,'Nhà xuất bản DHQG','Thủ Đức','032592353'),(5,'NXB Giáo Dục 2','Hà Nội','9085345');
/*!40000 ALTER TABLE `nxb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tacgia`
--

DROP TABLE IF EXISTS `tacgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tacgia` (
  `MaSach` varchar(10) NOT NULL,
  `TenTacGia` varchar(45) NOT NULL,
  PRIMARY KEY (`MaSach`,`TenTacGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tacgia`
--

LOCK TABLES `tacgia` WRITE;
/*!40000 ALTER TABLE `tacgia` DISABLE KEYS */;
INSERT INTO `tacgia` VALUES ('1','tg1'),('1','tg2'),('2','tg3'),('4','tg1'),('4','tg2'),('5','tg3'),('6','tg3'),('7','tg3');
/*!40000 ALTER TABLE `tacgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'thuvien'
--
/*!50003 DROP PROCEDURE IF EXISTS `GetAllCuonSach` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllCuonSach`()
BEGIN
		select cs.macuon,temp.tuasach,tacgia,nxb,case when temp2.test=1 then "Đang mượn" else "Chưa mượn" end Trangthai
from (select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb
from dausach ds left join tacgia tg on ds.masach=tg.masach
inner join nxb on ds.manxb=nxb.manxb
group by ds.masach) temp inner join cuonsach cs
on temp.masach=cs.MaSach
left join (select 1 as test,muon.MaCuon as macuon from muon where muon.NgayTra is null) temp2
on cs.MaCuon=temp2.macuon;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetAllDauSach` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllDauSach`()
BEGIN
    select t.MaSach,t.TuaSach,t.tacgia,t.nxb,(CASE when soluong>0 then soluong else 0 end),t.giasach from
(select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb,ds.giasach
from dausach ds left join tacgia tg on ds.masach=tg.masach
inner join nxb on ds.manxb=nxb.manxb group by ds.masach) as t
left join (select count(*) soluong,ds.MaSach ms from cuonsach cs,dausach ds where cs.MaSach=ds.MaSach group by ds.masach) as t2
on t.MaSach=t2.ms;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetDauSachFromMaSach` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetDauSachFromMaSach`(in param1 VARCHAR(20))
BEGIN
    select t.MaSach,t.TuaSach,t.tacgia,t.nxb,(CASE when soluong>0 then soluong else 0 end) from
(select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb 
from dausach ds left join tacgia tg on ds.masach=tg.masach
inner join nxb on ds.manxb=nxb.manxb where ds.masach=param1 group by ds.masach ) as t
left join (select count(*) soluong,ds.MaSach ms from cuonsach cs,dausach ds where cs.MaSach=ds.MaSach group by ds.masach) as t2
on t.MaSach=t2.ms;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `XoaNXB` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `XoaNXB`(in para int)
BEGIN
		select XoaSach(masach) from dausach where manxb=para;
		
        delete from NXB where manxb=para;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `XoaSach` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `XoaSach`(in ms VARCHAR(10))
BEGIN
		delete from Muon where Muon.masach=ms;
        delete from CuonSach where CuonSach.masach=ms;
        delete from Tacgia where Tacgia.masach=ms;
        delete from DauSach where dausach.masach=ms;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-02 22:41:18
