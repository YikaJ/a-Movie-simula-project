/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2014-10-15 20:37:15
 * @version $Id$
 */

define(["jquery"],function($){
	function Widget(){
		this.boundingBox = null;
	};

	Widget.prototype = {
		on : function(type, handler){
			if(typeof this.handlers[type] == "undefined"){
				this.handlers[type] = [];
			}
			this.handlers[type].push(handler);
			return this;
		},
		fire : function(type, data){
			if(this.handlers[type] instanceof Array){
				var handler = this.handlers[type];
				for(var i = 0, len = this.handlers[type].length; i<len; i++){
					handler[i](data);
				}
			}
		},
		render : function(container){
			this.renderUI();
			this.handlers = {};
			this.bindUI();
			this.synsUI();
			container || $(document.body).append(this.boundingBox);
		},
		destroy : function(){
			this.destructor();
			this.boundingBox.off();   //移除事件处理函数
			this.boundingBox.remove();
		},

		renderUI : function(){},   //DOM元素初始化
		bindUI : function(){},    //给DOM绑定事件和自定义的事件
		syncUI : function(){},   //初始化UI属性，CSS和CLASS
		destructor : function(){} //销毁时的回调
	};

	return{
		Widget : Widget
	};
});