$(function() {
	$("#submit").click(function() {
		var questionNum = $("#questionNum").val();
		if(questionNum == "" || questionNum == null){
			layer.msg("题目个数不能为空");
			return;
		}
		var questionType = $("#questionType").val();
		if(questionType == "" || questionType == null){
			layer.msg("题目类型不能为空");
			return;
		}
		var aTypeDiff = $("#aTypeDiff").val();
		if(aTypeDiff == "" || aTypeDiff == null){
			layer.msg("图形推理不能为空");
			return;
		}
		var bTypeDiff = $("#bTypeDiff").val();
		if(bTypeDiff == "" || bTypeDiff == null){
			layer.msg("数字推理不能为空");
			return;
		}
		var answerTime = $("#answerTime").val();
		if(answerTime == "" || answerTime == null){
			layer.msg("回答时间不能为空");
			return;
		}
		var aiAnswer = $("#aiAnswer").val();
		if(aiAnswer == "" || aiAnswer == null){
			layer.msg("电脑作答不能为空");
			return;
		}


		var id = $("#stageId").val();
		var params = {
				id : id,
				questionNum : questionNum,
				questionType : questionType,
				aTypeDiff : aTypeDiff,
				bTypeDiff :bTypeDiff,
				answerTime : answerTime,
				aiAnswer :aiAnswer
		};
		$.ajax({
			type : 'POST',
			url : 'standing/edit',
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
