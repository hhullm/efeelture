#
# Source for table "db_friend"
#

DROP TABLE IF EXISTS 'db_friend';
CREATE TABLE 'db_friend' (
  'fid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'firstid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户id',
  'secondid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友id',
  'status' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友状态',
  PRIMARY KEY ('fid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;