$(function() {
	$("#submit").click(function() {
		var total = $("#total").val();
		if(total == "" || total == null){
			layer.msg("总数不能为空");
			return;
		}
		var minNum = $("#minNum").val();
		if(minNum == "" || minNum == null){
			layer.msg("飞碟数量最小值不能为空");
			return;
		}
		var maxNum = $("#maxNum").val();
		if(maxNum == "" || maxNum == null){
			layer.msg("飞碟数量最大值不能为空");
			return;
		}
		var boths = $("#boths").val();
		if(boths == "" || boths == null){
			layer.msg("是否双响不能为空");
			return;
		}
		var boss = $("#boss").val();
		if(boss == "" || boss == null){
			layer.msg("boss血量不能为空");
			return;
		}
		var bossNum = $("#bossNum").val();
		if(bossNum == "" || bossNum == null){
			layer.msg("boss次数不能为空");
			return;
		}
		var disappearTime = $("#disappearTime").val();
		if(disappearTime == "" || disappearTime == null){
			layer.msg("飞碟消失时间不能为空");
			return;
		}
		var cloudStop = $("#cloudStop").val();
		if(cloudStop == "" || cloudStop == null){
			layer.msg("云停留时间不能为空");
			return;
		}
		var minInterval = $("#minInterval").val();
		if(minInterval == "" || minInterval == null){
			layer.msg("间隔时间最小值不能为空");
			return;
		}
		var maxInterval = $("#maxInterval").val();
		if(maxInterval == "" || maxInterval == null){
			layer.msg("间隔时间最大值不能为空");
			return;
		}
		var ring1Score = $("#ring1Score").val();
		if(ring1Score == "" || ring1Score == null){
			layer.msg("1环的得分不能为空");
			return;
		}
		var ring2Score = $("#ring2Score").val();
		if(ring2Score == "" || ring2Score == null){
			layer.msg("2环的得分不能为空");
			return;
		}
		var ring3Score = $("#ring3Score").val();
		if(ring3Score == "" || ring3Score == null){
			layer.msg("3环的得分不能为空");
			return;
		}
		var ring4Score = $("#ring4Score").val();
		if(ring4Score == "" || ring4Score == null){
			layer.msg("4环的得分不能为空");
			return;
		}
		var ring5Score = $("#ring5Score").val();
		if(ring5Score == "" || ring5Score == null){
			layer.msg("5环的得分不能为空");
			return;
		}
		var errScore = $("#errScore").val();
		if(errScore == "" || errScore == null){
			layer.msg("错误扣分不能为空");
			return;
		}
		var perfectScore = $("#perfectScore").val();
		if(perfectScore == "" || perfectScore == null){
			layer.msg("完美通关得分不能为空");
			return;
		}
		var ordinaryScore = $("#ordinaryScore").val();
		if(ordinaryScore == "" || ordinaryScore == null){
			layer.msg("普通通关得分不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id :id,
				total:total,
				minNum:minNum,
				maxNum:maxNum,
				boths :boths,
				boss:boss,
				bossNum:bossNum,
				disappearTime:disappearTime,
				cloudStop:cloudStop,
				minInterval:minInterval,
				maxInterval:maxInterval,
				ring1Score:ring1Score,
				ring2Score:ring2Score,
				ring3Score:ring3Score,
				ring4Score:ring4Score,
				ring5Score:ring5Score,
				errScore:errScore,
				perfectScore:perfectScore,
				ordinaryScore:ordinaryScore
		};
		$.ajax({
			type : 'POST',
			url : 'disk/edit',
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
