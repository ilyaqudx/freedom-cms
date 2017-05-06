$(function() {
	$("#submit").click(function() {
		var total = $("#total").val();
		if(total == "" || total == null){
			layer.msg("出现总个数不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美个数不能为空");
			return;
		}
		var ordinaryNum = $("#ordinaryNum").val();
		if(ordinaryNum == "" || ordinaryNum == null){
			layer.msg("普通个数不能为空");
			return;
		}
		var minTime = $("#minTime").val();
		if(minTime == "" || minTime == null){
			layer.msg(" 最小时间不能为空");
			return;
		}
		var type = $("#type").val();
		if(type == "" || type == null){
			layer.msg("题目类型不能为空");
			return;
		}
		var turn = $("#turn").val();
		if(turn == "" || turn == null){
			layer.msg("是否翻转不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				total : total,
				perfectNum : perfectNum,
				ordinaryNum :ordinaryNum,
				minTime : minTime,
				type : type,
				turn : turn
		};
		$.ajax({
			type : 'POST',
			url : 'tetris/edit',
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
