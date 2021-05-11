package com.lixiangyu.ajax.web;

import com.alibaba.fastjson.JSONObject;
import com.lixiangyu.ajax.bean.City;
import com.lixiangyu.ajax.service.CityService;
import com.lixiangyu.ajax.service.impl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: CityServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:31 下午
 */
@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet {
    private CityService cityService=new CityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int prov_code = Integer.parseInt(req.getParameter("prov_code"));
        List<City> cities = cityService.queryCityByProv_code(prov_code);
        resp.getWriter().write(JSONObject.toJSONString(cities));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
