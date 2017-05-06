$(function() {
	$("#submit").click(function() {
		var conveyorBelt1 = $("#conveyorBelt1").val();
		var conveyorBelt2 = $("#conveyorBelt2").val();
		var conveyorBelt3 = $("#conveyorBelt3").val();
		var conveyorBelt4 = $("#conveyorBelt4").val();
		if(conveyorBelt1 == "" || conveyorBelt1 == null){
			layer.msg("传送带不能为空");
			return;
		}
		if(conveyorBelt2 == "" || conveyorBelt2 == null){
			layer.msg("传送带不能为空");
			return;
		}
		if(conveyorBelt3 == "" || conveyorBelt3 == null){
			layer.msg("传送带不能为空");
			return;
		}
		if(conveyorBelt4 == "" || conveyorBelt4 == null){
			layer.msg("传送带不能为空");
			return;
		}
		var oddsOfBomb = $("#oddsOfBomb").val();
		if(oddsOfBomb == "" || oddsOfBomb == null){
			layer.msg("爆炸几率不能为空");
			return;
		}
		var fullThingNum = $("#fullThingNum").val();
		if(fullThingNum == "" || fullThingNum == null){
			layer.msg("完整物件个数不能为空");
			return;
		}
		var perfectDegree = $("#perfectDegree").val();
		if(perfectDegree == "" || perfectDegree == null){
			layer.msg("完美通关度不能为空");
			return;
		}
		var ordinaryDegree = $("#ordinaryDegree").val();
		if(ordinaryDegree == "" || ordinaryDegree == null){
			layer.msg("普通通关度不能为空");
			return;
		}
		var minSpeedDownUp = $("#minSpeedDownUp").val();
		if(minSpeedDownUp == "" || minSpeedDownUp == null){
			layer.msg("下往上速度最小值不能为空");
			return;
		}
		var maxSpeedDownUp = $("#maxSpeedDownUp").val();
		if(maxSpeedDownUp == "" || maxSpeedDownUp == null){
			layer.msg("下往上速度最大值不能为空");
			return;
		}
		var minSpeedUpDown = $("#minSpeedUpDown").val();
		if(minSpeedUpDown == "" || minSpeedUpDown == null){
			layer.msg("上往下速度最小值不能为空");
			return;
		}
		var maxSpeedUpDown = $("#maxSpeedUpDown").val();
		if(maxSpeedUpDown == "" || maxSpeedUpDown == null){
			layer.msg("上往下速度最大值不能为空");
			return;
		}
		var minTimeInterval = $("#minTimeInterval").val();
		if(minTimeInterval == "" || minTimeInterval == null){
			layer.msg("时间间隔最小值不能为空");
			return;
		}
		var maxTimeInterval = $("#maxTimeInterval").val();
		if(maxTimeInterval == "" || maxTimeInterval == null){
			layer.msg("时间间隔最大值不能为空");
			return;
		}
		var tasks = $("#tasks").val();
		if(tasks == "" || tasks == null){
			layer.msg("任务不能为空");
			return;
		}
		var repeatRate = $("#repeatRate").val();
		if(repeatRate == "" || repeatRate == null){
			layer.msg("重复率不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				conveyorBelt1 : conveyorBelt1,
				conveyorBelt2 : conveyorBelt2,
				conveyorBelt3 : conveyorBelt3,
				conveyorBelt4 : conveyorBelt4,
				oddsOfBomb : oddsOfBomb,
				fullThingNum : fullThingNum,
				perfectDegree : perfectDegree,
				ordinaryDegree : ordinaryDegree,
				minSpeedDownUp : minSpeedDownUp,
				maxSpeedDownUp : maxSpeedDownUp,
				minSpeedUpDown : minSpeedUpDown,
				maxSpeedUpDown : maxSpeedUpDown,
				minTimeInterval : minTimeInterval,
				maxTimeInterval : maxTimeInterval,
				tasks : tasks,
				repeatRate : repeatRate
		};
		$.ajax({
			type : 'POST',
			url : 'factoryH/edit',
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
