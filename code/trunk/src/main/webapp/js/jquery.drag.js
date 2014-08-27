(function(fn) {
	typeof define == 'function' && define.amd
			? define(['jquery'], fn)
			: fn(jQuery);
})(function(jq) {
			var drag = function($o, t) {
				var $t = t ? jq(t) : $o;
				var objs = {
					dragingFlag : false,
					target : {},
					offsetX : 0,
					offsetY : 0,
					mouseDownFn : function(event) {
						var o = objs;
						o.dragingFlag = true;
						var event = o.wrapperEvent(event);
						o.offsetX = event.x - o.target.offset().left;
						o.offsetY = event.y - o.target.offset().top;
					},
					mouseUpFn : function(event) {
						objs.dragingFlag = false;
					},
					moveFn : function(event) {
						var o = objs;
						if (o.dragingFlag == false)
							return;
						if (event.preventDefault)
							event.preventDefault();
						else
							event.returnValue = false;
						var event = o.wrapperEvent(event);
						var offsetTop = event.y - o.offsetY;
						var offsetLeft = event.x - o.offsetX;
						if (offsetTop > $(document).height() - $o.height()) {
							return;
						}
						if (offsetLeft > $(document).width() - $o.width()) {
							return;
						}
						o.target.offset({
									top : event.y - o.offsetY,
									left : event.x - o.offsetX
								});
					},
					wrapperEvent : function(event) {
						if (!event) {
							event = window.event;
							event.target = event.srcElement;
							event.layerX = event.offsetX;
							event.layerY = event.offsetY;
						}
						if (event.stopPropagation)
							event.stopPropagation();
						else
							event.cancelBubble = true;
						event.x = event.pageX || event.clientX
								+ document.body.scrollLeft;
						event.y = event.pageY || event.clientY
								+ document.body.scrollTop
						return event;
					}
				};
				objs.target = $t;
				$o.css('cursor', 'move');
				$o.bind('mousedown', objs.mouseDownFn);
				jq(document).bind('mousemove', objs.moveFn);
				jq(document).bind('mouseup', objs.mouseUpFn);
			}
			jq.fn.drag = function(target) {
				drag(this, target);
			}
			jq.drag = function(id, target) {
				drag(jq(id), target);
			}
		});