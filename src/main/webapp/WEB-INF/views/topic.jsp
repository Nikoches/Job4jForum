<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${topic}</title>
    <jsp:include page="parts/general.jsp" />
</head>
<body>
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
            <td><c:out value="${message.author.username}"/> <td><c:out value="${message.message}"/></td>  <td><c:out value="${message.date}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
