package com.lixiangyu.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: User
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/48:03 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
}
