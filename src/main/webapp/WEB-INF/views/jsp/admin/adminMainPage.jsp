<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/4/16
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Final//EN">
<html lang="en">

<head>
    <link  rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href=“/resources/css/bootstrap.min.css”>

<%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>


</head>
<body>
<h3>Hello, dear administrator</h3>
<a class="btn btn-info" style="margin: 2px" href="/admin/find-artist-by-id">Find artist</a><br>
<a class="btn btn-info" style="margin: 2px" href="/admin/delete-artist">Delete artist</a><br>
<a class="btn btn-info" href="/admin/add-artist">You can add artist, if click here!</a><br>
<a class="btn btn-info" href="/admin/update-artist">You can update artist, if click here!</a><br>
<br>
<a class="btn btn-info" href="/admin/find-album-by-id" role="link">You can find album, if click here!</a><br>
<a class="btn btn-info" href="/admin/delete-album">You can delete album, if click here!</a><br>
<a class="btn btn-info" href="/admin/add-album">You can add album, if click here!</a><br>
<a class="btn btn-info" href="/admin/update-album">You can update album, if click here!</a><br>
<br>
<a class="btn btn-info" href="/admin/find-studio-by-id">You can find studio, if click here!</a><br>
<a class="btn btn-info" href="/admin/delete-studio">You can delete studio, if click here!</a><br>
<a class="btn btn-info" href="/admin/add-studio" role="button">You can add studio, if click here!</a><br>
<a class="btn btn-info"  href="/admin/update-studio">You can update studio, if click here!</a><br>
</body>
</html>
