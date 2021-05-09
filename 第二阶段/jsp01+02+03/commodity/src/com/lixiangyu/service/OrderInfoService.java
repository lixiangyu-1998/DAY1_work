package com.lixiangyu.service;

import com.lixiangyu.bean.Order;
import com.lixiangyu.bean.OrderInfo;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderInfoService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/94:04 下午
 */
public interface OrderInfoService {
    /**
     * 返回订单list
     * @return
     */
    public List<OrderInfo> queryOrderInfoList();

    /**
     * 保存orderInfo对象到数据库
     * @return
     */
    public int saveOrderInfo(OrderInfo orderInfo);
    /**
     * 通过订单编号 返回集合
     * @param <T>
     * @return
     */
    public List<OrderInfo> queryOrderInfoListByOid(Integer oid);
}
