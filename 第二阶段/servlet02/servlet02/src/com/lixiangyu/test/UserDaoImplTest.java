package com.lixiangyu.test;

import com.lixiangyu.bean.User;
import com.lixiangyu.dao.UserDao;
import com.lixiangyu.dao.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lixiangyu
 * @title: UserDaoImplTest
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/49:04 下午
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1") == null ){
            System.out.println("用户名可用！");
        } else { System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin1","admin1") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else { System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"admin1", "admin1")) );
    }
}