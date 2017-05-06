$(function(){
	$('#submit').click(function(){
		var title = $('#title').val();
		if(title == '' || title == null){
			layer.msg('标题不能为空！');return;
		}
		var content = $('#content').val();
		if(content == '' || content == null){
			layer.msg('内容不能为空！');return;
		}
		var userIds = $('#userIds').val();
		$.ajax({
			type:'POST',
			url:'user/sendMsg',
			data:'userIds='+userIds+'&title='+title+'&content='+content,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('成功!',{icon:1,time:800},function(){
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