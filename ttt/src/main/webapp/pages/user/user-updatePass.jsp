<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$('#submit').click(function(){
			var password = $('#password').val();
			if(isNull(password)){
				layer.msg('新的密码不能为空！');return;
			}
			var password2 = $('#password2').val();
			if(isNull(password2)){
				layer.msg('确认密码不能为空！');return;
			}
			if(password == password2){
				$.ajax({
					type:'POST',
					url:'user/updatePass',
					data:'userId='+$('#userId').val() +'&pass='+password,
					dataType:'json',
					success:function(data){
						if(data.code == 0){
							layer.msg('成功!',{icon:1,time:1000},function(){
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
							});
						}else{
							layer.msg('服务器内部错误！');
						}
					}
				});
			}else{
				layer.msg('密码不一致！');return;
			}
		});
	});
</script>
<title>修改密码 - 会员管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="userId" value="${userId }">
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新的密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" autocomplete="off" value="" placeholder="密码" id="password" name="password">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" autocomplete="off"  placeholder="确认新密码" id="password2" name="password2">
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script> 
</body>
</html>