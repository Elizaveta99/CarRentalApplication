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
            <a href="${pageContext.request.contextPath}/serv?action=leaveRequest">Leave request</a>
            <a href="${pageContext.request.contextPath}/serv?action=cars">Cars</a>
            <a class="active" href="${pageContext.request.contextPath}/serv?action=requests">Requests</a>
            <a href="${pageContext.request.contextPath}/serv?action=info">Info</a>
            <a href="${pageContext.request.contextPath}/serv?action=handleRequest">Handle Request</a>
            <a href="${pageContext.request.contextPath}/serv?action=returnCar">Return Car</a>
            <a class="login" href="${pageContext.request.contextPath}/serv?action=logout">Logout</a>
        </div>
            <h1>
                    Список заявок
            </h1>
            <c:if test="${!empty requestsList}">
            <div class="page-table">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Model</th>
                            <th scope="col">Day's amount</th>
                            <th scope="col">Client's ID</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestsList}" var="request">
                            <tr>
                                <th scope="col">${request.getId()}</th>
                                <th scope="col">${request.getModel()}</th>
                                <th scope="col">${request.getRentalTime()}</th>
                                <th scope="col">${request.getClient().getIdPassport()}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

<%--            <script src="script/script.js" type="text/javascript" charset="utf-8"></script>--%>
        <script>
            <%@include file="/script/script.js"%>
        </script>
</body>

</html>