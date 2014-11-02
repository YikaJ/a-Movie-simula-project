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
<%@include file="/WEB-INF/jsp/public/head.jsp"%>
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
                        <a href="javascript:" class="activeChoose">全部</a>
                        <a href="javascript:">霞山区(3)</a>
                        <a href="javascript:">赤坎区(2)</a>
                        <a href="javascript:">廉江市(2)</a>
                        <a href="javascript:">雷州市(2)</a>
                    </li>
                </ul>
                <%--列表--%>
                <ul class="cinemaList">
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                    <li>
                        <a href="cinemaInformation.jsp"><img class="cinemaImg" src="../image/cinemaSmallImg.jpg"></a>
                        <div class="cinemaInformation">
                            <h4><a href="cinemaInformation.jsp">金逸湛江赤坎店</a></h4>
                            <p><span>地址：</span>湛江市赤坎区跃进路36号爱华广场五楼</p>
                            <p><span>更多：</span><a href="#">影院简介</a></p>
                        </div>
                        <a class="goCinema" href="../jsp/cinemaInformation.jsp">影院购票</a>
                    </li>
                </ul>
            </div>
    </div>
    <div class="rightBar">
        <div class="rightBarTab clearfix">
            <a href="javascript:" class="activeRightBarTab">正在热映</a>
            <a href="javascript:">即将上映</a>
        </div>
        <ul class="rightBarMovieList">
            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(2).jpg" class="fl" alt="movie">
                    <div class="rightBarInformation fl">
                        <h3>超体</h3>
                        <p><span>2014-10-24</span>首映</p>
                        <p>导演：卢克•贝松</p>
                    </div>
                </a>
            </li>
            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(3).jpg" class="fl" alt="movie">
                    <div class="rightBarInformation fl">
                        <h3>超体</h3>
                        <p><span>2014-10-24</span>首映</p>
                        <p>导演：卢克•贝松</p>
                    </div>
                </a>
            </li>
            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(4).jpg" class="fl" alt="movie">
                    <div class="rightBarInformation fl">
                        <h3>超体</h3>
                        <p><span>2014-10-24</span>首映</p>
                        <p>导演：卢克•贝松</p>
                    </div>
                </a>
            </li>

            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(2).jpg" class="fl" alt="movie">
                    <div class="rightBarInformation fl">
                        <h3>超体</h3>
                        <p><span>2014-10-24</span>首映</p>
                        <p>导演：卢克•贝松</p>
                    </div>
                </a>
            </li>
            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(1).jpg" class="fl" alt="movie">
                    <div class="rightBarInformation fl">
                        <h3>超体</h3>
                        <p><span>2014-10-24</span>首映</p>
                        <p>导演：卢克•贝松</p>
                    </div>
                </a>
            </li>
            <li class="clearfix">
                <a href="movieInformation.jsp">
                    <img src="${pageContext.request.contextPath}/image/hotOn%20(4).jpg" class="fl" alt="movie">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js" data-main="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>