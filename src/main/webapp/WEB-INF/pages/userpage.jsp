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
            <c:forEach var="ticket" items="${ticketList}">
                <div class="card w-60 p-0 m-0 mb-3">
                    <div class="card-body">
                        <table class="text-wrap text-break">
                            <tr>
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
                                </td>
                                <td>
                                    <div class="ml-2">
                                        <h6 class="card-subtitle text-muted">Description</h6>
                                        <c:if test="${ticket.description.length() > 40}">
                                            <c:set var="desc" value="${ticket.description.substring(0, 40)}..."/>
                                            ${desc}
                                        </c:if>
                                        <c:if test="${ticket.description.length() <= 40}">
                                            ${ticket.description}
                                        </c:if>
                                        <a data-toggle="modal" style="outline:none;" href="#exampleModalCenter${ticket.id}" role="button">show
                                            more info</a>
                                            <%--                                        <button class="btn btn-link" style="border:none;padding:0;" type="button" data-toggle="modal"--%>
                                            <%--                                                data-target="#exampleModalCenter${ticket.id}">--%>
                                            <%--                                            show more info--%>
                                            <%--                                        </button>--%>
                                        <div class="modal fade" id="exampleModalCenter${ticket.id}" tabindex="-1"
                                             role="dialog" aria-labelledby="exampleModalCenterTitle"
                                             aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLongTitle1">
                                                            Description
                                                            ticket</h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                            ${ticket.description}
                                                        <c:if test="${!empty ticket.detectionProblemDescription}">
                                                            <h6 class="card-subtitle mb-2 mt-2 text-muted">Detection
                                                                problem description</h6>
                                                            ${ticket.detectionProblemDescription}
                                                        </c:if>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">Close
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                            <%-- <p class="card-text ml-2">${ticket.description}</p> --%>

                                        <!-- Modal -->
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table table-bordered bg-light m-0 mt-2">
                            <tr>
                                <td>
                                    <h6 class="card-subtitle mb-2 text-muted">assignee</h6>
                                        ${ticket.assignedTo.firstName} ${ticket.assignedTo.secondName}
                                </td>
                                <td>
                                    <h6 class="card-subtitle mb-2 text-muted">raised by</h6>
                                        ${ticket.raisedBy.firstName} ${ticket.raisedBy.secondName}
                                </td>
                                <td>
                                    <h6 class="card-subtitle mb-2 text-muted">priority</h6>
                                        ${ticket.priority.name}
                                </td>
                                <td>
                                    <h6 class="card-subtitle mb-2 text-muted">category</h6>
                                        ${ticket.category.name}
                                </td>
                                <td>
                                    <h6 class="card-subtitle mb-2 text-muted">date</h6>
                                        ${ticket.dateDiscovery}
                                </td>
                                <c:choose>
                                    <c:when test="${isAdmin or ticket.raisedBy.id eq currentUser.id}">
                                        <td>
                                            <c:if test="${isInMemoryUser}">
                                                <p class="m-0"><a href="/userpage/deleteTicket/${ticket.id}">delete</a>
                                                </p>
                                                <p class="m-0"><a href="/userpage/editTicket/${ticket.id}">edit</a></p>
                                            </c:if>
                                            <c:if test="${!isInMemoryUser}">
                                                <p class="m-0"><a href="/userpage/${message2}/editTicket/${ticket.id}">edit</a>
                                                </p>
                                                <p class="m-0"><a
                                                        href="/userpage/${message2}/deleteTicket/${ticket.id}">delete</a>
                                                </p>
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
                        </table>
                    </div>
                </div>
            </c:forEach>
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
