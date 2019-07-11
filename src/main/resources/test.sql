CREATE DATABASE `loveandpeace` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `notice` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_dt` datetime(6) DEFAULT NULL,
  `modify_dt` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
