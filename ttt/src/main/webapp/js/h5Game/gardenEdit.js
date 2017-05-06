$(function() {
	$("#submit").click(function() {
		var flyPestType = $("#flyPestType").val();
		if(flyPestType == "" || flyPestType == null){
			layer.msg("飞行害虫不能为空");
			return;
		}
		var creepPestType = $("#creepPestType").val();
		if(creepPestType == "" || creepPestType == null){
			layer.msg("爬行害虫不能为空");
			return;
		}
		var newPest = $("#newPest").val();
		if(newPest == "" || newPest == null){
			layer.msg("中途新增害虫不能为空");
			return;
		}
		var pestNum = $("#pestNum").val();
		if(pestNum == "" || pestNum == null){
			layer.msg("每种害虫出现数量不能为空");
			return;
		}
		var shellType = $("#shellType").val();
		if(shellType == "" || shellType == null){
			layer.msg("炮弹种类不能为空");
			return;
		}
		var shellRate = $("#shellRate").val();
		if(shellRate == "" || shellRate == null){
			layer.msg("炮弹数量倍率不能为空");
			return;
		}
		var minTipInterval = $("#minTipInterval").val();
		if(minTipInterval == "" || minTipInterval == null){
			layer.msg("新增间隔害虫数最小值不能为空");
			return;
		}
		var maxTipInterval = $("#maxTipInterval").val();
		if(maxTipInterval == "" || maxTipInterval == null){
			layer.msg("新增间隔害虫数最大值不能为空");
			return;
		}
		var minShowInterval = $("#minShowInterval").val();
		if(minShowInterval == "" || minShowInterval == null){
			layer.msg("到出现的间隔害虫最小值不能为空");
			return;
		}
		var maxShowInterval = $("#maxShowInterval").val();
		if(maxShowInterval == "" || maxShowInterval == null){
			layer.msg("到出现的间隔害虫最大值不能为空");
			return;
		}
		var tipsTime = $("#tipsTime").val();
		if(tipsTime == "" || tipsTime == null){
			layer.msg("关卡开始提示时间不能为空");
			return;
		}
		var overScreen = $("#overScreen").val();
		if(overScreen == "" || overScreen == null){
			layer.msg("害虫过屏时间不能为空");
			return;
		}
		var minPestInterval = $("#minPestInterval").val();
		if(minPestInterval == "" || minPestInterval == null){
			layer.msg("害虫出现间隔最小值不能为空");
			return;
		}
		var maxPestInterval = $("#maxPestInterval").val();
		if(maxPestInterval == "" || maxPestInterval == null){
			layer.msg("害虫出现间隔最大值不能为空");
			return;
		}
		var killPestNum = $("#killPestNum").val();
		if(killPestNum == "" || killPestNum == null){
			layer.msg("消灭害虫不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美个数不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				flyPestType : flyPestType,
				creepPestType : creepPestType,
				newPest :newPest,
				pestNum : pestNum,
				shellType : shellType,
				shellRate : shellRate,
				minTipInterval : minTipInterval,
				maxTipInterval : maxTipInterval,
				minShowInterval : minShowInterval,
				maxShowInterval : maxShowInterval,
				tipsTime : tipsTime,
				overScreen : overScreen,
				minPestInterval : minPestInterval,
				maxPestInterval : maxPestInterval,
				killPestNum : killPestNum,
				perfectNum : perfectNum,
		};
		$.ajax({
			type : 'POST',
			url : 'garden/edit',
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
