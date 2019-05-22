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
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign out"/>
    </form>
</div>
<h2>My page</h2>
<c:if test="${isInMemoryUser}">
    <h2>Hello, ${inMemoryUser.username.toString()}</h2>
</c:if>
<c:if test="${!isInMemoryUser}">
    <h2>Hello, ${currentUser.firstName} ${currentUser.secondName}</h2>
</c:if>
<h2>${message}</h2>
<table>
    <tr>
        <td valign="top">
            <table>
                <c:if test="${!isInMemoryUser}">
                    <tr>
                        <td><a href="/userpage/alltickets/${currentUser.id}">All tickets</a></td>
                    </tr>
                    <tr>
                        <td><a href="/userpage/raisedBy/${currentUser.id}">My tickets</a></td>
                    </tr>
                    <tr>
                        <td><a href="/userpage/assignedTo/${currentUser.id}">On me tickets</a></td>
                    </tr>
                </c:if>
                <c:if test="${isAdmin}">
                    <tr>
                        <td><a href="/main">List users</a></td>
                    </tr>
                </c:if>
            </table>
        </td>
        <td valign="top">
            <table>
                <tr>
                    <%--                    <th>id</th>--%>
                    <th>raised by</th>
                    <th>assigned to</th>
                    <th>category</th>
                    <th>status</th>
                    <th>priority</th>
                    <th>description</th>
                    <th>description detection problem</th>
                    <th>Discovery product version</th>
                    <th>Fixed Product version</th>
                    <th>Date</th>
                    <c:if test="${isAdmin}">
                        <th>action</th>
                    </c:if>
                </tr>
                <c:forEach var="ticket" items="${ticketList}">
                    <tr>
                            <%--                        <td>${ticket.id}</td>--%>
                        <td>${ticket.raisedBy.firstName} ${ticket.raisedBy.secondName}</td>
                        <td>${ticket.assignedTo.firstName} ${ticket.assignedTo.secondName}</td>
                        <td>${ticket.category.name}</td>
                        <td>${ticket.status.name}</td>
                        <td>${ticket.priority.name}</td>
                        <td>${ticket.description}</td>
                        <td>${ticket.detectionProblemDescription}</td>
                        <td>${ticket.discoveryProductVersion}</td>
                        <td>${ticket.fixedProductVersion}</td>
                        <td>${ticket.dateDiscovery}</td>
                        <c:if test="${isAdmin}">
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
                        </c:if>
                        <td>
                            <a href="/ticketPage/${ticket.id}">go to page</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td valign="top">
            <form action="/userpage/filter" method="POST">

                <fieldset>
                    <legend><h2>Ticket search</h2></legend>
                    <p><b>Write ticket description</b></p>
                    <p><input type="text" name="description" value/></p>
                    <p><b>Describe how to detect a bug</b></p>
                    <p><input type="text" name="detectionProblemDescription" value/></p>
                    <p><b>Write first name author</b></p>
                    <p><input type="text" name="raisedByFirstName" value/></p>
                    <p><b>Write second name author</b></p>
                    <p><input type="text" name="raisedBySecondName" value/></p>
                    <p><b>Write first name assigned</b></p>
                    <p><input type="text" name="assignedToFirstName" value/></p>
                    <p><b>Write second name assigned</b></p>
                    <p><input type="text" name="assignedToSecondName" value/></p>
                    <p>
                        <select size=1 name="status">
                            <option value="">Enter status ticket</option>
                            <option value="NEW">New</option>
                            <option value="OPEN">Open</option>
                            <option value="ON_HOLD">On hold</option>
                            <option value="SOLVER">Solver</option>
                            <option value="CLOSED">Closed</option>
                            <option value="IN_PROGRESS">In progress</option>
                        </select>
                    </p>
                    <p>
                        <select size=1 name="priority">
                            <option value="">Enter priority ticket</option>
                            <option value="LOW">Low</option>
                            <option value="NORMAL">Normal</option>
                            <option value="MEDIUM">Medium</option>
                            <option value="HIGH">High</option>
                            <option value="CRITICAL">Critical</option>
                        </select>
                    </p>
                    <p>
                        <select size=1 name="category">
                            <option value="">Enter priority ticket</option>
                            <option value="BUG">Bug</option>
                            <option value="DEV_TASK">Dev task</option>
                            <option value="WORK_ITEM">Work item</option>
                        </select>
                    </p>
                    <p><b>Write product version discovery</b></p>
                    <p><input type="text" name="discoveryProductVersion" value></p>
                    <p><b>Write product version fixed</b></p>
                    <p><input type="text" name="fixedProductVersion" value></p>

                    <input type="submit" value="Filter">
                </fieldset>
            </form>
        </td>
    </tr>
</table>

<h2>Add</h2>
<c:if test="${isInMemoryUser}">
    <c:url value="/userpage/addTicket" var="add"/>
    <a href="/userpage/addTicket">Add new ticket</a>
</c:if>
<c:if test="${!isInMemoryUser}">
    <c:url value="/userpage/addTicket/${currentUser.id}" var="add"/>
    <a href="/userpage/addTicket/${currentUser.id}">Add new ticket</a>
</c:if>

</body>
</html>
