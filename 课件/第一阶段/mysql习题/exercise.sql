
#
# Structure for table "dept"
#

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) DEFAULT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "dept"
#

INSERT INTO `dept` VALUES (10,'教研部','北京'),(20,'学工部','上海'),(30,'销售部','广州'),(40,'财务部','深圳');

#
# Structure for table "emp"
#

DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) DEFAULT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "emp"
#

INSERT INTO `emp` VALUES (1001,'甘宁','文员',1013,'2000-12-17',8000.00,NULL,20),(1002,'黛绮丝','销售员',1006,'2001-02-20',16000.00,3000.00,30),(1003,'殷天正','销售员',1006,'2001-02-22',12500.00,5000.00,30),(1004,'刘备','经理',1009,'2001-04-02',29750.00,NULL,20),(1005,'谢逊','销售员',1006,'2001-09-28',12500.00,14000.00,30),(1006,'关羽','经理',1009,'2001-05-01',28500.00,NULL,30),(1007,'张飞','经理',1009,'2001-09-01',24500.00,NULL,10),(1008,'诸葛亮','分析师',1004,'2007-04-19',30000.00,NULL,20),(1009,'曾阿牛','董事长',NULL,'2001-11-17',50000.00,NULL,10),(1010,'韦一笑','销售员',1006,'2011-09-08',15000.00,0.00,30),(1011,'周泰','文员',1008,'2007-05-23',11000.00,NULL,20),(1012,'程普','文员',1006,'2001-12-03',9500.00,NULL,30),(1013,'庞统','分析师',1004,'2001-12-03',30000.00,NULL,20),(1014,'黄盖','文员',1007,'2002-01-23',13000.00,NULL,10),(1015,'张三','保洁员',1001,'2013-05-01',80000.00,50000.00,50);

#
# Structure for table "profit"
#

DROP TABLE IF EXISTS `profit`;
CREATE TABLE `profit` (
  `year` year(4) DEFAULT NULL,
  `zz` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "profit"
#

INSERT INTO `profit` VALUES (2010,100),(2011,150),(2012,250),(2013,800),(2014,1000);

#
# Structure for table "salgrade"
#

DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `GRADE` int(11) NOT NULL DEFAULT '0' COMMENT '工资的等级',
  `LOwSAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最低工资',
  `HISAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最高工资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资等级表';

#
# Data for table "salgrade"
#

INSERT INTO `salgrade` VALUES (1,7000.00,12000.00),(2,12010.00,14000.00),(3,14010.00,20000.00),(4,20010.00,30000.00),(5,30010.00,99990.00);

#
# Structure for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_id` int(10) NOT NULL,
  `c_name` varchar(20) DEFAULT NULL,
  `greade` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "score"
#

INSERT INTO `score` VALUES (1,901,'计算机',98),(2,901,'英语',80),(3,902,'计算机',65),(4,902,'中文',88),(5,903,'中文',95),(6,904,'计算机',70),(7,904,'英语',92),(8,905,'英语',94),(9,906,'计算机',90),(10,906,'英语',85);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birth` year(4) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (901,'张老大','男',1985,'计算机系','北京市海淀区'),(902,'张老二','男',1986,'中文系','北京市昌平区'),(903,'张三','女',1990,'中文系','湖南省永州市'),(904,'李四','男',1990,'英语系','辽宁省阜新市'),(905,'王五','女',1991,'英语系','福建省厦门市'),(906,'王六','男',1988,'计算机系','湖南省衡阳市');
