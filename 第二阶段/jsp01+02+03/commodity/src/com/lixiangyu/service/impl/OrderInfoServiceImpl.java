package com.lixiangyu.service.impl;

import com.lixiangyu.bean.OrderInfo;
import com.lixiangyu.dao.OrderInfoDao;
import com.lixiangyu.dao.impl.OrderInfoDaoImpl;
import com.lixiangyu.service.OrderInfoService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderInfoServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/94:05 下午
 */
public class OrderInfoServiceImpl implements OrderInfoService {
    private OrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
    @Override
    public List<OrderInfo> queryOrderInfoList() {
        return orderInfoDao.queryOrderInfoList();
    }

    @Override
    public int saveOrderInfo(OrderInfo orderInfo) {
        return orderInfoDao.saveOrderInfo(orderInfo);
    }

    @Override
    public List<OrderInfo> queryOrderInfoListByOid(Integer oid) {
        return orderInfoDao.queryOrderInfoListByOid(oid);
    }
}
