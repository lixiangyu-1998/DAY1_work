package com.lixiangyu.ajax.dao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CountryDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:47 下午
 */
public interface CountryDao {
    public <T> List<T> queryCountryByCity_code(int City_code);
}
