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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/logout")
public class LoginOutServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();
        HttpSession session = req.getSession();
        //登录访问控制
        session.removeAttribute("loginUser");
        //权限访问控制  展示菜单
        session.removeAttribute("userRoles");

        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        String res = JSON.toJSONString(re);
        pw.print(res);
        pw.flush();
        pw.close();


    }


}
