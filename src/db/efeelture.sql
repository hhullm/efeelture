#
# Source for table "db_user"
#

DROP TABLE IF EXISTS 'db_user';
CREATE TABLE 'db_user' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'phone' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '手机号',
  'name' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'type' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '使用者类型',
  'password' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码',
  'ipaddress' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'ip地址',
  'status' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户状态',
  'sex' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '性别',
  'age' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '年龄',
  'picture' varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片头像',
  'sign' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '签名',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_friend"
#

DROP TABLE IF EXISTS 'db_friend';
CREATE TABLE 'db_friend' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友id',
  'status' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友状态',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_hardware"
#

DROP TABLE IF EXISTS 'db_hardware';
CREATE TABLE 'db_hardware' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'userid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户id',
  'hardwareid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件id',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_ctrl"
#

DROP TABLE IF EXISTS 'db_ctrl';
CREATE TABLE 'db_ctrl' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'name' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件名',
  'status' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件状态',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '附加内容',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_like"
#

DROP TABLE IF EXISTS 'db_like';
CREATE TABLE 'db_like' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'uid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'user表pk',
  'mid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'message表pk',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


#
# Source for table "db_message"
#

DROP TABLE IF EXISTS 'db_message';
CREATE TABLE 'db_message' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态内容',
  'picture' varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态图片',
  'address' varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态地址',
  'status' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态状态',
  'permission' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态权限',
  'comment' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态评论',
  'likenumber' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '点赞数',
  'uname' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'uid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'user表pk',
  'type' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态类型',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_reply"
#

DROP TABLE IF EXISTS 'db_reply';
CREATE TABLE 'db_reply' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'mid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态id',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复时间',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户1id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户2id',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


#
# Source for table "db_object"
#

DROP TABLE IF EXISTS 'db_object';
CREATE TABLE 'db_object' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'temperature' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '温度',
  'humidity' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '湿度',
  'air' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '空气',
  'weekday' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '工作日',
  'peoplenumber' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '人数',
  'word' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友圈文字',
  'picturecolor' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片颜色',
  'picturenumber' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片数量',
  'music' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '音乐',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '时间',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


#
# Source for table "db_status"
#

DROP TABLE IF EXISTS 'db_status';
CREATE TABLE 'db_status' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'status' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '状态改变',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '状态改变时间',
  'ipaddress' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户ip',
  'uname' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'address' varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '地址',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Source for table "db_talk"
#

DROP TABLE IF EXISTS 'db_talk';
CREATE TABLE 'db_talk' (
  'id' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送方id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '接收方id',
  'type' varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天内容类型',
  'content' varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天内容',
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;