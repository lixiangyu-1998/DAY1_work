package com.lixiangyu.dao;

import com.lixiangyu.bean.Commodity;
import com.lixiangyu.bean.Order;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CommodityDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:03 下午
 */
public interface CommodityDao {
    /**
     * 查询返回集合
     * @param <T>
     * @return
     */
    public <T> List<T> queryCommodityList();
    /**
     * 查表中最后一条数据
     * @return
     */
    public Commodity queryCommodityLast();
}
