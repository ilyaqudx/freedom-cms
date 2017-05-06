<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/fishEdit.js"></script>
<title>捕鱼高手</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>倒计时：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.countdown }" placeholder="" id="countdown" name="countdown">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第一阶段起始数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.oneOriginNum }" placeholder="" id="oneOriginNum" name="oneOriginNum">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第一阶段出现数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.oneFactNum }" placeholder="" id="oneFactNum" name="oneFactNum">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第一阶段操作数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.oneOperationNum }" placeholder="" id="oneOperationNum" name="oneOperationNum">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第二阶段起始数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.twoOriginNum }" placeholder="" id="twoOriginNum" name="twoOriginNum">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第二阶段记忆数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.twoMemoryNum }" placeholder="" id="twoMemoryNum" name="twoMemoryNum">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第二阶段操作数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.twoOperationNum }" placeholder="" id="twoOperationNum" name="twoOperationNum">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>记忆时间最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minMemoryTime }" placeholder="" id="minMemoryTime" name="minMemoryTime">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>记忆时间最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxMemoryTime }" placeholder="" id="maxMemoryTime" name="maxMemoryTime">
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>正确分数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.rightScore }" placeholder="" id="rightScore" name="rightScore">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>错误分数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.errScore }" placeholder="" id="errScore" name="errScore">
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