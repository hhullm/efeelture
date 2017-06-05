#
# Source for table "db_user"
#

DROP TABLE IF EXISTS 'db_user';
CREATE TABLE 'db_user' (
  'uid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'phone' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '手机号',
  'name' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'type' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '使用者类型',
  'password' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码',
  'ipaddress' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'ip地址',
  'status' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户状态',
  'sex' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '性别',
  'age' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '年龄',
  'picture' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图片头像',
  'sign' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '签名',
  PRIMARY KEY ('uid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;