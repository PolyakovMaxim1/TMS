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
<c:if test="${isInMemoryUser}">
    <c:if test="${empty ticket.description}">
        <c:url value="/userpage/addTicket" var="var"/>
    </c:if>
    <c:if test="${!empty ticket.description}">
        <c:url value="/userpage/editTicket/${ticket.id}" var="var"/>
    </c:if>
</c:if>
<c:if test="${!isInMemoryUser}">
    <c:if test="${empty ticket.description}">
        <c:url value="/userpage/addTicket/${user.id}" var="var"/>
    </c:if>
    <c:if test="${!empty ticket.description}">
        <c:url value="/userpage/${messageUpdate}/editTicket/${ticket.id}" var="var"/>
    </c:if>
</c:if>
<form action="${var}" method="POST">

    <c:if test="${!empty ticket.description}">
        <input type="hidden" name="id" value="${ticket.id}">
    </c:if>

    <p><b>Write ticket description</b></p>
    <p><input type="text" name="description", value="${ticket.description}"  , placeholder="${ticket.description}"/></p>
    <p><b>Describe how to detect a bug</b></p>
    <p><input type="text" name="detectionProblemDescription", value="${ticket.detectionProblemDescription}" placeholder="${ticket.detectionProblemDescription}"/></p>
    <c:if test="${empty user.id}">
        <p><b>Write id author</b></p>
        <p><input type="text" name="raisedBy", value="${ticket.raisedBy.firstName}" placeholder="${ticket.raisedBy}"/></p>
    </c:if>
    <p><b>Write id assigned</b></p>
    <p><input type="text" name="assignedTo", value="${ticket.assignedTo.firstName}" placeholder="${ticket.assignedTo}"/></p>
    <p>
        <select size=1 name="status">
            <option value="${ticket.status}">Enter status ticket</option>
            <option value="NEW">New</option>
            <option value="OPEN">Open</option>
            <option value="ON_HOLD">On hold</option>
            <option value="SOLVER">Solver</option>
            <option value="CLOSED">Closed</option>
            <option value="IN_PROGRESS">In progress</option>
        </select>
    </p>
    <p>
        <select size=1 name="priority">
            <option value="${ticket.priority}">Enter priority ticket</option>
            <option value="LOW">Low</option>
            <option value="NORMAL">Normal</option>
            <option value="MEDIUM">Medium</option>
            <option value="HIGH">High</option>
            <option value="CRITICAL">Critical</option>
        </select>
    </p>
    <p>
        <select size=1 name="category">
            <option value="${ticket.category}">Enter priority ticket</option>
            <option value="BUG">Bug</option>
            <option value="DEV_TASK">Dev task</option>
            <option value="WORK_ITEM">Work item</option>
        </select>
    </p>
    <p><b>Write product version discovery</b></p>
    <p><input type="text" name="discoveryProductVersion" , value="${ticket.discoveryProductVersion}", placeholder="${ticket.discoveryProductVersion}"></p>
    <p><b>Write product version fixed</b></p>
    <p><input type="text" name="fixedProductVersion" , value="${ticket.fixedProductVersion}", placeholder="${ticket.fixedProductVersion}"></p>

    <c:if test="${empty ticket.description}">
        <input type="submit" value="Add new ticket">
    </c:if>
    <c:if test="${!empty ticket.description}">
        <input type="submit" value="Edit ticket">
    </c:if>
</form>
</body>
</html>