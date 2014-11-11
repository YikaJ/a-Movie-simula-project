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
            <input id="nick"  type="text" disabled="disabled" class="textInput" value="<s:property value="#user.nick"/> "/>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">生日</label>
            <div class="selectInput">
                <s:if test="#user.birthday != null">
                    <select name="year" id="year">
                            <option value="<s:date name="#user.birthday" format="yyyy"/>"><s:date name="#user.birthday" format="yyyy"/></option>
                    </select>
                    <select name="month" id="month">
                            <option value="<s:date name="#user.birthday" format="MM"/>"><s:date name="#user.birthday" format="MM"/></option>
                    </select>
                    <select name="date" id="date">
                            <option value="<s:date name="#user.birthday" format="dd"/>"><s:date name="#user.birthday" format="dd"/></option>
                    </select>
                </s:if>
                <s:else>
                    <select name="year" id="year">
                            <option value="none">出生年份</option>
                    </select>
                    <select name="month" id="month">
                            <option value="none">出生年份</option>
                    </select>
                    <select name="date" id="date">
                            <option value="none">出生年份</option>
                    </select>
                </s:else>
            </div>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">性别</label>
            <span class="radioInput">男<input  name="sex" type="radio" value="true" <s:property value="#user.gender==true?'checked':''"/>/></span>
            <span class="radioInput">女<input  name="sex" type="radio" value="false" <s:property value="#user.gender==false?'checked':''"/>/></span>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">所在城市</label>
            <div class="selectInput">
                <s:if test="#user.district==null">
                    <select name="province" id="province">
                        <option value="none">请选择省份</option>
                    </select>
                    <select name="city" id="city">
                        <option value="none">请选择城市</option>
                    </select>
                    <select name="district" id="district">
                        <option value="none">请选择县区</option>
                    </select>
                </s:if>
                <s:else>
                    <select name="province" id="province">
                        <option value="<s:property value="#user.district.city.province.name"/>"><s:property value="#user.district.city.province.name"/></option>
                    </select>
                    <select name="city" id="city">
                        <option value="<s:property value="#user.district.city.name"/>"><s:property value="#user.district.city.name"/></option>
                    </select>
                    <select name="district" id="district">
                        <option value="<s:property value="#user.district.name"/>"><s:property value="#user.district.name"/></option>
                    </select>
                </s:else>

            </div>
            <span class="inputError"></span>
        </div>
        <div class="formGroup">
            <label for="nick">个性签名</label>
            <textarea  name="aboutMe"  class="textareaInput" rows="5" cols="43"><s:property value="signature==null?'这位童鞋很懒，什么也没有留下～～！':signature"/></textarea>
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
