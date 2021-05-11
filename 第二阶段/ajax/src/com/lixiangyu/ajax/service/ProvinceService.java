package com.lixiangyu.ajax.service;

import com.lixiangyu.ajax.bean.Province;

import java.util.List;

/**
 * @author lixiangyu
 * @title: ProvinceService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:58 下午
 */
public interface ProvinceService {
    /**
     * 查询返回provin 集合
     * @return
     */
    public List<Province> queryProvinceList();
}
