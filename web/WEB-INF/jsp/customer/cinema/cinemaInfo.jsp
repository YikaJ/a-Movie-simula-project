<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>爆米花影院详情</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/public/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/cinema/cinemaInformation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customer/public/window.css">
</head>
<body>
<%--<%@include file="/WEB-INF/jsp/public/head.jsp"%>--%>
<%--banner--%>
<div class="cinemaInformation clearfix">
    <div class="content">
        <h3 class="cinemaTitle">
            <s:property value="#cinema.name"/>
            <span class="rating">8.0</span>
        </h3>
        <img src="${pageContext.request.contextPath}/image/cinema.jpg" class="poster">
        <ul class="cinemaDetail">
            <li>详细地址：<s:property value="#cinema.address"/></li>
            <li>联系电话：<s:property value="#cinema.telephone"/></li>
            <li>更多信息： <a href="#"> 交通信息</a></li>
        </ul>
    </div>
</div>
<%--过渡--%>
<div class="content hr">
    <span class="directory"><a href="${pageContext.request.contextPath}">首页</a> >
        <a href="${pageContext.request.contextPath}/cinema/cinemaInfo.do?cinemaId=<s:property value="#cinema.id"/> ">影院</a> > <a><s:property value="#cinema.name"/> </a> </span>
    <span class="smallTips">3步轻松购票: 1.购票/买券 -> 2.收电子码 -> 3.影院取票</span>
</div>
<%--买票框--%>
<div class="content clearfix">
    <div class="tabWrap">
        <div class="cinemaTab">
            <ul class="clearfix">
                <li class="currentTab"><a href="javascript:">选择购票</a></li>
                <li><a href="javascript:">影城简介</a></li>
            </ul>
        </div>
        <div class="TabContent">
            <div class="buyTicketContent">
                <ul class="chooseMovieTab">
                    <li class="clearfix">
                        <div class="chooseTitle">选择影片</div>
                        <s:iterator value="#movies">
                            <a href="?movieId=<s:property value="id"/>&dayType=<s:property value="dayType"/>&cinemaId=<s:property value="#cinema.id"/>" class="<s:property value="id==#movie.id?'activeChoose':''"/>"><s:property value="name"/></a>
                        </s:iterator>
                    <li class="clearfix">
                        <div class="chooseTitle">选择时间</div>
                        <a href="?movieId=<s:property value="#movie.id"/>&dayType=0&cinemaId=<s:property value="#cinema.id"/>" class="<s:property value="#dayType==0?'activeChoose':''"/>">
                            <s:date name="today" format="MM"/>月<s:date name="today" format="dd"/>日（今天）</a>
                        <a href="?movieId=<s:property value="#movie.id"/>&dayType=1&cinemaId=<s:property value="#cinema.id"/>" class="<s:property value="#dayType==1?'activeChoose':''"/>">
                            <s:date name="tom" format="MM"/>月<s:date name="tom" format="dd"/>日</a>
                    </li>
                </ul>
                <div class="ajax-buyTicket">
                    <div class="movieContent clearfix">
                        <img src="<s:property value="#movie.poster"/>">
                        <div class="movieInformation">
                            <h3 class="movieTitle">
                                <a class="moreDetail fr" href="${pageContext.request.contextPath}/movie/showMovieInfo.do?movieId=<s:property value="#movie.id"/>">查看影片详情 ></a>
                                <a href="${pageContext.request.contextPath}/movie/showMovieInfo.do?movieId=<s:property value="#movie.id"/>" class="movieName"><s:property value="#movie.name"/> </a>
                                <span class="rating">7.8</span>

                            </h3>
                            <ul>
                                <li>导演：<s:property value="#movie.director"/> </li>
                                <li>主演：<s:property value="#movie.mainRole"/></li>
                                <li>版本：<s:iterator value="#movie.movieVersions"><s:property value="name"/>&nbsp;</s:iterator> </li>
                                <li>类型：<s:iterator value="#movie.movieTypes"><s:property value="name"/>&nbsp;</s:iterator> </li>
                                <li>语言：<s:property value="#movie.language"/></li>
                                <li>片长：<s:property value="#movie.filmTime"/>分钟</li>
                            </ul>
                        </div>
                    </div>
                    <table class="ticketTable">
                        <thead>
                            <tr>
                                <td class="thead-time">放映时间</td>
                                <td class="thead-language">语言版本</td>
                                <td class="thead-type">电影类型</td>
                                <td class="thead-hall">放映厅</td>
                                <td class="thead-price">现价/影院价</td>
                                <td class="thead-buy">选定购票</td>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#movie.schedules" status="var">
                            <tr class="<s:property value="#var.index%2!=0?'tdBgColor':''"/>">
                                <td class="thead-time">
                                    <em><s:property value="time"/> </em>
                                </td>
                                <td class="thead-language"><s:property value="#movie.language"/></td>
                                <td class="thead-type"><s:iterator value="#movie.movieVersions"><s:property value="name"/>&nbsp;</s:iterator></td>
                                <td class="thead-hall"><s:property value="hall.number"/>号厅</td>
                                <td class="thead-price">
                                    ￥<s:property value="price"/>
                                </td>
                                <td class="thead-buy">
                                    <a href="#" class="buyTicketBtn">立即购票</a>
                                </td>
                            </tr>
                        </s:iterator>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="footer">
    <div class="content"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/cinemaInformationMain.js"></script>
</body>
</html>