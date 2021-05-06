package com.lixiangyu.web;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.service.impl.UserServiceImpl;
import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author lixiangyu
 * @title: QueryUserList
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/56:40 下午
 */
public class QueryUserList extends HttpServlet {
    private UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if (session.getAttribute("User") == null || session.isNew()) {
            System.out.println("请先登录");
            //req.setAttribute("msg","请先登录");
            writer.print("<script> alert(\"请先登录!\");window.location.href='pages/login.html' </script>");
            //req.getRequestDispatcher("/pages/login.html").forward(req, resp);
        } else {
            List<User> userList = userService.queryUserList();
            Iterator<User> iterator = userList.iterator();
            writer.println("数据库中所储存的用户名为：");
            while (iterator.hasNext()){
                writer.println(iterator.next().getUsername());
            }
        }
    }
}
