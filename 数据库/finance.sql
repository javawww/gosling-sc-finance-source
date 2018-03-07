/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : finance

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-02-28 22:57:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bonus
-- ----------------------------
DROP TABLE IF EXISTS `t_bonus`;
CREATE TABLE `t_bonus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jsTime` datetime DEFAULT NULL,
  `layerBonus` decimal(30,9) DEFAULT NULL,
  `tjrBonus` decimal(30,9) DEFAULT NULL,
  `totalBonus` decimal(30,9) DEFAULT NULL,
  `memNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bonus
-- ----------------------------
INSERT INTO `t_bonus` VALUES ('33', '2017-08-22 21:40:32', '50.000000000', '400.000000000', '250.000000000', 'admin');

-- ----------------------------
-- Table structure for t_bonus_inf
-- ----------------------------
DROP TABLE IF EXISTS `t_bonus_inf`;
CREATE TABLE `t_bonus_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bonusDesc` varchar(255) DEFAULT NULL,
  `bonusStatus` tinyint(4) DEFAULT NULL,
  `bonusType` tinyint(4) DEFAULT NULL,
  `bonusSalar` decimal(30,9) DEFAULT NULL,
  `bonusTime` datetime DEFAULT NULL,
  `bonusId` int(11) DEFAULT NULL,
  `memNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bonus_inf
-- ----------------------------
INSERT INTO `t_bonus_inf` VALUES ('225', '会员:111111被激活时获得的推荐奖', '2', '2', '200.000000000', '2017-08-22 21:40:32', '33', 'admin');
INSERT INTO `t_bonus_inf` VALUES ('226', '会员111111激活获得的层奖收益', '2', '1', '50.000000000', '2017-08-22 21:40:32', '33', 'admin');

-- ----------------------------
-- Table structure for t_currency_info
-- ----------------------------
DROP TABLE IF EXISTS `t_currency_info`;
CREATE TABLE `t_currency_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dynWallet` decimal(30,9) DEFAULT NULL COMMENT '动态钱包',
  `statDJWallet` decimal(30,9) DEFAULT NULL COMMENT '静态冻结钱包',
  `statJDWallet` decimal(30,9) DEFAULT NULL COMMENT '静态解冻钱包',
  `seedsPenn` decimal(30,9) DEFAULT NULL COMMENT '种子积分',
  `manaMoney` decimal(30,9) DEFAULT NULL COMMENT '管家月俸',
  `kidMoney` decimal(30,9) DEFAULT NULL COMMENT '神童日俸',
  `memNum` varchar(255) DEFAULT NULL COMMENT '关联用户编码',
  `memid` int(11) DEFAULT NULL COMMENT '关联用户主键ID',
  `activPenn` decimal(30,9) DEFAULT NULL COMMENT '激活积分',
  `teamPoints` decimal(30,9) DEFAULT NULL,
  `crashPoints` decimal(30,9) DEFAULT NULL,
  `totalAssets` decimal(30,9) DEFAULT NULL,
  `availlableAssets` decimal(30,9) DEFAULT NULL,
  `frozenAssets` decimal(30,9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COMMENT='所有币种信息  关联用户   一对一';

-- ----------------------------
-- Records of t_currency_info
-- ----------------------------
INSERT INTO `t_currency_info` VALUES ('1', '500000.000000000', '500000.000000000', '500000.000000000', '500000.000000000', '500000.000000000', '500000.000000000', 'admin', '1', '101860.000000000', '50.000000000', '600.000000000', null, null, null);
INSERT INTO `t_currency_info` VALUES ('71', null, null, null, null, null, null, '111111', '265', '1100.000000000', '0.000000000', '0.000000000', null, null, null);
INSERT INTO `t_currency_info` VALUES ('72', null, null, null, null, null, null, '222222', '266', '0.000000000', '0.000000000', '0.000000000', null, null, null);
INSERT INTO `t_currency_info` VALUES ('73', null, null, null, null, null, null, '33333333', '267', '0.000000000', '0.000000000', '0.000000000', null, null, null);
INSERT INTO `t_currency_info` VALUES ('74', null, null, null, null, null, null, '66666666666', '268', '0.000000000', '0.000000000', '0.000000000', null, null, null);

-- ----------------------------
-- Table structure for t_db
-- ----------------------------
DROP TABLE IF EXISTS `t_db`;
CREATE TABLE `t_db` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_db
-- ----------------------------

-- ----------------------------
-- Table structure for t_emsg
-- ----------------------------
DROP TABLE IF EXISTS `t_emsg`;
CREATE TABLE `t_emsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `msgSubject` varchar(255) DEFAULT NULL COMMENT '邮件主题 邮件标题',
  `msgContent` text COMMENT '邮件正文 邮件内容 html编辑器',
  `sendid` int(11) DEFAULT NULL COMMENT '外键 关联发件人 当前登录用户',
  `receids` varchar(255) DEFAULT NULL COMMENT '外键 关联收件人 一或多个 示例1,2,3 发送至 张三,李四,王五',
  `sendTime` datetime DEFAULT NULL COMMENT '发送时间',
  `msgStatus` int(11) DEFAULT NULL COMMENT '查看状态 0未读邮件 1已读邮件',
  `msgType` tinyint(4) DEFAULT NULL COMMENT '邮件类型 0注册问题 1安全问题 2账号问题3交易问题 4其他问题',
  `memNum` varchar(255) DEFAULT NULL COMMENT '编辑该邮件的会员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件管理 前台用户和后台管理员可以通过邮件中心进行信息通讯';

-- ----------------------------
-- Records of t_emsg
-- ----------------------------

-- ----------------------------
-- Table structure for t_information
-- ----------------------------
DROP TABLE IF EXISTS `t_information`;
CREATE TABLE `t_information` (
  `id` int(11) NOT NULL COMMENT '主键',
  `infNum` tinyint(11) DEFAULT NULL COMMENT '新闻编号',
  `infType` tinyint(11) DEFAULT NULL COMMENT '新闻类别  1普通公告 2活动公告 3其他公告',
  `infTitle` varchar(255) DEFAULT NULL COMMENT '新闻标题',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `pubTime` datetime DEFAULT NULL COMMENT '发布时间  ',
  `infContent` text COMMENT '新闻内容 html编辑器控制',
  `memid` int(11) DEFAULT NULL COMMENT '外键 关联当前管理员',
  `memNum` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_information
-- ----------------------------
INSERT INTO `t_information` VALUES ('1', null, '1', '44444444444444', '2017-08-29 13:40:54', '2017-08-29 00:00:00', '<p>1451151414151541541515</p>', '1', 'admin');
INSERT INTO `t_information` VALUES ('2', null, '1', 'asdasdas', '2017-08-29 14:24:45', '2017-08-29 00:00:00', '<p>dasdasdasasdsadasda</p>', '1', 'admin');
INSERT INTO `t_information` VALUES ('3', null, null, 'adasdasd', '2017-08-29 15:55:58', '1899-12-26 00:00:00', '<p>asdasdasdasd</p>', '1', 'admin');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `memberNum` varchar(255) DEFAULT NULL,
  `layerBonus` decimal(30,9) DEFAULT NULL,
  `tjrBonus` decimal(30,9) DEFAULT NULL,
  `activeBonus` decimal(30,9) DEFAULT NULL,
  `totalBonus` decimal(30,9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('33', '2017-08-22 21:40:32', 'admin', '50.000000000', '400.000000000', '208640.000000000', '104570.000000000');

-- ----------------------------
-- Table structure for t_log_inf
-- ----------------------------
DROP TABLE IF EXISTS `t_log_inf`;
CREATE TABLE `t_log_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `currencyType` tinyint(4) DEFAULT NULL,
  `salary` decimal(30,9) DEFAULT NULL,
  `origSalary` decimal(30,9) DEFAULT NULL,
  `preSalary` decimal(30,9) DEFAULT NULL,
  `optDesc` varchar(255) DEFAULT NULL,
  `memNum` varchar(255) DEFAULT NULL,
  `logPid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=282 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log_inf
-- ----------------------------
INSERT INTO `t_log_inf` VALUES ('279', '2017-08-22 21:40:32', '1', '-680.000000000', '105000.000000000', '104320.000000000', '会员:111111被激活时扣除激活积分', 'admin', '33');
INSERT INTO `t_log_inf` VALUES ('280', '2017-08-22 21:40:32', '3', '200.000000000', '0.000000000', '200.000000000', '会员:111111被激活时获得的推荐奖进入现金积分', 'admin', '33');
INSERT INTO `t_log_inf` VALUES ('281', '2017-08-22 21:40:32', '2', '50.000000000', '0.000000000', '50.000000000', '会员:111111被激活时获取的层奖进入团队收益', 'admin', '33');

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `memNum` varchar(255) DEFAULT NULL COMMENT '会员编号',
  `tjrNum` varchar(255) DEFAULT NULL COMMENT '推荐人编号',
  `jiedianId` int(11) DEFAULT NULL,
  `jiedianNum` varchar(255) DEFAULT NULL,
  `areaType` varchar(255) DEFAULT NULL,
  `aCounts` int(11) DEFAULT NULL,
  `bCounts` int(11) DEFAULT NULL,
  `ztAmounts` int(11) DEFAULT NULL COMMENT '直推数量  即直接推荐人的数量',
  `teamAmounts` int(11) DEFAULT NULL COMMENT '团队数量 即直接推荐和间接推荐和本身数量和',
  `jhTime` datetime DEFAULT NULL COMMENT '激活时间',
  `jhState` int(11) DEFAULT NULL COMMENT '激活状态  0未激活  1已激活',
  `gjLevel` int(11) DEFAULT NULL COMMENT '管家等级  0普通管家  1超级管家',
  `realName` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `teleNum` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `registTime` datetime DEFAULT NULL COMMENT '注册时间',
  `djState` int(11) DEFAULT NULL COMMENT '冻结状态  0冻结  1解冻',
  `roleState` int(11) DEFAULT NULL COMMENT '角色类型  0普通会员  1超级管理员',
  `weichat` varchar(255) DEFAULT NULL COMMENT '微信账号',
  `alipay` varchar(255) DEFAULT NULL COMMENT '支付宝账号',
  `alipayName` varchar(255) DEFAULT NULL COMMENT '支付宝昵称',
  `loginPwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `tradePwd` varchar(255) DEFAULT NULL COMMENT '交易密码',
  `bankNum` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `bankType` int(11) DEFAULT NULL COMMENT '银行卡类型  0中国工商银行、1中国建设银行、2中国银行、3中国农业银行、4交通银行',
  `khhAddress` varchar(255) DEFAULT NULL COMMENT '开户行地址',
  `khhkName` varchar(255) DEFAULT NULL COMMENT '开户行名称 ',
  `adloginPwd` varchar(255) DEFAULT NULL COMMENT '后台登录密码 即管理员',
  `protectQuest` tinyint(4) DEFAULT NULL COMMENT '密保问题  0最喜欢看的电影是什么? 1曾经去过最远的地方是? 2父亲的生日日期是多少号?',
  `protectAnswe` varchar(255) DEFAULT NULL COMMENT '密保答案',
  `payPic` varchar(255) DEFAULT NULL COMMENT '图片存放的位置和图片名，如：\\\\goldentree\\\\upload\\\\20170619\\\\51354351.jpg',
  `isLayerOver` varchar(255) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL COMMENT '记录登录时间',
  `btcAddress` varchar(255) DEFAULT NULL,
  `dhgAddress` varchar(255) DEFAULT NULL,
  `ethAddress` varchar(255) DEFAULT NULL,
  `payBtc` varchar(255) DEFAULT NULL,
  `payDhg` varchar(255) DEFAULT NULL,
  `payEth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('1', 'admin', null, null, null, null, '2', '1', '3', '3', '2017-05-30 12:19:57', '3', '1', '梦幻园4', '15556921921', '2017-05-30 08:19:44', '1', '2', '15556921921', '15556921921', '梦幻园', '111111', '111111', '6217856101019613954', '2', '江苏苏州', '苏州横塘', '111111', '1', '美国', 'http://123.207.28.216:8082/images/brand/67437438-ed4f-412b-9bf8-d991f60ee249.jpg', '1', null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('265', '111111', 'admin', '1', 'admin', 'A', '1', '0', '0', '0', '2017-08-22 21:40:32', '2', null, '方芳芳', '13855445526', '2017-08-22 21:40:22', '1', '1', null, null, null, 'aaa111', 'aaa111', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('266', '222222', 'admin', '1', 'admin', 'B', '0', '0', '0', '0', '2017-08-22 22:12:31', '2', null, '噩噩噩噩', '13955445521', '2017-08-22 21:41:10', '1', '1', null, null, null, '111111', '111111', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('267', '33333333', 'admin', '265', '111111', 'A', '0', '0', '0', '0', '2017-08-22 22:14:04', '2', null, '吞吞吐吐', '13688554452', '2017-08-22 22:13:54', '1', '1', null, null, null, '111111', '111111', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('268', '66666666666', 'admin', '265', '111111', 'B', '0', '0', '0', '0', null, '1', null, '反反复复', '13855441152', '2017-08-22 22:39:08', '1', '1', null, null, null, '111111', '111111', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_member_currency_log
-- ----------------------------
DROP TABLE IF EXISTS `t_member_currency_log`;
CREATE TABLE `t_member_currency_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memId` int(11) DEFAULT NULL,
  `memNum` varchar(255) DEFAULT NULL,
  `toMemNum` varchar(255) DEFAULT NULL,
  `fromMemNum` varchar(255) DEFAULT NULL,
  `currenType` tinyint(4) DEFAULT NULL,
  `toCurrenType` tinyint(4) DEFAULT NULL,
  `fromCurrenType` tinyint(4) DEFAULT NULL,
  `rechargeType` tinyint(4) DEFAULT NULL,
  `checkedTime` datetime DEFAULT NULL,
  `certificatePic` varchar(255) DEFAULT NULL,
  `rechargeMark` varchar(255) DEFAULT NULL,
  `rechargeStatus` tinyint(4) DEFAULT NULL,
  `salary` decimal(30,9) DEFAULT NULL,
  `optDesc` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `optType` tinyint(4) DEFAULT NULL,
  `txType` tinyint(4) DEFAULT NULL,
  `txStatus` tinyint(4) DEFAULT NULL,
  `realSalary` decimal(30,9) DEFAULT NULL,
  `txMark` varchar(255) DEFAULT NULL,
  `currenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member_currency_log
-- ----------------------------
INSERT INTO `t_member_currency_log` VALUES ('30', '1', 'admin', null, null, '1', null, null, '1', '2017-08-22 21:39:09', null, null, '2', '100000.000000000', '手动充值', '2017-08-22 21:37:50', '2', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('31', '1', 'admin', '111111', 'admin', '1', null, null, null, null, null, null, null, '-500.000000000', '转出', '2017-08-22 21:54:05', '1', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('32', '265', '111111', '111111', 'admin', '1', null, null, null, null, null, null, null, '500.000000000', '转入', '2017-08-22 21:54:05', '1', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('33', '1', 'admin', '111111', 'admin', '1', null, null, null, null, null, null, null, '-500.000000000', '转出', '2017-08-22 22:12:47', '1', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('34', '265', '111111', '111111', 'admin', '1', null, null, null, null, null, null, null, '500.000000000', '转入', '2017-08-22 22:12:47', '1', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('35', '1', 'admin', null, null, null, null, null, '1', null, 'http://123.207.28.216:8082/images/brand/9d4c3caa-ec8a-4897-b398-89421153df44.jpg', '555555', '1', '5000.000000000', '货币充值', '2017-08-22 22:39:46', '2', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('36', '1', 'admin', '111111', 'admin', '1', null, null, null, null, null, null, null, '-100.000000000', '转出', '2017-08-22 22:40:14', '1', null, null, null, null, null);
INSERT INTO `t_member_currency_log` VALUES ('37', '265', '111111', '111111', 'admin', '1', null, null, null, null, null, null, null, '100.000000000', '转入', '2017-08-22 22:40:14', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_mem_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_mem_menu`;
CREATE TABLE `t_mem_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `memId` int(11) DEFAULT NULL COMMENT '关联会员ID',
  `menuId` int(11) DEFAULT NULL COMMENT '关联菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mem_menu
-- ----------------------------
INSERT INTO `t_mem_menu` VALUES ('145', '1', '1');
INSERT INTO `t_mem_menu` VALUES ('146', '1', '2');
INSERT INTO `t_mem_menu` VALUES ('147', '1', '3');
INSERT INTO `t_mem_menu` VALUES ('148', '1', '4');
INSERT INTO `t_mem_menu` VALUES ('149', '1', '5');
INSERT INTO `t_mem_menu` VALUES ('150', '1', '6');
INSERT INTO `t_mem_menu` VALUES ('151', '1', '7');
INSERT INTO `t_mem_menu` VALUES ('152', '1', '8');
INSERT INTO `t_mem_menu` VALUES ('153', '1', '10');
INSERT INTO `t_mem_menu` VALUES ('154', '1', '11');
INSERT INTO `t_mem_menu` VALUES ('155', '1', '12');
INSERT INTO `t_mem_menu` VALUES ('156', '1', '13');
INSERT INTO `t_mem_menu` VALUES ('157', '1', '15');
INSERT INTO `t_mem_menu` VALUES ('158', '1', '16');
INSERT INTO `t_mem_menu` VALUES ('159', '1', '22');
INSERT INTO `t_mem_menu` VALUES ('160', '1', '23');
INSERT INTO `t_mem_menu` VALUES ('161', '1', '24');
INSERT INTO `t_mem_menu` VALUES ('162', '1', '25');
INSERT INTO `t_mem_menu` VALUES ('163', '1', '26');
INSERT INTO `t_mem_menu` VALUES ('164', '1', '27');
INSERT INTO `t_mem_menu` VALUES ('165', '1', '28');
INSERT INTO `t_mem_menu` VALUES ('166', '1', '29');
INSERT INTO `t_mem_menu` VALUES ('167', '1', '30');
INSERT INTO `t_mem_menu` VALUES ('168', '1', '32');
INSERT INTO `t_mem_menu` VALUES ('169', '1', '33');
INSERT INTO `t_mem_menu` VALUES ('170', '1', '34');
INSERT INTO `t_mem_menu` VALUES ('171', '1', '35');
INSERT INTO `t_mem_menu` VALUES ('172', '1', '36');
INSERT INTO `t_mem_menu` VALUES ('173', '1', '37');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `isspread` int(11) DEFAULT NULL COMMENT '是否展开  0展开true  1折叠false',
  `menuTitle` varchar(255) DEFAULT NULL COMMENT '菜单标题',
  `menuIcon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menuHref` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `menuOrder` int(11) DEFAULT NULL COMMENT '菜单排序',
  `pid` int(11) DEFAULT NULL COMMENT '关联父亲Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '1', '信息管理', 'fa-desktop', null, '1', null);
INSERT INTO `t_menu` VALUES ('2', null, '添加新闻', 'fa-laptop', 'admin/information_add.html', '2', '1');
INSERT INTO `t_menu` VALUES ('3', null, '新闻列表', 'fa-laptop', 'admin/information_list.html', '4', '1');
INSERT INTO `t_menu` VALUES ('4', '0', '系统设置', 'fa-desktop', null, '4', null);
INSERT INTO `t_menu` VALUES ('5', null, '初始参数', 'fa-laptop', 'admin/paramconf.html', '5', '4');
INSERT INTO `t_menu` VALUES ('6', '0', '会员管理', 'fa-desktop', null, '6', null);
INSERT INTO `t_menu` VALUES ('7', null, '添加会员', 'fa-laptop', 'admin/member_add.html', '7', '6');
INSERT INTO `t_menu` VALUES ('8', null, '会员列表', 'fa-laptop', 'admin/member_list.html', '8', '6');
INSERT INTO `t_menu` VALUES ('10', '0', '财务明细', 'fa-desktop', null, '13', null);
INSERT INTO `t_menu` VALUES ('11', null, '奖金明细', 'fa-laptop', 'admin/finace_detail.html', '14', '10');
INSERT INTO `t_menu` VALUES ('12', null, '财务明细', 'fa-laptop', 'admin/finace_inout.html', '15', '10');
INSERT INTO `t_menu` VALUES ('13', null, '提现管理', 'fa-laptop', 'admin/finace_txman.html', '16', '10');
INSERT INTO `t_menu` VALUES ('15', null, '充值管理', 'fa-laptop', 'admin/finace_czman.html', '17', '10');
INSERT INTO `t_menu` VALUES ('16', null, '手动充值', 'fa-laptop', 'admin/finace_czbyhand.html', '18', '10');
INSERT INTO `t_menu` VALUES ('22', '0', '管理员', 'fa-desktop', null, '19', null);
INSERT INTO `t_menu` VALUES ('23', null, '添加管理员', 'fa-laptop', 'admin/member_manager_add.html', '20', '22');
INSERT INTO `t_menu` VALUES ('24', null, '管理员列表', 'fa-laptop', 'admin/member_manager_list.html', '21', '22');
INSERT INTO `t_menu` VALUES ('25', '0', '邮件管理', 'fa-desktop', null, '22', null);
INSERT INTO `t_menu` VALUES ('26', null, '发邮件', 'fa-laptop', 'admin/emailMsg_add.html', '23', '25');
INSERT INTO `t_menu` VALUES ('27', null, '发件箱', 'fa-laptop', 'admin/emailMsg_send_list.html', '24', '25');
INSERT INTO `t_menu` VALUES ('28', null, '收件箱', 'fa-laptop', 'admin/emailMsg_receive_list.html', '25', '25');
INSERT INTO `t_menu` VALUES ('29', '0', '数据库管理', 'fa-desktop', null, '26', null);
INSERT INTO `t_menu` VALUES ('30', null, '备份与还原', 'fa-laptop', 'admin/db_backup.html', '27', '29');
INSERT INTO `t_menu` VALUES ('32', null, '数据初始化', 'fa-laptop', 'admin/db_init.html', '28', '29');
INSERT INTO `t_menu` VALUES ('33', '0', '网络图谱', 'fa-desktop', '', '9', null);
INSERT INTO `t_menu` VALUES ('34', null, '直推系谱图', 'fa-laptop', 'admin/directionLinks.html', '10', '33');
INSERT INTO `t_menu` VALUES ('35', null, '安置关系图', 'fa-laptop', 'admin/contactLinks.html', '11', '33');
INSERT INTO `t_menu` VALUES ('36', null, '添加白皮书', 'fa-laptop', 'admin/white_paper.html', '3', '1');
INSERT INTO `t_menu` VALUES ('37', null, '白皮书列表', 'fa-laptop', 'admin/whitePaper_list.html', '4', '1');

-- ----------------------------
-- Table structure for t_paramconf
-- ----------------------------
DROP TABLE IF EXISTS `t_paramconf`;
CREATE TABLE `t_paramconf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `jhIntegral` decimal(15,6) DEFAULT NULL COMMENT '激活积分 激活普通会员使用 示例50元',
  `yszzIntegral` decimal(15,6) DEFAULT NULL COMMENT '银树种植一颗消耗的种子积分 示例200元 ',
  `jszzIntegral` decimal(15,6) DEFAULT NULL COMMENT '金树种植一颗消耗的种子积分 示例1000元',
  `ystqIntegral` decimal(15,6) DEFAULT NULL COMMENT '银树日分红每次偷取额度 示例 0.2元',
  `jstqIntegral` decimal(15,6) DEFAULT NULL COMMENT '金树日分红每次偷取额度 示例0.5元',
  `ystqCount` int(11) DEFAULT NULL COMMENT '银树日分红可被偷取次数 默认无管家 示例10次 该字段无效',
  `jstqCount` int(11) DEFAULT NULL COMMENT '金树日分红可被偷取次数 默认无管家 示例10次 该字段无效',
  `wgjCount` decimal(15,6) DEFAULT NULL COMMENT '金树 银树 无管家状态可被偷取次数 示例10次 ',
  `ptgjCount` decimal(15,6) DEFAULT NULL COMMENT '金树 银树 有管家状态可被偷取次数 示例8次',
  `cjgjCount` decimal(15,6) DEFAULT NULL COMMENT '超级管家偷取次数  该字段无效',
  `shtMoney` decimal(15,6) DEFAULT NULL COMMENT '神童日俸 针对神童是否处于工作状态的限定',
  `ptgjMoney` decimal(15,6) DEFAULT NULL COMMENT '管家月俸  针对管家是否处于工作状态的限定',
  `cjgjMoney` decimal(15,6) DEFAULT NULL COMMENT '超级管家月俸  该字段无效',
  `ysCapacity` decimal(15,6) DEFAULT NULL COMMENT '银树日分红收益产能 示例10元',
  `jsCapacity` decimal(15,6) DEFAULT NULL COMMENT '金树日分红收益产能 示例100元',
  `ysCapaCycle` int(11) DEFAULT NULL COMMENT '银树日分红产能周期 分钟 示例5分钟',
  `jsCapaCycle` int(11) DEFAULT NULL COMMENT '金树日分红产能周期 分钟 示例10分钟',
  `ysCapaLimit` int(11) DEFAULT NULL COMMENT '银树日分红产能上限  即分红次数 示例30次',
  `jsCapaLimit` int(11) DEFAULT NULL COMMENT '金树日分红产能上限  即分红次数 示例30次',
  `dsjScale` varchar(255) DEFAULT NULL COMMENT '代数奖比例 示例0.05,0.02,0.01,0.005,0.003,0.001 ',
  `zhtParam` varchar(255) DEFAULT NULL COMMENT '直推参数 示例1_1,3_2,6_3,15_4,20_10,50_15',
  `tixCycle` varchar(255) DEFAULT NULL COMMENT '提现周期 1_1,2_1,3_1,4_0,5_1,6_1,7_0 说明 1_1 礼拜一可以提现 4_0礼拜四不可提现...',
  `dyWalDeposit` varchar(255) DEFAULT NULL COMMENT '示例：1,100,2000,100,0.02 动态钱包每天提现次数,提现最低,提现最高,提现倍数,手续费',
  `jtWalDeposit` varchar(255) DEFAULT NULL COMMENT '示例：1,100,2000,100,0.02 静态钱包每天提现次数,提现最低,提现最高,提现倍数,手续费',
  `epSellTrade` varchar(255) DEFAULT NULL COMMENT '示例：100,2000,100 最低挂卖额度,最高挂卖额度,挂卖倍数',
  `epBuyTrade` varchar(255) DEFAULT NULL COMMENT '示例：100,2000,100 最低买进额度,最高买进额度,买进倍数',
  `dyWal2Jhjf` varchar(255) DEFAULT NULL COMMENT '动态钱包转激活积分 示例：100,2000,100 最低额度,最高额度,转换倍数',
  `dyWal2Zzjf` varchar(255) DEFAULT NULL COMMENT '动态钱包转种子积分示例：100,2000,100 最低额度,最高额度,转换倍数',
  `dyWal2GjMoney` varchar(255) DEFAULT NULL COMMENT '动态钱包转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `dyWal2ShtMoney` varchar(255) DEFAULT NULL COMMENT '动态钱包转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `jtWal2Jhjf` varchar(255) DEFAULT NULL COMMENT '静态钱包(收益钱包)转激活积分示例：100,2000,100 最低额度,最高额度,转换倍数',
  `jtWal2Zzjf` varchar(255) DEFAULT NULL COMMENT '静态钱包(收益钱包)转种子积分示例：100,2000,100 最低额度,最高额度,转换倍数',
  `jtWal2ShtMoney` varchar(255) DEFAULT NULL COMMENT '静态钱包(收益钱包)转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `jtWal2GjMoney` varchar(255) DEFAULT NULL COMMENT '静态钱包(收益钱包)转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `zzjf2Jhjf` varchar(255) DEFAULT NULL COMMENT '种子积分转激活积分示例：100,2000,100 最低额度,最高额度,转换倍数',
  `zzjf2ShtMoney` varchar(255) DEFAULT NULL COMMENT '种子积分转神童日俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `zzjf2GjMoney` varchar(255) DEFAULT NULL COMMENT '种子积分转管家月俸示例：100,2000,100 最低额度,最高额度,转换倍数',
  `zzjf2Zzjf` varchar(255) DEFAULT NULL COMMENT '会员间种子积分互转示例：100,2000,100 最低额度,最高额度,转换倍数',
  `jhjf2Jhjf` varchar(255) DEFAULT NULL COMMENT '会员间激活积分互转示例：100,2000,100 最低额度,最高额度,转换倍数',
  `singlePrice` decimal(10,2) DEFAULT NULL,
  `activeGetPrice` decimal(10,2) DEFAULT NULL,
  `directivePrice` decimal(10,2) DEFAULT NULL,
  `cashIntegralTX` varchar(255) DEFAULT NULL,
  `stopLayerPrice` decimal(10,0) DEFAULT NULL,
  `cashInteg2ActiveInteg` varchar(255) DEFAULT NULL,
  `activeInteg2activeInteg` varchar(255) DEFAULT NULL,
  `teamInteg2ActiveInteg` varchar(255) DEFAULT NULL,
  `teamIntegralTX` varchar(255) DEFAULT NULL,
  `integralTX` varchar(255) DEFAULT NULL,
  `currenName` varchar(255) DEFAULT NULL,
  `frozenAmount` decimal(30,9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_paramconf
-- ----------------------------
INSERT INTO `t_paramconf` VALUES ('1', '50.000000', '200.000000', '2000.000000', '0.200000', '2.000000', '10', '10', '10.000000', '5.000000', '6.000000', '10.000000', '30.000000', '20.000000', '10.000000', '100.000000', '1440', '1440', '30', '30', '0.05,0.03,0.02,0.01,0.005,0.003', '1_1,3_2,6_3,10_4,20_10,30_15', '1_1,2_1,3_1,4_1,5_1,6_1,7_1', '1,200,2000,200,0.02', '1,100,6000,100,0.01', '10,6000,10', '10,6000,10', '50,1000,50', '100,6000,100', '10,100,10', '10,300,10', '50,1000,10', '100,6000,100', '10,300,10', '10,100,10', '50,200,10', '10,300,10', '10,100,10', '100,12000,100', '50,1000,50', '680.00', '50.00', '200.00', '1,100,2000,100,0.1', '10000', '100,2000,100', '100,2000,100', '100,2000,100', '1,100,2000,100,0.1', null, null, null);

-- ----------------------------
-- Table structure for t_white_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_white_paper`;
CREATE TABLE `t_white_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `path` varchar(100) NOT NULL,
  `createTime` datetime NOT NULL,
  `memid` int(11) DEFAULT NULL,
  `memNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_white_paper
-- ----------------------------
INSERT INTO `t_white_paper` VALUES ('1', '20170828', 'http://123.207.28.216:8082/images/brand/20170828.docx', '2017-08-29 17:22:41', '1', 'admin');
INSERT INTO `t_white_paper` VALUES ('2', '20170829', 'http://123.207.28.216:8082/images/brand/20170828.docx', '2017-08-29 17:22:59', '1', 'admin');
INSERT INTO `t_white_paper` VALUES ('3', '20170828.docx', 'http://123.207.28.216:8082/images/brand/20170828.docx', '2017-08-29 19:24:26', '1', 'admin');
