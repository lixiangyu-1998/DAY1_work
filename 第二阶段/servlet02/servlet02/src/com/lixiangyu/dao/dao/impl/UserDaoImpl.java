package com.lixiangyu.dao.dao.impl;

import com.lixiangyu.bean.User;
import com.lixiangyu.dao.BaseDao;
import com.lixiangyu.dao.UserDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: UserDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/48:59 下午
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`) values(?,?)";
        return update(sql, user.getUsername(),user.getPassword());
    }

    @Override
    public  List<User> queryUserList() {
        String sql="SELECT * FROM t_user ";
        return queryForList(User.class,sql);
    }
}
