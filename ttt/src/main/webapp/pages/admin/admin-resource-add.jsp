<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('#iconDiv').hide();

	$("#admin-resource-save").click(function(){
		$("#admin-resource-save").attr('disabled','disabled');
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
		var pId = $('#pId').val();
		var params = {
				parentId:pId,
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
			url:'resource/add',
			data:'params='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('成功!',{icon:1,time:1000},function(){
						parent.t.fnDraw();
						var node = parent.tree.getNodeByParam("id", pId, null);//得到当前节点
						//判断节点是否为父节点，不是就修改成父节点
						if(!node.isParent){
							node.isParent = true;
							parent.tree.updateNode(node);
						}
						parent.tree.reAsyncChildNodes(node, "refresh");//重新加载节点
						//var node = parent.tree.getNodeByParam("id", pId, null);//得到当前节点
						//parent.tree.expandNode(node, true, true, true);
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
		$("#admin-resource-save").remove('disabled');
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
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" id="name" name="" datatype="*4-16" nullmsg="名称不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" id="url" name="" datatype="*4-16" >
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
				<input type="text" class="input-text" placeholder="" id="icon" name="" datatype="*4-16" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">日志记录：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="checkbox" id="log" checked="checked">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">权限控制：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="checkbox" id="authority" checked="checked">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" id="description" name="">
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