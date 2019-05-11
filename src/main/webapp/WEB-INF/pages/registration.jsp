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
</head>
<body>
    <c:url value="/registration" var="var"/>
<form action="${var}" method="POST">

    <p>${message}</p>
    <p><b>First Name</b></p>
    <p><input type = "text" name = "firstName"></p>
    <p><b>Second name</b></p>
    <p><input type = "text" name = "secondName"></p>
    <p><b>Login</b></p>
    <p><input type = "text" name = "login"></p>
    <p><b>Password</b></p>
    <p><input type = "text" name = "password"></p>
    <p><b>Gender</b></p>
    <p>
        <input type = "radio" name = "gender" value = "MALE"> Мужской
        <input type = "radio" name = "gender" value = "FEMALE"> Женский
    </p>
    <p><b>Email</b></p>
    <p><input type = "text" name = "email"></p>

    <input type = "submit" value = "registration">
</form>
</body>
</html>
