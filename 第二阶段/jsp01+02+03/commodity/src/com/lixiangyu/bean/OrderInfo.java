package com.lixiangyu.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: OrderInfo
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:09 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfo {
    private Integer opid;
    private Integer oid;
    private String pid;
    private String num;
}
