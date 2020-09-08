/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : zyz

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2020-05-16 14:32:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `aid` int(10) NOT NULL AUTO_INCREMENT COMMENT '活动唯一ID',
  `TYPEs` int(1) DEFAULT '0' COMMENT '活动类型0为新闻动态1为志愿活动',
  `title` varchar(500) DEFAULT NULL COMMENT '活动名称',
  `problem` varchar(3000) DEFAULT '' COMMENT '活动描述',
  `createtime` datetime DEFAULT NULL COMMENT '活动创建时间',
  `starttime` datetime DEFAULT NULL COMMENT '活动开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '活动报名结束时间',
  `STATUS` int(1) DEFAULT '1' COMMENT '活动状态0为结束 1为开始',
  `gname` varchar(20) DEFAULT NULL COMMENT '发布者',
  `maxnum` int(5) DEFAULT NULL COMMENT '限制录取人数',
  `signnum` int(5) DEFAULT '0' COMMENT '已经录取人数',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('2', '1', '凡人善举·情暖中国', '植树活动', '2020-04-17 11:32:05', '2020-04-17 11:32:08', '2020-04-17 11:32:09', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('24', '1', '凡人善举·情暖中国', '常家有说，开展学雷锋志愿服务活动，是巩固和深化全国文明城市创建成果，深入推进精神文明建设的重要举措。广泛深入开展学雷锋志愿服务活动，对促进社会主义核心价值体系建设具有重要意义。传承和发扬雷锋精神，是时代所需、社会所盼、人民所愿。我们要积极促进学雷锋志愿服务活动常态化、制度化。要着眼基层，务求实效，长期坚持开展，扎实深入推进，全面汇聚志愿服务正能量，不断提升志愿服务新水平，为建设繁荣、文明、和谐、现代金昌，宜居、宜业、宜游幸福家园做出更大的贡献。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('25', '1', '凡人善举·情暖中国', '常家有说，开展学雷锋志愿服务活动，是巩固和深化全国文明城市创建成果，深入推进精神文明建设的重要举措。广泛深入开展学雷锋志愿服务活动，对促进社会主义核心价值体系建设具有重要意义。传承和发扬雷锋精神，是时代所需、社会所盼、人民所愿。我们要积极促进学雷锋志愿服务活动常态化、制度化。要着眼基层，务求实效，长期坚持开展，扎实深入推进，全面汇聚志愿服务正能量，不断提升志愿服务新水平，为建设繁荣、文明、和谐、现代金昌，宜居、宜业、宜游幸福家园做出更大的贡献。', '2020-04-22 00:00:00', '2020-03-31 00:00:00', '2020-04-20 00:00:00', '1', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('26', '1', '凡人善举·情暖中国', '常家有说，开展学雷锋志愿服务活动，是巩固和深化全国文明城市创建成果，深入推进精神文明建设的重要举措。广泛深入开展学雷锋志愿服务活动，对促进社会主义核心价值体系建设具有重要意义。传承和发扬雷锋精神，是时代所需、社会所盼、人民所愿。我们要积极促进学雷锋志愿服务活动常态化、制度化。要着眼基层，务求实效，长期坚持开展，扎实深入推进，全面汇聚志愿服务正能量，不断提升志愿服务新水平，为建设繁荣、文明、和谐、现代金昌，宜居、宜业、宜游幸福家园做出更大的贡献。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('27', '1', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('28', '1', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-01 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '1', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('29', '1', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-01 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '1', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('30', '1', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '1', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('31', '1', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('32', '0', '凡人善举·情暖中国', '据了解，“凡人善举·情暖金昌”学雷锋志愿服务月活动以社会主义核心价值观为引领，以关爱他人、关爱社会、关爱自然为主要内容，旨在培育志愿服务文化，提高公民思想道德素质和社会文明程度。在为期一个月的服务活动中,我市将主要开展“爱心在行动”学雷锋志愿服务、“关爱在巾帼”学雷锋志愿服务、“雷锋在身边”学雷锋志愿服务、“绿色在家园”学雷锋志愿服务和“文明在窗口”学雷锋志愿服务等活动。', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '2020-04-22 00:00:00', '0', 'admin', '1', '1', '/hdpic/fdd4d5b10ae54294a9d659762757e4f3.jpg');
INSERT INTO `activity` VALUES ('78', '1', '五一活动', '植树', '2020-04-27 00:00:00', '2020-04-27 00:00:00', '2020-04-27 00:00:00', '1', 'admin', '12', '0', '/hdpic/459d597a975e4a878d301dd2ce2858a2.jpg');

-- ----------------------------
-- Table structure for juser
-- ----------------------------
DROP TABLE IF EXISTS `juser`;
CREATE TABLE `juser` (
  `jid` int(10) NOT NULL AUTO_INCREMENT COMMENT '街道管理员ID',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `jname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `email` varchar(20) NOT NULL COMMENT '邮箱作为登录账号',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话号码',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别0为女 1为男',
  `jissys` int(1) DEFAULT '1' COMMENT '账号状态，0为封禁',
  PRIMARY KEY (`jid`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`),
  UNIQUE KEY `email_3` (`email`),
  UNIQUE KEY `email_4` (`email`),
  UNIQUE KEY `email_5` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of juser
-- ----------------------------
INSERT INTO `juser` VALUES ('1', '123', '张三', '20', '121@qq.com', '110', '1', '1');
INSERT INTO `juser` VALUES ('2', '123', '李四', '20', '2121@qq.com', '110', '1', '1');
INSERT INTO `juser` VALUES ('9', '123', '213', '32', '213@qq.com', '120', '1', '0');

-- ----------------------------
-- Table structure for root
-- ----------------------------
DROP TABLE IF EXISTS `root`;
CREATE TABLE `root` (
  `rid` int(10) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(20) DEFAULT NULL,
  `rname` varchar(20) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of root
-- ----------------------------
INSERT INTO `root` VALUES ('1', '123', 'admin', '110@qq.com', '110');
INSERT INTO `root` VALUES ('3', '123', 'lisi', '111@qq.com', '112');
INSERT INTO `root` VALUES ('61', '123', '张三', '2121@qq.com', '110');

-- ----------------------------
-- Table structure for scores
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores` (
  `sid` int(20) NOT NULL AUTO_INCREMENT COMMENT '积分ID',
  `aid` int(10) DEFAULT NULL COMMENT '活动ID',
  `jid` int(10) DEFAULT NULL COMMENT '街道管理员ID',
  `uid` int(10) DEFAULT NULL COMMENT '志愿者ID',
  `ustatus` int(1) DEFAULT '0' COMMENT '报名状态:0为待审核,1为已录取,2已完成(已签到)',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scores
-- ----------------------------
INSERT INTO `scores` VALUES ('1', '1', '1', '1', '2');
INSERT INTO `scores` VALUES ('2', '1', '1', '2', '2');
INSERT INTO `scores` VALUES ('3', '2', '1', '3', '0');
INSERT INTO `scores` VALUES ('5', '2', '2', '2', '2');
INSERT INTO `scores` VALUES ('9', '24', '2', '2', '0');
INSERT INTO `scores` VALUES ('10', '2', '1', '45', '0');
INSERT INTO `scores` VALUES ('11', '80', '1', '45', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(15) NOT NULL AUTO_INCREMENT COMMENT '志愿者ID',
  `uname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别0为女 1为男',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `email` varchar(20) NOT NULL COMMENT '邮箱作为登录账号',
  `jid` int(10) DEFAULT NULL COMMENT '所属街道管理员',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `score` int(6) DEFAULT '0' COMMENT '志愿者积分 默认0',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `address` varchar(20) DEFAULT NULL COMMENT '居住地址',
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `uissys` int(1) DEFAULT '0' COMMENT '账号状态 0未审核',
  `regtime` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '0', '123', 'zhangsan@qq.com', '1', '1', '1', '119', '天津', '111111222233334444', '0', '2020-03-01 00:00:00');
INSERT INTO `user` VALUES ('2', '李四', '1', '12', '1@qq.com', '2', '12', '1', '13311111111', '北京', '11111111111111', '1', '2020-03-01 00:00:00');
INSERT INTO `user` VALUES ('8', '王五', '1', '123', '11@qq.com', '3', '22', '0', '11111111111', '上海', '111111111111111111', '0', '2020-03-01 00:00:00');
INSERT INTO `user` VALUES ('43', '王五', '1', '123123', '111@qq.com', '1', '21', '0', '13333333333', '天津静海', '111111111111111111', '0', '2020-05-13 19:10:01');
INSERT INTO `user` VALUES ('44', '张三', '1', '123123', '121@qq.com', '1', '21', '0', '13311112222', '天津静海', '111111222233334444', '1', '2020-05-15 08:13:14');
INSERT INTO `user` VALUES ('45', '张三', '1', '123123', '22@qq.com', '1', '21', '0', '13322221111', '天津静海', '399999111122221111', '1', '2020-05-15 10:20:38');
