/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2014-10-25 19:14:35
 * @version $Id$
 */

define(["jquery", "widget"], function ($, w){
	function Autoplay(){
		this.cfg = {
			box: {},
			hasArrow: true,
			hasButton: true,
			changeSpeed: 500,
			time4Interval: 3000,
			arrowTrigger: "click",
			buttonTrigger: "mouseover"
		}
	}

	Autoplay.prototype = $.extend({}, new w.Widget(), {
		renderUI: function(){
			this.imgLength = (this.cfg.box).find('ul a').length; //获取当前banner图片的数量
			this.boxWidth = (this.cfg.box).width();//获取当前Box宽度
			this.ulBox = this.cfg.box.find("ul")[0];

			if(this.cfg.hasArrow){
				this.arrows = $("<a href='javascript:' class='autoplay_prevArrow'><</a><a href='javascript:' class='autoplay_nextArrow'>></a>")
				this.arrows.appendTo(this.cfg.box).hide();
				this.prevArrow = $('.autoplay_prevArrow');
				this.nextArrow = $('.autoplay_nextArrow');
			}
		},

		bindUI: function(){
			//alert(this.boxWidth);
			var self = this;
			this.index = 0;
			/*绑定move事件*/
			this.on("move", function(){
				$(self.ulBox).stop().animate({
					left: -self.index*self.boxWidth
				}, self.cfg.changeSpeed);
			})
			/*自动轮播*/
			this.autoMove = function (){
				if(self.index === self.imgLength-1){
					self.index = 0;
				}else{
					self.index += 1;
				}
				self.fire("move", self.index);
			}
			var timer = setInterval(this.autoMove, this.cfg.time4Interval);
			this.cfg.box.mouseenter(function() {
				clearInterval(timer);
				self.arrows.show();
			});
			this.cfg.box.mouseleave(function() {
				clearInterval(timer);
				timer = setInterval(self.autoMove, self.cfg.time4Interval);
				self.arrows.fadeOut();
			});
			/*小箭头功能*/
			if(this.cfg.hasArrow){
				if(this.cfg.arrowTrigger == "mouseover"){
					this.prevArrow.mouseover(function(){
						if(self.index === 0){
							self.index = self.imgLength - 1;
						}else{
							self.index -= 1;
						}
						self.fire("move", self.index);
					});
					this.nextArrow.mouseover(function(){
						if(self.index === self.imgLength - 1){
							self.index = 0;
						}else{
							self.index += 1;
						}
						self.fire("move", self.index);
					});
				}else{
					this.prevArrow.click(function(){
						if(self.index === 0){
							self.index = self.imgLength - 1;
						}else{
							self.index -= 1;
						}
						self.fire("move", self.index);
					});

					this.nextArrow.click(function(){
						if(self.index === self.imgLength - 1){
							self.index = 0;
						}else{
							self.index += 1;
						}
						self.fire("move", self.index);
					});
				}
			}
			/*当屏幕发生改变时*/
			$(window).resize(function(){
				self.boxWidth = (self.cfg.box).width();
				$(self.ulBox).width(self.imgLength*self.boxWidth).find('a').width(self.boxWidth);
				self.fire("move");
			});

		},

		synsUI: function(){
			$(this.ulBox).width(this.imgLength*this.boxWidth).find('a').width(this.boxWidth);
		},

		destructor: function(){

		},

		autoplay: function(cfg){
			$.extend(this.cfg, cfg);
			this.render(this.cfg.box);
			return this;
		}
	});



	return {
		Autoplay: Autoplay
	}
})