# Host: 115.159.120.220  (Version 5.7.15)
# Date: 2017-06-10 02:50:30
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "db_ctrl"
#

DROP TABLE IF EXISTS `db_ctrl`;
CREATE TABLE `db_ctrl` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'user pk',
  `hid` varchar(32) NOT NULL DEFAULT '' COMMENT 'hardware pk',
  `uname` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  `hname` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件名',
  `uipaddress` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ip',
  `ctime` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '控制时间',
  `clevel` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件状态',
  `content` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '附加内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_friend"
#

DROP TABLE IF EXISTS `db_friend`;
CREATE TABLE `db_friend` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `firstid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `secondid` varchar(32) NOT NULL DEFAULT '' COMMENT '朋友id',
  `fstatus` varchar(32) NOT NULL DEFAULT '1' COMMENT '朋友状态 0删除 1好友',
  `ftime` varchar(32) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_hardware_match"
#

DROP TABLE IF EXISTS `db_hardware_match`;
CREATE TABLE `db_hardware_match` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `hardwareid` varchar(32) NOT NULL DEFAULT '' COMMENT '硬件id',
  `htime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_jective"
#

DROP TABLE IF EXISTS `db_jective`;
CREATE TABLE `db_jective` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'user pk',
  `temperature` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '温度',
  `humidity` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '湿度',
  `air` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '空气',
  `weekday` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '工作日 0不是工作日 1是工作日',
  `peoplenumber` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '人数',
  `word` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友圈文字',
  `picturecolor` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片颜色',
  `picturenumber` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片数量',
  `music` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '音乐',
  `jtime` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_like"
#

DROP TABLE IF EXISTS `db_like`;
CREATE TABLE `db_like` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'user表pk',
  `messageid` varchar(32) NOT NULL DEFAULT '' COMMENT 'message表pk',
  `ltime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_message"
#

DROP TABLE IF EXISTS `db_message`;
CREATE TABLE `db_message` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `content` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态内容',
  `picture` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态图片',
  `address` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态地址',
  `mstatus` varchar(32) NOT NULL DEFAULT '1' COMMENT '动态状态 0删除 1保存',
  `permission` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态权限 0自己可见 1好友可见 2所有人可见',
  `likenumber` varchar(32) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `uname` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'user表pk',
  `mtype` varchar(32) NOT NULL DEFAULT '0' COMMENT '动态类型 0所有 1学习交流 2情感天地 3生活趣事',
  `mtime` varchar(32) DEFAULT NULL,
  `jword` varchar(8) DEFAULT NULL,
  `jpicturecolor` varchar(8) DEFAULT NULL,
  `jpicturenumber` varchar(8) DEFAULT NULL,
  `jmusic` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_reply"
#

DROP TABLE IF EXISTS `db_reply`;
CREATE TABLE `db_reply` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `messageid` varchar(32) NOT NULL DEFAULT '' COMMENT '动态id',
  `rtime` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复时间',
  `firstid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户1id',
  `secondid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户2id',
  `content` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_status"
#

DROP TABLE IF EXISTS `db_status`;
CREATE TABLE `db_status` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `uid` varchar(32) NOT NULL DEFAULT '' COMMENT 'user pk',
  `sstatus` varchar(32) NOT NULL DEFAULT '0' COMMENT '状态改变 0离线 1在线',
  `stime` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '状态改变时间',
  `ipaddress` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户ip',
  `ipport` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户port',
  `uname` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  `address` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_talk"
#

DROP TABLE IF EXISTS `db_talk`;
CREATE TABLE `db_talk` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `firstid` varchar(32) NOT NULL DEFAULT '' COMMENT '发送方id',
  `secondid` varchar(32) NOT NULL DEFAULT '' COMMENT '接收方id',
  `ttype` varchar(32) NOT NULL DEFAULT '0' COMMENT '聊天内容类型 0文本 1语音 2视频',
  `content` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天内容',
  `ttime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "db_user"
#

DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  `phone` varchar(32) NOT NULL DEFAULT '12345678900' COMMENT '手机号',
  `uname` varchar(32) DEFAULT 'machine' COMMENT '用户名',
  `utype` varchar(32) DEFAULT '0' COMMENT '使用者类型 0机器 1用户',
  `upassword` varchar(32) DEFAULT NULL COMMENT '密码',
  `ipaddress` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'ip地址',
  `ustatus` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户状态 0离线 1在线',
  `sex` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '性别',
  `age` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '年龄',
  `picture` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片头像',
  `sign` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '签名',
  `utime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
