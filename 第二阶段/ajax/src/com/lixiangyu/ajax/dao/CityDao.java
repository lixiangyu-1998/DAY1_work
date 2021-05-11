package com.lixiangyu.ajax.dao;

import com.lixiangyu.ajax.bean.City;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CityDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:25 下午
 */
public interface CityDao {
    /**
     * 通过省编号返回城市对象
     * @param Prov_code
     * @return
     */
    public <T> List<T> queryCityByProv_code(int Prov_code);
}
