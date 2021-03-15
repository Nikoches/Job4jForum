<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование</title>
    <jsp:include page="parts/general.jsp" />
</head>
<body>
<c:if test="${alert==true}">
    <div class="alert alert-warning">
        <strong>Warning!</strong> Пост не найден. <a href="/index" class="alert-link">Вернутся на главную</a>.
    </div>
</c:if>

<h4>${post.name}</h4>
<ul>
    <li>Название поста: <input type = "text" name = "post_name" id="post_name" value="${post.name}"></li>
    <li>Описание поста: <input type = "text" name = "post_desc" id="post_desc" value="${post.desc}"></li>
    <li>Дата поста:  <input type = "text" name = "post_date" id="post_date"></li>
</ul>
</div>
</body>
</html>
