-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemerch
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `verificationid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Pika','Chu','pikachu@mail.com','ilovedisctru',NULL),(2,'Remoraid','Beaulausse','docbeau@mail.com','advandbbestsubj',NULL),(3,'Tessie','Ursa','tehsea@mail.com','59.999isnotequalto60.00',NULL),(4,'Joltean','De Hahaha','diorthanagain@mail.com','mousewithmylefthand',NULL),(5,'Roughy','Crabrawler','crabreado@mail.com','being-ST-dean-is-awesome',NULL),(6,'Kneel Patrat','Del Gallade-o','dg@mail.com','DiPoAkoTerror',NULL),(7,'Fritz','Florges','ff@mail.com','@beE3eE3eE3p',NULL),(8,'Franchespin','Laguna','lagoonie@mail.com','lagoon=laguna???',NULL),(9,'Natu','Lime-Tsieng','natnat@mail.com','FEARME',NULL),(10,'Pathreeze','Lucario','lucaripat@mail.com','#techTopic',NULL),(11,'Koff','Ngingo','koffney@mail.com','MobilesMobile',NULL),(12,'Marill','Peradilla','mp@mail.com','ilooklikepatricknarvasa',NULL),(13,'Ethel','Onix','etheloff@mail.com','sabi_ko_kay_chari...',NULL),(14,'Ralts','Regalado','raltsregi@mail.com','IcUtClAsStOAtTeNdTaLkS',NULL),(15,'Add Word','Togetighe','teeegheh@mail.com','tie,notTIG-HE!',NULL),(16,'Regiroger','Uy','regiuy@mail.com','TALKtome;TALKtoyourself',NULL),(38,'Zed','Macalalad','isiahmacs@gmail.com','$31$16$lpjWhrEadfciWSIj017d-fJEBzL2v3MsFLEpGMtCO6o',NULL),(39,'Michael Ryan','Respicio','michael_respicio@dlsu.edu.ph','$31$16$EZ3ZgDeVwGUc_fHP-86kIFLWgA7jS083dM54yQRNEH0','$31$16$Tv6Dg_D_mq3NKcn0YPnfmQdo9xoP68Ae1h7-VpkLac4');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-07  0:36:02
