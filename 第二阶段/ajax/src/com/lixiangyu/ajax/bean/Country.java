package com.lixiangyu.ajax.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: Country
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/108:49 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country {
    private Integer coun_code;
    private String coun_name;
    private Integer city_code;
}
