#
# Source for table "db_object"
#

DROP TABLE IF EXISTS 'db_object';
CREATE TABLE 'db_object' (
  'oid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'temperature' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '温度',
  'humidity' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '湿度',
  'air' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '空气',
  'weekdays' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '工作日',
  'amountofpeople' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '人数',
  'words' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '朋友圈文字',
  'pic_colors' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片颜色',
  'pic_amounts' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片数量',
  'music' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '音乐',
  'time' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '时间',
  PRIMARY KEY ('oid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;