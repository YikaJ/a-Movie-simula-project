/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    /*右侧列表*/
    var rightBarTab = $(".rightBarTab a");
    rightBarTab.click(function(){
        var index = $(this).index();
        rightBarTab.eq(index).addClass("activeRightBarTab").siblings().removeClass();
        $(".rightBarMovieList").eq(index).fadeIn().siblings("ul").hide();
    });

    /*更多*/
    $("#summaryToggle").click(function(){
        var more = $("#moreOn");
            if(more.is(":hidden")){
                more.fadeIn();
                $(this).text("<< 收回");
            }else{
                more.hide();
                $(this).text("展开>>");
            }
    })
})