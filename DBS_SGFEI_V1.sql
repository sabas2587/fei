CREATE DATABASE  IF NOT EXISTS `dbs_sgfei_v1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbs_sgfei_v1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbs_sgfei_v1
-- ------------------------------------------------------
-- Server version 5.5.5-10.1.29-MariaDB

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `pk_idActividades` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcionActividad` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '0',
  `fechaFinal` date DEFAULT NULL,
  `fechaInicial` date DEFAULT NULL,
  `listaactividad` varchar(255) DEFAULT NULL,
  `nombreActividad` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idActividades`),
  KEY `FK_Actividades_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  KEY `FK_Actividades_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  CONSTRAINT `FK_Actividades_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_Actividades_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acudiente`
--

DROP TABLE IF EXISTS `acudiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acudiente` (
  `pk_idAcudiente` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idAcudiente`),
  KEY `FK_acudiente_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  CONSTRAINT `FK_acudiente_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acudiente`
--

LOCK TABLES `acudiente` WRITE;
/*!40000 ALTER TABLE `acudiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `acudiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adolescente`
--

DROP TABLE IF EXISTS `adolescente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adolescente` (
  `pk_idAdolescente` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `escolaridad` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `lugarNacimiento` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroDocumento` bigint(20) DEFAULT NULL,
  `path_document` longtext,
  `tipoDocumento` varchar(255) DEFAULT NULL,
  `Remision_pk_ordenRemision` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idAdolescente`),
  KEY `FK_Adolescente_Remision_pk_ordenRemision` (`Remision_pk_ordenRemision`),
  CONSTRAINT `FK_Adolescente_Remision_pk_ordenRemision` FOREIGN KEY (`Remision_pk_ordenRemision`) REFERENCES `remision` (`pk_ordenRemision`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adolescente`
--

LOCK TABLES `adolescente` WRITE;
/*!40000 ALTER TABLE `adolescente` DISABLE KEYS */;
INSERT INTO `adolescente` VALUES (1,'aa',0,'qq','2017-01-01','Bogota','aa',11,'/archivos/FileBean.java','CC',1);
/*!40000 ALTER TABLE `adolescente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encuesta` (
  `pk_idencuesta` int(11) NOT NULL AUTO_INCREMENT,
  `criterio` varchar(255) DEFAULT NULL,
  `escala` varchar(255) DEFAULT NULL,
  `pregunta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_idencuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informe`
--

DROP TABLE IF EXISTS `informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informe` (
  `idinformeEx` int(11) NOT NULL AUTO_INCREMENT,
  `capacidadRestaurativa` varchar(255) DEFAULT NULL,
  `conceptoIntegral` varchar(255) DEFAULT NULL,
  `fechaDiagnostico` date DEFAULT NULL,
  `fortalecimiento` varchar(255) DEFAULT NULL,
  `objetivos` varchar(255) DEFAULT NULL,
  `tipoinforme` varchar(255) DEFAULT NULL,
  `trascendencia` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinformeEx`),
  KEY `FK_Informe_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  KEY `FK_Informe_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  CONSTRAINT `FK_Informe_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_Informe_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informe`
--

LOCK TABLES `informe` WRITE;
/*!40000 ALTER TABLE `informe` DISABLE KEYS */;
/*!40000 ALTER TABLE `informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervecion`
--

DROP TABLE IF EXISTS `intervecion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervecion` (
  `idintervecion` int(11) NOT NULL,
  `fechaintervencion` varchar(255) DEFAULT NULL,
  `tipointervencion` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idintervecion`),
  KEY `FK_intervecion_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  KEY `FK_intervecion_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  CONSTRAINT `FK_intervecion_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_intervecion_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervecion`
--

LOCK TABLES `intervecion` WRITE;
/*!40000 ALTER TABLE `intervecion` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervecion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `pk_idPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `active` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `nombre_permiso` varchar(255) DEFAULT NULL,
  `nombre_permiso_en` varchar(255) DEFAULT NULL,
  `url` longtext,
  `permiso_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idPermiso`),
  KEY `FK_permisos_permiso_padre` (`permiso_padre`),
  CONSTRAINT `FK_permisos_permiso_padre` FOREIGN KEY (`permiso_padre`) REFERENCES `permisos` (`pk_idPermiso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,NULL,NULL,'Adolecentes',NULL,NULL,NULL),(2,NULL,NULL,'listar adolecentes',NULL,'/Views/Adolescente/listAdolescente.xhtml?faces-redirect=true',1),(3,NULL,NULL,'crear adolecente',NULL,'/Views/Adolescente/addAdolescente.xhtml?faces-redirect=true',1);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos_has_rol`
--

DROP TABLE IF EXISTS `permisos_has_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos_has_rol` (
  `permisos_pk_idPermiso` int(11) NOT NULL,
  `Rol_pk_idRol` int(11) NOT NULL,
  PRIMARY KEY (`permisos_pk_idPermiso`,`Rol_pk_idRol`),
  KEY `FK_permisos_has_Rol_Rol_pk_idRol` (`Rol_pk_idRol`),
  CONSTRAINT `FK_permisos_has_Rol_Rol_pk_idRol` FOREIGN KEY (`Rol_pk_idRol`) REFERENCES `rol` (`pk_idRol`),
  CONSTRAINT `FK_permisos_has_Rol_permisos_pk_idPermiso` FOREIGN KEY (`permisos_pk_idPermiso`) REFERENCES `permisos` (`pk_idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos_has_rol`
--

LOCK TABLES `permisos_has_rol` WRITE;
/*!40000 ALTER TABLE `permisos_has_rol` DISABLE KEYS */;
INSERT INTO `permisos_has_rol` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `permisos_has_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesos`
--

DROP TABLE IF EXISTS `procesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procesos` (
  `pk_idValoracion` int(11) NOT NULL,
  `fechaValoracion` date DEFAULT NULL,
  `tipoactividad` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Encuesta_pk_idencuesta` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idValoracion`),
  KEY `FK_procesos_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  KEY `FK_procesos_Encuesta_pk_idencuesta` (`Encuesta_pk_idencuesta`),
  KEY `FK_procesos_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  CONSTRAINT `FK_procesos_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_procesos_Encuesta_pk_idencuesta` FOREIGN KEY (`Encuesta_pk_idencuesta`) REFERENCES `encuesta` (`pk_idencuesta`),
  CONSTRAINT `FK_procesos_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesos`
--

LOCK TABLES `procesos` WRITE;
/*!40000 ALTER TABLE `procesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `procesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remision`
--

DROP TABLE IF EXISTS `remision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remision` (
  `pk_ordenRemision` int(11) NOT NULL AUTO_INCREMENT,
  `autoridad` varchar(255) DEFAULT NULL,
  `fechaRemision` date DEFAULT NULL,
  `tipoRemision` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_ordenRemision`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remision`
--

LOCK TABLES `remision` WRITE;
/*!40000 ALTER TABLE `remision` DISABLE KEYS */;
INSERT INTO `remision` VALUES (1,'Juez','2018-03-27','Homicidio');
/*!40000 ALTER TABLE `remision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `pk_idRol` int(11) NOT NULL AUTO_INCREMENT,
  `Cargo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `pk_idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroDocumento` bigint(20) DEFAULT NULL,
  `Rol_pk_idRol` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idUsuario`),
  KEY `FK_Usuario_Rol_pk_idRol` (`Rol_pk_idRol`),
  CONSTRAINT `FK_Usuario_Rol_pk_idRol` FOREIGN KEY (`Rol_pk_idRol`) REFERENCES `rol` (`pk_idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'1','1','1','1','1',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbs_sgfei_v1'
--

--
-- Dumping routines for database 'dbs_sgfei_v1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-27 21:12:11
