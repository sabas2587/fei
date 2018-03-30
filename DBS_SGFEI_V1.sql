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
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_idAdolescente`),
  KEY `FK_Adolescente_Remision_pk_ordenRemision` (`Remision_pk_ordenRemision`),
  CONSTRAINT `FK_Adolescente_Remision_pk_ordenRemision` FOREIGN KEY (`Remision_pk_ordenRemision`) REFERENCES `remision` (`pk_ordenRemision`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adolescente`
--

LOCK TABLES `adolescente` WRITE;
/*!40000 ALTER TABLE `adolescente` DISABLE KEYS */;
INSERT INTO `adolescente` VALUES (4,'sarnoso',NULL,'n-a','2018-03-02','Bogota','el perro',123,'/archivos/a.txt','CC',4,NULL),(5,'ratica',NULL,'aa','2018-03-01','Bogota','la',123,'/archivos/aaaaassf.txt','CC',5,NULL),(6,'brayitan',NULL,'b','2018-03-30','Bogota','el ',NULL,'/archivos/a.txt','CC',6,NULL);
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
  `escala` int(11) DEFAULT NULL,
  `pregunta` varchar(255) DEFAULT NULL,
  `valoracion_valoracion` int(11) NOT NULL,
  PRIMARY KEY (`pk_idencuesta`),
  KEY `fk_encuesta_valoracion1_idx` (`valoracion_valoracion`),
  CONSTRAINT `fk_encuesta_valoracion1` FOREIGN KEY (`valoracion_valoracion`) REFERENCES `valoracion` (`valoracion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` VALUES (1,3,'<cambiar pregunta>',7),(2,3,'<cambiar pregunta>',7),(3,3,'<cambiar pregunta>',7),(4,3,'<cambiar pregunta>',7),(5,3,'<cambiar pregunta>',7),(6,2,'<cambiar pregunta>',8),(7,1,'<cambiar pregunta>',8),(8,1,'<cambiar pregunta>',8),(9,5,'<cambiar pregunta>',8),(10,5,'<cambiar pregunta>',8),(11,1,'<cambiar pregunta>',9),(12,2,'<cambiar pregunta>',9),(13,3,'<cambiar pregunta>',9),(14,4,'<cambiar pregunta>',9),(15,5,'<cambiar pregunta>',9),(28,5,'<cambiar pregunta>',6),(29,4,'<cambiar pregunta>',6),(30,5,'<cambiar pregunta>',6),(31,4,'<cambiar pregunta>',6),(32,5,'<cambiar pregunta>',6),(33,2,'<cambiar pregunta>',10),(34,3,'<cambiar pregunta>',10),(35,3,'<cambiar pregunta>',10),(36,2,'<cambiar pregunta>',10),(37,1,'<cambiar pregunta>',10),(38,2,'<cambiar pregunta>',11),(39,2,'<cambiar pregunta>',11),(40,2,'<cambiar pregunta>',11),(41,2,'<cambiar pregunta>',11),(42,2,'<cambiar pregunta>',11);
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedad`
--

DROP TABLE IF EXISTS `novedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novedad` (
  `idintervecion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaintervencion` varchar(255) DEFAULT NULL,
  `tipointervencion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
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
-- Dumping data for table `novedad`
--

LOCK TABLES `novedad` WRITE;
/*!40000 ALTER TABLE `novedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedad` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,NULL,NULL,'Adolecentes',NULL,NULL,NULL),(2,NULL,NULL,'listar adolecentes',NULL,'/Views/Adolescente/listAdolescente.xhtml?faces-redirect=true',1),(3,NULL,NULL,'crear adolecente',NULL,'/Views/Adolescente/addAdolescente.xhtml?faces-redirect=true',1),(4,NULL,NULL,'Valoracion',NULL,NULL,NULL),(5,NULL,NULL,'Listar valoraciones',NULL,'/Views/Valoracion/ListarValoraciones.xhtml?faces-redirect=true',4),(6,NULL,NULL,'Crear valoracion',NULL,'/Views/Valoracion/CrearValoracion.xhtml?faces-redirect=true',4);
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
  KEY `FK_permisos_has_Rol_Rol_pk_idRol` (`Rol_pk_idRol`),
  KEY `FK_permisos_has_Rol_permisos_pk_idPermiso` (`permisos_pk_idPermiso`),
  CONSTRAINT `FK_permisos_has_Rol_Rol_pk_idRol` FOREIGN KEY (`Rol_pk_idRol`) REFERENCES `rol` (`pk_idRol`),
  CONSTRAINT `FK_permisos_has_Rol_permisos_pk_idPermiso` FOREIGN KEY (`permisos_pk_idPermiso`) REFERENCES `permisos` (`pk_idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos_has_rol`
--

LOCK TABLES `permisos_has_rol` WRITE;
/*!40000 ALTER TABLE `permisos_has_rol` DISABLE KEYS */;
INSERT INTO `permisos_has_rol` VALUES (4,2),(5,2),(6,2),(4,3),(5,3),(6,3),(4,4),(5,4),(6,4),(4,5),(5,5),(6,5),(1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `permisos_has_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesos`
--

DROP TABLE IF EXISTS `procesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procesos` (
  `idinformeEx` int(11) NOT NULL AUTO_INCREMENT,
  `capacidadRestaurativa` varchar(255) DEFAULT NULL,
  `tipo_concepto` varchar(45) DEFAULT NULL,
  `fechaDiagnostico` date DEFAULT NULL,
  `fortalecimiento` varchar(255) DEFAULT NULL,
  `objetivos` varchar(255) DEFAULT NULL,
  `tipoproceso` varchar(255) DEFAULT NULL,
  `trascendencia` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  `path_concepto_final` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idinformeEx`),
  KEY `FK_Informe_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  KEY `FK_Informe_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  CONSTRAINT `FK_Informe_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_Informe_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remision`
--

LOCK TABLES `remision` WRITE;
/*!40000 ALTER TABLE `remision` DISABLE KEYS */;
INSERT INTO `remision` VALUES (4,'Juez','2018-03-29','Homicidio'),(5,'Juez','2018-03-01','Homicidio'),(6,'Juez','2018-03-01','Robo');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Admin',NULL),(2,'medico',NULL),(3,'psicologo',NULL),(4,'nutricion',NULL),(5,'trabajadora social',NULL),(6,'secretaria',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'admin','1','1','1','admin',1,1),(6,'medico','2','1','2','medico',2,2),(7,'psicologo','3','1','3','psicologo3',3,3),(8,'nutricionista','4','1','4','nutricionista',4,4),(9,'trabajador social','5','1','5','trabajador social',5,5),(10,'secretaria','6','1','6','secretaria',6,6);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valoracion` (
  `valoracion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaValoracion` date DEFAULT NULL,
  `tipoactividad` varchar(255) DEFAULT NULL,
  `Adolescente_pk_idAdolescente` int(11) DEFAULT NULL,
  `Usuario_pk_idUsuario` int(11) DEFAULT NULL,
  `recomendacion` varchar(100) DEFAULT NULL,
  `concepto_integral` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`valoracion`),
  KEY `FK_procesos_Usuario_pk_idUsuario` (`Usuario_pk_idUsuario`),
  KEY `FK_procesos_Adolescente_pk_idAdolescente` (`Adolescente_pk_idAdolescente`),
  CONSTRAINT `FK_procesos_Adolescente_pk_idAdolescente` FOREIGN KEY (`Adolescente_pk_idAdolescente`) REFERENCES `adolescente` (`pk_idAdolescente`),
  CONSTRAINT `FK_procesos_Usuario_pk_idUsuario` FOREIGN KEY (`Usuario_pk_idUsuario`) REFERENCES `usuario` (`pk_idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracion`
--

LOCK TABLES `valoracion` WRITE;
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
INSERT INTO `valoracion` VALUES (6,'2018-03-30','123',4,6,'123','123'),(7,'2018-03-30','aa',5,6,'aaa','aaa'),(8,'2018-03-30','psicologo',4,7,'psicologo','psicologo'),(9,'2018-03-30','trabajador social ',4,9,'trabajador social ','trabajador social '),(10,'2018-03-30','medico medico',6,6,'medico medico','medico medico'),(11,'2018-03-30','psicologo psicologo',5,7,'psicologo psicologo','psicologo psicologo');
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;
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

-- Dump completed on 2018-03-30 12:13:46
