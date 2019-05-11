<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-11
  Time: 04:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My page</title>
</head>
<body>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign out"/>
    </form>
</div>
<h2>My page</h2>
<h2>My tickets</h2>
<h2>Hello, ${currentUser.firstName} ${currentUser.secondName}</h2>
<table>
    <tr>
        <th>id</th>
        <th>raised by</th>
        <th>assigned to</th>
        <th>category</th>
        <th>status</th>
        <th>priority</th>
        <th>description</th>
        <th>description detection problem</th>
        <c:if test="${isAdmin}">
            <th>action</th>
        </c:if>
    </tr>
    <c:forEach var="ticket" items="${ticketList}">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.raisedBy.firstName.toString()}</td>
            <td>${ticket.assignedTo.firstName.toString()}</td>
            <td>${ticket.category.toString()}</td>
            <td>${ticket.status.toString()}</td>
            <td>${ticket.priority.toString()}</td>
            <td>${ticket.description}</td>
            <td>${ticket.detectionProblemDescription}</td>

            <c:if test="${isAdmin}">
                <td>
                    <a href="/edit/${ticket.id}">edit</a>
                    <a href="/deleteTicket/${ticket.id}">delete</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addTicket" var="add"/>
<a href="/addTicket">Add new ticket</a>

</body>
</html>
