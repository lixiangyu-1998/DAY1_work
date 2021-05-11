package com.lixiangyu.ajax.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lixiangyu
 * @title: JdbcUtils
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/68:59 下午
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {

        try {
            Properties         properties = new Properties();
            //读取配置文件到流
            InputStream inputStream = DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接
     * @return 如果返回null 说明获取链接失败
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接 放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
