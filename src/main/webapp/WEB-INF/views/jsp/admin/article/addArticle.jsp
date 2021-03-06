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

        <div div class="col-lg-10" align="center" style="margin-top:10px">
            <form:form method="post" cssStyle="margin-left: 150px">
                <table>

                    <tr>
                        <td>Author:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="author" cssStyle="width: 500px; margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="name" cssStyle="width: 500px; margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td> Date of release: </td>
                        <td>
                            <input type="text" class="form-control" id="datetimepicker" name="dateField" path="date"  style="margin-top: 3px"/>
                            <script type="text/javascript">
                                $(function () {
                                    $('#datetimepicker').datetimepicker({language: 'en',pickTime:false, format:'YYYY-MM-DD'});
                                });
                            </script>
                        </td>
                    </tr>

                    <tr>
                        <td>Main text:</td>
                        <td><form:textarea class="form-control" rows="5" id="comment" path="article"  cssStyle="margin-top: 3px"></form:textarea></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-info btn-block"
                                   value="Create" style="margin-top: 15px;
                                   background-color: #337AB7;border-color: #337AB7"/>
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

