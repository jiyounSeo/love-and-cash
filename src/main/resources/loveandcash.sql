CREATE DATABASE `loveandcash` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `loveandcash`;

CREATE TABLE `account_book` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `type` tinyint(2) NOT NULL,
  `income_category` tinyint(2) DEFAULT NULL,
  `outgoing_category` tinyint(2) DEFAULT NULL,
  `object_type` tinyint(2) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `using_date` varchar(8) DEFAULT NULL,
  `create_dt` datetime(6) DEFAULT NULL,
  `modify_dt` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `budget` (
  `budget_id` int(11) NOT NULL AUTO_INCREMENT,
  `budget_month` varchar(6) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`budget_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `budget_detail` (
  `budget_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `budget_id` int(11) NOT NULL,
  `outgoing_category` tinyint(2) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`budget_detail_id`),
  KEY `budget_id_idx` (`budget_id`),
  CONSTRAINT `fk` FOREIGN KEY (`budget_id`) REFERENCES `budget` (`budget_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


