package com.lixiangyu.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author lixiangyu
 * @title: JdbcUtilsTest
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/48:36 下午
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }

}