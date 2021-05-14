package com.javasm.util;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class  JDBCUtil {
    private static String username;
    private static String password;
    private static String url;
    private static String drivername;

    private static Properties prop = new Properties();
    static{
        try {
            prop.load(JDBCUtil.class.getResourceAsStream("/jdbc.properties"));
            username = prop.getProperty("jdbc.user");
            password = prop.getProperty("jdbc.pass");
            url = prop.getProperty("jdbc.url");
            drivername = prop.getProperty("jdbc.driver");
            Class.forName(drivername);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection myconn = null;
        try {
            myconn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myconn;
    }

    public static void closeConn(Connection conn, PreparedStatement psta, Statement stat, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(psta!=null){
                psta.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JDBCUtil ju = new JDBCUtil();

    }

}
