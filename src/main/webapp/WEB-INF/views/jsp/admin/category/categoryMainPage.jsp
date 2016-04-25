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
                            <a href="/admin/add-category" type="button" class="btn btn-sm btn-primary btn-create">Create New</a>
                        </div>
                        <div class="col-lg-1">
                            <a href="/admin/category-main-page" type="button" class="btn btn-sm btn-primary btn-success" style="margin-left: 5px"><span class="glyphicon glyphicon-arrow-up"></span></a>
                        </div>


                        <div class="col-lg-7">
                            <p ><h4 align="center"> Categories </h4></p>
                        </div>

                        <div class="col-lg-3">
                             <span class="span12">
                                <form id="custom-search-form" method="post" class="form-search form-horizontal pull-right" action="/admin/find-album-by-id">
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
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${categories}" var="category">
                                <tr>
                                    <td align="center"  style="width: 150px">
                                        <a href="/admin/update-category/${category.id}" class="btn btn-default">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </a>
                                        <a href="/admin/delete-category/${category.id}" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </a>
                                    </td>
                                    <td><c:out value="${category.id}" /></td>
                                    <td><c:out value="${category.name}" /></td>
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