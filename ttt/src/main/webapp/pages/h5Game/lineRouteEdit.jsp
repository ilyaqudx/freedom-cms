<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/lineRouteEdit.js"></script>
<title>连线-线路</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>线路图名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${stage.routeImg }" placeholder="" id="routeImg" name="routeImg">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>难度：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.diff }" placeholder="" id="diff" name="diff">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>入口编号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.entryId }" placeholder="" id="entryId" name="entryId">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口1-1：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap1_1 }" placeholder="" id="gap1_1" name="gap1_1">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口1-2：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap1_2 }" placeholder="" id="gap1_2" name="gap1_2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口1-3：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap1_3 }" placeholder="" id="gap1_3" name="gap1_3">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口2-1：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap2_1 }" placeholder="" id="gap2_1" name="gap2_1">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口2-2：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap2_2 }" placeholder="" id="gap2_2" name="gap2_2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口2-3：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap2_3 }" placeholder="" id="gap2_3" name="gap2_3">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口3-1：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap3_1 }" placeholder="" id="gap3_1" name="gap3_1">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口3-2：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap3_2 }" placeholder="" id="gap3_2" name="gap3_2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>缺口3-3：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${stage.gap3_3 }" placeholder="" id="gap3_3" name="gap3_3">
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