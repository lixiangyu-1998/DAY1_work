package com.lixiangyu.test;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author lixiangyu
 * @title: UserServiceImplTest
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/49:22 下午
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void regisUser() {
        userService.regisUser(new User(null, "admin", "admin"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }

    @Test
    public void queryUserList() {
        List<User> users = userService.queryUserList();
        users.forEach(System.out::println);
    }
}