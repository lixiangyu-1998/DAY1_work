package com.lixiangyu.service.impl;

import com.lixiangyu.bean.Order;
import com.lixiangyu.dao.OrderDao;
import com.lixiangyu.dao.impl.OrderDaoImpl;
import com.lixiangyu.service.OrderService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:25 下午
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public List<Order> queryOrderList() {
        return orderDao.queryOrderList();
    }

    @Override
    public int saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public Order queryOrderLast() {
        return orderDao.queryOrderLast();
    }
}
