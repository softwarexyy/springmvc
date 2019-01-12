
CREATE TABLE `userinfo` (
  `USERID` varchar(32) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `to_userinfo` (
  `id` varchar(64) NOT NULL COMMENT '用户ID',
  `name` varchar(45) NOT NULL COMMENT '用户名/登录名',
  `gender` varchar(45) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(45) DEFAULT NULL COMMENT '生日',
  `logintime` int(11) DEFAULT NULL COMMENT '登录次数',
  `lastlogintime` varchar(45) DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tu_id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查看个人信息'

CREATE TABLE `to_accinfo` (
  `userid` varchar(64) NOT NULL COMMENT '用户ID',
  `account` varchar(32) NOT NULL COMMENT '账户(银行卡号)',
  `currentdeposit` double NOT NULL COMMENT '活期存款',
  `timedeposit` double NOT NULL COMMENT '定期存款',
  `finacialdeposit` double NOT NULL COMMENT '其他理财金',
  PRIMARY KEY (`userid`,`account`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户信息表'