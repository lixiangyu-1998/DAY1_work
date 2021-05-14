package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());//servlet路径
        System.out.println(req.getRequestURI());//用户输入的请求路径
        String requri = req.getRequestURI();
        String methodName = requri.substring(requri.lastIndexOf("/")+1);
        System.out.println(methodName);

        try {
            //用路径中的最后一段 决定调用哪个方法
            // 从路径中的最后一段  抽取出方法对象
            //再用被调用的子类实例 调用方法
            Method mymethod = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            mymethod.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            //异常信息告知给tomcat 让tomcat给用户报错
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
