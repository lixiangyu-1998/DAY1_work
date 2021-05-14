package com.javasm.service.impl;

import com.javasm.dao.LoginDao;
import com.javasm.dao.MenuDao;
import com.javasm.dao.impl.MenuDaoImpl;
import com.javasm.entity.Menu;
import com.javasm.entity.User;
import com.javasm.dao.impl.LoginDaoImpl;
import com.javasm.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    @Override
    public User Login(User insertUser) {
        LoginDao ld = new LoginDaoImpl();
        return ld.Login(insertUser);
}

    @Override
    public List<Menu> getUserRole(User insertUser) {
        LoginDao ld = new LoginDaoImpl();
        //查询用户的权限信息 11001,11002,12001,12002,12003,13001,14001,14002,15001,16001,16002,19001,19002,11,12,13,14,15,16
        String userRole = ld.getUserRole(insertUser);
        MenuDao md = new MenuDaoImpl();
        //查一级菜单
        List<Menu> lm1 = md.getMenuByLevel(0,userRole);
        //查二级菜单
        List<Menu> lm2 = md.getMenuByLevel(1,userRole);
        System.out.println(lm1);
        System.out.println(lm2);
        //遍历一级菜单 过程中遍历二级菜单
        //用二级菜单的pid 和一级菜单的mid匹配
        //如果匹配上 把当前遍历到的二级菜单 放入一级菜单的submenu中
        for(Menu m1:lm1){
            for(Menu m2:lm2){
                if(m2.getPid()==m1.getMenuid()){
                    m1.getSubmenu().add(m2);
                }
            }
        }
        return lm1;
    }
}
