package com.lixiangyu.web;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.service.impl.UserServiceImpl;
import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;
import sun.jvm.hotspot.gc_interface.GCWhen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lixiangyu
 * @title: RegistServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/55:59 下午
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //拿参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        String repeatPassword = req.getParameter("repeatPassword");
        //校验 合法性 失败就跳回原来页面 成功就跳到登录页面 并保存数据到数据库
        if(userService.existsUsername(username)){
            System.out.println("用户名已存在！");
            writer.print("<script> alert(\"用户名已存在！\");window.location.href='pages/regist.html' </script>");
            //req.getRequestDispatcher("/pages/regist.html").forward(req,resp);
        }else if (!password.equals(repeatPassword)){
            System.out.println("两次输入的密码不一致！");
            writer.print("<script> alert(\"两次输入的密码不一致！\");window.location.href='pages/regist.html' </script>");
            //req.getRequestDispatcher("/pages/regist.html").forward(req,resp);
        }else{
            userService.regisUser(new User(null,username,password));
            req.getRequestDispatcher("/pages/login.html").forward(req,resp);

        }
    }
}
