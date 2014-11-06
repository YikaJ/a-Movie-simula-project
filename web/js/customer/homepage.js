/**
 * Created by sheng on 2014/11/6.
 */
define(["jquery"], function(){
    var aLi1 =  $("#firmRank li"),
          aLi2 = $("#cinemaRank li");

        aLi1.mouseover(function(){
            $(this).addClass("activeList").siblings().removeClass();
        })

        aLi2.mouseover(function(){
            $(this).addClass("activeList").siblings().removeClass();
        });
})
