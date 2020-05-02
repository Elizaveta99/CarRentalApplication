<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CarRental</title>
    <link rel="stylesheet" href="/style/styles.css">
</head>

<body>
<h1>
    Войти
</h1>
<div class="page-form">
    <form id = "login_form" action="${pageContext.request.contextPath}/serv?action=login" method="POST">
    </form>
</div>

<a href="${pageContext.request.contextPath}/serv?action=home">Back</a>

<script src="/script/script.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>