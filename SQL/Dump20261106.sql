-- MySQL dump 10.13  Distrib 8.0.46, for macos15 (x86_64)
--
-- Host: 127.0.0.1    Database: Biblioteca
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `Autori`
--

DROP TABLE IF EXISTS `Autori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autori` (
  `idAutore` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `nazionalita` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`idAutore`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autori`
--

LOCK TABLES `Autori` WRITE;
/*!40000 ALTER TABLE `Autori` DISABLE KEYS */;
INSERT INTO `Autori` VALUES (52,'Alessandro','Manzoni',NULL),(53,'James','Joyce',NULL),(54,'George','Orwell',NULL),(55,'Italo','Calvino',NULL),(56,'Elsa','Morante',NULL),(57,'Umberto','Eco',NULL),(58,'Stephen','King',NULL),(59,'Edgar Allan','Poe',NULL),(60,'Mary','Shelley',NULL),(61,'J.R.R.','Tolkien',NULL),(62,'Ursula K.','Le Guin',NULL),(63,'Terry','Pratchett',NULL),(64,'Agatha','Christie',NULL),(65,'Andrea','Camilleri',NULL),(66,'Dan','Brown',NULL),(67,'Neil','Gaiman',NULL),(68,'Italo','Calvino','IT'),(69,'Elsa','Morante','IT'),(70,'Umberto','Eco','IT'),(71,'Stephen','King','US'),(72,'Edgar Allan','Poe','US'),(73,'Mary','Shelley','EN'),(74,'J.R.R.','Tolkien','EN'),(75,'Ursula K.','Le Guin','US'),(76,'Terry','Pratchett','EN'),(77,'Agatha','Christie','EN'),(78,'Andrea','Camilleri','IT'),(79,'Dan','Brown','US'),(80,'Neil','Gaiman','EN');
/*!40000 ALTER TABLE `Autori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Copie`
--

DROP TABLE IF EXISTS `Copie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Copie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fk_isbn` int DEFAULT NULL,
  `num_copie` int NOT NULL,
  `fk_casaeditrice` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_isbn` (`fk_isbn`),
  KEY `Copie_ibfk_2_idx` (`fk_casaeditrice`),
  CONSTRAINT `Copie_ibfk_1` FOREIGN KEY (`fk_isbn`) REFERENCES `Libri` (`isbn`),
  CONSTRAINT `Copie_ibfk_2` FOREIGN KEY (`fk_casaeditrice`) REFERENCES `casa_editrice` (`id_casaeditrice`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Copie`
--

LOCK TABLES `Copie` WRITE;
/*!40000 ALTER TABLE `Copie` DISABLE KEYS */;
INSERT INTO `Copie` VALUES (107,1,5,NULL),(108,1,0,NULL),(109,2,3,NULL),(110,3,100,NULL),(111,5,8,NULL),(112,5,2,NULL),(113,7,4,NULL),(114,8,6,NULL),(115,11,0,NULL),(116,14,3,NULL),(117,17,1,NULL),(118,18,5,NULL),(119,19,7,NULL),(120,20,0,NULL),(121,21,2,NULL);
/*!40000 ALTER TABLE `Copie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Generi`
--

DROP TABLE IF EXISTS `Generi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Generi` (
  `idGenere` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idGenere`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Generi`
--

LOCK TABLES `Generi` WRITE;
/*!40000 ALTER TABLE `Generi` DISABLE KEYS */;
INSERT INTO `Generi` VALUES (52,'romanzo'),(53,'horror'),(54,'fantasy'),(55,'thriller'),(56,'romanzo'),(57,'horror'),(58,'fantasy'),(59,'thriller');
/*!40000 ALTER TABLE `Generi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libri`
--

DROP TABLE IF EXISTS `Libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libri` (
  `isbn` int NOT NULL,
  `titolo` varchar(45) DEFAULT NULL,
  `anno` date DEFAULT NULL,
  `fk_genere` int DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `fk_genere` (`fk_genere`),
  CONSTRAINT `Libri_ibfk_1` FOREIGN KEY (`fk_genere`) REFERENCES `Generi` (`idGenere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libri`
--

LOCK TABLES `Libri` WRITE;
/*!40000 ALTER TABLE `Libri` DISABLE KEYS */;
INSERT INTO `Libri` VALUES (1,'Cinquecento','1998-06-21',54),(2,'Giungla','1994-03-11',55),(3,'Cielo Sbagliato','2000-02-21',56),(4,'Canzone','1988-06-09',57),(5,'I promessi sposi','1827-01-01',54),(6,'Ulisse','1922-02-02',54),(7,'1984','1949-06-08',54),(8,'Il nome della rosa','1980-01-01',54),(9,'Il barone rampante','1957-01-01',54),(10,'La Storia','1974-01-01',54),(11,'Shining','1977-01-28',55),(12,'Il pozzo e il pendolo','1842-01-01',55),(13,'Frankenstein','1818-01-01',55),(14,'Lo Hobbit','1937-09-21',56),(15,'Il mago di Earthsea','1968-01-01',56),(16,'Il colore della magia','1983-11-24',56),(17,'Buona Apocalisse a tutti!','1990-05-01',56),(18,'Assassinio sull\'Orient Express','1934-01-01',57),(19,'La forma dell\'acqua','1994-01-01',57),(20,'Il codice da Vinci','2003-03-18',57),(21,'It','1986-09-15',55);
/*!40000 ALTER TABLE `Libri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libri_Autori`
--

DROP TABLE IF EXISTS `Libri_Autori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libri_Autori` (
  `fk_isbn` int NOT NULL,
  `fk_autore` int NOT NULL,
  KEY `fk_autore` (`fk_autore`),
  KEY `Libri_Autori_ibfk_1` (`fk_isbn`),
  CONSTRAINT `Libri_Autori_ibfk_1` FOREIGN KEY (`fk_isbn`) REFERENCES `Libri` (`isbn`),
  CONSTRAINT `Libri_Autori_ibfk_2` FOREIGN KEY (`fk_autore`) REFERENCES `Autori` (`idAutore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libri_Autori`
--

LOCK TABLES `Libri_Autori` WRITE;
/*!40000 ALTER TABLE `Libri_Autori` DISABLE KEYS */;
INSERT INTO `Libri_Autori` VALUES (2,54),(3,53),(5,52),(6,53),(7,54),(8,57),(9,55),(10,56),(11,58),(21,58),(12,59),(13,60),(14,61),(15,62),(16,63),(17,63),(17,67),(18,64),(19,65),(20,66);
/*!40000 ALTER TABLE `Libri_Autori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casa_editrice`
--

DROP TABLE IF EXISTS `casa_editrice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casa_editrice` (
  `id_casaeditrice` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_casaeditrice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa_editrice`
--

LOCK TABLES `casa_editrice` WRITE;
/*!40000 ALTER TABLE `casa_editrice` DISABLE KEYS */;
/*!40000 ALTER TABLE `casa_editrice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-06 16:17:48
