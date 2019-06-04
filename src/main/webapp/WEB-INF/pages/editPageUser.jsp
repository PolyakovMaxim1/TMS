<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.id}">
        <title>Add user</title>
    </c:if>
    <c:if test="${!empty user.id}">
        <title>Edit user</title>
    </c:if>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body class="p-3 mb-2 bg-light text-dark">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<c:if test="${empty user.id}">
    <c:url value="/userList/addUser" var="var"/>
</c:if>
<c:if test="${!empty user.id}">
    <c:url value="/userList/editUser/${user.id}" var="var"/>
</c:if>
<p>${message}</p>
<form action="${var}" method="post">
    <c:if test="${!empty user.id}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>

    <div class="col-3 ml-3">
        <p><b>Write first name</b></p>
        <p><input type="text" class="form-control" name="firstName" placeholder="${user.firstName}" value="${user.firstName}"></p>
        <p><b>Write second name</b></p>
        <p><input type="text" class="form-control" name="secondName" placeholder="${user.secondName}" value="${user.secondName}"></p>
        <p><b>Write login</b></p>
        <p><input type="text" class="form-control" name="login" placeholder="${user.login}" value="${user.login}"></p>
        <c:if test="${empty user.id}">
        <p><b>Write password</b></p>
        <p><input type="text" class="form-control" name="password" placeholder="${user.password}" value="${user.password}"></p>
        </c:if>
        <p><b>Choose gender</b></p>
        <c:choose>
            <c:when test="${user.gender.name() eq 'MALE'}">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioMale" value="MALE" checked>
                    <label class="form-check-label" for="radioMale">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioFemale" value="FEMALE">
                    <label class="form-check-label" for="radioFemale">Female</label>
                </div>
            </c:when>
            <c:when test="${user.gender.name() eq 'FEMALE'}">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioMale2" value="MALE">
                    <label class="form-check-label" for="radioMale2">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioFemale2" value="FEMALE" checked>
                    <label class="form-check-label" for="radioFemale2">Female</label>
                </div>
            </c:when>
            <c:when test="${empty user.gender.name()}">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioMale1" value="MALE">
                    <label class="form-check-label" for="radioMale1">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="radioFemale1" value="FEMALE">
                    <label class="form-check-label" for="radioFemale1">Female</label>
                </div>
            </c:when>
        </c:choose>
        <p><b>Write email</b></p>
        <p><input type="text" class="form-control" name="email" placeholder="${user.email}" value="${user.email}"></p>

        <c:if test="${!empty user.id}">
            <p><b>Write count bug</b></p>
            <input type="text" class="form-control" name="countMakeBug" placeholder="${user.countMakeBug}" value="${user.countMakeBug}">
        </c:if>
        <p><b>Choose roles</b></p>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="role1" id="radioAdmin" value="ADMIN">
            <label class="form-check-label" for="radioAdmin">Admin</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="role2" id="radioUser" value="USER">
            <label class="form-check-label" for="radioUser">User</label>
        </div>

        <c:if test="${empty user.id}">
            <p>
                <button type="submit" class="btn btn-primary">Add new user</button>
            </p>
        </c:if>
        <c:if test="${!empty user.id}">
            <p>
                <button type="submit" class="btn btn-primary">Edit user</button>
            </p>
        </c:if>
    </div>
</form>
</body>
</html>