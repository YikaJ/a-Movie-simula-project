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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.Jcrop.min.css">
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
    <div class="rightContent fr clearfix">
        <h2>请选择头像并上传</h2>
        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" id="target" alt="[Jcrop Example]" />
        <div id="preview-pane">
            <div class="preview-container">
                <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="jcrop-preview" alt="Preview" />
            </div>
        </div>
    </div>
        <form>
            <a href="javascript:0" class="selectImg">选择图片</a>
            <input id="file" class="selectInput" type="file" name="img" title="请选择图片">
        </form>
            <a href="#" class="uploadImg">保存头像</a>

</div>

<div class="footer">
    <div class="content"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/userInfoMain.js"></script>
</body>
</html>
