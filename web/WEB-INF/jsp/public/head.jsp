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
    <div class="loginRegister">
        <s:if test="#session.user==null">
            <a href="javascript:" id="login">登陆</a> | <a href="javascript:" id="register">注册</a>
        </s:if>
        <s:else>

        </s:else>
    </div>
    <div class="content">
        <h1 class="logo">
            <a href="index.jsp">想映电影院</a>
        </h1>
        <ul class="nav">
            <li class="currentLi"><a href="${pageContext.request.contextPath}/index.do">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/movie/index.do">电影</a></li>
            <li><a href="#">影院</a></li>
            <li><a href="#">我的</a></li>
        </ul>
    </div>
</div>