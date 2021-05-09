package com.lixiangyu.web;

import com.lixiangyu.bean.Order;
import com.lixiangyu.service.OrderService;
import com.lixiangyu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderCheckServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/93:17 下午
 */
public class OrderCheckServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.queryOrderList();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order.jsp").forward(req,resp);
    }
}
