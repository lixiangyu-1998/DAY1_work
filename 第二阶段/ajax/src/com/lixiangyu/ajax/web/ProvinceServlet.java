package com.lixiangyu.ajax.web;

import com.alibaba.fastjson.JSONObject;
import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.service.ProvinceService;
import com.lixiangyu.ajax.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: ProvinceServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/109:08 下午
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    private ProvinceService provinceService=new ProvinceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        List<Province> provinces = provinceService.queryProvinceList();
        //System.out.println(provinces);

        //java对象转json
        resp.getWriter().write(JSONObject.toJSONString(provinces));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
