$(function(){
	
	$('#submit').click(function(){
		var gold = $('#gold').val();
		if(gold == '' || gold == null){
			layer.msg('金币不能为空！');return;
		}
		var userTaskId = $("#userTaskId").val();
		var taskId = $("#name").val();
		var name = $("#name option:selected").text();
		var type = taskId;
		var status = $("#status").val();
		var userId = $("#userId").val();
		var params = {
				id:userTaskId,
				taskId:taskId,
				type:type,
				name:name,
				gold:gold,
				status:status,
				userId:userId
		};
		$.ajax({
			type:'POST',
			url:'userTask/edit',
			data:'params='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
	});
});