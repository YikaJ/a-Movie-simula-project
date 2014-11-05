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
        div.confirmMovieTime{
            background: #F5F5F5;
        }
        .confirmMovieTime  .btn-hidden{
            display: none;
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
        <%@include file="/WEB-INF/jsp/cinema/public/menu.jsp"%>

        <!-- content -->

        <div class="col-md-10">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTab">
                <li role="presentation" class="active"><a href="#today" role="tab" data-toggle="tab">11-5星期三</a></li>
                <li role="presentation"><a href="#tomorrow" role="tab" data-toggle="tab">11-6星期四</a></li>
                <li role="presentation"><a href="#theDayAfterTorrow" role="tab" data-toggle="tab">11-7星期五</a></li>
                <li class="pull-right">
                    <button class="btn btn-info" type="button">增加电影排期</button>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <%--今天--%>
                <div role="tabpanel" class="tab-pane active" id="today">
                    <div class="container-fluid">
                        <div class="row-fluid list-group-item div-margin">
                            <form class="form-group"  method="POST" action="#">
                                <div class="span12 clearfix">
                                    <div class="div-margin">
                                        <strong>电影名:</strong>
                                        <select name="name" class="selectize-select" style="width: 100px">
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                        </select>
                                        <button class="btn btn-default pull-right  btn-group addMovieTimeBtn" type="button">添加放映时间</button>
                                    </div>
                                    <table class="table table-striped" id="table1-1">
                                        <thead class="row">
                                        <tr>
                                            <th class="col-lg-4">
                                                上映时间
                                            </th>
                                            <th class="col-lg-4">
                                                放映厅
                                            </th>
                                            <th class="col-lg-4">
                                                票价
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody class="row">
                                        <tr>
                                            <td class="col-lg-4">
                                                <input type="text" class="form-control"/>
                                            </td>
                                            <td class="col-lg-4">
                                                <select name="name" class="selectize-select form-control">
                                                    <option value="1">1号厅</option>
                                                    <option value="2">2号厅</option>
                                                    <option value="3">3号厅</option>
                                                    <option value="4">4号厅</option>
                                                    <option value="5">5号厅</option>
                                                </select>
                                            </td>
                                            <td class="col-lg-4">
                                                <input type="text" class="form-control"/>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <div class="col-lg-offset-9">
                                        <button class="btn btn-success btn-group confirmBtn" type="button">确认排期</button>
                                        <button class="btn btn-danger btn-group" type="button">删除排期</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <%--新电影--%>
                        <div class="row-fluid list-group-item div-margin confirmMovieTime">
                            <form class="form-group"  method="POST" action="#">
                                <div class="span12 clearfix">
                                    <div class="div-margin">
                                        <strong>电影名:</strong>
                                        <select name="name" class="selectize-select" style="width: 100px" disabled="disabled">
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                            <option value="超体">超体</option>
                                        </select>
                                        <button class="btn btn-default pull-right  btn-group btn-hidden" type="button">添加放映时间</button>
                                    </div>
                                    <table class="table  table-striped" id="table1-2">
                                        <thead class="row">
                                        <tr>
                                            <th class="col-lg-4">
                                                放映时间
                                            </th>
                                            <th class="col-lg-4">
                                                放映厅
                                            </th>
                                            <th class="col-lg-4">
                                                票价
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody class="row">
                                        <tr>
                                            <td class="col-lg-4">
                                                <input type="text" class="form-control" value="12:30" disabled="disabled">
                                            </td>
                                            <td class="col-lg-4">
                                                <select name="name" class="selectize-select form-control" disabled>
                                                    <option value="1">1号厅</option>
                                                    <option value="2">2号厅</option>
                                                    <option value="3">3号厅</option>
                                                    <option value="4">4号厅</option>
                                                    <option value="5">5号厅</option>
                                                </select>
                                            </td>
                                            <td class="col-lg-4">
                                                <input type="text" class="form-control" value="27.00" disabled="disabled">
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <div class="col-lg-offset-9">
                                        <button class="btn btn-success btn-group btn-hidden" type="button">确认排期</button>
                                        <button class="btn btn-danger btn-group btn-hidden" type="button">删除排期</button>
                                    </div>
                                </div>
                            </form>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-admin-theme-change-size.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/selectize/dist/js/standalone/selectize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/javascripts/bootstrap-wysihtml5/wysihtml5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/javascripts/bootstrap-wysihtml5/core-b3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/twitter-bootstrap-wizard/jquery.bootstrap.wizard-for.bootstrap3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/boostrap3-typeahead/bootstrap3-typeahead.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mindmup-editabletable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/numeric-input-example.js"></script>
<script>
    $(function () {
        var addMovieTimeBtn  = $(".addMovieTimeBtn");
        //标签页切换
        $('#myTab a:first').tab('show');
        //发布排期
        $(".confirmBtn").click(function(){
            var form = $(this).parents(".div-margin");
            if(confirm("是否确认发布排期？")){
                form.addClass("confirmMovieTime").find("button").remove();
                form.find("select").removeAttr("disabled");
                form.find("input").removeAttr("disabled");
            }else{
                return false;
            }
        })
        //添加新的放映时间
        addMovieTimeBtn.click(function(){
            var appendTbody = $(this).parents(".div-margin").find("tbody");
            var newMovieTime =
            newMovieTime.appendTo(appendTbody);
        })
    })
</script>
</body>
</html>


