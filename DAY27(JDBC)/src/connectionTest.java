import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.Class.forName;

/**
 * @author:LXY
 * @className:connectionTest
 * @description:
 * @date:2021/4/811:10 下午
 * @version:0.1
 * @since:1.8
 */
public class connectionTest {
    public static void main(String[] args) {
        try {
            //connectionTest1();
            //connectionTest2();
            //connectionTest3();
            //connectionTest4();
            connctionTest5();
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    //方式1
    public static void connectionTest1() throws SQLException {
        //获取 driver实现类 对象
        Driver dirver =new  com.mysql.cj.jdbc.Driver();//多态实例化驱动 为 我们要链接的数据库的驱动 加载驱动程序
        Properties info =new Properties();//properties 类 保存账号密码键值对
        info.setProperty("user","root");
        info.setProperty("password","19980821");
        Connection connect = dirver.connect(
                "jdbc:mysql://localhost:3306/mysqlhomework" +
                        "?useUnicode=truecharacterEncoding=utf-8",info);
        //选择正确版本的驱动jar包才行 8.0以上版本的驱动 步骤有少许不同

         System.out.println(connect);
    }

    //方式2 对方式一的迭代 在如下的程序中不出现第三方api，使得程序有更好的可移植性
    public static void connectionTest2() throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, SQLException {
        //通过反射的方式 获取driver实现类对象  替换了上面的 Driver dirver =new  com.mysql.cj.jdbc.Driver();代码
        Class Clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver= (Driver) Clazz.newInstance();
        //其他流程不变

        //提供要链接的数据库
        String url="jdbc:mysql://localhost:3306/mysqlhomework"+"?useUnicode=truecharacterEncoding=utf-8";
        //提供链接需要的用户名和密码
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","19980821");
        //获取链接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    //方式3 使用 DriverManager 替换Driver
    public static void connectionTest3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //获取driver的实现类对象
        Class forName = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver= (Driver) forName.newInstance();
        //获取其他基本信息
        String url="jdbc:mysql://localhost:3306/mysqlhomework"+"?useUnicode=truecharacterEncoding=utf-8";
        String user="root";
        String password="19980821";
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式4 优化 驱动注册
    public static void connectionTest4() throws ClassNotFoundException, SQLException {
        //驱动
        //driver类中的静态代码块 会注册driver 随着Driver类的加载 静态代码块会自动执行 注册驱动
        //所以只需要一行driver类加载的代码即可
        Class.forName("com.mysql.cj.jdbc.Driver");
        //提供连接数据库的信息
        String url="jdbc:mysql://localhost:3306/mysqlhomework"+"?useUnicode=truecharacterEncoding=utf-8";
        String user="root";
        String password="19980821";
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式5 最终版本 将数据库连接需要的基本信息 声明在配置文件中 通过读取配置文件 获取连接
    public static void connctionTest5() throws IOException, SQLException, ClassNotFoundException {
        //读取配置文件信息 类加载器的getResourceAsStream()方法获取类路径下的指定文件输入流
        InputStream resourceAsStream =
                connectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);

    }

}
