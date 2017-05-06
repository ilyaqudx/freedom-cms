$(function() {
	$("#submit").click(function() {
		var timeForPer = $("#timeForPer").val();
		if(timeForPer == "" || timeForPer == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var disturbNum = $("#disturbNum").val();
		if(disturbNum == "" || disturbNum == null){
			layer.msg("干扰物数量不能为空");
			return;
		}
		var sickNum = $("#sickNum").val();
		if(sickNum == "" || sickNum == null){
			layer.msg("生病动物数量不能为空");
			return;
		}
		var tipsTime = $("#tipsTime").val();
		if(tipsTime == "" || tipsTime == null){
			layer.msg("提示时间不能为空");
			return;
		}
		var syringeNum = $("#syringeNum").val();
		if(syringeNum == "" || syringeNum == null){
			layer.msg("针筒数量不能为空");
			return;
		}
		var stethoscopeNum = $("#stethoscopeNum").val();
		if(stethoscopeNum == "" || stethoscopeNum == null){
			layer.msg("听诊器数量不能为空");
			return;
		}
		var mosquito = $("#mosquito").val();
		if(mosquito == "" || mosquito == null){
			layer.msg("蚊子次数不能为空");
			return;
		}
		var darkCloud = $("#darkCloud").val();
		if(darkCloud == "" || darkCloud == null){
			layer.msg("生成速度不能为空");
			return;
		}
		var totalTurns = $("#totalTurns").val();
		if(totalTurns == "" || totalTurns == null){
			layer.msg("总轮数不能为空");
			return;
		}
		var passNum = $("#passNum").val();
		if(passNum == "" || passNum == null){
			layer.msg("每轮通关正确个数不能为空");
			return;
		}
		var perfectTurns = $("#perfectTurns").val();
		if(perfectTurns == "" || perfectTurns == null){
			layer.msg("完美轮数不能为空");
			return;
		}
		var ordinaryTurns = $("#ordinaryTurns").val();
		if(ordinaryTurns == "" || ordinaryTurns == null){
			layer.msg("普通轮数不能为空");
			return;
		}
		var minStop = $("#minStop").val();
		if(minStop == "" || minStop == null){
			layer.msg("冷却时间最小值不能为空");
			return;
		}
		var maxStop = $("#maxStop").val();
		if(maxStop == "" || maxStop == null){
			layer.msg("冷却时间最大值不能为空");
			return;
		}
		var speed = $("#speed").val();
		if(speed == "" || speed == null){
			layer.msg("速度不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				timeForPer : timeForPer,
				disturbNum : disturbNum,
				sickNum :sickNum,
				tipsTime : tipsTime,
				syringeNum : syringeNum,
				stethoscopeNum : stethoscopeNum,
				mosquito : mosquito,
				darkCloud : darkCloud,
				totalTurns : totalTurns,
				passNum : passNum,
				perfectTurns : perfectTurns,
				ordinaryTurns : ordinaryTurns,
				minStop : minStop,
				maxStop : maxStop,
				speed : speed
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
			url : 'farm/edit',
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
