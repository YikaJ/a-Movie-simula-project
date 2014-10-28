<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>movieInformation</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/movieInformation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
    <div class="header">
        <div class="loginRegister">
                <a href="javascript:" id="login">登陆</a> | <a href="javascript:" id="register">注册</a>
        </div>
        <div class="content">
            <h1 class="logo">
                <a href="index.jsp">想映电影院</a>
            </h1>
            <ul class="nav">
                <li><a href="index.jsp">首页</a></li>
                <li class="currentLi"><a href="movieList.jsp">电影</a></li>
                <li><a href="#">影院</a></li>
                <li><a href="#">我的</a></li>
            </ul>
        </div>
    </div>

    <div class="movieInformation clearfix">
        <div class="content">
            <h3 class="movieTitle">
                超体
                <span class="rating">7.6</span>
            </h3>
            <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="poster">
            <ul class="movieDetail">
                <li><h3>“斯嘉丽·约翰逊绝境逢生普通女孩成超人”</h3></li>
                <li>导演：吕克·贝松</li>
                <li>主演：斯嘉丽·约翰逊,摩根·弗里曼,安娜丽·提普顿,阿马尔·维克德,崔岷植 ,乔汗·菲利普·阿斯巴克,李淳,朱利安·林希德-图特,乔汗·菲利普·阿斯巴克,詹·奥利弗·施罗德,塞德里克·舍瓦姆</li>
                <li>类型：3D,IMAX,普通</li>
                <li>制片国家/地区：中国大陆,法国</li>
                <li>语言：英语|法语</li>
                <li>片长：90分钟</li>
                <li class="summary">剧情介绍：　　是一部以台北为背景的科幻动作电影。一个年轻女人被迫变成毒贩然后这种毒品倾入她自己身体系统的故事。但这种毒品却并不会让人萎靡丧命，反而给了她超于常人的力量，包括心灵感应...
                    <a href="javascript:" class="summaryOpen">
                            展开>>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="content">
		<div class="tabWrap">
			<div class="movieTab">
				<ul class="clearfix">
					<li class="currentTab"><a href="javascript:">上线影院</a></li>
					<li><a href="javascript:">热门影评</a></li>
					<li><a href="javascript:">剧情海报</a></li>
					<li><a href="javascript:">周边八卦</a></li>
				</ul>
			</div>
			<div class="TabContent">
				<div class="cinemaContent">
					<ul class="cinemaTab">
						<li>
							放映时间：
							<a href="javascript:" class="activeChoose">全部</a>
							<a href="javascript:">今天(10.28)</a>
							<a href="javascript:">明天(10.29)</a>
						<li>
							区域：
							<a href="javascript:" class="activeChoose">全部</a>
							<a href="javascript:">霞山区(3)</a>
							<a href="javascript:">赤坎区(2)</a>
							<a href="javascript:">廉江市(2)</a>
							<a href="javascript:">雷州市(2)</a>
						</li>
					</ul>
					<ul class="cinemaList">
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
						<li>
							<p>
								<a href="#">中影国际影城(湛江店)</a>
								<span>湛江市霞山区椹川大道1-3号江霞广场5楼</span>
							</p>
							<div class="ticketPrice">
								￥34.00<span class="originPrice">￥70.00</span>
								<a href="#" class="buyTicket">立即购票</a>
							</div>
						</li>
					</ul>	
				</div>
			</div>
		</div>
		<div class="rightBar">
			<div class="rightBarTab clearfix">
				<a href="javascript:" class="activeRightBarTab">正在热映</a>
				<a href="javascript:">即将上映</a>
			</div>
			<ul class="rightBarMovieList">
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (2).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (3).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (4).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
				
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (2).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (1).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
				<li class="clearfix">
					<img src="${pageContext.request.contextPath}/image/hotOn (4).jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
				</li>
			</ul>
		</div>
    </div>



    <div class="footer">
        <div class="content"></div>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js" data-main="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>