/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : jk_carSupply_db

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 28/05/2020 22:13:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_orders
-- ----------------------------
DROP TABLE IF EXISTS `car_orders`;
CREATE TABLE `car_orders` (
  `id` int(20) NOT NULL,
  `number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of car_orders
-- ----------------------------
BEGIN;
INSERT INTO `car_orders` VALUES (1, '23234234', 45.00);
INSERT INTO `car_orders` VALUES (2, 'ORD_00000002', 65.00);
INSERT INTO `car_orders` VALUES (3, 'ORD_00000003', 37.00);
INSERT INTO `car_orders` VALUES (4, 'ORD_00000004', 194.00);
INSERT INTO `car_orders` VALUES (5, 'ORD_00000005', 194.00);
COMMIT;

-- ----------------------------
-- Table structure for car_orders_details
-- ----------------------------
DROP TABLE IF EXISTS `car_orders_details`;
CREATE TABLE `car_orders_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '物品名称',
  `num` int(20) DEFAULT NULL COMMENT '物品数量',
  `produce` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '生产商',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `order_id` int(20) DEFAULT NULL COMMENT '订单外建',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of car_orders_details
-- ----------------------------
BEGIN;
INSERT INTO `car_orders_details` VALUES (1, '后视镜', 1, '北京', 20.00, 1);
INSERT INTO `car_orders_details` VALUES (2, '保险杠', 2, '上海', 30.00, 1);
INSERT INTO `car_orders_details` VALUES (11, '前保险杠', 1, '北京厂', 33.00, 2);
INSERT INTO `car_orders_details` VALUES (12, '前灯', 2, '北京厂', 16.00, 2);
INSERT INTO `car_orders_details` VALUES (19, '后视镜', 4, '北京厂', 1.00, 3);
INSERT INTO `car_orders_details` VALUES (20, '前保险杠', 1, '北京厂', 33.00, 3);
INSERT INTO `car_orders_details` VALUES (21, '前灯', 1, '北京厂', 16.00, 4);
INSERT INTO `car_orders_details` VALUES (22, '玻璃', 2, '北京厂', 89.00, 4);
INSERT INTO `car_orders_details` VALUES (23, '前灯', 1, '北京厂', 16.00, 5);
INSERT INTO `car_orders_details` VALUES (24, '玻璃', 2, '北京厂', 89.00, 5);
COMMIT;

-- ----------------------------
-- Table structure for cargoods
-- ----------------------------
DROP TABLE IF EXISTS `cargoods`;
CREATE TABLE `cargoods` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) DEFAULT NULL COMMENT '编号',
  `name` varchar(150) DEFAULT NULL COMMENT '配件名称',
  `produce` varchar(255) DEFAULT NULL COMMENT '生产厂商',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `type` varchar(30) DEFAULT NULL COMMENT '类型',
  `description` varchar(4000) DEFAULT NULL COMMENT '描述',
  `num` int(11) DEFAULT NULL COMMENT '销售数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cargoods
-- ----------------------------
BEGIN;
INSERT INTO `cargoods` VALUES (1, '001', '后视镜', '北京厂', 1.00, '1', '全金属外壳', 10);
INSERT INTO `cargoods` VALUES (2, '002', '玻璃', '北京厂', 89.00, '3', '钢化玻璃', 10);
INSERT INTO `cargoods` VALUES (3, '003', '前灯', '北京厂', 16.00, '4', '高亮度', 10);
INSERT INTO `cargoods` VALUES (4, '004', '前保险杠', '北京厂', 33.00, '2', '高强度', 10);
COMMIT;

-- ----------------------------
-- Table structure for tear_down_details
-- ----------------------------
DROP TABLE IF EXISTS `tear_down_details`;
CREATE TABLE `tear_down_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `produce` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cargoods_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tear_down_details
-- ----------------------------
BEGIN;
INSERT INTO `tear_down_details` VALUES (1, 2, '北京厂', '前保险杠', 1);
INSERT INTO `tear_down_details` VALUES (2, 2, '北京厂', '前灯', 2);
INSERT INTO `tear_down_details` VALUES (7, 3, '北京厂', '后视镜', 4);
INSERT INTO `tear_down_details` VALUES (8, 3, '北京厂', '前保险杠', 1);
INSERT INTO `tear_down_details` VALUES (9, 4, '北京厂', '前灯', 1);
INSERT INTO `tear_down_details` VALUES (10, 4, '北京厂', '玻璃', 2);
INSERT INTO `tear_down_details` VALUES (11, 5, '北京厂', '前灯', 1);
INSERT INTO `tear_down_details` VALUES (12, 5, '北京厂', '玻璃', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
