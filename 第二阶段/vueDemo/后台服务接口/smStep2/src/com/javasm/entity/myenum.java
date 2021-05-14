package com.javasm.entity;

public enum myenum {

    FAILED(1001,"abc"),
    SUCCESS(1001,"abc");

    private Integer code;
    private String msg;
    private myenum(Integer code,String msg){
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
