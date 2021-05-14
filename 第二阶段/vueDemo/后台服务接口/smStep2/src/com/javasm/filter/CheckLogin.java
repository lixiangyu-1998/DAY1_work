package com.javasm.filter;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebFilter("/*")
public class CheckLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse)servletResponse;
        /* 允许跨域的主机地址 */
        String origin = req.getHeader("Origin");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8088");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        resp.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        resp.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        resp.setHeader("Access-Control-Allow-Headers", "*");
        //resp.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        /* 是否携带cookie */
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println(req);
        HttpSession session = req.getSession();
/*
        String jsessionid = session.getId();
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie ck:cookies){
                if("JSESSIONID".equals(ck.getName())){
                    jsessionid = ck.getValue();
                }
            }
        }

        String header ="JSESSIONID="+jsessionid+"; Path=/; HttpOnly";
        resp.setHeader("Set-Cookie", String.format("%s; %s", header, "SameSite=None; Secure;"));
*/

        System.out.println("来源地址："+origin);

        System.out.println(session.getId());
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println(req.getServletPath());
        //放行特定请求和静态资源
        if(!"/login".equals(req.getServletPath())&&!"/loginOut".equals(req.getServletPath())&&!req.getServletPath().endsWith(".html")&&!req.getServletPath().endsWith(".css")&&!req.getServletPath().endsWith(".js")&&!req.getServletPath().endsWith(".png")&&!req.getServletPath().endsWith(".jpg")&&!req.getServletPath().endsWith(".jpeg")  ){
            if(loginUser!=null){
                filterChain.doFilter(req,resp);
            }else{
                resp.setContentType("text/html;charset=utf-8");
                ReturnEntity re = new ReturnEntity();
                re.setReturnCode(ReturnCode.NOT_LOGIN.getCode());
                re.setReturnMsg(ReturnCode.NOT_LOGIN.getMsg());
                String res = JSON.toJSONString(re);
                PrintWriter pw = resp.getWriter();
                pw.print(res);
                pw.flush();
                pw.close();
            }
        }else{
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
