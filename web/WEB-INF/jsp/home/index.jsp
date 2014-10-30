<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>电影院</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/homepage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/autoplay.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/window.css">
</head>
<body>
   <%@include file="/WEB-INF/jsp/public/head.jsp"%>
    <div id="banner">
        <ul>
            <li><a href="index.jsp" title="banner1" style="background-image: url(${pageContext.request.contextPath}/image/banner1.jpg)"></a></li>
            <li><a href="index.jsp" title="banner2" style="background-image: url(${pageContext.request.contextPath}/image/banner2.png)"></a></li>
            <li><a href="index.jsp" title="banner3" style="background-image: url(${pageContext.request.contextPath}/image/banner3.png)"></a></li>
        </ul>
    </div>

    <div class="movieContent content">
        <div class="tabList content">
            <a class="hotOnTab activeTab" href="javascript:">正在热映(13)</a>
            <a class="hotReadyTab" href="javascript:">即将上映(47)</a>
            <a class="moreFirm" href="javascript:">查看全部 ></a>
        </div>
        <ul class="movieList">
            <li><a href="../movie/movieInformation.jsp"><img src="${pageContext.request.contextPath}/image/hotOn%20(1).jpg"><span class="buyTicket">立即购票</span></a></li>
            <li><a href="../movie/movieInformation.jsp"><img src="${pageContext.request.contextPath}/image/hotOn%20(2).jpg"><span class="buyTicket">立即购票</span></a></li>
            <li><a href="../movie/movieInformation.jsp"><img src="${pageContext.request.contextPath}/image/hotOn%20(3).jpg"><span class="buyTicket">立即购票</span></a></li>
            <li><a href="../movie/movieInformation.jsp"><img src="${pageContext.request.contextPath}/image/hotOn%20(4).jpg"><span class="buyTicket">立即购票</span></a></li>
            <li><a href="../movie/movieInformation.jsp"><img src="${pageContext.request.contextPath}/image/hotOn%20(5).jpg"><span class="buyTicket">立即购票</span></a></li>
        </ul>
        <ul class="movieList" style="display: none"></ul>
    </div>

    <div class="content rankList">
        <div class="rankBox">
            <div class="rank">
                <h4>
                    <a class="moreFirm fr" href="javascript:">更多电影 ></a>
                    上周票房冠军
                </h4>
                <ol class="firmList" id="firmRank">
                    <li class="activeList">
                        <i class="listType" style="background-position: 0px 0px"></i>
                        <a href="index.jsp"><img src="${pageContext.request.contextPath}/image/rank%20(1).jpg" alt="championFirm"></a>
                        <div class="information">
                            <h5 class="movieTitle">心花路放</h5>
                            <span class="rating">8.9</span>
                            <a href="index.jsp" class="buyTicket">立即购票</a>
                        </div>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -42px"></i>
                        <a href="index.jsp"><img src="${pageContext.request.contextPath}/image/rank%20(2).jpg" alt="championFirm"></a>
                        <div class="information">
                            <h5 class="movieTitle">心花路放</h5>
                            <span class="rating">8.9</span>
                            <a href="index.jsp" class="buyTicket">立即购票</a>
                        </div>
                    </li>
                     <li>
                        <i class="listType" style="background-position: 0px -81px"></i>
                        <a href="index.jsp"><img src="${pageContext.request.contextPath}/image/rank%20(3).jpg" alt="championFirm"></a>
                        <div class="information">
                            <h5 class="movieTitle">心花路放</h5>
                            <span class="rating">8.9</span>
                            <a href="index.jsp" class="buyTicket">立即购票</a>
                        </div>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -125px"></i>
                        <a href="index.jsp"><img src="${pageContext.request.contextPath}/image/rank%20(4).jpg" alt="championFirm"></a>
                        <div class="information">
                            <h5 class="movieTitle">心花路放</h5>
                            <span class="rating">8.9</span>
                            <a href="index.jsp" class="buyTicket">立即购票</a>
                        </div>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -168px"></i>
                        <a href="index.jsp"><img src="${pageContext.request.contextPath}/image/rank%20(5).jpg" alt="championFirm"></a>
                        <div class="information">
                            <h5 class="movieTitle">心花路放</h5>
                            <span class="rating">8.9</span>
                            <a href="index.jsp" class="buyTicket">立即购票</a>
                        </div>
                    </li>
                </ol>
            </div>
            <div class="rank">
                <h4>
                    <a class="moreCinema fr" href="javascript:">更多影院 ></a>
                    热门影院排行
                </h4>
                <ol class="cinemaList" id="cinemaRank">
                    <li class="activeList">
                        <i class="listType" style="background-position: 0px 0px"></i>
                        <a href="index.jsp" class="cinemaTitle"><h5>金逸影城霞山店</h5></a>
                        <span class="address">区跃进路36号爱华广场五36号爱华广场五楼
                        </span>
                        <a href="index.jsp" class="goCinema">查看影院</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -42px"></i>
                        <a href="index.jsp" class="cinemaTitle"><h5>金逸影城霞山店</h5></a>
                        <span class="address">区跃进路36号爱华广场五爱华广场五楼</span>
                        <a href="index.jsp" class="goCinema">查看影院</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -81px"></i>
                        <a href="index.jsp" class="cinemaTitle"><h5>金逸影城霞山店</h5></a>
                        <span class="address">区跃进路36号爱华广场爱华广场五楼</span>
                        <a href="index.jsp" class="goCinema">查看影院</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -125px"></i>
                        <a href="index.jsp" class="cinemaTitle"><h5>金逸影城霞山店</h5></a>
                        <span class="address">区跃进路36号爱华广场五楼跃进爱华广场五楼</span>
                        <a href="index.jsp" class="goCinema">查看影院</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -168px"></i>
                        <a href="index.jsp" class="cinemaTitle"><h5>金逸影城霞山店</h5></a>
                        <span class="address">区跃进路36号爱华广场五号爱华广场五楼</span>
                        <a href="index.jsp" class="goCinema">查看影院</a>
                    </li>
                </ol>
            </div>
            <div class="rank">
                <h4>
                    <a class="moreNews fr" href="javascript:">更多新闻 ></a>
                    周边八卦
                </h4>
                <ol class="movieNewsList">
                    <li>
                        <i class="listType" style="background-position: 0px 0px"></i>
                        <a href="index.jsp">《黄飞鸿》发英雄之战终极预告 颜值战斗值爆表</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -42px"></i>
                        <a href="index.jsp">导演价值排行榜姜文拔头筹 徐静蕾唯一上榜女性</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -81px"></i>
                        <a href="index.jsp">《大话西游》曝爱情版预告 经典影片重回大银幕</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -125px"></i>
                        <a href="index.jsp">高圆圆新片暴打古天乐 谈婚姻：要选对的人</a>
                    </li>
                    <li>
                        <i class="listType" style="background-position: 0px -168px"></i>
                        <a href="index.jsp">广电总局：吸毒嫖娼者损害行业形象 绝不容忍</a>
                    </li>
                </ol>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="content"></div>
    </div>

<script type="text/javascript">
    var aLi =  document.getElementById("firmRank").getElementsByTagName("li"),
        aLi2 = document.getElementById("cinemaRank").getElementsByTagName("li");
    for(var i = 0, len = aLi.length; i <len; i++){
        aLi[i].onmouseover = function(){
            for(i = 0; i < len; i++){
                aLi[i].className = "";
            }
            this.className = "activeList";
        }
    }
    for(var i = 0, len = aLi2.length; i <len; i++){
        aLi2[i].onmouseover = function(){
            for(i = 0; i < len; i++){
                aLi2[i].className = "";
            }
            this.className = "activeList";
        }
    }
  
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js" data-main="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>