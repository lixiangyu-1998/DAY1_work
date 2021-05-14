package com.javasm.dao;

import com.javasm.entity.Menu;

import java.util.List;

public interface MenuDao {

    List<Menu> getMenuByLevel(Integer level,String roles);

    List<Menu> getMenuByPage(Integer page,Integer pagesize,Menu queryMenu);

    Integer getMenuNum(Menu queryMenu);

    Integer addMenu(Menu menu);

    Integer editMenu(Menu menu);

    Integer removeMenu(Menu menu);


}
