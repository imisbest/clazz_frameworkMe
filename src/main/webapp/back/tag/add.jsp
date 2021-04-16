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
            text-align: center;
        }

        select {
            width: 173px;
        }
    </style>
</head>

<body>

<h1>标签添加</h1>
<hr/>


<form action="${path}/tag/add" method="post" onsubmit="return check()">
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
    标签名称:<input type="text" name="name"/><br/>
    标签类型:
    <select name="tag">
        <option value="班级">班级</option>
        <option value="学生">学生</option>
    </select><br/>
    <input type="submit" value="提交"/>
    <a href="${path}/tag/queryAll"><input type="button" value="返回上一级"> </a>
</form>


</body>
</html>
