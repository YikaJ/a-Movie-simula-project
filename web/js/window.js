/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2014-10-27 13:08:00
 * @version $Id$
 */

define(["jquery", "widget", "validate"], function ($, w){
	function Window(){
		this.cfg = {
			box: $(window),
			title: "系统提示",
			hasMask: true,
			fixed: false,
			fadeIn: false,
			autoRemoved: false,
			time4Removed: 0,
			content: "",
			width: 500,
			height: 300,
			text4AlertBtn: "知道啦！",
			text4loginUserPlaceholder: "请输入你的账号",
			text4loginPwdPlaceholder: "请输入你的密码",
            rules4RegisterUser: "请输入用户账号",
            rules4RegisterPwd: "请输入用户密码",
            rules4RegisterEmail: "请输入正确格式的电子邮箱",
            rules4RegisterPwdAgain: "两次输入的结果不一致",
            text4RegisterUser:"请输入你的昵称，长度为3-15"
		}
	}

	Window.prototype = $.extend({}, new w.Widget(), {

		renderUI: function(){
			var footerContent = "";
			switch(this.cfg.winType){
				case "alert":
                    footerContent = "<input type='button' class='window_alertBtn' value='"
                        + this.cfg.text4AlertBtn + "'>";
				break;

				case "login":
                    /*判断是否拥有placeholder*/
                    var userLabel, passwordLabel;
                    if('placeholder' in document.createElement('input')){
                        userLabel = "";
                        passwordLabel = "";
                    }else{
                        userLabel = "请输入账号";
                        passwordLabel = "请输入密码";
                    }
                    /*登陆主体*/
                    this.cfg.content = "<form action='#' method='post' id='window_login'><input type='text' placeholder=" +
                    this.cfg.text4loginUserPlaceholder + " class='window_userInput window_formInput' name='window_loginUser' required><label class='window_inputError'>"+
                    userLabel +"</label><input type='password' placeholder=" +
                    this.cfg.text4loginPwdPlaceholder + " class='window_passwordInput window_formInput' name='window_loginPwd' required><label class='window_inputError'>"+
                    passwordLabel +"</label><div class='window_loginOthers'><a href='javascript:' class='window_toRegister fl'>还没注册？</a><a href='#' class='window_forgotPwd fr'>忘记密码</a></div><input type='submit' class='window_submitBtn' value='登陆'></form>";
				break;

                case "register":
                    this.cfg.content = "<form action='#' method='post' id='window_register'><input type='text' class='window_userInput window_formInput' name='window_registerUser' required><label class='window_inputError' for='window_registerUser'>" +
                    this.cfg.text4RegisterUser +"</label><input type='password' class='window_passwordInput window_formInput' id='password' name='window_registerPwd' required><label class='window_inputError' for='window_registerPwd'>" +
                    this.cfg.rules4RegisterPwd +"</label><input type='password' class='window_passwordInput window_formInput' name='window_registerPwdAgain' required><label class='window_inputError' for='window_registerPwdAgain'>请再一次输入密码</label><input type='email' required name='window_registerEmail' class='window_emailInput window_formInput'><label class='window_inputError' for='window_registerEmail'>" +
                    this.cfg.rules4RegisterEmail +"</label><div class='window_registerOthers'><input type='checkbox' name='registerService' checked='checked'>我已阅读并同意<a href=" +
                    this.cfg.serviceURL +" class='window_registerService'>" +
                    this.cfg.text4Service +"</a></div><input type='submit' class='window_submitBtn' value='注册'></form>";
                    break;
			}
			//弹窗的总体结构，包括头部、内容和底部按钮
			this.boundingBox = $(
					"<div class='window_boundingBox'><div class='window_body'>" +
					this.cfg.content + "</div></div>"
			);

			$("<div class='window_header'>" + this.cfg.title + "</div>").prependTo(this.boundingBox);
			$("<div class='window_footer'>" + footerContent + "</div>").appendTo(this.boundingBox);

			//关闭按钮
			this.closeBtn = $("<a href='javascript:' class='window_closeBtn'>X</a>")
			this.closeBtn.appendTo(this.boundingBox);

			//遮罩模态组件生成
			if(this.cfg.hasMask){
				this.windowMask = $("<div class='window_mask'></div>");
				this.windowMask.appendTo(document.body);
			};

			this.boundingBox.appendTo(document.body);
		},
		bindUI: function(){
			var self = this;
            /*获取表单的输入框，并为其添加样式*/
            this.formInput = $(".window_formInput");
            this.formInput.focusin(function(){
                $(this).addClass('window_inputFocus');
            }).focusout(function(){
                $(this).removeClass('window_inputFocus');
            });
            /*点击关闭按钮*/
			this.closeBtn.click(function(){
				self.destroy();
			});
            /*判断不同的弹框，不同的行为*/
			if(this.cfg.winType == "login"){
                var toRegister = $(".window_toRegister");
				var userLogin = this.formInput.eq(0);
                toRegister.click(function(){
                    self.destroy();
                    $("#register").click();
                })
			}
			/*if(!("placeholder" in document.createElement("input"))) {
                if (this.cfg.winType == "login") {
                    *//*用户窗口*//*
                    userLogin.val(this.cfg.text4loginUserPlaceholder)
                    .focus(function () {
                        if ($(this).val() === self.cfg.text4loginUserPlaceholder) {
                            $(this).val("");
                        }
                    })
                }
            }*/
            /*Validate验证信息*/
            switch (this.cfg.winType) {
                case "login":
                    $("#window_login").validate({
                        rules: {
                            window_loginUser: {
                                required: true
                            },
                            window_loginPwd: {
                                required: true
                            }
                        },
                        messages: {
                            window_loginUser: {
                                required: "忘记填写账号啦！"
                            },
                            window_loginPwd: {
                                required: "记得填写密码哟！"
                            }
                        },
                        /*修改错误出现的地方*/
                        errorPlacement: function (error, element) {
                            element.next().html(error);
                        }
                    });
                    break;
                case "register":
                    $("#window_register").validate({
                        rules: {
                            window_registerUser: {
                                required: true,
                                rangelength: [3,15]
                            },
                            window_registerPwd: {
                                required: true,
                                minlength: 6
                            },
                            window_registerPwdAgain:{
                                required: true,
                                minlength: 6,
                                equalTo: "#password"
                            },
                            window_registerEmail: {
                                email: true,
                                required: true
                            },
                            registerService: {
                                required: true
                            }
                        },
                        messages: {
                            window_registerUser: {
                                required:  this.cfg.rules4RegisterUser,
                                rangelength: this.cfg.rules4RegisterUser
                            },
                            window_registerPwd: {
                                required:  this.cfg.rules4RegisterPwd,
                                minlength: this.cfg.rules4RegisterPwd
                            },
                            window_registerPwdAgain: {
                                required:  this.cfg.rules4RegisterPwd,
                                minlength: this.cfg.rules4RegisterPwd,
                                equalTo: this.cfg.rules4RegisterPwdAgain
                            },
                            window_registerEmail: {
                                required: this.cfg.rules4RegisterEmail
                            },
                            registerService: {
                                required: "请同意协议"
                            }
                        },
                        /*修改错误出现的地方*/
                        errorPlacement: function (error, element) {
                           if(element.attr("name") == "registerService"){
                                element.parent().append(error);
                            }else {
                               element.next().html(error);
                           }
                        }
                    });
                break;
            }
		},

		synsUI: function(){
			this.boundingBox.css({
				width : this.cfg.width +'px',
				height : this.cfg.height +'px',
				left : ( this.cfg.x|| (window.innerWidth - this.cfg.width) / 2 ) + "px", //若未定义x，y坐标
				top : ( this.cfg.y||(window.innerHeight - this.cfg.height) / 2 ) + "px"//默认居中
			});

		},
		destructor: function(){
			if(this.windowMask){
				this.windowMask.remove();
			}
		},
		alert: function(cfg){
			$.extend(this.cfg, cfg, {winType: "alert"});
			this.render(this.cfg.box);
			return this;
		},
		login: function(cfg){
			$.extend(this.cfg, cfg, {winType: "login"});
			this.render(this.cfg.box);
			return this;
		},
        register: function(cfg){
            $.extend(this.cfg, cfg, {winType: "register"});
            this.render(this.cfg.box);
            return this;
        }
	})

	return {Window: Window};
})