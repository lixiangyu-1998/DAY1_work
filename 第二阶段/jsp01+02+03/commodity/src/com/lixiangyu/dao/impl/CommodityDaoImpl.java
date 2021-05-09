package com.lixiangyu.dao.impl;

import com.lixiangyu.bean.Commodity;
import com.lixiangyu.bean.Order;
import com.lixiangyu.dao.BaseDao;
import com.lixiangyu.dao.CommodityDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CommodityDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:04 下午
 */
public class CommodityDaoImpl extends BaseDao implements CommodityDao {

    @Override
    public List<Commodity> queryCommodityList() {
        String sql="SELECT * FROM t_commodity";
        return queryForList(Commodity.class,sql);
    }

    @Override
    public Commodity queryCommodityLast() {
        String sql="SELECT * from t_commodity ORDER BY pid desc LIMIT 1";
        return queryForOne(Commodity.class,sql);
    }
}
