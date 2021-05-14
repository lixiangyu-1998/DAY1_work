package com.javasm.entity;

import java.util.List;

public class ReturnEntity {
    private Integer returnCode;
    private String returnMsg;
    private List returnData;
    private PageInfo pageinfo;
    private Object extData;

    public Object getExtData() {
        return extData;
    }

    public void setExtData(Object extData) {
        this.extData = extData;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public List getReturnData() {
        return returnData;
    }

    public void setReturnData(List returnData) {
        this.returnData = returnData;
    }

    public PageInfo getPageinfo() {
        return pageinfo;
    }

    public void setPageinfo(PageInfo pageinfo) {
        this.pageinfo = pageinfo;
    }
}
