<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/9/16
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">

</head>
<body>

<div class="raw">
    <div class="col-lg-12">
        <div class="page-header">
            <div class="col-lg-4" style="margin-top: 15px; margin-bottom: 15px" >
                <img src="/resources/img/corso-musica2.jpg" class="img-rounded" align="center" width="300" height="100" >
            </div>
            <div class="col-lg-5">
                <h1>Music for life
                    <small>A lot of music for you!</small>
                </h1>
            </div>

            <div class="col-lg-3">
                <div class="btn-group btn-group-lg" style="margin-left: 75px">
                    <a type="button" class="btn btn-default" href="/user/main-page">Main page</a>
                    <a type="button" class="btn btn-default" href="/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="raw">
    <div div class="col-lg-12">

        <ul class="nav nav-tabs">
            <li><a href="/admin/artist-main-page">Artist</a></li>
            <li><a href="/admin/studio-main-page">Studio</a></li>
            <li><a href="/admin/album-main-page">Album</a></li>
            <li><a href="/admin/category-main-page">Category</a></li>
            <li><a href="/admin/user-main-page">User</a></li>
            <li><a href="/admin/article-main-page">Article</a></li>
        </ul>
    </div>
</div>

<div class="raw">
    <div div class="col-lg-1" style="margin-top:10px">
    </div>

    <div class="raw">
        <div div class="col-lg-8" style="margin-top:10px">
            <form:form id = "userupdate" method="post" cssStyle="margin-left: 150px" >
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="username" value="${command.username}"
                                        cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>First name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="firstName" value="${command.firstName}"
                                        cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>


                    <tr>
                        <td>Last name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="lastName" value="${command.lastName}"
                                        cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="email" value="${command.email}"
                                        cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>


                    <tr>
                        <td>Roles:</td>
                        <td><select size="2" multiple name="userRole" class = "form-control" id = "focusedInput" form="userupdate"
                                    style="width: 500px;margin-top: 3px">
                                <option value="ROLE_USER" selected> USER </option>
                                <option value="ROLE_ADMIN"> ADMIN </option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Enable:</td>
                        <td><form:checkbox class = "checkbox"  path="enable" value="${enable}"
                                           cssStyle="width: 500px;margin-top: 10px;
                                            transform: scale(2.0);
                                           -webkit-transform: scale(2.0);"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-info btn-block" value="Update user"
                                   style="margin-top: 15px;background-color: #337AB7;border-color: #337AB7"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>

    <div div class="col-lg-1" style="margin-top:10px">
    </div>
</div>

<div class="raw">
    <div div class="col-lg-12" style = "margin-top: 200px">
        <div class="well">
            Author sunrise@gmail.com
        </div>
    </div>
</div>
</body>
</html>