/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.253_3306
Source Server Version : 50517
Source Host           : 192.168.0.253:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-05-04 18:15:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for porder
-- ----------------------------
DROP TABLE IF EXISTS `porder`;
CREATE TABLE `porder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `amount` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of porder
-- ----------------------------
INSERT INTO `porder` VALUES ('1', '1', '380');
INSERT INTO `porder` VALUES ('2', '2', '1500');
INSERT INTO `porder` VALUES ('3', '3', '2000');
INSERT INTO `porder` VALUES ('4', '3', '1000');
INSERT INTO `porder` VALUES ('5', '4', '200');
INSERT INTO `porder` VALUES ('6', '5', '500');
INSERT INTO `porder` VALUES ('7', '6', '800');
INSERT INTO `porder` VALUES ('8', '7', '1200');
