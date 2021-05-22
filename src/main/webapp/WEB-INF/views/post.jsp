<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="parts/general.jsp"/>
<html>
<head>
    <title>${post}</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">${post}</th>
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

<form action=${pageContext.request.contextPath}/createMessage" style="width: 500px">
    <input type="text" name="Message_body" class="form-control" >
    <input type="hidden" value=${post} id="Post_id" name="post_id">
    <br>
    <button type="submit" name="button" class="btn btn-success" id="savePost">Сохранить</button>
</form>
</body>
</html>
