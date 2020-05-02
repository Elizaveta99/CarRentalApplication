<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="/style/styles.css"%>--%>
<head>
    <meta charset="UTF-8">
    <title>CarRental</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/styles.css">
</head>
<body>
    <div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/serv?action=home">Home</a>
        <a class="login" href="${pageContext.request.contextPath}/serv?action=login">Login</a>
        <a class="login" href="${pageContext.request.contextPath}/serv?action=register">Register</a>
    </div>
<p style="font-family:courier;">Вариант 15.<br>Прокат автомобилей. 
Клиент оставляет Заявку на Автомобиль конкретной модели, указывая паспортные данные, срок аренды. 
Администратор оформляет Заказ, выбрав Автомобиль, соответствующий Заявке из списка доступных,
после чего Клиенту выставляется Счет.
По факту возврата Администратором фиксируется текущее состояние Автомобиля.</p>
<p>
    Последний заход: ${cookie['lastEnterTime'].getValue()}
<p>
<p>
    Количество посещений: ${cookie['usageCount'].getValue()}
</p>
</body>
</html>