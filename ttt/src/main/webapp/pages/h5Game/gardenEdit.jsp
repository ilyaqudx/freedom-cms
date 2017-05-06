<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/gardenEdit.js"></script>
<title>保卫花园</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>有几种飞行害虫：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.flyPestType }" placeholder="" id="flyPestType" name="flyPestType">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>有几种爬行害虫：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.creepPestType }" placeholder="" id="creepPestType" name="creepPestType">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>中途新增害虫数量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.newPest }" placeholder="" id="newPest" name="newPest">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>每种害虫出现数量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.pestNum }" placeholder="" id="pestNum" name="pestNum">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>炮弹种类：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.shellType }" placeholder="" id="shellType" name="shellType">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>炮弹数量倍率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.shellRate }" placeholder="" id="shellRate" name="shellRate">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新增间隔数最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minTipInterval }" placeholder="" id="minTipInterval" name="minTipInterval">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新增间隔数最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxTipInterval }" placeholder="" id="maxTipInterval" name="maxTipInterval">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>到出现的间隔最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minShowInterval }" placeholder="" id="minShowInterval" name="minShowInterval">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>到出现的间隔最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxShowInterval }" placeholder="" id="maxShowInterval" name="maxShowInterval">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>关卡开始提示时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.tipsTime }" placeholder="" id="tipsTime" name="tipsTime">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>害虫过屏时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.overScreen }" placeholder="" id="overScreen" name="overScreen">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>害虫出现间隔最小值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minPestInterval }" placeholder="" id="minPestInterval" name="minPestInterval">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>害虫出现间隔最大值：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxPestInterval }" placeholder="" id="maxPestInterval" name="maxPestInterval">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>消灭害虫：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.killPestNum }" placeholder="" id="killPestNum" name="killPestNum">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>完美个数：</label>
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