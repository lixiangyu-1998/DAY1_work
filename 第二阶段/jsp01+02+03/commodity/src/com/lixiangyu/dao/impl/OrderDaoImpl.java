package com.lixiangyu.dao.impl;

import com.lixiangyu.bean.Order;
import com.lixiangyu.dao.BaseDao;
import com.lixiangyu.dao.OrderDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:20 下午
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> queryOrderList() {
        String sql="select * from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public int saveOrder(Order order) {
        String sql="INSERT INTO t_order(uid,sum,odate) VALUES(?,?,NOW())";
        return update(sql,order.getUid(),order.getSum());
    }

    @Override
    public Order queryOrderLast() {
        String sql="SELECT * from t_order ORDER BY oid desc LIMIT 1";
        return queryForOne(Order.class,sql);
    }

}
