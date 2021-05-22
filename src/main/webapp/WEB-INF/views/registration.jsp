<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="parts/general.jsp"/>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action = "${pageContext.request.contextPath}/rg" method = "POST">

</form>
<form action = "${pageContext.request.contextPath}/rg" method = "POST">
<div class="form-row" style="width: 500px"  >
    <div class="col">
        <label for="username">Username: </label>
        <input type="text" class="form-control" placeholder="Username" name = "username" id="username">
    </div>
    <div class="col">
        <label for="password">password: </label>
        <input type="password" class="form-control" placeholder="password" name = "password" id="password">
    </div>
</div>
    <br>
    <div>
        <button type="submit" value = "Submit" class="btn btn-primary">Регистрация </button>
    </div>
</form>
</body>
</html>
