package com.javasm.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;


public class DBHelper {

    private DBHelper() {
    }

    private static DataSource dataSource;//null

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBHelper.class.getResourceAsStream("/jdbc.properties"));

            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }


}
