<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<!-- <script type="text/javascript" src="js/h5Game/cardEdit.js"></script> -->
<title>游戏算分规则</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 游戏管理 <span class="c-gray en">&gt;</span> ${game.name}<span class="c-gray en">&gt;</span>算分规则<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<article class="page-container">

	<form class="form form-horizontal" id="configForm">

	<div class="row cl">
		<label class="form-label col-xs-3 col-sm-2">算分规则：</label>
		<div class="formControls col-xs-9 col-sm-10">
			<textarea style="min-height:10em;" class="input-text" min="0" placeholder="" id="scoreRule" name="scoreRule" readonly="readonly">${rule}</textarea>
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-2">
			<input class="btn btn-primary radius" type="button" onclick="switch2ModifyStatus();" id="modify" value="&nbsp;&nbsp;编辑&nbsp;&nbsp;">
			<input class="btn btn-primary radius" style="display:none;" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>

	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script>

	function switch2ModifyStatus() {
		$('#submit').css({
			display: "block"
		});
		
		$('#modify').css({
			display: "none"
		});
		
		$('#scoreRule').removeAttr('readonly');
	}	

	$(function(){
		
		
		// submit
		$("#submit").click(function() {
			var ruleValue = $("#scoreRule").val();
			if (!ruleValue || ruleValue == '') {
				layer.msg("规则不能为空");
				return;
			}
			
			var data = {
				gameCode: ${game.code},
				rule: ruleValue
			};
			
			$.ajax({
				type : 'POST',
				url : 'game/score/rule',
				data : data,
				dataType : 'json',
				success:function(data){
					if (data.code != "0") {
						layer.msg("修改失败！ 错误原因：" + data.msg);
					} else {
						layer.msg("修改成功");
						setTimeout( function(){
							parent.location.reload();
							var index = parent.layer.getFrameIndex(window.name);
							parent.layer.close(index);
						}, 1500);
					}
				},
				error: function(xhr, textStatus, errorThrown) {
					layer.msg("修改失败! 错误状态: " + textStatus + ", 错误原因: " + errorThrown);
				}
			});
		});
		
		
	}());
</script>
</body>

</html>