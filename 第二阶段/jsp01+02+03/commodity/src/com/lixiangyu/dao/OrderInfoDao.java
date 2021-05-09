package com.lixiangyu.dao;

import com.lixiangyu.bean.OrderInfo;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderInfoDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/93:49 下午
 */
public interface OrderInfoDao {
    /**
     * 保存OrderInfo对象
     * @param orderInfo
     * @return
     */
    public int saveOrderInfo(OrderInfo orderInfo);

    /**
     * 查询返回订单详情集合
     * @param <T>
     * @return
     */
    public <T> List<T> queryOrderInfoList();

    /**
     * 通过订单编号 返回集合
     * @param <T>
     * @return
     */
    public <T> List<T> queryOrderInfoListByOid(Integer oid);
}
