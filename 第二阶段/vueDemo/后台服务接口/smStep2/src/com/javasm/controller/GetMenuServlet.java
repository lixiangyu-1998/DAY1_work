package com.javasm.controller;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getmenu")
public class GetMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Map<String,Object> returnMap = new HashMap<String,Object>();
        HttpSession session = req.getSession();
        List<Menu> userRoles = (List<Menu>) session.getAttribute("userRoles");
        //returnMap.put("menus",userRoles);
        //returnMap.put("recode",10000);
        ReturnEntity re = new ReturnEntity();
        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        re.setReturnData(userRoles);
        String res = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(res);
        writer.flush();
        writer.close();
    }
}
