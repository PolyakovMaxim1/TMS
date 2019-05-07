<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty ticket.description}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty ticket.description}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty ticket.description}">
    <c:url value="/addTicket" var="var"/>
</c:if>
<c:if test="${!empty ticket.description}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty ticket.description}">
        <input type="hidden" name="id" value="${ticket.id}">
    </c:if>

    <input type="text" name="description", placeholder="Введите описание"/>
    <input type="text" name="descriptionDetectionProblem", placeholder="Введите описание проблемы"/>
    <input type="text" name="raisedById", placeholder="Введите id, автора"/>
    <input type="text" name="assignedToId", placeholder="Введите id отвественного"/>
    <input type="text" name="statusId" , placeholder="Введите статус">
    <input type="text" name="priorityId", placeholder="Введите приоритет">
    <input type="text" name="categoryId", placeholder="Введите категорию">
    <input type="text" name="productVersionDiscovery", placeholder="version in">
    <input type="text" name="productVersionFixed", placeholder="version out">

    <c:if test="${empty ticket.description}">
        <input type="submit" value="Add new ticket">
    </c:if>
    <c:if test="${!empty user.description}">
        <input type="submit" value="Edit ticket">
    </c:if>
</form>
</body>
</html>