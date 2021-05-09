package com.lixiangyu.web;

import com.lixiangyu.bean.Commodity;
import com.lixiangyu.service.CommodityService;
import com.lixiangyu.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: CommodityServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:25 下午
 */
public class CommodityServlet extends HttpServlet {
    private CommodityService commodityService=new CommodityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿商品数量
        Integer pid = commodityService.queryCommodityLast().getPid();
        req.setAttribute("pid",pid);
        //拿结果集
        List<Commodity> commodities = commodityService.queryCommodityList();
        //保存到request域中
        req.setAttribute("commodities",commodities);
        //请求转发到 商品信息页面
        req.getRequestDispatcher("/pages/commodityInformation.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
