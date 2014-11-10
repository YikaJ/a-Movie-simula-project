<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-10-29
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="header">
    <div class="loginRegister clearfix" id="loginRegister">
        <s:if test="#session.user==null">
                <a href="javascript:" id="login" class="topBarLeft">登录</a><span class="little">|</span><a href="javascript:" id="register" class="topBarRight">注册</a>
        </s:if>
        <s:else>
            <a href="#" class="loginLeft clearfix"><i class="icon"></i><span><s:property value="#session.user.nick"/></span></a>
            <ul class="userList" id="myList">
                <li><a href="${pageContext.request.contextPath}/user/userInfo.do">个人资料</a></li>
                <li><a href="#">我的订单</a></li>
                <li><a href="#">消息中心</a></li>
                <li><a href="${pageContext.request.contextPath}/user/loginOff.do">退出</a></li>
            </ul>
        </s:else>
    </div>
    <div class="content">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/">想映电影院 <s:property value="#session.currentSpace.name"/></a>
        </div>
        <div id="mapLocation">
            <span></span>
            <i class="icon"></i>
        </div>
        <ul class="nav">
            <li class="<s:property value="actionNameSpace=='HomeIndex'?'currentPage':''"/>">
                <a href="${pageContext.request.contextPath}/">首页</a>
            </li>
            <li class="<s:property value="actionNameSpace=='MovieIndex'?'currentPage':''"/>">
                <a href="${pageContext.request.contextPath}/movie/index.do">电影</a>
            </li>
            <li class="<s:property value="actionNameSpace=='CinemaIndex'?'currentPage':''"/>">
                <a href="${pageContext.request.contextPath}/cinema/index.do">影院</a>
            </li>
            <li><a href="#">发现</a></li>
        </ul>
    </div>
</div>