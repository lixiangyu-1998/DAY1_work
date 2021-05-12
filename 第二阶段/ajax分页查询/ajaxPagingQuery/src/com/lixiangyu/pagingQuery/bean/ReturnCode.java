package com.lixiangyu.pagingQuery.bean;

import lombok.Getter;

/**
 * @author lixiangyu
 * @title: ReturnCode
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/119:05 下午
 */
@Getter
public enum ReturnCode {
    /**
     * 错误码
     */
    SUCCESS("200","成功"),
    ERROR("404","失败");
    private String code;
    private String msg;

    private ReturnCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
