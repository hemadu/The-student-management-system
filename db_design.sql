/*
Navicat MySQL Data Transfer

Source Server         : mysql2
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : db_design

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2023-11-15 16:04:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) DEFAULT NULL COMMENT '用户ID',
  `price` double DEFAULT NULL COMMENT '价格',
  `type` int(4) DEFAULT NULL COMMENT '类别0餐饮美食、1服装美容、2生活日用、3交通出行、4休闲娱乐',
  `role` int(4) DEFAULT NULL COMMENT '0支出1收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '5', '288', '0', '0');
INSERT INTO `account` VALUES ('2', '5', '288', '1', '0');
INSERT INTO `account` VALUES ('3', '5', '288', '2', '0');
INSERT INTO `account` VALUES ('4', '5', '288', '0', '1');
INSERT INTO `account` VALUES ('6', '5', '111', '0', '0');
INSERT INTO `account` VALUES ('7', '5', '111', '0', '0');
INSERT INTO `account` VALUES ('8', '6', '111', '0', '0');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `tid` int(4) DEFAULT NULL COMMENT '老师ID',
  `sid` int(4) DEFAULT NULL COMMENT '学生ID',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `reply` varchar(5000) DEFAULT NULL COMMENT '回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2', '4', '阿巴阿巴1', '111111111111');
INSERT INTO `comment` VALUES ('2', '2', '5', '阿巴阿巴2<p><br></p>', '回复2');
INSERT INTO `comment` VALUES ('3', '3', '6', '阿巴阿巴3', '333');
INSERT INTO `comment` VALUES ('4', '2', '4', '<p>1111</p>', null);
INSERT INTO `comment` VALUES ('5', '2', '5', '<p>1111</p>', null);
INSERT INTO `comment` VALUES ('6', '2', '4', '<p>问卷调查</p>', null);
INSERT INTO `comment` VALUES ('7', '2', '5', '<p>问卷调查</p>', null);
INSERT INTO `comment` VALUES ('8', '2', '4', '<p>发布问卷</p>', null);
INSERT INTO `comment` VALUES ('9', '2', '5', '<p>发布问卷</p>', null);
INSERT INTO `comment` VALUES ('10', '2', '4', '<p>发布问卷</p>', null);
INSERT INTO `comment` VALUES ('11', '2', '5', '<p>发布问卷</p>', null);
INSERT INTO `comment` VALUES ('12', '2', '4', '<p>问卷调查</p>', null);
INSERT INTO `comment` VALUES ('13', '2', '5', '<p>问卷调查</p>', null);
INSERT INTO `comment` VALUES ('14', '2', '4', '<p>1111</p>', null);
INSERT INTO `comment` VALUES ('15', '2', '5', '<p>1111</p>', null);
INSERT INTO `comment` VALUES ('16', '8', null, '<p>1111</p>', null);
INSERT INTO `comment` VALUES ('17', '8', '5', '<p>1111</p>', null);

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `uid` int(4) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `score` varchar(255) DEFAULT NULL COMMENT '成绩',
  `type` int(4) DEFAULT NULL COMMENT '类别0是学科成绩，1是获得的奖状，2是获得的证书',
  `role` int(4) DEFAULT NULL COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('1', '', '4', '数学', '100', '0', '0');
INSERT INTO `data` VALUES ('2', '', '4', '英语', '90', '0', '0');
INSERT INTO `data` VALUES ('3', '', '4', '暑期社会实践', null, '1', '1');
INSERT INTO `data` VALUES ('5', '1.jpg', '6', '笔记本', '1001', '0', '0');
INSERT INTO `data` VALUES ('6', 'logout.png', '5', '语文', '100', '0', '0');

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) DEFAULT NULL COMMENT '用户ID',
  `fid` int(4) DEFAULT NULL COMMENT '朋友ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------
INSERT INTO `friends` VALUES ('1', '4', '2');
INSERT INTO `friends` VALUES ('2', '5', '2');
INSERT INTO `friends` VALUES ('3', '4', '5');
INSERT INTO `friends` VALUES ('5', '5', '6');
INSERT INTO `friends` VALUES ('9', '5', '3');
INSERT INTO `friends` VALUES ('10', '3', '4');
INSERT INTO `friends` VALUES ('11', '3', '6');
INSERT INTO `friends` VALUES ('12', '2', '6');
INSERT INTO `friends` VALUES ('13', '6', '4');
INSERT INTO `friends` VALUES ('14', '6', '2');
INSERT INTO `friends` VALUES ('15', '6', '3');
INSERT INTO `friends` VALUES ('16', '6', '5');
INSERT INTO `friends` VALUES ('17', '6', '6');
INSERT INTO `friends` VALUES ('18', '6', '3');
INSERT INTO `friends` VALUES ('19', '2', '5');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `tid` int(4) DEFAULT NULL COMMENT '老师ID',
  `sid` int(4) DEFAULT NULL COMMENT '学生ID',
  `grade` varchar(255) DEFAULT NULL COMMENT '年级',
  `name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '2', '4', '1', '计算机1班');
INSERT INTO `grade` VALUES ('3', '8', null, '1', '笔记本1');
INSERT INTO `grade` VALUES ('4', '8', '5', '1', '笔记本1');
INSERT INTO `grade` VALUES ('5', '9', null, '1', '1');

-- ----------------------------
-- Table structure for grow
-- ----------------------------
DROP TABLE IF EXISTS `grow`;
CREATE TABLE `grow` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) DEFAULT NULL COMMENT '用户ID',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `date` varchar(255) DEFAULT NULL COMMENT '日期',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类别',
  `role` int(4) DEFAULT NULL COMMENT '是否公开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grow
-- ----------------------------
INSERT INTO `grow` VALUES ('1', '5', '1.jpg', '2022-3-19', '我的奋斗', '阿巴巴1<p><br></p>', '日记', '1');
INSERT INTO `grow` VALUES ('2', '5', '4.jpg', '2022-3-19', '我的奋斗', '阿巴巴2', '1', '0');
INSERT INTO `grow` VALUES ('3', '5', '3.jpg', '2022-3-19', '我的奋斗', '阿巴巴3', '0', '1');
INSERT INTO `grow` VALUES ('4', '5', '1.jpg', '2022-3-19', '我的奋斗', '<p>aa</p>', '日记', '0');
INSERT INTO `grow` VALUES ('5', '5', '1.jpg', '2022-3-19', '我的奋斗', '<p>aa</p>', '日记', '0');
INSERT INTO `grow` VALUES ('6', '5', '1.jpg', '2022-3-19', '我的奋斗', '<p>aa</p>', '日记', '0');
INSERT INTO `grow` VALUES ('7', '6', '1.png', '2022-3-19', '斗1119', '<p>111</p>', '日记', '1');
INSERT INTO `grow` VALUES ('8', '4', 'ins10.jpg', '2022-04-19', '図書館で勉強しています', '<p><span style=\"font-weight: bold;\">今</span>日は図書館で勉強しています、とても楽しいです<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"></p>', '成长相册', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) DEFAULT NULL COMMENT '用户ID',
  `lid` int(4) DEFAULT NULL COMMENT '留言者Id',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '2', '4', '阿巴阿巴1', '2022-4-19');
INSERT INTO `message` VALUES ('2', '4', '2', '阿巴阿巴2', '2022-4-19');
INSERT INTO `message` VALUES ('5', '4', '2', '好你个阿巴怪', '2022-4-19 11:16:45');
INSERT INTO `message` VALUES ('7', '5', '2', '我要留言', '2022-4-19 12:14:10');
INSERT INTO `message` VALUES ('8', '5', '2', '我要留言', '2022-4-19 12:21:36');
INSERT INTO `message` VALUES ('9', '5', '2', '111', '2022-4-19 12:53:29');
INSERT INTO `message` VALUES ('10', '2', '5', '好的呢 李老师', '2022-4-19 12:58:26');
INSERT INTO `message` VALUES ('11', '2', '5', '好的呢 李老师', '2022-4-19 12:59:08');
INSERT INTO `message` VALUES ('12', '2', '5', '111', '2022-4-19 01:06:30');
INSERT INTO `message` VALUES ('13', '5', '2', '留言7 16:21', '2022-4-19 04:21:50');
INSERT INTO `message` VALUES ('14', '5', '2', '16:24  第7条留言', '2022-4-19 04:24:25');
INSERT INTO `message` VALUES ('15', '2', '5', '16:26 第8条留言', '2022-4-19 04:26:47');
INSERT INTO `message` VALUES ('16', '6', '2', '16:29 第1条留言', '2022-4-19 04:29:26');
INSERT INTO `message` VALUES ('17', '2', '6', '16:29 第2条留言', '2022-4-19 04:30:04');
INSERT INTO `message` VALUES ('18', '3', '5', '111', '2020-10-10 04:45:19');
INSERT INTO `message` VALUES ('19', '4', '3', '我是3 给4 留言', '2020-10-10 04:49:46');
INSERT INTO `message` VALUES ('20', '3', '4', '收到', '2020-10-10 04:50:09');
INSERT INTO `message` VALUES ('21', '6', '3', '留言', '2020-10-10 04:50:50');
INSERT INTO `message` VALUES ('22', '1', '4', '10/24', '2020-10-24 09:12:03');
INSERT INTO `message` VALUES ('23', '4', '1', '11111', '2020-10-24 09:15:07');
INSERT INTO `message` VALUES ('24', '1', '4', '10/24456+123', '2020-10-24 09:28:51');
INSERT INTO `message` VALUES ('25', '1', '5', '111', '2020-10-25 17:20:12');
INSERT INTO `message` VALUES ('26', '2', '6', '我要留言', '2020-11-30 22:00:14');
INSERT INTO `message` VALUES ('27', '3', '6', '我要留言', '2020-11-30 22:00:52');
INSERT INTO `message` VALUES ('28', '6', '2', 'こんにちは', '2023-11-14 19:58:31');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) DEFAULT NULL COMMENT '用户Id',
  `year` varchar(255) DEFAULT NULL COMMENT '第几学年',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `type` int(4) DEFAULT NULL COMMENT '类别0自我评价1自我反思',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '5', '第一学年一学期', '阿巴阿巴1', '0');
INSERT INTO `plan` VALUES ('2', '5', '第一学年二学期', '阿巴阿巴2', '1');
INSERT INTO `plan` VALUES ('3', '5', '第二学年一学期', '阿巴阿巴3', '0');
INSERT INTO `plan` VALUES ('4', '4', '11', '<p>111</p>', '0');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `pic` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` int(4) DEFAULT NULL COMMENT '管理员权限0管理员1老师2学生',
  `isdel` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '隆冬呛', '男', '20', '3.png', '13712345678', 'admin', 'admin', '0', '0');
INSERT INTO `users` VALUES ('2', '张老师', '女', '40', '1.png', '13712345678', '111', '111', '1', '0');
INSERT INTO `users` VALUES ('3', '王老师', '女', '40', '1.png', '13712345678', '222', '222', '1', '0');
INSERT INTO `users` VALUES ('4', '张三', '男', '20', '4.png', '13712345678', '333', '333', '2', '0');
INSERT INTO `users` VALUES ('5', '李四', '男', '22', '1.png', '13712345678', '444', '444', '2', '0');
INSERT INTO `users` VALUES ('6', '王五', '女', '25', '3.png', '13412345678', '555', '555', '2', '0');
INSERT INTO `users` VALUES ('7', '王五', '女', '25', '3.png', '13412345678', '666', '666', '2', '1');
INSERT INTO `users` VALUES ('8', '777', '男', '777', '1.png', '777', '777', '777', '1', '0');
INSERT INTO `users` VALUES ('9', '777', '男', '777', 'BingWallpaper.jpg', '66666', '666', '666', '1', '0');
