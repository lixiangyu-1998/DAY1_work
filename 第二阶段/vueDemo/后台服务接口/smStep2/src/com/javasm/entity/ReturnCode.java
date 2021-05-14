package com.javasm.entity;

public enum ReturnCode {

    SUCCESS(10000,"操作成功"),
    FAILED(10001,"操作失败"),
    DATA_ERROR(10005,"数据异常"),
    LOGIN_FAILED(20001,"用户名或密码错误"),
    NOT_LOGIN(20000,"没有登录");


    private Integer code;
    private String msg;
    private ReturnCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

 

    public String getMsg() {
        return msg;
    }


}
