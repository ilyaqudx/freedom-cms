/*
Navicat MySQL Data Transfer

Source Server         : localhost5.7.9
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : freedom-cms

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-05-04 08:35:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `name` varchar(100) NOT NULL,
  `resource_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '会员管理', '1', '1', '2017-05-04 00:19:52', null);
INSERT INTO `menu` VALUES ('2', '1', '会员列表', '2', '1', '2017-05-04 00:20:13', null);
INSERT INTO `menu` VALUES ('3', '1', '会员注册', '3', '1', '2017-05-04 01:20:30', null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '资源名称',
  `parentId` bigint(20) NOT NULL DEFAULT '0' COMMENT '父资源ID,如果没有则为0',
  `path` varchar(255) DEFAULT NULL COMMENT '路径,如果没有则为NULL',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '会员管理', '0', '/admin/vip', '2017-05-04 00:11:20');
INSERT INTO `resource` VALUES ('2', '会员列表', '1', '/admin/vip/list', '2017-05-04 00:12:02');
INSERT INTO `resource` VALUES ('3', '会员注册', '1', '/admin/vip/add', '2017-05-04 00:12:30');
INSERT INTO `resource` VALUES ('4', '会员删除', '1', '/admin/vip/del', '2017-05-04 00:12:54');
INSERT INTO `resource` VALUES ('5', '会员信息更新', '1', '/admin/vip/update', '2017-05-04 00:13:27');
INSERT INTO `resource` VALUES ('10000', '主页', '0', '/', '2017-05-04 02:07:15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '超级管理员', '2017-05-04 00:07:13', '1');
INSERT INTO `role` VALUES ('2', '高级管理员', '高级管理员', '2017-05-04 00:07:55', '2');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  `resource_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1');
INSERT INTO `role_resource` VALUES ('1', '2');
INSERT INTO `role_resource` VALUES ('1', '3');
INSERT INTO `role_resource` VALUES ('1', '4');
INSERT INTO `role_resource` VALUES ('1', '5');
INSERT INTO `role_resource` VALUES ('1', '10000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `identityCode` varchar(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', 'abcd', '0', '2017-05-03 12:48:52');
INSERT INTO `user` VALUES ('2', 'zhangsan', 'abcd', '0', '2017-05-04 01:37:59');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
