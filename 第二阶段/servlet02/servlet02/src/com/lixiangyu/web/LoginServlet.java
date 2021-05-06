package com.lixiangyu.web;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lixiangyu
 * @title: LoginServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/49:31 下午
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        //调用userService 处理登录业务
        User loginUser = userService.login(new User(null,username, password));
        //如果是null 说明登录失败
        if(loginUser==null){
            //跳到登录页面
            writer.print("<script> alert(\"用户名或密码错误!\");window.location.href='pages/login.html' </script>");
            //req.getRequestDispatcher("/pages/login.html").forward(req,resp);
        }else {
            //成功登录
            //保存用户信息到Session
            req.getSession().setAttribute("User",loginUser);
            // 跳到登录成功页面
            System.out.println("true");
            req.getRequestDispatcher("/pages/login_success.html").forward(req,resp);
        }
    }
}
