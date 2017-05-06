<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/msg/msgTypeEdit.js"></script>
<title>添加类型</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add">
	<input type="hidden" id="id" name="id" value="${messageType.id}">
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${messageType.type }" placeholder="" id="type" name="type">
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${messageType.name }" placeholder="" id="name" name="name">
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>消息组：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="groupId" name="groupId" size="1">
				<c:forEach var="item" items="${group }">
						<c:if test="${item.id == messageType.groupId }">
							<option value="${item.id }" selected="selected">${item.name}</option>
						</c:if>
						<c:if test="${item.id != messageType.groupId }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
				</c:forEach>
			</select></span>
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