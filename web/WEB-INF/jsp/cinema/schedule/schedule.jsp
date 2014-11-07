<%--
  Created by IntelliJ IDEA.
  User: sheng
  Date: 2014/11/3
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        div.pushWebsite {
            background: #F6F6F6;
        }
    </style>

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme-change-size.css">
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
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTab">
                <li role="presentation" class="<s:property value="dayType==0?'active':''"/> "><a href="?"><s:property value="#today"/> </a></li>
                <li role="presentation" class="<s:property value="dayType==1?'active':''"/> "><a href="?dayType=1"><s:property value="#tom"/></a></li>
                <li role="presentation" class="<s:property value="dayType==2?'active':''"/> "><a href="?dayType=2"><s:property value="#after_tom"/></a></li>
                <li class="pull-right">
                    <button class="btn btn-info" type="button" id="addMovieBtn">增加电影排期</button>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <%--今天--%>
                <div role="tabpanel" class="tab-pane active" id="today">
                    <%--在此排期--%>
                    <div class="container-fluid scheduleContent">
                        <%--这里是一个电影的排期--%>
                        <div class="row-fluid list-group-item div-margin movieTimeDiv">
                            <s:form cssClass="form-group"  method="POST" action="publishSchedule" namespace="/cinema/manage/schedule">
                                <div class="span12 clearfix">
                                    <div class="div-margin">
                                        <strong>电影名:</strong>
                                        <input type="hidden" name="showTime" value="<s:property value="#baseDate"/> ">
                                        <select name="movieId" class="selectize-select" style="width: 100px">
                                            <s:iterator value="movies">
                                                <option value="<s:property value="id"/>"><s:property value="name"/></option>
                                            </s:iterator>
                                        </select>
                                        <button class="btn btn-default pull-right  btn-group removeMovieTimeBtn"  type="button">撤销放映时间</button>
                                        <button class="btn btn-default pull-right  btn-group addMovieTimeBtn"  type="button">添加放映时间</button>
                                    </div>
                                    <table class="table table-striped" id="table1-1">
                                        <thead class="row">
                                        <tr>
                                            <th class="col-lg-4">
                                                放映时间<small class="text-danger">（格式为: 16:40）</small>
                                            </th>
                                            <th class="col-lg-4">
                                                放映厅 <small class="text-danger">(请选择)</small>
                                            </th>
                                            <th class="col-lg-4">
                                                票价 <small class="text-danger">(格式为: 27.00)</small>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody class="row">
                                        <tr id="cloneTr">
                                            <td class="col-lg-4">
                                                <input type="text" name="times" class="form-control" required="true"/>
                                            </td>
                                            <td class="col-lg-4">
                                                <select name="hallIds" class="selectize-select form-control">
                                                    <s:iterator value="halls">
                                                        <option value="<s:property value="id"/>"><s:property value="number"/>号厅</option>
                                                    </s:iterator>
                                                </select>
                                            </td>
                                            <td class="col-lg-4">
                                                <input type="text" name="prices" class="form-control"/>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <button class="btn btn-danger pull-right removeMovieBtn" type="button">删除排期</button>
                                    <%--<button class="btn btn-success pull-right confirmMovieTimeBtn" type="submit">确认排期</button>--%>
                                    <button class="btn btn-success" type="submit">确认排期</button>
                                </div>
                            </s:form>
                        </div>


                    </div>
                    <%--已经发布的排期--%>
                        <div class="container-fluid">
                            <%--这里是一个电影的排期--%>
                                <div class="row-fluid list-group-item div-margin pushWebsite">
                                    <div class="span12 clearfix">
                                        <h3 class="h3"><strong>超体</strong></h3>
                                        <table class="table">
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
                                                    20:40
                                                </td>
                                                <td class="col-lg-4">
                                                    6号厅
                                                </td>
                                                <td class="col-lg-4">
                                                    27.00
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="col-lg-4">
                                                    20:40
                                                </td>
                                                <td class="col-lg-4">
                                                    6号厅
                                                </td>
                                                <td class="col-lg-4">
                                                    27.00
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/twitter-bootstrap-hover-dropdown.min.js"></script>
<script>
    $(function () {
        //初始化div模版
        var movieTimeDiv = $(".movieTimeDiv").eq(0).parent().html();

        //标签页切换
        $('#myTab a:first').tab('show');

        //添加删除放映时间
        $(document).on("click", ".addMovieTimeBtn", function(){
            var appendTbody = $(this).parents(".div-margin").find("tbody");
            appendTbody.append($("#cloneTr").clone().hide().fadeIn());
        })
        $(document).on("click", ".removeMovieTimeBtn",function(){
            var appendTbody = $(this).parents(".div-margin").find("tbody");
            appendTbody.children("tr").length !== 1 && appendTbody.children("tr:last").remove();
        })

        //添加电影排期
        $("#addMovieBtn").bind("click",function(){
            //保存一个电影排期模版
            $(".scheduleContent").prepend(movieTimeDiv);//增加到最前面
        });
        //删除电影排期
        $(document).on("click", ".removeMovieBtn",function(){
            var movieDiv = $(this).parents(".movieTimeDiv");
            movieDiv.length >= 1 && movieDiv.remove();
        });
        //发布排期
        $(document).on("click",".confirmMovieTimeBtn", function(event){
            event.preventDefault();
            var form = $(this).parents(".div-margin");
            if(confirm("是否确认发布排期？")){
                if($(this).parents(".div-margin").find("input").val() == ""){
                    alert("表单不能为空！请确认");
                    return false;
                }
                form.remove();
            }else{
                return false;
            }
        })

    })
</script>
</body>
</html>


