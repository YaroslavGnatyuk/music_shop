<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/9/16
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>

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
            <li><a href="/admin/artist-main-page">Artist</a></li>
            <li><a href="/admin/studio-main-page">Studio</a></li>
            <li><a href="/admin/album-main-page">Album</a></li>
            <li><a href="/admin/category-main-page">Category</a></li>
            <li><a href="/login?logout">Exit</a></li>
        </ul>
    </div>
</div>

<div class="raw">
    <div div class="col-lg-1" style="margin-top:10px">
    </div>
    <div class="raw">

        <div div class="col-lg-8" style="margin-top:10px" align="center">
            <form:form method="post" cssStyle="margin-left: 150px" >
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="name" value="${command.name}" cssStyle="width: 500px;margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td> Date of release: </td>
                        <td>
                            <input type="text" class="form-control" id="datetimepicker" name="date" path="birthday" value="${command.releaseDate}" style="margin-top: 3px"/>
                            <script type="text/javascript">
                                $(function () {
                                    $('#datetimepicker').datetimepicker({language: 'en',pickTime:false, format:'YYYY-MM-DD'});
                                });
                            </script>
                        </td>
                    </tr>

                    <tr>
                        <td>Artist:</td>
                        <td>
                            <form:select class="form-control" path="artist.name" value="${command.artist.name}" id = "focusedInput" type = "text" cssStyle="margin-top: 3px">
                                <c:forEach items="${artists}" var="artist">
                                    <option>${artist.name}</option>
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>Studio:</td>
                        <td>
                            <form:select class="form-control" path="studio.name" id = "focusedInput" type = "text" cssStyle="margin-top: 3px">
                                <c:forEach items="${studios}" var="studio">
                                    <option  value="${command.studio.name}">${studio.name}</option>
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>Category:</td>
                        <td>
                            <form:select class="form-control" path="category.name" value="${command.category.name}" id = "focusedInput" type = "text" cssStyle="margin-top: 3px">
                                <c:forEach items="${categories}" var="category">
                                    <option>${category.name}</option>
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>Rating:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="rating" value="${command.rating}" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td>Sold albums:</td>
                        <td><form:input class = "form-control" id = "focusedInput" type = "text" path="countOfSales" value="${command.countOfSales}" cssStyle="margin-top: 3px"/></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn btn-info btn-block"
                                   value="Update album" style="margin-top: 15px;
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
