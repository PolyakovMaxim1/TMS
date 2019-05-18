<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-18
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ticket № ${ticket.id}</title>
</head>
<body>
<h2>Ticket № ${ticket.id}</h2>
<table>
    <tr>
        <th>Description</th>
        <th>Description detection problem</th>
        <th>Status</th>
        <th>Category</th>
        <th>Priority</th>
        <th>Raised</th>
        <th>Assigned</th>
        <th>Object</th>
        <th>Product version discovery</th>
        <th>Product version fixed</th>
        <th>Date</th>
    </tr>
    <tr>
        <td>${ticket.description}</td>
        <td>${ticket.detectionProblemDescription}</td>
        <td>${ticket.status.toString()}</td>
        <td>${ticket.category.toString()}</td>
        <td>${ticket.priority.toString()}</td>
        <td>${ticket.raisedBy.firstName.toString()} ${ticket.raisedBy.secondName.toString()}</td>
        <td>${ticket.assignedTo.firstName.toString()} ${ticket.assignedTo.secondName.toString()}</td>
        <td>${ticket.object}</td>
        <td>${ticket.discoveryProductVersion}</td>
        <td>${ticket.fixedProductVersion}</td>
        <td>${ticket.dateDiscovery}</td>
    </tr>
</table>
<div>
    <h2>Add comment</h2>
    <form action="/ticket/${idTicket}/addComment" method="post">
        <input type="text" name="message">
        <input type="submit" value="AddComment">
    </form>
</div>
<h2>Ticket comments</h2>
<table>
    <tr>
        <th>Message</th>
        <th>Author comment</th>
        <th>Date</th>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.message}</td>
            <td>${comment.user.firstName} ${comment.user.secondName}</td>
            <td>${comment.dateAnswer}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
