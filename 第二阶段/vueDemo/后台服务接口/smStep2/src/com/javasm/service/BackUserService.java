package com.javasm.service;

import com.javasm.entity.BackUser;
import com.javasm.entity.Menu;
import com.javasm.entity.User;

import java.util.List;

public interface BackUserService {

    List<BackUser> queryUsers(Integer page, Integer pagesize, BackUser queryUser);
    Integer getUsersNum(BackUser queryUser);

    Integer addBackUser(BackUser addUser);

    Integer editBackUser(BackUser editUser);

    Integer delBackUser(BackUser delUser);

    List<Menu> getAllAuth();

    String getCurrentUserAuth(User queryUser);

    Integer editUserAuth(BackUser editUser);

}
