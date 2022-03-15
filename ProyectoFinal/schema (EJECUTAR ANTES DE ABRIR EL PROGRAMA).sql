CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `matricula` int NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `apellidos` varchar(256) NOT NULL,
  `genero` varchar(8) NOT NULL,
  `carrera_id` int NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `FK_alumnos_carreras_idx` (`carrera_id`),
  CONSTRAINT `FK_alumnos_carreras` FOREIGN KEY (`carrera_id`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,1930337,'Juan','Perez Perez','masc',1,'2021-12-02','2001-02-25'),(2,2020675,'Juan','Perez Perez','masc',1,'2021-12-02','2001-02-25');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `alumnos_v`
--

DROP TABLE IF EXISTS `alumnos_v`;
/*!50001 DROP VIEW IF EXISTS `alumnos_v`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `alumnos_v` AS SELECT 
 1 AS `id`,
 1 AS `matricula`,
 1 AS `nombre`,
 1 AS `apellidos`,
 1 AS `carrera_id`,
 1 AS `carrera_nombre`,
 1 AS `carrera_activo`,
 1 AS `fecha_ingreso`,
 1 AS `fecha_nacimiento`,
 1 AS `genero`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'Ingeniería en Tecnologías de Información y Comunicaciones',_binary ''),(2,'Ingeniería en Tecnologías de Manofactura',_binary ''),(3,'Ingeniería en Tecnologías de Manofactura',_binary ''),(4,'Ingeniería en Tecnologías de Manofactura',_binary ''),(5,'Ingeniería en Tecnologías de Manofactura',_binary ''),(6,'Ingeniería en Tecnologías de Manofactura',_binary ''),(7,'Ingeniería en Tecnologías de Manofactura',_binary ''),(8,'Ingeniería en Tecnologías de Manofactura',_binary ''),(9,'Ingeniería en Tecnologías de Manofactura',_binary ''),(10,'Ingeniería en Tecnologías de Manofactura',_binary ''),(11,'Ingeniería en Tecnologías de Manofactura',_binary ''),(12,'Ingeniería en Tecnologías de Manofactura',_binary ''),(13,'Ingeniería en Tecnologías de Manofactura',_binary ''),(14,'Ingeniería en Tecnologías de Manofactura',_binary ''),(15,'Ingeniería en Tecnologías de Manofactura',_binary ''),(16,'Ingeniería en Tecnologías de Manofactura',_binary ''),(17,'Ingeniería en Tecnologías de Manofactura',_binary ''),(18,'Ingeniería en Tecnologías de Manofactura',_binary ''),(19,'Ingeniería en Tecnologías de Manofactura',_binary ''),(20,'Ingeniería en Tecnologías de Manofactura',_binary ''),(21,'Ingeniería en Tecnologías de Manofactura',_binary ''),(22,'Ingeniería en Tecnologías de Manofactura',_binary ''),(23,'Ingeniería en Tecnologías de Manofactura',_binary ''),(24,'Ingeniería en Tecnologías de Manofactura',_binary ''),(25,'Ingeniería en Tecnologías de Manofactura',_binary ''),(26,'Ingeniería en Tecnologías de Manofactura',_binary ''),(27,'Ingeniería en Tecnologías de Manofactura',_binary ''),(28,'Ingeniería en Tecnologías de Manofactura',_binary ''),(29,'Ingeniería en Tecnologías de Manofactura',_binary ''),(30,'Ingeniería en Tecnologías de Manofactura',_binary ''),(31,'Ingeniería en Tecnologías de Manofactura',_binary ''),(32,'Ingeniería en Tecnologías de Manofactura',_binary ''),(33,'Ingeniería en Tecnologías de Manofactura',_binary ''),(34,'Ingeniería en Tecnologías de Manofactura',_binary ''),(35,'Ingeniería en Tecnologías de Manofactura',_binary ''),(36,'Ingeniería en Tecnologías de Manofactura',_binary ''),(37,'Ingeniería en Tecnologías de Manofactura',_binary ''),(38,'Ingeniería en Tecnologías de Manofactura',_binary ''),(39,'Ingeniería en Tecnologías de Manofactura',_binary ''),(40,'Ingeniería en Tecnologías de Manofactura',_binary ''),(41,'Ingeniería en Tecnologías de Manofactura',_binary ''),(42,'Ingeniería en Tecnologías de Manofactura',_binary ''),(43,'Ingeniería en Tecnologías de Manofactura',_binary ''),(44,'Ingeniería en Tecnologías de Manofactura',_binary ''),(45,'Ingeniería en Tecnologías de Manofactura',_binary ''),(46,'Ingeniería en Tecnologías de Manofactura',_binary ''),(47,'Ingeniería en Tecnologías de Manofactura',_binary ''),(48,'Ingeniería en Tecnologías de Manofactura',_binary ''),(49,'Ingeniería en Tecnologías de Manofactura',_binary ''),(50,'Ingeniería en Tecnologías de Manofactura',_binary ''),(51,'Ingeniería en Tecnologías de Manofactura',_binary ''),(52,'Ingeniería en Tecnologías de Manofactura',_binary ''),(53,'Ingeniería en Tecnologías de Manofactura',_binary ''),(54,'Ingeniería en Tecnologías de Manofactura',_binary ''),(55,'Ingeniería en Tecnologías de Manofactura',_binary ''),(56,'Ingeniería en Tecnologías de Manofactura',_binary ''),(57,'Ingeniería en Tecnologías de Manofactura',_binary ''),(58,'Ingeniería en Tecnologías de Manofactura',_binary ''),(59,'Ingeniería en Tecnologías de Manofactura',_binary ''),(60,'Ingeniería en Tecnologías de Manofactura',_binary ''),(61,'Ingeniería en Tecnologías de Manofactura',_binary ''),(62,'Ingeniería en Tecnologías de Manofactura',_binary ''),(63,'Ingeniería en Tecnologías de Manofactura',_binary ''),(64,'Ingeniería en Tecnologías de Manofactura',_binary ''),(65,'Ingeniería en Tecnologías de Manofactura',_binary ''),(66,'Ingeniería en Tecnologías de Manofactura',_binary ''),(67,'Ingeniería en Tecnologías de Manofactura',_binary ''),(68,'Ingeniería en Tecnologías de Manofactura',_binary ''),(69,'Ingeniería en Tecnologías de Manofactura',_binary ''),(70,'Ingeniería en Tecnologías de Manofactura',_binary ''),(71,'Ingeniería en Tecnologías de Manofactura',_binary ''),(72,'Ingeniería en Tecnologías de Manofactura',_binary ''),(73,'Ingeniería en Tecnologías de Manofactura',_binary ''),(74,'Ingeniería en Tecnologías de Manofactura',_binary ''),(75,'Ingeniería en Tecnologías de Manofactura',_binary ''),(76,'Ingeniería en Tecnologías de Manofactura',_binary ''),(77,'Ingeniería en Tecnologías de Manofactura',_binary ''),(78,'Ingeniería en Tecnologías de Manofactura',_binary ''),(79,'Ingeniería en Tecnologías de Manofactura',_binary ''),(80,'Ingeniería en Tecnologías de Manofactura',_binary ''),(81,'Ingeniería en Tecnologías de Manofactura',_binary ''),(82,'Ingeniería en Tecnologías de Manofactura',_binary ''),(83,'Ingeniería en Tecnologías de Manofactura',_binary ''),(84,'Ingeniería en Tecnologías de Manofactura',_binary ''),(85,'Ingeniería en Tecnologías de Manofactura',_binary ''),(86,'Ingeniería en Tecnologías de Manofactura',_binary ''),(87,'Ingeniería en Tecnologías de Manofactura',_binary ''),(88,'Ingeniería en Tecnologías de Manofactura',_binary ''),(89,'Ingeniería en Tecnologías de Manofactura',_binary ''),(90,'Ingeniería en Tecnologías de Manofactura',_binary ''),(91,'Ingeniería en Tecnologías de Manofactura',_binary ''),(92,'Ingeniería en Tecnologías de Manofactura',_binary ''),(93,'Ingeniería en Tecnologías de Manofactura',_binary ''),(94,'Ingeniería en Tecnologías de Manofactura',_binary ''),(95,'Ingeniería en Tecnologías de Manofactura',_binary ''),(96,'Ingeniería en Tecnologías de Manofactura',_binary ''),(97,'Ingeniería en Tecnologías de Manofactura',_binary ''),(98,'Ingeniería en Tecnologías de Manofactura',_binary ''),(99,'Ingeniería en Tecnologías de Manofactura',_binary ''),(100,'Ingeniería en Tecnologías de Manofactura',_binary ''),(101,'Ingeniería en Tecnologías de Manofactura',_binary ''),(102,'Ingeniería en Tecnologías de Manofactura',_binary ''),(103,'Ingeniería en Tecnologías de Manofactura',_binary ''),(104,'Ingeniería en Tecnologías de Manofactura',_binary ''),(105,'Ingeniería en Tecnologías de Manofactura',_binary ''),(106,'Ingeniería en Tecnologías de Manofactura',_binary ''),(107,'Ingeniería en Tecnologías de Manofactura',_binary ''),(108,'Ingeniería en Tecnologías de Manofactura',_binary ''),(109,'Ingeniería en Tecnologías de Manofactura',_binary ''),(110,'Ingeniería en Tecnologías de Manofactura',_binary ''),(111,'Ingeniería en Tecnologías de Manofactura',_binary ''),(112,'Ingeniería en Tecnologías de Manofactura',_binary ''),(113,'Ingeniería en Tecnologías de Manofactura',_binary ''),(114,'Ingeniería en Tecnologías de Manofactura',_binary ''),(115,'Ingeniería en Tecnologías de Manofactura',_binary ''),(116,'Ingeniería en Tecnologías de Manofactura',_binary ''),(117,'Ingeniería en Tecnologías de Manofactura',_binary ''),(118,'Ingeniería en Tecnologías de Manofactura',_binary ''),(119,'Ingeniería en Tecnologías de Manofactura',_binary ''),(120,'Ingeniería en Tecnologías de Manofactura',_binary ''),(121,'Ingeniería en Tecnologías de Manofactura',_binary ''),(122,'Ingeniería en Tecnologías de Manofactura',_binary ''),(123,'Ingeniería en Tecnologías de Manofactura',_binary ''),(124,'Ingeniería en Tecnologías de Manofactura',_binary ''),(125,'Ingeniería en Tecnologías de Manofactura',_binary ''),(126,'Ingeniería en Tecnologías de Manofactura',_binary ''),(127,'Ingeniería en Tecnologías de Manofactura',_binary ''),(128,'Ingeniería en Tecnologías de Manofactura',_binary ''),(129,'Ingeniería en Tecnologías de Manofactura',_binary ''),(130,'Ingeniería en Tecnologías de Manofactura',_binary ''),(131,'Ingeniería en Tecnologías de Manofactura',_binary ''),(132,'Ingeniería en Tecnologías de Manofactura',_binary ''),(133,'Ingeniería en Tecnologías de Manofactura',_binary ''),(134,'Ingeniería en Tecnologías de Manofactura',_binary ''),(135,'Ingeniería en Tecnologías de Manofactura',_binary ''),(136,'Ingeniería en Tecnologías de Manofactura',_binary ''),(137,'Ingeniería en Tecnologías de Manofactura',_binary ''),(138,'Ingeniería en Tecnologías de Manofactura',_binary ''),(139,'Ingeniería en Tecnologías de Manofactura',_binary ''),(140,'Ingeniería en Tecnologías de Manofactura',_binary ''),(141,'Ingeniería en Tecnologías de Manofactura',_binary ''),(142,'Ingeniería en Tecnologías de Manofactura',_binary ''),(143,'Ingeniería en Tecnologías de Manofactura',_binary ''),(144,'Ingeniería en Tecnologías de Manofactura',_binary ''),(145,'Ingeniería en Tecnologías de Manofactura',_binary ''),(146,'Ingeniería en Tecnologías de Manofactura',_binary ''),(147,'Ingeniería en Tecnologías de Manofactura',_binary ''),(148,'Ingeniería en Tecnologías de Manofactura',_binary ''),(149,'Ingeniería en Tecnologías de Manofactura',_binary ''),(150,'Ingeniería en Tecnologías de Manofactura',_binary ''),(151,'Ingeniería en Tecnologías de Manofactura',_binary ''),(152,'Ingeniería en Tecnologías de Manofactura',_binary ''),(153,'Ingeniería en Tecnologías de Manofactura',_binary ''),(154,'Ingeniería en Tecnologías de Manofactura',_binary ''),(155,'Ingeniería en Tecnologías de Manofactura',_binary ''),(156,'Ingeniería en Tecnologías de Manofactura',_binary '');
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editoriales`
--

DROP TABLE IF EXISTS `editoriales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editoriales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) NOT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editoriales`
--

LOCK TABLES `editoriales` WRITE;
/*!40000 ALTER TABLE `editoriales` DISABLE KEYS */;
INSERT INTO `editoriales` VALUES (1,'editorial chida','Mexico','echida@gmail.com',_binary '');
/*!40000 ALTER TABLE `editoriales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(512) NOT NULL,
  `tipo_recurso_id` int NOT NULL,
  `stock` int NOT NULL,
  `edicion` varchar(128) DEFAULT NULL,
  `editorial_id` int DEFAULT NULL,
  `autores` varchar(1024) DEFAULT NULL,
  `isbn` varchar(256) DEFAULT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_recursos_recursos1_idx` (`tipo_recurso_id`),
  KEY `FK_recursos_editoriales_idx` (`editorial_id`),
  CONSTRAINT `FK_recursos_editoriales` FOREIGN KEY (`editorial_id`) REFERENCES `editoriales` (`id`),
  CONSTRAINT `FK_recursos_tipos_recursos` FOREIGN KEY (`tipo_recurso_id`) REFERENCES `tipos_recursos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (5,'ciencias naturales',1,2,'4ta Edicion',1,'Benito Juarez','12345',_binary ''),(6,'Historia I',1,2,'5ta Edicion',1,'Lalo Sierra','54321',_binary ''),(7,'Matematicas',1,2,'1ra Edicion',1,'Guillermo Sierra','6789',_binary '');
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros_inventario`
--

DROP TABLE IF EXISTS `libros_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros_inventario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libro_id` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  `disponible` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_inventario_libros_idx` (`libro_id`),
  CONSTRAINT `FK_inventario_libros` FOREIGN KEY (`libro_id`) REFERENCES `libros` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros_inventario`
--

LOCK TABLES `libros_inventario` WRITE;
/*!40000 ALTER TABLE `libros_inventario` DISABLE KEYS */;
INSERT INTO `libros_inventario` VALUES (1,5,'Nuevo',_binary ''),(2,5,'Nuevo',_binary ''),(3,5,'Nuevo',_binary ''),(4,6,'Nuevo',_binary ''),(5,6,'Nuevo',_binary '');
/*!40000 ALTER TABLE `libros_inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `libros_inventario_existencia_v`
--

DROP TABLE IF EXISTS `libros_inventario_existencia_v`;
/*!50001 DROP VIEW IF EXISTS `libros_inventario_existencia_v`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `libros_inventario_existencia_v` AS SELECT 
 1 AS `id`,
 1 AS `titulo`,
 1 AS `tipo_recurso_id`,
 1 AS `tipo_recurso_nombre`,
 1 AS `tipo_recurso_activo`,
 1 AS `edicion`,
 1 AS `editorial_id`,
 1 AS `editorial_nombre`,
 1 AS `editorial_pais`,
 1 AS `editorial_emial`,
 1 AS `editorial_activo`,
 1 AS `autores`,
 1 AS `isbn`,
 1 AS `activo`,
 1 AS `cantidad_en_inventario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `libros_inventario_v`
--

DROP TABLE IF EXISTS `libros_inventario_v`;
/*!50001 DROP VIEW IF EXISTS `libros_inventario_v`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `libros_inventario_v` AS SELECT 
 1 AS `id`,
 1 AS `titulo`,
 1 AS `tipo_recurso_id`,
 1 AS `tipo_recurso_nombre`,
 1 AS `tipo_recurso_activo`,
 1 AS `edicion`,
 1 AS `editorial_id`,
 1 AS `editorial_nombre`,
 1 AS `editorial_pais`,
 1 AS `editorial_emial`,
 1 AS `editorial_activo`,
 1 AS `autores`,
 1 AS `isbn`,
 1 AS `activo`,
 1 AS `inventario_id`,
 1 AS `estado`,
 1 AS `disponible`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `libros_v`
--

DROP TABLE IF EXISTS `libros_v`;
/*!50001 DROP VIEW IF EXISTS `libros_v`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `libros_v` AS SELECT 
 1 AS `id`,
 1 AS `titulo`,
 1 AS `tipo_recurso_id`,
 1 AS `tipo_recurso_nombre`,
 1 AS `tipo_recurso_activo`,
 1 AS `edicion`,
 1 AS `editorial_id`,
 1 AS `editorial_nombre`,
 1 AS `editorial_pais`,
 1 AS `editorial_emial`,
 1 AS `editorial_activo`,
 1 AS `autores`,
 1 AS `isbn`,
 1 AS `activo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libro_inventario_id` int NOT NULL,
  `alumno_matricula` int NOT NULL,
  `fecha_prestamo` datetime NOT NULL,
  `fecha_devuelto` datetime DEFAULT NULL,
  `fecha_debe_devolver` datetime NOT NULL,
  `disponible` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_libro_inv_id_idx` (`libro_inventario_id`),
  KEY `FK_alumno_matricula_idx` (`alumno_matricula`),
  CONSTRAINT `FK_alumno_matricula` FOREIGN KEY (`alumno_matricula`) REFERENCES `alumnos` (`matricula`),
  CONSTRAINT `FK_libro_inv_id` FOREIGN KEY (`libro_inventario_id`) REFERENCES `libros_inventario` (`libro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
INSERT INTO `prestamos` VALUES (82,5,1930337,'2021-12-05 10:19:00','2021-12-05 11:10:00','2022-02-25 12:59:00',_binary ''),(83,6,1930337,'2021-01-05 10:19:00','2021-12-05 11:06:00','2022-02-25 12:59:00',_binary ''),(84,5,1930337,'2021-12-05 11:11:00','2021-12-05 11:33:00','2022-03-01 11:29:00',_binary ''),(85,6,1930337,'2021-01-05 11:13:00','2021-12-05 11:33:00','2022-04-10 10:20:00',_binary ''),(86,5,1930337,'2021-01-05 11:38:00','2021-12-05 11:39:00','2022-02-25 12:59:00',_binary '');
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `prestamos_v`
--

DROP TABLE IF EXISTS `prestamos_v`;
/*!50001 DROP VIEW IF EXISTS `prestamos_v`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prestamos_v` AS SELECT 
 1 AS `id`,
 1 AS `libro_inventario_id`,
 1 AS `libro_id`,
 1 AS `libro_titulo`,
 1 AS `libro_tipo_recurso_nombre`,
 1 AS `libro_edicion`,
 1 AS `libro_editorial_nombre`,
 1 AS `libro_autores`,
 1 AS `libro_isbn`,
 1 AS `libro_estado`,
 1 AS `alumno_matricula`,
 1 AS `alumno_nombre`,
 1 AS `alumno_apellidos`,
 1 AS `alumno_carrera_nombre`,
 1 AS `fecha_prestamo`,
 1 AS `fecha_debe_devolver`,
 1 AS `fecha_devuelto`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tipos_recursos`
--

DROP TABLE IF EXISTS `tipos_recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_recursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_recursos`
--

LOCK TABLES `tipos_recursos` WRITE;
/*!40000 ALTER TABLE `tipos_recursos` DISABLE KEYS */;
INSERT INTO `tipos_recursos` VALUES (1,'libro',_binary '');
INSERT INTO `tipos_recursos` VALUES (2,'revista',_binary '');
INSERT INTO `tipos_recursos` VALUES (3,'articulo web',_binary '');
INSERT INTO `tipos_recursos` VALUES (4,'enciclopedia',_binary '');
INSERT INTO `tipos_recursos` VALUES (5,'tesis',_binary '');
INSERT INTO `tipos_recursos` VALUES (6,'reporte',_binary '');
/*!40000 ALTER TABLE `tipos_recursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'biblioteca'
--

--
-- Dumping routines for database 'biblioteca'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_prestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_prestamo`(
	in p_libro_inv int,
    in p_alumno_mat int,
    in p_fecha_prestamo datetime,
    in p_fecha_devolver datetime,
    out p_id int
)
BEGIN
	INSERT INTO prestamos (
		libro_inventario_id,
		alumno_matricula,
        fecha_prestamo,
        fecha_debe_devolver,
        disponible
	) VALUES (
		p_libro_inv,
        p_alumno_mat,
        p_fecha_prestamo,
        p_fecha_devolver,
        1
    );
    SELECT id INTO p_id FROM prestamos
    WHERE libro_inventario_id = p_libro_inv AND
    alumno_matricula = p_alumno_mat AND
    fecha_prestamo = p_fecha_prestamo AND
    fecha_debe_devolver = p_fecha_devolver;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_prestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_prestamo`(
	in p_id int,
    in p_fecha_devuelto datetime
)
BEGIN
	UPDATE prestamos
    SET fecha_devuelto = p_fecha_devuelto
    WHERE id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;


-- -----------------------------------------------------
-- procedure insert_editorial
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `insert_editorial`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `insert_editorial`(
	 IN p_nombre  varchar(256)
    ,IN p_pais varchar(45)
    ,IN p_email varchar(45)
    ,IN p_activo int
)
BEGIN
	INSERT INTO editoriales(nombre, pais, email,activo) 
		VALUES(p_nombre, p_pais, p_email, p_activo);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_libro
-- -----------------------------------------------------

DELIMITER ;
USE `biblioteca`;
DROP procedure IF EXISTS `delete_libro`;

DELIMITER $$
USE `biblioteca`$$
CREATE  PROCEDURE `delete_libro`(
	IN p_id int
)
BEGIN
	DELETE FROM libros WHERE id = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure delete_editorial
-- -----------------------------------------------------
DELIMITER ;
USE `biblioteca`;
DROP procedure IF EXISTS `delete_editorial`;

DELIMITER $$
USE `biblioteca`$$
CREATE  PROCEDURE `delete_editorial`(
	IN p_id int
)
BEGIN
	DELETE FROM editoriales WHERE id = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_editorial
-- -----------------------------------------------------
DELIMITER ;
USE `biblioteca`;
DROP procedure IF EXISTS `update_editorial`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `update_editorial`(
	 IN p_id int
	,IN p_nombre  varchar(256)
    ,IN p_pais varchar(45)
    ,IN p_email varchar(45)
    ,IN p_activo int
)
BEGIN
	UPDATE editoriales SET 
    nombre = p_nombre, 
    pais = p_pais, 
    email = p_email,
    activo = p_activo
   
	WHERE id=p_id;
    
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_libro
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `update_libro`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `update_libro` (
	IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
	,IN p_stock int
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1),
    IN p_id int)
BEGIN
   UPDATE libros SET 
    titulo = p_titulo, 
    tipo_recurso_id = p_tipo_recurso_id, 
    stock = p_stock,
    editorial_id = p_editorial_id,
    autores = p_autores,
    isbn= p_isbn,
    activo = p_activo
   
	WHERE id=p_id;
END$$

DELIMITER ;
-- -----------------------------------------------------
-- procedure insert_libro
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `insert_libro`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `insert_libro` (
	 IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
	,IN p_stock int
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1))
BEGIN
	INSERT INTO libros(titulo,tipo_recurso_id,stock,editorial_id,autores,isbn,activo) 
		VALUES(p_titulo,p_tipo_recurso_id,p_stock,p_editorial_id,p_autores,p_isbn,p_activo);
END$$

DELIMITER ;
--
-- Final view structure for view `alumnos_v`
--

/*!50001 DROP VIEW IF EXISTS `alumnos_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `alumnos_v` AS select `a`.`id` AS `id`,`a`.`matricula` AS `matricula`,`a`.`nombre` AS `nombre`,`a`.`apellidos` AS `apellidos`,`a`.`carrera_id` AS `carrera_id`,`c`.`nombre` AS `carrera_nombre`,`c`.`activo` AS `carrera_activo`,`a`.`fecha_ingreso` AS `fecha_ingreso`,`a`.`fecha_nacimiento` AS `fecha_nacimiento`,`a`.`genero` AS `genero` from (`alumnos` `a` join `carreras` `c` on((`a`.`carrera_id` = `c`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `libros_inventario_existencia_v`
--

/*!50001 DROP VIEW IF EXISTS `libros_inventario_existencia_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `libros_inventario_existencia_v` AS select `l`.`id` AS `id`,`l`.`titulo` AS `titulo`,`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`l`.`tipo_recurso_nombre` AS `tipo_recurso_nombre`,`l`.`tipo_recurso_activo` AS `tipo_recurso_activo`,`l`.`edicion` AS `edicion`,`l`.`editorial_id` AS `editorial_id`,`l`.`editorial_nombre` AS `editorial_nombre`,`l`.`editorial_pais` AS `editorial_pais`,`l`.`editorial_emial` AS `editorial_emial`,`l`.`editorial_activo` AS `editorial_activo`,`l`.`autores` AS `autores`,`l`.`isbn` AS `isbn`,`l`.`activo` AS `activo`,(select count(0) from `libros_inventario` `li` where ((`li`.`libro_id` = `l`.`id`) and (`li`.`disponible` = 1))) AS `cantidad_en_inventario` from `libros_v` `l` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `libros_inventario_v`
--

/*!50001 DROP VIEW IF EXISTS `libros_inventario_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `libros_inventario_v` AS select `l`.`id` AS `id`,`l`.`titulo` AS `titulo`,`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`l`.`tipo_recurso_nombre` AS `tipo_recurso_nombre`,`l`.`tipo_recurso_activo` AS `tipo_recurso_activo`,`l`.`edicion` AS `edicion`,`l`.`editorial_id` AS `editorial_id`,`l`.`editorial_nombre` AS `editorial_nombre`,`l`.`editorial_pais` AS `editorial_pais`,`l`.`editorial_emial` AS `editorial_emial`,`l`.`editorial_activo` AS `editorial_activo`,`l`.`autores` AS `autores`,`l`.`isbn` AS `isbn`,`l`.`activo` AS `activo`,`li`.`id` AS `inventario_id`,`li`.`estado` AS `estado`,`li`.`disponible` AS `disponible` from (`libros_inventario` `li` join `libros_v` `l` on((`li`.`libro_id` = `l`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `libros_v`
--

/*!50001 DROP VIEW IF EXISTS `libros_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `libros_v` AS select `l`.`id` AS `id`,`l`.`titulo` AS `titulo`,`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`tr`.`nombre` AS `tipo_recurso_nombre`,`tr`.`activo` AS `tipo_recurso_activo`,`l`.`edicion` AS `edicion`,`l`.`editorial_id` AS `editorial_id`,`e`.`nombre` AS `editorial_nombre`,`e`.`pais` AS `editorial_pais`,`e`.`email` AS `editorial_emial`,`e`.`activo` AS `editorial_activo`,`l`.`autores` AS `autores`,`l`.`isbn` AS `isbn`,`l`.`activo` AS `activo` from ((`libros` `l` join `tipos_recursos` `tr` on((`l`.`tipo_recurso_id` = `tr`.`id`))) left join `editoriales` `e` on((`l`.`editorial_id` = `e`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prestamos_v`
--

/*!50001 DROP VIEW IF EXISTS `prestamos_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prestamos_v` AS select `p`.`id` AS `id`,`p`.`libro_inventario_id` AS `libro_inventario_id`,`li`.`id` AS `libro_id`,`li`.`titulo` AS `libro_titulo`,`li`.`tipo_recurso_nombre` AS `libro_tipo_recurso_nombre`,`li`.`edicion` AS `libro_edicion`,`li`.`editorial_nombre` AS `libro_editorial_nombre`,`li`.`autores` AS `libro_autores`,`li`.`isbn` AS `libro_isbn`,`li`.`estado` AS `libro_estado`,`p`.`alumno_matricula` AS `alumno_matricula`,`a`.`nombre` AS `alumno_nombre`,`a`.`apellidos` AS `alumno_apellidos`,`a`.`carrera_nombre` AS `alumno_carrera_nombre`,`p`.`fecha_prestamo` AS `fecha_prestamo`,`p`.`fecha_debe_devolver` AS `fecha_debe_devolver`,`p`.`fecha_devuelto` AS `fecha_devuelto` from ((`prestamos` `p` join `libros_inventario_v` `li` on((`p`.`libro_inventario_id` = `li`.`id`))) join `alumnos_v` `a` on((`p`.`alumno_matricula` = `a`.`matricula`))) where (`li`.`disponible` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
