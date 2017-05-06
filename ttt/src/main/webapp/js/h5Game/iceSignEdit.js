$(function() {
	$("#submit").click(function() {
		var layerNum = $("#layerNum").val();
		if(layerNum == "" || layerNum == null){
			layer.msg("层数不能为空");
			return;
		}
		var layerIceNum = $("#layerIceNum").val();
		if(layerIceNum == "" || layerIceNum == null){
			layer.msg("每层冰块数不能为空");
			return;
		}
		var iceRiseTime = $("#iceRiseTime").val();
		if(iceRiseTime == "" || iceRiseTime == null){
			layer.msg("冰层上升时间不能为空");
			return;
		}
		var signNum = $("#signNum").val();
		if(signNum == "" || signNum == null){
			layer.msg("文字内容难度不能为空");
			return;
		}
		var correctRate = $("#correctRate").val();
		if(correctRate == "" || correctRate == null){
			layer.msg("正确率出现不能为空");
			return;
		}
		var heartNum = $("#heartNum").val();
		if(heartNum == "" || heartNum == null){
			layer.msg("心数量不能为空");
			return;
		}
		var featherNum = $("#featherNum").val();
		if(featherNum == "" || featherNum == null){
			layer.msg("羽毛数量不能为空");
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
				layerNum : layerNum,
				layerIceNum : layerIceNum,
				iceRiseTime :iceRiseTime,
				signNum : signNum,
				correctRate : correctRate,
				heartNum : heartNum,
				featherNum : featherNum,
				perfectNum : perfectNum,
		};
		$.ajax({
			type : 'POST',
			url : 'iceSign/edit',
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
