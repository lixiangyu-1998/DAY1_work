package com.lixiangyu.servlet;

import jakarta.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author lixiangyu
 */
public class ServletWork extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置相应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String title="用户提交的数据";
        //处理中文
//        String username=new String(req.getParameter("username")
//                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        String address=new String(req.getParameter("address")
//                .getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
        String docType = "<!DOCTYPE html> \n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>姓名</b>："
                + req.getParameter("username") + "\n" +
                "  <li><b>年龄</b>："
                + req.getParameter("age") + "\n" +
                "  <li><b>籍贯</b>："
                + req.getParameter("area1") +"省"+ "\n" +
                 req.getParameter("area2")+"市" + "\n" +
                "  <li><b>地址</b>："
                + req.getParameter("address") + "\n" +
                "  <li><b>性别</b>："
                + req.getParameter("sex") + "\n" +
                "  <li><b>个人介绍</b>："
                + req.getParameter("textarea01") + "\n" +
                "  <li><b>备注</b>："
                + req.getParameter("textarea02") + "\n" +
                "</ul>\n" +
                "</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
