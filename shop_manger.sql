/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : shop_manger

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 28/10/2020 20:37:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `bid` int(255) NOT NULL AUTO_INCREMENT,
  `cashier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productNum` int(255) NULL DEFAULT NULL,
  `productPrice` float(255, 0) NULL DEFAULT NULL,
  `productmoney` float(255, 0) NULL DEFAULT NULL,
  `billDate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  INDEX `for_cashier`(`cashier`) USING BTREE,
  INDEX `for_proprice`(`productPrice`) USING BTREE,
  INDEX `for_proName`(`productName`) USING BTREE,
  CONSTRAINT `for_cashier` FOREIGN KEY (`cashier`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `for_proName` FOREIGN KEY (`productName`) REFERENCES `reserve` (`R_name`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `for_proprice` FOREIGN KEY (`productPrice`) REFERENCES `reserve` (`R_out_price`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, 'mm', '牛奶', 1, 2, 2, '2020-09-25 00:25:00');
INSERT INTO `bill` VALUES (2, 'mm', '面包', 2, 4, 8, '2020-09-24 16:56:40');
INSERT INTO `bill` VALUES (3, 'zmf', '泡面', 3, 2, 6, '2020-09-16 16:57:15');
INSERT INTO `bill` VALUES (6, 'admin', '牛奶', 12, 2, 24, '2020-09-26 19:55:58');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `R_id` int(255) NOT NULL AUTO_INCREMENT,
  `R_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `R_num` int(11) NULL DEFAULT NULL,
  `R_in_price` float(10, 2) NULL DEFAULT NULL,
  `R_out_price` float(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`R_id`, `R_name`) USING BTREE,
  INDEX `R_name`(`R_name`) USING BTREE,
  INDEX `R_out_price`(`R_out_price`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES (1, '泡面', 50, 3.00, 4.00);
INSERT INTO `reserve` VALUES (2, '牛奶', 30, 1.20, 2.00);
INSERT INTO `reserve` VALUES (3, '面包', 35, 1.50, 2.00);
INSERT INTO `reserve` VALUES (4, '饮料', 40, 2.00, 2.50);
INSERT INTO `reserve` VALUES (5, '水果', 100, 2.00, 3.00);
INSERT INTO `reserve` VALUES (9, 'Mac', 100, 2.00, 2.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(20) NULL DEFAULT NULL,
  `tel` int(20) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `issupper` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'root', '1', 19, 00000000000123456789, '819277@qq.com', 'c', '2');
INSERT INTO `user` VALUES (2, 'xx', '123123', '0', 11, 00000000000123123123, '123123', 'qweasdzxc', '1');
INSERT INTO `user` VALUES (3, 'zmf', '123456', '0', 11, 00000000001234567891, '1335476765@qq.com', 'database', '1');
INSERT INTO `user` VALUES (4, 'mm', '654321', '1', 11, 00000000000123123123, '123.com', 'computer', '0');
INSERT INTO `user` VALUES (5, 'oo', '123456', '0', 12, 00000000000111111111, '11111.com', 'asdasfasd', '0');

SET FOREIGN_KEY_CHECKS = 1;
