package com.lixiangyu.pagingQuery.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: User
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/119:09 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String sex;
    private String age;
    private String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User(String name, String sex, String age, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }
}
