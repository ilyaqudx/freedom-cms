<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/task/userTaskAdd.js"></script>
<title>用户任务管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="userTaskId" value="${userTask.id }">
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>userId：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${userTask.userId }" placeholder="" id="userId" name="userId" readonly="readonly">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>任务：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" id="name" name="name" size="1">
				<c:forEach var="item" items="${tasks }">
						<c:if test="${item.id==userTask.taskId }">
							<option value="${item.id }" selected="selected">${item.name }</option>
						</c:if>
						<c:if test="${item.id !=userTask.taskId }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
				</c:forEach>
			</select>
			</span> </div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>金币：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${userTask.gold }" placeholder="" id="gold" name="gold">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" id="status" name="status" size="1">
				<c:forEach var="item" items="${status }">
						<c:if test="${item.status == userTask.status }">
							<option value="${item.status }" selected="selected">${item.statusName }</option>
						</c:if>
						<c:if test="${item.status != userTask.status }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select>
			</span> </div>
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