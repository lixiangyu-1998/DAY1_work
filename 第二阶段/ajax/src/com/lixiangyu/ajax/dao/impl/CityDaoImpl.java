package com.lixiangyu.ajax.dao.impl;

import com.lixiangyu.ajax.bean.City;
import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.dao.BaseDao;
import com.lixiangyu.ajax.dao.CityDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CityServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:27 下午
 */
public class CityDaoImpl extends BaseDao implements CityDao {
    @Override
    public List<City> queryCityByProv_code(int Prov_code) {
        String sql="SELECT * FROM tb_city WHERE Prov_code=?";
        return queryForList(City.class,sql,Prov_code);
    }
}
