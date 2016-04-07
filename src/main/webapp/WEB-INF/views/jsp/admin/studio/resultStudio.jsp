<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/5/16
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Result search for studio</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" >
</head>
<body>
<table border="1" cellpadding="5" align="centr" >
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>delete</th>
    </tr>

    <tr>
        <td><c:out value="${result.id}" /></td>
        <td><c:out value="${result.name}" /></td>
        <td><c:out value="${result.address.country}" /></td>
        <td><input type="checkbox" checked></td>
    </tr>
</table>
<br>
<a class="btn btn-info" style="margin: 2px" href="/admin/find-studio-by-id">Search again</a>
</body>
</html>
