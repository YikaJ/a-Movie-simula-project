$(function () {
    //初始化div模版
    var movieTimeDiv = $(".movieTimeDiv").eq(0).parent().html();
    //添加删除放映时间
    $(document).on("click", ".addMovieTimeBtn", function(){
        var appendTbody = $(this).parents(".div-margin").find("tbody");
        appendTbody.append($("#cloneTr").clone().hide().fadeIn());
    })
    $(document).on("click", ".removeMovieTimeBtn",function(){
        var appendTbody = $(this).parents(".div-margin").find("tbody");
        appendTbody.children("tr").length !== 1 && appendTbody.children("tr:last").remove();
    })

    //添加电影排期
    $(document).on("click", ".addMovieBtn", function(){

        $(".scheduleContent").prepend(movieTimeDiv);//增加到最前面
    });
    //删除电影排期
    $(document).on("click", ".removeMovieBtn",function(){
        var movieDiv = $(this).parents(".movieTimeDiv");
        movieDiv.length >= 1 && movieDiv.remove();
    });
    //发布排期
    $(document).on("click",".confirmMovieTimeBtn", function(event){
        event.preventDefault();
        var form = $(this).parents(".div-margin");
        if(confirm("是否确认发布排期？")){
            if($(this).parents(".div-margin").find("input").val() == ""){
                alert("表单不能为空！请确认");
                return false;
            }
            form.remove();
        }else{
            return false;
        }
    })
})/**
 * Created by sheng on 2014/11/7.
 */
