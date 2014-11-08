/**
 * Created by sheng on 2014/11/7.
 */

define(["jquery"], function($){
    $("#uploadImg").click(function(){
        var form = $("#imageShot").serialize();
        $.post("/support/imageShot.do", form, function(data){
            if(data.response){
                alert(data.msg);
            }else{
                alert(data.msg);
            }
        });
    })
});
