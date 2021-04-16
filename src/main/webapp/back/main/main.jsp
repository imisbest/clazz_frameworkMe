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

<h1>系统主菜单</h1>
<hr/>

<ul>
    <%----%>
    <c:if test="${user.username.equals('admin')}">
        <li><a href="${path}/city/queryAll">就业城市管理</a></li>
        <li><a href="${path}/tag/queryAll">标签管理</a></li>
        <li><a href="${path}/clazz/queryAll">班级管理</a></li>
        <li><a href="${path}/group/queryAll">小组管理</a></li>
        <li><a href="${path}/student/queryAll">学生管理</a></li>


    </c:if>
    <%----%>
    <c:if test="${!user.username.equals('admin')}">
        <li><a href="${path}/student/queryAll">学生管理</a></li>
    </c:if>

</ul>

</body>
</html>
