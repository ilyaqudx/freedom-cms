$(function() {
	$("#submit").click(function() {
		var stageLength = $("#stageLength").val();
		if(stageLength == "" || stageLength == null){
			layer.msg("关卡长度不能为空");
			return;
		}
		var operationNum = $("#operationNum").val();
		if(operationNum == "" || operationNum == null){
			layer.msg("需要操作的数量不能为空");
			return;
		}
		var colorRate = $("#colorRate").val();
		if(colorRate == "" || colorRate == null){
			layer.msg("操作比例不能为空");
			return;
		}
		var blood = $("#blood").val();
		if(blood == "" || blood == null){
			layer.msg("血量不能为空");
			return;
		}
		var firstColor = $("#firstColor").val();
		if(firstColor == "" || firstColor == null){
			layer.msg("第一阶段需求个数不能为空");
			return;
		}
		var secondColor = $("#secondColor").val();
		if(secondColor == "" || secondColor == null){
			layer.msg("第二阶段增加个数 不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关操作个数不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				stageLength : stageLength,
				operationNum :operationNum,
				colorRate : colorRate,
				blood : blood,
				firstColor : firstColor,
				secondColor : secondColor,
				perfectNum : perfectNum
		};
		$.ajax({
			type : 'POST',
			url : 'color/edit',
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
