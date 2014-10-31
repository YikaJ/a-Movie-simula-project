<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>爆米花影院列表</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cinemaList.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
<div class="header">
    <div class="loginRegister">
        <a href="#">YikaJ</a> | <a href="javascript:" id="register">我的<i class="icon"></i></a>
        <ul class="userList">
            <li><a href="#">个人资料</a></li>
            <li><a href="#">我的订单</a></li>
            <li><a href="#">我的积分</a></li>
            <li><a href="#">消息中心</a></li>
        </ul>
    </div>
    <div class="content">
        <h1 class="logo">
            <a href="../WEB-INF/jsp/home/index.jsp">想映电影院</a>
        </h1>
        <ul class="nav">
            <li><a href="../WEB-INF/jsp/home/index.jsp">首页</a></li>
            <li><a href="../WEB-INF/jsp/movie/movieList.jsp">电影</a></li>
            <li class="currentLi"><a href="#">影院</a></li>
            <li><a href="#">发现</a></li>
        </ul>
    </div>
</div>




<div class="footer">
    <div class="content"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js" data-main="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>