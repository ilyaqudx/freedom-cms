$(function() {
	$("#submit").click(function() {
		var times = $("#times").val();
		if(times == "" || times == null){
			layer.msg("次数不能为空");
			return;
		}
		var type = $("#type").val();
		if(type == "" || type == null){
			layer.msg("类型不能为空");
			return;
		}
		var oneBeginNum = $("#oneBeginNum").val();
		if(oneBeginNum == "" || oneBeginNum == null){
			layer.msg("1类型初始出现个数不能为空");
			return;
		}
		var oneScreenNum = $("#oneScreenNum").val();
		if(oneScreenNum == "" || oneScreenNum == null){
			layer.msg("1类型每屏出现个数不能为空");
			return;
		}
		var twoTitleNum = $("#twoTitleNum").val();
		if(twoTitleNum == "" || twoTitleNum == null){
			layer.msg("2类型题目每波个数不能为空");
			return;
		}
		var twoDisturbNum = $("#twoDisturbNum").val();
		if(twoDisturbNum == "" || twoDisturbNum == null){
			layer.msg("2类型答题阶段干扰数不能为空");
			return;
		}
		var twoStageWave = $("#twoStageWave").val();
		if(twoStageWave == "" || twoStageWave == null){
			layer.msg("2类型题目阶段波次不能为空");
			return;
		}
		var oneDiveTime = $("#oneDiveTime").val();
		if(oneDiveTime == "" || oneDiveTime == null){
			layer.msg("1类型下潜时间不能为空");
			return;
		}
		var twoExistTime = $("#twoExistTime").val();
		if(twoExistTime == "" || twoExistTime == null){
			layer.msg("2类型每波队存在时间不能为空");
			return;
		}
		var maxStop = $("#maxStop").val();
		if(maxStop == "" || maxStop == null){
			layer.msg("允许最大停留时间不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关完成度不能为空");
			return;
		}
		var ordinaryNum = $("#ordinaryNum").val();
		if(ordinaryNum == "" || ordinaryNum == null){
			layer.msg("普通通关完成度不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				times : times,
				type : type,
				oneBeginNum :oneBeginNum,
				oneScreenNum : oneScreenNum,
				twoTitleNum : twoTitleNum,
				twoDisturbNum : twoDisturbNum,
				twoStageWave : twoStageWave,
				oneDiveTime : oneDiveTime,
				twoExistTime : twoExistTime,
				maxStop : maxStop,
				perfectNum : perfectNum,
				ordinaryNum : ordinaryNum
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
			url : 'plane/edit',
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
