#
# Source for table "db_message"
#

DROP TABLE IF EXISTS 'db_message';
CREATE TABLE 'db_message' (
  'mid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'content' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态内容',
  'picture' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态图片',
  'address' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态地址',
  'status' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态状态',
  'permission' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态权限',
  'comment' varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态评论',
  'likenumber' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '点赞数',
  'uname' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
  'uid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'user表pk',
  'type' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '动态类型',
  PRIMARY KEY ('mid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;