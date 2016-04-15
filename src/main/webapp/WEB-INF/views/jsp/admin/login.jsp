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
<head>
    <link  rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link  rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <script src="/resources/js/bootstrap.js"> </script>
</head>
<body>
<h3>Sign Up</h3>
    <container>
        <row>
           <form:form cssclass="form-horizontal" method="post" commandName="user">
                <div class="control-group">
                    <label class="control-label" for="inputEmail">Login</label>
                    <div class="controls">
                        <form:input type="text" id="inputEmail" path="name" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Password</label>
                    <div class="controls">
                        <form:input type="password" id="inputPassword" path="password"/>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                       <%-- <label class="checkbox">
                            <form:input type="checkbox" > Запомнить меня
                        </label>--%>
                        <button type="submit" class="btn" style="background-color: #527cfb">Enter</button>
                    </div>
                </div>
            </form:form>
        </row>
    </container>
</body>