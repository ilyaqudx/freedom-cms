$(function() {
	$("#submit").click(function() {
		var diff = $("#diff").val();
		if(diff == "" || diff == null){
			layer.msg("难度不能为空");
			return;
		}
		var grabNum = $("#grabNum").val();
		if(grabNum == "" || grabNum == null){
			layer.msg("抓取次数不能为空");
			return;
		}
		var carry = $("#carry").val();
		if(carry == "" || carry == null){
			layer.msg("准载不能为空");
			return;
		}
		var goods1 = $("#goods1").val();
		if(goods1 == "" || goods1 == null){
			layer.msg("货物1数量不能为空");
			return;
		}
		var goods2 = $("#goods2").val();
		if(goods2 == "" || goods2 == null){
			layer.msg("货物2数量不能为空");
			return;
		}
		var goods3 = $("#goods3").val();
		if(goods3 == "" || goods3 == null){
			layer.msg("货物3数量不能为空");
			return;
		}
		var goods4 = $("#goods4").val();
		if(goods4 == "" || goods4 == null){
			layer.msg("货物4数量不能为空");
			return;
		}
		var goods5 = $("#goods5").val();
		if(goods5 == "" || goods5 == null){
			layer.msg("货物5数量不能为空");
			return;
		}
		var goods6 = $("#goods6").val();
		if(goods6 == "" || goods6 == null){
			layer.msg("货物6数量不能为空");
			return;
		}
		var goods7 = $("#goods7").val();
		if(goods7 == "" || goods7 == null){
			layer.msg("货物7数量不能为空");
			return;
		}
		
		var id = $("#stageId").val();
		var params = {
				id : id,
				diff : diff,
				grabNum : grabNum,
				carry : carry,
				goods1 : goods1,
				goods2 : goods2,
				goods3 : goods3,
				goods4 : goods4,
				goods5 : goods5,
				goods6 : goods6,
				goods7 : goods7
		};
		$.ajax({
			type : 'POST',
			url : 'truckDiff/edit',
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
