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
        body {
            text-align: center;
        }

        select {
            width: 173px;
        }
    </style>
    <script type="text/javascript" src="/back/statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 初始化省
            $.get('/student/findName', function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    $('#province')
                        .append($('<option value="' + data[i].id + '">' + data[i].name + '</option>'));
                }
                // 手动触发change事件
                $('#province').change();
            }, 'json');

            // 初始化市
            $('#province').change(function () {
                // 清空历史记录
                $('#city').empty();
                $.get('/student/findCity', 'parentId=' + $(this).val(), function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $('#city')
                            .append($('<option value="' + data[i].id + '">' + data[i].name + '</option>'));
                    }
                    // 手动触发city的change事件
                    $('#city').change();
                }, 'json');
            });
            /*// 初始化县
             $('#city').change(function () {
             // 清空历史记录
             $('#country').empty();
             $.get('/p/findCity', 'parentId=' + $(this).val(), function (data) {
             for (var i = 0; i < data.length; i++) {
             $('#country')
             .append($('<option value="' + data[i].id + '">' + data[i].name + '</option>'));
             }
             }, 'json');
             });*/
        });
    </script>
</head>

<body>

<h1>学生信息修改</h1>
<hr/>


<form action="${path}/student/update" method="post" onsubmit="return check()">
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
    <input type="text" name="id" value="${infos.id}" hidden="hidden"><br>
    学生名称:<input type="text" name="name" value="${infos.name}"/><br/>
    学生年龄:<input type="text" name="age" value="${infos.age}"/><br/>
    学生生日:<input type="text" name="bir" value="<f:formatDate value="${infos.bir}" pattern="yyyy/MM/dd"/>"/><br/>
    学生手机:<input type="text" name="phone" value="${infos.phone}"/><br/>
    学生QQ:<input type="text" name="qq" value="${infos.qq}"><br/>
    班级:<select id="province" name="cid"></select><br/>
    小组:<select id="city" name="xid"></select><br/>
    学生就业城市:
    <select name="tid">
        <c:forEach items="${cityList}" var="p">
            <c:if test="${((p.name).equals(infos.city.name))}">
                <option value="${p.id}" selected="selected">${p.name}</option>
            </c:if>
            <c:if test="${!((p.name).equals(infos.city.name))}">
                <option value="${p.id}">${p.name}</option>
            </c:if>
        </c:forEach>
    </select><br/>
    学生标签:
    <c:forEach items="${taglibList}" var="p" varStatus="s">
        <c:if test="${(p.id)==(infos.taglibs[s.count-1].id)}">
            <input type="checkbox" name="stringList" value="${p.id}" checked="checked">${p.name}
        </c:if>
        <c:if test="${!((p.id)==(infos.taglibs[s.count-1].id))}">
            <input type="checkbox" name="stringList" value="${p.id}" checked="checked">${p.name}
        </c:if>
    </c:forEach>
    <br/>
    学生备注:
    <textarea name="beiz">${infos.beiz}</textarea><br/><br/>
    <input type="submit" value="提交"/>
</form>
<a href="${path}/student/queryAll"><input type="button" value="返回上一级"> </a>

</body>
</html>
