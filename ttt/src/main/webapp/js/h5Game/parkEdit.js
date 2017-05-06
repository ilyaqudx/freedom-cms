$(function() {
	$("#submit").click(function() {
		var parkNum = $("#parkNum").val();
		if(parkNum == "" || parkNum == null){
			layer.msg("停车数目不能为空");
			return;
		}
		var sceneId = $("#sceneId").val();
		if(sceneId == "" || sceneId == null){
			layer.msg("场景不能为空");
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
		var stopTime = $("#stopTime").val();
		if(stopTime == "" || stopTime == null){
			layer.msg("允许停留时间不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				parkNum : parkNum,
				sceneId : sceneId,
				perfectNum :perfectNum,
				ordinaryNum : ordinaryNum,
				minMemoryTime : minMemoryTime,
				maxMemoryTime : maxMemoryTime,
				stopTime : stopTime,
		};
		$.ajax({
			type : 'POST',
			url : 'park/edit',
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
