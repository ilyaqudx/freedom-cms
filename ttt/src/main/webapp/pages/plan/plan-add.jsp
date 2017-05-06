<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/plan/plan-add.js"></script>
<title>添加管理员 - 管理员管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="planId" value="${plan.id }">
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>计划名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${plan.name }" placeholder="" id="planName" name="planName">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" id="templateId" name="templateId" size="1">
				<c:forEach var="item" items="${templates }">
					<c:if test="${plan != null }">
						<c:if test="${item.id==plan.templateId }">
							<option value="${item.id }" selected="selected">${item.name }</option>
						</c:if>
						<c:if test="${item.id==plan.templateId }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
					</c:if>
					<c:if test="${plan == null }">
						<option value="${item.id }">${item.name }</option>
					</c:if>
					
				</c:forEach>
			</select>
			</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排序：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${plan.sequence }" placeholder="" id="sequence" name="sequence">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>训练周期：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.cycle }" placeholder="" id="cycle" name="cycle">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>免费天数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.freeDays }" min="0" placeholder="" id="freeDays" name="freeDays">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原价：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.originalGold }" placeholder="" name="originalGold" id="originalGold">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>现价：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.gold }" placeholder="" name="gold" id="gold">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>通关需要星星数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.trainingPassStar }" min="0" placeholder="" name="trainingPassStar" id="trainingPassStar">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>训练能力数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.trainingAbilityCount }" min="1" placeholder="" name="trainingAbilityCount" id="trainingAbilityCount">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>测评能力数：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="${plan.evaluationAbilityCount }" min="1" placeholder="" name="evaluationAbilityCount" id="evaluationAbilityCount">
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