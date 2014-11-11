<%--
  Created by IntelliJ IDEA.
  User: sheng
  Date: 2014/11/3
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" media="screen" href="../css/public/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="../css/public/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="../css/public/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="../css/public/bootstrap-admin-theme-change-size.css">

    <!-- Vendors -->
    <link rel="stylesheet" media="screen" href="../vendors/bootstrap-datepicker/css/datepicker.css">
    <link rel="stylesheet" media="screen" href="../css/manage/datepicker.fixes.css">
    <link rel="stylesheet" media="screen" href="../vendors/uniform/themes/default/css/uniform.default.min.css">
    <link rel="stylesheet" media="screen" href="../css/public/uniform.default.fixes.css">
    <link rel="stylesheet" media="screen" href="../vendors/chosen.min.css">
    <link rel="stylesheet" media="screen" href="../vendors/selectize/dist/css/selectize.bootstrap3.css">
    <link rel="stylesheet" media="screen" href="../vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/stylesheets/bootstrap-wysihtml5/core-b3.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../js/html5shiv.js"></script>
    <script type="text/javascript" src="../js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-with-small-navbar">
<!-- small navbar -->
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar-sm" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">链接</a></li>
                        <li><a href="#">链接</a></li>
                        <li>
                            <a href="#">提醒 <i class="glyphicon glyphicon-bell"></i></a>
                        </li>
                        <li>
                            <a href="#">设置 <i class="glyphicon glyphicon-cog"></i></a>
                        </li>
                        <li>
                            <a href="#">前往前端 <i class="glyphicon glyphicon-share-alt"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i> 用户名 <i class="caret"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">行为</a></li>
                                <li><a href="#">另一个行为</a></li>
                                <li><a href="#">其它东西</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="BE-index.jsp">注销用户</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>

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
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li class="active">
                    <a href="forms.html"><i class="glyphicon glyphicon-chevron-right"></i> 上映电影</a>
                </li>
                <li>
                    <a href="tables.html"><i class="glyphicon glyphicon-chevron-right"></i> 排期管理</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 影厅管理</a>
                </li>
                <li>
                    <a href="BE-movie.jsp"><i class="glyphicon glyphicon-chevron-right"></i> 订单管理</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 信息管理</a>
                </li>
            </ul>
        </div>

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

                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row div-margin">
                                <div class="col-lg-3">
                                    <img src="../image/movieInformation1.jpg" data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" style="width: 215px; height: 330px;">
                                </div>
                                <div class="col-lg-9">
                                    <ul class="list-group list-unstyled list-margin">
                                        <li>
                                            <h3 class="h3">超体</h3>
                                        </li>
                                        <li>导演：<span>吕克·贝松</span></li>
                                        <li>主演：<span>斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</span></li>
                                        <li>类型：<span>3D,IMAX</span></li>
                                        <li>地区：<span>中国大陆,法国</span></li>
                                        <li>语言：<span>英语|法语</span></li>
                                        <li>片长：<span>90分钟</span></li>
                                        <li><button type="button" class="btn btn-success">进入排期</button></li>
                                    </ul>
                                </div>
                            </div>
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

<script type="text/javascript" src="../js/cinema/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/cinema/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/cinema/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-admin-theme-change-size.js"></script>
<script type="text/javascript" src="../vendors/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../vendors/chosen.jquery.min.js"></script>
<script type="text/javascript" src="../vendors/selectize/dist/js/standalone/selectize.min.js"></script>
<script type="text/javascript" src="../vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="../vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/javascripts/bootstrap-wysihtml5/wysihtml5.js"></script>
<script type="text/javascript" src="../vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/javascripts/bootstrap-wysihtml5/core-b3.js"></script>
<script type="text/javascript" src="../vendors/twitter-bootstrap-wizard/jquery.bootstrap.wizard-for.bootstrap3.js"></script>
<script type="text/javascript" src="../vendors/boostrap3-typeahead/bootstrap3-typeahead.min.js"></script>
</body>
</html>


