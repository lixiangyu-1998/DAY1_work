# MySQL

# 1. 数据库  DB

> database  数据库  存储不同 类型的数据。

```java
为什么要学习数据库? 项目中?
    用户--->页面
       ----->控制器(接收前台页面提交的数据)
       --->service(业务逻辑处理层)
       --->dao(数据持久层)
       --->DB(mysql oracle pot db2  sqlite)
  持久化保存用户数据，  
```

```java
数据库的分类:
   1. 从存储位置划分:
        1.1 基于磁盘(文件) --->mysql oracle sqlserver  持久化 IO 效率偏慢
        1.2 基于缓存----> redis   不能完全保证持久化  效率快
         
 mysql：
      db--->table--->字段 类型  数据
   2.从关系上划分:
       2.1 关系型数据库:  表与表  字段与字段之间  有关系  mysql oracle sqlserver
       2.2 非关系型数据库NOSQL(not only sql): key:value   redis       
```



```java
数据库系统:
   1. 数据库
   2. 硬件
   3. 软件: dbms 数据库管理系统软件。
   4. 人员  DBA  
```



# 2. DBMS

> 数据库管理系统。目前需要学习的是关系型数据库管理系统。 ==简称RDBMS.==  软件---> 服务端的程序。

```java
Oracle:  Scott/orcl  tiger  政府项目  
 9i  11G  12C   租赁   
```



# 3. MySQL

```java
mysql 8 
   常用: 5.5+  jdk:15  学习: 5.7
       
下载:  https://dev.mysql.com/downloads/windows/installer/8.0.html
用户名: root
密码:  root
端口号: 3306
    
 my.ini  mysql的核心配置文件。   
```



# 4. 操作

## 4.1 指令

> 客户端连接服务端。

> cmd通过命令行操作服务端， 配置mysql的环境  在path里面配置mysql的bin目录。

```bash
# TCP/IP: 连接特定计算机里面的软件程序。  ip 3306 root  root
# mysql -hip -uroot -p
# mysql -h127.0.0.1 -uroot -p  连接本机的服务: C:\Users\DELL>mysql -uroot -p

#mysql DBMS 里面的组成部分:
##   很多数据库DB
##    每个DB--->table--->字段  类型  数据
```

```bash
# mysql> show databases; 查看所有的数据库


# mysql> use mysql; 使用指定数据库

# mysql> show tables;  查看指定库里面所有的表
+---------------------------+
| Tables_in_mysql           |
+---------------------------+
| columns_priv              |
| db                        |
| engine_cost               |
| event

# mysql> desc user;  查看表结构

mysql> show create database mydb; # 查看创建的数据库的基本结构
+----------+-----------------------------------------------------------------+
| Database | Create Database                                                 |
+----------+-----------------------------------------------------------------+
| mydb     | CREATE DATABASE `mydb` /*!40100 DEFAULT CHARACTER SET latin1 */ |
+----------+-----------------------------------------------------------------+
```





## 4.2 SQL

> 结构化查询语言。 structured query  language

```mysql
# 分为4类:
1. DDL data definition language  数据定义语言  create alter  drop  truncate
2. DML 数据操作语言 insert  delete   update
3. DQL 数据查询语言 select
4. DCL 数据控制语言 start transaction  begin  commit rollback  grant
```





```mysql
mysql> select database();  # 查看当前正在操作的数据库
+------------+
| database() |
+------------+
| mysql      |
+------------+

select * from 表名;   * 通配的表里面所有的字段
select 字段,字段,.... from 表名; 
# mysql> select * from user;   关键字  数据  不区分大小写
mysql> select host,user from user;
+-----------+---------------+
| host      | user          |
+-----------+---------------+
| localhost | mysql.session |
| localhost | mysql.sys     |
| localhost | root          |
+-----------+---------------+
```



# 5. DDL

> 创建库    创建表    删库 删表      修改表结构

```mysql
create database 数据库名称 ; #名字无法修改的
# mysql> create database mydb

mysql> drop database mydb; # 删除指定的库
```



```mysql
create table 表名(
   字段名称1 字段类型 [约束],
   字段1 字段类型 [约束],
    ....
   字段n 字段类型 [约束]
);

# 创建用户信息表 tb_userinfo  t_userinfo  userinfo  
 # 必不可少的3个字段  id  create_time  update_time
create table tb_userinfo( 
  id  int(4),
  name varchar(20),
  age tinyint(2) unsigned,
  gender  char(1),
  birthday date,
  balance decimal(10,3),
  create_time  datetime,
  update_time datetime
);

属性: java程序class   基本  引用
映射关系:
   表--->class
   表字段--->类属性
   表字段类型--->类属性的数据类型
```



```mysql
mysql> desc tb_userinfo;
+-------------+---------------------+------+-----+---------+-------+
| Field       | Type                | Null | Key | Default | Extra |
+-------------+---------------------+------+-----+---------+-------+
| id          | int(4)              | YES  |     | NULL    |       |
| name        | varchar(20)         | YES  |     | NULL    |       |
| age         | tinyint(2) unsigned | YES  |     | NULL    |       |
| gender      | char(1)             | YES  |     | NULL    |       |
| birthday    | date                | YES  |     | NULL    |       |
| balance     | decimal(10,3)       | YES  |     | NULL    |       |
| create_time | datetime            | YES  |     | NULL    |       |
| update_time | datetime            | YES  |     | NULL    |       |
+-------------+---------------------+------+-----+---------+-------+
```



## ==5.1 数据类型==

> 1. 整数类型

```mysql
tinyint(m)==>byte  年龄 -128-127   unsigned 0-255 
  tinyint(1)---> 1  0 boolean 
int(m)==>int  id      11  int(4)---> 限制列宽  1000000
bigint(m)==>long  id  时间的毫秒数  
unsigned: 标识数值必须是一个正整数。
zerofill: 以0填充。   int(4) 0100 10000
```





> 2. 小数类型

```mysql
float/ double / BigDecimal 小数

float(m,n)  m: 限定小数总位数。  n: 限定小数点之后的位数
double(m,n)
decimal(m,n) 定点数  BigDecimal
```



> 3. 字符类型

```mysql
char/String
-- 存储字符串的数据     n: 限定字符个数 
char(n)
varchar(n) 255   

char(3)  vs varchar(3)
char(3): 'a__' 查询的时候 先trim 再展示数据   性别  手机号  身份证号 
varchar(3): 'a'  可变字符串

text
longtext
```



> 4. 日期类型

```mysql
-- 年月日 date
-- 时分秒 time
-- 年月日  时分秒  datetime  timestamp  bigint
-- 年 year(n) n=2/4  2021
```



## 5.2 alter

```mysql
-- 修改表结构
-- 1. 新增新的字段
alter table tb_userinfo add image varchar(100);
-- 2.删除指定字段
alter table tb_userinfo drop image;
-- 3. 修改字段名称/字段类型
alter table tb_userinfo change name username varchar(30);
-- 4. 修改字段类型
alter table tb_userinfo modify username char(30);

-- 5. 修改表名
alter table tb_userinfo rename userinfo;

-- 6. 删除表
drop table userinfo;
```





# ==6. DML==

> 1. 新增  insert     一次新增一条记录  1条

```mysql
-- 1. 对表的列全部赋值(不太推荐) 
insert into 表名 values (数据1,数据2....数据n),(数据1,数据2....数据n); 
insert into tb_userinfo values (1,'jim',20,'m','2020-01-01',40000,'2020-01-01 12:00:00','2020-01-01 12:00:00');

mysql> insert into tb_userinfo values (1,'jim',-10,'男','2020-01-01',40000,'2020-01-01 12:00:00','2020-01-01 12:00:00');
ERROR 1264 (22003): Out of range value for column 'age' at row 1

mysql> insert into tb_userinfo values (1,'jim',20,'男','2020-01-01',40000,'2020-01-01 12:00:00','2020-01-01 12:00:00');
ERROR 1366 (HY000): Incorrect string value: '\xC4\xD0' for column 'gender' at row 1
```

```mysql
-- 2. 对指定字段赋值
insert into 表名 (字段1,...字段n) values (数据1,...数据n),(数据1,...数据n);
insert into tb_userinfo (id,name,balance,create_time) values (2,'tom',49999,now());

mysql> insert into tb_userinfo (id,name,balance,create_time) values (2,'tom',49999,now()),(3,'lily',635325,now());
```





> 2. 删除  delete  >=0

```mysql
-- delete from 表名 [where 条件1 and/or ];  清空表数据  多行记录受影响
mysql> delete from tb_userinfo where name='jim';
mysql> delete from tb_userinfo where name='tom' or id=3;
```





> 3. 修改  update  >=0

```mysql
-- update 表名 set 字段1=新值1,...字段n=新值n [where 条件1 and/or ] ;
mysql> update tb_userinfo set age=18,gender='F';
mysql> update tb_userinfo set balance = 1665327,birthday='2021-10-10',update_time=now() where id=2;
```



> 不能存储中文

```mysql
mysql> alter database mydb character set utf8;
Query OK, 1 row affected (0.00 sec)

mysql> show create database mydb;
+----------+---------------------------------------------------------------+
| Database | Create Database                                               |
+----------+---------------------------------------------------------------+
| mydb     | CREATE DATABASE `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ |
+----------+---------------------------------------------------------------+

-- 用户表是在修改编码格式之前创建的 依然不能添加中文
mysql> insert into tb_userinfo (name) values ('张三');
ERROR 1366 (HY000): Incorrect string value: '\xD5\xC5\xC8\xFD' for column 'name' at row 1
mysql> create table a(name varchar(10));
Query OK, 0 rows affected (0.02 sec)

mysql> insert into a values ('张三');
Query OK, 1 row affected (0.01 sec)

mysql> select * from a;
+------+
| name |
+------+
| 张三 |
+------+
```



```mysql
-- 修改方式:  修改mysql的服务  my.ini
 66 default-character-set=utf8
 100 character-set-server=utf8
    
 重新加载核心配置文件----> 重启服务
mysql> show variables like '%character%';    
```









