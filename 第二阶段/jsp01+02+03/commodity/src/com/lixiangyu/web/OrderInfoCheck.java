package com.lixiangyu.web;

import com.lixiangyu.bean.OrderInfo;
import com.lixiangyu.service.OrderInfoService;
import com.lixiangyu.service.impl.OrderInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderInfoCheck
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/96:09 下午
 */
public class OrderInfoCheck extends HttpServlet {
    private OrderInfoService orderInfoService=new OrderInfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("action");
        System.out.println(oid);
        int i = Integer.parseInt(oid);
        //Integer oid = (Integer)req.getAttribute("action");
        System.out.println(i);
        List<OrderInfo> orderInfos = orderInfoService.queryOrderInfoListByOid(i);
        req.setAttribute("orderInfos",orderInfos);
        req.getRequestDispatcher("/pages/orderInfo.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
