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
    <div div class="col-lg-12">
        <div class="page-header">
            <h1>Music for life
                <small>Administrator page</small>
            </h1>
        </div>
        <p>
            Here you can update, create, find and delete records from database!
            Be careful!
        </p>

    </div>
</div>

<div class="raw">
    <div div class="col-lg-12">

        <ul class="nav nav-tabs">
            <li class="active"><a href="/admin/admin-main-page">Home</a></li>
            <li><a href="/admin/artist-main-page">Artist</a></li>
            <li><a href="/admin/studio-main-page">Studio</a></li>
            <li><a href="/admin/album-main-page">Album</a></li>
            <li><a href="/admin/category-main-page">Category</a></li>
            <li><a href="#">Store</a></li>
        </ul>
    </div>
</div>

<div class="raw">
    <div div class="col-lg-2" style="margin-top:10px">
        <ul class="list-group">
            <a href="/admin/studio-main-page" class="list-group-item active">
                Studio
            </a>
            <a href="/admin/add-studio" class="list-group-item">Create</a>
            <a href="/admin/update-studio" class="list-group-item">Update</a>
            <a href="/admin/find-studio-by-id" class="list-group-item">Find</a>
            <a href="/admin/delete-studio" class="list-group-item">Delete</a>
        </ul>

    </div>
    <div class="raw">

        <div div class="col-lg-8" style="margin-top:10px">
            <form:form method="post" cssStyle="margin-left: 150px" >
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="name" cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="address.country" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>City:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="address.city" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Street:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="address.street" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Building:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="address.house" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Flat:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="address.flat" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-info btn-block"
                                   value="Add new studio" style="margin-top: 15px;
                                   background-color: #337AB7;border-color: #337AB7"/>
                        </td>
                    </tr>
                </table>
            </form:form>

        </div>



    </div>

    <div div class="col-lg-2" style="margin-top:10px">

        <div class="well">
            The page header is a nice little feature to add appropriate spacing around the
            headings on a page. This is particularly helpful on a web page where you may
            have several post titles and need a way to add distinction to each of them. To
            use a page header, wrap your heading in a with a class of .page-header:
            Hi, am in well !!
        </div>
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