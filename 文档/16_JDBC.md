# JDBC

```java
// 通过sql直接在DBMS的服务里面  操作库里面表的数据。
// 通过java程序操作表数据。    
// 数据都是用户请求过来的   提交给后台程序  通过代码实现数据的持久化

java database connectivity  java连接数据库技术。

 DBMS:
   mysql  oracle  sqlserver... 软件---> 服务
能够满足操作任意的DBMS.
  SUN/oracle---> 制定好了一组规则       
  不同dbms功能实现都是不一样的   sun规定标准  数据库厂商提供一组实现  基于jdbc的实现       
       
   cmd  navicat
   连接:  客户端连接服务端    my.ini 151         
```





# 1. 获得DBMS的连接

```java
-- mysql -hip -uroot -p
-- ip 3306  root  root
    
1. 主机 端口  3306   服务软件的所在位置   
2. 用户名 root
3. 密码 root
4. 驱动 jar  
https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.47/    
```



```java
 public static void main(String[] args) {

        //获得mysql数据库的连接---> 对象
        //1. 获得 mysql数据库的连接对象

        String username = "root";
        String password = "root";
//        String url = "jdbc:mysql://ip:端口号/数据库名称?参数名=值&";
        String url = "jdbc:mysql://192.168.14.113:3306/aa?useSSL=false&characterEncoding=utf-8";
        //mysql服务的版本: 5+
        String driver = "com.mysql.jdbc.Driver";//第三方的jar


        //2. 利用JDBC获得对象  DriverManager
        //JDBC4 ---> 服务发现机制  META-INF/service ---> 省略注册驱动
        //java项目可以这么用  web项目--->运行服务器-->jar/war META-INF没有service

        try {
            //2.1 注册驱动  java.sql.*
            // DriverManager.registerDriver(new Driver());
            Class.forName(driver);// jvm 自动创建Class对象  加载static的代码块(注册驱动)

            //2.2 DriverManager
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("mysql...连接:" + connection);
            //com.mysql.jdbc.JDBC4Connection@5b37e0d2
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
```





> DBHelper.java

```java
public class DBHelper {

    private DBHelper() {
    }


    public static Connection getMysqlConn() {
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://192.168.14.113:3306/aa?useSSL=false&characterEncoding=utf-8";
        String driver = "com.mysql.jdbc.Driver";

        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeResources(Connection connection) {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```



# 2. 优化DBHelper

```java
 //在一个进程里面  不管调用多少次  都是同一个连接的对象?

public class DBHelper {

    private DBHelper() {
    }

    private static Connection connection;

    static {
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://192.168.14.113:3306/aa?useSSL=false&characterEncoding=utf-8";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConn() {

        return connection;
    }
}
```



> 弊端:  提升了资源利用率  但是多线程环境下  有问题

```java
public static void main(String[] args) {

        //一个进程里面 调用getMysqlConn  151
        //在一个进程里面  不管调用多少次  都是同一个连接的对象?
        //1.解决方式: 存储到静态代码块

//        new Thread(DBHelper::a).start();
//        new Thread(DBHelper::a).start();


        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Connection conn1 = getMysqlConn();
                System.out.println(Thread.currentThread().getName() + ":" + conn1);

                try {
                    if (i == 5) {
                        //关闭了连接
                        conn1.close();
                    }
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Connection conn1 = getMysqlConn();
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + conn1.isClosed());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        //前提: 一个进程里面有一个连接对象  多个线程是相互独立的
        //一个线程关闭 其它线程就不能使用的
    }
```





# 3. ThreadLocal

```java
public class DBHelper {

    private DBHelper() {
    }
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal() {
        @SneakyThrows
        @Override
        protected Connection initialValue() {
            return DriverManager.getConnection(
                    PropUtil.getValue("jdbc.url"),
                    PropUtil.getValue("jdbc.username"),
                    PropUtil.getValue("jdbc.pass"));
        }
    };


    public static Connection getMysqlConn() {
        return THREAD_LOCAL.get();
    }

    public static void closeResources(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```



# 4. CRUD

## 1. 新增

```java
数据库持久层:  Dao  接口
 都会将sql语句封装成Statement进行处理  。 
Statement createStatement()    创建一个 Statement对象，用于将SQL语句发送到数据库。 禁止使用
PreparedStatement prepareStatement(String sql)  推荐使用
创建一个 PreparedStatement对象，用于将参数化的SQL语句发送到数据库。 
    
PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) 
创建一个默认的 PreparedStatement对象，该对象具有检索自动生成的密钥的能力。      
    
 boolean execute()  
int executeUpdate() 常用  int: 受影响的记录数 >=0   =0
执行在该SQL语句PreparedStatement对象，它必须是一个SQL数据操纵语言（DML）语句，如INSERT ， UPDATE或DELETE ; 或不返回任何内容的SQL语句，例如DDL语句    
    
ResultSet executeQuery() 
执行此 PreparedStatement对象中的SQL查询，并返回查询 PreparedStatement的 ResultSet对象。     
```

```java
映射:   一张表对一个类
   表--->类
   表字段--->类属性
   表字段类型--->类属性类型
   表记录---->类对象    
```



```java
@Override
    public int addUserInfo(UserInfo userInfo) {
        //1.获得数据库连接
        conn = DBHelper.getMysqlConn();
        //2.准备sql语句 使用占位符? 进行占位 代表需要传递一个数据
        sql = "insert  into tb_userinfo (username,image,age, birthday, balance, rid) values (?,?,?,?,?,?)";
        //3. 执行sql---> 所有的sql都是DBMS的服务软件里面执行  java程序没有能力执行

        int result = 0;
        try {
            //3.1 将sql发送到mysql的服务中
            ps = conn.prepareStatement(sql);//sql语句在ps对象
            //查看sql语句有没有占位符 1
            ps.setString(1, userInfo.getUsername());
            ps.setString(2, userInfo.getImage());
            ps.setInt(3, userInfo.getAge());
            ps.setObject(4, userInfo.getBirthday());
            ps.setBigDecimal(5, userInfo.getBalance());
            ps.setInt(6, userInfo.getRid());
            //3.2 在mysql服务  执行sql语句  DDL  DML(insert update delete) DQL(select)
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps);
        }
        return result;
    }
```





## 2. 删除

```java
delete from tb_userinfo where id=?   DML
delete from tb_userinfo where id in ();
 @Override
    public int deleteUserInfoById(int id) {

        conn = DBHelper.getMysqlConn();
        sql = "delete from tb_userinfo where id=?";

        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps);
        }
        return result;
    }
```

> 删除多个

```java
@Override
    public int deleteUserByIn(int[] ids) {
        conn = DBHelper.getMysqlConn();
        StringBuilder builder = new StringBuilder("delete from tb_userinfo where id in ( ");
        for (int id : ids) {
            builder.append(id);
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append(")");
        int result = 0;
        try {
            ps =  conn.prepareStatement(builder.toString());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

```









