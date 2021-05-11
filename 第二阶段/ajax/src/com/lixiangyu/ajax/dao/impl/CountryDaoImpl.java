package com.lixiangyu.ajax.dao.impl;

import com.lixiangyu.ajax.bean.Country;
import com.lixiangyu.ajax.dao.BaseDao;
import com.lixiangyu.ajax.dao.CountryDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CountryDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:49 下午
 */
public class CountryDaoImpl extends BaseDao implements CountryDao {
    @Override
    public List<Country> queryCountryByCity_code(int City_code) {
        String sql="SELECT * FROM tb_country WHERE city_code=?";
        return queryForList(Country.class,sql,City_code );
    }
}
