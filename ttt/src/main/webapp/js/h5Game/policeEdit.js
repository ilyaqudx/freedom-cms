$(function() {
	$("#submit").click(function() {
		var redirectorNum = $("#redirectorNum").val();
		if(redirectorNum == "" || redirectorNum == null){
			layer.msg("转向器数量不能为空");
			return;
		}
		var mapId = $("#mapId").val();
		if(mapId == "" || mapId == null){
			layer.msg("地图ID不能为空");
			return;
		}
		var crash = $("#crash").val();
		if(crash == "" || crash == null){
			layer.msg("允许撞毁不能为空");
			return;
		}
		var total = $("#total").val();
		if(total == "" || total == null){
			layer.msg("总共出现的车俩数量不能为空");
			return;
		}
		var biggest = $("#biggest").val();
		if(biggest == "" || biggest == null){
			layer.msg("同屏最大车辆不能为空");
			return;
		}
		var carInterval = $("#carInterval").val();
		if(carInterval == "" || carInterval == null){
			layer.msg("车辆出现间隔不能为空");
			return;
		}
		var minSpeed = $("#minSpeed").val();
		if(minSpeed == "" || minSpeed == null){
			layer.msg("最小速度不能为空");
			return;
		}
		var maxSpeed = $("#maxSpeed").val();
		if(maxSpeed == "" || maxSpeed == null){
			layer.msg("最大速度不能为空");
			return;
		}
		var maxOil = $("#maxOil").val();
		if(maxOil == "" || maxOil == null){
			layer.msg("油量最大不能为空");
			return;
		}
		var gold = $("#gold").val();
		if(gold == "" || gold == null){
			layer.msg("金币数量不能为空");
			return;
		}
		var showInterval = $("#showInterval").val();
		if(showInterval == "" || showInterval == null){
			layer.msg("出现间隔不能为空");
			return;
		}
		var maxGold = $("#maxGold").val();
		if(maxGold == "" || maxGold == null){
			layer.msg("同屏最大金币数量不能为空");
			return;
		}
		var perfectGold = $("#perfectGold").val();
		if(perfectGold == "" || perfectGold == null){
			layer.msg("完美比例不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				redirectorNum : redirectorNum,
				mapId : mapId,
				crash : crash,
				total : total,
				biggest : biggest,
				carInterval : carInterval,
				minSpeed : minSpeed,
				maxSpeed : maxSpeed,
				maxOil : maxOil,
				gold : gold,
				showInterval : showInterval,
				maxGold : maxGold,
				perfectGold : perfectGold
		};
		debugger
		$.ajax({
			type : 'POST',
			url : 'police/edit',
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
