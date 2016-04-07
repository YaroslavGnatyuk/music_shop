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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<h3>Add studio</h3>

<form:form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><form:input type = "email" path="address.country" /></td>
        </tr>

        <tr>
            <td>City:</td>
            <td><form:input path="address.city" /></td>
        </tr>

        <tr>
            <td>Street:</td>
            <td><form:input path="address.street" /></td>
        </tr>

        <tr>
            <td>Building:</td>
            <td><form:input path="address.house" /></td>
        </tr>

        <tr>
            <td>Flat:</td>
            <td><form:input path="address.flat" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add new studio" />
            </td>
        </tr>
    </table>
</form:form>

<button type="button" class="btn btn-primary">Default</button>

</body>
