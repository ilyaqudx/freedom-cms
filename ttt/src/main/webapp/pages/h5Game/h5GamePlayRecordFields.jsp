<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<!-- <script type="text/javascript" src="js/h5Game/cardEdit.js"></script> -->
<title>游戏玩耍后提交的数据字段</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 游戏管理 <span class="c-gray en">&gt;</span> ${game.name}<span class="c-gray en">&gt;</span>记录字段<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<article class="page-container">

	<form class="form form-horizontal" id="configForm">
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script>
	$(function(){
	
		// getContent from server
		$.get("game/playrecord/fields?gameId=" + ${game.id}, function(fieldsText) {
			var reportFields = JSON.parse(fieldsText);
			if (reportFields.code) {
				layer.msg("获取游戏提交字段失败！" + reportFields.msg);
				return;
			}
			
			// construct page content
			var pageContent = "";
			for (var attr in reportFields) {
				var readonly = "readonly";
				pageContent += '<div class="row cl">'
							  + '	<label class="form-label col-xs-4 col-sm-3">' + reportFields[attr] + '</label>'
							  + '		<div class="formControls col-xs-8 col-sm-9">'
							  + '			<input type="text" class="input-text" min="0" value="' + attr + '" placeholder="" id="' +  attr + '" name="stageId" ' + readonly  + '>'
							  + '		</div>'
							  + '</div>';
			}
	
			$('#configForm').append(pageContent);
		});
	}());
</script>
</body>

</html>