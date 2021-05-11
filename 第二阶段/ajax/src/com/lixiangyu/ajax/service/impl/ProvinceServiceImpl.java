package com.lixiangyu.ajax.service.impl;

import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.dao.ProvinceDao;
import com.lixiangyu.ajax.dao.impl.ProvinceDaoImpl;
import com.lixiangyu.ajax.service.ProvinceService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: ProvinceServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:59 下午
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> queryProvinceList() {
        return provinceDao.queryProvinceList();
    }
}
