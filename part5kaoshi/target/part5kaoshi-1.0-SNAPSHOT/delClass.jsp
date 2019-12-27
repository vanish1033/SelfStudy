<%--
  Created by IntelliJ IDEA.
  User: vanish
  Date: 2019/9/26
  Time: 14:58
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
<center>
    <form action="class/delClass">
        请输入要删除哪个班级编号：<input type="text" name="classId">
        <input type="submit">
    </form>
</center>
</body>
</html>
