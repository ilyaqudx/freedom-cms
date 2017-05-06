$(function() {
	$("#submit").click(function() {
		var countdown = $("#countdown").val();
		if(countdown == "" || countdown == null){
			layer.msg("倒计时不能为空");
			return;
		}
		var oneOriginNum = $("#oneOriginNum").val();
		var oneFactNum = $("#oneFactNum").val();
		var oneOperationNum = $("#oneOperationNum").val();
		if(oneOriginNum == "" || oneOriginNum == null){
			layer.msg("第一阶段起始数不能为空");
			return;
		}
		if(oneFactNum == "" || oneFactNum == null){
			layer.msg("第一阶段出现数不能为空");
			return;
		}
		if(oneOperationNum == "" || oneOperationNum == null){
			layer.msg("第一阶段操作数不能为空");
			return;
		}
		var twoOriginNum = $("#twoOriginNum").val();
		var twoMemoryNum = $("#twoMemoryNum").val();
		var twoOperationNum = $("#twoOperationNum").val();
		if(twoOriginNum == "" || twoOriginNum == null){
			layer.msg("第二阶段起始数不能为空");
			return;
		}
		if(twoMemoryNum == "" || twoMemoryNum == null){
			layer.msg("第二阶段记忆数不能为空");
			return;
		}
		if(twoOperationNum == "" || twoOperationNum == null){
			layer.msg("第二阶段操作数不能为空");
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
		var perfectDegree = $("#perfectDegree").val();
		if(perfectDegree == "" || perfectDegree == null){
			layer.msg("完美通关完成度不能为空");
			return;
		}
		var ordinaryDegree = $("#ordinaryDegree").val();
		if(ordinaryDegree == "" || ordinaryDegree == null){
			layer.msg("普通通关完成度不能为空");
			return;
		}
		var rightScore = $("#rightScore").val();
		if(rightScore == "" || rightScore == null){
			layer.msg("正确分数不能为空");
			return;
		}
		var errScore = $("#errScore").val();
		if(errScore == "" || errScore == null){
			layer.msg("错误分数不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				countdown : countdown,
				oneOriginNum :oneOriginNum,
				oneFactNum :oneFactNum,
				oneOperationNum :oneOperationNum,
				twoOriginNum : twoOriginNum,
				twoMemoryNum : twoMemoryNum,
				twoOperationNum : twoOperationNum,
				minMemoryTime : minMemoryTime,
				maxMemoryTime : maxMemoryTime,
				perfectDegree : perfectDegree,
				ordinaryDegree : ordinaryDegree,
				rightScore : rightScore,
				errScore : errScore,
		};
		$.ajax({
			type : 'POST',
			url : 'fish/edit',
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
