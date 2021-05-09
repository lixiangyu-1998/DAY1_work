package com.lixiangyu.service;

import com.lixiangyu.bean.Commodity;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CommodityService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:18 下午
 */
public interface CommodityService {
    /**
     * 返回商品list
     * @return
     */
    public List<Commodity> queryCommodityList();

    /**
     * 查表中最后一条数据
     * @return
     */
    public Commodity queryCommodityLast();
}
