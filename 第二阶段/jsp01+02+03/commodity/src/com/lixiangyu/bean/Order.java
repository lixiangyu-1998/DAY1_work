package com.lixiangyu.bean;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lixiangyu
 * @title: Order
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/88:08 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer oid;
    private Integer uid;
    private String sum;
    private LocalDateTime odate;

    public Order(Integer oid, Integer uid, String sum) {
        this.oid = oid;
        this.uid = uid;
        this.sum = sum;
    }
}
