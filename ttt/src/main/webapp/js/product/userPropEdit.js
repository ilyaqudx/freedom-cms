$(function() {
	
	
	$('#submit').click(function(){
		debugger
			var count = $('#count').val();
			if(count == '' || count == null){
				layer.msg('数量不能为空！');return;
			}			
			var userId = $("#userId").val();
			var propId = $("#propId").val();
			var originalCount = $("#originalCount").val();
			if(originalCount == null || originalCount == ''){
				originalCount = 0;
			}
			var params = {				
					count:count,
					userId:userId,
					propId:propId,
					originalCount : originalCount
			};
			
			$.ajax({
			        type: "POST",
			        url: 'userProp/edit',
			        data: 'params='+JSON.stringify(params),
			        success: function (data) {
			        	parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
			        }
			 });
		});

});