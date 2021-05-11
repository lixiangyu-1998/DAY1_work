package com.lixiangyu.ajax.test;

import com.lixiangyu.ajax.bean.Province;
import com.lixiangyu.ajax.service.ProvinceService;
import com.lixiangyu.ajax.service.impl.ProvinceServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author lixiangyu
 * @title: provinceTest
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1010:08 下午
 */

public class provinceTest {
    @Test
    public static void main(String[] args) {
        ProvinceService provinceService=new ProvinceServiceImpl();
        List<Province> provinces = provinceService.queryProvinceList();
        System.out.println(provinces);
    }


}
