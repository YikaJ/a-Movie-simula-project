<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>爆米花影院详情</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cinemaInformation.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
<div class="header">
    <div class="loginRegister">
        <a href="javascript:" id="login">登陆</a> | <a href="javascript:" id="register">注册</a>
    </div>
    <div class="content">
        <h1 class="logo">
            <a href="../WEB-INF/jsp/home/index.jsp">想映电影院</a>
        </h1>
        <ul class="nav">
            <li><a href="../WEB-INF/jsp/home/index.jsp">首页</a></li>
            <li><a href="../WEB-INF/jsp/movie/movieList.jsp">电影</a></li>
            <li class="currentLi"><a href="#">影院</a></li>
            <li><a href="#">我的</a></li>
        </ul>
    </div>
</div>

<div class="cinemaInformation clearfix">
    <div class="content">
        <h3 class="cinemaTitle">
            湛江金影电影城
            <span class="rating">8.0</span>
        </h3>
        <img src="${pageContext.request.contextPath}/image/cinema.jpg" class="poster">
        <ul class="cinemaDetail">
            <li>详细地址：湛江市赤坎区跃进路36号爱华广场五楼</li>
            <li>联系电话：0759-3618688 </li>
            <li>更多信息： <a href="#"> 交通信息</a></li>
        </ul>
    </div>
</div>

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
                        <a href="javascript:" class="activeChoose">超体</a>
                        <a href="javascript:">银河护卫队</a>
                        <a href="javascript:">宙斯之子：赫拉克勒斯</a>
                        <a href="javascript:">不能说的夏天</a>
                        <a href="javascript:">移动迷宫</a>
                        <a href="javascript:">忍者神龟：变种时代</a>
                        <a href="javascript:">一个人的武林</a>
                    <li class="clearfix">
                        <div class="chooseTitle">选择时间</div>
                        <a href="javascript:" class="activeChoose"> 10月30日（今天）</a>
                        <a href="javascript:">10月31日</a>
                    </li>
                </ul>
                <div class="ajax-buyTicket">
                    <div class="movieContent clearfix">
                        <img src="../image/movieInformation1.jpg">
                        <div class="movieInformation">
                            <h3 class="movieTitle">
                                <a href="movieInformation.jsp" class="movieName">超体</a>
                                <span class="rating">7.8</span>
                                <a class="moreDetail fr" href="movieInformation.jsp">查看影片详情 ></a>
                            </h3>
                            <ul>
                                <li>看点：失忆男孩揭开真相破解迷宫密码</li>
                                <li>导演：吕克·贝松</li>
                                <li>主演：斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳</li>
                                <li>类型：3D,IMAX,普通</li>
                                <li>语言：英语|法语</li>
                                <li>片长：90分钟</li>
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
                                <tr>
                                    <td class="thead-time">
                                        <em>20:40</em>
                                        <p>预计22：33离场</p>
                                    </td>
                                    <td class="thead-language">英语</td>
                                    <td class="thead-type">2D</td>
                                    <td class="thead-hall">6号厅</td>
                                    <td class="thead-price">
                                        ￥27.00
                                        <span class="originPrice">￥35.00</span>
                                    </td>
                                    <td class="thead-buy">
                                        <a href="#" class="buyTicketBtn">立即购票</a>
                                    </td>
                                </tr>
                                <tr class="tdBgColor">
                                    <td class="thead-time">
                                        <em>20:40</em>
                                        <p>预计22：33离场</p>
                                    </td>
                                    <td class="thead-language">英语</td>
                                    <td class="thead-type">2D</td>
                                    <td class="thead-hall">6号厅</td>
                                    <td class="thead-price">
                                        ￥27.00
                                        <span class="originPrice">￥35.00</span>
                                    </td>
                                    <td class="thead-buy">
                                        <a href="#" class="buyTicketBtn">立即购票</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="thead-time">
                                        <em>20:40</em>
                                        <p>预计22：33离场</p>
                                    </td>
                                    <td class="thead-language">英语</td>
                                    <td class="thead-type">2D</td>
                                    <td class="thead-hall">6号厅</td>
                                    <td class="thead-price">
                                        ￥27.00
                                        <span class="originPrice">￥35.00</span>
                                    </td>
                                    <td class="thead-buy">
                                        <a href="#" class="buyTicketBtn">立即购票</a>
                                    </td>
                                </tr>
                                <tr class="tdBgColor">
                                    <td class="thead-time">
                                        <em>20:40</em>
                                        <p>预计22：33离场</p>
                                    </td>
                                    <td class="thead-language">英语</td>
                                    <td class="thead-type">2D</td>
                                    <td class="thead-hall">6号厅</td>
                                    <td class="thead-price">
                                        ￥27.00
                                        <span class="originPrice">￥35.00</span>
                                    </td>
                                    <td class="thead-buy">
                                        <a href="#" class="buyTicketBtn">立即购票</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="thead-time">
                                        <em>20:40</em>
                                        <p>预计22：33离场</p>
                                    </td>
                                    <td class="thead-language">英语</td>
                                    <td class="thead-type">2D</td>
                                    <td class="thead-hall">6号厅</td>
                                    <td class="thead-price">
                                        ￥27.00
                                        <span class="originPrice">￥35.00</span>
                                    </td>
                                    <td class="thead-buy">
                                        <a href="#" class="buyTicketBtn">立即购票</a>
                                    </td>
                                </tr>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js" data-main="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>