/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    var rightBar = $("#rightFixedBar"),
        fixedTop = rightBar.offset().top,
        fixedLeft = rightBar.offset().left,
        $footer  = $("#footer"),
        footerHeight = $footer.height(),
        height = $(".movieBox").height(),
        limitedHeight = $footer.offset().top - rightBar.height();
        $(".rightBarContent").height(height);


    $(window).scroll(function(){
        var scrollTop = $(document.documentElement).scrollTop() + $(document.body).scrollTop();
        if(scrollTop < fixedTop) {
            console.log("reset");
            rightBar[0].style.cssText = "";
        }else{
            if(scrollTop < limitedHeight){
                console.log("center");
                rightBar.css({
                    "position": "fixed",
                    "top": "0px",
                    left: fixedLeft + "px"
                });
            }else{
                console.log("stop")
                rightBar[0].style.cssText = "";
                rightBar.css({
                    "position": "absolute",
                    "bottom": "0px"
                });
            }
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
