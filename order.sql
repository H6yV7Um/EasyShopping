/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-23 16:08:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `filelist`
-- ----------------------------
DROP TABLE IF EXISTS `filelist`;
CREATE TABLE `filelist` (
  `id` text,
  `refid` text,
  `filePath` text,
  `name` text,
  `creator` text,
  `createTime` date DEFAULT NULL,
  `path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filelist
-- ----------------------------
INSERT INTO `filelist` VALUES ('26edff73-a100-4f3b-bfa1-e897f79178c1', '81ac8e2f-3780-41c2-aa72-b1c1fb314ce2', null, '26edff73-a100-4f3b-bfa1-e897f79178c1.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('9a8a64ce-8ba2-4869-a7e6-2e7e49b8711c', '4d49706b-4ab5-4c0d-8625-fe9923c3806d', null, '9a8a64ce-8ba2-4869-a7e6-2e7e49b8711c.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('881b80c1-f970-4b3e-b001-7ab72cda1e10', null, null, '881b80c1-f970-4b3e-b001-7ab72cda1e10.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('d5a1d66b-5a67-437b-91df-9bd7a62d6d76', '2b9350c7-ee4d-40b1-b23d-96e8574d7b43', null, 'd5a1d66b-5a67-437b-91df-9bd7a62d6d76.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('0d818d5c-e6fa-42f5-9540-43bc99ae4069', '3ee3dff8-5ffe-47a9-90ba-a3653d8cfa39', null, '0d818d5c-e6fa-42f5-9540-43bc99ae4069.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('56dff3a1-081b-4067-b9ff-ba66ab1482ba', '4df94b59-8bc9-486b-977a-e894cf84cdb8', null, '56dff3a1-081b-4067-b9ff-ba66ab1482ba.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('9cb00914-1d2f-429e-937d-9a3a81b97c7a', '7b96b5f1-2ca2-4ee4-a79c-db12f3be0a31', null, '9cb00914-1d2f-429e-937d-9a3a81b97c7a.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('d2ce4da5-3f91-450d-8950-36521f28e449', '9564b528-9070-4cad-80f1-5b158ff11b9c', null, 'd2ce4da5-3f91-450d-8950-36521f28e449.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('9a1fd6eb-4909-4b17-8ee2-c679a9781c6c', null, null, '9a1fd6eb-4909-4b17-8ee2-c679a9781c6c.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('545c3e62-b114-42b3-ad00-3b069dc12bb5', null, null, '545c3e62-b114-42b3-ad00-3b069dc12bb5.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('5422541e-abd7-41c9-95c7-990ace683031', '80f51763-2180-4d01-ac54-c9799a4b2d50', null, '5422541e-abd7-41c9-95c7-990ace683031.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('07146d30-f372-4cc0-ae2a-a0f0e13fbf9c', '892bdeae-cbbf-4138-b20a-8270ed871c47', null, '07146d30-f372-4cc0-ae2a-a0f0e13fbf9c.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('abb12b6f-4efb-46a4-90ae-13bc2d88983d', 'aa274027-4a63-457a-8ee7-81edc9269d88', null, 'abb12b6f-4efb-46a4-90ae-13bc2d88983d.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('13bce26d-210a-4da8-894f-c98acab7ccee', 'a32c7091-f5f5-4952-9297-665ccecf36e6', null, '13bce26d-210a-4da8-894f-c98acab7ccee.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('5f21ea23-ab55-4183-ab40-3462b086883b', null, null, '5f21ea23-ab55-4183-ab40-3462b086883b.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('f4e8850c-2292-4f39-b6c2-a7e4b14c2c73', '5bc8b4e8-94b5-4a58-a128-7e815a02425d', null, 'f4e8850c-2292-4f39-b6c2-a7e4b14c2c73.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('9dbfbdc7-d958-42b3-ada5-3be7710be05d', 'd157a88a-1978-4e76-ba3c-5fa5009a4605', null, '9dbfbdc7-d958-42b3-ada5-3be7710be05d.png', null, null, null);
INSERT INTO `filelist` VALUES ('67d2b514-f650-4476-ab24-7ed1f4c61bbf', '11d716eb-d3c1-4baa-8fc1-7b8eeca6395e', null, '67d2b514-f650-4476-ab24-7ed1f4c61bbf.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('11fa61a1-8756-430d-9d47-19bfcf2c45c1', 'e424343d-592e-4049-a77e-f13b7f4084fc', null, '11fa61a1-8756-430d-9d47-19bfcf2c45c1.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('c0174d7a-c288-401f-a3a6-a8eca863e00a', '3fd961c0-25e3-43de-8810-f285376ad1be', null, 'c0174d7a-c288-401f-a3a6-a8eca863e00a.jpg', null, null, null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` text CHARACTER SET utf8 NOT NULL,
  `name` text CHARACTER SET utf8,
  `imageId` text CHARACTER SET utf8,
  `creator` text,
  `colorName` text CHARACTER SET utf8,
  `colorNum` text CHARACTER SET utf8,
  `price` double DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `createTime` date DEFAULT NULL,
  `path` text,
  `status` text COMMENT '办理状态'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('11d716eb-d3c1-4baa-8fc1-7b8eeca6395e', 'ui还好', '67d2b514-f650-4476-ab24-7ed1f4c61bbf', null, null, null, '0', null, '2018-03-22', null, '1');
INSERT INTO `goods` VALUES ('e424343d-592e-4049-a77e-f13b7f4084fc', '肉', '11fa61a1-8756-430d-9d47-19bfcf2c45c1', null, null, null, '0', null, '2018-03-22', null, '1');
INSERT INTO `goods` VALUES ('3fd961c0-25e3-43de-8810-f285376ad1be', '试试看', 'c0174d7a-c288-401f-a3a6-a8eca863e00a', null, null, null, '0', null, '2018-03-22', null, '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` text,
  `name` text,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin', 'admin', '1');

-- ----------------------------
-- Table structure for `roleuser`
-- ----------------------------
DROP TABLE IF EXISTS `roleuser`;
CREATE TABLE `roleuser` (
  `id` text NOT NULL,
  `roleId` text,
  `roleName` text,
  `userName` text,
  `userId` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleuser
-- ----------------------------
INSERT INTO `roleuser` VALUES ('admin', 'admin', 'admin', 'ldh', 'admin');

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `id` text,
  `orderId` text,
  `createTime` text,
  `creator` text,
  `status` text,
  `userId` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcart
-- ----------------------------

-- ----------------------------
-- Table structure for `shoporder`
-- ----------------------------
DROP TABLE IF EXISTS `shoporder`;
CREATE TABLE `shoporder` (
  `id` text CHARACTER SET utf8 NOT NULL,
  `goodsId` text CHARACTER SET utf8,
  `type` text,
  `creator` text,
  `createTime` date DEFAULT NULL,
  `creatorId` text,
  `total` double DEFAULT NULL,
  `num` double DEFAULT NULL,
  `status` text COMMENT '办理状态'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoporder
-- ----------------------------
INSERT INTO `shoporder` VALUES ('21f350ef-cc77-45cb-bbbf-1ccded832246', '11d716eb-d3c1-4baa-8fc1-7b8eeca6395e', '1', 'admin', '2018-03-22', 'admin', '0', '0', '3');
INSERT INTO `shoporder` VALUES ('1261fa3a-2d56-4f13-bf29-d2292f4a41f9', 'e424343d-592e-4049-a77e-f13b7f4084fc', '1', 'admin', '2018-03-22', 'admin', '0', '0', '3');
INSERT INTO `shoporder` VALUES ('9ad909cd-25fe-4b49-911b-f081195c70d1', '3fd961c0-25e3-43de-8810-f285376ad1be', '1', 'admin', '2018-03-22', 'admin', '0', '0', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` text CHARACTER SET utf8 NOT NULL,
  `name` text CHARACTER SET utf8,
  `sex` text,
  `birthday` date DEFAULT NULL,
  `address` text,
  `registerId` text,
  `pwd` text NOT NULL,
  `loginId` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('qwer', '123', null, null, null, '15217636961', '123456', '123');
INSERT INTO `user` VALUES ('test1', 'test1', null, null, null, 'test1', '123', 'test1');
INSERT INTO `user` VALUES ('test2', 'test2', null, null, null, 'test2', '123', 'test2');
INSERT INTO `user` VALUES ('wet', '1', null, null, null, null, 'a', 'a');
INSERT INTO `user` VALUES ('admin', 'admin', null, null, null, null, 'ldh', 'ldh');
INSERT INTO `user` VALUES ('a349881c-e8c4-4e0d-a9dd-bc9726e680c2', '然后给', null, null, null, null, 'a123456', '15217636960');
