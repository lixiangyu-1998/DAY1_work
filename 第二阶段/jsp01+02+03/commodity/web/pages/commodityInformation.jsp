<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/7
  Time: 7:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="isLogin.jsp"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/commodity/static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/commodity/static/css/bootstrap.min.css">
    <script src="/commodity/static/js/bootstrap.min.js"></script>
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
</head>
<body>
<%@include file="isLogin.jsp" %>
<%@include file="menu.jsp" %>

<div class="page-header">
    <h1>商品信息页面<small>请挑选商品</small></h1>
</div>
<form action="http://localhost:8080/commodity/orderServlet" method="get">


<table class="table table-hover">
    <tr>
        <th>
            商品序号
        </th>
        <th>
            商品名
        </th>
        <th>
            单价
        </th>
        <th>
            商品图片
        </th>
        <th>
            商品介绍
        </th>
        <th>
            购买数量
        </th>
        <th>
            小记
        </th>
    </tr>
    <% int i = 0;
        int j = 0;
        int k = 0;
    %>
    <c:forEach items="${requestScope.commodities}" var="commodities">
        <% i++;
            j++;
            k++;
        %>
        <tr>
            <td>
                    ${commodities.pid}
                        <input type="hidden" name='<%="pid"+i %>' value=${commodities.pid}>
            </td>
            <td>
                    ${commodities.pname}
            </td>
            <td>
                    ${commodities.price}
            </td>
            <td>
                <img src=${commodities.pimg} width="51" height="38"/>
            </td>
            <td>
                    ${commodities.pdesc}
            </td>
            <td>
                <button type="button" class="btn btn-default" disabled="disabled" id='<%="add"+i %>'>-</button>
                <span id='<%="num"+k %>'>0&nbsp;</span>
                <button type="button" class="btn btn-default" id='<%="reduce"+j %>'>+</button>
                <input type="hidden" name='<%="num"+i %>' value="0">
            </td>
            <td>
                <span>0&nbsp;</span>元

            </td>
        </tr>

    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>总计</td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <input type="hidden" name="sum" id="sum">
        </td>
        <td>
            <span id="total">0&nbsp;</span>元
        </td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>        <button type="submit" class="btn btn-default">结账</button>
        </td>
    </tr>
</table>

</form>
<script>
    // $("#btn1").click(function (){
    //     console.log("123")
    //     alert("111")
    // })
    <%--    <% i=0;--%>
    <%--                        j=0;--%>
    <%--                        k=0;--%>
    <%--                    %>--%>
    var pid01=${requestScope.pid}
    console.log(pid01)
    var n = 0;
    var total=0;
    var total = parseFloat(total);
    for (var a = 0; a <${requestScope.pid}; a++) {
        <%--        <% i++;--%>
        <%--                    j++;--%>
        <%--                    k++;--%>
        <%--                %>--%>
        <%--        var number = 0;--%>
        <%--        $("#'<%="add"+i %>'").click(function () {--%>
        <%--            number--;--%>
        <%--            $("#'<%="num"+k %>'").text(5);--%>
        <%--        })--%>
        <%--        $("#'<%="reduce"+j %>'").click(function () {--%>
        <%--            number--;--%>
        <%--            $("#'<%="num"+k %>'").text(5);--%>
        <%--        })--%>
        n++;

        $("tr:eq(" + n + ")>td:eq(5)>button:eq(0)").click(function () {
            //点击减少按钮 数量减少
            var text = $(this).next('span').text();
            // var text = this.next().text();
            text--;
            $(this).next('span').text(text);
            //隐藏域
            $(this).next('span').next('button').next('input').val(text);
            // this.next().text(text);
            //相应的钱要减少
            var priceReduce1 = $(this).parent().next('td').children('span').text();
            priceReduce1 -= $(this).parent().prev('td').prev('td').prev('td').text();
            console.log(priceReduce1)
            $(this).parent().next('td').children('span').text(priceReduce1);

            //对总金额操作
            var text3 = $("#total").text();
            text3-=$(this).parent().prev('td').prev('td').prev('td').text();
            $("#total").text(text3);
            //隐藏域
            $("#sum").val(text3);

            //数量是0就 禁止使用 减少数量按钮
            if (text === 0) {
                $(this).attr("disabled", true)
            }

        })
        $("tr:eq(" + n + ")>td:eq(5)>button:eq(1)").click(function () {
            //点击增加按钮数量增加
            var text1 = $(this).prev('span').text();
            text1++;
            $(this).prev('span').text(text1);
            //隐藏域
            $(this).next('input').val(text1);
            //相应的钱也增加

            //+法自动拼接字符串 要强制转换 找到问题出现在这里 花了我2小时。。。
            var priceReduce2 = $(this).parent().next('td').children('span').text();

            var text2 = $(this).parent().prev('td').prev('td').prev('td').text();
            var text2 = parseFloat(text2);
            var priceReduce2 = parseFloat(priceReduce2);
             priceReduce2 += text2;
            console.log(text2)
            $(this).parent().next('td').children('span').text(priceReduce2);

            //对总金额操作
            var text4 = $("#total").text();
            var text4 = parseFloat(text4);
            text4+=text2;
                $("#total").text(text4);
            //隐藏域
            $("#sum").val(text4)

            //数量不是0就 解除 减少数量 按钮的禁用
            if (text1 !== 0) {
                $(this).prev().prev().attr("disabled", false)
            }
        })

    }
</script>

</body>
</html>
