<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanish
  Date: 2019/9/24
  Time: 20:07
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
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>gender</td>
            <td>age</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
