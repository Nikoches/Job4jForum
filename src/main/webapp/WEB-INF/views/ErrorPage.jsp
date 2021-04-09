<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.03.2021
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="parts/general.jsp"/>
<head>
    <title>Error</title>
</head>
<body>
<div class="alert alert-danger" role="alert">
        ${error}
</div>
</body>
</html>
