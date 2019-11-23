<%--
  Created by IntelliJ IDEA.
  User: vanish
  Date: 2019/9/26
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/"/>
    <script type="text/javascript" src="js/jquery-1.11.1-min.js"></script>
    <script type="text/javascript">
        $(function showAllStu() {
            $.ajax({
                url: "stu/showAllStu",
                type: "get",
                dataType: "json",
                success: function (data) {
                    var html = "";
                    $.each(data, function (i, n) {
                        html += '<tr>';
                        html += '    <td>' + n.id + '</td>';
                        html += '    <td>' + n.name + '</td>';
                        html += '    <td>' + n.age + '</td>';
                        html += '    <td>' + n.email + '</td>';
                        html += '    <td>' + n.classId + '</td>';
                        html += '    </tr>';
                    });
                    $("#stuTable").append(html);
                }
            });
        });
    </script>
</head>
<body>
<center>
    <table border="1" id="stuTable">
        <tr>
            <td>学号</td>
            <td>学生姓名</td>
            <td>学生年龄</td>
            <td>学生email</td>
            <td>学生班级</td>
        </tr>
    </table>
</center>
</body>
</html>
