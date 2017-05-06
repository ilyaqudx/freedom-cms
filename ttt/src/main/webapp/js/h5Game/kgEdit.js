$(function() {
	$("#submit").click(function() {
		var type = $("#type").val();
		if(type == "" || type == null){
			layer.msg("任务类型不能为空");
			return;
		}
		var airportNumber = $("#airportNumber").val();
		if(airportNumber == "" || airportNumber == null){
			layer.msg("停机场个数不能为空");
			return;
		}
		var interfereAirport = $("#interfereAirport").val();
		if(interfereAirport == "" || interfereAirport == null){
			layer.msg("干扰停机场个数不能为空");
			return;
		}
		var minInterval = $("#minInterval").val();
		if(minInterval == "" || minInterval == null){
			layer.msg("间隔时间最小值不能为空");
			return;
		}
		var maxInterval = $("#maxInterval").val();
		if(maxInterval == "" || maxInterval == null){
			layer.msg("间隔时间最大值不能为空");
			return;
		}
		var life = $("#life").val();
		if(life == "" || life == null){
			layer.msg("生命不能为空");
			return;
		}
		var memoryTime = $("#memoryTime").val();
		if(memoryTime == "" || memoryTime == null){
			layer.msg("记忆时间不能为空");
			return;
		}
		var reactionTime = $("#reactionTime").val();
		if(reactionTime == "" || reactionTime == null){
			layer.msg("反应时间不能为空");
			return;
		}
		var fleets = $("#fleets").val();
		if(fleets == "" || fleets == null){
			layer.msg("飞机数量不能为空");
			return;
		}
		var memoryType = $("#memoryType").val();
		if(memoryType == "" || memoryType == null){
			layer.msg("记忆类型不能为空");
			return;
		}
		var random = $("#random").val();
		if(random == "" || random == null){
			layer.msg("随机类型不能为空");
			return;
		}
		var perfectDegree = $("#perfectDegree").val();
		if(perfectDegree == "" || perfectDegree == null){
			layer.msg("完美通关不能为空");
			return;
		}
		var ordinaryDegree = $("#ordinaryDegree").val();
		if(ordinaryDegree == "" || ordinaryDegree == null){
			layer.msg("普通通关不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				type : type,
				airportNumber : airportNumber,
				interfereAirport :interfereAirport,
				minInterval : minInterval,
				maxInterval : maxInterval,
				life : life,
				memoryTime : memoryTime,
				reactionTime : reactionTime,
				fleets : fleets,
				memoryType : memoryType,
				random : random,
				perfectDegree : perfectDegree,
				ordinaryDegree : ordinaryDegree
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
			url : 'kg/edit',
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
