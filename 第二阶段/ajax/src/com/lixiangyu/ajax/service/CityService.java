package com.lixiangyu.ajax.service;

import com.lixiangyu.ajax.bean.City;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CityService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:30 下午
 */
public interface CityService {
    /**
     * 通过省编号返回城市对象
     * @param Prov_code
     * @return
     */
    public List<City> queryCityByProv_code(int Prov_code);
}
