CREATE DATABASE  IF NOT EXISTS `thuvien` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `thuvien`;
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
  `manv` int DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('NV21','123','NV',21),('NV22','123','NV',22),('ql','123','QL',1),('tt','123','TT',2);
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
  `TrangThai` varchar(20) NOT NULL,
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
INSERT INTO `cuonsach` VALUES (31,'1','','Đang mượn'),(33,'1','','Chưa mượn'),(34,'1','','Chưa mượn'),(35,'1','','Chưa mượn'),(36,'1','','Chưa mượn'),(37,'1','','Chưa mượn'),(38,'1','','Chưa mượn'),(39,'1','','Chưa mượn'),(40,'1','','Chưa mượn'),(41,'4','','Chưa mượn'),(42,'4','','Chưa mượn'),(43,'4','','Chưa mượn'),(44,'4','','Chưa mượn'),(45,'4','','Chưa mượn'),(46,'4','','Chưa mượn'),(47,'4','','Chưa mượn'),(48,'4','','Chưa mượn'),(49,'4','','Chưa mượn'),(50,'4','','Chưa mượn');
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
INSERT INTO `dausach` VALUES ('1','Đắc Nhân Tâm',6,55000),('10','Nhà giả kim ',6,50000),('11','Cà Phê Cùng Tony',3,88000),('12','Người bán hàng vĩ đại nhất thế giới',5,50000),('13','Đừng Bao Giờ Đi Ăn Một Mình',5,50000),('2','Mỗi lần vấp ngã là một lần Trưởng Thành',1,50000),('4','Đời thay đổi khi chúng ta thay đổi',1,80000),('5','Dạy Con Làm Giàu',6,88000),('6','Những Tấm Lòng Cao Cả ',3,88000),('7','Nhà Lãnh Đạo không Chức Danh ',3,88000),('8','Cho tôi xin 1 vé đi tuổi thơ',3,88000),('9','Harry Potter',3,88000);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (2,'Trần Bảo Duy','An Giang','0481048134'),(3,'Nguyễn Hoài An','Hồ Chí Minh','0481048144'),(4,'Nguyễn Thị Thu Thủy','An Giang','04810481444'),(5,'Nguyễn Quỳnh Như','Đăk Lăk','0397436178'),(6,'Nguyễn Thu Hiền','Đăk Lăk','0397436178'),(7,'Trần Văn Thái','Đăk Lăk','0397436178');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `idLog` int NOT NULL AUTO_INCREMENT,
  `maNV` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`idLog`),
  KEY `MaNV_idx` (`maNV`),
  CONSTRAINT `MaNV` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`manv`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'','2021-12-07 16:50:02'),(2,2,'Thêm đầu sách (Mã:10)','2021-12-07 19:58:19'),(3,1,'Thêm nhân viên (Mã:21','2021-12-10 18:09:28'),(4,1,'Xoá nhân viên (Mã:20','2021-12-10 19:08:22'),(5,1,'Thêm nhân viên (Mã:22','2021-12-10 19:09:04'),(6,1,'Sửa thông tin nhân viên (Mã:22','2021-12-10 19:10:06'),(7,2,'Thêm đầu sách (Mã:6)','2021-12-10 19:15:29'),(8,2,'Thêm đầu sách (Mã:7)','2021-12-10 19:15:50'),(9,2,'Thêm đầu sách (Mã:8)','2021-12-10 19:16:28'),(10,2,'Thêm đầu sách (Mã:9)','2021-12-10 19:16:48'),(11,2,'Thêm đầu sách (Mã:11)','2021-12-10 19:17:23'),(12,2,'Thêm đầu sách (Mã:12)','2021-12-10 19:18:01'),(13,2,'Thêm đầu sách (Mã:13)','2021-12-10 19:18:32'),(14,2,'Thêm nhà xuất bản (Mã NXB:null)','2021-12-10 19:19:20');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
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
INSERT INTO `muon` VALUES (1,31,2,'2021-11-03','2021-12-06'),(3,33,2,'2021-11-03','2021-12-06'),(4,31,2,'2021-12-04',NULL);
/*!40000 ALTER TABLE `muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `manv` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diachi` longtext,
  `sdt` varchar(11) DEFAULT NULL,
  `luong` double DEFAULT NULL,
  PRIMARY KEY (`manv`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Lê Văn Cường','Đăk Lăk','0389365835',1000),(2,'Trần Bảo Duy','Đăk Lăk','0397436178',10000),(21,'Lê Dĩ Hân','Đăk Lăk','0398110398',7792429),(22,'Bùi Ngọc Dũng','An Giang','0398110398',7792429);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nxb`
--

LOCK TABLES `nxb` WRITE;
/*!40000 ALTER TABLE `nxb` DISABLE KEYS */;
INSERT INTO `nxb` VALUES (1,'NXB Giáo Dục','Hà Nội','9085345'),(3,'Nhà xuất bản DHQG','Thủ Đức','032592353'),(5,'NXB Giáo Dục 2','Hà Nội','9085345'),(6,'Nhà xuất bản Thời đại','Thôn 5, Xá EaKhal, EaHleo, Đăk Lak','0397436178');
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
INSERT INTO `tacgia` VALUES ('1','Dale Carnegie'),('10','Paulo Coelho'),('11','Tony Buổi sáng'),('12','Og Mandino'),('13',' Keith Ferrazzi'),('2','Liêu Trí Phong'),('4','Andrew Matthews'),('5','Robert Kiyosaki'),('6','Edmondo De Amicis'),('6','tg3'),('7','Robin Sharma'),('7','tg3'),('8',' Nguyễn Nhật Ánh'),('9','J. K. Rowling');
/*!40000 ALTER TABLE `tacgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'thuvien'
--

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
		select cs.macuon,temp.tuasach,tacgia,nxb,cs.trangthai
from (select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb
from dausach ds left join tacgia tg on ds.masach=tg.masach
inner join nxb on ds.manxb=nxb.manxb
group by ds.masach) temp inner join cuonsach cs
on temp.masach=cs.MaSach;
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
/*!50003 DROP PROCEDURE IF EXISTS `Thongke` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Thongke`()
BEGIN
    SELECT * from 
		(Select count(*) SoDauSach from DauSach) a,
        (Select count(*) SoSachDangMuon from CuonSach where trangthai='Đang mượn') b,
		(Select count(*) SoSachChuaMuon from CuonSach where trangthai<>'Đang mượn') g,
        (Select count(*) SoDocGia from docgia) c,
        (Select count(*) SoTacGia from tacgia) d,
        (Select count(*) SoNXB from nxb) e,
        (Select count(*) SoNhanVien from nhanvien) f;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ThongkeMuon` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ThongkeMuon`()
BEGIN
    SELECT * from 
		(Select count(*) SoLanMuon from Muon) a,
        (Select count(*) SoLanTra from Muon where ngaytra) b,
        (select g.tua, max(g.macuon) from (Select count(mamuon) macuon,ds.tuaSach tua from Muon m inner join CuonSach cs
        on m.macuon=cs.macuon inner join DauSach ds
        on cs.masach=ds.masach
        group by ds.masach,ds.tuaSach) g group by g.tua) d;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ThongkeMuonTheoNgay` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ThongkeMuonTheoNgay`(In d1 date, In d2 date)
BEGIN
    SELECT * from 
		(Select count(*) SoLanMuon from Muon where ngaymuon>=d1 and ngaymuon<=d2) a,
        (Select count(*) SoLanTra from Muon where ngaytra and ngaymuon>=d1 and ngaymuon<=d2) b,
        (select g.tua, max(g.macuon) from (Select count(mamuon) macuon,ds.tuaSach tua from Muon m inner join CuonSach cs
        on m.macuon=cs.macuon inner join DauSach ds
        on cs.masach=ds.masach where ngaymuon>=d1 and ngaymuon<=d2
        group by ds.masach,ds.tuaSach ) g group by g.tua) d;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TraCuu` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TraCuu`(In para1 VARCHAR(15),In para2 VARCHAR(50))
BEGIN
        select t.MaSach,t.TuaSach,t.tacgia,t.nxb,(CASE when soluong>0 then soluong else 0 end),t.GiaSach from
		(select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb,ds.GiaSach 
		from dausach ds left join tacgia tg on ds.masach=tg.masach
		inner join nxb on ds.manxb=nxb.manxb where nxb.manxb=para1 and tg.TenTacGia=para2  group by ds.masach ) as t
		left join (select count(*) soluong,ds.MaSach ms from cuonsach cs,dausach ds where cs.MaSach=ds.MaSach group by ds.masach) as t2
		on t.MaSach=t2.ms;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TraCuuTheoNXB` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TraCuuTheoNXB`(In para1 VARCHAR(15))
BEGIN
        select t.MaSach,t.TuaSach,t.tacgia,t.nxb,(CASE when soluong>0 then soluong else 0 end),t.GiaSach from
		(select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb ,ds.GiaSach
		from dausach ds left join tacgia tg on ds.masach=tg.masach
		inner join nxb on ds.manxb=nxb.manxb where nxb.manxb=para1  group by ds.masach ) as t
		left join (select count(*) soluong,ds.MaSach ms from cuonsach cs,dausach ds where cs.MaSach=ds.MaSach group by ds.masach) as t2
		on t.MaSach=t2.ms;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TraCuuTheoTacGia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TraCuuTheoTacGia`(In para1 VARCHAR(55))
BEGIN
        select t.MaSach,t.TuaSach,t.tacgia,t.nxb,(CASE when soluong>0 then soluong else 0 end),t.GiaSach from
		(select ds.masach,ds.tuasach, group_concat(tg.tentacgia separator "-") tacgia,nxb.tennxb nxb ,ds.GiaSach
		from dausach ds left join tacgia tg on ds.masach=tg.masach
		inner join nxb on ds.manxb=nxb.manxb where tg.TenTacGia=para1  group by ds.masach ) as t
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

-- Dump completed on 2021-12-10 19:40:21
