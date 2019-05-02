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
    <title>USERS</title>
</head>
<body>

<h2>Users</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>role</th>
        <th>email</th>
        <th>countmadebug</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>${user.email}</td>
            <td>${user.countMakeBug}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<h2>Add</h2>--%>
<%--<c:url value="/add" var="add"/>--%>
<%--<a href="${add}">Add new film</a>--%>
</body>
</html>
