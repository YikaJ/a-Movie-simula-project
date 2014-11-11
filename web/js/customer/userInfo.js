/**
 * Created by sheng on 2014/11/10.
 */
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

define(["jquery", "window", "common"], function($,w){
    /*出生年月option*/
    var $year = $("#year"),
        $month = $("#month"),
        $date = $("#date");
    //年份
    for(var i = 1960; i < new Date().getFullYear() + 1; i++){
        $("<option value=" + i + " name='year'>" + i + "</option>").appendTo($year);
    }
    //月份
    $year.change(function(){
        $month.find("option:gt(0)").remove();
        $date.find("option:gt(0)").remove();
        for(var i = 1; i < 13; i++){
            $("<option value=" + i + " name='month'>" + i + "</option>").appendTo($month);
        }
    });
    //日期
    $month.change(function(){
        $date.find("option:gt(0)").remove();
        var month = parseInt($month.val(), 10);
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                for(var i = 1; i < 32; i++){
                    $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                for(var i = 1; i < 31; i++){
                    $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
                }
                break;
            case 2:
                var year = $year.val();
                if( (year%4 == 0) && (year%100 != 0)||(year%400 == 0) ){
                    for(var i = 1; i < 30; i++){
                        $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
                    }
                }else{
                    for(var i = 1; i < 29; i++){
                        $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
                    }
                }
                break;
        }
    })

    /*三级联动*/
    var $province = $("#province"),
        $city = $("#city"),
        $district = $("#district");
    //载入时获取省份
    $.post("/space/catchProvince.do?time=" + new Date().getTime(), null, function(data){
        if(data.response){
            for(var i = 0, len = data.data.length; i < len; i++){
                $("<option value=" + data.data[i].id + " name=" + data.data[i].name + " >" + data.data[i].name + "</option>").appendTo($province);
            }
        }
    });
    //获取值改变城市
    $province.change(function(){
        $city.find("option:gt(0)").remove();
        $district.find("option:gt(0)").remove();
        var provinceId = $(this).val();
        $.post("/space/catchCity.do?time=" + new Date().getTime(), {provinceId: provinceId}, function(data){
            if(data.response){
                for(var i = 0, len = data.data.length; i < len; i++){
                    $("<option value=" + data.data[i].id + " name=" + data.data[i].name + " >" + data.data[i].name + "</option>").appendTo($city);
                }
            }else{
                alert(data.msg);
            }
        });
    });

    $city.change(function(){
        $district.find("option:gt(0)").remove();
        var cityId = $(this).val();
        $.post("/space/catchDistrict.do?time=" + new Date().getTime(), {cityId: cityId}, function(data){
            if(data.response){
                for(var i = 0, len = data.data.length; i < len; i++){
                    $("<option value=" + data.data[i].id + " name=" + data.data[i].name + " >" + data.data[i].name + "</option>").appendTo($district);
                }
            }else{
                alert(data.msg);
            }
        });
    });


    /*提交表单！*/
    //修改生日
    $("#submitBtn").click(function(){
        var birth = $year.val() + "-" + $month.val() + "-" + $date.val();
        $("#birth").val(birth);
        $.post("use/info.do", $("#updateInfo").serialize(), function(data){
            if(data.response){
                new w.Window().alert({
                    box: $(window),
                    title: "已成功提交",
                    hasMask: false,
                    closeBtn: false,
                    height: 60,
                    width: 400,
                    autoRemoved: 2000,
                    boxStyle: "successBox",
                    headerStyle: "successHeader"
                });
            }else{

            }
        }, "json")
    })

});