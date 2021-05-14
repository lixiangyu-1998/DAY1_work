package com.javasm.service.impl;

import com.javasm.dao.MenuDao;
import com.javasm.dao.impl.MenuDaoImpl;
import com.javasm.entity.Menu;
import com.javasm.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Override
    public Integer addMenu(Menu menu) {
        MenuDao md = new MenuDaoImpl();
        return md.addMenu(menu);
    }

    @Override
    public Integer editMenu(Menu menu) {
        MenuDao md = new MenuDaoImpl();
        return md.editMenu(menu);
    }

    @Override
    public Integer removeMenu(Menu menu) {
        MenuDao md = new MenuDaoImpl();
        return md.removeMenu(menu);
    }


    @Override
    public List<Menu> getMenuByPage(Integer page, Integer pagesize, Menu queryMenu) {
        MenuDao md = new MenuDaoImpl();
        return md.getMenuByPage(page,pagesize,queryMenu);
    }



    @Override
    public Integer getMenuNum(Menu queryMenu) {
        MenuDao md = new MenuDaoImpl();
        return md.getMenuNum(queryMenu);
    }

    @Override
    public List<Menu> getMenuSelect() {
        MenuDao md = new MenuDaoImpl();
        List<Menu> lm1 = md.getMenuByLevel(0,"");
        return lm1;
    }
}
