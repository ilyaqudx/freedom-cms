$(function(){
	$('#submit').click(function(){
		var adminName = $('#adminName').val();
		if(adminName == '' || adminName == null){
			layer.msg('账号不能为空！');return;
		}
		var password = $('#password').val();
		if(password == '' || password == null){
			layer.msg('密码不能为空！');return;
		}
		var password2 = $('#password2').val();
		if(password != password2){
			layer.msg('密码不一致！');return;
		}
		var phone = $('#phone').val();
		var realName = $('#realName').val();
		var adminRole = $('#adminRole').val();
		var identityCode = $("#identityCode").val();
		var weixin = $("#weixin").val();
		var qq = $("#qq").val();
		var homeAddress = $("#homeAddress").val();
		var remark = $('#remark').val();
		
		//银行信息
		var bankId = $("#bankId").val();
		var account = $("#account").val();
		var accountName = $("#accountName").val();
		var bankBranch  = $("#bankBranch").val();
		var bankAddress = $("#bankAddress").val();
		var params = {
				name:adminName,
				password:password,
				phone:phone,
				realName:realName,
				roleIds:adminRole,
				identityCode:identityCode,
				weixin:weixin,
				qq:qq,
				homeAddress:homeAddress,
				remark:remark,
				bankId   : bankId,
				account : account,
				accountName : accountName,
				bankBranch : bankBranch,
				bankAddress : bankAddress
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