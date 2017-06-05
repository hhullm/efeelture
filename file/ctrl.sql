#
# Source for table "db_ctrl"
#

DROP TABLE IF EXISTS 'db_ctrl';
CREATE TABLE 'db_ctrl' (
  'cid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'name' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件名',
  'status' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件状态',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '附加内容',
  PRIMARY KEY ('cid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;