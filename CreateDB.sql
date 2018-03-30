/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-19 20:05:54
*/

create database online;
use online;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
`cid`  int(11) NOT NULL AUTO_INCREMENT ,
`cname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称' ,
PRIMARY KEY (`cid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=16

;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '大学英语'), ('2', '高等数学'), ('3', '数据结构'), ('4', '算法初级'), ('13', '大学物理'), ('14', '线性代数'), ('15', '美术');
COMMIT;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
`pid`  int(11) NOT NULL AUTO_INCREMENT ,
`testId`  int(11) NOT NULL ,
`courseId`  int(11) NOT NULL ,
`time`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`score`  double NULL DEFAULT NULL ,
`wrongQueIds`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`wrongAns`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`studentId`  int(11) NOT NULL ,
`createDate`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`pid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=15

;

-- ----------------------------
-- Records of paper
-- ----------------------------
BEGIN;
INSERT INTO `paper` VALUES ('5', '3', '13', '0分7秒', '2', '8', 'null', '2', '2018-01-16 17:50:55'), ('6', '6', '13', '0分3秒', '50', '8', 'A', '2', '2018-01-16 19:47:01'), ('14', '10', '13', '0分27秒', '50', '7', 'D', '2', '2018-01-19 14:36:16');
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
`qid`  int(11) NOT NULL AUTO_INCREMENT ,
`courseId`  int(11) NOT NULL ,
`queType`  int(11) NULL DEFAULT NULL ,
`queTitle`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`choiceA`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`choiceB`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`choiceC`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`choiceD`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ans`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`queExist`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`qid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=15

;

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('1', '1', '1', '哪个选项值最大', '1', '2', '3', '4', 'D', '0'), ('2', '1', '1', '哪个选项值最小', '1', '2', '3', '4', 'A', '0'), ('3', '15', '1', 'QAQrz是不是傻', '是的', '绝对是', '百分百是', '还用问', 'D', '0'), ('5', '3', '1', '最短路算法有', 'spfa', 'QAQ', 'Ninaye', 'QAQrz', 'A', '1'), ('6', '15', '1', 'QAQrz美不美', '美', '苍天', '滚', 'fuck', 'D', '0'), ('7', '13', '1', '时间的符号是', 'a', 'v', 't', 'km', 'C', '1'), ('8', '13', '1', '速度的符号是', 'a', 'v', 't', 'km', 'B', '1'), ('9', '13', '1', '加速度的符号是', 'a', 'v', 't', 'km', 'A', '1');
COMMIT;

-- ----------------------------
-- Table structure for stuclass
-- ----------------------------
DROP TABLE IF EXISTS `stuclass`;
CREATE TABLE `stuclass` (
`scid`  int(11) NOT NULL AUTO_INCREMENT ,
`scname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称' ,
`deptName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`scid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=17

;

-- ----------------------------
-- Records of stuclass
-- ----------------------------
BEGIN;
INSERT INTO `stuclass` VALUES ('1', '计科1503', '测试'), ('2', '计科1502', '测试'), ('3', '软件1501', '开发'), ('14', '软件1507', '开发'), ('16', '计科1504', '开发');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
`sid`  int(11) NOT NULL AUTO_INCREMENT ,
`sname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`spwd`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`school`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`sex`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`born`  date NOT NULL ,
`classId`  int(11) NOT NULL ,
PRIMARY KEY (`sid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('2', '张亮', 'ninaye', '计算机', '男', '2018-01-21', '2'), ('5', 'QAQrz', 'ninaye', '计算机', '女', '2018-01-01', '2');
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
`tid`  int(11) NOT NULL AUTO_INCREMENT ,
`tname`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名' ,
`tpwd`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师密码' ,
`deptName`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`tid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=12

;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1', '刘晓红', 'lxh666', '测试'), ('2', '张先伟', 'zxw666', '开发'), ('9', '张立红', 'zlh666', '开发'), ('10', '崔鑫', 'ninaye', '测试');
COMMIT;

-- ----------------------------
-- Table structure for teachercourse
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
`tcId`  int(11) NOT NULL AUTO_INCREMENT ,
`tcCourseId`  int(11) NOT NULL ,
`tcTeacherId`  int(11) NOT NULL ,
`tcStuClassId`  int(11) NOT NULL ,
PRIMARY KEY (`tcId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=18

;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
BEGIN;
INSERT INTO `teachercourse` VALUES ('13', '16', '9', '14'), ('15', '13', '1', '2'), ('16', '4', '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`courseId`  int(11) NOT NULL ,
`endDate`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`testTime`  int(11) NOT NULL ,
`questions`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`teacherId`  int(11) NOT NULL ,
`classIds`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`scores`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=12

;

-- ----------------------------
-- Records of test
-- ----------------------------
BEGIN;
INSERT INTO `test` VALUES ('3', 'Ninaye之大物修炼', '13', '2018-01-02 16:03:52', '11', '7,9,8', '1', '2,1', '3'), ('5', 'Ninaye', '13', '2018-01-20 15:54:08', '1', '8,9,7', '1', '1', '100'), ('6', 'QAQrz', '13', '2018-01-28 15:54:10', '1', '8,9', '1', '2,1', '100'), ('7', '绝地大物杀', '13', '2018-01-31 19:50:02', '45', '9,7,8', '1', '2', '100'), ('8', '1', '13', '2018-01-01 21:03:44', '45', '9', '1', '2,1', '1'), ('10', '大物进阶测试', '13', '2018-01-28 00:00:00', '50', '7,8', '1', '2,1', '100'), ('11', '每天一练', '13', '2018-01-28 00:00:00', '11', '7,8,9', '1', '2', '90');
COMMIT;

-- ----------------------------
-- Auto increment value for course
-- ----------------------------
ALTER TABLE `course` AUTO_INCREMENT=16;

-- ----------------------------
-- Auto increment value for paper
-- ----------------------------
ALTER TABLE `paper` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for question
-- ----------------------------
ALTER TABLE `question` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for stuclass
-- ----------------------------
ALTER TABLE `stuclass` AUTO_INCREMENT=17;

-- ----------------------------
-- Auto increment value for student
-- ----------------------------
ALTER TABLE `student` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for teacher
-- ----------------------------
ALTER TABLE `teacher` AUTO_INCREMENT=12;

-- ----------------------------
-- Auto increment value for teachercourse
-- ----------------------------
ALTER TABLE `teachercourse` AUTO_INCREMENT=18;

-- ----------------------------
-- Auto increment value for test
-- ----------------------------
ALTER TABLE `test` AUTO_INCREMENT=12;
