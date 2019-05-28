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

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/user">Home<span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${!isInMemoryUser}">
                <li class="nav-item">
                    <a class="nav-link" href="/userpage/alltickets/${currentUser.id}">All tickets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/userpage/raisedBy/${currentUser.id}">My tickets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/userpage/assignedTo/${currentUser.id}">On me tickets</a>
                </li>
            </c:if>
            <c:if test="${isAdmin}">
                <li class="nav-item">
                    <a class="nav-link" href="/userList">List users</a>
                </li>
            </c:if>
        </ul>
        <c:if test="${isInMemoryUser}">
            <div class="navbar-text mr-3">${inMemoryUser.username.toString()}</div>
        </c:if>
        <c:if test="${!isInMemoryUser}">
            <div class="navbar-text mr-3">${currentUser.firstName} ${currentUser.secondName}</div>
        </c:if>
        <form class="form-inline my-2 my-lg-0" , action="/logout" , method="post">
            <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Sign out</button>
        </form>
    </div>
</nav>

<div class="form-group">
    <h2 class="h2 ml-4">Users</h2>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Second name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Count made bug</th>
            <th>Roles</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.secondName}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.gender.toString()}</td>
                <td>${user.email}</td>
                <td>${user.countMakeBug}</td>
                <td>
                    <c:forEach var="role" items="${user.roles}">
                        ${role.name()}
                    </c:forEach>
                </td>
                <td>
                    <a href="/userList/editUser/${user.id}">edit</a>
                    <a href="/userList/deleteUser/${user.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/userList/addUser" var="add"/>
    <a class="btn btn-primary ml-4" href="${add}">Add new user</a>
</div>
</body>
</html>
