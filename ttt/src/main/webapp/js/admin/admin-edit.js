$(function(){

	$('#submit').click(function(){
		var adminName = $('#adminName').val();
		if(isNull(adminName)){
			layer.msg('账号不能为空！');return;
		}
		var phone = $('#phone').val();
		var realName = $('#realName').val();
		var adminRole = $('#adminRole').val();
		var description = $('#description').val();
		var params = {
				name:adminName,
				phone:phone,
				realName:realName,
				roleIds:adminRole,
				description:description
		};
		var roleIds = [adminRole];
		params['roleIds'] = roleIds;
		var adminId = $('#adminId').val();
		var url = 'admin/add';
		if(adminId != null && adminId != ''){
			url = 'admin/edit';
			params['id'] = adminId;
		}
		$.ajax({
			type:'POST',
			url:url,
			data:'params='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('成功!',{icon:1,time:1000},function(){
						parent.location.reload();
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					});
				}else{
					layer.msg('服务器内部错误！');
				}
			}
		});
	});
});