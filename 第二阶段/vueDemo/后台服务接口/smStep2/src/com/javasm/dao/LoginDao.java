package com.javasm.dao;

import com.javasm.entity.User;

public interface LoginDao {
    //粒度
    User Login(User insertUser);

    String getUserRole(User insertUser);
}
