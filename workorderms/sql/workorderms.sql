/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : workorderms

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 20/05/2020 17:56:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for workorder
-- ----------------------------
DROP TABLE IF EXISTS `workorder`;
CREATE TABLE `workorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `number` varchar(30) NOT NULL COMMENT '工单编号',
  `name` varchar(100) NOT NULL COMMENT '工单名称',
  `content` text NOT NULL COMMENT '工单内容',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '完成时间',
  `role` varchar(30) NOT NULL COMMENT '角色',
  `executor` varchar(30) NOT NULL COMMENT '执行人',
  `status` varchar(10) NOT NULL DEFAULT '0' COMMENT '工单执行状态：1-已执行，0-未执行',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=930 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workorder
-- ----------------------------
BEGIN;
INSERT INTO `workorder` VALUES (899, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 19:00:00', '2020-05-19 20:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (900, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 20:00:00', '2020-05-19 21:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (901, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 21:00:00', '2020-05-19 22:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (902, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 22:00:00', '2020-05-19 23:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (903, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 23:00:00', '2020-05-20 00:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (904, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 00:00:00', '2020-05-20 01:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (905, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 01:00:00', '2020-05-20 02:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (906, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 02:00:00', '2020-05-20 03:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (907, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 03:00:00', '2020-05-20 04:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (908, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 04:00:00', '2020-05-20 05:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (909, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 05:00:00', '2020-05-20 06:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (910, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 06:00:00', '2020-05-20 07:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (911, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 07:00:00', '2020-05-20 08:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (912, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 08:00:00', '2020-05-20 09:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (913, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 09:00:00', '2020-05-20 10:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (914, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 10:00:00', '2020-05-20 11:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (915, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 11:00:00', '2020-05-20 12:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (916, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 12:00:00', '2020-05-20 13:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (917, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 13:00:00', '2020-05-20 14:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (918, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 14:00:00', '2020-05-20 15:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (919, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 15:00:00', '2020-05-20 16:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (920, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 16:00:00', '2020-05-20 17:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (921, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 17:00:00', '2020-05-20 18:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (922, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 18:00:00', '2020-05-20 19:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (923, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 19:00:00', '2020-05-20 20:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (924, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 20:00:00', '2020-05-20 21:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (925, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 21:00:00', '2020-05-20 22:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (926, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 22:00:00', '2020-05-20 23:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (927, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-20 23:00:00', '2020-05-21 00:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (928, 'DS20200518000003', '泛亚技术', '通用汽车新增工单(天)', '2020-05-19 00:00:00', '2020-05-20 00:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (929, 'DS20200518000003', '泛亚技术', '通用汽车新增工单(天)', '2020-05-20 00:00:00', '2020-05-21 00:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (880, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 00:00:00', '2020-05-19 01:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (881, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 01:00:00', '2020-05-19 02:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (882, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 02:00:00', '2020-05-19 03:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (883, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 03:00:00', '2020-05-19 04:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (884, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 04:00:00', '2020-05-19 05:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (885, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 05:00:00', '2020-05-19 06:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (886, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 06:00:00', '2020-05-19 07:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (887, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 07:00:00', '2020-05-19 08:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (888, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 08:00:00', '2020-05-19 09:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (889, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 09:00:00', '2020-05-19 10:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (890, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 10:00:00', '2020-05-19 11:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (891, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 11:00:00', '2020-05-19 12:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (892, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 12:00:00', '2020-05-19 13:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (893, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 13:00:00', '2020-05-19 14:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (894, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 14:00:00', '2020-05-19 15:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (895, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 15:00:00', '2020-05-19 16:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (896, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 16:00:00', '2020-05-19 17:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (897, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 17:00:00', '2020-05-19 18:00:00', 'admin', 'jiker', '0');
INSERT INTO `workorder` VALUES (898, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '2020-05-19 18:00:00', '2020-05-19 19:00:00', 'admin', 'jiker', '0');
COMMIT;

-- ----------------------------
-- Table structure for workorder_plan
-- ----------------------------
DROP TABLE IF EXISTS `workorder_plan`;
CREATE TABLE `workorder_plan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `number` varchar(30) NOT NULL COMMENT '工单编号',
  `name` varchar(100) NOT NULL COMMENT '工单名称',
  `content` text NOT NULL COMMENT '工单内容',
  `cycle` varchar(30) NOT NULL COMMENT '执行周期',
  `plan_start_time` datetime NOT NULL COMMENT '计划开始时间',
  `plan_end_time` datetime NOT NULL COMMENT '计划完成时间',
  `role` varchar(30) NOT NULL COMMENT '角色',
  `executor` varchar(30) NOT NULL COMMENT '执行人',
  `status` varchar(10) NOT NULL DEFAULT '0' COMMENT '工单生成状态：1-已生成，0-未生成',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workorder_plan
-- ----------------------------
BEGIN;
INSERT INTO `workorder_plan` VALUES (1, 'DS20200518000001', '通用汽车', '通用汽车新增工单(时)', '0 0 0 * * *', '2020-05-19 00:00:00', '2020-05-21 00:00:00', 'admin', 'jiker', '1');
INSERT INTO `workorder_plan` VALUES (3, 'DS20200518000003', '泛亚技术', '通用汽车新增工单(天)', '0 0 2 * * *', '2020-05-19 00:00:00', '2020-05-21 00:00:00', 'admin', 'jiker', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
