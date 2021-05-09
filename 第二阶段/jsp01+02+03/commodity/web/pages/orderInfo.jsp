<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/9
  Time: 6:06 下午
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
    <h1>订单详情页面<small></small></h1>
</div>
<table class="table table-hover" >
    <tr>
        <th>订单详情编号</th>
        <th>订单编号</th>
        <th>商品编号</th>
        <th>购买数量</th>
    </tr>
    <c:forEach items="${requestScope.orderInfos}" var="orderInfos" >
        <tr>
            <td>${orderInfos.opid}</td>
            <td>${orderInfos.oid}</td>
            <td>${orderInfos.pid}</td>
            <td>${orderInfos.num}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
