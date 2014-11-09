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
    <%@include file="/WEB-INF/jsp/customer/user/public/menu.jsp"%>
    <div class="rightContent fr clearfix">



    </div>
</div>

<div class="footer">
    <div class="content"></div>
</div>
<script  type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jaDcSl7r2ArKTbGYn4lGZUcQ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/userInfo.js"></script>
</body>
</html>
