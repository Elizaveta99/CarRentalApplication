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
        <div class="topnav">
                <a href="${pageContext.request.contextPath}/serv?action=homeLogged">Home</a>
                <a class="active" href="${pageContext.request.contextPath}/serv?action=leaveRequest">Leave request</a>
                <a href="${pageContext.request.contextPath}/serv?action=cars">Cars</a>
                <a href="${pageContext.request.contextPath}/serv?action=requests">Requests</a>
                <a href="${pageContext.request.contextPath}/serv?action=info">Info</a>
                <a href="${pageContext.request.contextPath}/serv?action=handleRequest">Handle Request</a>
                <a href="${pageContext.request.contextPath}/serv?action=returnCar">Return Car</a>
                <a class="login" href="${pageContext.request.contextPath}/serv?action=logout">Logout</a>
        </div>
        <h1>
            Оставить заявку
        </h1>
        <div class="page-form">
            <form id = "leave_request_form" action="${pageContext.request.contextPath}/serv?action=leaveRequest" method="POST">
            </form>
        </div>
        <script>
            <%@include file="/script/script.js"%>
        </script>
</body>

</html>