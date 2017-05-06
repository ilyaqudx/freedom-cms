<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/h5Game/kangarooEdit.js"></script>
<title>袋鼠蹦跶</title>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单关时长：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.time }" placeholder="" id="time" name="time">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>好水果几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.goodFruit }" placeholder="" id="goodFruit" name="goodFruit">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>大灰狼几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.wolf }" placeholder="" id="wolf" name="wolf">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>坏水果几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.badFruit }" placeholder="" id="badFruit" name="badFruit">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>便便几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.poop }" placeholder="" id="poop" name="poop">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件1几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.eventOne }" placeholder="" id="eventOne" name="eventOne">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件1存在时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.oneTime }" placeholder="" id="oneTime" name="oneTime">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件2几率：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.eventTwo }" placeholder="" id="eventTwo" name="eventTwo">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件2存在时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.twoTime }" placeholder="" id="twoTime" name="twoTime">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>停留时间min：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minStop }" placeholder="" id="minStop" name="minStop">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>停留时间max：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxStop }" placeholder="" id="maxStop" name="maxStop">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>抑制时间min：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minRefrain }" placeholder="" id="minRefrain" name="minRefrain">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>抑制时间max：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxRefrain }" placeholder="" id="maxRefrain" name="maxRefrain">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>间隔时间min：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.minInterval }" placeholder="" id="minInterval" name="minInterval">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>间隔时间max：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.maxInterval }" placeholder="" id="maxInterval" name="maxInterval">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否提示：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.tips }" placeholder="" id="tips" name="tips">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单次正确得分：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.rightScore }" placeholder="" id="rightScore" name="rightScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单次错误扣分：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.errorScore }" placeholder="" id="errorScore" name="errorScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>完美通关得分：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.perfectScore }" placeholder="" id="perfectScore" name="perfectScore">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>普通通关得分：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${stage.ordinaryScore }" placeholder="" id=ordinaryScore name="ordinaryScore">
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