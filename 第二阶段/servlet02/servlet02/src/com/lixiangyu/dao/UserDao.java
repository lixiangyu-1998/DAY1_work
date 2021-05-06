package com.lixiangyu.dao;

import com.lixiangyu.bean.User;

import java.util.List;

/**
 * @author lixiangyu
 * @title: UserDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/48:53 下午
 */
public interface UserDao {
    /**
     * 根据用户名 查询信息
     * @param username
     * @return 如果返回null， 说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码来查询信息
     * @param username
     * @param password
     * @return 如果返回null 说明用户名或者密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    public <T> List<T> queryUserList();
}
