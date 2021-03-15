<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Редактирование</title>
    <jsp:include page="parts/general.jsp" />
    <a href='<c:url value="/index"/>'><c:url value="Вернутся на главную" /></a>
</head>
<body>
<div class="alert alert-warning"  id="alert" style="${alert};">
    <strong>Warning!</strong> Пост не найден. <a href="/index" class="alert-link">Вернутся на главную</a>.
</div>



<div class="container">
    <div class="row justify-content-center mb-5 mt-5">
        <div class="col-md-6 col-md-offset-3 text-center">
            <h2>Редактирование ${post.name}</h2>
            <h5>${post.id}</h5>
            <form id="edit_post" method="post" action="${pageContext.request.contextPath}/edit">
                <label for="post_name">Название поста:</label>
                <input type="text" name="post_name" class="form-control" placeholder="${post.name}" id="post_name"><br>
                <label for="post_desc">Описание поста:</label>
                <input type="text" name="post_desc" class="form-control" placeholder="${post.desc}" id="post_desc"><br>
                <label for="post_date">Дата поста:</label>
                <input type="date" name="post_date" class="form-control" placeholder="${post.created}" id="post_date"><br>
                <input type="hidden" value="1" id="post_id" name="post_id">
                <button type="submit" name="button" class="btn btn-success" id="savePost">Сохранить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
