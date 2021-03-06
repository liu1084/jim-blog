/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 5.5.5-10.1.13-MariaDB : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `articles` */

DROP TABLE IF EXISTS `articles`;

CREATE TABLE `articles` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `userId` bigint(30) unsigned NOT NULL DEFAULT '1',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDraft` tinyint(1) NOT NULL DEFAULT '0',
  `isPrivate` tinyint(1) NOT NULL DEFAULT '0',
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_articles_users` (`userId`),
  CONSTRAINT `FK_articles_users` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `articles` */

insert  into `articles`(`id`,`title`,`content`,`userId`,`create_at`,`update_at`,`isDraft`,`isPrivate`,`isActive`) values (1,'task1','dddddddddddddddddddddddddd',1,'2016-06-05 00:40:35','2016-06-05 00:40:35',0,0,1),(2,'title2','fewfewfew',2,'2016-06-09 00:59:44','2016-06-09 00:59:44',0,0,1),(3,'t3','dd',1,'2016-06-14 01:31:40','2016-06-14 01:31:40',0,0,1),(4,'t4','dfeaf',1,'2016-06-14 01:35:00','2016-06-14 01:35:00',0,0,1);

/*Table structure for table `articles_metadata` */

DROP TABLE IF EXISTS `articles_metadata`;

CREATE TABLE `articles_metadata` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `articleId` bigint(30) unsigned NOT NULL DEFAULT '1',
  `key` varchar(50) NOT NULL DEFAULT '',
  `value` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_articles_metadata` (`articleId`),
  CONSTRAINT `FK_articles_metadata` FOREIGN KEY (`articleId`) REFERENCES `articles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articles_metadata` */

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `parentId` bigint(30) unsigned DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `userId` bigint(30) unsigned NOT NULL,
  `articleId` bigint(30) unsigned NOT NULL,
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_comments_articles` (`articleId`),
  KEY `FK_comments_users` (`userId`),
  CONSTRAINT `FK_comments_articles` FOREIGN KEY (`articleId`) REFERENCES `articles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_comments_users` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`id`,`parentId`,`title`,`content`,`userId`,`articleId`,`create_at`,`update_at`,`isActive`) values (1,NULL,'task comment 1','/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\r\n/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\r\n/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\r\n/*!40101 SET NAMES utf8 */;\r\n/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;\r\n/*!40103 SET TIME_ZONE=\'+00:00\' */;\r\n/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\r\n/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\r\n/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=\'NO_AUTO_VALUE_ON_ZERO\' */;\r\n/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;\r\n\r\n...........',1,1,'2016-06-05 00:41:59','2016-06-05 00:41:59',1),(2,1,'task comment 1 - 1','fff',1,1,'2016-06-18 11:57:59','2016-06-18 11:57:59',1);

/*Table structure for table `comments_metadata` */

DROP TABLE IF EXISTS `comments_metadata`;

CREATE TABLE `comments_metadata` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `commentId` bigint(30) unsigned NOT NULL DEFAULT '1',
  `key` varchar(50) NOT NULL DEFAULT '',
  `value` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comments_metadata` (`commentId`),
  CONSTRAINT `FK_comments_metadata` FOREIGN KEY (`commentId`) REFERENCES `comments` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comments_metadata` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  `isActive` tinyint(2) NOT NULL DEFAULT '1',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`,`description`,`isActive`,`create_at`,`update_at`) values (1,'admin','admin',1,'2016-06-05 00:39:41','2016-06-05 00:39:41'),(2,'user','my wife',1,'2016-06-20 02:31:51','2016-06-20 02:31:51');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(30) unsigned NOT NULL,
  `roleId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role_users` (`userId`),
  KEY `FK_user_role_roles` (`roleId`),
  CONSTRAINT `FK_user_role_roles` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_user_role_users` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`userId`,`roleId`) values (1,1,1),(2,1,2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `nickname` varchar(50) NOT NULL DEFAULT '',
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`nickname`,`isActive`,`create_at`,`update_at`) values (1,'liujun','111','Jim',1,'2016-06-05 10:42:38','2016-06-05 10:42:38'),(2,'liqing','222','Sunny',1,'2016-06-05 00:42:38','2016-06-05 00:42:38');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
