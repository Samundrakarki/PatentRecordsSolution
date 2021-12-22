CREATE DATABASE  IF NOT EXISTS `records_directory`;
USE `records_directory`;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `record`;

CREATE TABLE `records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `abstract` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


