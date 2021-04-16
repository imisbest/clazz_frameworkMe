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

<h1>就业城市管理</h1>
<hr/>

<h4>城市信息展示:</h4>
<hr/>
<c:forEach items="${cities}" var="p" varStatus="loop">
    <ul>
        <li>城市名:${p.name}</li>
            <%--<li>城市名:${cities[loop.count-1].name}</li>
            <li>城市名:${cities1[loop.count-1].name}</li>
            <li>城市名:${cities2[loop.count-1].name}</li>
            <li>城市名:${cities3[loop.count-1].name}</li>
            <li>城市名:${cities4[loop.count-1].name}</li>--%>
        <li>创建时间:${p.dd}</li>
    </ul>
    <hr/>
</c:forEach>


<input type="button" value="添加城市" onclick="location.href='${path}/back/city/add.jsp'"/>
<a href="${path}/back/main/main.jsp"><input type="button" value="返回上一级"> </a>

</body>
</html>
