<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/9/16
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="/admin/artist-main-page" class="list-group-item active">
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
            <h3>Artist main page</h3>
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
