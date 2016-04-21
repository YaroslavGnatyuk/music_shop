<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-datetimepicker.min.css" />

    <script type="text/javascript" src="/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap-datetimepicker.min.js"></script>
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
            <a href="/admin/admin-main-page" class="list-group-item active">
                Artist
            </a>
            <a href="/admin/add-artist" class="list-group-item">Create</a>
            <a href="/admin/update-artist" class="list-group-item">Update</a>
            <a href="/admin/find-artist-by-id" class="list-group-item">Find</a>
            <a href="/admin/delete-artist" class="list-group-item">Delete</a>
        </ul>

    </div>
    <div class="raw">

        <div div class="col-lg-8" style="margin-top:10px">
            <h3 align="center">Page add's artist </h3>
            <form:form method="post" cssStyle="margin-left: 150px" >
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="name" cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td> Birthday: </td>
                        <td>
                            <input type="text" class="form-control" id="datetimepicker" name="date" path="birthday"  style="margin-top: 3px"/>
                            <script type="text/javascript">
                                $(function () {
                                    $('#datetimepicker').datetimepicker({language: 'ru',pickTime:false, format:'YYYY-MM-DD'});
                                });
                            </script>
                        </td>
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
                        <td>E-mail:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="email" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Rating:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="rating" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Sold albums:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="countOfSales" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Studio:</td>
                        <td>
                            <form:select class="form-control" path="studio.name" id = "focusedInput" type = "text" cssStyle="margin-top: 3px">
                            <c:forEach items="${studios}" var="studio">
                                <option>${studio.name}</option>
                            </c:forEach>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>Category:</td>
                        <td>
                            <form:select class="form-control" path="category.name" id = "focusedInput" type = "text" cssStyle="margin-top: 3px">
                                <c:forEach items="${categories}" var="category">
                                    <option>${category.name}</option>
                                </c:forEach>
                            </form:select>
                        </td>
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

