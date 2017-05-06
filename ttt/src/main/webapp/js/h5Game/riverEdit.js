$(function() {
	$("#submit").click(function() {
		var time = $("#time").val();
		if(time == "" || time == null){
			layer.msg("作答时间不能为空");
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
		var speed = $("#speed").val();
		if(speed == "" || speed == null){
			layer.msg("场景移动速度不能为空");
			return;
		}
		var train = $("#train").val();
		if(train == "" || train == null){
			layer.msg("火车次数不能为空");
			return;
		}
		var intervalTime = $("#intervalTime").val();
		if(intervalTime == "" || intervalTime == null){
			layer.msg("火车间隔时间不能为空");
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
				time : time,
				type : type,
				number :number,
				speed : speed,
				train : train,
				intervalTime : intervalTime,
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
			url : 'river/edit',
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
