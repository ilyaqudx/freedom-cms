$(function() {
	$("#submit").click(function() {
		var titleJSON = $("#titleJSON").val();
		if(titleJSON == "" || titleJSON == null){
			layer.msg("题目类型不能为空");
			return;
		}
		
		var readDifficulty = $("#readDifficulty").val();
		if(readDifficulty == "" || readDifficulty == null){
			layer.msg("阅读理解不能为空");
			return;
		}
		var suspectNum = $("#suspectNum").val();
		if(suspectNum == "" || suspectNum == null){
			layer.msg("嫌疑犯人数不能为空");
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
				titleJSON : titleJSON,
				readDifficulty : readDifficulty,
				suspectNum : suspectNum,
				perfectRate :perfectRate
		};
		$.ajax({
			type : 'POST',
			url : 'judgeRead/edit',
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
