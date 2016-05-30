<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body class="body">

<div class="container">

    <form class="form-signin" action="/login" method="post" role="form">
        <h2 class="form-signin-heading" align="center">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Username" name="j_username" cssStyle="margin-bottom: 5px"/>
        <input type="password" class="form-control" placeholder="Password" name="j_password"/>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a class="btn btn-lg btn-primary btn-block" type="submit" href="/registration">Registration</a>
    </form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
