package com.javasm.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/upload")
@MultipartConfig
public class UserHeadImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求到");
        Part file = req.getPart("myfile");
        System.out.println("取到的文件"+file.getName());
        System.out.println("取到的文件2"+file.getSubmittedFileName());
        String basePath = req.getServletContext().getRealPath("/");
        String folder = "img/";
        System.out.println(basePath+folder+file.getSubmittedFileName());
        file.write(basePath+folder+file.getSubmittedFileName());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("imgsrc","http://localhost:8080/"+folder+file.getSubmittedFileName());
        writer.print(JSON.toJSONString(returnMap));
        writer.flush();
        writer.close();
    }
}
