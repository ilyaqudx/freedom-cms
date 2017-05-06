$(function() {
	$("#submit").click(function() {
		var timeForPer = $("#timeForPer").val();
		if(timeForPer == "" || timeForPer == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var orderNum = $("#orderNum").val();
		if(orderNum == "" || orderNum == null){
			layer.msg("订单数量不能为空");
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
		var minStop = $("#minStop").val();
		if(minStop == "" || minStop == null){
			layer.msg("停留最小值不能为空");
			return;
		}
		var maxStop = $("#maxStop").val();
		if(maxStop == "" || maxStop == null){
			layer.msg("停留最大值不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				timeForPer : timeForPer,
				orderNum : orderNum,
				perfectNum : perfectNum,
				ordinaryNum : ordinaryNum,
				minStop : minStop,
				maxStop : maxStop,
		};
		$.ajax({
			type : 'POST',
			url : 'fruit/edit',
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
