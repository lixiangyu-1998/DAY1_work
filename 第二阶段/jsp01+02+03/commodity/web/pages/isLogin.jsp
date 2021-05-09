<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/7
  Time: 7:47 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--如果没有session对象 或者是刚创建出来的session 对象 那么跳转回登录页面--%>

<c:if test="${empty sessionScope.get('User')}">
    <% System.out.println("无登录信息"); %>
    <c:redirect url="/pages/login.jsp"/>
<%--    //等等再全用JSTl 重构吧--%>
<%--    <c:url value="login.jsp">--%>
<%--        <c:param name="msg" value="请先登录 "/>--%>
<%--    </c:url>--%>

</c:if>

<%--<%--%>
<%--    if (session.getAttribute("User") == null || session.isNew()) {--%>

<%--&lt;%&ndash;<jsp:forward page="login.jsp"> </jsp:forward>&ndash;%&gt;--%>

<%--    } %>--%>
</body>
</html>
