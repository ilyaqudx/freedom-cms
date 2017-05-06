$(function() {
	$("#submit").click(function() {
		var taskType = $("#taskType").val();
		if(taskType == "" || taskType == null){
			layer.msg("任务类型不能为空");
			return;
		}
		var tools = $("#tools").val();
		if(tools == "" || tools == null){
			layer.msg("道具不能为空");
			return;
		}
		var gainTools = $("#gainTools").val();
		if(gainTools == "" || gainTools == null){
			layer.msg("增益道具几率不能为空");
			return;
		}
		var debuff = $("#debuff").val();
		if(debuff == "" || debuff == null){
			layer.msg("减益道具几率不能为空");
			return;
		}
		var animalSpeed = $("#animalSpeed").val();
		if(animalSpeed == "" || animalSpeed == null){
			layer.msg("猫下落时间不能为空");
			return;
		}
		var monsterSpeed = $("#monsterSpeed").val();
		if(monsterSpeed == "" || monsterSpeed == null){
			layer.msg("怪物下落时间不能为空");
			return;
		}
		var animalInterval = $("#animalInterval").val();
		if(animalInterval == "" || animalInterval == null){
			layer.msg("友方间隔时间不能为空");
			return;
		}
		var animalBeed = $("#animalBeed").val();
		if(animalBeed == "" || animalBeed == null){
			layer.msg("友方频率不能为空");
			return;
		}
		var animalNumber = $("#animalNumber").val();
		if(animalNumber == "" || animalNumber == null){
			layer.msg("友方数量不能为空");
			return;
		}
		var monsterInterval = $("#monsterInterval").val();
		if(monsterInterval == "" || monsterInterval == null){
			layer.msg("敌方间隔不能为空");
			return;
		}
		var monsterBeed = $("#monsterBeed").val();
		if(monsterBeed == "" || monsterBeed == null){
			layer.msg("敌方频率不能为空");
			return;
		}
		var monsterNumber = $("#monsterNumber").val();
		if(monsterNumber == "" || monsterNumber == null){
			layer.msg("友方数量不能为空");
			return;
		}
		var score = $("#score").val();
		if(score == "" || score == null){
			layer.msg("正确得分不能为空");
			return;
		}
		var pick = $("#pick").val();
		if(pick == "" || pick == null){
			layer.msg("错误扣分不能为空");
			return;
		}
		var ordinaryDegree = $("#ordinaryDegree").val();
		if(ordinaryDegree == "" || ordinaryDegree == null){
			layer.msg("普通通关不能为空");
			return;
		}
		var perfectDegree = $("#perfectDegree").val();
		if(perfectDegree == "" || perfectDegree == null){
			layer.msg("完美通关不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				taskType : taskType,
				tools : tools,
				gainTools :gainTools,
				debuff : debuff,
				animalSpeed : animalSpeed,
				monsterSpeed : monsterSpeed,
				animalInterval : animalInterval,
				animalBeed : animalBeed,
				animalNumber : animalNumber,
				monsterInterval : monsterInterval,
				monsterBeed : monsterBeed,
				monsterNumber : monsterNumber,
				score : score,
				pick : pick,
				ordinaryDegree : ordinaryDegree,
				perfectDegree : perfectDegree
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
			url : 'cat/edit',
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
