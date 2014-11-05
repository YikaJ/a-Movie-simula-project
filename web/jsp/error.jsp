<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-10-28
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="error-page">
<head>
    <title>404 error page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->


    <!-- Bootstrap Error Page -->
    <link rel="stylesheet" media="screen" href="css/bootstrap-error-page.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- content -->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-lg-12">
            <div class="centering text-center">
                <div class="text-center">
                    <h2 class="without-margin">哎呀！你需要的网页 <span class="text-success"><big>404</big></span> 啦！</h2>
                    <h4 class="text-success">找不到该网页</h4>
                </div>
                <div class="text-center">
                    <h3><small>点击按钮返回首页吧~</small></h3>
                </div>
                <hr>
                <ul class="pager">
                    <li><a href="about.html">&larr; 返回首页</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- footer -->
<div class="navbar navbar-footer navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <footer role="contentinfo">
                    <p class="left">爆米花网站</p>
                </footer>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
</body>
</html>
