#
# Source for table "db_like"
#

DROP TABLE IF EXISTS `db_like`;
CREATE TABLE `db_like` (
  `lid` varchar(16) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '���ޱ������',
  `uid` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '���ޱ����',
  `mid` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '���޵���Ϣ',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

