$(function() {
	$("#submit").click(function() {
		var countdown = $("#countdown").val();
		if(countdown == "" || countdown == null){
			layer.msg("倒计时不能为空");
			return;
		}
		var transformNum = $("#transformNum").val();
		if(transformNum == "" || transformNum == null){
			layer.msg("黑色糖果数量不能为空");
			return;
		}
		var transformTime = $("#transformTime").val();
		if(transformTime == "" || transformTime == null){
			layer.msg("黑色糖果变换时间不能为空");
			return;
		}
		var passNum = $("#passNum").val();
		if(passNum == "" || passNum == null){
			layer.msg("通关消除数量不能为空");
			return;
		}
		var semanticRate = $("#semanticRate").val();
		if(semanticRate == "" || semanticRate == null){
			layer.msg("语义概率不能为空");
			return;
		}
		var perfectNum = $("#perfectNum").val();
		if(perfectNum == "" || perfectNum == null){
			layer.msg("完美通关数不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				countdown : countdown,
				transformNum : transformNum,
				transformTime : transformTime,
				passNum : passNum,
				perfectNum : perfectNum,
		};
		$.ajax({
			type : 'POST',
			url : 'candy/edit',
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
