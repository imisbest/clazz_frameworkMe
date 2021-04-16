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

<body style="text-align: center;">

<h1>用户登陆</h1>

<form action="${path}/user/login" method="post" onsubmit="return check()">
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
    <%----%>
    用户名:<input type="text" name="username"><br/><br/>
    <%----%>
    密&nbsp;&nbsp;码:<input type="text" name="password"><br/><br/>
    <%----%>
    <img src="${path}/captcha/captcha" id="captchaImg"/>
    <div class="label-text">验证码：</div>
    <input type="text" name="captchaCode"><br/>
    <a href="javascript:void(0)"
       onclick="changeCaptcha()">看不清，换一张!~</a>&nbsp;<span
        style="color:red">${errorMsg }</span><br/>
    <script type="text/javascript">
        function changeCaptcha() {
            // 根据ID获取到验证码图片对象
            var captchaImg = document.getElementById('captchaImg');
            captchaImg.src = '${path}/captcha/captcha?'
                + Math.random();
        }
    </script>
    <input type="submit" value="提交">
    <%--
        <input type="button" value="注册"/>--%>
</form>


</body>
</html>
