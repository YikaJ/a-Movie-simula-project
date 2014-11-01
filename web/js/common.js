/**
 * Created by sheng on 2014/11/1.
 */
/*页面常用零碎模块*/

/*登陆后的设置框*/
define(["jquery"], function($){
    $("#myStuf").click(function(){
        $("#myList").slideToggle("3000");
        $(" .icon").eq(0).toggleClass("iconActive");
    })
})