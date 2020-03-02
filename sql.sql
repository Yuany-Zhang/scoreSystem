DROP DATABASE IF EXISTS `access`;
CREATE DATABASE `access';
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: access
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `ID` char(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `Password` char(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('Admin','123456'),('S2001','123456'),('S2002','123456'),('S2003','123456'),('S2004','123456'),('S2005','123456'),('S2006','123456'),('S2007','123456'),('S2008','123456'),('S2009','123456'),('S2010','123456'),('T2001','123456'),('T2002','123456'),('T2003','123456'),('T2004','123456'),('T2005','123456'),('T2006','123456'),('T2007','123456');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `StudentID` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `StudentName` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `Chinese` double(10,2) DEFAULT NULL,
  `math` double(10,2) DEFAULT NULL,
  `English` double(10,2) DEFAULT NULL,
  `aggResult` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`StudentID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES ('S2001','艾伦·耶格尔',80.00,76.50,100.00,256),('S2002','三笠·阿克曼',88.00,100.00,67.00,255),('S2003','爱尔敏·亚鲁雷特',90.00,100.00,77.00,267),('S2004','埃尔文·史密斯',88.00,888.00,78.00,1054),('S2005','利威尔·阿克曼',88.00,99.00,77.00,264),('S2006','让·基尔希斯坦',70.00,22.00,66.00,158),('S2007','莎夏·布劳斯',67.00,22.00,56.00,145),('S2008','尤米尔',66.00,53.00,87.00,206),('S2009','赫里斯塔·兰斯',100.00,100.00,87.00,287),('S2010','肯尼·阿克曼',99.00,88.00,78.00,265);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `StudentID` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `StudentName` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `StudentSex` char(2) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `StudentBirthday` date DEFAULT NULL,
  PRIMARY KEY (`StudentID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('S2001','艾伦·耶格尔','男','1999-06-06'),('S2002','三笠·阿克曼','女','1999-07-07'),('S2003','爱尔敏·亚鲁雷特','男','1999-08-08'),('S2004','埃尔文·史密斯','男','1999-09-09'),('S2005','利威尔·阿克曼','男','1999-10-10'),('S2006','让·基尔希斯坦','男','1999-11-11'),('S2007','莎夏·布劳斯','男','1999-12-12'),('S2008','尤米尔','女','2000-05-05'),('S2009','赫里斯塔·兰斯','女','2000-07-07'),('S2010','肯尼·阿克曼','男','2000-08-08');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `TeacherID` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `TeacherName` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `TeacherCourse` char(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `TeacherSex` char(5) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `TeacherBirthday` date DEFAULT NULL,
  PRIMARY KEY (`TeacherID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('T2001','诸葛亮','数学','男','2018-03-03'),('T2002','唐纳德·特朗普','英语','男','2018-04-04'),('T2003','胡歌','语文','男','2018-05-05'),('T2004','tatan','数学','女','2018-06-06'),('T2005','东野圭吾','语文','女','2018-07-07'),('T2006','刘备','英语','女','2018-08-08'),('T2007','阿卡丽','英语','女','1888-08-08');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-26 17:24:49
