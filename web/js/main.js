/**
 * 全屏轮播图
	bigBox: 指定banner容器，必填
	hasArrow： 指定是否有箭头，选填，默认为true
	hasButton： 指定是否有小按钮，选填，默认为true
	changeSpeed：指定切换图片的速度，选填，单位为ms
	time4Interval: 指定切换图片的时间间隔，选填，单位为ms
	arrowTrigger: 指定触发箭头的方法，二选一选填，默认为点击
	buttonTrigger: 指定触发按钮的方法，二选一选填，默认为鼠标移入
 */
require.config({
	paths: {
		jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
	}
});

require(["jquery", "autoplay","window", "common"], function ($, a, w) {
    new a.Autoplay().autoplay({
        box: $("#banner"),
        hasArrow: true,
        hasButton: true,
        changeSpeed: 600,
        time4Interval: 4000,
        arrowTrigger: "click",
        buttonTrigger: "mouseover"
    });

    $("#login").click(function () {
        new w.Window().login({
            box: $(window),
            title: "立即登录",
            hasMask: true,
            fixed: false,
            fadeIn: false,
            height: 315,
            width: 400,
            text4loginUserPlaceholder: "请输入您的注册邮箱",
            text4loginPwdPlaceholder: "请输入您的密码",
            text4autoLogin: "七天内自动登陆"
        })
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


