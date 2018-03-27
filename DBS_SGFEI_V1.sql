-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: DBS_SGFEI_V1
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `Actividades`
--

DROP TABLE IF EXISTS `Actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Actividades` (
  `pk_idActividades` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombreActividad` varchar(100) DEFAULT NULL,
  `fechaInicial` date DEFAULT NULL,
  `fechaFinal` date DEFAULT NULL,
  `descripcionActividad` varchar(150) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `listaactividad` varchar(45) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) NOT NULL,
  `Adolescente_pk_idAdolescente` int(11) NOT NULL,
  PRIMARY KEY (`pk_idActividades`),
  KEY `fk_Actividades_Usuario1_idx` (`Usuario_pk_idUsuario`),
  KEY `fk_Actividades_Adolescente1_idx` (`Adolescente_pk_idAdolescente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actividades`
--

LOCK TABLES `Actividades` WRITE;
/*!40000 ALTER TABLE `Actividades` DISABLE KEYS */;
INSERT INTO `Actividades` VALUES (1,'sdv','2018-03-28','2018-03-29','asdfa',1,'examen',1,1);
/*!40000 ALTER TABLE `Actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Adolescente`
--

DROP TABLE IF EXISTS `Adolescente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Adolescente` (
  `pk_idAdolescente` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDocumento` varchar(45) NOT NULL,
  `numeroDocumento` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `lugarNacimiento` varchar(100) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `escolaridad` varchar(45) NOT NULL,
  `path_document` text,
  `Remision_pk_ordenRemision` int(11) NOT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idAdolescente`),
  KEY `fk_Adolescente_Remision1_idx` (`Remision_pk_ordenRemision`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Adolescente`
--

LOCK TABLES `Adolescente` WRITE;
/*!40000 ALTER TABLE `Adolescente` DISABLE KEYS */;
INSERT INTO `Adolescente` VALUES (1,'cc',1234,'sebastian','guerrero','2018-03-17','boyaca',30,'primari',NULL,1,NULL);
/*!40000 ALTER TABLE `Adolescente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Encuesta`
--

DROP TABLE IF EXISTS `Encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Encuesta` (
  `pk_idencuesta` int(11) NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(150) NOT NULL,
  `criterio` varchar(45) DEFAULT NULL,
  `escala` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_idencuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Encuesta`
--

LOCK TABLES `Encuesta` WRITE;
/*!40000 ALTER TABLE `Encuesta` DISABLE KEYS */;
INSERT INTO `Encuesta` VALUES (1,'fuma','si ','1');
/*!40000 ALTER TABLE `Encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Informe`
--

DROP TABLE IF EXISTS `Informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Informe` (
  `idinformeEx` int(11) NOT NULL AUTO_INCREMENT,
  `tipoinforme` varchar(45) NOT NULL,
  `fechaDiagnostico` date NOT NULL,
  `objetivos` varchar(150) NOT NULL,
  `fortalecimiento` varchar(100) NOT NULL,
  `trascendencia` varchar(100) NOT NULL,
  `capacidadRestaurativa` varchar(100) NOT NULL,
  `conceptoIntegral` varchar(100) NOT NULL,
  `Usuario_pk_idUsuario` int(11) NOT NULL,
  `Adolescente_pk_idAdolescente` int(11) NOT NULL,
  `path_document` varchar(200) NOT NULL,
  `descripcion_informe` varchar(45) NOT NULL,
  PRIMARY KEY (`idinformeEx`),
  KEY `fk_InformeExtraordinario_Usuario1_idx` (`Usuario_pk_idUsuario`),
  KEY `fk_InformeExtraordinario_Adolescente1_idx` (`Adolescente_pk_idAdolescente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Informe`
--

LOCK TABLES `Informe` WRITE;
/*!40000 ALTER TABLE `Informe` DISABLE KEYS */;
/*!40000 ALTER TABLE `Informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Remision`
--

DROP TABLE IF EXISTS `Remision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Remision` (
  `pk_ordenRemision` int(11) NOT NULL,
  `fechaRemision` date NOT NULL,
  `tipoRemision` varchar(100) NOT NULL,
  `autoridad` varchar(100) NOT NULL,
  PRIMARY KEY (`pk_ordenRemision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Remision`
--

LOCK TABLES `Remision` WRITE;
/*!40000 ALTER TABLE `Remision` DISABLE KEYS */;
INSERT INTO `Remision` VALUES (1,'2018-03-17','robo','juez');
/*!40000 ALTER TABLE `Remision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rol`
--

DROP TABLE IF EXISTS `Rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rol` (
  `pk_idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `Cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rol`
--

LOCK TABLES `Rol` WRITE;
/*!40000 ALTER TABLE `Rol` DISABLE KEYS */;
INSERT INTO `Rol` VALUES (1,'medico','profesional'),(2,'secretaria','secretaria'),(3,'coordinador','coordinador');
/*!40000 ALTER TABLE `Rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `pk_idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `numeroDocumento` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `Rol_pk_idRol` int(11) NOT NULL,
  PRIMARY KEY (`pk_idUsuario`),
  KEY `fk_Usuario_Rol1_idx` (`Rol_pk_idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,1234,'sebastian','guerrero','sgsabas0692@gmail.com','1','1234',1),(2,4321,'coordinador','coordinador','4321','1','4321',3);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acudiente`
--

DROP TABLE IF EXISTS `acudiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acudiente` (
  `pk_idAcudiente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `Adolescente_pk_idAdolescente` int(11) NOT NULL,
  PRIMARY KEY (`pk_idAcudiente`),
  KEY `fk_acudiente_Adolescente1_idx` (`Adolescente_pk_idAdolescente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acudiente`
--

LOCK TABLES `acudiente` WRITE;
/*!40000 ALTER TABLE `acudiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `acudiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervecion`
--

DROP TABLE IF EXISTS `intervecion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervecion` (
  `idintervecion` int(11) NOT NULL,
  `fechaintervencion` varchar(45) DEFAULT NULL,
  `tipointervencion` varchar(45) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) NOT NULL,
  `Usuario_pk_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idintervecion`),
  KEY `fk_intervecion_Adolescente1_idx` (`Adolescente_pk_idAdolescente`),
  KEY `fk_intervecion_Usuario1_idx` (`Usuario_pk_idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `nombre_permiso` varchar(45) NOT NULL,
  `nombre_permiso_en` varchar(45) NOT NULL,
  `url` text,
  `icon` varchar(45) DEFAULT NULL,
  `active` varchar(45) DEFAULT NULL,
  `permiso_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idPermiso`),
  KEY `fk_permisos_permisos1_idx` (`permiso_padre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Registrar-Adolescente','Teenage','','fa fa-cogs','material-icons',NULL),(2,'Adolescente','Teenage','../Views/Adolescente/Adolescente.xhtml?faces-redirect=true','','',1),(3,'Proceso-Adolescente','Process-Teenage','','fa fa-cogs','material-icons',NULL),(4,'Seguimiento','Tracing','../Views/Proceso/addAdolescente.xhtml?faces-redirect=true',NULL,NULL,4),(5,'Diagnostico','Diagnostic','../Views/Proceso/addAdolescente.xhtml?faces-redirect=true',NULL,NULL,4),(6,'Intervencion','Intervencion','../Views/Proceso/addAdolescente.xhtml?faces-redirect=true',NULL,NULL,4),(7,'Informe-Adolescente','Report-Teenage','','fa fa-cogs','material-icons',NULL),(8,'Extraordinario','Extraordinary','../Views/Informe/addAdolescente.xhtml?faces-redirect=true',NULL,NULL,8),(9,'Seguimiento','Tracing','../Views/Informe/addAdolescente.xhtml?faces-redirect=true',NULL,NULL,8),(10,'Actividad-Adolescente','Activity-Teenage','',NULL,NULL,NULL),(11,'Registrar','Register','../Views/Actividad/activitidad.xhtml?faces-redirect=true',NULL,NULL,11);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos_has_Rol`
--

DROP TABLE IF EXISTS `permisos_has_Rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos_has_Rol` (
  `permisos_pk_idPermiso` int(11) NOT NULL,
  `Rol_pk_idRol` int(11) NOT NULL,
  KEY `fk_permisos_has_Rol_Rol1_idx` (`Rol_pk_idRol`),
  KEY `fk_permisos_has_Rol_permisos1_idx` (`permisos_pk_idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos_has_Rol`
--

LOCK TABLES `permisos_has_Rol` WRITE;
/*!40000 ALTER TABLE `permisos_has_Rol` DISABLE KEYS */;
INSERT INTO `permisos_has_Rol` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1);
/*!40000 ALTER TABLE `permisos_has_Rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesos`
--

DROP TABLE IF EXISTS `procesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procesos` (
  `pk_idValoracion` int(11) NOT NULL,
  `tipoactividad` varchar(45) DEFAULT NULL,
  `fechaValoracion` date NOT NULL,
  `Adolescente_pk_idAdolescente` int(11) NOT NULL,
  `Usuario_pk_idUsuario` int(11) NOT NULL,
  `Encuesta_pk_idencuesta` int(11) NOT NULL,
  PRIMARY KEY (`pk_idValoracion`),
  KEY `fk_Valoracion_Adolescente1_idx` (`Adolescente_pk_idAdolescente`),
  KEY `fk_Valoracion_Usuario1_idx` (`Usuario_pk_idUsuario`),
  KEY `fk_Valoracion_Encuesta1_idx` (`Encuesta_pk_idencuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesos`
--

LOCK TABLES `procesos` WRITE;
/*!40000 ALTER TABLE `procesos` DISABLE KEYS */;
INSERT INTO `procesos` VALUES (1,'valoracion','2018-03-27',1,1,1);
/*!40000 ALTER TABLE `procesos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-26 21:47:20
