<%--
  Created by IntelliJ IDEA.
  User: developerjeyhun
  Date: 17.10.23
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm User Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/index.css">
</head>
<body>
<div class="page">
    <form action="${pageContext.request.contextPath}/confirmUser" method="post">
        <input hidden name="token" value="${token}"/>
        <input class="button" type="submit" value="Verification Email" />
    </form>
</div>
</body>
</html>
