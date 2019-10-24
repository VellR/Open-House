-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for OpenHouseDB
CREATE DATABASE IF NOT EXISTS `openhousedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `OpenHouseDB`;

-- Dumping structure for table OpenHouseDB.activetrades
CREATE TABLE IF NOT EXISTS `activetrades` (
  `ownerID` int(11) NOT NULL,
  `tradeID` int(11) DEFAULT NULL,
  `buyername` varchar(50) DEFAULT NULL,
  `sellername` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `barter` int(1) DEFAULT NULL,
  `desiredbarter` varchar(50) DEFAULT NULL,
  `expiration` date DEFAULT NULL,
  PRIMARY KEY (`ownerID`),
  KEY `itemID` (`tradeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table OpenHouseDB.completedtrades
CREATE TABLE IF NOT EXISTS `completedtrades` (
  `sellerID` int(11) DEFAULT NULL,
  `buyerID` int(11) DEFAULT NULL,
  `itemID` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `barter` int(1) DEFAULT NULL,
  `recievedbarter` varchar(50) DEFAULT NULL,
  `barterID` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  KEY `sellerID` (`sellerID`),
  KEY `buyerID` (`buyerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table OpenHouseDB.request
CREATE TABLE IF NOT EXISTS `request` (
  `requestID` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `barter` int(1) DEFAULT NULL,
  `desiredbarter` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table OpenHouseDB.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(10) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(25) NOT NULL,
  `phonenumber` varchar(11) NOT NULL,
  `barter` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
