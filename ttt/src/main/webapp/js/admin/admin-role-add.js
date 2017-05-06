
$(function(){
	$(".permission-list dt input:checkbox").click(function(){
		$(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
	});
	$(".permission-list2 dd input:checkbox").click(function(){
		var l =$(this).parent().parent().find("input:checked").length;
		var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
		if($(this).prop("checked")){
			$(this).closest("dl").find("dt input:checkbox").prop("checked",true);
			$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
		}
		else{
			if(l==0){
				$(this).closest("dl").find("dt input:checkbox").prop("checked",false);
			}
			if(l2==0){
				$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
			}
		}
	});
	
	$("#admin-role-save").click(function(){
		var roleName = $('#roleName').val();
		var description = $('#description').val();
		var checked = $('.permission-list input:checked');
		var length = checked.length;
		var ids = '';
		for(var i=0; i<length; i++){
			ids+=checked[i].value+',';
		}
		var params = {
				name:roleName,
				description:description,
				resourceIds:ids
		};
		var url = 'role/add';
		var roleId = $('#roleId').val();
		if(roleId != '' && roleId != null){
			url = 'role/edit';
			params['id']=roleId;
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
			},
			error:function(data){
				layer.msg('服务器内部错误！');
			}
		});
	});
});