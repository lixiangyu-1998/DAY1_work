package com.lixiangyu.dao.impl;

import com.lixiangyu.bean.OrderInfo;
import com.lixiangyu.dao.BaseDao;
import com.lixiangyu.dao.OrderInfoDao;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.List;

/**
 * @author lixiangyu
 * @title: OrderInfoDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/93:55 下午
 */
public class OrderInfoDaoImpl extends BaseDao implements OrderInfoDao {
    @Override
    public int saveOrderInfo(OrderInfo orderInfo) {
        String sql="INSERT INTO t_order_prod(oid,pid,num) VALUES(?,?,?)";
        return update(sql,orderInfo.getOid(),orderInfo.getPid(),orderInfo.getNum());
    }

    @Override
    public List<OrderInfo> queryOrderInfoListByOid(Integer oid) {
        String sql="SELECT * FROM t_order_prod WHERE oid=?";
        return queryForList(OrderInfo.class,sql,oid);
    }

    @Override
    public List<OrderInfo> queryOrderInfoList() {
        String sql="SELECT * FROM t_order_prod";
        return queryForList(OrderInfo.class,sql);
    }
}
