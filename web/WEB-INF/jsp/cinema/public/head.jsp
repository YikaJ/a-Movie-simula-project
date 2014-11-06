<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-11-6
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar-sm" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">链接</a></li>
                        <li><a href="#">链接</a></li>
                        <li>
                            <a href="#">提醒 <i class="glyphicon glyphicon-bell"></i></a>
                        </li>
                        <li>
                            <a href="#">设置 <i class="glyphicon glyphicon-cog"></i></a>
                        </li>
                        <li>
                            <a href="#">前往前端 <i class="glyphicon glyphicon-share-alt"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i><s:property value="#session.cinema.name"/> <i class="caret"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">行为</a></li>
                                <li><a href="#">另一个行为</a></li>
                                <li><a href="#">其它东西</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="BE-index.jsp">注销用户</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>
