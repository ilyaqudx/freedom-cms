<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/factoryEdit.js"></script>
<title>未来工厂</title>
</head>
<body>
<article class="page-container">
	<label style="color: red;"> 修改配置表数据要慎重</label>
	<form class="form form-horizontal">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>关卡：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.id }" placeholder="" id="stageId" name="stageId" readonly="readonly">
		    
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>传送带1：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.conveyorBelt1 }" placeholder="" id="conveyorBelt1" name="conveyorBelt1">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>传送带2：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.conveyorBelt2 }" placeholder="" id="conveyorBelt2" name="conveyorBelt2">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>传送带3：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.conveyorBelt3 }" placeholder="" id="conveyorBelt3" name="conveyorBelt3">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>传送带4：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.conveyorBelt4 }" placeholder="" id="conveyorBelt4" name="conveyorBelt4">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出现炸弹的几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.oddsOfBomb }" placeholder="" id="oddsOfBomb" name="oddsOfBomb">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>完整物件个数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.fullThingNum }" placeholder="" id="fullThingNum" name="fullThingNum">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>完美通关完成度：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.perfectDegree }" placeholder="" id="perfectDegree" name="perfectDegree">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>普通通关完成度：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.ordinaryDegree }" placeholder="" id="ordinaryDegree" name="ordinaryDegree">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下往上速度最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minSpeedDownUp }" placeholder="" id="minSpeedDownUp" name="minSpeedDownUp">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下往上速度最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxSpeedDownUp }" placeholder="" id="maxSpeedDownUp" name="maxSpeedDownUp">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上往下速度最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minSpeedUpDown }" placeholder="" id="minSpeedUpDown" name="minSpeedUpDown">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上往下速度最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxSpeedUpDown }" placeholder="" id="maxSpeedUpDown" name="maxSpeedUpDown">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>间隔时间最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minTimeInterval }" placeholder="" id="minTimeInterval" name="minTimeInterval">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>间隔时间最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxTimeInterval }" placeholder="" id="maxTimeInterval" name="maxTimeInterval">
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>s
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>