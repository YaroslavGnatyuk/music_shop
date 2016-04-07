
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Title</title>
    </head>

    <body>
        <table border="1" cellpadding="5" align="centr">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>address</th>
                <th>category</th>
                <th>studio</th>
                <th>email</th>
                <th>year of create</th>
            </tr>

            <tr>
                <td><c:out value="${result.id}" /></td>
                <td><c:out value="${result.name}" /></td>
                <td><c:out value="${result.address.country}" /></td>
                <td><c:out value="${result.category.name}" /></td>
                <td><c:out value="${result.studio.name}" /></td>
                <td><c:out value="${result.email}" /></td>
                <td><c:out value="${result.birthday}" /></td>
            </tr>
        </table>
    <br>
    <a href="/admin/find-artist-by-id">Search again</a>
    </body>
</html>