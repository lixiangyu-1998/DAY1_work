package com.javasm.entity;

public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userRegTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRegTime() {

        return userRegTime.split("\\.")[0];
    }

    public void setUserRegTime(String userRegTime) {
        this.userRegTime = userRegTime;
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(Integer userId, String userName, String userPwd, String userRegTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRegTime = userRegTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRegTime='" + userRegTime + '\'' +
                '}';
    }

    public User() {
        super();
    }
}
