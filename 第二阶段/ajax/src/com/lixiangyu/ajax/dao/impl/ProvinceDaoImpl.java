package com.lixiangyu.ajax.dao.impl;

import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.dao.BaseDao;
import com.lixiangyu.ajax.dao.ProvinceDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: ProvinceDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:55 下午
 */
public class ProvinceDaoImpl extends BaseDao implements ProvinceDao {
    @Override
    public List<Province> queryProvinceList() {
        String sql="SELECT * FROM tb_prov";
        return queryForList(Province.class,sql);
    }
}
