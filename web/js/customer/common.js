/**
 * Created by sheng on 2014/11/1.
 */
/*页面常用零碎模块*/


define(["jquery"], function($){
    /*登陆后的设置框*/
    var $myList = $("#myList");
    var $login =  $(".loginLeft");
    var $loginRegister = $("#loginRegister");
    var width = $login.innerWidth();
    $myList.css("width", width);
    $loginRegister.mousemove(function(event){
        event.stopPropagation();
        $login.addClass("activeLeftBar");
        $myList.show();
        $(" .icon").eq(0).addClass("iconActive");
    });

    $(document).mousemove(function(event){
        if($myList.css("display") !== "none"){
            if(event.target.id !== "myList"){
                $myList.hide();
                $login.removeClass("activeLeftBar");
                $(" .icon").removeClass("iconActive");
            }
        }
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
      });

    // 百度地图API功能
    var myCity = new BMap.LocalCity();
    myCity.get(myFun);
    function myFun(result){
        var cityName = result.name;
        $("#mapLocation span").text(cityName);
        $.post(".do", {city: cityName}, function(data){
            if(data.response){

            }
        })
    }

});