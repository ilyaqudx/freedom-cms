<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="js/msg/messageEdit.js"></script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>添加文章</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add" enctype="multipart/form-data">
	<input type="hidden" id="id" value="${message.id }">
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="type" name="type" size="1">
				<c:forEach var="item" items="${type }">
						<c:if test="${item.status == message.type }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= message.type }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl" id="gold">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>栗子数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" size="50" value="${message.attachment }" placeholder="" id="attachment" name="attachment">
			</div>
	</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>消息类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="messageTypeId" name="messageTypeId" size="1">
				<c:forEach var="item" items="${messageTypes }">
						<c:if test="${item.id == message.messageTypeId }">
							<option value="${item.id }" selected="selected">${item.name}</option>
						</c:if>
						<c:if test="${item.id!= message.messageTypeId }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 50%;" size="50" value="${message.title }" placeholder="" id="title" name="title">
			</div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>APP内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="width: 70%;height: 200px;" id="content" name="content" >${message.content }</textarea>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>微信内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="width: 70%;height: 200px;" id="wxContent" name="wxContent" >${message.wxContent }</textarea>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="status" name="status" size="1">
				<c:forEach var="item" items="${statusList }">
						<c:if test="${item.status == message.status }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= message.status }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>有效期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${message.startTime}" pattern="yyyy-MM-dd"/>">
				-
				<input type="text" onfocus="WdatePicker()" id="datemax" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${message.endTime}" pattern="yyyy-MM-dd"/>">
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发布终端：</label>
			<div class="formControls col-xs-8 col-sm-9">
			   <input type="hidden" id="devices" name="devices" value="${message.devices }">
				<input type="checkbox" value="0" name="app" id="selecctApp"> APP: &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" value="1" name="terminal" disabled="disabled"> ios iphone &nbsp;&nbsp;
				<input type="checkbox" value="2" name="terminal" disabled="disabled"> ios ipad &nbsp;&nbsp;
				<input type="checkbox" value="3" name="terminal" disabled="disabled"> android iphone &nbsp;&nbsp;
				<input type="checkbox" value="4" name="terminal" disabled="disabled"> android ipad <br/>
				<input type="checkbox" value="5" name="weixin">微信
			</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;
		</div>
	</div>
	</form>
</article>

</body>
</html>