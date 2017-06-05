#
# Source for table "db_hardware"
#

DROP TABLE IF EXISTS 'db_hardware';
CREATE TABLE 'db_hardware' (
  'hid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'userid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户id',
  'hardwareid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '硬件id',
  PRIMARY KEY ('hid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;