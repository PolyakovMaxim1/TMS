<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.firstName}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.firstName}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.firstName}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.firstName}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.firstName}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>

    <input type="text" name="firstName", placeholder="Введите имя"/>
    <input type="text" name="secondName", placeholder="Введите фамилию"/>
    <input type="text" name="login", placeholder="Введите логин"/>
    <input type="text" name="password" , placeholder="Введите пароль">
    <input type="text" name="gender" , placeholder="Укажите пол">
    <input type="text" name="email", placeholder="Введите email">
    <input type="text" name="countMakeBug", placeholder="Введите кол-во ошибок">

    <c:if test="${empty user.firstName}">
        <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.firstName}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>