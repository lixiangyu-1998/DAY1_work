package com.javasm.dao.impl;

import com.javasm.dao.LoginDao;
import com.javasm.entity.User;
import com.javasm.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public User Login(User insertUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        User loginUser =null;
        conn = JDBCUtil.getConn();
        String sql = "select pau.uid,pau.username,pau.`password`,pau.reg_time from pn_admin_user pau where pau.username = ? and pau.`password` = ?";
        try {
            psta = conn.prepareStatement(sql);
            psta.setString(1,insertUser.getUserName());
            psta.setString(2,insertUser.getUserPwd());
            rs = psta.executeQuery();
            while(rs.next()){
                Integer uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String regtime = rs.getString("reg_time");
                loginUser = new User(uid,username,password,regtime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }


        return loginUser;
    }

    @Override
    public String getUserRole(User insertUser) {
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rs = null;
        String roles ="";
        conn = JDBCUtil.getConn();
        String sql = "select pau.menu_id from pn_admin_user pau where pau.uid = ? ";
        try {
            psta = conn.prepareStatement(sql);
            psta.setInt(1,insertUser.getUserId());
            rs = psta.executeQuery();
            while(rs.next()){
                roles = rs.getString("menu_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(conn,psta,null,rs);
        }
        return roles;
    }
}
