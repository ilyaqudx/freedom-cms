<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/standingEdit.js"></script>
<title>一站到底</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>题目个数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.questionNum }" placeholder="" id="questionNum" name="questionNum">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>题目类型：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.questionType }" placeholder="" id="questionType" name="questionType">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图形推理难度：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.aTypeDiff }" placeholder="" id="aTypeDiff" name="aTypeDiff">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数字推理难度：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.bTypeDiff }" placeholder="" id="bTypeDiff" name="bTypeDiff">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>回答时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.answerTime }" placeholder="" id="answerTime" name="answerTime">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电脑作答：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.aiAnswer }" placeholder="" id="aiAnswer" name="aiAnswer">
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