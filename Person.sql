/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.253_3306
Source Server Version : 50517
Source Host           : 192.168.0.253:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-05-04 18:15:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `seq` int(11) DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '层级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `parent_seq` (`parent_id`,`seq`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '张三', '0', '1000', '0', '0');
INSERT INTO `person` VALUES ('2', '李四', '1', '1000-1', '1', '1');
INSERT INTO `person` VALUES ('3', '王五', '2', '1000-1-1', '1', '2');
INSERT INTO `person` VALUES ('4', '赵六', '2', '1000-1-2', '2', '2');
INSERT INTO `person` VALUES ('5', '田七', '0', '1001', '0', '0');
INSERT INTO `person` VALUES ('6', '古今', '5', '1001-1', '1', '1');
INSERT INTO `person` VALUES ('7', '值么', '5', '1001-2', '2', '1');
