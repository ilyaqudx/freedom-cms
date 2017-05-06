$(function() {
	$("#submit").click(function() {
		var time = $("#time").val();
		if(time == "" || time == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var rule = $("#rule").val();
		if(rule == "" || rule == null){
			layer.msg("法则不能为空");
			return;
		}
		var generalNum = $("#generalNum").val();
		if(generalNum == "" || generalNum == null){
			layer.msg("普通通关正确次数不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关正确次数不能为空");
			return;
		}
		var reactionTimeMin = $("#reactionTimeMin").val();
		if(reactionTimeMin == "" || reactionTimeMin == null){
			layer.msg("反应时间最小值不能为空");
			return;
		}
		var reactionTimeMax = $("#reactionTimeMax").val();
		if(reactionTimeMax == "" || reactionTimeMax == null){
			layer.msg("反应时间最大值不能为空");
			return;
		}
		var intervalTime = $("#intervalTime").val();
		if(intervalTime == "" || intervalTime == null){
			layer.msg("间隔时间不能为空");
			return;
		}
		var speed = $("#speed").val();
		if(speed == "" || speed == null){
			layer.msg("生成速度不能为空");
			return;
		}
		var upSpeed = $("#upSpeed").val();
		if(upSpeed == "" || upSpeed == null){
			layer.msg("上升速度不能为空");
			return;
		}
		var answerPosition = $("#answerPosition").val();
		if(answerPosition == "" || answerPosition == null){
			layer.msg("答案不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				time : time,
				rule : rule,
				generalNum :generalNum,
				perfectNum : perfectNum,
				reactionTimeMin : reactionTimeMin,
				reactionTimeMax : reactionTimeMax,
				intervalTime : intervalTime,
				speed : speed,
				upSpeed : upSpeed,
				answerPosition : answerPosition,
		};
	/*	$.post("balloon/edit",{param : JSON.stringify(params)},function(data){
			debugger
			layer.msg("修改成功");
			parent.location.reload();
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		});*/
		$.ajax({
			type : 'POST',
			url : 'balloon/edit',
			data : 'param=' + JSON.stringify(params),
			dataType : 'json',
			success:function(data){
				layer.msg("修改成功");
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
		
	});
	
});
