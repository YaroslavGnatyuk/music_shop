<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: leopold
  Date: 29/03/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<h3>Sign Up</h3>
    <container>
        <row>
        <form:form method="post" commandName="user">
            <table>
                <tr>
                    <td>login:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Commit" />
                    </td>
                </tr>
            </table>
        </form:form>
        </row>
    </container>
</body>