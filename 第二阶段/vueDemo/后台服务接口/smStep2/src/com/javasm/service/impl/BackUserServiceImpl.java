package com.javasm.service.impl;

import com.javasm.dao.BackUserDao;
import com.javasm.dao.LoginDao;
import com.javasm.dao.MenuDao;
import com.javasm.dao.impl.BackUserDaoImpl;
import com.javasm.dao.impl.LoginDaoImpl;
import com.javasm.dao.impl.MenuDaoImpl;
import com.javasm.entity.BackUser;
import com.javasm.entity.Menu;
import com.javasm.entity.User;
import com.javasm.service.BackUserService;

import java.util.List;
import java.util.stream.Collectors;

public class BackUserServiceImpl implements BackUserService {

    @Override
    public List<BackUser> queryUsers(Integer page, Integer pagesize, BackUser queryUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.queryUsers(page,pagesize,queryUser);
    }

    @Override
    public Integer getUsersNum(BackUser queryUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.getUsersNum(queryUser);
    }

    @Override
    public Integer addBackUser(BackUser addUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.addBackUser(addUser);
    }

    @Override
    public Integer editBackUser(BackUser addUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.editBackUser(addUser);
    }

    @Override
    public Integer delBackUser(BackUser delUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.delBackUser(delUser);
    }

    @Override
    public List<Menu> getAllAuth() {
        MenuDao md = new MenuDaoImpl();
        List<Menu> lm1 = md.getMenuByLevel(0,"");
        List<Menu> lm2 = md.getMenuByLevel(1,"");

        for(Menu m1:lm1){
            for(Menu m2:lm2){
                if(m2.getPid()==m1.getMenuid()){
                    m1.getSubmenu().add(m2);
                }
            }
        }
        return lm1;
    }

    @Override
    public String getCurrentUserAuth(User queryUser) {
        LoginDao ld = new LoginDaoImpl();
        //查询用户的权限信息 11001,11002,12001,12002,12003,13001,14001,14002,15001,16001,16002,19001,19002,11,12,13,14,15,16
        String userRole = ld.getUserRole(queryUser);
        String userAuth = "";
        if(userRole!=null&&!"".equals(userRole)){
            MenuDao md = new MenuDaoImpl();
            List<Menu> lm2 = md.getMenuByLevel(1,userRole);
            StringBuffer sb = new StringBuffer();
            lm2.forEach(menu -> {
                sb.append(menu.getMenuid()).append(",");
            });
            userAuth = sb.deleteCharAt(sb.length() - 1).toString();
        }


        return userAuth;
    }

    @Override
    public Integer editUserAuth(BackUser editUser) {
        BackUserDao bud = new BackUserDaoImpl();
        return bud.editUserAuth(editUser);
    }
}
