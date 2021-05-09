package com.lixiangyu.service;

import com.lixiangyu.bean.Order;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:23 下午
 */
public interface OrderService {
    /**
     * 返回订单list
     * @return
     */
    public List<Order> queryOrderList();

    /**
     * 保存order对象到数据库
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 查询表中最后一条数据
     * @return
     */
    public Order queryOrderLast();
}
