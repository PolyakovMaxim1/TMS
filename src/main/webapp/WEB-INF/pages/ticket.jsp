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

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body class="bg-light text-dark">
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
    <h2 class="ml-3">Ticket № ${ticket.id}</h2>
    <table class="table table-bordered">
        <thead class="thead-light">
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
        </thead>
        <tr>
            <td class="text-wrap text-break">${ticket.description}</td>
            <td class="text-wrap text-break">${ticket.detectionProblemDescription}</td>
            <td>${ticket.status.name}</td>
            <td>${ticket.category.name}</td>
            <td>${ticket.priority.name}</td>
            <td>${ticket.raisedBy.firstName.toString()} ${ticket.raisedBy.secondName.toString()}</td>
            <td>${ticket.assignedTo.firstName.toString()} ${ticket.assignedTo.secondName.toString()}</td>
            <td>${ticket.object}</td>
            <td>${ticket.discoveryProductVersion}</td>
            <td>${ticket.fixedProductVersion}</td>
            <td>${ticket.dateDiscovery}</td>
        </tr>
    </table>
    <div>
        <h2 class="ml-3">Add comment</h2>
        <form action="/ticket/${idTicket}/addComment" method="post">
            <input class="form-control m-3 col-md-4" type="text" name="message">
            <button type="submit" class="btn btn-primary ml-3">Add comment</button>
        </form>
    </div>
    <h2 class="ml-3">Ticket comments</h2>
    <table class="table table-striped m-3 w-50">
        <tr>
            <th>Message</th>
            <th>Author comment</th>
            <th>Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td class="text-wrap text-break">${comment.message}</td>
                <td>${comment.user.firstName} ${comment.user.secondName}</td>
                <td>${comment.dateAnswer}</td>
                <c:choose>
                    <c:when test="${isAdmin or comment.user.id eq currentUser.id}">
                        <td>
                            <a href="/ticketPage/${ticket.id}/deleteComment/${comment.id}">delete</a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
