package com.lixiangyu.dao.impl;

import com.lixiangyu.bean.User;
import com.lixiangyu.dao.BaseDao;
import com.lixiangyu.dao.UserDao;

import java.sql.SQLClientInfoException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: UserDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/69:18 下午
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql="SELECT * FROM t_user WHERE username=?";
        return queryForOne(User.class,sql,username );
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="SELECT * FROM t_user WHERE username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="INSERT INTO t_user(username,password,isalive,truename,gender,age,email) VALUES(?,?,?,?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.isIsalive(),user.getTruename(),user.getGender(),
                user.getAge(),user.getEmail());
    }

//    @Override
//    public List<User> queryUserList() {
//        String sql="SELECT * FROM t_commodity";
//        return queryForList(User.class,sql);
//    }
}
