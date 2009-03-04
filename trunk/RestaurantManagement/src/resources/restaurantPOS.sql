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
  `cost` double default NULL,
  PRIMARY KEY  (`itemId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `item` */

/*Table structure for table `itemaddon` */

DROP TABLE IF EXISTS `itemaddon`;

CREATE TABLE `itemaddon` (
  `itemAddonId` int(11) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY  (`itemAddonId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `itemaddon` */

/*Table structure for table `itemmod` */

DROP TABLE IF EXISTS `itemmod`;

CREATE TABLE `itemmod` (
  `itemModId` bigint(11) NOT NULL auto_increment,
  `itemAddonId` bigint(11) NOT NULL,
  `OrderItemId` bigint(11) NOT NULL,
  PRIMARY KEY  (`itemModId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `itemmod` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderItemId` int(11) NOT NULL auto_increment,
  `itemId` int(11) NOT NULL,
  `price` double NOT NULL,
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
  `typechar` char(1) default NULL,
  PRIMARY KEY  (`tableId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `restable` */

/*Table structure for table `timestamp` */

DROP TABLE IF EXISTS `timestamp`;

CREATE TABLE `timestamp` (
  `timeStampId` int(11) NOT NULL auto_increment,
  `inTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `outTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  `FK_employeeId` int(11) default NULL,
  PRIMARY KEY  (`timeStampId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `timestamp` */

insert  into `timestamp`(`timeStampId`,`inTime`,`outTime`,`FK_employeeId`) values (1,'2009-02-23 14:24:17','2009-02-23 14:24:17',1),(2,'2009-02-23 14:24:58','2009-02-23 14:24:58',1),(3,'2009-02-23 14:27:19','2009-02-23 14:27:27',1);

/* Procedure structure for procedure `spAddEmployee` */

/*!50003 DROP PROCEDURE IF EXISTS  `spAddEmployee` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spAddEmployee`(IN ID int(11), IN role char(1), IN fname varchar(20), IN lname varchar(20),
								IN phone char(10), IN address varchar(40), IN sin CHAR(9), IN wage double)
BEGIN
	INSERT INTO employee (employeeId, role, fname, lname, phone, address, sin, wage)
	VALUES(ID, role, fname, lname, phone, address, sin, wage);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spAddTable` */

/*!50003 DROP PROCEDURE IF EXISTS  `spAddTable` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spAddTable`(IN id int(11), IN status char(1), IN xloc int(11), IN yloc int(11),
									IN floor tinyint(1),IN seats tinyint(2), In employeeId int(11))
BEGIN
	INSERT INTO restable (tableid, status, xloc, yloc, floor, seats, employeeId)
	VALUES(id, status, xloc, yloc, floor, seats, employeeId);
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

/* Procedure structure for procedure `spLogIn` */

/*!50003 DROP PROCEDURE IF EXISTS  `spLogIn` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spLogIn`(IN empId int(11))
BEGIN
	
	INSERT INTO timestamp(FK_employeeId)
	VALUES(empId); 
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spLogOut` */

/*!50003 DROP PROCEDURE IF EXISTS  `spLogOut` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spLogOut`(IN empId int(11))
BEGIN
	set @out_time = now();
	set @timeId = -1;
	
	SELECT 	max(timeStampId) INTO @timeId
	FROM	timestamp
	WHERE 	FK_employeeId = empId;
	UPDATE 	timestamp
	SET	outTime = @out_time,
		in_time = in_time
	WHERE	timeStampId = @timeId;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
