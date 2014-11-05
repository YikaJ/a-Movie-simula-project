<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-11-5
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-2 bootstrap-admin-col-left">
    <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
        <li class="active">
            <s:a action="movieStorage" namespace="/ciname/manage"><i class="glyphicon glyphicon-chevron-right"></i> 上映电影</s:a>
        </li>
        <li>
            <s:a action="scheduleManage" namespace="/cinema/manage" >
               <i class="glyphicon glyphicon-chevron-right"></i> 排期管理
            </s:a>
        </li>
        <li>
            <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 影厅管理</a>
        </li>
        <li>
            <a href="BE-movie.jsp"><i class="glyphicon glyphicon-chevron-right"></i> 订单管理</a>
        </li>
        <li>
            <a href="wysiwyg-editors.html"><i class="glyphicon glyphicon-chevron-right"></i> 信息管理</a>
        </li>
    </ul>
</div>
