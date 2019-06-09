<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-05-02
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Hello, guest</title>
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

<form action="/login" method="post">
    <div align="center" class="mt-4">
        <h2>Please sign in</h2>
<%--        <p>--%>
<%--        <input class="form-control col-3" type="text" name="username" placeholder="Email Address or login"/>--%>
<%--        <input class="form-control col-3 "type="password" name="password" placeholder="Password"/>--%>
<%--        </p>--%>
        <ul class="list-group list-group-flush">
            <input class="form-control col-3" type="text" name="username" placeholder="Email Address or login"/>
            <input class="form-control col-3 "type="password" name="password" placeholder="Password"/>
        </ul>
        <p><button type="submit" class="btn btn-primary col-3 mt-2 mb-1">Sign in</button></p>
        <a href="/registration">Registration</a>
    </div>
</form>
</body>
</html>