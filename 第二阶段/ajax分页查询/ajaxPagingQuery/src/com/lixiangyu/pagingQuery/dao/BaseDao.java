package com.lixiangyu.pagingQuery.dao;


import com.lixiangyu.pagingQuery.bean.User;
import com.lixiangyu.pagingQuery.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: BaseDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/69:02 下午
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行 增删改 语句
     * @param sql
     * @param args
     * @return 如果返回 -1 说明执行失败
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回 一个 javaBean
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回 多个javaBean
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return  queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 返回一行一列
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    protected StringBuilder sqlAppend(String sql, User user,String addSql){
        StringBuilder builder = new StringBuilder(sql);
        boolean isWhere = true;
        //搜索栏的名字不为空 就拼sql
        if (!"".equals(user.getName()) && !(user.getName() == null)) {
            isWhere = false;
            builder.append(" WHERE name = '"+user.getName()+"' ");
        }
        //搜索栏地址不为空也拼sql
        if (!"".equals(user.getAddress()) && !(user.getAddress() == null)) {
            //如果已经拼了名字的sql 就不要再加where了
            if (isWhere) {
                builder.append(" WHERE ");
            } else {
                builder.append(" AND ");
            }
            builder.append("address LIKE '"+user.getAddress()+"' ");
        }

        //无论如何 都要 拼个 addSql
        builder.append(addSql);

        return builder;
    }

}
