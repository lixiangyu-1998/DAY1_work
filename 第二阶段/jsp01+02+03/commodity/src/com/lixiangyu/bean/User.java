package com.lixiangyu.bean;

import lombok.*;

import java.rmi.server.UID;

/**
 * @author lixiangyu
 * @title: user
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/68:55 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer uid;
    private String username;
    private String password;
    private boolean isalive;
    private String truename;
    private String gender;
    private String age;
    private String email;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
