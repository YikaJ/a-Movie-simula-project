<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>爆米花影院列表</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cinemaList.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/customer/public/head.jsp"%>
<div class="content hr">
    <span class="directory"><a href="../home/index.jsp">首页</a> > <a href="movieList">影院</a></span>
    <span class="smallTips">3步轻松购票: 1.选座购票/买券 -> 2.收电子码 -> 3.影院取票</span>
</div>

<div class="content clearfix">
    <div class="tabWrap">
            <div class="cinemaContent">
                <ul class="cinemaTab clearfix">
                    <li class="clearfix">
                        <div class="chooseTitle">选择区域</div>
                        <a href="?" class="activeChoose">全部</a>
                        <s:iterator value="#districts">
                            <a href="?districtId=<s:property value="id"/>"><s:property value="name"/>(<s:property value="cinemas.size"/>)</a>
                        </s:iterator>
                    </li>
                </ul>
                <%--列表--%>
                <ul class="cinemaList">
                    <s:iterator value="#cinemas.recordList">
                        <li>
                            <a href="../../../../jsp/cinemaInformation.jsp"><img class="cinemaImg" src="../../../../image/cinemaSmallImg.jpg"></a>
                            <div class="cinemaInformation">
                                <s:a action="cinemaInfo" namespace="/cinema" var="cinemaInfoURL">
                                    <s:param name="cinemaId" value="id"/>
                                </s:a>
                                <h4><a href="<s:property value="#cinemaInfoURL"/>"><s:property value="name"/></a></h4>
                                <p><span>地址：</span><s:property value="address"/> </p>
                                <p><span>更多：</span><a href="#">影院简介</a></p>
                            </div>
                            <a class="goCinema" href="<s:property value="#cinemaInfoURL"/>">影院购票</a>
                        </li>
                    </s:iterator>
                </ul>
            </div>
    </div>
    <div class="rightBar">
        <div class="rightBarTab clearfix">
            <a href="javascript:" class="activeRightBarTab">正在热映</a>
            <a href="javascript:">即将上映</a>
        </div>
        <%--正在热映--%>
        <ul class="rightBarMovieList">
            <s:iterator value="#movies.recordList">
                <li class="clearfix">
                    <s:url action="showMovieInfo" namespace="/movie" var="showMovieURL">
                        <s:param value="id" name="movieId"/>
                    </s:url>
                    <a href="<s:property value="#showMovieURL"/>">
                        <img src="${pageContext.request.contextPath}<s:property value="poster"/>" class="fl" alt="movie">
                        <div class="rightBarInformation fl">
                            <h3><s:property value="name"/> </h3>
                            <p><span><s:date name="showTime" format="yyyy-MM-dd"/></span>  首映</p>
                            <p>导演：<s:property value="director"/></p>
                        </div>
                    </a>
                </li>
            </s:iterator>
            
        </ul>
        <%--即将上映--%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/require.js" data-main="${pageContext.request.contextPath}/js/customer/cinemaListMain.js"></script>
</body>
</html>