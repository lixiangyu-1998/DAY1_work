package com.javasm.controller;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.Menu;
import com.javasm.entity.PageInfo;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.service.MenuService;
import com.javasm.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/menu/*")
public class MenuServlet extends BaseServlet {

    public void query(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String dowhat = req.getParameter("dowhat");
        ReturnEntity re = new ReturnEntity();
        MenuService ms = new MenuServiceImpl();
        String qmname = req.getParameter("qmname");
        String qpidstr = req.getParameter("qpid");
        Integer qpid = null;
        if(qpidstr!=null&&!"".equals(qpidstr)){
            qpid = Integer.valueOf(qpidstr);
        }
        Menu queryMenu = new Menu(qmname,qpid);
        String pagestr = req.getParameter("page");
        String pagesizestr = req.getParameter("pagesize");
        Integer page = 1;
        Integer pagesize = 10;
        if(pagestr!=null&&!"".equals(pagestr)){
            page=Integer.valueOf(pagestr);
        }
        if(pagesizestr!=null&&!"".equals(pagesizestr)){
            pagesize=Integer.valueOf(pagesizestr);
        }

        List<Menu> lm = ms.getMenuByPage(page,pagesize,queryMenu);
        Integer total = ms.getMenuNum(queryMenu);
        PageInfo pif = new PageInfo();
        pif.setPage(page);
        pif.setPagesize(pagesize);
        pif.setTotal(total);

        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        re.setReturnData(lm);
        re.setPageinfo(pif);
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void getmenuselect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String dowhat = req.getParameter("dowhat");
        ReturnEntity re = new ReturnEntity();
        MenuService ms = new MenuServiceImpl();
        List<Menu> lm = ms.getMenuSelect();
        re.setReturnCode(ReturnCode.SUCCESS.getCode());
        re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        re.setReturnData(lm);
        String resstr = JSON.toJSONString(re);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(resstr);
        writer.flush();
        writer.close();
    }

    public void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String dowhat = req.getParameter("dowhat");
        ReturnEntity re = new ReturnEntity();
        MenuService ms = new MenuServiceImpl();
        String menuid = req.getParameter("menuid");
        String menuname = req.getParameter("menuname");
        String menuurl = req.getParameter("menuurl");
        String pid = req.getParameter("pid");
        String glyphicon = req.getParameter("glyphicon");

        Menu menu = new Menu(Integer.valueOf(menuid), menuname, menuurl, Integer.valueOf(pid),"", glyphicon);
        Integer res = ms.addMenu(menu);
        if(res>0){
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        }else{
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

    public void edit(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String dowhat = req.getParameter("dowhat");
        ReturnEntity re = new ReturnEntity();
        MenuService ms = new MenuServiceImpl();
        String menuid = req.getParameter("menuid");
        String menuname = req.getParameter("menuname");
        String menuurl = req.getParameter("menuurl");
        String pid = req.getParameter("pid");
        String glyphicon = req.getParameter("glyphicon");

        Menu menu = new Menu(Integer.valueOf(menuid), menuname, menuurl, Integer.valueOf(pid),"", glyphicon);
        Integer res = ms.editMenu(menu);
        if(res>0){
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        }else{
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

    public void remove(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String dowhat = req.getParameter("dowhat");
        ReturnEntity re = new ReturnEntity();
        MenuService ms = new MenuServiceImpl();
        String menuid = req.getParameter("menuid");

        Menu menu = new Menu();
        menu.setMenuid(Integer.valueOf(menuid));
        Integer res = ms.removeMenu(menu);
        if(res>0){
            re.setReturnCode(ReturnCode.SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.SUCCESS.getMsg());
        }else{
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
