/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function($){
    function ScrollUp(){};
    ScrollUp.prototype = {
        up: function(){
            var scrollUp = $("<a class='scrollUp_button' title='回到顶部' href='javascript:'>回到顶部</a>");
            scrollUp.appendTo("body");
            $(window).scroll(function(){
                var scrollTop = $(document.documentElement).scrollTop() + $(document.body).scrollTop();
                scrollTop > 300?   scrollUp.fadeIn(): scrollUp.fadeOut();
            });

            scrollUp.click(function(){
                $(document.documentElement).animate({scrollTop: 0}, "normal");
                $(document.body).animate({scrollTop: 0}, "normal");
            })
        }
    };
    return { ScrollUp: ScrollUp}
});
