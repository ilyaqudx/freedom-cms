$(function() {
	$("#submit").click(function() {
		var diff = $("#diff").val();
		if(diff == "" || diff == null){
			layer.msg("难度不能为空");
			return;
		}
		var simpleTime = $("#simpleTime").val();
		if(simpleTime == "" || simpleTime == null){
			layer.msg("单次时间不能为空");
			return;
		}
		var time = $("#time").val();
		if(time == "" || time == null){
			layer.msg("时间不能为空");
			return;
		}
		var passNum = $("#passNum").val();
		if(passNum == "" || passNum == null){
			layer.msg("通关车次不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关车次不能为空");
			return;
		}
		
		
		var id = $("#stageId").val();
		var params = {
				id :id,
				diff:diff,
				time:time,
				simpleTime:simpleTime,
				passNum:passNum,
				perfectNum :perfectNum
		};
		$.ajax({
			type : 'POST',
			url : 'truck/edit',
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
