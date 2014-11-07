<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-11-6
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人设置</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userInfo.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
<div class="content  clearfix infoContent">
    <ul class="leftContent fl">
        <li><a href="javascript:">个人资料</a></li>
        <li><a href="javascript:"  class="activeLi">头像设置</a></li>
        <li><a href="javascript:">修改密码</a></li>
        <li><a href="javascript:">我的订单</a></li>
    </ul>
    <div class="rightContent fr">

    </div>
</div>

<div class="footer">
    <div class="content"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/userInfoMain.js"></script>
</body>
</html>
