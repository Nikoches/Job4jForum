<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.2021
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <jsp:include page="parts/general.jsp" />
</head>
<body>
<form action = "/rg" method = "POST">
    Username: <input type = "text" name = "username" id="username">
    <br />
    Surname: <input type = "text" name = "surname" id="surname" />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
