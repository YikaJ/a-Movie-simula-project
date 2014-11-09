<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><s:property value="#movie.name"/></title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/movieInformation.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
   <%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
    <div class="movieInformation clearfix">
        <div class="content">
            <img src="${pageContext.request.contextPath}<s:property value="#movie.poster"/> " class="poster">
            <ul class="movieDetail">
                <li>
                    <h3 class="movieTitle">
                    <s:property value="#movie.name"/>
                        <span class="rating">7.6</span>
                    </h3>
                </li>
                <li>导演：<s:property value="#movie.director"/></li>
                <li>主演：<s:property value="#movie.mainRole"/></li>
                <li>类型：<s:iterator value="#movie.movieTypes"><s:property value="name"/></s:iterator></li>
                <li>地区：<s:property value="#movie.region"/></li>
                <li>语言：<s:property value="#movie.language"/></li>
                <li>片长：<s:property value="#movie.filmTime"/> 分钟</li>
                <li class="summary">
                    剧情介绍：<s:property value="@com.mx.popcorn.utils.WebUtils@simpleSubstring(#movie.introduce, 0, 80)"/>
                    <span id="moreOn" style="display: none"><s:property value="@com.mx.popcorn.utils.WebUtils@simpleSubstring(#movie.introduce, 80, 10000)"/></span>......
                    <a href="javascript:" id="summaryToggle">
                            展开>>
                    </a>
                </li>
            </ul>
        </div>
    </div>
   <%--过渡框--%>
   <div class="content hr">
       <span class="directory"><a href="${pageContext.request.contextPath}/">首页</a> >
           <a href="${pageContext.request.contextPath}/movie/index.do">电影</a> >
           <a href="${pageContext.request.contextPath}/movie/showMovieInfo.do?movieId=<s:property value="#movie.id"/> "><s:property value="#movie.name"/> </a> </span>
       <span class="smallTips">3步轻松购票: 1.购票/买券 -> 2.收电子码 -> 3.影院取票</span>
   </div>
   <%--电影票购买--%>
    <div class="content clearfix">
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
					<ul class="cinemaTab clearfix">
						<li class="clearfix">
                            <div class="chooseTitle">选择时间</div>
							<a href="javascript:" class="activeChoose">全部</a>
							<a href="javascript:">今天(10.28)</a>
							<a href="javascript:">明天(10.29)</a>
                        </li>
						<li class="clearfix">
                            <div class="chooseTitle">选择区域</div>
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
			<ul  class="rightBarMovieList">
				<li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
				</li>
				<li class="clearfix">
                    <a href="movieInformation.jsp">
					<img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
                    </a>
				</li>
				<li class="clearfix">
                    <a href="movieInformation.jsp">
					<img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
                    </a>
				</li>

				<li class="clearfix">
                    <a href="movieInformation.jsp">
					<img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
                    </a>
				</li>
				<li class="clearfix">
                    <a href="movieInformation.jsp">
					<img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
                    </a>
				</li>
				<li class="clearfix">
                    <a href="movieInformation.jsp">
					<img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
					<div class="rightBarInformation fl">
						<h3>超体</h3>
						<p><span>2014-10-24</span>首映</p>
						<p>导演：卢克•贝松</p>
					</div>
                    </a>
				</li>
			</ul>
            <ul  class="rightBarMovieList" style="display: none">
                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>
                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>
                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>

                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>
                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>
                <li class="clearfix">
                    <a href="movieInformation.jsp">
                        <img src="${pageContext.request.contextPath}/image/movieInformation1.jpg" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3>超体</h3>
                            <p><span>2014-10-24</span>首映</p>
                            <p>导演：卢克•贝松</p>
                        </div>
                    </a>
                </li>
            </ul>
		</div>
    </div>



    <div class="footer">
        <div class="content"></div>
    </div>
   <script  type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jaDcSl7r2ArKTbGYn4lGZUcQ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/movieInformationMain.js"></script>
</body>
</html>