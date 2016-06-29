<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 4/24/16
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>

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

<%--style.html {
background: url(images/bg.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}--%>

<div id="bg">
    <img src="/resources/img/music_shop_background_1.jpg">
</div>
<!-- Navigation -->
<div class="row">
    <div class="col-lg-12">
        <div class="page-header">
            <div class="col-lg-4" style="margin-top: 15px; margin-bottom: 15px" >
                <img src="/resources/img/corso-musica.png" class="img-rounded" align="center" width="300" height="100" >
            </div>
            <div class="col-lg-5">
                <h1>Music for life
                    <small>A lot of music for you!</small>
                </h1>
            </div>

            <div class="col-lg-3">
                <div class="btn-group btn-group-lg">
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <a type="button" class="btn btn-default" href="/admin/artist-main-page">Admin</a>
                    </security:authorize>
                    <a type="button" class="btn btn-default" href="/logout">Logout</a>
                </div>
            </div>
        </div>
       <%-- <p>
            Here you can find your favorite artist and music!
            Enjoy it!
        </p>--%>
    </div>
</div>

<div class="raw">
    <div class="col-md-12">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">MainPage</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">New's</a></li>
                    <li><a href="#">Studios</a></li>
                    <li><a href="#">Artists</a></li>
                    <li><a href="#">Albums</a></li>
                    <li><a href="#">About us</a></li>
                </ul>
            </div>


            <div>
                <form class="navbar-form navbar-right" role="search" style="margin-right: 20px">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </nav>

    </div>
</div>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-1">
        </div>

        <div class="col-lg-12">
            <div class="row carousel-holder">
            </div>
            <div class="row">
<%--repeat this section for nine times--%>
                <c:forEach items="${page.albums}" var="album">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <img src="<c:out value="${album.httpPathToAlbumsCover}"/>" alt="<c:out value="${album.name}"/>">
                            <div class="caption">
                                <h4><a href="#"><c:out value="${album.artist.name}"/></a></h4>
                                <h4><a href="#"><c:out value="${album.name}"/></a></h4>
                                <p><c:out value="${album.shortDescription}"/></p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
<%-------------------------------------%>
            </div>

            <div class="panel-footer">
                <div class="row">
                    <div class="col col-xs-4">Page ${page.currentPage} of ${page.lastPage}</div>
                    <div class="col col-xs-8">
                        <ul class="pagination hidden-xs pull-right">

                            <c:if test="${page.currentPage!=1}">
                                <li><a href="/user/album-page-${page.currentPage-1}" > << </a></li>
                            </c:if>
                            <c:forEach items="${page.valueButtonsInPagination}" var="p" >
                                <c:if test="${ !(p.equalsIgnoreCase('..')) && p.equalsIgnoreCase(page.currentPage.toString())}">
                                    <li class="active"><a href="/admin/album-page-${p}" ><c:out value="${p}"/></a></li>
                                </c:if>

                                <c:if test="${ !(p.equalsIgnoreCase('..')) && !(p.equalsIgnoreCase(page.currentPage.toString()))}">
                                    <li><a href="/admin/album-page-${p}" ><c:out value="${p}"/></a></li>
                                </c:if>

                                <c:if test="${ p.equalsIgnoreCase('..')}">
                                    <li><a ><c:out value="${p}"/></a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${page.currentPage!=page.lastPage}">
                                <li><a href="/admin/album-page-${page.currentPage+1}" > >> </a></li>
                            </c:if>

                        </ul>
                    </div>
                </div>
            </div>

        <div class="col-lg-1">
        </div>
    </div>
</div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
</body>
</html>