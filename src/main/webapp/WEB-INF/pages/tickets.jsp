<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-07
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-01
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TICKETS</title>
</head>
<body>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign out"/>
    </form>
</div>

<h2>Tickets</h2>
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
    </tr>
    <c:forEach var="ticket" items="${ticketList}">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.raisedBy.name}</td>
            <td>${ticket.assignedTo.name}</td>
            <td>${ticket.category.toString()}</td>
            <td>${ticket.status.toString()}</td>
            <td>${ticket.priority.toString()}</td>
            <td>${ticket.description}</td>
            <td>${ticket.detectionProblemDescription}</td>
            <td>
                <a href="/edit/${ticket.id}">edit</a>
                <a href="/deleteTicket/${ticket.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addTicket" var="add"/>
<a href="${add}">Add new ticket</a>

</body>
</html>

