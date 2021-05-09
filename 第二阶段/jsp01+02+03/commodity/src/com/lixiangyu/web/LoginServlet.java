package com.lixiangyu.web;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lixiangyu
 * @title: LoginServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/69:38 下午
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ServletContext servletContext = getServletContext();

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User loginUser = userService.login(new User(username, password));
        if (loginUser==null){
            System.out.println("false");
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
        }else {
            System.out.println("true");
            //成功登录
            //保存用户信息到Session
            session.setAttribute("User",loginUser);
            //context 中保存uid
            System.out.println(userService.queryUserByUsername(username).getUid());
            servletContext.setAttribute("uid",userService.queryUserByUsername(username).getUid());


            req.getRequestDispatcher("/pages/login_success.jsp").forward(req,resp);
        }


    }
}
