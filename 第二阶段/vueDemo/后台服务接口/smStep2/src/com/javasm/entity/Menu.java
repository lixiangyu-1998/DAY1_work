package com.javasm.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Integer menuid;
    private String menuname;
    private String menuurl;
    private Integer pid;
    private String pname;
    private String glyphicon;
    private List<Menu> submenu = new ArrayList<Menu>();

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public List<Menu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<Menu> submenu) {
        this.submenu = submenu;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getGlyphicon() {
        return glyphicon;
    }

    public void setGlyphicon(String glyphicon) {
        this.glyphicon = glyphicon;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", glyphicon='" + glyphicon + '\'' +
                ", submenu=" + submenu +
                '}';
    }

    public Menu(Integer menuid, String menuname, String menuurl, Integer pid,String pname, String glyphicon) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.menuurl = menuurl;

        this.pid = pid;
        this.pname = pname;
        this.glyphicon = glyphicon;
    }

    public Menu(String menuname,Integer pid) {
        this.menuname = menuname;
        this.pid = pid;
    }
    public Menu() {
        super();
    }
}
