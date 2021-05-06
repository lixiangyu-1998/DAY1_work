import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author:LXY
 * @className:test
 * @description:
 * @date:2021/4/97:09 下午
 * @version:0.1
 * @since:1.8
 */
public class test {
    public static void connectionTest99(){
        PreparedStatement ps =null;
        InputStream rs =null;
        try {
            Connection conn = JDBCUtils.getConnection();
            rs = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(rs);
            String sql = "select * from score";
            ps = conn.prepareStatement(sql);
            //ps.setObject();
            ResultSet rst = ps.executeQuery();
            while(rst.next()){//next 判断结果集下一条是否有数据 如果有数据返回true并指针下移 如果返回false
                int id = rst.getInt(1);
                int stu_id = rst.getInt(2);
                final String c_name = rst.getString(3);
                final int Grade = rst.getInt(4);
                System.out.println(id+stu_id+c_name+Grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {if(rs!=null){
                rs.close();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        connectionTest99();

        PreparedStatement ps=null;
        Connection conn=null;
        try {
            //读取配置文件到输入流中
            InputStream resourceAsStream = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //new一个properties 对象 并 装载 本地文件的内容到里面
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            //开始连接驱动
            Class.forName(properties.getProperty("driverClass"));
            //连接数据库
            conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("password"));
            System.out.println(conn);
            //预编译 sql语句 返回PreparedStatement实例

            String sql="show  tables";//"insert into 表名（字段，字段，字段）vlaues（？，？，？）" 占位符用  ？ 来代表
            ps = conn.prepareStatement(sql);

            //填充占位符 ps.set字段相应的数据类型（index，数据）
            //填充占位符 ps.set字段相应的数据类型（index，数据） 注意 凡是涉及到数据库的index 统统从1开始
            //填充占位符 ps.set字段相应的数据类型（index，数据）

            //执行sql语句
            ps.execute();

            //最后不要忘记关闭资源 和io流一样 从 下 往 上  依次关闭
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            try {if(ps!=null){
                ps.close();
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {if(conn!=null){
                conn.close();
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
