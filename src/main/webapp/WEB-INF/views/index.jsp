<%--
  Created by IntelliJ IDEA.
  User: developerjeyhun
  Date: 16.10.23
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/index.css">
</head>
<body>
<div class="page">
    <a href="${pageContext.request.contextPath}/listUsers" class="link">
        <div class="button">User List</div>
    </a>
    <a href="${pageContext.request.contextPath}/addUser" class="link">
        <div class="button">Add User</div>
    </a>
</div>
</body>
</html>
