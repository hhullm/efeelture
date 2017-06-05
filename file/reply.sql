#
# Source for table "db_reply"
#

DROP TABLE IF EXISTS 'db_reply';
CREATE TABLE 'db_reply' (
  'rid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'mid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态id',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复时间',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户1id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户2id',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY ('rid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;