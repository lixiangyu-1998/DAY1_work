package com.lixiangyu.ajax.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: City
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:46 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    private Integer city_code;
    private String city_name;
    private Integer prov_code;
}
