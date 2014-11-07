/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    var rightBar = $("#rightFixedBar"),
        fixedTop = rightBar.offset().top,
        fixedLeft = rightBar.offset().left,
        limitedHeight = $("#footer").offset().height + rightBar.height();


    $(window).scroll(function(){
        var scrollTop = $(document.documentElement).scrollTop() + $(document.body).scrollTop();
        console.log(rightBar.offset().left);
        if(scrollTop > fixedTop /*&& scrollTop < limitedHeight*/) {
            rightBar.css({
                "position": "fixed",
                "top": "0px",
                left: fixedLeft + "px"
            });
        }else{
           rightBar[0].style.cssText = "";
        }
    });
    $(window).resize(function(){
        rightBar[0].style.cssText = "";   //先还原右边栏的位置，然后获取新位置再触发滚动
        fixedLeft = rightBar.offset().left;
        rightBar.css("left", fixedLeft);
        $(window).trigger("scroll");
    })
    $(window).trigger("scroll");
})
