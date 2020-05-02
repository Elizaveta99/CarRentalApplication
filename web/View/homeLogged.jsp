<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>CarRental</title>
    <style>
        <%@include file="/style/styles.css"%>
    </style>
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/serv?action=homeLogged">Home</a>
    <a href="${pageContext.request.contextPath}/serv?action=leaveRequest">Leave request</a>
    <a href="${pageContext.request.contextPath}/serv?action=cars">Cars</a>
    <a href="${pageContext.request.contextPath}/serv?action=requests">Requests</a>
    <a href="${pageContext.request.contextPath}/serv?action=info">Info</a>
    <a href="${pageContext.request.contextPath}/serv?action=handleRequest">Handle Request</a>
    <a href="${pageContext.request.contextPath}/serv?action=returnCar">Return Car</a>
    <a class="login" href="${pageContext.request.contextPath}/serv?action=logout">Logout</a>
</div>
<p style="font-family:courier;">Вариант 15.<br>Прокат автомобилей.
    Клиент оставляет Заявку на Автомобиль конкретной модели, указывая паспортные данные, срок аренды.
    Администратор оформляет Заказ, выбрав Автомобиль, соответствующий Заявке из списка доступных,
    после чего Клиенту выставляется Счет.
    По факту возврата Администратором фиксируется текущее состояние Автомобиля.</p>
<%--<p>--%>
<%--    Последний заход: ${cookie['lastEnterTime'].getValue()}--%>
<%--<p>--%>
<%--<p>--%>
<%--    Количество посещений: ${cookie['usageCount'].getValue()}--%>
<%--</p>--%>
</body>
</html>