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

<h3>Sign Up</h3>

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