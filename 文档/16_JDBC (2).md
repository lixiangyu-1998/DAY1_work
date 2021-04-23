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

## 1. insert

```java
数据库持久层:  Dao  接口
 都会将sql语句封装成Statement进行处理  。 
Statement createStatement()    创建一个 Statement对象，用于将SQL语句发送到数据库。 禁止使用
PreparedStatement prepareStatement(String sql)  推荐使用
创建一个 PreparedStatement对象，用于将参数化的SQL语句发送到数据库。 
    
PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) 
创建一个默认的 PreparedStatement对象，该对象具有检索自动生成的密钥的能力。      
    
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





## 2. delete

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



## 3. update

> 删除/修改  前提: 查询

```mysql
update tb_userinfo set username=?,image=?,age=?, birthday=?, balance=?, rid=? where id=?

-- 修改其中一部分字段 很少动态sql

```



```java
 @Override
    public int updateUserInfoById(UserInfo userInfo) {
        conn = DBHelper.getMysqlConn();
        sql = "update tb_userinfo set username=?,image=?,age=?, birthday=?, balance=?, rid=? where id=?";
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);//sql语句在ps对象
            ps.setString(1, userInfo.getUsername());
            ps.setString(2, userInfo.getImage());
            ps.setInt(3, userInfo.getAge());
            ps.setObject(4, userInfo.getBirthday());
            ps.setBigDecimal(5, userInfo.getBalance());
            ps.setInt(6, userInfo.getRid());
            ps.setInt(7, userInfo.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, null);
        }
        return result;
    }
```

```java
private static void updateTest() {

        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("修改用户id:");
        int uid = input.nextInt();
        UserInfo userInfo = userInfoDao.selectUserById(uid);


        System.out.println("用户信息如下:" + userInfo);
        System.out.println("请选择要修改的字段: 1.username 2. image 3. age 4. birthday 5. balance 6. rid");
        String choice = input.next();//1,2,3
        String[] array = choice.split(",");
        for (String s : array) {
            int num = Integer.parseInt(s);
            switch (num) {
                case 1:
                    System.out.println("请录入新的username:");
                    String newName = input.next();
                    userInfo.setUsername(newName);
                    break;
                case 2:
                    System.out.println("请录入新的image:");
                    String newImage = input.next();
                    userInfo.setImage(newImage);
                    break;
                case 3:
                    System.out.println("请录入新的age:");
                    int newAge = input.nextInt();
                    userInfo.setAge(newAge);
                    break;
                case 4:
                    System.out.println("请录入新的birthday:");
                    String newBirthday = input.next();
                    userInfo.setBirthday(new Date());
                    break;
                case 5:
                    System.out.println("请录入新的balance:");
                    BigDecimal newBalance = input.nextBigDecimal();
                    userInfo.setBalance(newBalance);
                    break;
                case 6:
                    System.out.println("请录入新的rid:");
                    userInfo.setRid(input.nextInt());
                    break;
            }
        }

        System.out.println("修改之后的用户信息:" + userInfo);
        System.out.println(userInfoDao.updateUserInfoById(userInfo));
    }
```



## 4. select

### 4.1  查询单个

```mysql
-- 查询一个完整的用户信息
-- 临时表  
select * from tb_userinfo where id=?
```

```java
 @Override
    public UserInfo selectUserVyId(int id) {
        conn = DBHelper.getMysqlConn();
        sql = "select * from tb_userinfo where id=?";// DQL
        UserInfo userInfo = null;
        try {
            //1.将sql发送到mysql
            ps = conn.prepareStatement(sql);
            //2. 是否有占位符
            ps.setInt(1, id);
            //3. 执行sql  类似Iterator
            rs = ps.executeQuery();//select查询的结果(临时表的数据) 都在rs对象中
            //判断光标之后是否有更多记录需要遍历
            if (rs.next()) {
                //获得记录  get
                userInfo = new UserInfo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, rs);
        }
        return userInfo;
    }
```





### 4.2 查询所有

```mysql
select * from tb_userinfo;
```

```java
@Override
    public List<UserInfo> selectAllUserInfo() {
        conn = DBHelper.getMysqlConn();
        sql = "select * from tb_userinfo";// DQL
        UserInfo userInfo = null;
        List<UserInfo> userInfoList = new ArrayList<>(10);
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                userInfoList.add(new UserInfo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, rs);
        }
        return userInfoList;
    }
```



### 4.3 分页查询

```mysql
select * from tb_userinfo limit ?,?;
select count(id) from tb_userinfo;
-- select * from tb_userinfo limit (page-1)*size,size;
```

```java
 @Override
    public List<UserInfo> selectUserInfoByPage(int page) {
        conn = DBHelper.getMysqlConn();
        sql = "select * from tb_userinfo order by id DESC limit ?,?";
        UserInfo userInfo = null;
        List<UserInfo> userInfoList = new ArrayList<>(10);
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * CommonConstant.SIZE);
            ps.setInt(2, CommonConstant.SIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                userInfoList.add(new UserInfo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, rs);
        }
        return userInfoList;
    }

    @Override
    public int selectCount() {
        conn = DBHelper.getMysqlConn();
        sql = "select count(*) from tb_userinfo";//Long

        long cou = 0L;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                cou = (Long) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) cou;
    }
```

```java
public static void selectPageTest() {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        int count = userInfoDao.selectCount();
        int result = count / CommonConstant.SIZE;
        int totalPage = (count % CommonConstant.SIZE == 0) ? (result) : (result + 1);
        for (int i = 1; i <= totalPage; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("请选择要查看的页数:");
        @Cleanup
        Scanner input = new Scanner(System.in);
        int page = input.nextInt();


        userInfoDao.selectUserInfoByPage(page).forEach(System.out::println);
    }

```



### 4.4 多条件查询

```mysql
-- 查询的条件 都是等值条件  and  ? 占位符 只能占位数据
select * from tb_userinfo where 
```

```java
@Override
    public List<UserInfo> selectByParams(Map<String, Object> params) {

        conn = DBHelper.getMysqlConn();
        StringBuilder builder = new StringBuilder(" select * from tb_userinfo where ");
        params.forEach((key, value) -> {
            builder.append(key);
            builder.append("='");
            builder.append(value);
            builder.append("'");
            builder.append(" and ");
        });
        builder.delete(builder.lastIndexOf("and"), builder.length());

        List<UserInfo> userInfoList = new ArrayList<>(10);
        try {
            ps = conn.prepareStatement(builder.toString());

            rs = ps.executeQuery();
            while (rs.next()) {
                userInfoList.add(new UserInfo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, rs);
        }
        return userInfoList;
    }
```



### 4.5 多表关联查询

```java
@Override
    public List<Map<String, Object>> selectUserInfoAddress(int uid) {

        conn = DBHelper.getMysqlConn();
        sql = "select\n" +
                "  u.id,u.username,u.age,sa.province,sa.city,sa.area,sa.id AS sid\n" +
                "from\n" +
                "  tb_ship_address sa, tb_userinfo u\n" +
                "where u.id = ? and sa.uid=u.id";
        List<Map<String, Object>> list = new ArrayList<>(10);
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, uid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("id", rs.getObject("id"));
                map.put("username", rs.getObject("username"));
                map.put("province", rs.getObject("province"));
                map.put("city", rs.getObject("city"));
                map.put("area", rs.getObject("area"));
                map.put("sid", rs.getObject("sid"));
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResources(conn, ps, rs);
        }
        return list;
    }
```





## 5. service

```java
//新增完整的用户信息  实现用户头像上传  用户密码加密
```

```java
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public Map<String, Object> addUser(UserInfo userInfo) {
        Objects.requireNonNull(userInfo);

        //用户头像上传
        //1.1 IO 实现文件上传
        //1.2 Socket编写文件服务器

        String serverFilePath = FileUtil.fileUpload(userInfo.getImage());
        userInfo.setImage(serverFilePath);

        //用户密码加密
        String encodePass = MD5Util.encodeStr(userInfo.getPass());
        userInfo.setPass(encodePass);

        UserInfoDao userInfoDao = new UserInfoDaoImpl();

        //数据已经处理之后的数据
        Map<String, Object> map = new HashMap<>(16);
        int result = userInfoDao.addUserInfo(userInfo);
        if (result == 0) {
            map.put("code", 401);
            map.put("msg", "新增用户失败");
            return map;
        }
        map.put("code", 200);
        map.put("msg", "新增用户成功");
        return map;
    }

    @Override
    public Map<String, Object> selectOneUser(int uid) {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo = userInfoDao.selectUserById(uid);
        Map<String, Object> map = new HashMap<>(16);
        if (userInfo == null) {
            map.put("code", 400);
            map.put("msg", "查询单个用户信息失败");
            return map;
        }
        map.put("code", 200);
        map.put("msg", "查询单个用户信息成功");
        map.put("data", userInfo);
        return map;
    }
}
```



> 优化之后

```java
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public ServerResponse addUser(UserInfo userInfo) {
        Objects.requireNonNull(userInfo);

        //用户头像上传
        //1.1 IO 实现文件上传
        //1.2 Socket编写文件服务器

        String serverFilePath = FileUtil.fileUpload(userInfo.getImage());
        userInfo.setImage(serverFilePath);

        //用户密码加密
        String encodePass = MD5Util.encodeStr(userInfo.getPass());
        userInfo.setPass(encodePass);

        UserInfoDao userInfoDao = new UserInfoDaoImpl();

        int result = userInfoDao.addUserInfo(userInfo);
        if (result == 0) {
            return ServerResponse.error();
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse<UserInfo> selectOneUser(int uid) {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo = userInfoDao.selectUserById(uid);
        if (userInfo == null) {
            return ServerResponse.error();
        }
        return ServerResponse.success(userInfo);
    }
}

```

```json
{
    "code":200,
    "data":
       
    {"age":30,
        "balance":4000.000,
        "birthday":"2020-01-01",
        "createTime":1618648929000,
     "id":9,
     "image":"b.jpg",
     "rid":4,
     "updateTime":1618799283000,
     "username":"jim_new"},
    
    "msg":"SUCCESS"}
```



## 6.  获得自增id

```java
//新增角色  并关联角色对应的权限功能
//1.准备功能  
Role.java
    RoleDao.java
    RoleDaoImpl.java
    
Permission.java
    PermissionDao.java
    PermissionDaoImpl.java
```



```java
//测试
public static void main(String[] args) {

        //新增角色信息  并关联角色的权限功能
        //1.查看所有的权限数据的前提下  分配
        Scanner input = new Scanner(System.in);
        System.out.println("录入新的角色名称:");
        String newRoleName = input.next();
        System.out.println("录入新的角色描述:");
        String str = input.next();
        
        System.out.println("目前所有的权限功能如下，请给" + newRoleName + "分配权限:");
        PermissionDao permissionDao = new PermissionDaoImpl();
        List<Permission> list = permissionDao.selectAllPermission();
        list.forEach(System.out::println);
        String[] choiceArray = input.next().split(",");
        System.out.println(Arrays.toString(choiceArray));


        RoleService roleService = new RoleServiceImpl();
        System.out.println(roleService.addRole(new Role(newRoleName, str), choiceArray));
    }
```

```java
//service
public class RoleServiceImpl implements RoleService {
    @Override
    public ServerResponse addRole(Role role, String[] pids) {

        RoleDao roleDao = new RoleDaoImpl();
        try {
            int rid = roleDao.addRole(role);
            roleDao.addRolePer(pids, rid);
            return ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerResponse.error();
    }
}
```



```java
//dao
@Override
    public int addRole(Role role) throws Exception {
        conn = DBHelper.getMysqlConn();
        sql = "insert into tb_role (rolename,remark) values (?,?)";
        long result = 0;
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// 底层自动执行select last_insert_id()
        ps.setString(1, role.getRoleName());
        ps.setString(2, role.getRemark());

        ps.executeUpdate();
        //执行完sql之后  将id返回
        rs = ps.getGeneratedKeys();
        if (rs.next()) {
            result = rs.getLong(1);
        }

        return (int) result;
    }

    @Override
    public int addRolePer(String[] pidArray, int rid) throws Exception {
        conn = DBHelper.getMysqlConn();
        StringBuilder builder = new StringBuilder("insert into tb_role_per (roleid, pid) values ");
        for (String pid : pidArray) {
            builder.append("(");
            builder.append(rid);
            builder.append(",");
            builder.append(pid);
            builder.append(")");
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        System.out.println(builder);

        ps = conn.prepareStatement(builder.toString());
        return ps.executeUpdate();
    }
```





## 7. 事务







## 8. sql注入









# 5. DBUtils









# 6. Druid

