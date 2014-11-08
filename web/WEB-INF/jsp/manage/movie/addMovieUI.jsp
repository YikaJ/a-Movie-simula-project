<%--
  Created by IntelliJ IDEA.
  User: sheng
  Date: 2014/11/3
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>爆米花后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/vendors/bootstrap-wysihtml5-rails-b3/vendor/assets/stylesheets/bootstrap-wysihtml5/core-b3.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
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
                    <a class="navbar-brand" href="BE-homepage.jsp"><strong>爆米花后台管理系统</strong></a>
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
                <li>
                    <a href="forms.html"><i class="glyphicon glyphicon-chevron-right"></i> 系统管理</a>
                </li>
                <li>
                    <a href="tables.html"><i class="glyphicon glyphicon-chevron-right"></i> 会员管理</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 电影管理</a>
                </li>
                <li class="active">
                    <a href="BE-movie.jsp"><i class="glyphicon glyphicon-chevron-right"></i> 影院管理</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 公共信息</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 分类管理</a>
                </li>
                <li>
                    <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 数据统计</a>
                </li>
            </ul>
        </div>

        <!-- content -->
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>电影</h1>
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
                            <s:form cssClass="form-horizontal" action="publishMovie" namespace="/manage/movie">
                                <fieldset>
                                    <legend>上传电影</legend>
                                    <div class="col-lg-12 col-lg-offset-2">
                                        <img  data-src="holder.js/100%x180" alt="缩略图" class="thumbnail" id="posterPreview" style="width: 215px; height: 330px;">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="posterInput">电影海报</label>
                                        <div class="col-lg-5">
                                            <input class="form-control uniform_on" id="posterInput" type="file" name="_img"/>
                                            <input type="hidden" id="posterURL" name="poster"/>
                                            <p class="help-block text-danger">图片大小为：215px330px</p>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="movieTitle">电影名字 </label>
                                        <div class="col-lg-10">
                                            <input type="text" name="name" class="form-control col-md-6" id="movieTitle" autocomplete="off" data-provide="typeahead" data-items="4" />
                                            <p class="help-block text-danger">不用书名号括起来《》</p>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="director">导演 </label>
                                        <div class="col-lg-10">
                                            <input type="text" name="director" class="form-control col-md-6" id="director" autocomplete="off" data-provide="typeahead" data-items="4">
                                            <p class="help-block text-danger">导演</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="mainRole">主演 </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control col-md-6" name="mainRole" id="mainRole" autocomplete="off" data-provide="typeahead" data-items="4"/>
                                            <p class="help-block text-danger">人名用逗号隔开</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">类型</label>
                                        <div class="col-lg-10">
                                            <label class="uniform">
                                                <s:checkboxlist list="#movieType" name="type" listKey="id" listValue="name" cssClass="uniform_on"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">版本</label>
                                        <div class="col-lg-10">
                                            <label class="uniform">
                                                <s:checkboxlist list="#movieVersion" name="version" listValue="name" listKey="id" cssClass="uniform_on"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="region">地区 </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control col-md-6" name="region" id="region" autocomplete="off" data-provide="typeahead" data-items="4" />
                                            <p class="help-block text-danger">地名用逗号隔开</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="language">语言 </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control col-md-6" name="language" id="language" autocomplete="off" data-provide="typeahead" data-items="4">
                                            <p class="help-block text-danger">语言用分割号隔开（普通话|法语）</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="filmTime">片长 </label>
                                        <div class="col-lg-10">
                                            <input type="number" min="1" class="form-control col-md-6" name="filmTime" id="filmTime" autocomplete="off" data-provide="typeahead" data-items="4" />
                                            <p class="help-block text-danger">90</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="date01">上映时间</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="showTime" class="form-control datepicker" id="date01" readonly value="2014-11-05">
                                            <p class="help-block text-danger">请选择</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" for="introduce">剧情介绍 </label>
                                        <div class="col-lg-10">
                                            <textarea class="form-control col-md-6" name="introduce" id="introduce" data-provide="typeahead" data-items="4"></textarea>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">上传</button>
                                    <button type="reset" class="btn btn-default">重置</button>
                                </fieldset>
                            </s:form>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/uniform/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/ajaxfileupload.js"></script>
<script type="text/javascript">
    $(function() {
        $('.datepicker').datepicker();
        $('.uniform_on').uniform();
        $('.chzn-select').chosen();
        $(document).on("change", "#posterInput", function(){
                $.ajaxFileUpload ( {
                    url: '/support/uploadImage.do', //用于文件上传的服务器端请求地址
                    secureuri : false, //是否需要安全协议，一般设置为false
                    fileElementId: 'posterInput', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data){  //服务器成功响应处理函数
                        if(data.response){
                            $("#posterPreview").attr("src", data.msg);
                            $("#posterURL").val(data.msg);
                            //改变上传文件的名字
                            $("#posterInput").change(function(){
                                var text = $(this).val();
                                $(".filename").text(text);
                            });
                        }else{
                            alert(data.msg);
                        }
                    },
                    error: function (data, status, e){//服务器响应失败处理函数
                        alert(e);
                    }
                });
                return false;
        });

    });
</script>
</body>
</html>


