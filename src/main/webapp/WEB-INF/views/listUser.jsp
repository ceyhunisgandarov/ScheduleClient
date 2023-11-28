<%--
  Created by IntelliJ IDEA.
  User: developerjeyhun
  Date: 16.10.23
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Users</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/table.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            setInterval(function() {
                $("#table").load(window.location.href + " #table");
            }, 3000);
        });
    </script>
</head>
<body>
<div class="page">
    <div id="table">
        <table id="customers">
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>GMAIL</th>
                <th>STATUS</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name} ${user.surname}</td>
                    <td>${user.email}</td>
                    <c:if test="${user.active == 1}">
                        <td>ACTIVE</td>
                    </c:if>
                    <c:if test="${user.active == 2}">
                        <td>PENDING</td>
                    </c:if>
                    <c:if test="${user.active == 3}">
                        <td>SENDING SMS</td>
                    </c:if>
                    <c:if test="${user.active == 4}">
                        <td>CONFIRMED</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="${pageContext.request.contextPath}/" class="link">
        <div class="button">BACK</div>
    </a>
</div>
</body>
</html>
