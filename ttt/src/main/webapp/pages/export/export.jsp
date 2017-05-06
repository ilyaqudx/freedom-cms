<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var type = $("#type").val();
		if(type == "1"){
			var excerciseId = $("#excerciseId").val();
			if(isNull(excerciseId)){
				layer.alert("试题id不存在！");
				return;
			}
			var params = {
			    excerciseId : excerciseId
			};
			var startTime = $("#datemin").val();
			if(startTime != null && startTime != ""){
			   params['startTime'] = startTime;
			}
			var endTime = $("#datemax").val() ;
			if(endTime != null && endTime != ""){
			   params['endTime'] = endTime + " 23:59:59";
			}
			window.location.href="eval/exportData?params=" + JSON.stringify(params);
		}
		if(type == "2"){
			var table = $("#table").val();
			var gameId = $("#gameId").val();
			var params = {
			    gameId : gameId,
			    table : table
			} ;
			var zd =$("#zd").val();
			if(zd != 0){
			   params['zd'] = zd; 
			}
			var area = $("#area").val();
			if(area != null && area != ""){
			   params['area'] = area; 
			}
			var startTime = $("#datemin").val();
			if(startTime != null && startTime != ""){
			   params['startTime'] = startTime;
			}
			
			var endTime = $("#datemax").val() ;
			if(endTime != null && endTime != ""){
			   params['endTime'] = endTime + " 23:59:59";
			}
			
			window.location.href="exportGame/exportData?params=" + JSON.stringify(params);
		}
		
	});
});
	
</script>
<title>导出数据</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="excerciseId" value="${excerciseId }">
	<input type="hidden" id="type" value="${type }">
	<input type="hidden" id="gameId" value="${game.id }">
	<input type="hidden" id="table" value="${game.logTable }">
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>终端：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box inline">
				<select class="select" id="zd">
					<option value="0">全部</option>
					<option value="1">ios</option>
					<option value="2">安卓</option>
					<option value="3">web</option>
				</select>
			</span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地区：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" style="width:250px" placeholder="地区名称" id="area" name="">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>时间范围：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
			-
			<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		</div>
	</div>
	<br>	<br>	<br>
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