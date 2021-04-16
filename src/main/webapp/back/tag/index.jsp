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

<h1>标签管理</h1>
<hr/>

<h4>标签信息展示:</h4>
<hr/>

<c:forEach items="${taglibs}" var="p">
    <ul>
        <li>标签名:${p.name}</li>
        <li>创建时间:${p.dd}</li>
        <li>是否是班级标签:
            <c:if test="${p.tag.equals('班级')}">
                <span>是</span>
            </c:if>
            <c:if test="${!p.tag.equals('班级')}">
                <span>否</span>
            </c:if>
        </li>
    </ul>
    <hr/>
</c:forEach>
<input type="button" value="添加标签" onclick="location.href='${path}/back/tag/add.jsp'"/>
<a href="${path}/back/main/main.jsp"><input type="button" value="返回上一级"> </a>


</body>
</html>
