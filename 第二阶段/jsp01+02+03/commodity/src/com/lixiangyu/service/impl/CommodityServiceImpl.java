package com.lixiangyu.service.impl;

import com.lixiangyu.bean.Commodity;
import com.lixiangyu.dao.CommodityDao;
import com.lixiangyu.dao.impl.CommodityDaoImpl;
import com.lixiangyu.service.CommodityService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CommodityServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:20 下午
 */
public class CommodityServiceImpl implements CommodityService {
    private CommodityDao commodityDao=new CommodityDaoImpl();
    @Override
    public List<Commodity> queryCommodityList() {
        return commodityDao.queryCommodityList();
    }

    @Override
    public Commodity queryCommodityLast() {
        return commodityDao.queryCommodityLast();
    }
}
