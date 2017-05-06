$(function() {
	$("#submit").click(function() {
		var name = $("#name").val();
		if(name == "" || name == null){
			layer.msg("类型名称不能为空");
			return;
		}
		
		var type = $("#type").val();
		var groupId = $("#groupId").val();
		var params = {
				type : type,
				name : name,
				groupId : groupId
		};
		var id = $("#id").val();
		var url ;
		if(id != null && id != ""){
			params['id'] = id;
			url ="msgType/edit";
		}else{
			url = "msgType/add";
		}
		$.ajax({ 
			type : 'POST',
			url : url,
			data : 'params=' + JSON.stringify(params),
			dataType : 'json',
			success:function(data){
				if(data.code != 0){
					layer.msg("类型已经存在");
					return;
				}else{
					layer.msg("修改成功");
					parent.location.reload();
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}
			}
		});
		
	});
	
});