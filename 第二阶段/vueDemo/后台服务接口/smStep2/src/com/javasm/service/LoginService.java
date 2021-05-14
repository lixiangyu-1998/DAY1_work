package com.javasm.service;

import com.javasm.entity.Menu;
import com.javasm.entity.User;

import java.util.List;

public interface LoginService {

    User Login(User insertUser);
    List<Menu> getUserRole(User insertUser);
}
