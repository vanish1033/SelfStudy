<%--
  Created by IntelliJ IDEA.
  User: vanish
  Date: 2019/9/26
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/"/>
    <script type="text/javascript">

    </script>
</head>
<body>
<form action="stu/add">
    学生姓名：<input type="text" name="name"/><br>
    学生年龄：<input type="text" name="age"/><br>
    学生email<input type="text" name="email"/><br>
    学生班级编号<input type="text" name="classId"/><br>
    <input type="submit">
</form>
</body>
</html>
