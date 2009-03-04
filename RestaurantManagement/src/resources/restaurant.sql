/*
SQLyog Community Edition- MySQL GUI v8.01 
MySQL - 5.0.67-community-nt : Database - restaurant
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`restaurant` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `restaurant`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL,
  `parent` int(11) default NULL,
  PRIMARY KEY  (`categoryId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `category` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL auto_increment,
  `role` char(1) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `phone` char(10) NOT NULL,
  `address` varchar(40) NOT NULL,
  `sin` char(9) NOT NULL,
  `wage` double NOT NULL,
  PRIMARY KEY  (`employeeId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itemId` int(11) NOT NULL auto_increment,
  `price` double NOT NULL,
  `categoryId` int(11) default NULL,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY  (`itemId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `item` */

/*Table structure for table `itemaddon` */

DROP TABLE IF EXISTS `itemaddon`;

CREATE TABLE `itemaddon` (
  `itemAddonId` int(11) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL,
  `price` double NOT NULL,
  `itemId` int(11) NOT NULL,
  PRIMARY KEY  (`itemAddonId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `itemaddon` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderItemId` int(11) NOT NULL auto_increment,
  `itemId` int(11) NOT NULL,
  `cost` double NOT NULL,
  `seat` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  PRIMARY KEY  (`orderItemId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `orderitem` */

/*Table structure for table `resorder` */

DROP TABLE IF EXISTS `resorder`;

CREATE TABLE `resorder` (
  `orderId` int(11) NOT NULL auto_increment,
  `paymentMethod` char(1) NOT NULL,
  `paid` tinyint(1) NOT NULL default '0',
  `paymentAmount` double NOT NULL,
  `tableId` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  PRIMARY KEY  (`orderId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `resorder` */

/*Table structure for table `restable` */

DROP TABLE IF EXISTS `restable`;

CREATE TABLE `restable` (
  `tableId` int(11) NOT NULL auto_increment,
  `status` char(1) NOT NULL,
  `employeeId` int(11) default NULL,
  `xloc` int(11) NOT NULL,
  `yloc` int(11) NOT NULL,
  `floor` tinyint(1) default NULL,
  `seats` tinyint(2) default NULL,
  PRIMARY KEY  (`tableId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `restable` */

/*Table structure for table `timestamp` */

DROP TABLE IF EXISTS `timestamp`;

CREATE TABLE `timestamp` (
  `timeStampId` int(11) NOT NULL auto_increment,
  `in` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `out` timestamp NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`timeStampId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `timestamp` */

/* Procedure structure for procedure `addTable` */

/*!50003 DROP PROCEDURE IF EXISTS  `addTable` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addTable`(IN id int(11), IN status char(1), IN xloc int(11), IN yloc int(11),
									IN floor tinyint(1),IN seats tinyint(2))
BEGIN
	INSERT INTO restable (tableid, status, xloc, yloc, floor, seats)
	VALUES(id, status, xloc, yloc, floor, seats);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spAddTable` */

/*!50003 DROP PROCEDURE IF EXISTS  `spAddTable` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spAddTable`(IN id int(11), IN status char(1), IN xloc int(11), IN yloc int(11),
									IN floor tinyint(1),IN seats tinyint(2))
BEGIN
	INSERT INTO restable (tableid, status, xloc, yloc, floor, seats)
	VALUES(id, status, xloc, yloc, floor, seats);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spDeleteEmployee` */

/*!50003 DROP PROCEDURE IF EXISTS  `spDeleteEmployee` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteEmployee`(IN delID int(11))
BEGIN
	DELETE FROM employee
	WHERE employeeId = delID;
END */$$
DELIMITER ;

/* Procedure structure for procedure `spDeleteTable` */

/*!50003 DROP PROCEDURE IF EXISTS  `spDeleteTable` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteTable`(IN delID int(11))
BEGIN
	DELETE FROM resTable
	WHERE tableId = delID;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
