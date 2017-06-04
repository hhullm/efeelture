#
# Source for table "db_like"
#

DROP TABLE IF EXISTS `db_like`;
CREATE TABLE `db_like` (
  `lid` varchar(16) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '评论表的主键',
  `uid` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '评论表的内容',
  `mid` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '评论的时间',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

