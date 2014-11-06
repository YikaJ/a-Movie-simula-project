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
    /*
    *  回到顶部
    */
     var scrollUp = $("<a class='scrollUp_button' title='回到顶部' href='javascript:'>回到顶部</a>");
     scrollUp.appendTo("body");
     $(window).scroll(function(){
         var scrollTop = $(document.documentElement).scrollTop() + $(document.body).scrollTop();
         scrollTop > 300?   scrollUp.fadeIn(): scrollUp.fadeOut();
     });
    $(window).trigger("scroll");//模拟触发一下滚动
     scrollUp.click(function(){
            $(document.documentElement).animate({scrollTop: 0}, "normal");
            $(document.body).animate({scrollTop: 0}, "normal");
      })
});