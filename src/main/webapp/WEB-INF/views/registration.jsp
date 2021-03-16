<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="parts/general.jsp"/>
<html>
<head>
    <title>Регистрация</title>
    <jsp:include page="parts/general.jsp" />
</head>
<body>
<form action = "${pageContext.request.contextPath}/rg" method = "POST">
    Username: <input type = "text" name = "username" id="username">
    <br />
    Surname: <input type = "text" name = "surname" id="surname" />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
