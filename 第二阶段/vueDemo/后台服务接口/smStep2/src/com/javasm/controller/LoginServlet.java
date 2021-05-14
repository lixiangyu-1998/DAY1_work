package com.javasm.controller;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.service.LoginService;
import com.javasm.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRemoteHost()



        req.setCharacterEncoding("utf-8");
        System.out.println("aaaaaa");
        String uname = req.getParameter("username");
        String upwd = req.getParameter("pwd");
        System.out.println(uname);
        User insertUser = new User(uname, upwd);
        LoginService ls = new LoginServiceImpl();

        User loginUser = ls.Login(insertUser);



        ReturnEntity re = new ReturnEntity();

        if (loginUser != null) {

            //查权限 展示左侧菜单栏
            List<Menu> userRole = ls.getUserRole(loginUser);

            HttpSession session = req.getSession();
            //登录访问控制
            session.setAttribute("loginUser", loginUser);
            //权限访问控制  展示菜单
            session.setAttribute("userRoles", userRole);



            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        } else {
            re.setReturnCode(ReturnCode.LOGIN_FAILED.getCode());
            re.setReturnMsg(ReturnCode.LOGIN_FAILED.getMsg());
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        String res = JSON.toJSONString(re);
        pw.print(res);
        pw.flush();
        pw.close();


    }


}
