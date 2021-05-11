package com.lixiangyu.ajax.service.impl;

import com.lixiangyu.ajax.bean.City;
import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.dao.CityDao;
import com.lixiangyu.ajax.dao.impl.CityDaoImpl;
import com.lixiangyu.ajax.service.CityService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: CityServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:30 下午
 */
public class CityServiceImpl implements CityService {
    private CityDao cityDao=new CityDaoImpl();
    @Override
    public List<City>  queryCityByProv_code(int Prov_code) {
        return cityDao.queryCityByProv_code(Prov_code);
    }
}
