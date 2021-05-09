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
    <title>注册页面</title>
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

    #btn001 {
        position: relative;
        left: 245px;
    }

</style>
<body>
<%@include file="menu.jsp"%>

<div class="page-header">
    <h1>用户注册界面<small>请填入相关信息</small></h1>
</div>
<div class="alert alert-info" role="alert"><%=request.getAttribute("msg")==null?"请填入相关信息":request.getAttribute("msg")%></div>
<form action="http://localhost:8080/commodity/registServlet" method="post">
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Username</span>
        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" name="username">
    </div>

    <div class="input-group">
        <span class="input-group-addon" id="basic-addon2">Password</span>
        <input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon2" name="password">
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon3">RepeatPassword</span>
        <input type="text" class="form-control" placeholder="RepeatPassword" aria-describedby="basic-addon2" name="repeatPassword">
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon4">Truename</span>
        <input type="text" class="form-control" placeholder="Truename" aria-describedby="basic-addon1" name="truename">
    </div>
    <div class="btn-group" data-toggle="buttons" id="div002">
        <label class="btn btn-default active">
            <input type="radio" name="options" value="false" id="option1" checked> Gender
        </label>
        <label class="btn btn-default">
            <input type="radio" name="options" value="male" id="option2"> Male
        </label>
        <label class="btn btn-default">
            <input type="radio" name="options" value="female" id="option3"> Female
        </label>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon5">Age</span>
        <input type="text" class="form-control" placeholder="Age" aria-describedby="basic-addon2" name="age">
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon6">Email</span>
        <input type="text" class="form-control" placeholder="Email" aria-describedby="basic-addon2" name="email">
    </div>


    <br/>
    <div class="btn-group" role="group" aria-label="...">
        <button type="submit" class="btn btn-default" id="btn001">注册</button>
    </div>
</form>



</body>
</html>
