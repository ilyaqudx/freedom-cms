$(function() {
	$("#submit").click(function() {
		var timeForPer = $("#timeForPer").val();
		if(timeForPer == "" || timeForPer == null){
			layer.msg("单关游戏时长不能为空");
			return;
		}
		var mapId = $("#mapId").val();
		if(mapId == "" || mapId == null){
			layer.msg("地图不能为空");
			return;
		}
		var disturbNum = $("#disturbNum").val();
		if(disturbNum == "" || disturbNum == null){
			layer.msg("干扰物数量不能为空");
			return;
		}
		var planetId = $("#planetId").val();
		if(planetId == "" || planetId == null){
			layer.msg("卫星ID不能为空");
			return;
		}
		var planetNum = $("#planetNum").val();
		if(planetNum == "" || planetNum == null){
			layer.msg("卫星数量不能为空");
			return;
		}
		var batteryNum = $("#batteryNum").val();
		if(batteryNum == "" || batteryNum == null){
			layer.msg("电池数量不能为空");
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
		var totalTurns = $("#totalTurns").val();
		if(totalTurns == "" || totalTurns == null){
			layer.msg("总轮数不能为空");
			return;
		}
		var perfectTurns = $("#perfectTurns").val();
		if(perfectTurns == "" || perfectTurns == null){
			layer.msg("完美通关正确轮数不能为空");
			return;
		}
		var ordinaryTurns = $("#ordinaryTurns").val();
		if(ordinaryTurns == "" || ordinaryTurns == null){
			layer.msg("普通通关正确轮数不能为空");
			return;
		}
		var passNum = $("#passNum").val();
		if(passNum == "" || passNum == null){
			layer.msg(" 本轮通关正确轮数不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				timeForPer : timeForPer,
				mapId : mapId,
				disturbNum : disturbNum,
				planetId : planetId,
				planetNum : planetNum,
				batteryNum : batteryNum,
				perfectNum : perfectNum,
				ordinaryNum : ordinaryNum,
				minStop : minStop,
				maxStop : maxStop,
				speed : speed,
				totalTurns : totalTurns,
				perfectTurns : perfectTurns,
				ordinaryTurns : ordinaryTurns,
				passNum : passNum
		};
		$.ajax({
			type : 'POST',
			url : 'space/edit',
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
