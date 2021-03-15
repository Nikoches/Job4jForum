<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="parts/general.jsp" />
    <title>Форум job4j</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>Форум job4j</h4>
    </div>
    <br/>
    <p>Login:
        <c:if test="${sessionScope.username == null}">
            Anonimus
        </c:if>
        <c:if test="${sessionScope.username != null}">
            ${sessionScope.username}
        </c:if>

        <%= session.getAttribute("username") %></p>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">  </th>
                <th scope="col">Описание</th>
                <th scope="col">Создано</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td><c:out value="${post.name}"/></td>
                    <td>  <a href='<c:url value="/topic?topic=${post.id}"/>'><c:url value="Перейти в пост" /></a></td>
                    <td><c:out value="${post.desc}"/></td>
                    <td><c:out value="${post.created}"/></td>
                    <td>  <a href='<c:url value="/edit?topic=${post.id}"/>'><c:url value="Редактировать пост" /></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <table class="table2">
        <thead>
        <tr>
            <th scope="col">Users</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.username}"/> <td><c:out value="${user.surname}"/></td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>