/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2014-10-27 13:08:00
 * @version $Id$
 */

define(["jquery", "widget"], function ($, w){
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
			text4loginPwdPlaceholder: "请输入你的密码"
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
				this.cfg.content = "<form action='#' method='post' id='window_login'><input type='text' placeholder=" +
				this.cfg.text4loginUserPlaceholder + " class='window_user'><input type='password' placeholder=" +
				this.cfg.text4loginPwdPlaceholder + " class='window_password'></form><p class='window_loginOthers'><a href='#' class='window_toRegister fl'>还没注册？</a><a href='#' class='window_forgotPwd fr'>忘记密码</a></p>";
				footerContent = "<input type='button' class='window_loginBtn' value='登陆'>";
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
			this.closeBtn.click(function(){
				self.destroy();
			});
			if(this.cfg.winType == "login"){
				this.loginInput = $("#window_login input");
				var userLogin = this.loginInput.eq(0),
					pwdLogin = this.loginInput.eq(1);
				this.loginInput.focusin(function(){
					$(this).addClass('window_loginInputFocus');
				}).focusout(function(){
					$(this).removeClass('window_loginInputFocus');
				});
			}
			/*判断是否拥有placeHolder属性*/
			if(!("placeholder" in document.createElement("input"))) {
                if (this.cfg.winType == "login") {
                    /*用户窗口*/
                    userLogin.val(this.cfg.text4loginUserPlaceholder)
                        .focusin(function () {
                            if ($(this).val() === self.cfg.text4loginUserPlaceholder) {
                                $(this).val("");
                            }
                        })
                        .focusout(function () {
                            if ($(this).val() === "") {
                                $(this).val(self.cfg.text4loginUserPlaceholder);
                            }
                        });
                }
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
			};
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
		}
	})

	return {Window: Window};
})