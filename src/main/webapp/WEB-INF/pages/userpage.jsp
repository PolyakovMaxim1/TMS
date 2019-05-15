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
<h2>Hello, ${currentUser.firstName} ${currentUser.secondName}</h2>
<h2>${message}</h2>
<table>
    <tr>
        <td valign="top" >
            <table>
                <tr>
                    <td><a href="/userpage/alltickets/${currentUser.id}">All tickets</a></td>
                </tr>
                <tr>
                    <td><a href="/userpage/mytickets/${currentUser.id}">My tickets</a></td>
                </tr>
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
                    <th>id</th>
                    <th>raised by</th>
                    <th>assigned to</th>
                    <th>category</th>
                    <th>status</th>
                    <th>priority</th>
                    <th>description</th>
                    <th>description detection problem</th>
                    <c:if test="${isAdmin}">
                        <th>action</th>
                    </c:if>
                </tr>
            <c:forEach var="ticket" items="${ticketList}">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.raisedBy.firstName.toString()}</td>
                    <td>${ticket.assignedTo.firstName.toString()}</td>
                    <td>${ticket.category.toString()}</td>
                    <td>${ticket.status.toString()}</td>
                    <td>${ticket.priority.toString()}</td>
                    <td>${ticket.description}</td>
                    <td>${ticket.detectionProblemDescription}</td>
                    <c:if test="${isAdmin}">
                        <td>
                            <a href="/userpage/${message2.toString()}/edit/${ticket.id}">edit</a>
                            <a href="/userpage/${message2.toString()}/deleteTicket/${ticket.id}">delete</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </table>
        </td>
        <td valign="top">
            <form action="/userpage/filter" method="POST">
                <h2>Filter</h2>
                <p><b>Write ticket description</b></p>
                <p><input type="text" name="description"/></p>
                <p><b>Describe how to detect a bug</b></p>
                <p><input type="text" name="descriptionDetectionProblem"/></p>
                <p><b>Write id author</b></p>
                <p><input type="text" name="raisedById"/></p>
                <p><b>Write id assigned</b></p>
                <p><input type="text" name="assignedToId"/></p>
                <p>
                    <select size = 1 name="statusId">
                        <option>Enter status ticket</option>
                        <option value="0">New</option>
                        <option value="1">Open</option>
                        <option value="2">On hold</option>
                        <option value="3">Solver</option>
                        <option value="4">Closed</option>
                        <option value="5">In progress</option>
                    </select>
                </p>
                <p>
                    <select size = 1 name="priorityId">
                        <option>Enter priority ticket</option>
                        <option value="0">Low</option>
                        <option value="1">Normal</option>
                        <option value="2">Medium</option>
                        <option value="3">High</option>
                        <option value="4">Critical</option>
                    </select>
                </p>
                <p>
                    <select size = 1 name="categoryId">
                        <option>Enter priority ticket</option>
                        <option value="0">Bug</option>
                        <option value="1">Dev task</option>
                        <option value="2">On hold</option>
                    </select>
                </p>
                <p><b>Write product version discovery</b></p>
                <p><input type="text" name="productVersionDiscovery", placeholder="version in"></p>
                <p><b>Write product version fixed</b></p>
                <p><input type="text" name="productVersionFixed", placeholder="version out"></p>

                <input type="submit" value="filter">
            </form>
        </td>
    </tr>
</table>

<h2>Add</h2>
<c:url value="/addTicket/${currentUser.id}" var="add"/>
<a href="/addTicket/${currentUser.id}">Add new ticket</a>

</body>
</html>
