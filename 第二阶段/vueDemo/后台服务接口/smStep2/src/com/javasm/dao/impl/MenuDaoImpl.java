package com.javasm.dao.impl;

import com.javasm.dao.MenuDao;
import com.javasm.entity.Menu;
import com.javasm.entity.User;
import com.javasm.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
    @Override
    public Integer addMenu(Menu menu) {

        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "insert into pn_admin_menu(mid,menuname,pid,url,glyphicon) VALUES(?,?,?,?,?)";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setInt(1,menu.getMenuid());
            psta.setString(2,menu.getMenuname());
            psta.setInt(3,menu.getPid());
            psta.setString(4,menu.getMenuurl());
            psta.setString(5,menu.getGlyphicon());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

    @Override
    public Integer editMenu(Menu menu) {
        //update pn_admin_menu set menuname=112,pid=0,url=112,glyphicon=112 where mid=111
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "update pn_admin_menu set menuname=?,pid=?,url=?,glyphicon=? where mid=?";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setString(1,menu.getMenuname());
            psta.setInt(2,menu.getPid());
            psta.setString(3,menu.getMenuurl());
            psta.setString(4,menu.getGlyphicon());
            psta.setInt(5,menu.getMenuid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

    @Override
    public Integer removeMenu(Menu menu) {
        //delete from pn_admin_menu where mid=111
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "delete from pn_admin_menu where mid=?";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setInt(1,menu.getMenuid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

    @Override
    public List<Menu> getMenuByLevel(Integer level,String roles) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        List<Menu> menus =new ArrayList<Menu>();
        conn = JDBCUtil.getConn();
        String sql = "select mu.mid,mu.menuname,mu.pid,mu.url,mu.glyphicon from pn_admin_menu mu where ";
        if(level==0){
            sql+="mu.pid=0 ";
        }else{
            sql+="mu.pid!=0 ";
        }
        if(roles!=null&&!"".equals(roles)){
            sql+=" and  mu.mid in ("+roles+") ";
        }
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            rs = psta.executeQuery();
            while(rs.next()){
                Integer uid = rs.getInt("mid");
                String menuname = rs.getString("menuname");
                Integer pid = rs.getInt("pid");
                String url = rs.getString("url");
                String glyphicon = rs.getString("glyphicon");
                Menu menu = new Menu(uid,menuname,url,pid,"",glyphicon);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return menus;
    }

    @Override
    public List<Menu> getMenuByPage(Integer page, Integer pagesize, Menu queryMenu) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        List<Menu> menus =new ArrayList<Menu>();
        conn = JDBCUtil.getConn();
        List paramlist = new ArrayList();
        boolean iswhere = true;
        String sql = "select mu.mid,mu.menuname,mu.pid,IFNULL(mu2.menuname,'无')  pname,mu.url,mu.glyphicon from pn_admin_menu mu left join pn_admin_menu mu2 on mu.pid=mu2.mid ";
        if(queryMenu.getMenuname()!=null&&!"".equals(queryMenu.getMenuname())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" mu.menuname like ? ";
            paramlist.add("%"+queryMenu.getMenuname()+"%");
        }

        if(queryMenu.getPid()!=null&&!"".equals(queryMenu.getPid())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" mu.pid = ? ";
            paramlist.add(queryMenu.getPid());
        }


        sql+=" limit "+(page-1)*pagesize+","+pagesize;
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            for(int i = 0;i<paramlist.size();i++){
                psta.setObject(i+1,paramlist.get(i));
            }
            rs = psta.executeQuery();
            while(rs.next()){
                Integer uid = rs.getInt("mid");
                String menuname = rs.getString("menuname");
                Integer pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                String url = rs.getString("url");
                String glyphicon = rs.getString("glyphicon");
                Menu menu = new Menu(uid,menuname,url,pid,pname,glyphicon);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return menus;
    }

    @Override
    public Integer getMenuNum(Menu queryMenu) {

        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        List paramlist = new ArrayList();
        boolean iswhere = true;
        String sql = "select count(1) total from pn_admin_menu mu";
        if(queryMenu.getMenuname()!=null&&!"".equals(queryMenu.getMenuname())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" mu.menuname like ? ";
            paramlist.add("%"+queryMenu.getMenuname()+"%");
        }

        if(queryMenu.getPid()!=null&&!"".equals(queryMenu.getPid())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" mu.pid = ? ";
            paramlist.add(queryMenu.getPid());
        }
        Integer total = 0;
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            for(int i = 0;i<paramlist.size();i++){
                psta.setObject(i+1,paramlist.get(i));
            }
            rs = psta.executeQuery();
            while(rs.next()){
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return total;
    }
}
