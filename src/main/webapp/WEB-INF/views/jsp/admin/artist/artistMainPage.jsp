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
    <div div class="col-lg-1" style="margin-top:10px">

    </div>

    <div class="raw">
        <div class="col-lg-10" style="margin-top:10px">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-lg-1">
                            <a href="/admin/add-artist" type="button" class="btn btn-sm btn-primary btn-create">Create New</a>
                        </div>
                        <div class="col-lg-1">
                            <a href="/admin/artist-main-page" type="button" class="btn btn-sm btn-primary btn-success"><span class="glyphicon glyphicon-arrow-up"></span></a>
                        </div>
                        <div class="col-lg-7">
                        </div>

                        <div class="col-lg-3">
                             <span class="span12">
                                <form id="custom-search-form" method="post" class="form-search form-horizontal pull-right" action="/admin/find-artist-by-id">
                                    <span class="input-append span12">
                                        <input type="text" placeholder="Search" name="id" />
                                        <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>
                                    </span>
                                </form>
                            </span>
                        </div>
                    </div>
                </div>
                <table  class ="table table-bordered" cellpadding="5" align="centr" >
                    <thead>
                    <tr>
                        <th><span class="glyphicon glyphicon-cog"></span></th>
                        <th class="hidden-xs">ID</th>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Category</th>
                        <th>Studio</th>
                        <th>Birthday</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${artists}" var="artist">
                        <tr>
                            <td align="center"  style="width: 150px">
                                <a href="/admin/update-artist/${artist.id}" class="btn btn-default">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                <a href="/admin/delete-artist/${artist.id}" class="btn btn-danger">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                            <td><c:out value="${artist.id}" /></td>
                            <td><c:out value="${artist.name}" /></td>
                            <td><c:out value="${artist.address.country}" /></td>
                            <td><c:out value="${artist.category.name}" /></td>
                            <td><c:out value="${artist.studio.name}" /></td>
                            <td><c:out value="${artist.birthday}" /></td>
                            <td><c:out value="${artist.email}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col col-xs-4">Page 1 of 5
                    </div>
                    <div class="col col-xs-8">
                        <ul class="pagination hidden-xs pull-right">
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                        </ul>
                        <ul class="pagination visible-xs pull-right">
                            <li><a href="#">«</a></li>
                            <li><a href="#">»</a></li>
                        </ul>
                    </div>
                </div>
            </div>
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