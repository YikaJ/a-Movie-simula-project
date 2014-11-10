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
        <h2>个人资料</h2>
        <form>
        <div class="formGroup">
            <label for="nick">昵称</label>
            <input id="nick" name="nick" type="text" disabled="disabled" class="textInput" value="handoop-Sb-teamLeader"/>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">生日</label>
            <div class="selectInput">
                <select name="provice">
                    <option value="none">出生年份</option>
                    <option value="none">1</option>
                    <option value="none">2</option>
                    <option value="none">3</option>
                    <option value="none">4</option>
                    <option value="none">5</option>
                </select>
                <select name="city">
                    <option value="none">出生月份</option>
                    <option value="none">1</option>
                    <option value="none">2</option>
                    <option value="none">3</option>
                    <option value="none">4</option>
                    <option value="none">5</option>
                </select>
                <select name="provice">
                    <option value="none">出生日期</option>
                    <option value="none">1</option>
                    <option value="none">2</option>
                    <option value="none">3</option>
                </select>
            </div>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">性别</label>
            <span class="radioInput">男<input  name="sex" type="radio" value="true"/></span>
            <span class="radioInput">女<input  name="sex" type="radio" value="false" checked /></span>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">所在城市</label>
            <div class="selectInput">
                <select name="provice" id="provice">
                    <option value="none">请选择省份</option>
                </select>
                <select name="city" id="city">
                    <option value="none">请选择城市</option>
                </select>
                <select name="district" id="district">
                    <option value="none">请选择县区</option>
                </select>
            </div>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">个性签名</label>
            <textarea  name="aboutMe"  class="textareaInput" rows="5" cols="43" />这位童鞋很懒，什么也没有留下～～！
            </textarea>
        </div>
            <a class="submitBtn" href="#"/>保存</a>
        </form>
    </div>
</div>

<div class="footer">
    <div class="content"></div>
</div>
<script  type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jaDcSl7r2ArKTbGYn4lGZUcQ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/userInfo.js"></script>
</body>
</html>
