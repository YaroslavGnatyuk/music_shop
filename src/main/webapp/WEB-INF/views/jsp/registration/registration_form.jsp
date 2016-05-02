<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: leopold
  Date: 29/03/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link  rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link  rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <script src="/resources/js/bootstrap.js"> </script>
    <script src="/resources/js/checkpass.js"> </script>
</head>
<body class="body">

<div class="container">

    <form:form class="form-signin " action="/registration" commandName="user" method="post" role="form">
        <h2 class="form-signin-heading" align="center">Registration</h2>
        <form:input type="text" class="form-control" placeholder="Username" name="username" style="margin-bottom: 5px" path="username"/>
        <form:input type="text" class="form-control" placeholder="First name" name="first_name" style="margin-bottom: 5px" path="firstName"/>
        <form:input type="text" class="form-control" placeholder="Last name" name="last_name" style="margin-bottom: 5px" path="lastName"/>
        <form:input type="text" class="form-control" placeholder="Email address" name="email" style="margin-bottom: 5px" path="email"/>
        <form:input id = "pass" type="password" class="form-control" placeholder="Password" name="password" style="margin-bottom: 5px" path="password"/>
        <input id = "confirm_pass" type="password" class="form-control" onkeyup="checkPass(); return false;" placeholder="Password confirm" name="password" style="margin-bottom: 5px" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        <a class="btn btn-lg btn-primary btn-block" type="submit" href="/">Back to main page</a>
    </form:form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>