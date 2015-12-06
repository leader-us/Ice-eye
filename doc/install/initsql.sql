/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : ku8eye

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2015-11-24 15:57:56
*/

DROP DATABASE IF EXISTS iceeye;
create database iceeye DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
#insert into mysql.user(Host,User,Password) values('localhost','iceeye',password('123456'));
grant all privileges on iceeye.* to 'iceeye'@'%' identified  by '123456';
use iceeye;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `host`
-- ----------------------------
DROP TABLE IF EXISTS `host`;
CREATE TABLE `host` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `HOST_NAME` char(32) NOT NULL COMMENT 'host name ',
  `IP` char(32) NOT NULL COMMENT 'ip addr',
  `ROOT_PASSWD` char(16) DEFAULT NULL COMMENT 'root password ',
  `LOCATION` varchar(128) DEFAULT NULL COMMENT 'host location ,etc room ',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  `CORES` tinyint(4) DEFAULT 0,
  `MEMORY` mediumint(6) DEFAULT 0,
  `USAGE_FLAG` tinyint(4) DEFAULT 0,
  `SSH_LOGIN` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of host
-- ----------------------------
INSERT INTO `host` VALUES ('1',  'mynode_1', '192.168.1.3', '123456', 'wang jing', null, '2015-11-24 15:20:04', '4', '524288', 0, 1);
INSERT INTO `host` VALUES ('2',  'mynode_2', '192.168.1.4', '123456', 'si hui', null, '2015-11-24 15:20:53', '8', '524288', 0, 1);
INSERT INTO `host` VALUES ('3',  'mynode_3', '192.168.1.5', '123456', 'si hui', null, '2015-11-24 15:20:18', '16', '1048576', 0, 1);
INSERT INTO `host` VALUES ('4',  'mynode_4', '192.168.1.6', '123456', 'wang jing', null, '2015-11-24 15:20:56', '24', '262144',0, 1);



-- ----------------------------
-- Table structure for `ice_cluster`
-- ----------------------------
DROP TABLE IF EXISTS `ice_cluster`;
CREATE TABLE `ice_cluster` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `NAME` char(32) NOT NULL COMMENT 'cluster name ',
  `LABELS` varchar(64) DEFAULT NULL COMMENT 'splitted labels',
  `ICE_VERSION` char(16) DEFAULT '1.0' COMMENT 'ICE version',
  `INSTALL_TYPE` tinyint(4) DEFAULT NULL COMMENT 'custom, all in one, normal ,ha ..',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ku8_cluster
-- ----------------------------
INSERT INTO `ice_cluster` VALUES ('1', 'test cluster', 'test', '3.6.1', '1', null, '2015-11-19 14:13:46');


-- ----------------------------
-- Table structure for `ice_project`
-- ----------------------------
DROP TABLE IF EXISTS `ice_project`;
CREATE TABLE `ice_project` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `OWNER` char(16) DEFAULT NULL COMMENT 'creater :userid',
  `NAME` varchar(128) NOT NULL COMMENT ' project name ',
  `VERSION` char(16) DEFAULT '1.0' COMMENT ' project version',
  `ICE_VERSION` char(16) DEFAULT '3.6.1' COMMENT 'ice  version',
  `XML_SPEC` text COMMENT 'XML spec content',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ice_project
-- ----------------------------
INSERT INTO `ice_project` VALUES ('1',  'hpcms', 'demo project', '3.6.1', '1.0', null, null, '2015-11-19 14:09:13');
INSERT INTO `ice_project` VALUES ('2',  'guest', 'demo2 project', '3.6.1', '1.0', null, null, '2015-11-19 14:12:44');

-- ----------------------------
-- Table structure for `ice_proj_instance`
-- ----------------------------
DROP TABLE IF EXISTS `ice_proj_instance`;
CREATE TABLE `ice_proj_instance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `PROJECTID` int(11) DEFAULT NULL COMMENT 'project Id ',
  `CLUSTER_ID` int(11) DEFAULT NULL COMMENT 'belong to which cluster ',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT 'instance status OK, ERR,DELETED',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ice_proj_instance
-- ----------------------------

-- ----------------------------
-- Table structure for `ice_proj_icebox_inst`
-- ----------------------------
DROP TABLE IF EXISTS `ice_proj_icebox_inst`;
CREATE TABLE `ice_proj_icebox_inst` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `PROJECTID` int(11) DEFAULT NULL COMMENT 'project Id ',
  `PROJECT_INSTANCE_ID` int(11) DEFAULT NULL COMMENT 'project instance Id ',
  `SERVER_NAME` varchar(32) DEFAULT NULL COMMENT 'ice box name',
  `REPLICA` tinyint(4) DEFAULT NULL COMMENT 'ice box replica ',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` char(16) NOT NULL COMMENT 'id of user',
  `ALIAS` varchar(64) DEFAULT NULL COMMENT 'user alias',
  `PASSWORD` char(8) NOT NULL,
  `USER_TYPE` tinyint(4) DEFAULT NULL COMMENT 'tenent user or admin user',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT 'account status ,used for control login',
  `NOTE` varchar(256) DEFAULT NULL COMMENT 'note for this record',
  `LAST_UPDATED` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'last updated time',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('guest', 'guest', '123456', '1', '0',  null, '2015-11-19 14:07:25');
INSERT INTO `user` VALUES ('hpcms', 'hp cms', '123456', '1', '0',  null, '2015-11-19 14:08:14');
INSERT INTO `user` VALUES ('ku8eye', 'ku8 admin', '123456', '1', null, 'demo init user', '2015-11-19 11:16:21');

