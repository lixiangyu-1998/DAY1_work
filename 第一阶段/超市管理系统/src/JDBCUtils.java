import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author:LXY
 * @className:JDBCUtils
 * @description:
 * @date:2021/4/97:48 下午
 * @version:0.1
 * @since:1.8
 */
public class JDBCUtils {
    //获取数据库连接
            public static Connection getConnection() throws Exception {
                InputStream resourceAsStream =ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
                //new一个properties 对象 并 装载 本地文件的内容到里面
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                //开始连接驱动
                Class.forName(properties.getProperty("driverClass"));
                //连接数据库
                Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                        properties.getProperty("password"));
                return conn;
            }
    //关闭资源
            public static void closeResource(Connection conn, PreparedStatement ps){
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
            //关闭资源
            public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rst){
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
                try {if(rst!=null){
                    rst.close();
                }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            //通用的 增删改 操作
            public static void update(String sql,Object ... args){//可变参数数量来表示qsl中占位符的数量
                Connection conn=null;
                PreparedStatement ps=null;
                try {
                    conn = JDBCUtils.getConnection();
                    ps = conn.prepareStatement(sql);
                    for(int i=0;i<args.length;i++){
                        ps.setObject(i+1,args[i]);//注意参数i
                    }
                    ps.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JDBCUtils.closeResource(conn,ps);
                }
            }

            //针对于不同表的查询操作
            public static <T> List<T> query(Class<T> clazz, String sql, Object ... args){
                Connection conn=null;
                PreparedStatement ps=null;
                ResultSet rst=null;
                try {
                    conn=JDBCUtils.getConnection();
                    ps=conn.prepareStatement(sql);
                    for(int i=0;i<args.length;i++){
                        ps.setObject(i+1,args[i]);
                    }
                    rst=ps.executeQuery();
                    ResultSetMetaData rstmd = rst.getMetaData();
                    int columnCount = rstmd.getColumnCount();
                    ArrayList<T> list = new ArrayList<>();
                    while(rst.next()){
                        T t=clazz.newInstance();
                        for(int i=0;i<columnCount;i++){
                            Object columValue = rst.getObject(i + 1);
                            String columnLabel = rstmd.getColumnLabel(i + 1);
                            Field field = clazz.getDeclaredField(columnLabel);
                            field.setAccessible(true);
                            field.set(t,columValue);
                        }
                        list.add(t);

                    }
                    return list;
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    JDBCUtils.closeResource(conn,ps,rst);
                }
                return null;
    }



}
