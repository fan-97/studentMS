/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : stus

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 26/04/2019 15:16:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for con_test
-- ----------------------------
DROP TABLE IF EXISTS `con_test`;
CREATE TABLE `con_test`  (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, '蔡徐坤', '女', '1888888888', '2019-04-04', '唱歌, 跳舞, 篮球', '我是练习时长两年半的蔡徐坤，我喜欢唱、跳、rap、篮球', '练习生001');
INSERT INTO `stu` VALUES (2, 'cxk', '男', '11111111', '2019-04-12', '唱歌, 跳舞', '111', 'cxk1');
INSERT INTO `stu` VALUES (5, '张三2', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (6, '张三3', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (7, '张三4', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (9, '张三5', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (10, '张三6', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (11, '张三7', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (12, '张三8', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (13, '张三9', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (14, '张三10', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (15, '张三11', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (16, '张三12', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (17, '张三13', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (18, '张三14', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (19, '张三15', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (20, '张三16', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (21, '张三17', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (22, '张三18', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (23, '张三19', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (24, '张三20', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (25, '张三21', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');
INSERT INTO `stu` VALUES (26, '张三21', '男', '155555555', '2018-11-16', '唱、跳、rap、篮球', '哈哈哈哈哈', '计科1641');

SET FOREIGN_KEY_CHECKS = 1;
