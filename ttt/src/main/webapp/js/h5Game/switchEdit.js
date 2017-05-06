$(function() {
	$("#submit").click(function() {
		var timeForPer = $("#timeForPer").val();
		if(timeForPer == "" || timeForPer == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var oddsOfBad = $("#oddsOfBad").val();
		if(oddsOfBad == "" || oddsOfBad == null){
			layer.msg("出现坏开关的几率不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关正确次数不能为空");
			return;
		}
		var ordinaryNum = $("#ordinaryNum").val();
		if(ordinaryNum == "" || ordinaryNum == null){
			layer.msg("普通通关正确次数不能为空");
			return;
		}
		var minSwitchStop = $("#minSwitchStop").val();
		if(minSwitchStop == "" || minSwitchStop == null){
			layer.msg("开关停留最小值不能为空");
			return;
		}
		var maxSwitchStop = $("#maxSwitchStop").val();
		if(maxSwitchStop == "" || maxSwitchStop == null){
			layer.msg("开关停留最大值不能为空");
			return;
		}
		var minEmptyWait = $("#minEmptyWait").val();
		if(minEmptyWait == "" || minEmptyWait == null){
			layer.msg("空屏等待间隔时间最小值不能为空");
			return;
		}
		var maxEmptyWait = $("#maxEmptyWait").val();
		if(maxEmptyWait == "" || maxEmptyWait == null){
			layer.msg("空屏等待间隔时间最大值不能为空");
			return;
		}
		var maxNum = $("#maxNum").val();
		if(maxNum == "" || maxNum == null){
			layer.msg("最多出现个数不能为空");
			return;
		}
		var minNum = $("#minNum").val();
		if(minNum == "" || minNum == null){
			layer.msg("最少出现个数为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				timeForPer : timeForPer,
				oddsOfBad : oddsOfBad,
				perfectNum : perfectNum,
				ordinaryNum :ordinaryNum,
				minSwitchStop : minSwitchStop,
				maxSwitchStop : maxSwitchStop,
				minEmptyWait : minEmptyWait,
				maxEmptyWait : maxEmptyWait,
				maxNum : maxNum,
				minNum : minNum
		};
	
		$.ajax({
			type : 'POST',
			url : 'switch/edit',
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
