<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Final//EN">
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
            <div class="col-lg-4" style="margin-top: 15px; margin-bottom: 15px">
                <img src="/resources/img/corso-musica.jpg" class="img-rounded" align="center" width="300" height="100" >
            </div>
            <div class="col-lg-8">
                <h1>Music for life
                    <small>Administrator page</small>
                </h1>
            </div>
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
           <%-- <li><a href="/admin/artist-main-page">Artist</a></li>
            <li><a href="/admin/studio-main-page">Studio</a></li>
            <li><a href="/admin/album-main-page">Album</a></li>
            <li><a href="#">Store</a></li>--%>
        </ul>
    </div>
</div>

<div class="raw">
    <div div class="col-lg-2" style="margin-top:10px">
        <ul class="list-group">
            <a href="#" class="list-group-item active">
                Options
            </a>
            <a href="/admin/artist-main-page" class="list-group-item">Artist</a>
            <a href="/admin/studio-main-page" class="list-group-item">Studio</a>
            <a href="/admin/album-main-page" class="list-group-item">Album</a>
            <a href="/admin/category-main-page" class="list-group-item">Category</a>
            <a href="#" class="list-group-item">Store</a>
        </ul>

    </div>
    <div class="raw">

        <div div class="col-lg-8" style="margin-top:10px">
            <h3>Admin main page</h3>
            <div class="jumbotron" >
                <h1>Welcome to landing page!</h1>
                <p>This is an example for jumbotron.</p>
                <p><a class="btn btn-primary btn-lg" role="button">
                    Learn more</a>
                </p>
            </div>
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
