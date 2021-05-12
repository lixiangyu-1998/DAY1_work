package com.lixiangyu.pagingQuery.web;

import com.alibaba.fastjson.JSON;
import com.lixiangyu.pagingQuery.bean.PageInfo;
import com.lixiangyu.pagingQuery.bean.ReturnCode;
import com.lixiangyu.pagingQuery.bean.User;
import com.lixiangyu.pagingQuery.service.Impl.PageServiceImpl;
import com.lixiangyu.pagingQuery.service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiangyu
 * @title: PageServlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1110:01 下午
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    private PageService pageService=new PageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得ajax的请求参数
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        System.out.println("pageSize："+pageSize);
        //Integer pageSize=5;
        Integer page = Integer.parseInt(req.getParameter("page"));
        System.out.println("page："+page);
        String name = req.getParameter("name");
        System.out.println(name);
        String address = req.getParameter("address");
        System.out.println(address);
        // 创建查询传参对象
        User user = new User(name, address);
        // 分页查询用户信息
        List<User> userList = pageService.queryLimit(page, pageSize, user);
        // map装载返回值
        Map<String, Object> map = new HashMap<>();
        if (userList.size() == 0) {
            map.put("returnCode", ReturnCode.ERROR.getCode());
            map.put("returnMsg", ReturnCode.ERROR.getMsg());
        } else {
            map.put("returnCode", ReturnCode.SUCCESS.getCode());
            map.put("returnMsg", ReturnCode.SUCCESS.getMsg());
        }
        map.put("returnData", userList);
        // 查询总页数
        Integer total = pageService.queryAllUser(user);
        System.out.println(total);
        PageInfo pageInfo = new PageInfo(page, pageSize, total);
        map.put("PageInfo", pageInfo);
        // 向浏览器响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        // 转换数据类型为json格式
        pw.print(JSON.toJSONString(map));
        System.out.println(map);
        pw.flush();
        pw.close();
    }
}
