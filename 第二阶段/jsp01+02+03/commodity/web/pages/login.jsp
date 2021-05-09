<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/6
  Time: 8:35 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/commodity/static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/commodity/static/css/bootstrap.min.css">
    <script src="/commodity/static/js/bootstrap.min.js"></script>
</head>
<style>
    * {
        margin-left: 10px;
    }

    .input-group {
        width: 300px;
    }

    .btn-group {
        position: relative;
        left: 245px;
    }
</style>
<body>
<%@include file="menu.jsp"%>

<div class="page-header">
    <h1>用户登录界面<small>请输入用户名和密码</small></h1>
</div>
<div class="alert alert-info" role="alert"><%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%></div>
<form action="http://localhost:8080/commodity/loginServlet" method="post">
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Username</span>
        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" name="username"
        value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>">
    </div>

    <div class="input-group">
        <span class="input-group-addon" id="basic-addon2">Password</span>
        <input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon2" name="password">
    </div>
    <div class="btn-group" role="group" aria-label="...">
        <button type="submit" class="btn btn-default">登录</button>
    </div>
</form>

</body>
</html>
