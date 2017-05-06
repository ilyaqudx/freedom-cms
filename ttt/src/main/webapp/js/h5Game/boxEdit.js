$(function() {
	$("#submit").click(function() {
		var eachtime = $("#eachtime").val();
		if(eachtime == "" || eachtime == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var type = $("#type").val();
		if(type == "" || type == null){
			layer.msg("难度类型不能为空");
			return;
		}
		var number = $("#number").val();
		if(number == "" || number == null){
			layer.msg("每关答题个数不能为空");
			return;
		}
		var ordinarydegree = $("#ordinarydegree").val();
		if(ordinarydegree == "" || ordinarydegree == null){
			layer.msg("普通通关完成度不能为空");
			return;
		}
		var perfectdegree = $("#perfectdegree").val();
		if(perfectdegree == "" || perfectdegree == null){
			layer.msg("完美通关完成度不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				eachtime : eachtime,
				type : type,
				number :number,
				ordinarydegree : ordinarydegree,
				perfectdegree : perfectdegree,
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
			url : 'box/edit',
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
