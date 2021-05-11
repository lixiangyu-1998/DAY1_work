<%--
  Created by IntelliJ IDEA.
  User: lixiangyu
  Date: 2021/5/10
  Time: 8:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市县三级联动</title>
    <script src="/ajax/static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/ajax/static/css/bootstrap.min.css">
    <script src="/ajax/static/js/bootstrap.min.js"></script>
</head>
<script>
    $(function (){
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/ajax/provinceServlet",
            dataType:"json",
            success:function (data){
                console.log(data)
                var $province = $("#province");
                console.log("true")
                for (var i=0;i<data.length;i++){
                    // var ob="<option value='"+data[i].provinceCode+"'>"+data[i].provinceNmae+"</option>";
                    // $province.append(ob);
                     $("<option value='"+data[i].prov_code+"'>"+data[i].prov_name+"</option>").appendTo($province);
                }
            }
        })
        $("#province").change(function (){
            //省一变 市 县 框内容全删
            $("#city option").remove();
            $("#country option").remove();
            $.ajax({
                type:"get",
                url: "http://localhost:8080/ajax/cityServlet?prov_code="+$("#province").val(),
                dataType: "json",
                success:function (data){
                    var $city = $("#city");
                    var $country = $("#country");
                    // 然后市 县 加个选择标识 给用户看
                    $("<option value='0'>---请选择市---</option>").appendTo($city);
                    $("<option value='0'>---请选择县---</option>").appendTo($country);
                    for (var i=0;i<data.length;i++){
                        $("<option value='"+data[i].city_code+"'>"+data[i].city_name+"</option>").appendTo($city);
                    }
                }
            })
        })

        $("#city").change(function (){
            //市变 县删
            $("#country option").remove();
            $.ajax({
                type:"get",
                url: "http://localhost:8080/ajax/countryServlet?city_code="+$("#city").val(),
                dataType: "json",
                success:function (data){
                    var $country = $("#country");
                    $("<option value='0'>---请选择县---</option>").appendTo($country);
                    for (var i=0;i<data.length;i++){
                        $("<option value='"+data[i].coun_code+"'>"+data[i].coun_name+"</option>").appendTo($country);
                    }
                }
            })
        })


    })
</script>
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
<div class="page-header">
    <h1>地址选择界面<small>请选择具体的地址</small></h1>
</div>
<select  name="province" id="province">
    <option value="0">---请选择省---</option>
</select>省
<select  name="city" id="city">
    <option value="0">---请选择市---</option>
</select>市
<select  name="country" id="country">
    <option value="0">---请选择县---</option>
</select>县

</body>
</html>
