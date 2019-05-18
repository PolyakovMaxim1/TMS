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
    <c:url value="/addTicket/${user.id}" var="var"/>
</c:if>
<c:if test="${!empty ticket.description}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty ticket.description}">
        <input type="hidden" name="id" value="${ticket.id}">
    </c:if>

    <p><b>Write ticket description</b></p>
    <p><input type="text" name="description"/></p>
    <p><b>Describe how to detect a bug</b></p>
    <p><input type="text" name="descriptionDetectionProblem"/></p>
    <c:if test="${empty user.id}">
        <p><b>Write id author</b></p>
        <p><input type="text" name="raisedById"/></p>
    </c:if>
    <p><b>Write id assigned</b></p>
    <p><input type="text" name="assignedToId"/></p>
    <p>
        <select size = 1 name="statusId">
            <option>Enter status ticket</option>
            <option value="0">New</option>
            <option value="1">Open</option>
            <option value="2">On hold</option>
            <option value="3">Solver</option>
            <option value="4">Closed</option>
            <option value="5">In progress</option>
        </select>
    </p>
    <p>
        <select size = 1 name="priorityId">
            <option>Enter priority ticket</option>
            <option value="0">Low</option>
            <option value="1">Normal</option>
            <option value="2">Medium</option>
            <option value="3">High</option>
            <option value="4">Critical</option>
        </select>
    </p>
    <p>
        <select size = 1 name="categoryId">
            <option>Enter priority ticket</option>
            <option value="0">Bug</option>
            <option value="1">Dev task</option>
            <option value="2">Work item</option>
        </select>
    </p>
    <p><b>Write product version discovery</b></p>
    <p><input type="text" name="productVersionDiscovery", placeholder="version in"></p>
    <p><b>Write product version fixed</b></p>
    <p><input type="text" name="productVersionFixed", placeholder="version out"></p>

    <c:if test="${empty ticket.description}">
        <input type="submit" value="Add new ticket">
    </c:if>
    <c:if test="${!empty ticket.description}">
        <input type="submit" value="Edit ticket">
    </c:if>
</form>
</body>
</html>