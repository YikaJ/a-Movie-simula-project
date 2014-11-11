/**
 * Created by sheng on 2014/11/10.
 */

require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

define(["jquery", "common", "validate", "jquery.md5"], function($){
    //修改密码验证
    $("#changePassword").validate({
        rules: {
            originPasswordInput: {
                required: true,
                minlength: 6
            },
            newPasswordInput: {
                required: true,
                minlength: 6
            },
            newPasswordInput2: {
                required: true,
                minlength: 6,
                equalTo: "#newPasswordInput"
            }
        },
        messages: {
            originPasswordInput: {
                required: "密码不能为空",
                minlength: "密码不得小于6位"
            },
            newPasswordInput: {
                required: "密码不能为空",
                minlength: "密码不得小于6位"
            },
            newPasswordInput2: {
                required: "密码不能为空",
                minlength: "密码不得小于6位",
                equalTo: "两次输入的密码不一致"
            }
        },
            //errorPlacement是一个函数
        errorPlacement: function(error, element){
                element.next().html(error);
        },
        //提交前处理密码md5
        submitHandler: function(form){
            //原密码
            var $originPasswordInput = $("#originPasswordInput");
            var $newPasswordInput = $("#newPasswordInput");
            var $newPasswordInput2 = $("#newPasswordInput2");
            //md5加密传输密码
            var $originPassword = $("#originPassword");
            var $newPassword = $("#newPassword");
            //禁止上传
            $("submitBtn").val("正在上传...");
            $originPasswordInput.attr("disabled", "disabled");
            $newPasswordInput.attr("disabled", "disabled");
            $newPasswordInput2.attr("disabled", "disabled");
            //加密
            $originPassword.val($.md5($originPasswordInput.val()));
            $newPassword.val($.md5($newPasswordInput.val()));
            //Ajax上传
            $.post( "/user/changePassword.do?time="+new Date().getTime(), $(form).serialize(), function(data){
                if(data.response){
                    window.location.href = "/user/updatePwSuccess.do";
                }else{
                    $originPasswordInput.next().html(data.msg).addClass("error");
                    $originPasswordInput.val("").removeAttr("disabled");
                    $newPasswordInput.val("").removeAttr("disabled");
                    $newPasswordInput2.val("").removeAttr("disabled");
                    $("submitBtn").val("保存");
                }
            }, "json");
        }
    })
})