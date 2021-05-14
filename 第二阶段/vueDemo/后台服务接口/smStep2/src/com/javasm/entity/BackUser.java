package com.javasm.entity;

import java.util.Date;

public class BackUser {
    Integer uid;
    String userName;
    String passWord;
    Date regTime;
    Date loginTime;
    Integer isValid;
    Integer createUid;
    String createUname;//查询时展示创建人名称
    String menuId;
    String remark;
    String headImg;

    public String getCreateUname() {
        return createUname;
    }

    public void setCreateUname(String createUname) {
        this.createUname = createUname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BackUser() {
    }

    public BackUser(Integer uid, String userName, String passWord, Date regTime, Date loginTime, Integer isValid, Integer createUid,String createUname, String menuId, String remark,String headImg) {
        this.uid = uid;
        this.userName = userName;
        this.passWord = passWord;
        this.regTime = regTime;
        this.loginTime = loginTime;
        this.isValid = isValid;
        this.createUid = createUid;
        this.menuId = menuId;
        this.remark = remark;
        this.headImg = headImg;
        this.createUname = createUname;
    }

    @Override
    public String toString() {
        return "BackUser{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", regTime=" + regTime +
                ", loginTime=" + loginTime +
                ", isValid=" + isValid +
                ", createUid=" + createUid +
                ", createUname=" + createUname +
                ", menuId='" + menuId + '\'' +
                ", remark='" + remark + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }
}
