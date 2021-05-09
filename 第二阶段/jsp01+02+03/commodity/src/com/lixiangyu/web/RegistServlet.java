package com.lixiangyu.web;

import com.lixiangyu.bean.User;
import com.lixiangyu.service.UserService;
import com.lixiangyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author lixiangyu
 * @title: RegistServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/75:45 下午
 */
public class RegistServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    String pattern="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        String truename = req.getParameter("truename");
        String[] options = req.getParameterValues("options");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        System.out.println(options[0]);
        boolean isMatches = Pattern.matches(pattern, email);
        //做判断
        if (username==null||password.isEmpty()||repeatPassword.isEmpty()||truename==null||options[0].isEmpty()||age==null||email==null){
            System.out.println("请填写所有信息！");
            req.setAttribute("msg","请填写所有信息！");
            req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
        }else if(userService.existsUsername(username)){
            System.out.println("用户名已存在！");
            req.setAttribute("msg","用户名已存在！");
            req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
        }else if (!password.equals(repeatPassword)){
            System.out.println("两次输入的密码不一致！");
            req.setAttribute("msg","两次输入的密码不一致！");
            req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
        }else if (options[0].equals("false")){
            System.out.println("请选择性别！");
            req.setAttribute("msg","请选择性别！");
            req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
        }else if(!isMatches){
            System.out.println("请输入正确格式的邮箱！");
            req.setAttribute("msg","请输入正确格式的邮箱！");
            req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
        }else {
            userService.regisUser(new User(null,username,password,true,truename,options[0],age,email));
            System.out.println("注册成功 开始登录吧！");
            req.setAttribute("msg","注册成功 开始登录吧！");
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
        }

    }
}
