<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CarRental</title>
    <style>
        <%@include file="/style/styles.css"%>
    </style>
</head>

<body>
<h1>
    Зарегистрироваться
</h1>
<div class="page-form">
    <form id = "register_form" action="${pageContext.request.contextPath}/serv?action=register" method="POST">
    </form>
</div>

<a href="${pageContext.request.contextPath}/serv?action=home">Back</a>

<script>
    <%@include file="/script/script.js"%>
</script>
</body>

</html>