package com.lixiangyu.ajax.web;

import com.alibaba.fastjson.JSONObject;
import com.lixiangyu.ajax.bean.Country;
import com.lixiangyu.ajax.service.CountryService;
import com.lixiangyu.ajax.service.impl.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: CountryServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:53 下午
 */
@WebServlet("/countryServlet")
public class CountryServlet extends HttpServlet {
    private CountryService countryService=new CountryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int city_code = Integer.parseInt(req.getParameter("city_code"));
        List<Country> countries = countryService.queryCountryByCity_code(city_code);

        resp.getWriter().write(JSONObject.toJSONString(countries));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
