/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : hongqi

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 16/03/2019 12:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pbl
-- ----------------------------
DROP TABLE IF EXISTS `pbl`;
CREATE TABLE `pbl`  (
  `pblid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ptbid` bigint(20) NOT NULL,
  `ptbno` bigint(20) NOT NULL,
  `pblno` bigint(20) NOT NULL,
  `result` int(11) NOT NULL,
  `pbltext` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begintime` datetime(0) NULL DEFAULT NULL,
  `endtime` datetime(0) NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pblid`) USING BTREE,
  INDEX `idx_pbl_ptbid`(`ptbid`) USING BTREE,
  CONSTRAINT `FK_PTB` FOREIGN KEY (`ptbid`) REFERENCES `ptb` (`ptbid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 74913 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for prs
-- ----------------------------
DROP TABLE IF EXISTS `prs`;
CREATE TABLE `prs`  (
  `prsid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pblid` bigint(20) NOT NULL,
  `ptbno` bigint(20) NOT NULL,
  `pblno` bigint(20) NOT NULL,
  `statno` bigint(20) NOT NULL,
  `stattext` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `statflag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` int(11) NOT NULL,
  `datatype` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `format` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `testvalue` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `testseq` int(11) NULL DEFAULT NULL,
  `targetvalue` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upper` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lower` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  `cdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`prsid`) USING BTREE,
  INDEX `idx_prs_pblid`(`pblid`) USING BTREE,
  CONSTRAINT `FK_PBL` FOREIGN KEY (`pblid`) REFERENCES `pbl` (`pblid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 926348 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ptb
-- ----------------------------
DROP TABLE IF EXISTS `ptb`;
CREATE TABLE `ptb`  (
  `ptbid` bigint(20) NOT NULL AUTO_INCREMENT,
  `resulttestid` bigint(20) NOT NULL,
  `ptbno` bigint(20) NOT NULL,
  `ptbtext` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ptbid`) USING BTREE,
  INDEX `idx_ptb_resulttestid`(`resulttestid`) USING BTREE,
  CONSTRAINT `FK_resulttestid` FOREIGN KEY (`resulttestid`) REFERENCES `result_test` (`resulttestid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21244 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result`  (
  `resultid` bigint(11) NOT NULL AUTO_INCREMENT,
  `tel` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `ident` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0undoing 1,doing',
  `cdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`resultid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1718 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for result_test
-- ----------------------------
DROP TABLE IF EXISTS `result_test`;
CREATE TABLE `result_test`  (
  `resulttestid` bigint(20) NOT NULL AUTO_INCREMENT,
  `knr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cartype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `system` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sysnr` int(11) NOT NULL,
  `releasenr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `testplace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `asvversion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `odxversion` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` int(11) NOT NULL,
  `testorder` int(11) NULL DEFAULT NULL,
  `shift` int(11) NULL DEFAULT NULL,
  `testtimestamp` datetime(0) NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`resulttestid`) USING BTREE,
  INDEX `idx_resultTest_testtime`(`testtimestamp`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20781 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rpd_release
-- ----------------------------
DROP TABLE IF EXISTS `rpd_release`;
CREATE TABLE `rpd_release`  (
  `releasenr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `system` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `releaseconfig` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `releasefilepath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `releasedesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assigntime` datetime(0) NULL DEFAULT NULL,
  `recordtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `creationtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`releasenr`) USING BTREE,
  INDEX `idx_release_system`(`system`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rpd_release_context
-- ----------------------------
DROP TABLE IF EXISTS `rpd_release_context`;
CREATE TABLE `rpd_release_context`  (
  `rpdreleasecontextid` bigint(20) NOT NULL AUTO_INCREMENT,
  `releasenr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modulename` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `attrname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`rpdreleasecontextid`) USING BTREE,
  INDEX `idx_rpd_release_context_releasenr`(`releasenr`) USING BTREE,
  INDEX `idx_rpd_release_context_modulename`(`modulename`) USING BTREE,
  INDEX `idx_rpd_release_context_attrname`(`attrname`) USING BTREE,
  INDEX `idx_rpd_release_context_context`(`context`) USING BTREE,
  INDEX `idx_rpd_release_context_m_a_c`(`modulename`, `attrname`, `context`) USING BTREE,
  CONSTRAINT `FK_releasenr` FOREIGN KEY (`releasenr`) REFERENCES `rpd_release` (`releasenr`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rpd_runtime
-- ----------------------------
DROP TABLE IF EXISTS `rpd_runtime`;
CREATE TABLE `rpd_runtime`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `runtime_nr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `system` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `runtime_file_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `assigntime` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_release_system`(`system`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rpd_tester
-- ----------------------------
DROP TABLE IF EXISTS `rpd_tester`;
CREATE TABLE `rpd_tester`  (
  `rpdtesterid` bigint(20) NOT NULL AUTO_INCREMENT,
  `system` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sysnr` int(11) NULL DEFAULT NULL,
  `currentreleasenr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assignedreleasenr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `downloadfinshtime` datetime(0) NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  `current_runtime_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assigned_runtime_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serial_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rpdtesterid`) USING BTREE,
  INDEX `idx_rpd_tester_system`(`system`) USING BTREE,
  INDEX `idx_rpd_tester_sysnr`(`sysnr`) USING BTREE,
  INDEX `idx_rpd_tester_currentreleasenr`(`currentreleasenr`) USING BTREE,
  INDEX `idx_rpd_tester_assignedreleasenr`(`assignedreleasenr`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for snx_fis_push
-- ----------------------------
DROP TABLE IF EXISTS `snx_fis_push`;
CREATE TABLE `snx_fis_push`  (
  `sfpid` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NULL DEFAULT NULL,
  `testvalue` varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `resulttestid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`sfpid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for statistics_lang
-- ----------------------------
DROP TABLE IF EXISTS `statistics_lang`;
CREATE TABLE `statistics_lang`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stat_key` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stat_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `alias` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `releasenr` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lang` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_stat_key`(`stat_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 411401 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_auth`;
CREATE TABLE `tb_auth`  (
  `auth_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'auth name',
  `auth_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'auth path',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'parent id',
  `auth_description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'desc',
  `icons` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'icon',
  `auth_order` int(3) NULL DEFAULT NULL COMMENT 'order',
  `cdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `udate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`auth_id`) USING BTREE,
  INDEX `idx_tb_auth_auth_name`(`auth_name`) USING BTREE,
  INDEX `idx_tb_auth_auth_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_notifymessage
-- ----------------------------
DROP TABLE IF EXISTS `tb_notifymessage`;
CREATE TABLE `tb_notifymessage`  (
  `notifymessageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `deviceid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notifytype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`notifymessageid`) USING BTREE,
  UNIQUE INDEX `idx_notifymessage_deviceip_notifytype`(`deviceid`, `notifytype`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_odxfile
-- ----------------------------
DROP TABLE IF EXISTS `tb_odxfile`;
CREATE TABLE `tb_odxfile`  (
  `odxlistid` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileVersion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attrname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`odxlistid`) USING BTREE,
  UNIQUE INDEX `idx_tb_odxfile_n_v_id`(`fileName`, `fileVersion`, `fileID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `udate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE,
  INDEX `idx_tb_role_role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_auth`;
CREATE TABLE `tb_role_auth`  (
  `role_auth_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `auth_id` bigint(20) NOT NULL,
  `cdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_auth_id`) USING BTREE,
  INDEX `idx_tb_role_auth_role_id`(`role_id`) USING BTREE,
  INDEX `idx_tb_role_auth_auth_id`(`auth_id`) USING BTREE,
  CONSTRAINT `FK_auth_id` FOREIGN KEY (`auth_id`) REFERENCES `tb_auth` (`auth_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_role_id_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 138 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_task
-- ----------------------------
DROP TABLE IF EXISTS `tb_task`;
CREATE TABLE `tb_task`  (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `udate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码，采用MD5加密的方式',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `cdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `udate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `idx_tb_user_name`(`name`) USING BTREE,
  INDEX `idx_tb_user_password`(`password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `cdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `idx_tb_user_role_user_id`(`user_id`) USING BTREE,
  INDEX `idx_tb_user_role_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vehicle_data
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_data`;
CREATE TABLE `vehicle_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vin` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `carType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `vin`(`vin`) USING BTREE,
  UNIQUE INDEX `pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1473 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vpdm_context
-- ----------------------------
DROP TABLE IF EXISTS `vpdm_context`;
CREATE TABLE `vpdm_context`  (
  `vpdmcontextid` bigint(20) NOT NULL AUTO_INCREMENT,
  `modulename` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `attrname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`vpdmcontextid`) USING BTREE,
  INDEX `idx_vpdm_context_modulename`(`modulename`) USING BTREE,
  INDEX `idx_vpdm_context_attrname`(`attrname`) USING BTREE,
  INDEX `idx_vpdm_context_context`(`context`) USING BTREE,
  INDEX `idx_vpdm_context_m_a_c`(`modulename`, `attrname`, `context`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vpdm_tester_context
-- ----------------------------
DROP TABLE IF EXISTS `vpdm_tester_context`;
CREATE TABLE `vpdm_tester_context`  (
  `vpdmtestercontextid` bigint(20) NOT NULL AUTO_INCREMENT,
  `rpdtesterid` bigint(20) NOT NULL,
  `releasenr` bigint(20) NOT NULL,
  `modulename` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vpdmcontextid` bigint(20) NULL DEFAULT NULL,
  `assigntime` datetime(0) NULL DEFAULT NULL,
  `downloadfinishtime` datetime(0) NULL DEFAULT NULL,
  `recordtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`vpdmtestercontextid`) USING BTREE,
  INDEX `idx_vpdm_test_context_rpdtesterid`(`rpdtesterid`) USING BTREE,
  INDEX `idx_vpdm_test_context_releasenr`(`releasenr`) USING BTREE,
  INDEX `idx_vpdm_test_context_modulename`(`modulename`) USING BTREE,
  INDEX `idx_vpdm_test_context_vpdmcontextid`(`vpdmcontextid`) USING BTREE,
  CONSTRAINT `FK_TESTER_ID` FOREIGN KEY (`rpdtesterid`) REFERENCES `rpd_tester` (`rpdtesterid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- View structure for user_role_view
-- ----------------------------
DROP VIEW IF EXISTS `user_role_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_role_view` AS select `t3`.`role_name` AS `role_name`,`t2`.`user_id` AS `user_id` from (`tb_role` `t3` join `tb_user_role` `t2`) where (`t2`.`role_id` = `t3`.`role_id`);

-- ----------------------------
-- Procedure structure for test_insert
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_insert`;
delimiter ;;
CREATE PROCEDURE `test_insert`()
BEGIN 
DECLARE y TINYINT DEFAULT 100;
WHILE y<200
DO
INSERT INTO tb_repairshop ( NAME, parent_no, shop_no, description, contact, tel, address, cdate ) VALUES ( y, 0,y, y, y, '15221491640',y, NOW() );
SET y=y+1; 
END WHILE ; 
commit; 
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
