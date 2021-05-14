/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hs_db

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-12-17 09:31:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pn_admin_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pn_admin_menu`;
CREATE TABLE `pn_admin_menu` (
  `mid` bigint(20) NOT NULL,
  `menuname` varchar(20) DEFAULT NULL COMMENT '菜单名',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `url` varchar(200) DEFAULT NULL COMMENT '跳转链接',
  `show` int(2) DEFAULT '1' COMMENT '是否显示在导航,1显示,2不显示',
  `glyphicon` varchar(100) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据分析菜单';

-- ----------------------------
-- Records of pn_admin_menu
-- ----------------------------
INSERT INTO `pn_admin_menu` VALUES ('11', '管理中心', '0', '#', '1', 'el-icon-user');
INSERT INTO `pn_admin_menu` VALUES ('12', '模版管理', '0', '#', '1', 'el-icon-s-order');
INSERT INTO `pn_admin_menu` VALUES ('13', '广告管理', '0', '#', '1', 'el-icon-data-line');
INSERT INTO `pn_admin_menu` VALUES ('14', '游戏管理', '0', '#', '1', 'el-icon-timer');
INSERT INTO `pn_admin_menu` VALUES ('15', '合作公司管理', '0', '#', '1', 'el-icon-ship');
INSERT INTO `pn_admin_menu` VALUES ('16', '渠道版本', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('17', 'CP', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('18', '图书管理', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('19', '标签管理', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('20', '分类管理', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('21', '推荐管理', '0', '#', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('22', '认证管理', '0', '', '1', 'el-icon-setting');
INSERT INTO `pn_admin_menu` VALUES ('11001', '用户管理', '11', '/users', '1', 'glyphicon glyphicon-lock');
INSERT INTO `pn_admin_menu` VALUES ('11002', '菜单管理', '11', '/menus', '1', 'glyphicon glyphicon-lock');
INSERT INTO `pn_admin_menu` VALUES ('12001', '模版配置', '12', '/template/cfglist', '1', '');
INSERT INTO `pn_admin_menu` VALUES ('12002', '模版列表', '12', '/template/templatelist', '1', '');
INSERT INTO `pn_admin_menu` VALUES ('13001', '首页置顶广告', '13', '/banner/toplist', '1', '');
INSERT INTO `pn_admin_menu` VALUES ('13002', '首页分类广告', '13', '/banner/otherlist', '1', '');
INSERT INTO `pn_admin_menu` VALUES ('13003', '首页内容推荐', '21', '/recommend/recommendlist', '1', 'glyphicon glyphicon-hdd');
INSERT INTO `pn_admin_menu` VALUES ('14001', '游戏配置', '14', '/game/gamelist', '1', 'glyphicon glyphicon-eye-close');
INSERT INTO `pn_admin_menu` VALUES ('15001', '合作公司管理', '15', '/partner/list', '1', 'glyphicon glyphicon-send');
INSERT INTO `pn_admin_menu` VALUES ('15002', '合作公司订单管理', '15', '/partner/orderlist', '1', 'glyphicon glyphicon-record');
INSERT INTO `pn_admin_menu` VALUES ('16001', '渠道管理', '16', '/channel/list', '1', 'glyphicon glyphicon-screenshot');
INSERT INTO `pn_admin_menu` VALUES ('16002', '渠道分类管理', '16', '/channel/typelist', '1', 'glyphicon glyphicon-bullhorn');
INSERT INTO `pn_admin_menu` VALUES ('17001', 'CP查询', '17', '/cp/list', '1', 'glyphicon glyphicon-plane');
INSERT INTO `pn_admin_menu` VALUES ('18001', '图书列表', '18', '/book/booklist', '1', 'glyphicon glyphicon-bookmark');
INSERT INTO `pn_admin_menu` VALUES ('19001', '标签列表', '19', '/tag/taglist', '1', 'glyphicon glyphicon-tags');
INSERT INTO `pn_admin_menu` VALUES ('20001', '分类列表', '20', '/type/typelist', '1', 'glyphicon glyphicon-th');
INSERT INTO `pn_admin_menu` VALUES ('210005', '测试菜单444', '22', 'xxx', '1', 'el-icon-ship');

-- ----------------------------
-- Table structure for `pn_admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `pn_admin_user`;
CREATE TABLE `pn_admin_user` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id -1超级管理员 1管理员2普通用户3渠道',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `isvalid` int(2) DEFAULT '1' COMMENT '=1有效 =0无效',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建人',
  `menu_id` varchar(500) DEFAULT NULL COMMENT '菜单数组',
  `channels` varchar(1000) DEFAULT NULL COMMENT '渠道数组',
  `partners` varchar(1000) DEFAULT NULL,
  `remark` longtext COMMENT '备注',
  `head_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5556 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pn_admin_user
-- ----------------------------
INSERT INTO `pn_admin_user` VALUES ('1', 'i', 'aaa', null, '2020-11-12 17:42:16', null, '2', '7', null, null, null, 'ccc发发发', 'http://localhost:8080/img/01.png');
INSERT INTO `pn_admin_user` VALUES ('3', 'wangshaocheng', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-07-22 15:38:19', '2016-07-25 19:06:24', '0', '9', '11001,12001,13001,20,20001', null, null, '该账号停用', 'http://192.168.2.153:8080/img/headimg1.jpg');
INSERT INTO `pn_admin_user` VALUES ('7', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '-1', '2016-07-22 10:03:52', '2020-07-16 14:26:32', '1', null, null, null, null, null, 'http://localhost:8080/img/鐢佃剳.jpg');
INSERT INTO `pn_admin_user` VALUES ('8', 'ceshi001', 'd41d8cd98f00b204e9800998ecf8427e', '3', '2016-11-04 15:42:42', '2019-01-09 13:42:13', '2', '7', '11,11001,11002,12,12001,12002,13,13001,13002,15002', null, '1000067', '', 'http://localhost:8080/img/test0.jpg');
INSERT INTO `pn_admin_user` VALUES ('9', '测试1', 'abc123', '3', '2016-11-21 14:47:21', null, '1', '7', '11001,11002,12001,12002,12003,13001,14001,14002,15001,16001,16002,19001,19002,11,12,13,14,15,16', null, '1000067', '', 'logo/user1.png');
INSERT INTO `pn_admin_user` VALUES ('123', '3333', 'e10adc3949ba59abbe56e057f20f883e', null, '2020-11-12 17:57:23', null, '1', '9', null, null, null, '法尔', 'http://localhost:8080/img/02.png');
INSERT INTO `pn_admin_user` VALUES ('1235', '444', 'e10adc3949ba59abbe56e057f20f883e', null, '2020-11-12 18:04:00', null, '0', '9', null, null, null, '啊啊啊啊', 'http://localhost:8080/img/test.jpeg');
INSERT INTO `pn_admin_user` VALUES ('5555', '6666', 'e10adc3949ba59abbe56e057f20f883e', null, '2020-11-12 18:00:56', null, '1', '9', null, null, null, 'test', 'http://localhost:8080/img/鐢佃剳.jpg');
