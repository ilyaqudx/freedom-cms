$(function() {
	$("#submit").click(function() {
		var diff = $("#diff").val();
		if(diff == "" || diff == null){
			layer.msg("难度不能为空");
			return;
		}
		var testTime = $("#testTime").val();
		if(testTime == "" || testTime == null){
			layer.msg("测试次数不能为空");
			return;
		}
		var answerTime = $("#answerTime").val();
		if(answerTime == "" || answerTime == null){
			layer.msg("答题时间不能为空");
			return;
		}
		var commonNum = $("#commonNum").val();
		if(commonNum == "" || commonNum == null){
			layer.msg("普通正确数不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美正确数不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				diff : diff,
				testTime : testTime,
				answerTime : answerTime,
				commonNum : commonNum
				perfectNum : perfectNum
		};
		$.ajax({
			type : 'POST',
			url : 'line/edit',
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
