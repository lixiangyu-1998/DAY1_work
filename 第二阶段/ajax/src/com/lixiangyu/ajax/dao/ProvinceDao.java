package com.lixiangyu.ajax.dao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: ProvinceDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:53 下午
 */
public interface ProvinceDao {
    /**
     * 查询返回provin 集合
     * @param <T>
     * @return
     */
    public <T> List<T> queryProvinceList();
}
