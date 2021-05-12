<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/11
  Time: 8:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/ajaxPagingQuery/static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/ajaxPagingQuery/static/css/bootstrap.min.css">
    <script src="/ajaxPagingQuery/static/js/bootstrap.min.js"></script>
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
<script>
    $(function (){

        var page;
        var totalPage;
        var addPage;
        var reducePage;
        console.log(1);
        showTb({"page":1,"pageSize":5});
        console.log(2);
        //下一页
        $("#nextPage").click(function (){
            showTb({
                "page":addPage,
                "pageSize":5,
                "name":$("#name").val(),
                "address":$("#address").val()

            });
        });
        //上一页
        $("#prevPage").click(function (){
            showTb({
                "page":reducePage,
                "pageSize":5,
                "name":$("#name").val(),
                "address":$("#address").val()

            });
        });
        //带参数查询
        $("#queryBtn").click(function (){
            showTb({
                "page":1,
                "pageSize":5,
                "name":$("#name").val(),
                "address":$("#address").val()

            });
        })
        function showTb(param){
            console.log(true);
            $.post("http://localhost:8080/ajaxPagingQuery/pageServlet",param,function (data){
                console.log("yes");
                if (data.returnCode==200){
                    console.log(true);
                    $("#showTable").html("");
                    $.each(data.returnData,function ( i,d){
                        $("#showTable").append("<tr>" +
                            "            <td>" + d.name + "</td>" +
                            "            <td>" + d.sex + "</td>" +
                            "            <td>" + d.age + "</td>" +
                            "            <td>" + d.address + "</td>" +
                            "        </tr>")
                    })

                }else if (data.returnCode==400){
                    $("#showTable").html("没有结果")
                }
                //第几页
                page = data.PageInfo.page;
                console.log(page);
                //每页几个
                pageSize = data.PageInfo.pageSize;
                console.log(pageSize)
                //总共多少页
                totalPage = data.PageInfo.totalPage;
                console.log(totalPage)
                $("#pageNum").html(page);
                $("#totalPage").html(totalPage);
                addPage=page+1;
                reducePage=page-1;
                initBtn();

            },"json")
        }

        //设置按钮状态
        function initBtn(){
            $("#prevPage").attr("disabled",false);
            $("#nextPage").attr("disabled",false);
            console.log("page"+page);
            console.log("totalPage"+totalPage);
            if (page<=1){
                $("#prevPage").attr("disabled",true);

            }else if (page>=totalPage){
                $("#nextPage").prop("disabled",true);
            }
        }


    })
</script>
<body>

<div class="container">
    <div class="page-header">
        <h1>用户信息界面<small>可查询特定用户信息</small></h1>
    </div>
    <%--搜索框--%>
    <form class="form-inline">
        <div class="form-group">
            <label for="name">用户姓名</label>
            <input type="text" class="form-control" id="name" placeholder="请输入用户姓名">
        </div>
        <div class="form-group">
            <label for="address">用户住址</label>
            <input type="text" class="form-control" id="address" placeholder="请输入用户住址">
        </div>
        <button type="button" class="btn btn-success" id="queryBtn">搜索</button>
    </form>
    <%--表格--%>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>姓名</th>
            <th>姓别</th>
            <th>年龄</th>
            <th>住址</th>
        </tr>
        </thead>
        <tbody id="showTable"></tbody>
    </table>
    <%--分页标签--%>
    <div>
        <div class="col-lg-9">
            <input type="button" class="btn btn-default" id="prevPage" value="上一页"/>
            <span id="page" ></span>
            <input type="button" class="btn btn-default" id="nextPage" value="下一页"/>
            当前第<span id="pageNum"></span>页，共<span id="totalPage"></span>页
        </div>
    </div>
</div>

</body>
</html>
