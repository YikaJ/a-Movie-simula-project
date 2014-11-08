<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>电影院</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="${pageContext.request.contextPath}/css/movieList.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/window.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
    <div class="content hr">
    	<span class="directory"><a href="../home/index.jsp">首页</a> > <a href="movieList">电影</a></span>
        <span class="smallTips">3步轻松购票: 1.选座购票/买券 -> 2.收电子码 -> 3.影院取票</span>
    </div>
    <div class="details content">
        <div class="movieBox fl">
            <div class="movieTab">
                <a href="?" class="<s:property value="viewType==0?'currentTab':''"/>" id="hotTab">正在热映</a>
                <a href="?viewType=1" class="<s:property value="viewType==1?'currentTab':''"/>" id="soonTab">即将上映</a>
            </div>
            <div class="movieContent fl">
                <ul class="movieList fl">
                    <s:iterator value="#movies">
                        <li>
                            <s:url action="showMovieInfo" namespace="/movie" var="showMovieURL">
                                <s:param value="id" name="movieId"/>
                            </s:url>
                            <a href="<s:property value="#showMovieURL"/> " title="<s:property value="name"/>">
                                <img src="${pageContext.request.contextPath}<s:property value="poster"/> " alt="<s:property value="name"/>">
                                <span class="buyTicket">立即购票</span>
                            </a>
                        </li>
                    </s:iterator>
                </ul>
            </div>
        </div>
        <div class="rightFixedBar fr"  id="rightFixedBar">
            <h4>
                <a class="more fr" href="javascript:">更多新闻 ></a>
                热门新闻
            </h4>
            <ul>
                <li>
                    <a href="../home/index.jsp">《黄飞鸿》发英雄之战终极预告 颜值战斗值爆表</a>
                </li>
                <li>
                    <a href="../home/index.jsp">导演价值排行榜姜文拔头筹 徐静蕾唯一上榜女性</a>
                </li>
                <li>
                    <a href="../home/index.jsp">《大话西游》曝爱情版预告 经典影片重回大银幕</a>
                </li>
                <li>
                    <a href="../home/index.jsp">高圆圆新片暴打古天乐 谈婚姻：要选对的人</a>
                </li>
                <li>
                    <a href="../home/index.jsp">广电总局：吸毒嫖娼者损害行业形象 绝不容忍</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="footer" id="footer">
        <div class="content"></div>
    </div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/movieListMain.js"></script>
</body>
</html>