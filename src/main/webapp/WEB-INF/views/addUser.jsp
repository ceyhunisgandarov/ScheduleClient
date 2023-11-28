<%--
  Created by IntelliJ IDEA.
  User: developerjeyhun
  Date: 16.10.23
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/form.css">
</head>
<body>
    <div class="page">
        <div class="form">
            <h1>ADD CUSTOMER</h1>
            <form action="${pageContext.request.contextPath}/saveUser" method="post">
                <div class="form-row">
                    <label class="label">NAME</label> </br>
                    <input class="input" type="text" name="name"/>
                </div>
                <div class="form-row">
                    <label class="label">SURNAME</label> </br>
                    <input class="input" type="text" name="surname"/>
                </div>
                <div class="form-row">
                    <label class="label">EMAIL</label> </br>
                    <input class="input" type="email" name="email"/>
                </div>
                <div class="form-row">
                    <label class="label">PASSWORD</label> </br>
                    <input class="input" type="password" name="password"/>
                </div>
                <input class="input_button" type="submit"  value="ADD USER"/>
                <c:if test="${not empty msg}">
                    </br><span style="color: red; font-size: 16px; margin-top: 10px">${msg}</span>
                </c:if>
            </form>
        </div>
        <a href="${pageContext.request.contextPath}/" class="link">
            <div class="button">BACK</div>
        </a>
    </div>
</body>
</html>
