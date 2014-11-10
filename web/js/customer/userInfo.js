/**
 * Created by sheng on 2014/11/10.
 */
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

define(["jquery", "common"], function($){
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
        for(var i = 1; i < 13; i++){
            $("<option value=" + i + " name='month'>" + i + "</option>").appendTo($month);
        }
    });
    //日期
    $month.change(function(){
        $date.find("option:gt(0)").remove();
        if($month.val() == 1||3||5||7||8||10||12){
            for(var i = 1; i < 33; i++){
                $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
            }
        }
        if($month.val() == 4||6||9||11){
            for(var i = 1; i < 33; i++){
                $("<option value=" + i + " name='date'>" + i + "</option>").appendTo($date);
            }
        }
        if($month.val() == 2){
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
});