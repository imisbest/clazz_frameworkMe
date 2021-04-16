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

<h1>小组管理</h1>
<hr/>


<h4>小组展示:</h4>
<hr/>
<form action="${path}/group/add" method="post" onsubmit="return check()">
    <script type="text/javascript">
        function check() {
            var nn = document.getElementsByClassName('inputgri');
            for (var i = 0; i < nn.length; i++) {
                if (!nn[i].value) {
                    alert("有空值，请检查之后在重新提交");
                    return false;
                }
            }
            /* var b = window.confirm("请确认提交是否提交表单");
             if (b) {*/
            return true;
            /*  } else {
                  return false;
              }*/
        }
    </script>
    <c:forEach items="${xiaozList}" var="p">
        <ul>
            <li>小组id:${p.id}</li>
            <li>小组名称:${p.name}</li>
            <li>创建时间:${p.dd}</li>
            <li>所属班级:${p.clazz.name}</li>
            <li>目前标签:${p.clazz.tag}</li>
        </ul>
    </c:forEach>
    <hr/>
</form>
<a href="${path}/group/addfirst2"><input type="button" value="添加小组"/></a>
<a href="${path}/back/main/main.jsp"><input type="button" value="返回上一级"> </a>
</body>
</html>
