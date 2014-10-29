<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>电影院</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link href="../css/movieList.css" rel="stylesheet" type="text/css">
<link href="../css/window.css" rel="stylesheet" type="text/css">
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
                <li class="currentLi"><a href="#">电影</a></li>
                <li><a href="#">影院</a></li>
                <li><a href="#">我的</a></li>
            </ul>
        </div>
    </div>
    <div class="content hr">
    	<span class="directory"><a href="../WEB-INF/jsp/home/index.jsp">首页</a> > <a href="movieList">电影</a></span>
        <span class="smallTips">3步轻松购票: 1.选座购票/买券 -> 2.收电子码 -> 3.影院取票</span>
    </div>
    <div class="details content">
        <div class="movieBox fl">
            <div class="movieTab">
                <a href="javascript:" class="currentTab">正在热映</a>
                <a href="javascript:">即将上映</a>
            </div>
            <div class="movieContent fl">
                <ul class="movieList fl">
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(1).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(2).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(3).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(4).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(5).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(1).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(2).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(3).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(4).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                    <li>
                        <a href="movieInformation.jsp">
                            <img src="../image/hotOn%20(5).jpg">
                            <span class="buyTicket">立即购票</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="movieNews fr"  id="newsBar">
            <h4>
                <a class="moreNews fr" href="javascript:">更多新闻 ></a>
                热门新闻
            </h4>
            <ul>
                <li>
                    <a href="../WEB-INF/jsp/home/index.jsp">《黄飞鸿》发英雄之战终极预告 颜值战斗值爆表</a>
                </li>
                <li>
                    <a href="../WEB-INF/jsp/home/index.jsp">导演价值排行榜姜文拔头筹 徐静蕾唯一上榜女性</a>
                </li>
                <li>
                    <a href="../WEB-INF/jsp/home/index.jsp">《大话西游》曝爱情版预告 经典影片重回大银幕</a>
                </li>
                <li>
                    <a href="../WEB-INF/jsp/home/index.jsp">高圆圆新片暴打古天乐 谈婚姻：要选对的人</a>
                </li>
                <li>
                    <a href="../WEB-INF/jsp/home/index.jsp">广电总局：吸毒嫖娼者损害行业形象 绝不容忍</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="footer">
        <div class="content"></div>
    </div>


    <script type="text/javascript">
        var newsBar = document.getElementById('newsBar');
        var startHeight = newsBar.parentNode.offsetTop;
        var fixedLeft = newsBar.offsetLeft + newsBar.parentNode.offsetLeft;
        window.onscroll = function(){
            var currentScrollTop = document.documentElement.scrollTop + document.body.scrollTop;
            if(currentScrollTop > startHeight){
                newsBar.style.position = "fixed";
                newsBar.style.left = fixedLeft + "px";
                newsBar.style.top = "0px";
            }else{
                newsBar.style.cssText = "";
            }
        }
    </script>
    <script src="../js/require.js" data-main="../js/main.js"></script>
</body>
</html>