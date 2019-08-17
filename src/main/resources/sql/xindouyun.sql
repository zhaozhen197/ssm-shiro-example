/*
Navicat MySQL Data Transfer

Source Server         : zane
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : xindouyun

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-07-14 20:41:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_owner
-- ----------------------------
DROP TABLE IF EXISTS `business_owner`;
CREATE TABLE `business_owner` (
  `business_owner_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '所属的user的userID',
  `user_phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `personal_expenses` int(11) DEFAULT '0' COMMENT '个人月均流水',
  `company_expenses` int(11) DEFAULT '0' COMMENT '对公月均流水',
  `operation_years` varchar(255) DEFAULT '' COMMENT '经营年限',
  `location_of_company` varchar(255) DEFAULT '' COMMENT '经营地',
  `license` varchar(255) DEFAULT '0' COMMENT '是否有营业执照',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`business_owner_id`),
  KEY `user` (`user_id`),
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_owner
-- ----------------------------

-- ----------------------------
-- Table structure for company_loan
-- ----------------------------
DROP TABLE IF EXISTS `company_loan`;
CREATE TABLE `company_loan` (
  `company_loan_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT '' COMMENT '贷款类型',
  `name1` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `company_years` int(11) DEFAULT NULL,
  `stock_per` int(11) DEFAULT NULL,
  `invoice_fee` int(255) DEFAULT NULL,
  `tax_fee` int(11) DEFAULT NULL,
  `invoice_fee_oneyear` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`company_loan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_loan
-- ----------------------------
INSERT INTO `company_loan` VALUES ('1', '34', '15639068762', 'zhao', 'shareHolder', '5', '30', '6987', '1023', null, '2019-06-21 14:32:48', '2019-06-21 14:32:48');

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父选项id',
  `table` varchar(255) DEFAULT '' COMMENT '所属于哪个表',
  `key` varchar(255) DEFAULT '' COMMENT '键值',
  `value` varchar(255) DEFAULT '' COMMENT '对应的值',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', null, 'wage_earner', 'bank', '银行卡发放', null, null);
INSERT INTO `dictionary` VALUES ('2', null, 'wage_earner', 'cash', '现金发放', null, null);
INSERT INTO `dictionary` VALUES ('3', null, 'wage_earner', 'oneYearMore', '一年以上', null, null);
INSERT INTO `dictionary` VALUES ('4', null, 'wage_earner', 'lessThreeMonth', '未满三个月', null, null);
INSERT INTO `dictionary` VALUES ('5', null, 'wage_earner', 'aboutSixMonth', '满六个月', null, null);
INSERT INTO `dictionary` VALUES ('6', null, 'wage_earner', 'oneYear', '满一年', null, null);
INSERT INTO `dictionary` VALUES ('7', null, 'wage_earner', 'government', '企业事业单位', null, null);
INSERT INTO `dictionary` VALUES ('8', null, 'wage_earner', 'state_owned', '国有企业', null, null);
INSERT INTO `dictionary` VALUES ('9', null, 'wage_earner', 'share', '合资企业/股份制企业', null, null);
INSERT INTO `dictionary` VALUES ('10', null, 'wage_earner', 'personal_company', '私营企业/个体工商业', null, null);
INSERT INTO `dictionary` VALUES ('11', null, 'wage_earner', 'foreign_company', '外资企业', null, null);
INSERT INTO `dictionary` VALUES ('12', null, 'wage_earner', 'listed_company', '上市公司', null, null);
INSERT INTO `dictionary` VALUES ('13', null, 'wage_earner', 'top_500', '500强/上市公司', null, null);
INSERT INTO `dictionary` VALUES ('14', null, 'user', 'wage_earners', '工薪族', null, null);
INSERT INTO `dictionary` VALUES ('15', null, 'user', 'business_owner', '企业主', null, null);
INSERT INTO `dictionary` VALUES ('16', null, 'user', 'person', '个体户', null, null);
INSERT INTO `dictionary` VALUES ('17', null, 'user', 'other', '其他', null, null);
INSERT INTO `dictionary` VALUES ('18', null, 'user', 'noHouse', '无房', null, null);
INSERT INTO `dictionary` VALUES ('19', null, 'user', 'fullPaymentHouse', '全款房', null, null);
INSERT INTO `dictionary` VALUES ('20', null, 'user', 'mortgageHouse', '按揭房', null, null);
INSERT INTO `dictionary` VALUES ('21', null, 'user', 'noCar', '无车', null, null);
INSERT INTO `dictionary` VALUES ('22', null, 'user', 'fullPaymentCar', '全款车', null, null);
INSERT INTO `dictionary` VALUES ('23', null, 'user', 'mortgageCar', '按揭车', null, null);
INSERT INTO `dictionary` VALUES ('24', null, 'user', 'credit0', '请选择', null, null);
INSERT INTO `dictionary` VALUES ('25', null, 'user', 'credit1', '信用良好', null, null);
INSERT INTO `dictionary` VALUES ('26', null, 'user', 'credit2', '半年内逾期超过2次或者30天以上逾期', null, null);
INSERT INTO `dictionary` VALUES ('27', null, 'user', 'credit3', '一年内逾期超过3次或者90天以上逾期', null, null);
INSERT INTO `dictionary` VALUES ('28', null, 'user', 'credit4', '无信用卡贷款', null, null);
INSERT INTO `dictionary` VALUES ('29', null, '', '0', '否', null, null);
INSERT INTO `dictionary` VALUES ('30', null, '', '1', '是', null, null);
INSERT INTO `dictionary` VALUES ('31', null, '', 'lessSixMonth', '注册不满六个月', null, null);
INSERT INTO `dictionary` VALUES ('32', null, '', 'moreSixMonth', '注册满6到12个月', null, null);
INSERT INTO `dictionary` VALUES ('33', null, '', 'oneYear', '注册满1年', null, null);
INSERT INTO `dictionary` VALUES ('34', null, '', 'twoYear', '2年内', null, null);
INSERT INTO `dictionary` VALUES ('35', null, '', 'threeYear', '3年内', null, null);
INSERT INTO `dictionary` VALUES ('36', null, '', 'moreThreeYear', '3年以上', null, null);
INSERT INTO `dictionary` VALUES ('37', null, '', '-1', '否', null, null);
INSERT INTO `dictionary` VALUES ('38', null, '', 'local', '本地', null, null);
INSERT INTO `dictionary` VALUES ('39', null, '', 'non_local', '外地', null, null);
INSERT INTO `dictionary` VALUES ('40', null, 'insurance', 'pingAnRenShou', '平安人寿', null, null);
INSERT INTO `dictionary` VALUES ('41', null, 'insurance', 'zhongGuoRenShou', '中国人寿', null, null);
INSERT INTO `dictionary` VALUES ('42', null, 'insurance', 'renMinBaoXian', '人民保险', null, null);
INSERT INTO `dictionary` VALUES ('43', null, 'insurance', 'taiKangRenShou', '泰康人寿', null, null);
INSERT INTO `dictionary` VALUES ('44', null, 'insurance', 'xinHuaRenShou', '新华人寿', null, null);
INSERT INTO `dictionary` VALUES ('45', null, 'insurance', 'youBangRenShou', '友邦人寿', null, null);
INSERT INTO `dictionary` VALUES ('46', null, 'insurance', 'yangGuangRenShou', '阳光人寿', null, null);
INSERT INTO `dictionary` VALUES ('47', null, 'insurance', 'taiPingRenShou', '太平人寿', null, null);
INSERT INTO `dictionary` VALUES ('48', null, 'insurance', 'zhongHongRenShou', '中宏人寿', null, null);
INSERT INTO `dictionary` VALUES ('49', null, 'insurance', 'zhongYiRenShou', '中意人寿', null, null);
INSERT INTO `dictionary` VALUES ('50', null, 'insurance', 'zhaoShangXinNuo', '招商信诺', null, null);
INSERT INTO `dictionary` VALUES ('51', null, 'insurance', 'daDuHui', '大都会', null, null);
INSERT INTO `dictionary` VALUES ('52', null, 'insurance', 'shengMingRenShou', '生命人寿', null, null);
INSERT INTO `dictionary` VALUES ('53', null, 'insurance', 'zhongYouRenShou', '中邮人寿', null, null);
INSERT INTO `dictionary` VALUES ('54', null, 'insurance', 'qiTaBaoXian', '其他保险', null, null);
INSERT INTO `dictionary` VALUES ('55', null, '', 'legalPerson', '法人', null, null);
INSERT INTO `dictionary` VALUES ('56', null, '', 'shareHolder', '股东', null, null);
INSERT INTO `dictionary` VALUES ('57', null, '', 'companyLoan', '企业贷款', null, null);
INSERT INTO `dictionary` VALUES ('58', null, '', 'mortgageLoan', '抵押贷款', null, null);
INSERT INTO `dictionary` VALUES ('59', null, '', 'creditLoan', '信用贷款', null, null);

-- ----------------------------
-- Table structure for full_payment_car
-- ----------------------------
DROP TABLE IF EXISTS `full_payment_car`;
CREATE TABLE `full_payment_car` (
  `full_payment_car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '用户id',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `car_value` int(11) DEFAULT '0' COMMENT '裸车价格  万元',
  `car_years` int(11) DEFAULT '0' COMMENT '车子年限',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`full_payment_car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of full_payment_car
-- ----------------------------

-- ----------------------------
-- Table structure for full_payment_house
-- ----------------------------
DROP TABLE IF EXISTS `full_payment_house`;
CREATE TABLE `full_payment_house` (
  `full_payment_house_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '用户id',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `market_value` int(11) DEFAULT '0' COMMENT '房子市值  万元',
  `right_of_peopleNumber` int(11) DEFAULT '0' COMMENT '产权人数',
  `house_area` int(11) DEFAULT NULL COMMENT '房子面积',
  `complete_year` int(11) DEFAULT NULL COMMENT '房子竣工日期',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`full_payment_house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of full_payment_house
-- ----------------------------
INSERT INTO `full_payment_house` VALUES ('1', '35', '15090109700', 'zhen', '11', '11', '11', '1122', '2019-06-21 14:34:17', '2019-06-21 14:34:17');
INSERT INTO `full_payment_house` VALUES ('2', '35', '15090109700', 'zhen', '22', '22', '22', '22', '2019-06-21 14:34:17', '2019-06-21 14:34:17');
INSERT INTO `full_payment_house` VALUES ('3', '35', '15090109700', 'zhen', '333', '333', '33', '33', '2019-06-21 19:51:23', '2019-06-21 19:51:23');

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `fund_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公积金',
  `user_id` int(11) DEFAULT '0' COMMENT '所属的userid',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户电话',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `fund_money` int(255) DEFAULT '0' COMMENT '缴费额度',
  `payment_time` int(11) DEFAULT '0' COMMENT '连续缴纳时间啊',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`fund_id`),
  KEY `fund_user` (`user_id`),
  CONSTRAINT `fund_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fund
-- ----------------------------
INSERT INTO `fund` VALUES ('1', '34', '15639068762', 'zhaozhen', '3333', '33', '2019-06-21 14:48:34', '2019-06-21 14:48:34');

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `identity_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '职业身份的名称',
  `introduce` varchar(255) DEFAULT '' COMMENT '身份介绍详情',
  PRIMARY KEY (`identity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity
-- ----------------------------

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `insurance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保险',
  `user_id` int(11) DEFAULT '0',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `insurance_or_not` varchar(255) DEFAULT '0' COMMENT '是否投保人 0不是 1是',
  `company_of_insurance` varchar(255) DEFAULT '' COMMENT '投保公司',
  `money_of_year_insurance` int(11) DEFAULT '0' COMMENT '年交金额',
  `years_of_insurance` int(11) DEFAULT '0' COMMENT '缴费年限',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`insurance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES ('1', '34', '15639068762', 'zhaozhen', '1', 'zhongYiRenShou', '3', '3', '2019-06-21 14:48:34', '2019-06-21 14:48:34');
INSERT INTO `insurance` VALUES ('2', '34', '15639068762', 'zhaozhen', '1', 'taiKangRenShou', '33', '33', '2019-06-21 14:48:34', '2019-06-21 14:48:34');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT '' COMMENT '电话号码',
  `validate_code` int(11) DEFAULT '0' COMMENT '验证码',
  `dead_line` int(11) DEFAULT '0' COMMENT '失效时间',
  `usable` tinyint(4) DEFAULT '0' COMMENT '该验证码是是否已经使用了',
  `sended` tinyint(4) DEFAULT '0' COMMENT '验证码是否发送给用户',
  `creation_datetime` datetime DEFAULT NULL COMMENT '验证码创建时间',
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('16', '15090109700', '885777', '1560233740', '1', '1', '2019-06-11 14:05:40', '2019-06-11 14:05:40');
INSERT INTO `message` VALUES ('17', '15639068762', '742626', '1560236146', '1', '1', '2019-06-11 14:45:46', '2019-06-11 14:45:46');
INSERT INTO `message` VALUES ('18', '15755959917', '402486', '1560237833', '1', '1', '2019-06-11 15:13:53', '2019-06-11 15:13:53');
INSERT INTO `message` VALUES ('19', '15755959917', '414076', '1560241738', '1', '1', '2019-06-11 16:18:58', '2019-06-11 16:18:58');
INSERT INTO `message` VALUES ('20', '18557526726', '184755', '1560241761', '1', '1', '2019-06-11 16:19:21', '2019-06-11 16:19:21');
INSERT INTO `message` VALUES ('21', '18321115076', '989608', '1560241787', '1', '1', '2019-06-11 16:19:47', '2019-06-11 16:19:47');
INSERT INTO `message` VALUES ('22', '17718212510', '464210', '1560242103', '1', '1', '2019-06-11 16:25:03', '2019-06-11 16:25:03');
INSERT INTO `message` VALUES ('23', '15755959917', '212373', '1560252653', '1', '1', '2019-06-11 19:20:53', '2019-06-11 19:20:53');
INSERT INTO `message` VALUES ('24', '15090109700', '270140', '1560253267', '1', '1', '2019-06-11 19:31:07', '2019-06-11 19:31:07');
INSERT INTO `message` VALUES ('25', '17621062812', '586345', '1560254775', '1', '1', '2019-06-11 19:56:15', '2019-06-11 19:56:15');
INSERT INTO `message` VALUES ('26', '15090109700', '503908', '1560497078', '1', '1', '2019-06-14 15:14:38', '2019-06-14 15:14:38');
INSERT INTO `message` VALUES ('27', '15639068762', '506023', '1560497854', '1', '1', '2019-06-14 15:27:34', '2019-06-14 15:27:34');
INSERT INTO `message` VALUES ('28', '15639068762', '624425', '1560499000', '1', '1', '2019-06-14 15:46:40', '2019-06-14 15:46:40');
INSERT INTO `message` VALUES ('29', '15639068762', '911110', '1560499593', '1', '1', '2019-06-14 15:56:33', '2019-06-14 15:56:33');
INSERT INTO `message` VALUES ('30', '15639068762', '410787', '1560500891', '1', '1', '2019-06-14 16:18:11', '2019-06-14 16:18:11');
INSERT INTO `message` VALUES ('31', '15090109700', '325891', '1560501110', '1', '1', '2019-06-14 16:21:50', '2019-06-14 16:21:50');
INSERT INTO `message` VALUES ('32', '17621488178', '726525', '1560501507', '1', '1', '2019-06-14 16:28:27', '2019-06-14 16:28:27');
INSERT INTO `message` VALUES ('33', '15639068762', '155081', '1560501914', '1', '1', '2019-06-14 16:35:14', '2019-06-14 16:35:14');
INSERT INTO `message` VALUES ('34', '15090109700', '880977', '1560503446', '1', '1', '2019-06-14 17:00:46', '2019-06-14 17:00:46');
INSERT INTO `message` VALUES ('35', '15090109700', '464335', '1560503645', '1', '1', '2019-06-14 17:04:05', '2019-06-14 17:04:05');
INSERT INTO `message` VALUES ('36', '15090109700', '698731', '1560503978', '1', '1', '2019-06-14 17:09:38', '2019-06-14 17:09:38');
INSERT INTO `message` VALUES ('37', '15090109700', '698152', '1560504204', '1', '1', '2019-06-14 17:13:24', '2019-06-14 17:13:24');
INSERT INTO `message` VALUES ('38', '15090109700', '746941', '1560504538', '1', '1', '2019-06-14 17:18:58', '2019-06-14 17:18:58');
INSERT INTO `message` VALUES ('39', '18321115076', '104884', '1560504818', '1', '1', '2019-06-14 17:23:38', '2019-06-14 17:23:38');
INSERT INTO `message` VALUES ('40', '17718212510', '686306', '1560504884', '1', '1', '2019-06-14 17:24:44', '2019-06-14 17:24:44');
INSERT INTO `message` VALUES ('41', '17718212510', '337269', '1560504929', '1', '1', '2019-06-14 17:25:29', '2019-06-14 17:25:29');
INSERT INTO `message` VALUES ('42', '15639068762', '781762', '1560504969', '1', '1', '2019-06-14 17:26:09', '2019-06-14 17:26:09');
INSERT INTO `message` VALUES ('43', '15755959917', '774238', '1560505014', '1', '1', '2019-06-14 17:26:54', '2019-06-14 17:26:54');
INSERT INTO `message` VALUES ('44', '18321115076', '330013', '1560505463', '1', '1', '2019-06-14 17:34:23', '2019-06-14 17:34:23');
INSERT INTO `message` VALUES ('45', '15090109700', '788836', '1560751840', '1', '1', '2019-06-17 14:00:40', '2019-06-17 14:00:40');
INSERT INTO `message` VALUES ('46', '15639068762', '794887', '1560753270', '1', '1', '2019-06-17 14:24:30', '2019-06-17 14:24:30');
INSERT INTO `message` VALUES ('47', '15639068762', '355890', '1560753302', '1', '1', '2019-06-17 14:25:02', '2019-06-17 14:25:02');
INSERT INTO `message` VALUES ('48', '15755959917', '732324', '1560753696', '1', '1', '2019-06-17 14:31:36', '2019-06-17 14:31:36');
INSERT INTO `message` VALUES ('49', '17621062812', '611459', '1560753908', '1', '1', '2019-06-17 14:35:08', '2019-06-17 14:35:08');
INSERT INTO `message` VALUES ('50', '18321115076', '763262', '1560754319', '1', '1', '2019-06-17 14:41:59', '2019-06-17 14:41:59');
INSERT INTO `message` VALUES ('51', '18321115076', '158631', '1560754634', '1', '1', '2019-06-17 14:47:14', '2019-06-17 14:47:14');
INSERT INTO `message` VALUES ('52', '17718212510', '321841', '1560757516', '0', '1', '2019-06-17 15:35:16', '2019-06-17 15:35:16');
INSERT INTO `message` VALUES ('53', '15639068762', '511959', '1560834875', '1', '1', '2019-06-18 13:04:35', '2019-06-18 13:04:35');
INSERT INTO `message` VALUES ('54', '17718212510', '998288', '1560837281', '1', '1', '2019-06-18 13:44:41', '2019-06-18 13:44:41');
INSERT INTO `message` VALUES ('55', '18321115076', '297580', '1560838439', '1', '1', '2019-06-18 14:03:59', '2019-06-18 14:03:59');
INSERT INTO `message` VALUES ('56', '15639068762', '908203', '1561099169', '1', '1', '2019-06-21 14:29:29', '2019-06-21 14:29:29');
INSERT INTO `message` VALUES ('57', '15639068762', '671577', '1561099314', '1', '1', '2019-06-21 14:31:54', '2019-06-21 14:31:54');
INSERT INTO `message` VALUES ('58', '15090109700', '451855', '1561099400', '1', '1', '2019-06-21 14:33:20', '2019-06-21 14:33:20');
INSERT INTO `message` VALUES ('59', '15639068762', '816825', '1561100227', '1', '1', '2019-06-21 14:47:07', '2019-06-21 14:47:07');

-- ----------------------------
-- Table structure for mortgage_car
-- ----------------------------
DROP TABLE IF EXISTS `mortgage_car`;
CREATE TABLE `mortgage_car` (
  `mortgage_car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `money_every_month_car` int(255) DEFAULT '0' COMMENT '月供金额',
  `month_of_loan_car` int(255) DEFAULT '0' COMMENT '月供时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mortgage_car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mortgage_car
-- ----------------------------
INSERT INTO `mortgage_car` VALUES ('1', '34', '15639068762', 'zhaozhen', '33', '33', '2019-06-21 14:48:34', '2019-06-21 14:48:34');

-- ----------------------------
-- Table structure for mortgage_house
-- ----------------------------
DROP TABLE IF EXISTS `mortgage_house`;
CREATE TABLE `mortgage_house` (
  `mortgage_house_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户手机号',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `house_type` varchar(255) DEFAULT '' COMMENT '房子种类',
  `mian_loan_person` varchar(255) DEFAULT '0' COMMENT '是否是主贷人 0 为否 1为是',
  `money_every_month_house` int(255) DEFAULT '0' COMMENT '月供金额',
  `month_of_loan_house` int(11) DEFAULT '0' COMMENT '月供时间',
  `right_of_peopleNumber` int(11) DEFAULT NULL COMMENT '产权人数',
  `market_value` int(11) DEFAULT NULL COMMENT '市值',
  `house_area` int(11) DEFAULT NULL COMMENT '房子面积',
  `complete_year` int(11) DEFAULT NULL COMMENT '竣工日期（年)',
  `remaining_money` int(11) DEFAULT NULL COMMENT '未还按揭金额',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mortgage_house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mortgage_house
-- ----------------------------
INSERT INTO `mortgage_house` VALUES ('1', '34', '15639068762', 'zhaozhen', null, '1', '3333', '33', null, null, null, null, null, '2019-06-21 14:48:34', '2019-06-21 14:48:34');

-- ----------------------------
-- Table structure for other
-- ----------------------------
DROP TABLE IF EXISTS `other`;
CREATE TABLE `other` (
  `other_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '所属user的UeserId',
  `user_phone` varchar(255) DEFAULT NULL,
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `cash_income` int(255) DEFAULT '0',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`other_id`),
  KEY `other_user` (`user_id`),
  CONSTRAINT `other_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of other
-- ----------------------------

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '所属user的userid',
  `user_phone` varchar(255) DEFAULT '' COMMENT '用户电话',
  `user_name1` varchar(255) DEFAULT '' COMMENT '所属用户称呼',
  `personal_expenses` int(11) DEFAULT '0' COMMENT '个人月均流水',
  `cash_expenses` int(11) DEFAULT '0' COMMENT '个人现金月均流水',
  `operation_years` varchar(255) DEFAULT '' COMMENT '经营年限',
  `location_of_company` varchar(255) DEFAULT '' COMMENT '经营地',
  `license` varchar(4) DEFAULT '0' COMMENT '是否有营业执照',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `user_person` (`user_id`),
  CONSTRAINT `user_person` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限编号',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `rid` bigint(20) DEFAULT NULL COMMENT '此权限关联角色的id',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES ('31', 'resource:create', '用户新增', '23', '0');
INSERT INTO `sys_permissions` VALUES ('32', 'user:update', '用户修改', '23', '0');
INSERT INTO `sys_permissions` VALUES ('33', 'user:delete', '用户删除', '23', '0');
INSERT INTO `sys_permissions` VALUES ('34', 'user:view', '用户查看', '23', '0');
INSERT INTO `sys_permissions` VALUES ('35', 'role:update', '角色更新', '21', '0');
INSERT INTO `sys_permissions` VALUES ('36', 'role:delete', '角色删除', '21', '0');
INSERT INTO `sys_permissions` VALUES ('37', 'role:create', '角色创建', '21', '0');
INSERT INTO `sys_permissions` VALUES ('38', 'role:view', '角色查看', '21', '0');
INSERT INTO `sys_permissions` VALUES ('39', 'permission:delete', '权限删除', '21', '0');
INSERT INTO `sys_permissions` VALUES ('40', 'permission:create', '权限创建', '21', '0');
INSERT INTO `sys_permissions` VALUES ('41', 'permission:view', '权限查看', '21', '0');
INSERT INTO `sys_permissions` VALUES ('42', 'project:manage', '项目管理', '27', '0');
INSERT INTO `sys_permissions` VALUES ('43', 'project:distribution', '项目任务分配', '27', '0');
INSERT INTO `sys_permissions` VALUES ('44', 'project:develop', '项目开发', '28', '0');
INSERT INTO `sys_permissions` VALUES ('45', 'project:maintain', '项目维护', '28', '0');
INSERT INTO `sys_permissions` VALUES ('46', 'security:maintain', '安全维护', '30', '0');
INSERT INTO `sys_permissions` VALUES ('47', 'security:develop', '安全功能设计', '30', '0');
INSERT INTO `sys_permissions` VALUES ('48', 'security:test', '安全测试', '31', '0');
INSERT INTO `sys_permissions` VALUES ('49', 'security:bug-test', 'BUG检测', '31', '0');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父节点',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('21', 'admin', '总经理', '0', '0');
INSERT INTO `sys_roles` VALUES ('22', 'personnel', '人事部', '0', '0');
INSERT INTO `sys_roles` VALUES ('23', 'personnel-resource', '人力资源部部长', '22', '0');
INSERT INTO `sys_roles` VALUES ('24', 'personnel-administration', '行政部部长', '22', '0');
INSERT INTO `sys_roles` VALUES ('26', 'technical', '技术部', '0', '0');
INSERT INTO `sys_roles` VALUES ('27', 'technical-development', '项目经理', '26', '0');
INSERT INTO `sys_roles` VALUES ('28', 'technical-maintenance', '项目组组长', '26', '0');
INSERT INTO `sys_roles` VALUES ('29', 'security', '安全部', '0', '0');
INSERT INTO `sys_roles` VALUES ('30', 'security-net', '网络安全部负责人', '29', '0');
INSERT INTO `sys_roles` VALUES ('31', 'security-test', '项目安全测试人员', '29', '0');

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES ('1', '21', '35');
INSERT INTO `sys_roles_permissions` VALUES ('2', '21', '36');
INSERT INTO `sys_roles_permissions` VALUES ('3', '21', '37');
INSERT INTO `sys_roles_permissions` VALUES ('4', '21', '38');
INSERT INTO `sys_roles_permissions` VALUES ('5', '21', '39');
INSERT INTO `sys_roles_permissions` VALUES ('6', '21', '40');
INSERT INTO `sys_roles_permissions` VALUES ('7', '21', '41');
INSERT INTO `sys_roles_permissions` VALUES ('8', '23', '31');
INSERT INTO `sys_roles_permissions` VALUES ('9', '23', '32');
INSERT INTO `sys_roles_permissions` VALUES ('10', '23', '33');
INSERT INTO `sys_roles_permissions` VALUES ('11', '23', '34');
INSERT INTO `sys_roles_permissions` VALUES ('12', '27', '42');
INSERT INTO `sys_roles_permissions` VALUES ('13', '27', '43');
INSERT INTO `sys_roles_permissions` VALUES ('14', '28', '44');
INSERT INTO `sys_roles_permissions` VALUES ('15', '28', '45');
INSERT INTO `sys_roles_permissions` VALUES ('16', '30', '46');
INSERT INTO `sys_roles_permissions` VALUES ('17', '30', '47');
INSERT INTO `sys_roles_permissions` VALUES ('18', '31', '48');
INSERT INTO `sys_roles_permissions` VALUES ('19', '31', '49');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色列表',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'admin', '95657d3e3052fb39d70d610c70a9a575', '87cc486c53b49f72f5b96bb55d93bc7f', '超级管理员', '0');
INSERT INTO `sys_users` VALUES ('2', 'tycoding', '7de3848c92d39e98f7c74139f1a079d7', '6478ccf88032592fe9396f008408400b', '普通管理员', '0');
INSERT INTO `sys_users` VALUES ('3', '涂陌', '7247c372a4aae00c2f78239739384c0b', 'f0a35a4d99e23ad4a59616bd4d8eea02', '普通用户', '0');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '1', '21');
INSERT INTO `sys_users_roles` VALUES ('2', '2', '27');
INSERT INTO `sys_users_roles` VALUES ('3', '2', '30');
INSERT INTO `sys_users_roles` VALUES ('4', '3', '33');
INSERT INTO `sys_users_roles` VALUES ('5', '3', '34');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT '',
  `name1` varchar(255) DEFAULT '' COMMENT '用户称呼',
  `phone` varchar(255) DEFAULT '' COMMENT '电话号码',
  `loan_money` int(11) DEFAULT '0' COMMENT '贷款金娥,万元',
  `loan_time_limit` int(255) DEFAULT '0' COMMENT '贷款期限',
  `name2` varchar(255) DEFAULT '' COMMENT '本人姓名',
  `identity` varchar(255) DEFAULT '' COMMENT '职业身份',
  `fund` varchar(255) DEFAULT '0' COMMENT '本地公积金',
  `social_security` varchar(255) DEFAULT '0' COMMENT '社保',
  `house` varchar(255) DEFAULT '' COMMENT '名下是否有房',
  `car` varchar(255) DEFAULT '' COMMENT '名下是否有车',
  `insurance` varchar(255) DEFAULT '' COMMENT '是否有人寿保险',
  `credit` varchar(255) DEFAULT '' COMMENT '征信',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('34', 'creditLoan', 'zhaozhen', '15639068762', '369', '36', '爪痕', 'wage_earners', '1', '1', 'mortgageHouse', 'mortgageCar', '1', 'credit3', '2019-06-21 14:47:24', '2019-06-21 14:48:34');
INSERT INTO `user` VALUES ('35', 'mortgageLoan', 'zhen', '15090109700', '666666', '66666', 'zhaozhen', 'wage_earners', null, null, 'fullPaymentHouse', null, null, 'credit2', '2019-06-21 14:33:35', '2019-06-21 19:49:19');

-- ----------------------------
-- Table structure for wage_earner
-- ----------------------------
DROP TABLE IF EXISTS `wage_earner`;
CREATE TABLE `wage_earner` (
  `wage_earner_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '所属user的userid',
  `userPhone` varchar(255) DEFAULT '' COMMENT '用户电话',
  `user_name1` varchar(255) DEFAULT '' COMMENT '素数用户称呼',
  `salary_month` int(11) DEFAULT '0' COMMENT '工薪族工资',
  `salary_type` varchar(255) DEFAULT '' COMMENT '工资发放形式',
  `punch_time` varchar(255) DEFAULT '' COMMENT 'l连续打卡时间',
  `companyType` varchar(255) DEFAULT '' COMMENT '公司性质',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`wage_earner_id`),
  KEY `user_wage` (`user_id`),
  CONSTRAINT `user_wage` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wage_earner
-- ----------------------------
INSERT INTO `wage_earner` VALUES ('1', '34', '15639068762', 'zhaozhen', '222', 'bank', 'lessThreeMonth', 'personal_company', '2019-06-21 14:48:34', '2019-06-21 14:48:34');
INSERT INTO `wage_earner` VALUES ('2', '35', '15090109700', 'zhen', '222', 'bank', 'oneYearMore', 'listed_company', '2019-06-21 19:49:21', '2019-06-21 19:49:21');
