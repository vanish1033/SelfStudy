<%--
  Created by IntelliJ IDEA.
  User: vanish
  Date: 2019/9/25
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/"/>
    <script type="text/javascript" src="js/jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript">
        function fun4() {
            $.ajax({
                url: "test10",
                data: '{"name":"mike","age":12,"gender":"男","id":4}',
                contentType: "application/json;charset=utf-8",
                type: "post",
                dataType: "json",
                success: function (data) {
                    alert(data);
                }
            });
        }

        function fun3() {
            $.ajax({
                url: "test9",
                data: "<user>" +
                    "<name>张飞</name>" +
                    "<id>3</id>" +
                    "<gender>男</gender>" +
                    "<age>46</age>" +
                    "</user>",
                contentType: "application/xml;charset=utf-8",
                type: "post",
                dataType: "json",
                success: function (data) {
                    alert(data);
                }
            });
        }

        function fun1() {
            var val = $("#bookId").val();
            window.location.href = "" + val + "";
        }

        function fun2(mes) {
            alert(mes);
        }
    </script>
</head>
<body>
<center>

    bookId:<input type="text" id="bookId"/>
    <input type="button" value="fun1" onclick="fun1()"/>

    <input type="button" value="fun2" onclick="fun2(${key})">


    <br/>
    <form action="bookId/a/java" method="post">
        <input type="text" name="_method" value="put" hidden/>
        <input type="submit" value="put提交">
    </form>
    <br/>
    <form action="test8/delete" method="post">
        <input type="text" name="_method" value="delete" hidden/>
        <input type="submit" value="delete提交">
    </form>

    <br>

    <input type="button" onclick="fun3()" value="测试requestBody注解接收xml数据"/><br><br>
    <input type="button" onclick="fun4()" value="测试requestBody注解接收json数据"/>
</center>
</body>
</html>
