<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-08
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
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

<c:url value="/registration" var="var"/>
<form action="${var}" method="POST">

    <div class="col-3 ml-3 p-3 mb-2 bg-light text-dark">
        <p>${message}</p>
        <p><b>First Name</b></p>
        <p><input class="form-control" type="text" name="firstName"></p>
        <p><b>Second name</b></p>
        <p><input class="form-control" type="text" name="secondName"></p>
        <p><b>Login</b></p>
        <p><input class="form-control" type="text" name="login"></p>
        <p><b>Password</b></p>
        <p><input class="form-control" type="text" name="password"></p>
        <p><b>Gender</b></p>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="radioMale" value="MALE">
            <label class="form-check-label" for="radioMale">Male</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="radioFemale" value="FEMALE">
            <label class="form-check-label" for="radioFemale">Female</label>
        </div>
        <p><b>Email</b></p>
        <p><input class="form-control" type="text" name="email"></p>

        <button type="submit" class="btn btn-primary">Registration</button>
    </div>
</form>
</body>
</html>
