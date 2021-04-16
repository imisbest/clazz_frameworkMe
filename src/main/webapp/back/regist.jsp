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
    <style>
        body {
            text-align: center
        }

        #dd {
            margin: 0 auto;
            border: 1px solid #fff;
            width: 340px;
            height: 600px
        }
    </style>
</head>

<body>

<h1>用户注册</h1>

<div id="dd">
    <form action="" method="post" onsubmit="return check()">
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
        <div style="margin-top:70px;">
            <div style="float: left; width:100px;">
                选择头像:
            </div>
            <div style="float: left; width:120px;">
                <input type="file" name=""/>
            </div>
        </div>
        <br/>
        <div style="margin-top:15px;">
            <div style="float: left; width:100px;">
                用户名:
            </div>
            <div style="float: left; width:120px;">
                <input type="text" name=""/>
            </div>
        </div>
        <br/>
        <div style="margin-top:15px;">
            <div style="float: left; width:100px;">
                密&nbsp;&nbsp;码:
            </div>
            <div style="float: left;width:120px;">
                <input type="text" name=""/>
            </div>
        </div>
        <br/>
        <div style="margin-top:15px;">
            <div style="float: left; width:100px;">
                手机号:
            </div>
            <div style="float: left;width:120px;">
                <input type="text" name=""/>
            </div>
        </div>
        <br/>
        <div style="margin-top:30px;">
            <div style="float: left; width:400px;">
                <input type="submit" value="提交"/>&nbsp;&nbsp;
                <input type="reset" value="重置"/>&nbsp;&nbsp;
                <input type="button" value="登陆"/>&nbsp;&nbsp;
            </div>
        </div>
        <br/>
    </form>
</div>

</body>
</html>
