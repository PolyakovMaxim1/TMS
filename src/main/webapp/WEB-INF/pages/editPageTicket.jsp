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
<div class="p-3 mb-2 bg-light text-dark">
    <form action="${var}" method="POST">

        <c:if test="${!empty ticket.description}">
            <input type="hidden" name="id" value="${ticket.id}">
        </c:if>
        <div class="form-group ml-5 mt-3">
            <p><b>Write ticket description</b></p>
            <p><input class="form-control col-md-5" type="text" name="description" , value="${ticket.description}" ,
                      placeholder="${ticket.description}"/>
            </p>
            <p><b>Describe how to detect a bug</b></p>
            <p>
                <input class="form-control col-md-5" type="text" name="detectionProblemDescription" ,
                       value="${ticket.detectionProblemDescription}"
                       placeholder="${ticket.detectionProblemDescription}"/>
            </p>
            <c:if test="${isAdmin}">
                <%--            <p><b>Write id author</b></p>--%>
                <%--            <p><input class="form-control col-md-5" type="text" name="raisedBy" , value="${ticket.raisedBy.firstName}"--%>
                <%--                      placeholder="${ticket.raisedBy}"/></p>--%>
                <p>
                    <select class="form-control col-md-2" size=1 name="raisedBy">
                        <option value="${user.id}">Enter raised by user</option>
                        <c:forEach var="userValue" items="${listUsers}">
                            <option value="${userValue.id}">${userValue.firstName} ${userValue.secondName} ${userValue.login}</option>
                        </c:forEach>
                    </select>
                </p>
            </c:if>
            <%--        <p><b>Write id assigned</b></p>--%>
            <%--        <p>--%>
            <%--            <input class="form-control col-md-5" type="text" name="assignedTo" , value="${ticket.assignedTo.firstName}"--%>
            <%--                  placeholder="${ticket.assignedTo}"/>--%>
            <%--        </p>--%>
            <p>
                <select class="form-control col-md-2" size=1 name="assignedTo">
                    <option value="${user.id}">Enter assigned to user</option>
                    <c:forEach var="userValue" items="${listUsers}">
                        <option value="${userValue.id}">${userValue.firstName} ${userValue.secondName} ${userValue.login}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <select class="form-control col-md-2" size=1 name="status">
                    <option value="${ticket.status}">Enter status ticket</option>
                    <option value="NEW">New</option>
                    <option value="OPEN">Open</option>
                    <option value="ON_HOLD">On hold</option>
                    <option value="SOLVED">Solved</option>
                    <option value="CLOSED">Closed</option>
                    <option value="IN_PROGRESS">In progress</option>
                </select>
            </p>
            <p>
                <select class="form-control col-md-2" size=1 name="priority">
                    <option value="${ticket.priority}">Enter priority ticket</option>
                    <option value="LOW">Low</option>
                    <option value="NORMAL">Normal</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                    <option value="CRITICAL">Critical</option>
                </select>
            </p>
            <p>
                <select class="form-control col-md-2" size=1 name="category">
                    <option value="${ticket.category}">Enter category ticket</option>
                    <option value="BUG">Bug</option>
                    <option value="DEV_TASK">Dev task</option>
                    <option value="WORK_ITEM">Work item</option>
                </select>
            </p>
            <p><b>Write product version discovery</b></p>
            <p><input class="form-control col-md-2" type="text" name="discoveryProductVersion" ,
                      value="${ticket.discoveryProductVersion}" ,
                      placeholder="${ticket.discoveryProductVersion}"></p>
            <p><b>Write product version fixed</b></p>
            <p><input class="form-control col-md-2" type="text" name="fixedProductVersion" ,
                      value="${ticket.fixedProductVersion}" ,
                      placeholder="${ticket.fixedProductVersion}"></p>

            <c:if test="${empty ticket.description}">
                <button type="submit" class="btn btn-primary col-md-1">Add new ticket</button>
            </c:if>
            <c:if test="${!empty ticket.description}">
                <button type="submit" class="btn btn-primary col-md-1">Edit ticket</button>
            </c:if>
        </div>
    </form>
</div>
</body>
</html>