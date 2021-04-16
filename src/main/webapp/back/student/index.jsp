<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>index.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css">
        table {
            border-right: 1px solid black;
            border-bottom: 1px solid black;
        }

        table td {
            width: 200px;
            text-align: center;
            border-left: 1px solid black;
            border-top: 1px solid black;
        }
    </style>
    <script src="${path}/back/statics/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function () {
            //根据上一次搜索key将select中某一个option选中
            $("option[value='${tag}']").attr("selected", "selected");
            //绑定下载事件
            $("#btn").click(function () {
                var key = "${param.tag}";
                var value = "${param.into}";
                location.href = "${path}/student/download2?tag=" + key + "&into=" + value;
            });
        });
    </script>
</head>

<body>

<h1>学生管理</h1>
<hr/>

<div style="margin: 0 auto; width:500px; height:30px">
    <form action="${path}/student/query2"method="post">
    <select name="tag">
        <option value="nameValue">姓名</option>
        <option value="clazzValue">班级</option>
        <option value="taglibValue">标签</option>
    </select>
    <input type="text" placeholder="请输入查询条件" name="into"/>
    <input type="submit" value="搜索"/>
    </form>
</div>
<hr/>
<table border="0" cellspacing="0" cellpadding="0">
    <thead>
    <td>id</td>
    <td>学生姓名</td>
    <td>学生年龄</td>
    <td>出生日期</td>
    <td>手机号</td>
    <td>qq号</td>
    <td>生肖</td>
    <td>星座</td>
    <td>备注</td>
    <td>学生就业城市</td>
    <td>学生班级</td>
    <td>小组</td>
    <td>学生标签</td>
    <td>操作</td>
    </thead>
    <c:forEach items="${infosList}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.age}</td>
            <td><f:formatDate value="${p.bir}" pattern="yyyy/MM/dd"/></td>
            <td>${p.phone}</td>
            <td>${p.qq}</td>
            <td>${p.shengx}</td>
            <td>${p.xingz}</td>
            <td>${p.beiz}</td>
            <td>${p.city.name}</td>
            <td>${p.clazz.name}</td>
            <td>${p.xiaoz.name}</td>
            <td>
                <c:forEach items="${p.taglibs}" var="s">
                    ${s.name}、
                </c:forEach>
            </td>
            <td><a href="${path}/student/detail?id=${p.id}"><input type="button" value="查看详细"></a>
                <a href="${path}/student/delete?id=${p.id}"><input type="button" value="删除"></a><a
                        href="${path}/student/updatefirst?id=${p.id}"><input type="button" value="修改"></a></td>
        </tr>
    </c:forEach>
</table>

<hr/>
<a href="javascript:;" id="btn">导出学生信息</a>
<a href="${path}/student/addfirst">添加学生信息</a>
<a href="${path}/back/main/main.jsp"><input type="button" value="返回上一级"> </a>
</body>
</html>
