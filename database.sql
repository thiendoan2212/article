CREATE DATABASE /*!32312 IF NOT EXISTS*/`article_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `article_db`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` BIGINT(20) NOT NULL,
  `category` VARCHAR(255) DEFAULT NULL,
  `title` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*Data for the table `article` */

INSERT  INTO `article`(`id`,`category`,`title`) VALUES 
(4,'Android','Android AsyncTask Example'),
(3,'Java 8','Lambda Expressions Java 8 Example'),
(2,'Spring Boot','Spring Boot Getting Started'),
(1,'Angular','Angular 2 Tutorial using CLI');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` BIGINT(20) DEFAULT NULL
) ENGINE=MYISAM DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

INSERT  INTO `hibernate_sequence`(`next_val`) VALUES (5);
