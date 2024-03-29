/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2014-10-27 13:08:00
 * @version $Id$
 */

define(["jquery", "widget", "validate", "jquery.md5"], function ($, w){
	function Window(){
		this.cfg = {
			box: $(window),
			title: "系统提示",
			hasMask: true,
			fixed: false,
			fadeIn: false,
			autoRemoved: 0,
			time4Removed: 0,
			content: "",
			width: 500,
			height: 300,
            boxStyle: "",
            headerStyle: "",
            footerStyle: "",
            closeBtn: true,
			text4AlertBtn: "知道啦！",
			text4loginUserPlaceholder: "请输入你的账号",
			text4loginPwdPlaceholder: "请输入你的密码",
            rules4RegisterUser: "请输入用户账号",
            rules4RegisterPwd: "请输入用户密码",
            rules4RegisterEmail: "请输入正确格式的电子邮箱",
            rules4RegisterPwdAgain: "两次输入的结果不一致",
            text4RegisterUser:"请输入你的昵称，长度为3-15",
            text4autoLogin: "允许自动登录"
		}
	}

	Window.prototype = $.extend({}, new w.Widget(), {

		renderUI: function(){
			this.footerContent = "";
			switch(this.cfg.winType){
				case "alert":
				break;

				case "login":
                    /*判断是否拥有placeholder*/
                    var userLabel, passwordLabel;
                    if('placeholder' in document.createElement('input')){
                        userLabel = "";
                        passwordLabel = "";
                    }else{
                        userLabel = this.cfg.text4loginUserPlaceholder;
                        passwordLabel = this.cfg.text4loginPwdPlaceholder;
                    }
                    /*登陆主体*/
                    this.cfg.content = "<form action='/user/login.do' method='POST' id='window_login'><label id='loginResponse' class='window_inputError'></label><input type='email' placeholder=" +
                    this.cfg.text4loginUserPlaceholder + " class='window_emailInput window_formInput' name='email' required='required' id='L_email'><label class='window_inputError'>"+
                    userLabel +"</label><input type='password' placeholder=" +
                    this.cfg.text4loginPwdPlaceholder + " class='window_passwordInput window_formInput' name='L_originPwd' required id='L_originPwd'><label class='window_inputError' for='L_originPwd'>"+
                    passwordLabel +"</label><div class='window_loginOthers'><a href='#' class='window_forgotPwd fr'>忘记密码</a><input type='checkbox' id='loginAuto' name='autoLoginTo' style='vertical-align:middle;' value='true'><label style='vertical-align:middle;' for='loginAuto'>" +
                        this.cfg.text4autoLogin + "</label></div><input type='hidden' id='L_pwd' name='password'><input type='submit' class='window_submitBtn' value='登录' id='loginSubmit'><div class='window_loginOthers'><a href='javascript:' class='window_toRegister fr'>立即注册</a></div></form>";
				break;

                case "register":
                    this.cfg.content = "<form action='/user/register.do' method='post' id='window_register'><input type='text' class='window_userInput window_formInput' name='nick' required id='nick'><label class='window_inputError' for='window_registerUser'>" +
                    this.cfg.text4RegisterUser +"</label><input type='email' required name='email' class='window_emailInput window_formInput'><label class='window_inputError' for='R_email'>" +
                    this.cfg.rules4RegisterEmail +"</label><input type='password' class='window_passwordInput window_formInput' id='R_originPwd'  name='originPwd' required='required'><label class='window_inputError' for='R_originPwd'>" +
                    this.cfg.rules4RegisterPwd +"</label><input type='password' class='window_passwordInput window_formInput'  required='required' id='R_originPwd1' name='originPwd1'><label class='window_inputError' for='R_originPwd1'>请再一次输入密码</label><div class='window_registerOthers'><input type='checkbox' name='R_service' checked='checked' style='vertical-align:middle;'><span  style='vertical-align:middle;'>我已阅读并同意</span><a href=" +
                    this.cfg.serviceURL +" class='window_registerService' style='vertical-align:middle;'>" +
                    this.cfg.text4Service +"</a></div><input type='hidden' name='password' id='R_pwd'><input type='submit' class='window_submitBtn' value='注册'></form>";
                    break;
			}
			//弹窗的总体结构，包括头部、内容和底部按钮
			this.boundingBox = $(
					"<div class='window_boundingBox'><div class='window_body'>" +
					this.cfg.content + "</div></div>"
			);

			this.header = $("<div class='window_header'>" + this.cfg.title + "</div>").prependTo(this.boundingBox);
			this.footer = $("<div class='window_footer'>" + this.footerContent + "</div>").appendTo(this.boundingBox);

			//关闭按钮
            if(this.cfg.closeBtn){
                this.closeBtn = $("<a href='javascript:' class='window_closeBtn'>X</a>")
                this.closeBtn.appendTo(this.boundingBox);
            }


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
            if(this.cfg.closeBtn){
                this.closeBtn.click(function(){
                    self.destroy();
                });
            }

            /*窗口改变*/
            $(window).resize(function(){
                self.boundingBox.css({
                    left : ( self.cfg.x|| (window.innerWidth - self.cfg.width) / 2 ) + "px", //若未定义x，y坐标
                    top : ( self.cfg.y||(window.innerHeight - self.cfg.height) / 2 ) + "px"//默认居中
                });
            })
            /*判断不同的弹框，不同的行为*/
			if(this.cfg.winType == "login"){
                var toRegister = $(".window_toRegister");
                toRegister.click(function(){
                    self.destroy();
                    $("#register").click();
                })
			}

            /*Validate验证信息*/
            switch (this.cfg.winType) {
                case "login":
                    $("#window_login").validate({
                        rules: {
                            email: {
                                required: true,
                                email: true
                            },
                            L_originPwd: {
                                required: true
                            }
                        },
                        messages: {
                            email: {
                                required: "忘记填写账号啦！"
                            },
                            L_originPwd: {
                                required: "记得填写密码哟！"
                            }
                        },
                        /*修改错误出现的地方*/
                        errorPlacement: function (error, element) {
                            element.next().html(error);
                        },
                        /*MD5加密,提交表单前的验证*/
                        submitHandler:function(form){
                            var $password = $("#L_originPwd");
                            var pwd = $("#L_pwd");
                            $("#loginSubmit").val("登录中...");
                            pwd.val($.md5($password.val()));
                            $password.attr("disabled", "disabled");
                            $("#loginResponse").text("");
                            $.post("/user/login.do", $(form).serialize(), function(data){
                                if(data.response){
                                    window.location.reload();
                                }else{
                                    $password.removeAttr("disabled").val("").addClass("error");
                                    $("#loginResponse").text(data.msg.text);
                                    $("#loginSubmit").val("登陆")
                                }
                            });
                        }
                    });
                    break;
                /*注册验证*/
                case "register":
                    $("#window_register").validate({
                        onkeyup: "false",
                        rules: {
                            nick: {
                                required: true,
                                rangelength: [3, 15],
                                remote: {
                                    url: "/user/asyncValidate.do",
                                    type: "post",
                                    dataType: "json",
                                    data: {
                                        nick: function() {
                                            return $("#nick").val();
                                        }
                                    }
                                }
                            },
                            originPwd: {
                                required: true,
                                minlength: 6
                            },
                            originPwd1: {
                                required: true,
                                minlength: 6,
                                equalTo: "#R_originPwd"
                            },
                            email: {
                                email: true,
                                required: true,
                                remote: {
                                    url: "/user/asyncValidate.do",
                                    type: "post",
                                    dataType: "json",
                                    data: {
                                        nick: function() {
                                            return $("#nick").val();
                                        }
                                    }
                                }
                            },
                            registerService: {
                                required: true
                            }
                        },
                        messages: {
                            nick: {
                                required: this.cfg.rules4RegisterUser,
                                rangelength: this.cfg.rules4RegisterUser,
                                remote: "该用户已经注册过"
                            },
                            originPwd: {
                                required: this.cfg.rules4RegisterPwd,
                                minlength: this.cfg.rules4RegisterPwd
                            },
                            originPwd1: {
                                required: this.cfg.rules4RegisterPwd,
                                minlength: this.cfg.rules4RegisterPwd,
                                equalTo: this.cfg.rules4RegisterPwdAgain
                            },
                            email: {
                                required: this.cfg.rules4RegisterEmail,
                                remote: "该邮箱已经注册过"
                            },
                            registerService: {
                                required: "请同意协议"
                            }
                        },
                        /*修改错误出现的地方*/
                        errorPlacement: function (error, element) {
                            if (element.attr("name") == "registerService") {
                                element.parent().append(error); //显示在后面
                            } else {
                                element.next().html(error); //显示在下面
                            }
                        },
                        /*表单提交前的操作，MD5加密，ajax验证*/
                        submitHandler: function (form) {
                            var $password = $("#R_originPwd");
                            var $password1 = $("#R_originPwd1");
                            $("#R_pwd").val($.md5($password.val()));
                            $password.attr("disabled", "disabled");
                            $password1.attr("disabled", "disabled");

                            $.post("/user/register.do", $(form).serialize(), function(data){
                                if(data.response){
                                    window.location.reload();
                                }else{
                                    alert("系统错误，请重新输入");
                                }
                            })
                        }
                    })
                break;
            }

            /*定时自动关闭*/
            if(this.cfg.autoRemoved){
                setTimeout(function(){
                    self.boundingBox.fadeOut(function(){
                        self.destroy();
                    })
                }, this.cfg.autoRemoved)
            }
		},

		synsUI: function(){
			this.boundingBox.css({
				width : this.cfg.width +'px',
				height : this.cfg.height +'px',
				left : ( this.cfg.x|| (window.innerWidth - this.cfg.width) / 2 ) + "px", //若未定义x，y坐标
				top : ( this.cfg.y||(window.innerHeight - this.cfg.height) / 2 ) + "px"//默认居中
			});
            if(this.cfg.boxStyle || this.cfg.headerStyle){
                this.boundingBox.addClass(this.cfg.boxStyle);
                this.header.addClass(this.cfg.headerStyle);
                this.footer.addClass(this.cfg.footerStyle)
            }

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