-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookprev
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `billing_address`
--

DROP TABLE IF EXISTS `billing_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apartment_number` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `country` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `street_name` varchar(200) DEFAULT NULL,
  `zip_code` varchar(200) DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdjbqq4dn198ashlk2t2vnl922` (`customer`),
  CONSTRAINT `FKdjbqq4dn198ashlk2t2vnl922` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_address`
--

LOCK TABLES `billing_address` WRITE;
/*!40000 ALTER TABLE `billing_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grand_total` double DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5vleys1sf03imkv6nneu8csoi` (`customer`),
  CONSTRAINT `FK5vleys1sf03imkv6nneu8csoi` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cart` bigint(20) DEFAULT NULL,
  `product` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKknqhxrmf06u65u31yhsl1iswe` (`cart`),
  KEY `FK1995n4vu1kx536ajess0mhn60` (`product`),
  CONSTRAINT `FK1995n4vu1kx536ajess0mhn60` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FKknqhxrmf06u65u31yhsl1iswe` FOREIGN KEY (`cart`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `billing_address` bigint(20) DEFAULT NULL,
  `cart` bigint(20) DEFAULT NULL,
  `shopping_address` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6vt2i0p66gvkxqv9j8rlfk7o6` (`billing_address`),
  KEY `FKbrohf6epj6pcc29yl5bny60ys` (`cart`),
  KEY `FKoime9p1k4grfvovjh4ox78cjs` (`shopping_address`),
  CONSTRAINT `FK6vt2i0p66gvkxqv9j8rlfk7o6` FOREIGN KEY (`billing_address`) REFERENCES `billing_address` (`id`),
  CONSTRAINT `FKbrohf6epj6pcc29yl5bny60ys` FOREIGN KEY (`cart`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKoime9p1k4grfvovjh4ox78cjs` FOREIGN KEY (`shopping_address`) REFERENCES `shipping_address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billingaddress` bigint(20) DEFAULT NULL,
  `cart` bigint(20) DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  `shippingaddress` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKx2799t9hcqlk5ty1h08d6145` (`billingaddress`),
  KEY `FKiho5wteh8dnrsvnm51tdfa3it` (`cart`),
  KEY `FK5r232aaktxxxoht69hcnp3bs0` (`customer`),
  KEY `FK2ep1xhipv48leq4lfkk8cqrkp` (`shippingaddress`),
  CONSTRAINT `FK2ep1xhipv48leq4lfkk8cqrkp` FOREIGN KEY (`shippingaddress`) REFERENCES `shipping_address` (`id`),
  CONSTRAINT `FK5r232aaktxxxoht69hcnp3bs0` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKiho5wteh8dnrsvnm51tdfa3it` FOREIGN KEY (`cart`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKx2799t9hcqlk5ty1h08d6145` FOREIGN KEY (`billingaddress`) REFERENCES `billing_address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `manufacturer` varchar(200) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `unit_in_stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Khoa Hoc','b001','item_1','Nhan Van','Java Core',100,'/images/item_1.jpg',100),(2,'Nhan Van','b002','item_2','Nhan Van','English Learner',100,'/images/item_2.jpg',50),(3,'Giao Duc','b003','item_3','Fahasa','Toan Roi Rac',200,'/images/item_3.jpg',20),(4,'Giao Duc','b004','item_4','Fahasa','Toan Cao Cap',20,'/images/item_4.jpg',100);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apartment_number` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `country` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `street_name` varchar(200) DEFAULT NULL,
  `zip_code` varchar(200) DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsu9pb8wf8tx7xgw3i36te9x44` (`customer`),
  CONSTRAINT `FKsu9pb8wf8tx7xgw3i36te9x44` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_address`
--

LOCK TABLES `shipping_address` WRITE;
/*!40000 ALTER TABLE `shipping_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13  0:36:07
