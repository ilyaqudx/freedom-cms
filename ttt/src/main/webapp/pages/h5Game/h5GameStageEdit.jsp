<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<!-- <script type="text/javascript" src="js/h5Game/cardEdit.js"></script> -->
<title>动物忍者</title>
</head>
<body>
<article class="page-container">
	<label style="color: red;"> 修改配置表数据要慎重</label>
	<form class="form form-horizontal" id="configForm">
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script>
	$(function(){
	
		var stagefields = null;
		var stageValues = null;
		// getContent from server
		$.get("game/stage/fields?gameCode=" + ${gameCode}, function(fieldsText) {
		
			stagefields = JSON.parse(fieldsText);
			if (stagefields.code) {
				layer.msg("获取关卡配置表字段失败！" + stagefields.msg);
				return;
			}
		
			$.get("game/stage/one/value?gameCode=" + ${gameCode} + "&stageId=" + ${stageId}, function(valuesText) {
				
				stageValues = JSON.parse(valuesText);
				if (stageValues.code) {
					layer.msg("获取关卡配置表数据失败！" + stageValues.msg);
					return;
				}
			
				// construct page content
				var pageContent = "";
				for (var attr in stagefields) {
					var readonly = attr === "id" ? "readonly" : "";
					pageContent += '<div class="row cl">'
								  + '	<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>' + stagefields[attr] + '</label>'
								  + '		<div class="formControls col-xs-8 col-sm-9">'
								  + '			<input type="number" class="input-text" min="0" value="' +  stageValues[attr] + '" placeholder="" id="' +  attr + '" name="stageId" ' + readonly  + '>'
								  + '		</div>'
								  + '</div>';
				}
				
				// append submit content
				pageContent += '<div class="row cl">'
							+  '  	<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">'
							+  '		<input class="btn btn-primary radius" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">'
							+  '	</div>'
							+  '</div>';
							
				$('#configForm').append(pageContent);
				
				
				// submit
				$("#submit").click(function() {
					var params = {};
					var emptyErrorMsg = "不能为空";
					
					for (var attr in stagefields) {
						var value = $("#" + attr).val();
						if (!value || value == "") {
							layer.msg(stagefields[attr] + emptyErrorMsg);
							return;
						}
						params[attr] = value;
					}
					
					var data = {
						gameCode: ${gameCode},
						stageId: ${stageId},
						values: JSON.stringify(params)
					};
					
					$.ajax({
						type : 'POST',
						url : 'game/stage/one/value',
						data : data,
						dataType : 'json',
						success:function(data) {
							if (data.code != "0") {
								layer.msg("修改失败！" + data.msg);
							} else {
								layer.msg("修改成功");
								setTimeout(function() {
									parent.location.reload();
									var index = parent.layer.getFrameIndex(window.name);
									parent.layer.close(index);
								}, 1500);
							}
						}
					});
				});
			});
		});

	}());
</script>
</body>

</html>