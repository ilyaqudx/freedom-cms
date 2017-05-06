<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('#iconDiv').hide();
	
	if('${resource.type}' == '1'){
		$('#type').attr('checked','checked');
		$('#iconDiv').show();
	}
	
	$("#admin-resource-save").click(function(){
		var name = $('#name').val();//名称
		if(isNull(name)){
			layer.msg('名称不能为空！');return;
		}
		var url = $('#url').val();//地址
		if(isNull(url)){
			layer.msg('地址不能为空！');return;
		}
		var log = 0;
		if($('#log').is(':checked')){
			log = 1;
		}
		//权限
		var authority = 0;
		if($('#authority').is(':checked')){
			authority = 1;
		}
		//描述
		var description = $('#description').val();
		var type = 0;
		if($('#type').is(':checked')){
			type = 1;
		}
		//图标
		var icon = $('#icon').val();
		var id = $('#id').val();
		var params = {
				id:id,
				name:name,
				url:url,
				log:log,
				authority:authority,
				description:description,
				type:type,
				icon:icon
		};
		$.ajax({
			type:'POST',
			url:'resource/edit',
			data:'params='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('成功!',{icon:1,time:1000},function(){
						parent.t.fnDraw();
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
	
	$('#type').change(function(){
		var type = $('#type');
		if($('#type').is(':checked')){
			$('#iconDiv').show();
		}else{
			$('#iconDiv').hide();
		}
	});
});

</script>
<title>新建资源 - 管理员管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="pId" value="${pId }">
	<input type="hidden" id="id" value="${resource.id }">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="" id="name" name="" value="${resource.name }" datatype="*4-16" nullmsg="名称不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" id="url" name="" value="${resource.url }" datatype="*4-16" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">菜单栏目：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="checkbox" id="type">
			</div>
		</div>
		<div class="row cl" id="iconDiv">
			<label class="form-label col-xs-4 col-sm-3">图标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" value="${resource.icon }" id="icon" name="" datatype="*4-16" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">日志记录：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:if test="${resource.log == 1 }">
					<input type="checkbox" id="log" checked="checked">
				</c:if>
				<c:if test="${resource.log == 0 }">
					<input type="checkbox" id="log">
				</c:if>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">权限控制：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:if test="${resource.authority == 1 }">
					<input type="checkbox" id="authority"  checked="checked">
				</c:if>
				<c:if test="${resource.authority == 0 }">
					<input type="checkbox" id="authority">
				</c:if>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" value="${resource.description }" id="description" name="">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="button" class="btn btn-success radius" id="admin-resource-save"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>