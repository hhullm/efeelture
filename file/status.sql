#
# Source for table "db_status"
#

DROP TABLE IF EXISTS 'db_status';
CREATE TABLE 'db_status' (
  'sid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'status' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '状态改变',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '状态改变时间',
  'ipaddress' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户ip',
  'uname' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'address' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '地址',
  PRIMARY KEY ('sid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;