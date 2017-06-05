#
# Source for table "db_like"
#

DROP TABLE IF EXISTS 'db_like';
CREATE TABLE 'db_like' (
  'lid' varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT 'pk',
  'uid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'user表pk',
  'mid' varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'message表pk',
  PRIMARY KEY ('lid')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

