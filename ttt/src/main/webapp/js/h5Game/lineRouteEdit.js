$(function() {
	$("#submit").click(function() {
	
		var diff = $("#diff").val();
		if(diff == "" || diff == null){
			layer.msg("难度不能为空");
			return;
		}
		var id = $("#stageId").val();
		var routeImg = $("#routeImg").val();
		var diff = $("#diff").val();
		var entryId = $("#entryId").val();
		var gap1_1 = $("#gap1_1").val();
		var gap1_2 = $("#gap1_2").val();
		var gap1_3 = $("#gap1_3").val();
		var gap2_1 = $("#gap2_1").val();
		var gap2_2 = $("#gap2_2").val();
		var gap2_3 = $("#gap2_3").val();
		var gap3_1 = $("#gap3_1").val();
		var gap3_2 = $("#gap3_2").val();
		var gap3_3 = $("#gap3_3").val();
		
		var params = {
				id : id,
				routeImg : routeImg,
				diff : diff,
				entryId : entryId,
				gap1_1 : gap1_1,
				gap1_2 : gap1_2,
				gap1_3 : gap1_3,
				gap2_1 : gap2_1,
				gap2_2 : gap2_2,
				gap2_3 : gap2_3,
				gap3_1 : gap3_1,
				gap3_2 : gap3_2,
				gap3_3 : gap3_3
		};
		$.ajax({
			type : 'POST',
			url : 'lineRoute/edit',
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
