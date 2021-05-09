<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/8
  Time: 2:56 下午
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
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">请选择想进入的页面</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/commodity/pages/login.jsp">登录</a></li>
                <li><a href="/commodity/pages/regist.jsp">注册</a></li>
                <%--                a标签是get请求--%>
                <li ><a href="/commodity/commodityServlet">商品信息页面 <span class="sr-only">(current)</span></a>
                </li>
                <li><a href="/commodity/orderCheckServlet">订单查询</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
