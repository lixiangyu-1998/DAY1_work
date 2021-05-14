package com.javasm.controller;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.*;
import com.javasm.service.BackUserService;
import com.javasm.service.MenuService;
import com.javasm.service.impl.BackUserServiceImpl;
import com.javasm.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class BackUserServlet extends BaseServlet {

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();

        BackUserService bus = new BackUserServiceImpl();
        String uidstr = req.getParameter("uid");
        String uname = req.getParameter("uname");
        Integer uid = null;
        if (uidstr != null && !"".equals(uidstr)) {
            uid = Integer.valueOf(uidstr);
        }
        BackUser queryUser = new BackUser();
        queryUser.setUid(uid);
        queryUser.setUserName(uname);

        String pagestr = req.getParameter("page");
        String pagesizestr = req.getParameter("pagesize");
        Integer page = 1;
        Integer pagesize = 3;
        if (pagestr != null && !"".equals(pagestr)) {
            page = Integer.valueOf(pagestr);
        }
        if (pagesizestr != null && !"".equals(pagesizestr)) {
            pagesize = Integer.valueOf(pagesizestr);
        }

        List<BackUser> lu = bus.queryUsers(page, pagesize, queryUser);
        Integer total = bus.getUsersNum(queryUser);
        PageInfo pif = new PageInfo();
        pif.setPage(page);
        pif.setPagesize(pagesize);
        pif.setTotal(total);

        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        re.setReturnData(lu);
        re.setPageinfo(pif);
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void adduser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();
        BackUserService bus = new BackUserServiceImpl();
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String uid = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String isValid = req.getParameter("isValid");
        String remark = req.getParameter("remark");
        String headImg = req.getParameter("headImg");
        BackUser bu = new BackUser();
        bu.setUid(Integer.parseInt(uid));
        bu.setUserName(userName);
        bu.setIsValid(Integer.parseInt(isValid));
        bu.setRemark(remark);
        bu.setHeadImg(headImg);
        bu.setPassWord("e10adc3949ba59abbe56e057f20f883e");
        bu.setCreateUid(loginUser.getUserId());
        Integer res = bus.addBackUser(bu);
        if (res > 0) {
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        } else {
            re.setReturnCode(ReturnCode.FAILED.getCode());
            re.setReturnMsg(ReturnCode.FAILED.getMsg());
        }
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void edituser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();
        BackUserService bus = new BackUserServiceImpl();
        String uid = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String isValid = req.getParameter("isValid");
        String remark = req.getParameter("remark");
        String headImg = req.getParameter("headImg");
        BackUser bu = new BackUser();
        bu.setUid(Integer.parseInt(uid));
        bu.setUserName(userName);
        bu.setIsValid(Integer.parseInt(isValid));
        bu.setRemark(remark);
        bu.setHeadImg(headImg);
        Integer res = bus.editBackUser(bu);
        if (res > 0) {
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        } else {
            re.setReturnCode(ReturnCode.FAILED.getCode());
            re.setReturnMsg(ReturnCode.FAILED.getMsg());
        }
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void deluser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();
        BackUserService bus = new BackUserServiceImpl();
        String uid = req.getParameter("uid");
        BackUser bu = new BackUser();
        bu.setUid(Integer.parseInt(uid));
        Integer res = bus.delBackUser(bu);
        if (res > 0) {
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        } else {
            re.setReturnCode(ReturnCode.FAILED.getCode());
            re.setReturnMsg(ReturnCode.FAILED.getMsg());
        }
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void getauth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();

        BackUserService bus = new BackUserServiceImpl();
        String uidstr = req.getParameter("uid");
        Integer uid = null;
        if (uidstr != null && !"".equals(uidstr)) {
            uid = Integer.valueOf(uidstr);
        }
        User user = new User();
        user.setUserId(uid);
        List<Menu> allAuth = bus.getAllAuth();
        String currentUserAuth = bus.getCurrentUserAuth(user);
        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        //权限列表数据
        re.setReturnData(allAuth);
        //额外数据
        re.setExtData(currentUserAuth);
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void edituserauth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ReturnEntity re = new ReturnEntity();
        BackUserService bus = new BackUserServiceImpl();
        String uid = req.getParameter("uid");
        String menuId = req.getParameter("menuid");
        BackUser bu = new BackUser();
        bu.setUid(Integer.parseInt(uid));
        bu.setMenuId(menuId);
        Integer res = bus.editUserAuth(bu);
        if (res > 0) {
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        } else {
            re.setReturnCode(ReturnCode.FAILED.getCode());
            re.setReturnMsg(ReturnCode.FAILED.getMsg());
        }
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }


}
