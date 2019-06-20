CREATE DATABASE  IF NOT EXISTS `airftn` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `airftn`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: airftn
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `airline_admin`
--

LOCK TABLES `airline_admin` WRITE;
/*!40000 ALTER TABLE `airline_admin` DISABLE KEYS */;
INSERT INTO `airline_admin` VALUES (_binary '',_binary '\0',_binary '',3),(_binary '',_binary '\0',_binary '',4),(_binary '',_binary '\0',_binary '\0',5),(_binary '',_binary '\0',_binary '',8),(_binary '',_binary '\0',_binary '',9);
/*!40000 ALTER TABLE `airline_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `airline_company`
--

LOCK TABLES `airline_company` WRITE;
/*!40000 ALTER TABLE `airline_company` DISABLE KEYS */;
INSERT INTO `airline_company` VALUES (1,'West Street 2','London',_binary '\0','We love our customers!','AIR COCO',4),(2,'Nikole Tesle 10','Belgrade',_binary '\0','How cool are we? Come and see.','AIR SRB',3),(3,'Gogoljeva 23','Novi Sad',_binary '\0','Don\'t mess with us, fly with us!','SKY EYE',8),(4,'Shi Chang 4t','Tokyo',_binary '\0','Our country made Pokemons, we must be good!','ROCKET FLY',9);
/*!40000 ALTER TABLE `airline_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (1,_binary '\0','Boeing 737 MAX',6,_binary '\0',1),(2,_binary '\0','Boeing 747 800',8,_binary '\0',2),(3,_binary '\0','Airbus A320 200',4,_binary '\0',2),(4,_binary '\0','Airbus A320 300',4,_binary '\0',3),(5,_binary '\0','Airbus A380',10,_binary '\0',1),(6,_binary '\0','Boeing 777 Dreamliner',6,_binary '\0',1),(7,_binary '\0','Airbus A350',4,_binary '\0',4),(8,_binary '\0','Boeing 757',5,_binary '\0',1);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (1,'Podgorica','Montenegro',_binary '\0','Lovely place, lovely country'),(2,'Budapest','Hungary',_binary '\0','Maybe we don\'t have sea, but...'),(3,'Munich','Germany',_binary '\0','Greate city'),(4,'New York','USA',_binary '\0','Big Apple'),(5,'San Francisco','USA',_binary '\0','Golden gate bridge. Enough!'),(6,'Nis','Serbia',_binary '\0','I have no more ideas...'),(7,'Belgrade','Serbia',_binary '\0','Blue city');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `destinations`
--

LOCK TABLES `destinations` WRITE;
/*!40000 ALTER TABLE `destinations` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (_binary '','srbislav_token',2);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pricelist`
--

LOCK TABLES `pricelist` WRITE;
/*!40000 ALTER TABLE `pricelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `pricelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_SYSADMIN'),(2,'ROLE_PASSENGER'),(3,'ROLE_AIRLINE_ADMIN'),(4,'ROLE_AIRLINE_ADMIN'),(5,'ROLE_AIRLINE_ADMIN'),(6,'ROLE_SYSADMIN'),(7,'ROLE_SYSADMIN'),(8,'ROLE_AIRLINE_ADMIN'),(9,'ROLE_AIRLINE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,0,_binary '\0',_binary '\0',0,2,1),(2,1,_binary '\0',_binary '\0',0,2,1),(3,2,_binary '\0',_binary '\0',0,2,1),(4,3,_binary '\0',_binary '\0',0,2,1),(5,4,_binary '\0',_binary '\0',0,2,1),(6,5,_binary '\0',_binary '\0',0,2,1),(7,0,_binary '\0',_binary '\0',1,2,1),(8,1,_binary '\0',_binary '\0',1,2,1),(9,2,_binary '\0',_binary '\0',1,2,1),(10,3,_binary '\0',_binary '\0',1,2,1),(11,4,_binary '\0',_binary '\0',1,2,1),(12,5,_binary '\0',_binary '\0',1,2,1),(13,0,_binary '\0',_binary '\0',2,2,1),(14,1,_binary '\0',_binary '\0',2,2,1),(15,2,_binary '\0',_binary '\0',2,2,1),(16,3,_binary '\0',_binary '\0',2,2,1),(17,4,_binary '\0',_binary '\0',2,2,1),(18,5,_binary '\0',_binary '\0',2,2,1),(19,0,_binary '\0',_binary '\0',3,2,1),(20,1,_binary '\0',_binary '\0',3,2,1),(21,2,_binary '\0',_binary '\0',3,2,1),(22,3,_binary '\0',_binary '\0',3,2,1),(23,4,_binary '\0',_binary '\0',3,2,1),(24,5,_binary '\0',_binary '\0',3,2,1),(25,0,_binary '\0',_binary '\0',4,2,1),(26,1,_binary '\0',_binary '\0',4,2,1),(27,2,_binary '\0',_binary '\0',4,2,1),(28,3,_binary '\0',_binary '\0',4,2,1),(29,4,_binary '\0',_binary '\0',4,2,1),(30,5,_binary '\0',_binary '\0',4,2,1),(31,0,_binary '\0',_binary '\0',5,2,1),(32,1,_binary '\0',_binary '\0',5,2,1),(33,2,_binary '\0',_binary '\0',5,2,1),(34,3,_binary '\0',_binary '\0',5,2,1),(35,4,_binary '\0',_binary '\0',5,2,1),(36,5,_binary '\0',_binary '\0',5,2,1),(37,0,_binary '\0',_binary '\0',0,2,2),(38,1,_binary '\0',_binary '\0',0,2,2),(39,2,_binary '\0',_binary '\0',0,2,2),(40,3,_binary '\0',_binary '\0',0,2,2),(41,4,_binary '\0',_binary '\0',0,2,2),(42,5,_binary '\0',_binary '\0',0,2,2),(43,0,_binary '\0',_binary '\0',1,2,2),(44,1,_binary '\0',_binary '\0',1,2,2),(45,2,_binary '\0',_binary '\0',1,2,2),(46,3,_binary '\0',_binary '\0',1,2,2),(47,4,_binary '\0',_binary '\0',1,2,2),(48,5,_binary '\0',_binary '\0',1,2,2),(49,0,_binary '\0',_binary '\0',2,2,2),(50,1,_binary '\0',_binary '\0',2,2,2),(51,2,_binary '\0',_binary '\0',2,2,2),(52,3,_binary '\0',_binary '\0',2,2,2),(53,4,_binary '\0',_binary '\0',2,2,2),(54,5,_binary '\0',_binary '\0',2,2,2),(55,0,_binary '\0',_binary '\0',3,2,2),(56,1,_binary '\0',_binary '\0',3,2,2),(57,2,_binary '\0',_binary '\0',3,2,2),(58,3,_binary '\0',_binary '\0',3,2,2),(59,4,_binary '\0',_binary '\0',3,2,2),(60,5,_binary '\0',_binary '\0',3,2,2),(61,0,_binary '\0',_binary '\0',4,2,2),(62,1,_binary '\0',_binary '\0',4,2,2),(63,2,_binary '\0',_binary '\0',4,2,2),(64,3,_binary '\0',_binary '\0',4,2,2),(65,4,_binary '\0',_binary '\0',4,2,2),(66,5,_binary '\0',_binary '\0',4,2,2),(67,0,_binary '\0',_binary '\0',5,2,2),(68,1,_binary '\0',_binary '\0',5,2,2),(69,2,_binary '\0',_binary '\0',5,2,2),(70,3,_binary '\0',_binary '\0',5,2,2),(71,4,_binary '\0',_binary '\0',5,2,2),(72,5,_binary '\0',_binary '\0',5,2,2),(73,0,_binary '\0',_binary '\0',6,2,2),(74,1,_binary '\0',_binary '\0',6,2,2),(75,2,_binary '\0',_binary '\0',6,2,2),(76,3,_binary '\0',_binary '\0',6,2,2),(77,4,_binary '\0',_binary '\0',6,2,2),(78,5,_binary '\0',_binary '\0',6,2,2),(79,0,_binary '\0',_binary '\0',7,2,2),(80,1,_binary '\0',_binary '\0',7,2,2),(81,2,_binary '\0',_binary '\0',7,2,2),(82,3,_binary '\0',_binary '\0',7,2,2),(83,4,_binary '\0',_binary '\0',7,2,2),(84,5,_binary '\0',_binary '\0',7,2,2),(85,0,_binary '\0',_binary '\0',0,2,3),(86,1,_binary '\0',_binary '\0',0,2,3),(87,2,_binary '\0',_binary '\0',0,2,3),(88,3,_binary '\0',_binary '\0',0,2,3),(89,4,_binary '\0',_binary '\0',0,2,3),(90,5,_binary '\0',_binary '\0',0,2,3),(91,0,_binary '\0',_binary '\0',1,2,3),(92,1,_binary '\0',_binary '\0',1,2,3),(93,2,_binary '\0',_binary '\0',1,2,3),(94,3,_binary '\0',_binary '\0',1,2,3),(95,4,_binary '\0',_binary '\0',1,2,3),(96,5,_binary '\0',_binary '\0',1,2,3),(97,0,_binary '\0',_binary '\0',2,2,3),(98,1,_binary '\0',_binary '\0',2,2,3),(99,2,_binary '\0',_binary '\0',2,2,3),(100,3,_binary '\0',_binary '\0',2,2,3),(101,4,_binary '\0',_binary '\0',2,2,3),(102,5,_binary '\0',_binary '\0',2,2,3),(103,0,_binary '\0',_binary '\0',3,2,3),(104,1,_binary '\0',_binary '\0',3,2,3),(105,2,_binary '\0',_binary '\0',3,2,3),(106,3,_binary '\0',_binary '\0',3,2,3),(107,4,_binary '\0',_binary '\0',3,2,3),(108,5,_binary '\0',_binary '\0',3,2,3),(109,0,_binary '\0',_binary '\0',0,2,4),(110,1,_binary '\0',_binary '\0',0,2,4),(111,2,_binary '\0',_binary '\0',0,2,4),(112,3,_binary '\0',_binary '\0',0,2,4),(113,4,_binary '\0',_binary '\0',0,2,4),(114,5,_binary '\0',_binary '\0',0,2,4),(115,0,_binary '\0',_binary '\0',1,2,4),(116,1,_binary '\0',_binary '\0',1,2,4),(117,2,_binary '\0',_binary '\0',1,2,4),(118,3,_binary '\0',_binary '\0',1,2,4),(119,4,_binary '\0',_binary '\0',1,2,4),(120,5,_binary '\0',_binary '\0',1,2,4),(121,0,_binary '\0',_binary '\0',2,2,4),(122,1,_binary '\0',_binary '\0',2,2,4),(123,2,_binary '\0',_binary '\0',2,2,4),(124,3,_binary '\0',_binary '\0',2,2,4),(125,4,_binary '\0',_binary '\0',2,2,4),(126,5,_binary '\0',_binary '\0',2,2,4),(127,0,_binary '\0',_binary '\0',3,2,4),(128,1,_binary '\0',_binary '\0',3,2,4),(129,2,_binary '\0',_binary '\0',3,2,4),(130,3,_binary '\0',_binary '\0',3,2,4),(131,4,_binary '\0',_binary '\0',3,2,4),(132,5,_binary '\0',_binary '\0',3,2,4),(133,0,_binary '\0',_binary '\0',0,2,5),(134,1,_binary '\0',_binary '\0',0,2,5),(135,2,_binary '\0',_binary '\0',0,2,5),(136,3,_binary '\0',_binary '\0',0,2,5),(137,4,_binary '\0',_binary '\0',0,2,5),(138,5,_binary '\0',_binary '\0',0,2,5),(139,0,_binary '\0',_binary '\0',1,2,5),(140,1,_binary '\0',_binary '\0',1,2,5),(141,2,_binary '\0',_binary '\0',1,2,5),(142,3,_binary '\0',_binary '\0',1,2,5),(143,4,_binary '\0',_binary '\0',1,2,5),(144,5,_binary '\0',_binary '\0',1,2,5),(145,0,_binary '\0',_binary '\0',2,2,5),(146,1,_binary '\0',_binary '\0',2,2,5),(147,2,_binary '\0',_binary '\0',2,2,5),(148,3,_binary '\0',_binary '\0',2,2,5),(149,4,_binary '\0',_binary '\0',2,2,5),(150,5,_binary '\0',_binary '\0',2,2,5),(151,0,_binary '\0',_binary '\0',3,2,5),(152,1,_binary '\0',_binary '\0',3,2,5),(153,2,_binary '\0',_binary '\0',3,2,5),(154,3,_binary '\0',_binary '\0',3,2,5),(155,4,_binary '\0',_binary '\0',3,2,5),(156,5,_binary '\0',_binary '\0',3,2,5),(157,0,_binary '\0',_binary '\0',4,2,5),(158,1,_binary '\0',_binary '\0',4,2,5),(159,2,_binary '\0',_binary '\0',4,2,5),(160,3,_binary '\0',_binary '\0',4,2,5),(161,4,_binary '\0',_binary '\0',4,2,5),(162,5,_binary '\0',_binary '\0',4,2,5),(163,0,_binary '\0',_binary '\0',5,2,5),(164,1,_binary '\0',_binary '\0',5,2,5),(165,2,_binary '\0',_binary '\0',5,2,5),(166,3,_binary '\0',_binary '\0',5,2,5),(167,4,_binary '\0',_binary '\0',5,2,5),(168,5,_binary '\0',_binary '\0',5,2,5),(169,0,_binary '\0',_binary '\0',6,2,5),(170,1,_binary '\0',_binary '\0',6,2,5),(171,2,_binary '\0',_binary '\0',6,2,5),(172,3,_binary '\0',_binary '\0',6,2,5),(173,4,_binary '\0',_binary '\0',6,2,5),(174,5,_binary '\0',_binary '\0',6,2,5),(175,0,_binary '\0',_binary '\0',7,2,5),(176,1,_binary '\0',_binary '\0',7,2,5),(177,2,_binary '\0',_binary '\0',7,2,5),(178,3,_binary '\0',_binary '\0',7,2,5),(179,4,_binary '\0',_binary '\0',7,2,5),(180,5,_binary '\0',_binary '\0',7,2,5),(181,0,_binary '\0',_binary '\0',8,2,5),(182,1,_binary '\0',_binary '\0',8,2,5),(183,2,_binary '\0',_binary '\0',8,2,5),(184,3,_binary '\0',_binary '\0',8,2,5),(185,4,_binary '\0',_binary '\0',8,2,5),(186,5,_binary '\0',_binary '\0',8,2,5),(187,0,_binary '\0',_binary '\0',9,2,5),(188,1,_binary '\0',_binary '\0',9,2,5),(189,2,_binary '\0',_binary '\0',9,2,5),(190,3,_binary '\0',_binary '\0',9,2,5),(191,4,_binary '\0',_binary '\0',9,2,5),(192,5,_binary '\0',_binary '\0',9,2,5),(193,0,_binary '\0',_binary '\0',0,2,6),(194,1,_binary '\0',_binary '\0',0,2,6),(195,2,_binary '\0',_binary '\0',0,2,6),(196,3,_binary '\0',_binary '\0',0,2,6),(197,4,_binary '\0',_binary '\0',0,2,6),(198,5,_binary '\0',_binary '\0',0,2,6),(199,0,_binary '\0',_binary '\0',1,2,6),(200,1,_binary '\0',_binary '\0',1,2,6),(201,2,_binary '\0',_binary '\0',1,2,6),(202,3,_binary '\0',_binary '\0',1,2,6),(203,4,_binary '\0',_binary '\0',1,2,6),(204,5,_binary '\0',_binary '\0',1,2,6),(205,0,_binary '\0',_binary '\0',2,2,6),(206,1,_binary '\0',_binary '\0',2,2,6),(207,2,_binary '\0',_binary '\0',2,2,6),(208,3,_binary '\0',_binary '\0',2,2,6),(209,4,_binary '\0',_binary '\0',2,2,6),(210,5,_binary '\0',_binary '\0',2,2,6),(211,0,_binary '\0',_binary '\0',3,2,6),(212,1,_binary '\0',_binary '\0',3,2,6),(213,2,_binary '\0',_binary '\0',3,2,6),(214,3,_binary '\0',_binary '\0',3,2,6),(215,4,_binary '\0',_binary '\0',3,2,6),(216,5,_binary '\0',_binary '\0',3,2,6),(217,0,_binary '\0',_binary '\0',4,2,6),(218,1,_binary '\0',_binary '\0',4,2,6),(219,2,_binary '\0',_binary '\0',4,2,6),(220,3,_binary '\0',_binary '\0',4,2,6),(221,4,_binary '\0',_binary '\0',4,2,6),(222,5,_binary '\0',_binary '\0',4,2,6),(223,0,_binary '\0',_binary '\0',5,2,6),(224,1,_binary '\0',_binary '\0',5,2,6),(225,2,_binary '\0',_binary '\0',5,2,6),(226,3,_binary '\0',_binary '\0',5,2,6),(227,4,_binary '\0',_binary '\0',5,2,6),(228,5,_binary '\0',_binary '\0',5,2,6),(229,0,_binary '\0',_binary '\0',0,2,7),(230,1,_binary '\0',_binary '\0',0,2,7),(231,2,_binary '\0',_binary '\0',0,2,7),(232,3,_binary '\0',_binary '\0',0,2,7),(233,4,_binary '\0',_binary '\0',0,2,7),(234,5,_binary '\0',_binary '\0',0,2,7),(235,0,_binary '\0',_binary '\0',1,2,7),(236,1,_binary '\0',_binary '\0',1,2,7),(237,2,_binary '\0',_binary '\0',1,2,7),(238,3,_binary '\0',_binary '\0',1,2,7),(239,4,_binary '\0',_binary '\0',1,2,7),(240,5,_binary '\0',_binary '\0',1,2,7),(241,0,_binary '\0',_binary '\0',2,2,7),(242,1,_binary '\0',_binary '\0',2,2,7),(243,2,_binary '\0',_binary '\0',2,2,7),(244,3,_binary '\0',_binary '\0',2,2,7),(245,4,_binary '\0',_binary '\0',2,2,7),(246,5,_binary '\0',_binary '\0',2,2,7),(247,0,_binary '\0',_binary '\0',3,2,7),(248,1,_binary '\0',_binary '\0',3,2,7),(249,2,_binary '\0',_binary '\0',3,2,7),(250,3,_binary '\0',_binary '\0',3,2,7),(251,4,_binary '\0',_binary '\0',3,2,7),(252,5,_binary '\0',_binary '\0',3,2,7),(253,0,_binary '\0',_binary '\0',0,2,8),(254,1,_binary '\0',_binary '\0',0,2,8),(255,2,_binary '\0',_binary '\0',0,2,8),(256,3,_binary '\0',_binary '\0',0,2,8),(257,4,_binary '\0',_binary '\0',0,2,8),(258,5,_binary '\0',_binary '\0',0,2,8),(259,0,_binary '\0',_binary '\0',1,2,8),(260,1,_binary '\0',_binary '\0',1,2,8),(261,2,_binary '\0',_binary '\0',1,2,8),(262,3,_binary '\0',_binary '\0',1,2,8),(263,4,_binary '\0',_binary '\0',1,2,8),(264,5,_binary '\0',_binary '\0',1,2,8),(265,0,_binary '\0',_binary '\0',2,2,8),(266,1,_binary '\0',_binary '\0',2,2,8),(267,2,_binary '\0',_binary '\0',2,2,8),(268,3,_binary '\0',_binary '\0',2,2,8),(269,4,_binary '\0',_binary '\0',2,2,8),(270,5,_binary '\0',_binary '\0',2,2,8),(271,0,_binary '\0',_binary '\0',3,2,8),(272,1,_binary '\0',_binary '\0',3,2,8),(273,2,_binary '\0',_binary '\0',3,2,8),(274,3,_binary '\0',_binary '\0',3,2,8),(275,4,_binary '\0',_binary '\0',3,2,8),(276,5,_binary '\0',_binary '\0',3,2,8),(277,0,_binary '\0',_binary '\0',4,2,8),(278,1,_binary '\0',_binary '\0',4,2,8),(279,2,_binary '\0',_binary '\0',4,2,8),(280,3,_binary '\0',_binary '\0',4,2,8),(281,4,_binary '\0',_binary '\0',4,2,8),(282,5,_binary '\0',_binary '\0',4,2,8);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sys_admin`
--

LOCK TABLES `sys_admin` WRITE;
/*!40000 ALTER TABLE `sys_admin` DISABLE KEYS */;
INSERT INTO `sys_admin` VALUES (_binary '\0',_binary '\0',1),(_binary '',_binary '\0',6),(_binary '',_binary '\0',7);
/*!40000 ALTER TABLE `sys_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transfer_point`
--

LOCK TABLES `transfer_point` WRITE;
/*!40000 ALTER TABLE `transfer_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,_binary '\0',NULL,'sys_admin@email.com','System','Admin',NULL,'$2a$10$ahoSasTG/Vw51.VthhVanOLtm2XsYg7BXG1zzXNMf7e2Ma.8zA7C.',NULL,'admin'),(2,'Novi Sad, Gogoljeva',_binary '\0','1992-09-07 00:00:00','ssrbislav@gmail.com','Srbislav','Stojic','054353SR','$2a$10$qOWScis3oi1HU4bH67p1K.6RGUvAh.gtkESdq/xLehDg/lrWUGEvu','06434251334','srbislav'),(3,NULL,_binary '\0',NULL,'airadmin@email.com','Air','Admin',NULL,'$2a$10$or/cnWTJsvcs5goTcLJmn.m4UvBghQMe75F.FTveSzCEBy3Qgmnzq',NULL,'airadmin'),(4,NULL,_binary '\0',NULL,'aadmin@email.com','Airline','Admin',NULL,'$2a$10$uxM7HFFrs1g3eCV8lC.VBuoD2lWBUJS8K/Lwk8gQD073Sb0qNSOHK',NULL,'aadmin'),(5,NULL,_binary '\0',NULL,'airadmin2@email.com','Air2','Admin2',NULL,'$2a$10$8NRY07ZlEtV.MrHE6zMNmOGDN8GoNaMFoRY6xAbT8iVnMbsGvaQ5.',NULL,'airadmin2'),(6,NULL,_binary '\0',NULL,'sysadmin@email.com','Sys','Admin',NULL,'$2a$10$7rJdaQ22DqHX0ISoHFVfBObsZESmWFGx79SMx1K18zEBpYqv9Hf/W',NULL,'sysadmin@email.com'),(7,NULL,_binary '\0',NULL,'systemadmin@email.com','System','Admin',NULL,'$2a$10$97p41UAxYE.RxeX/sz/CheqEmdj1yjSy13adqJ/xX5wXDZ920BYhu',NULL,'systemadmin'),(8,NULL,_binary '\0',NULL,'admn@email.com','Admn','AdminJ',NULL,'$2a$10$ZOtW3pl1EPMwNfu5ypH4EeKHBiOcg87AYV4SkzDBIAdk.zR5abVOy',NULL,'admn'),(9,NULL,_binary '\0',NULL,'aa@email.com','AA','ADA',NULL,'$2a$10$oVTIHCgYrFeHxNDiTsY1geDzWbnjykM0Ccm7Rjn.WVYKY5Gw5rS2.',NULL,'aa');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-20  3:12:14
