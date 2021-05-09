package com.lixiangyu.bean;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author lixiangyu
 * @title: Commodity
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/78:00 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {
    private Integer pid;
    private String pname;
    private BigDecimal price;
    private String pimg;
    private String pdesc;
}
