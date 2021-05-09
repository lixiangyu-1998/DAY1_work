package com.lixiangyu.web;

import com.lixiangyu.bean.Order;
import com.lixiangyu.bean.OrderInfo;
import com.lixiangyu.service.CommodityService;
import com.lixiangyu.service.OrderInfoService;
import com.lixiangyu.service.OrderService;
import com.lixiangyu.service.impl.CommodityServiceImpl;
import com.lixiangyu.service.impl.OrderInfoServiceImpl;
import com.lixiangyu.service.impl.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.CommonDataSource;
import java.io.IOException;
import java.util.concurrent.CompletionService;

import static java.time.LocalTime.now;

/**
 * @author lixiangyu
 * @title: OrderServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:27 下午
 */
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private OrderInfoService orderInfoService=new OrderInfoServiceImpl();
    private CommodityService commodityService=new CommodityServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //简要订单被保存到数据库
        String sum = req.getParameter("sum");
        ServletContext servletContext = getServletContext();
        Integer uid = (Integer) servletContext.getAttribute("uid");
        System.out.println(uid);
        orderService.saveOrder(new Order(null,uid ,sum));
        //一并 把详细订单也存到数据库
        int i=1;
        int oid=orderService.queryOrderLast().getOid();
        oid+=1;
        //商品数量
        Integer pid1 = commodityService.queryCommodityLast().getPid();
        pid1+=1;
        System.out.println(pid1);
        while (i< pid1){
            String pid=req.getParameter("pid"+i);
            String num=req.getParameter("num"+i);
            int i1 = Integer.parseInt(num);
            System.out.println(i1);
            if (i1!=0){
                //数量不是0就存到数据库中
                orderInfoService.saveOrderInfo(new OrderInfo(null,oid,pid,num));
            }
            i++;
        }
        req.getRequestDispatcher("/pages/login_success.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
