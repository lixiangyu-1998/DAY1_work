package com.lixiangyu.ajax.service;

import com.lixiangyu.ajax.bean.Country;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CountryService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:51 下午
 */
public interface CountryService {
    public List<Country> queryCountryByCity_code(int City_code);
}
