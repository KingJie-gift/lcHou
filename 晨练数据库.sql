/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - cl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cl`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `type` int(4) NOT NULL COMMENT '0:部员  1：老师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`pwd`,`type`) values (10,'朱青','202cb962ac59075b964b07152d234b70',1),(11,'刘翠','698d51a19d8a121ce581499d7b701668',0),(12,'尹欢','9818af84da6f96579e99ed315f69e0c5',0),(13,'王胜楠','c6f057b86584942e415435ffb1fa93d4',0);

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `classid` int(4) NOT NULL AUTO_INCREMENT,
  `classname` varchar(20) NOT NULL,
  `typeid` int(4) NOT NULL COMMENT '班级类型id',
  `count` int(4) NOT NULL COMMENT '班级人数',
  `teaid` int(11) NOT NULL COMMENT '班主任id',
  `coachid` int(11) NOT NULL COMMENT '教员id',
  `motto` varchar(500) NOT NULL COMMENT '班级格言',
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`classid`,`classname`,`typeid`,`count`,`teaid`,`coachid`,`motto`) values (62,'0228_2019',2,21,43,1,'我是最棒的'),(63,'0123_2019',2,23,38,3,'我是最棒的'),(64,'0902_2019',1,23,43,4,'我是最棒的'),(65,'0318_2019',2,24,38,3,'我是最棒的'),(66,'0325_2019',1,34,38,5,'我是最棒的'),(67,'0724_2019',2,34,43,2,'我是最棒的'),(68,'0822_2019',1,23,38,5,'我是最棒的'),(69,'0508_2019',1,23,43,1,'我是最棒的'),(70,'0902_2018',2,24,32,1,'我是最棒的');

/*Table structure for table `classtalk` */

DROP TABLE IF EXISTS `classtalk`;

CREATE TABLE `classtalk` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) NOT NULL,
  `cid` int(11) NOT NULL,
  `time` int(11) NOT NULL COMMENT '演讲时间',
  `taifeng` int(11) NOT NULL COMMENT '台风',
  `smooth` int(11) DEFAULT NULL COMMENT '流畅性',
  `active` int(11) DEFAULT NULL COMMENT '互动性',
  `content` int(11) DEFAULT NULL COMMENT '内容的丰富性',
  `sum` int(11) DEFAULT NULL COMMENT '总分',
  `evaluate` varchar(1000) DEFAULT NULL COMMENT '评价',
  `talktime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日期',
  `memberid` int(11) DEFAULT NULL COMMENT '评价者(部员id)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `classtalk` */

insert  into `classtalk`(`id`,`sname`,`cid`,`time`,`taifeng`,`smooth`,`active`,`content`,`sum`,`evaluate`,`talktime`,`memberid`) values (1,'刘翠',11,2,2,2,3,2,11,'比较紧张','2019-04-23 00:00:00',1),(4,'dd',11,2,1,1,1,1,8,'dfgfg','2019-08-23 00:00:00',1),(5,'刘翠',11,1,3,4,6,2,5,'12fdf','2019-09-05 14:32:20',1),(7,'杜露瑶',11,3,5,7,8,9,15,'热狗的风格','2019-09-01 00:00:00',1),(8,'刘翠',11,5,4,3,1,1,3,'双方都','2019-09-01 00:00:00',1),(9,'杜露瑶',11,5,6,4,2,1,18,'陈师傅的说法','2019-09-05 14:32:20',1),(10,'杜露瑶',11,12,2,1,21,3,39,'2qesfhj','2019-09-09 09:51:37',1),(11,'杜露瑶',11,1,1,1,1,1,5,'gd','2019-09-12 00:00:00',1),(12,'杜露瑶',11,1,1,1,1,1,5,'ewe','2019-09-15 00:00:00',1),(13,'杜露瑶',11,2,1,3,1,2,8,'fdfd','2019-09-17 15:16:27',1),(14,'毛英豪 ',11,3,3,2,3,3,14,'fdsfd','2019-09-17 15:32:46',1),(15,'杜露瑶',62,3,3,1,1,1,7,'度uvbxcbv','2019-09-18 05:13:40',1),(16,'毛英豪 ',62,3,3,3,3,3,15,'内容太少','2019-09-18 05:14:07',1);

/*Table structure for table `classtype` */

DROP TABLE IF EXISTS `classtype`;

CREATE TABLE `classtype` (
  `typeid` int(4) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) NOT NULL COMMENT '班级类型,S1,S2,离校',
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `classtype` */

insert  into `classtype`(`typeid`,`typename`) values (1,'S1'),(2,'S2'),(3,'离校'),(4,'Y2'),(5,'技师班');

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `phone` varchar(500) NOT NULL,
  `intro` varchar(500) NOT NULL,
  `motto` varchar(500) NOT NULL,
  `dis` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `coach` */

insert  into `coach`(`id`,`name`,`account`,`pwd`,`phone`,`intro`,`motto`,`dis`,`image`) values (1,'郑智文','222222','222','123432323434','我叫郑智文，瓜王','我是最棒的',0,NULL),(2,'高琦','333333','333','139232848242','我叫高琦','我是老大',0,NULL),(3,'陈鹏','444444','444','12324324434','我叫陈鹏，大家叫我胖胖','我是小鹏',0,NULL),(4,'张羽','111111','111','13952275599','我叫张羽','嘻嘻哈哈',0,NULL),(5,'单文真','000000','000','13852275560','我叫单文真','嘿嘿嘿嘿嘿',0,NULL);

/*Table structure for table `interview` */

DROP TABLE IF EXISTS `interview`;

CREATE TABLE `interview` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `stuid` int(4) DEFAULT NULL,
  `cid` int(4) NOT NULL COMMENT '班级id',
  `jieshao` int(11) NOT NULL COMMENT '自我介绍',
  `problem` int(11) NOT NULL COMMENT '人事问题',
  `sum` int(11) NOT NULL COMMENT '总分',
  `time` int(11) NOT NULL,
  `mem` int(11) NOT NULL,
  `evalute` varchar(500) NOT NULL COMMENT '评价',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `interview` */

insert  into `interview`(`id`,`stuid`,`cid`,`jieshao`,`problem`,`sum`,`time`,`mem`,`evalute`,`date`) values (1,2,62,7,5,13,3,2,'自我介绍有的问题','2019-09-18 06:49:19'),(27,3,62,3,3,6,3,2,'电风扇等方式','2019-09-18 06:49:18'),(29,2,62,3,3,6,3,2,'的说法是发生','2019-09-18 06:49:17'),(34,24,62,8,2,4,2,2,'职业装不整洁','2019-09-18 06:55:47'),(38,24,62,1,2,4,2,2,'整体发是在','2019-09-18 06:55:50'),(39,24,62,6,4,10,3,2,'人事问题回答不完整','2019-09-05 00:00:00'),(40,24,62,1,3,4,3,2,'自我介绍回答不完整','2019-09-11 00:00:00'),(41,24,62,9,2,11,3,2,'时间太短','2019-09-03 00:00:00'),(42,24,62,9,2,11,3,2,'声音太小','2019-09-10 00:00:00'),(43,24,62,1,1,2,3,2,'态度很好 ','2019-09-10 00:00:00'),(44,24,62,1,1,2,3,2,'态度很好 ','2019-09-12 00:00:00'),(45,1,62,10,2,12,2,2,'3242342342为为热无若无热热','2019-09-18 09:20:24');

/*Table structure for table `lesson` */

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classid` int(11) NOT NULL,
  `week` varchar(50) NOT NULL,
  `none` int(11) NOT NULL,
  `lesson` varchar(50) NOT NULL,
  `memberid` int(11) NOT NULL,
  `talkTime` datetime NOT NULL,
  `ltime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `lesson` */

insert  into `lesson`(`id`,`classid`,`week`,`none`,`lesson`,`memberid`,`talkTime`,`ltime`) values (37,64,'周四',1,'3',2,'2019-09-18 00:00:00','2019-09-19 00:00:00'),(38,62,'周一',1,'2',2,'2019-09-18 00:00:00','2019-09-19 00:00:00'),(40,62,'周一',0,'1',5,'2019-09-18 00:00:00','2019-09-18 00:00:00'),(41,62,'周二',0,'2',11,'2019-09-18 00:00:00','2019-09-19 00:00:00'),(42,62,'周三',1,'3',2,'2019-09-18 00:00:00','2019-09-21 00:00:00');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `classid` int(4) NOT NULL,
  `course` int(11) NOT NULL COMMENT '0上午课，1下午课',
  `phone` varchar(355) DEFAULT NULL,
  `motto` varchar(500) NOT NULL COMMENT '格言',
  `tag` int(11) NOT NULL COMMENT '0在部1退部',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`id`,`name`,`classid`,`course`,`phone`,`motto`,`tag`) values (1,'尹欢',62,1,'1616200893','好好学习，天天向上 ',0),(2,'刘翠',62,1,'1616200893','嘻嘻嘻哈哈哈',0),(5,'张如梦',67,0,'15152008934','友谊是一棵可以庇荫的树。',0),(11,'李展',67,0,'13851768842','理想是人生的太阳。',0),(18,'张杰',65,0,'15152008934','我是最棒的',1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stuid` int(4) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(50) NOT NULL COMMENT '姓名',
  `cid` int(4) NOT NULL COMMENT '班级id',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`stuid`,`stuname`,`cid`) values (1,'杜露瑶',62),(2,'毛英豪 ',62),(3,'何其',62),(9,'朱传河',62),(13,'郭润',62),(15,'尹欢',62),(17,'董佳慧',63),(18,'刘纯',63),(19,'陆岩',62),(23,'朱宁',62),(24,'赵耀',62),(27,'朱宁',62);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `account` varchar(20) NOT NULL COMMENT '账号',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  `phone` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `motto` varchar(200) NOT NULL COMMENT '格言',
  `dis` int(4) NOT NULL COMMENT '是否离职0：在校1：离职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`account`,`pwd`,`phone`,`motto`,`dis`) values (32,'王胜楠','222','cfcd208495d565ef66e7dff9f98764da','15152008934','性相近，习相远',0),(34,'单曼曼','333','310dcbbf4cce62f762a2aaa148d556bd','1616200893','子不学，断机杼。',0),(38,'原艳娜','111','b706835de79a2b4e80506f582af3676a','17174669023','教五子，名俱扬。',0),(44,'刘冰洁','666','fae0b27c451c728867a567e8c1bb4e53','15152008934','苟不孝，性乃迁。',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
