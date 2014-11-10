<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-11-9
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<ul class="leftContent fl">
    <li><a href="${pageContext.request.contextPath}/user/userInfo.do"  class="<s:property value="actionName=='userInfo'?'activeLi':''"/> ">个人资料</a></li>
    <li><a href="${pageContext.request.contextPath}/user/userImg.do"  class="<s:property value="actionName=='userImg'?'activeLi':''"/> ">头像设置</a></li>
    <li><a href="${pageContext.request.contextPath}/user/changePasswordUI.do"  class="<s:property value="actionName=='changePasswordUI'?'activeLi':''"/> ">修改密码</a></li>
    <li><a href="javascript:"  class="<s:property value="actionName=='showOrder'?'activeLi':''"/> ">我的订单</a></li>
</ul>