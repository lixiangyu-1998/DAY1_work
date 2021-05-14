package com.javasm.dao;

import com.javasm.entity.BackUser;

import java.util.List;

public interface BackUserDao {

    List<BackUser> queryUsers(Integer page,Integer pagesize,BackUser queryUser);
    Integer getUsersNum(BackUser queryUser);

    Integer addBackUser(BackUser addUser);

    Integer editBackUser(BackUser editUser);

    Integer delBackUser(BackUser delUser);

    Integer editUserAuth(BackUser editUser);
}
