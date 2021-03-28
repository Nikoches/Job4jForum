<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="parts/general.jsp"/>
<html>
<head>
    <title>${topic}</title>
    <a href='<c:url value="/index"/>'><c:url value="Вернутся на главную" /></a>
</head>
<body>
<a href='<c:url value="/create"/>'><c:url value="Добавить сообщение" /></a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">${topic}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${messages}" var="message">
        <tr><td>Автор</td><td>Сообщение</td><td>Дата</td></tr>
        <tr>
            <td><c:out value="${message.author.username}"/></td>
            <td><c:out value="${message.message}"/></td>
            <td><c:out value="${message.date}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
