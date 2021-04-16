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
</head>

<body>

<h1>班级管理</h1>
<hr/>


<h4>班级信息展示:</h4>
<hr/>
<c:forEach items="${clazzList}" var="p">
    <ul>
        <li>班级名称:${p.name}</li>
        <li>班级标签:${p.tag}</li>
    </ul>
    <hr/>
</c:forEach>


<input type="button" value="添加班级" onclick="location.href='${path}/clazz/addfirst'"/>
<a href="${path}/back/main/main.jsp"><input type="button" value="返回上一级"> </a>

</body>
</html>
