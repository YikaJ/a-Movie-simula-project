<%--
  Created by IntelliJ IDEA.
  User: sheng
  Date: 2014/11/3
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>爆米花后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .div-margin, .list-margin li{
            margin: 18px 0;
        }
    </style>

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme-change-size.css">

    <!-- Vendors -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/bootstrap-datepicker/css/datepicker.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/datepicker.fixes.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/uniform/themes/default/css/uniform.default.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/uniform.default.fixes.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/chosen.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/selectize/dist/css/selectize.bootstrap3.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/stylesheets/bootstrap-wysihtml5/core-b3.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-with-small-navbar">
<!-- small navbar -->
<%@include file="/WEB-INF/jsp/cinema/public/head.jsp"%>

<!-- main / large navbar -->
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <a class="navbar-brand" href="cinema-BE.jsp"><strong>爆米花●影院后台管理系统</strong></a>
                </div>
            </div>
        </div>
    </div><!-- /.container -->
</nav>

<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
        <!-- left, vertical navbar -->
        <%@include file="/WEB-INF/jsp/cinema/public/menu.jsp"%>

        <!-- content -->
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>上映电影</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default bootstrap-admin-no-table-panel">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">电影详情</div>
                        </div>
                        <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                            <s:iterator value="#newMovie.recordList">
                                <div class="row div-margin">
                                    <div class="col-lg-3">
                                        <img src="${pageContext.request.contextPath}<s:property value="poster"/> " data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                    </div>
                                    <div class="col-lg-9">
                                        <ul class="list-group list-unstyled list-margin">
                                            <li>
                                                <h3 class="h3"><s:property value="name"/> </h3>
                                            </li>
                                            <li>导演：<span><s:property value="director"/> </span></li>
                                            <li>主演：<span><s:property value="mainRole"/> </span></li>
                                            <li>类型：<span><s:iterator value="movieTypes"><s:property value="name"/>&nbsp;</s:iterator></span></li>
                                            <li>地区：<span><s:property value="region"/></span></li>
                                            <li>语言：<span><s:property value="language"/></span></li>
                                            <li>片长：<span><s:property value="filmTime"/>分钟</span></li>
                                            <li>上映时间：<span><s:date name="showTime" format="yyyy-MM-dd"/>  </span></li>
                                            <li><button type="button" class="btn btn-success">进入排期</button></li>
                                        </ul>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- footer -->
<div class="navbar navbar-footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <footer role="contentinfo">
                    <p class="left">Bootstrap 3.x Admin Theme</p>
                    <p class="right">&copy; 2013 <a href="http://www.meritoo.pl" target="_blank">Meritoo.pl</a></p>
                </footer>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/twitter-bootstrap-hover-dropdown.min.js"></script>
</body>
</html>


