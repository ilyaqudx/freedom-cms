$(function() {
	$("#submit").click(function() {
		var timeForPer = $("#timeForPer").val();
		if(timeForPer == "" || timeForPer == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var gridNumberType = $("#gridNumberType").val();
		if(gridNumberType == "" || gridNumberType == null){
			layer.msg("格子数量类型不能为空");
			return;
		}
		var imageType = $("#imageType").val();
		if(imageType == "" || imageType == null){
			layer.msg("图片类型不能为空");
			return;
		}
		var memoryInfoNumber = $("#memoryInfoNumber").val();
		if(memoryInfoNumber == "" || memoryInfoNumber == null){
			layer.msg("记忆信息数量不能为空");
			return;
		}
		var perfectTime = $("#perfectTime").val();
		if(perfectTime == "" || perfectTime == null){
			layer.msg("完美作答时间用时不能为空");
			return;
		}
		var minMemoryTime = $("#minMemoryTime").val();
		if(minMemoryTime == "" || minMemoryTime == null){
			layer.msg("记忆时间最小值不能为空");
			return;
		}
		var maxMemoryTime = $("#maxMemoryTime").val();
		if(maxMemoryTime == "" || maxMemoryTime == null){
			layer.msg("记忆时间最大值不能为空");
			return;
		}
		var memoryInterval = $("#memoryInterval").val();
		if(memoryInterval == "" || memoryInterval == null){
			layer.msg("记忆间隔不能为空");
			return;
		}
		var handleType = $("#handleType").val();
		if(handleType == "" || handleType == null){
			layer.msg("可操作数量种类不能为空");
			return;
		}
		var turn = $("#turn").val();
		if(turn == "" || turn == null){
			layer.msg("是否翻转不能为空");
			return;
		}
		var totalTurns = $("#totalTurns").val();
		if(totalTurns == "" || totalTurns == null){
			layer.msg("总轮数不能为空");
			return;
		}
		var perfectTurns = $("#perfectTurns").val();
		if(perfectTurns == "" || perfectTurns == null){
			layer.msg("完美通关正确轮数不能为空");
			return;
		}
		var ordinaryTurns = $("#ordinaryTurns").val();
		if(ordinaryTurns == "" || ordinaryTurns == null){
			layer.msg("普通通关正确轮数不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				timeForPer : timeForPer,
				gridNumberType : gridNumberType,
				imageType : imageType,
				memoryInfoNumber : memoryInfoNumber,
				perfectTime : perfectTime,
				minMemoryTime : minMemoryTime,
				maxMemoryTime : maxMemoryTime,
				memoryInterval : memoryInterval,
				handleType : handleType,
				turn : turn,
				totalTurns : totalTurns,
				perfectTurns : perfectTurns,
				ordinaryTurns : ordinaryTurns
		};
		$.ajax({
			type : 'POST',
			url : 'cardH/edit',
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
