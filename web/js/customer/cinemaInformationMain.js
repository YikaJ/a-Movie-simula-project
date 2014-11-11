
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

require(["jquery", "window", "common", "cinemaInformation"], function ($, w) {

    $("#login").click(function () {
        new w.Window().login({
            box: $(window),
            title: "立即登录",
            hasMask: true,
            fixed: false,
            fadeIn: false,
            height: 325,
            width: 400,
            text4loginUserPlaceholder: "请输入您的注册邮箱",
            text4loginPwdPlaceholder: "请输入您的密码",
            text4autoLogin: "七天内自动登陆"
        });
        $("#L_email").focus();
    });

    $("#register").click(function () {
        new w.Window().register({
            box: $(window),
            title: "立即注册",
            hasMask: true,
            fixed: false,
            fadeIn: false,
            height: 460,//不可改变
            width: 500,
            time4Removed: 0,
            rules4RegisterUser: "输入内容的长度限制在3-15个字符哦",
            rules4RegisterPwd: "请输入至少6位的密码哟",
            rules4RegisterEmail: "请输入正确格式的电子邮箱",
            rules4RegisterPwdAgain: "两次输入的密码不一致",
            serviceURL: "#",
            text4Service: "《爆米花用户协议》"
        })
    });
});


