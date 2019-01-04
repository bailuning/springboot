/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : bailuning

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2019-01-04 23:41:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小白', '1');
INSERT INTO `user` VALUES ('2', '小亮', '0');
