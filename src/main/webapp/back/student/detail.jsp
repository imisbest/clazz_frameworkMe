<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        body {
            /* text-align: center; */
        }

        select {
            width: 173px;
        }
    </style>
</head>

<body>

<h1>学生详细信息展示</h1>
<hr/>

<ul>
    <li>学生姓名:${infos.name}</li>
    <li>学生年龄:${infos.age}</li>
    <li>学生班级:${infos.clazz.name}</li>
    <li>学生小组:${infos.xiaoz.name}</li>
    <li>学生就业城市:${infos.city.name}</li>
    <li>学生标签:
        <c:forEach items="${infos.taglibs}" var="p">
            ${p.name}
        </c:forEach></li>
</ul>
<hr/>
<a href="${path}/student/queryAll"><input type="button" value="返回上一级"> </a>
</body>
</html>
