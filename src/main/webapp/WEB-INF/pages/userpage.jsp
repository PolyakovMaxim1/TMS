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

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body class="bg-light text-dark">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
<h2 class="ml-3">My page</h2>
<h2 class="ml-3">${message}</h2>
<div class="container-fluid">
    <div class="row">
        <div class="col-10">
            <table class="table-striped table-sm">
                <thead class="thead-light">
                <tr>
                    <%--                    <th>id</th>--%>
                    <th scope="col">Raised by</th>
                    <th scope="col">Assigned to</th>
                    <th scope="col">Category</th>
                    <th scope="col">Status</th>
                    <th scope="col">Priority</th>
                    <th scope="col">Description</th>
                    <th scope="col">Description detection problem</th>
                    <th scope="col">Discovery product version</th>
                    <th scope="col">Fixed Product version</th>
                    <th scope="col">Date</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <c:forEach var="ticket" items="${ticketList}">
                    <tr>
                            <%--                        <td>${ticket.id}</td>--%>
                        <td>${ticket.raisedBy.firstName} ${ticket.raisedBy.secondName}</td>
                        <td>${ticket.assignedTo.firstName} ${ticket.assignedTo.secondName}</td>
                        <td>${ticket.category.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${ticket.status eq 'OPEN'}">
                                    <span class="badge badge-pill badge-primary">${ticket.status.name}</span>
                                </c:when>
                                <c:when test="${ticket.status eq 'SOLVED'}">
                                    <span class="badge badge-pill badge-success">${ticket.status.name}</span>
                                </c:when>
                                <c:when test="${ticket.status eq 'NEW'}">
                                    <span class="badge badge-pill badge-warning">${ticket.status.name}</span>
                                </c:when>
                                <c:when test="${ticket.status eq 'CLOSED'}">
                                    <span class="badge badge-pill badge-dark">${ticket.status.name}</span>
                                </c:when>
                                <c:when test="${ticket.status eq 'ON_HOLD'}">
                                    <span class="badge badge-pill badge-info">${ticket.status.name}</span>
                                </c:when>
                                <c:when test="${ticket.status eq 'IN_PROGRESS'}">
                                    <span class="badge badge-pill badge-light">${ticket.status.name}</span>
                                </c:when>
                            </c:choose></td>
                        <td>${ticket.priority.name}</td>
                        <td>${ticket.description}</td>
                        <td>${ticket.detectionProblemDescription}</td>
                        <td>${ticket.discoveryProductVersion}</td>
                        <td>${ticket.fixedProductVersion}</td>
                        <td>${ticket.dateDiscovery}</td>
                        <c:choose>
                            <c:when test="${isAdmin or ticket.raisedBy.id eq currentUser.id}">
                                <td>
                                    <c:if test="${isInMemoryUser}">
                                        <a href="/userpage/deleteTicket/${ticket.id}">delete</a>
                                        <a href="/userpage/editTicket/${ticket.id}">edit</a>
                                    </c:if>
                                    <c:if test="${!isInMemoryUser}">
                                        <a href="/userpage/${message2}/editTicket/${ticket.id}">edit</a>
                                        <a href="/userpage/${message2}/deleteTicket/${ticket.id}">delete</a>
                                    </c:if>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>

                                </td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a href="/ticketPage/${ticket.id}">go to page</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm">
            <c:if test="${isInMemoryUser}">
                <c:url value="/userpage/addTicket" var="add"/>
                <a class="btn btn-primary mb-2" href="/userpage/addTicket">Add new ticket</a>
            </c:if>
            <c:if test="${!isInMemoryUser}">
                <c:url value="/userpage/addTicket/${currentUser.id}" var="add"/>
                <a class="btn btn-primary mb-2" href="/userpage/addTicket/${currentUser.id}">Add new ticket</a>
            </c:if>
            <form action="/userpage/filter" method="POST">

                <p>
                    <button class="btn btn-primary" type="button" data-toggle="collapse"
                            data-target="#collapseExample"
                            aria-expanded="false" aria-controls="collapseExample">
                        Show filter
                    </button>
                </p>
                <div class="collapse mr-3" id="collapseExample">
                    <fieldset>
                        <legend><h2>Ticket search</h2></legend>
                        <p><b>Write ticket description</b></p>
                        <p><input type="text" name="description" class="form-control" value/></p>
                        <p><b>Describe how to detect a bug</b></p>
                        <p><input type="text" name="detectionProblemDescription" class="form-control" value/></p>
                        <p><b>Write first name author</b></p>
                        <p><input type="text" name="raisedByFirstName" class="form-control" value/></p>
                        <p><b>Write second name author</b></p>
                        <p><input type="text" name="raisedBySecondName" class="form-control" value/></p>
                        <p><b>Write first name assigned</b></p>
                        <p><input type="text" name="assignedToFirstName" class="form-control" value/></p>
                        <p><b>Write second name assigned</b></p>
                        <p><input type="text" name="assignedToSecondName" class="form-control" value/></p>
                        <p>
                            <select class="form-control" size=1 name="status">
                                <option value="">Enter status ticket</option>
                                <option value="NEW">New</option>
                                <option value="OPEN">Open</option>
                                <option value="ON_HOLD">On hold</option>
                                <option value="SOLVED">Solved</option>
                                <option value="CLOSED">Closed</option>
                                <option value="IN_PROGRESS">In progress</option>
                            </select>
                        </p>
                        <p>
                            <select class="form-control" size=1 name="priority">
                                <option value="">Enter priority ticket</option>
                                <option value="LOW">Low</option>
                                <option value="NORMAL">Normal</option>
                                <option value="MEDIUM">Medium</option>
                                <option value="HIGH">High</option>
                                <option value="CRITICAL">Critical</option>
                            </select>
                        </p>
                        <p>
                            <select class="form-control" size=1 name="category">
                                <option value="">Enter category ticket</option>
                                <option value="BUG">Bug</option>
                                <option value="DEV_TASK">Dev task</option>
                                <option value="WORK_ITEM">Work item</option>
                            </select>
                        </p>
                        <p><b>Write product version discovery</b></p>
                        <p><input type="text" name="discoveryProductVersion" class="form-control " value></p>
                        <p><b>Write product version fixed</b></p>
                        <p><input type="text" name="fixedProductVersion" class="form-control" value></p>

                        <button type="submit" class="btn btn-primary">Filter</button>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
