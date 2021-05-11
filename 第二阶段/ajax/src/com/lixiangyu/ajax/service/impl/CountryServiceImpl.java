package com.lixiangyu.ajax.service.impl;

import com.lixiangyu.ajax.bean.Country;
import com.lixiangyu.ajax.dao.CountryDao;
import com.lixiangyu.ajax.dao.impl.CountryDaoImpl;
import com.lixiangyu.ajax.service.CountryService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CountryServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:51 下午
 */
public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao=new CountryDaoImpl();
    @Override
    public List<Country> queryCountryByCity_code(int City_code) {
        return countryDao.queryCountryByCity_code(City_code);
    }
}
