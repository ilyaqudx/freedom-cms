$(function() {
	$("#submit").click(function() {
		var basketNum = $("#basketNum").val();
		if(basketNum == "" || basketNum == null){
			layer.msg("篮子数不能为空");
			return;
		}
		var fruitType = $("#fruitType").val();
		if(fruitType == "" || fruitType == null){
			layer.msg("对应水果不能为空");
			return;
		}
		var countdown = $("#countdown").val();
		if(countdown == "" || countdown == null){
			layer.msg("倒计时不能为空");
			return;
		}
		var fruitNum = $("#fruitNum").val();
		if(fruitNum == "" || fruitNum == null){
			layer.msg(" 掉落水果数不能为空");
			return;
		}
		var correctRate = $("#correctRate").val();
		if(correctRate == "" || correctRate == null){
			layer.msg("正确率不能为空");
			return;
		}
		var dropTime = $("#dropTime").val();
		if(dropTime == "" || dropTime == null){
			layer.msg("过屏时间不能为空");
			return;
		}
		var passScore = $("#passScore").val();
		if(passScore == "" || passScore == null){
			layer.msg("通关分数不能为空");
			return;
		}
		var correctScore = $("#correctScore").val();
		if(correctScore == "" || correctScore == null){
			layer.msg("正确分数不能为空");
			return;
		}
		var incorrectScore = $("#incorrectScore").val();
		if(incorrectScore == "" || incorrectScore == null){
			layer.msg("错误扣分不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关不能为空");
			return;
		}
		var id = $("#stageId").val();
		var params = {
				id : id,
				basketNum : basketNum,
				fruitType : fruitType,
				countdown :countdown,
				fruitNum : fruitNum,
				correctRate : correctRate,
				dropTime : dropTime,
				passScore : passScore,
				correctScore : correctScore,
				incorrectScore : incorrectScore,
				perfectNum : perfectNum,
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
			url : 'fruitTalent/edit',
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
