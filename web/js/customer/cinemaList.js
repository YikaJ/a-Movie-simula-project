/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    var rightBarTab = $(".rightBarTab a");
    rightBarTab.click(function(){
        var index = $(this).index();
        rightBarTab.eq(index).addClass("activeRightBarTab").siblings().removeClass();
        $(".rightBarMovieList").eq(index).fadeIn().siblings("ul").hide();
    });
})