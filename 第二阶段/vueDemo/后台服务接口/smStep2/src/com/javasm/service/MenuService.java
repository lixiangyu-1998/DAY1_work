package com.javasm.service;

import com.javasm.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenuByPage(Integer page, Integer pagesize, Menu queryMenu);

    Integer getMenuNum(Menu queryMenu);

    List<Menu> getMenuSelect();

    Integer addMenu(Menu menu);

    Integer editMenu(Menu menu);

    Integer removeMenu(Menu menu);

}
