$(function() {
	$("#submit").click(function() {
		var difficulty = $("#difficulty").val();
		if(difficulty == "" || difficulty == null){
			layer.msg("落点难度不能为空");
			return;
		}
		var testNum = $("#testNum").val();
		if(testNum == "" || testNum == null){
			layer.msg("总测试次数不能为空");
			return;
		}
		
		var life = $("#life").val();
		if(life == "" || life == null){
			layer.msg("生命值");
			return;
		}
		var overScreen = $("#overScreen").val();
		if(overScreen == "" || overScreen == null){
			layer.msg("过屏时间不能为空");
			return;
		}
		var stopTime = $("#stopTime").val();
		if(stopTime == "" || stopTime == null){
			layer.msg("空中停留时间不能为空");
			return;
		}
		var gold = $("#gold").val();
		if(gold == "" || gold == null){
			layer.msg("金币总数不能为空");
			return;
		}
		var serialGold = $("#serialGold").val();
		if(serialGold == "" || serialGold == null){
			layer.msg("连续金币不能为空");
			return;
		}
		var perfectRate = $("#perfectRate").val();
		if(perfectRate == "" || perfectRate == null){
			layer.msg("完美比例不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				difficulty : difficulty,
				testNum : testNum,
				life : life,
				overScreen : overScreen,
				stopTime : stopTime,
				gold : gold,
				serialGold : serialGold,
				perfectRate : perfectRate,
		};
		$.ajax({
			type : 'POST',
			url : 'fairysp/edit',
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
