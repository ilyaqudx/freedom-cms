$(function(){
	// 输入电话号码移交 验证是否是会员，提示操作者是否继续为他延期
	$('#phone').blur(function(){
		debugger
		var phone = $("#phone").val();
		if(phone != null && phone != ""){
			$.ajax({
				type:'POST',
				url:'accountVip/validate',
				data:'phone='+phone,
				dataType:'json',
				success:function(data){
					if(data.code == 1){// 已经是会员了
						$("#tips1").html( data.msg);
					}else if(data.code == 2){// 电话号码没有注册
						$("#tips2").html( data.msg);
					}
				}
			});
		}
	}).blur();

	$('#submit').click(function(){
		var phone = $('#phone').val();
		if(phone == '' || phone == null){
			layer.msg('电话号码不能为空！');return;
		}
		var mark = $('#mark').val();
		if(mark == '' || mark == null){
			layer.msg('备注不能为空！');return;
		}
		var datemin = $("#datemin").val();
		var datemax = $("#datemax").val();
		if(datemax == '' || datemax == null){
			layer.msg('会员截止时间不能为空！');return;
		}
		var tips = $("#tips2").html();
		if(tips != ""){
			layer.msg('号码没注册不能为他添加会员');return;
		}
		var params = {
				phone:phone,
				startTime:datemin,
				endTime:datemax,
				mark : mark
		};
		$.ajax({
			type:'POST',
			url:'accountVip/add',
			data:'param='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
	});
});