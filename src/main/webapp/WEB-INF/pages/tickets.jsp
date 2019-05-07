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
        <th>author</th>
        <th>category</th>
        <%--        <th>role</th>--%>
        <th>description</th>
    </tr>
    <c:forEach var="ticket" items="${ticketList}">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.author}</td>
            <td>${ticket.category}</td>
            <td>${ticket.description}</td>
            <td>
                <a href="/edit/${ticket.id}">edit</a>
                <a href="/delete/${ticket.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>

</body>
</html>

