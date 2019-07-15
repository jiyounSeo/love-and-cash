CREATE DATABASE `loveandcash` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `budget` (
  `budget_id` int(11) NOT NULL AUTO_INCREMENT,
  `budget_month` varchar(6) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`budget_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `budget_detail` (
  `budget_detail_id` int(11) NOT NULL,
  `budget_id` varchar(45) NOT NULL,
  `outgoingType` tinyint(2) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`budget_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



