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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changPassword.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
<div class="content  clearfix infoContent">
    <%@include file="/WEB-INF/jsp/customer/user/public/menu.jsp"%>
    <div class="rightContent fr clearfix">
        <h2>修改密码</h2>
        <div class="changePasswordForm">
            <p  id="dataResponse"></p>
            <form action="#" method="post" id="changePassword">
                <div class="formGroup">
                    <label for="originPasswordInput">当前密码</label>
                    <input id="originPasswordInput" name="password" type="password" placeholder="请输入当前密码" class="passwordInput"/>
                    <span class="errorInput"></span>
                </div>
                <div class="formGroup">
                    <label for="newPasswordInput">新密码</label>
                    <input id="newPasswordInput" name="newPasswordInput" type="password" placeholder="请输入新密码" class="passwordInput"/>
                    <span class="errorInput"></span>
                </div>
                <div class="formGroup">
                    <label for="newPasswordInput2">确认密码</label>
                    <input id="newPasswordInput2" name="newPasswordInput2" type="password" placeholder="请输入新密码" class="passwordInput"/>
                    <span class="errorInput"></span>
                </div>
                <input id="submitBtn" class="submitBtn" href="javascript:" value="保存" type="submit">
                <input id="originPassword" name="originPassword" type="hidden"/>
                <input id="newPassword" name="newPassword" type="hidden"/>
            </form>
        </div>
    </div>
</div>

<div class="footer">
    <div class="content"></div>
</div>
<script  type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jaDcSl7r2ArKTbGYn4lGZUcQ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/changePasswordMain.js"></script>
</body>
</html>
