$(function() {
	$("#submit").click(function() {
		var passTime = $("#passTime").val();
		if(passTime == "" || passTime == null){
			layer.msg("通关时间不能为空");
			return;
		}
		var perfectTime = $("#perfectTime").val();
		if(perfectTime == "" || perfectTime == null){
			layer.msg("完美通关时间不能为空");
			return;
		}
		var module = $("#module").val();
		if(module == "" || module == null){
			layer.msg("默认模块不能为空");
			return;
		}
		
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				passTime : passTime,
				perfectTime : perfectTime,
				module : module
		};
		$.ajax({
			type : 'POST',
			url : 'tangram/edit',
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
