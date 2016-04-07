<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Find by id</h3>
<form:form method="post" action="studio">
    <table>
        <tr>
            <td>Id :</td>
            <td><form:input path="id" /></td>
        </tr>
        <td colspan="2">
            <input type="submit" value="Search" />
        </td>
        </tr>
    </table>
</form:form>

</body>
</html>