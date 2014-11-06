/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    var rightBar = $("#rightFixedBar"),
        fixedTop = rightBar.offset().top,
        fixedLeft = rightBar.offset().left;

    $(window).scroll(function(){
        var scrollTop = $(document.documentElement).scrollTop() + $(document.body).scrollTop();
        if(scrollTop > fixedTop) {
            rightBar.css({
                "position": "fixed",
                "top": "0px",
                left: fixedLeft + "px"
            });
        }else{
           rightBar[0].style.cssText = "";
        }
    });
    $(window).trigger("scroll");
})
