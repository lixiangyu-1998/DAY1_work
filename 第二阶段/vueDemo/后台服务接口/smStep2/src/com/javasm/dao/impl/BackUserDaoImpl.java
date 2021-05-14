package com.javasm.dao.impl;

import com.javasm.dao.BackUserDao;
import com.javasm.entity.BackUser;
import com.javasm.entity.Menu;
import com.javasm.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackUserDaoImpl implements BackUserDao {
    @Override
    public List<BackUser> queryUsers(Integer page,Integer pagesize,BackUser queryUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        List<BackUser> users =new ArrayList<BackUser>();
        conn = JDBCUtil.getConn();
        List paramlist = new ArrayList();
        boolean iswhere = true;
        String sql = "select pau.uid,pau.username,pau.`password`,pau.reg_time,pau.login_time,pau.isvalid,pau.create_uid,pau2.username as create_uname,pau.remark,pau.head_img from pn_admin_user pau LEFT JOIN pn_admin_user pau2 on pau.create_uid = pau2.uid ";
        if(queryUser.getUserName()!=null&&!"".equals(queryUser.getUserName())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" pau.username like ? ";
            paramlist.add("%"+queryUser.getUserName()+"%");
        }

        if(queryUser.getUid()!=null&&!"".equals(queryUser.getUid())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" pau.uid = ? ";
            paramlist.add(queryUser.getUid());
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
                               Integer uid = rs.getInt("uid");
                String userName = rs.getString("username");
                String passWord = rs.getString("password");

                Date regTime = rs.getTimestamp("reg_time");
                Date loginTime = rs.getTimestamp("login_time");
                Integer isValid = rs.getInt("isvalid");
                Integer createUid = rs.getInt("create_uid");

                String createUname = rs.getString("create_uname");
                String remark = rs.getString("remark");
                String headImg = rs.getString("head_img");
                //权限列表menuID查询用户时不需要
                BackUser backUser = new BackUser(uid, userName, passWord, regTime, loginTime, isValid, createUid, createUname, null, remark, headImg);

                users.add(backUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return users;
    }

    @Override
    public Integer getUsersNum(BackUser queryUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        Integer totalNum = 0;
        conn = JDBCUtil.getConn();
        List paramlist = new ArrayList();
        boolean iswhere = true;
        String sql = "select count(1) as total_num from pn_admin_user pau ";
        if(queryUser.getUserName()!=null&&!"".equals(queryUser.getUserName())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" pau.username like ? ";
            paramlist.add("%"+queryUser.getUserName()+"%");
        }

        if(queryUser.getUid()!=null&&!"".equals(queryUser.getUid())){
            if(iswhere){
                sql+=" where ";
                iswhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" pau.uid = ? ";
            paramlist.add(queryUser.getUid());
        }
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            for(int i = 0;i<paramlist.size();i++){
                psta.setObject(i+1,paramlist.get(i));
            }
            rs = psta.executeQuery();
            while(rs.next()){
                totalNum = rs.getInt("total_num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return totalNum;
    }

    @Override
    public Integer addBackUser(BackUser addUser) {

        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "insert into pn_admin_user(uid,username,password,isvalid,head_img,remark,reg_time,create_uid) values(?,?,?,?,?,?,now(),?)";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setInt(1,addUser.getUid());
            psta.setString(2,addUser.getUserName());
            psta.setString(3,addUser.getPassWord());
            psta.setInt(4,addUser.getIsValid());
            psta.setString(5,addUser.getHeadImg());
            psta.setString(6,addUser.getRemark());
            psta.setInt(7,addUser.getCreateUid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }



    //update pn_admin_user set username = 'bbb',isvalid = 1,head_img = 'xxx',remark = 'bbbb' where uid = 1
    @Override
    public Integer editBackUser(BackUser addUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "update pn_admin_user set username = ?,isvalid = ?,head_img = ?,remark = ? where uid = ?";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setString(1,addUser.getUserName());
            psta.setInt(2,addUser.getIsValid());
            psta.setString(3,addUser.getHeadImg());
            psta.setString(4,addUser.getRemark());
            psta.setInt(5,addUser.getUid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

    @Override
    public Integer delBackUser(BackUser delUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "delete from pn_admin_user where uid = ?";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setInt(1,delUser.getUid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

    @Override
    public Integer editUserAuth(BackUser editUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        conn = JDBCUtil.getConn();
        Integer result = 0;
        String sql = "update pn_admin_user set menu_id = ?where uid = ?";
        System.out.println(sql);
        try {
            psta = conn.prepareStatement(sql);
            psta.setString(1,editUser.getMenuId());
            psta.setInt(2,editUser.getUid());
            result = psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,null);
        }
        return result;
    }

}
