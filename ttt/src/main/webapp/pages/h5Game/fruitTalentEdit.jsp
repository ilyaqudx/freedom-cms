<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/fruitTalentEdit.js"></script>
<title>水果达人</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>篮子数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.basketNum }" placeholder="" id="basketNum" name="basketNum">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>对应水果：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.fruitType }" placeholder="" id="fruitType" name="fruitType">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>倒计时：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.countdown }" placeholder="" id="countdown" name="countdown">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>掉落水果个数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.fruitNum }" placeholder="" id="fruitNum" name="fruitNum">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>正确率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.correctRate }" placeholder="" id="correctRate" name="correctRate">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>过屏时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.dropTime }" placeholder="" id="dropTime" name="dropTime">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通关分数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.passScore }" placeholder="" id="passScore" name="passScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>正确分数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.correctScore }" placeholder="" id="correctScore" name="correctScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>错误扣分：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.incorrectScore }" placeholder="" id="incorrectScore" name="incorrectScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>完美通关：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.perfectNum }" placeholder="" id="perfectNum" name="perfectNum">
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