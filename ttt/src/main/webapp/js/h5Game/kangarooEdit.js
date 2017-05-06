$(function() {
	$("#submit").click(function() {
		var time = $("#time").val();
		if(time == "" || time == null){
			layer.msg("单关时长不能为空");
			return;
		}
		var goodFruit = $("#goodFruit").val();
		if(goodFruit == "" || goodFruit == null){
			layer.msg("好水果几率不能为空");
			return;
		}
		var wolf = $("#wolf").val();
		if(wolf == "" || wolf == null){
			layer.msg("大灰狼几率不能为空");
			return;
		}
		var badFruit = $("#badFruit").val();
		if(badFruit == "" || badFruit == null){
			layer.msg("坏水果几率不能为空");
			return;
		}
		var poop = $("#poop").val();
		if(poop == "" || poop == null){
			layer.msg("便便几率不能为空");
			return;
		}
		var eventOne = $("#eventOne").val();
		if(eventOne == "" || eventOne == null){
			layer.msg("事件1几率不能为空");
			return;
		}
		var oneTime = $("#oneTime").val();
		if(oneTime == "" || oneTime == null){
			layer.msg("事件1存在时间不能为空");
			return;
		}
		var eventTwo = $("#eventTwo").val();
		if(eventTwo == "" || eventTwo == null){
			layer.msg("事件2几率不能为空");
			return;
		}
		var twoTime = $("#twoTime").val();
		if(twoTime == "" || twoTime == null){
			layer.msg("事件2存在时间不能为空");
			return;
		}
		var minStop = $("#minStop").val();
		if(minStop == "" || minStop == null){
			layer.msg("停留时间min不能为空");
			return;
		}
		var maxStop = $("#maxStop").val();
		if(maxStop == "" || maxStop == null){
			layer.msg("停留时间max不能为空");
			return;
		}
		var minRefrain = $("#minRefrain").val();
		if(minRefrain == "" || minRefrain == null){
			layer.msg("抑制时间min不能为空");
			return;
		}
		var maxRefrain = $("#maxRefrain").val();
		if(maxRefrain == "" || maxRefrain == null){
			layer.msg("抑制时间max不能为空");
			return;
		}
		var minInterval = $("#minInterval").val();
		if(minInterval == "" || minInterval == null){
			layer.msg("间隔时间min不能为空");
			return;
		}
		var maxInterval = $("#maxInterval").val();
		if(maxInterval == "" || maxInterval == null){
			layer.msg("间隔时间max不能为空");
			return;
		}
		var tips = $("#tips").val();
		if(tips == "" || tips == null){
			layer.msg("提示不能为空");
			return;
		}
		var rightScore = $("#rightScore").val();
		if(rightScore == "" || rightScore == null){
			layer.msg("单次正确得分不能为空");
			return;
		}
		var errorScore = $("#errorScore").val();
		if(errorScore == "" ||errorScore == null){
			layer.msg("单次错误扣分不能为空");
			return;
		}
		var perfectScore = $("#perfectScore").val();
		if(perfectScore == "" || perfectScore == null){
			layer.msg("完美通关得分不能为空");
			return;
		}
		var ordinaryScore = $("#ordinaryScore").val();
		if(ordinaryScore == "" || ordinaryScore == null){
			layer.msg("普通通关得分不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				time : time,
				goodFruit : goodFruit,
				wolf : wolf,
				badFruit : badFruit,
				poop : poop,
				eventOne : eventOne,
				oneTime : oneTime,
				eventTwo : eventTwo,
				twoTime : twoTime,
				minStop : minStop,
				maxStop : maxStop,
				minRefrain : minRefrain,
				maxRefrain : maxRefrain,
				minInterval : minInterval,
				maxInterval : maxInterval,
				tips : tips,
				rightScore : rightScore,
				errorScore : errorScore,
				perfectScore : perfectScore,
				ordinaryScore : ordinaryScore
		};
		$.ajax({
			type : 'POST',
			url : 'kangaroo/edit',
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
