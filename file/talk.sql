#
# Source for table "db_talk"
#

DROP TABLE IF EXISTS 'db_talk';
CREATE TABLE 'db_talk' (
  'tid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送方id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '接收方id',
  'type' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天内容类型',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '聊天内容',
  PRIMARY KEY ('tid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;