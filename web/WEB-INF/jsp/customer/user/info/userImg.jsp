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
    <title>用户头像</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/public/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/user/userImg.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/user/jquery.Jcrop.min.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
<div class="content  clearfix infoContent">
    <%@include file="/WEB-INF/jsp/customer/user/public/menu.jsp"%>
    <div class="rightContent fr clearfix">
        <h2>头像设置</h2>
        <div id="imgContent">
            <img src="" alt="上传你的头像"/>
        </div>
        <div class="previewContent">
            <div id="preview">
                <img src="<s:property value="#user.picture"/>" alt="预览"/>
            </div>
            <span class="tips"> 150*150头像 </span>
            <a href="javascript:" class="selectImg">选择图片</a>
            <input id="imgFile" class="selectInput" type="file" name="_img" title="请选择图片">
            <a href="javascript:" class="uploadImg" id="uploadImg">保存头像</a>
         </div>

    </div>
        <form id="imageShot" method="post" action="/support/imageShot.do">
            <input type="hidden" name="imgPath" id="imgPath">
            <input type="hidden" name="x" id="x">
            <input type="hidden" name="y" id="y">
            <input type="hidden" name="width" id="picWidth">
            <input type="hidden" name="height" id="picHeight">
        </form>


</div>

<div class="footer">
    <div class="content"></div>
</div>
<script  type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jaDcSl7r2ArKTbGYn4lGZUcQ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/userImgMain.js"></script>
</body>
</html>
