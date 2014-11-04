/**
 * Created by sheng on 2014/11/1.
 */
/*页面常用零碎模块*/


define(["jquery"], function($){
    /*登陆后的设置框*/
    var $myList = $("#myList");
    $(document).click(function(event){
        if($myList.css("display") !== "none"){
            if(event.target.id !== "myList"){
                $myList.stop().slideUp("3000", function(){
                    $("#myStuff").removeClass("activeRightBar");
                });
                $(" .icon").removeClass("iconActive");
            }
        }
    });
    //登录后的下拉列表
    $("#myStuff").click(function(event){
        event.stopPropagation();
        $(this).toggleClass("activeRightBar");
        $myList.stop().slideToggle("3000");
        $(" .icon").eq(0).toggleClass("iconActive");
    });

    var rightBarTab = $(".rightBarTab a");
    rightBarTab.click(function(){
        var index = $(this).index();
        rightBarTab.eq(index).addClass("activeRightBarTab").siblings().removeClass();
        $(".rightBarMovieList").eq(index).show().siblings("ul").hide();
    })
});