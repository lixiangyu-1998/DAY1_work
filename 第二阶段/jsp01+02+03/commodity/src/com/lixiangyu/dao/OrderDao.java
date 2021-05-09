package com.lixiangyu.dao;

import com.lixiangyu.bean.Order;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:17 下午
 */
public interface OrderDao {
    /**
     * 查询返回订单集合
     * @param <T>
     * @return
     */
    public <T> List<T> queryOrderList();

    /**
     * 保存order对象
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 查表中最后一条数据
     * @return
     */
    public Order queryOrderLast();
}
