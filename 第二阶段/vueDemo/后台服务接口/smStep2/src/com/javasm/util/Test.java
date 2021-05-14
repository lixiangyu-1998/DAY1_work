package com.javasm.util;

import com.javasm.dao.BackUserDao;
import com.javasm.dao.LoginDao;
import com.javasm.dao.MenuDao;
import com.javasm.dao.impl.BackUserDaoImpl;
import com.javasm.dao.impl.MenuDaoImpl;
import com.javasm.entity.BackUser;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.User;
import com.javasm.dao.impl.LoginDaoImpl;
import com.javasm.service.BackUserService;
import com.javasm.service.impl.BackUserServiceImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        LoginDao ldi = new LoginDaoImpl();
//        User user = ldi.Login(new User("测试1","abc123"));
//        System.out.println(user);
//        System.out.println(user.getUserRegTime());
/*        User user = new User();
        user.setUserId(9);
        String roles = ldi.getUserRole(user);
        MenuDao md = new MenuDaoImpl();
        List<Menu> lm1 = md.getMenuByLevel(0,roles);
        List<Menu> lm2 = md.getMenuByLevel(1,roles);
        System.out.println(lm1);
        System.out.println(lm2);
        for(Menu m1:lm1){
            for(Menu m2:lm2){
                if(m2.getPid()==m1.getMenuid()){
                    m1.getSubmenu().add(m2);
                }
            }
        }
        System.out.println(lm1);

        System.out.println(ReturnCode.FAILED.getCode());
        System.out.println(ReturnCode.FAILED.getMsg());*/
        BackUserDao md = new BackUserDaoImpl();
        BackUser backUser = new BackUser();
        //backUser.setUid(3);
        backUser.setUserName("i");
        backUser.setUid(1);
        backUser.setIsValid(1);
        backUser.setHeadImg("aaaaaa");
        backUser.setRemark("ccc");
        //Integer integer = md.editBackUser(backUser);
        BackUserService bus = new BackUserServiceImpl();
        User user = new User();
        user.setUserId(1);
        System.out.println(bus.getCurrentUserAuth(user));
    }
}
