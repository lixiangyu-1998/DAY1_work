package com.lixiangyu.service.impl;

import com.lixiangyu.bean.User;
import com.lixiangyu.dao.UserDao;
import com.lixiangyu.dao.impl.UserDaoImpl;
import com.lixiangyu.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * @author lixiangyu
 * @title: UserServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/69:42 下午
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void regisUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {

        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

//    @Override
//    public List<User> queryUserList() {
//        return userDao.queryUserList();
//    }
}
