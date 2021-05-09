<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/8
  Time: 8:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="isLogin.jsp" %>
<%@include file="menu.jsp"%>
<div class="page-header">
    <h1>订单信息页面<small>请点击订单编号查看详细信息</small></h1>
</div>
<table class="table table-hover" >
    <tr>
        <th>订单编号</th>
        <th>用户编号</th>
        <th>总价</th>
        <th>下单时间</th>
    </tr>
    <c:forEach items="${requestScope.orders}" var="orders" >
        <tr>
            <td><a href="/commodity/orderInfoCheck?action=${orders.oid}">${orders.oid}</a></td>
            <td>${orders.uid}</td>
            <td>${orders.sum}</td>
            <td>${orders.odate}</td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
