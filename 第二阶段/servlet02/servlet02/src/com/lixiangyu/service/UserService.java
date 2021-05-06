package com.lixiangyu.service;

import com.lixiangyu.bean.User;

import java.util.List;

/**
 * @author lixiangyu
 * @title: UserService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/49:12 下午
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void regisUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null 说明登录失败 有返回值就成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回 true 表明用户名存在 返回false 表明用户名可用
     */
    public boolean existsUsername(String username);

    /**
     * 返回用户List
     * @return
     */
    public List<User> queryUserList();
}
