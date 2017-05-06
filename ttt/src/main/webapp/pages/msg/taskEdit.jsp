<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="js/msg/taskEdit.js"></script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>添加文章</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add" enctype="multipart/form-data">
	<input type="hidden" id="id" value="${task.id }">
	<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="type" name="type" size="1">
				<c:forEach var="item" items="${type }">
						<c:if test="${item.status == task.type }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.type }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl" id="gold">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>栗子数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" size="50" value="${task.attachment }" placeholder="" id="attachment" name="attachment">
			</div>
	</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>消息类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="taskTypeId" name="taskTypeId" size="1">
				<c:forEach var="item" items="${taskTypes }">
						<c:if test="${item.id == task.taskTypeId }">
							<option value="${item.id }" selected="selected">${item.name}</option>
						</c:if>
						<c:if test="${item.id!= task.taskTypeId }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div> --%>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 50%;" size="50" value="${task.title }" placeholder="" id="title" name="title">
			</div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="width: 70%;" id="content" name="content" >${task.content }</textarea>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="eventType" name="eventType" size="1">
				<c:forEach var="item" items="${eventTypeList }">
						<c:if test="${item.status == task.eventType }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.eventType }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>事件参数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" style="width: 50%;" size="50" value="${task.eventParams }" placeholder="" id="eventParams" name="eventParams">
			</div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="userType" name="userType" size="1">
				<c:forEach var="item" items="${userTypeList }">
						<c:if test="${item.status == task.userType }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.userType }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否VIP：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="vip" name="vip" size="1">
				<c:forEach var="item" items="${vipTypeList }">
						<c:if test="${item.status == task.vip }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.vip }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否新增：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="newAdd" name="newAdd" size="1">
				<c:forEach var="item" items="${newAddList }">
						<c:if test="${item.status == task.newAdd }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.newAdd }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl" id="newAddDaysDiv">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新增天数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="width: 70%;" id="newAddDays" name="newAddDays" >${task.newAddDays }</textarea>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户端展现方式：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="showType" name="showType" size="1">
				<c:forEach var="item" items="${showTypeList }">
						<c:if test="${item.status == task.showType }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.showType }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>执行动作：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="actionType" name="actionType" size="1">
				<c:forEach var="item" items="${actionTypeList }">
						<c:if test="${item.status == task.actionType }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.actionType }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl" id="openUrl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>跳转URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea style="width: 70%;" id="action" cmd="openUrl" name="action" >${task.action }</textarea>
			</div>
	</div>
	<!-- 如果执行的动作是打开APP页面,进行下拉选择 -->
	<div class="row cl" id="jumpView">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>指定页面：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="action" name="action" cmd="jumpView" size="1" onchange="selectChange(this)">
				<c:forEach var="item" items="${jumpViewList }">
						<c:if test="${item.status == task.action }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status != task.action }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="status" name="status" size="1">
				<c:forEach var="item" items="${statusList }">
						<c:if test="${item.status == task.status }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!= task.status }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>有效期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="taskFirstExecuteDate" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${task.taskFirstExecuteDate}" pattern="yyyy-MM-dd"/>">
				-
				<input type="text" onfocus="WdatePicker()" id="taskLastExecuteDate" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${task.taskLastExecuteDate}" pattern="yyyy-MM-dd"/>">
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>执行时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" id="taskExecuteTime" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${task.taskExecuteTime}" pattern="hh:mm:ss"/>">
			</div>
	</div>
	<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>有效期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${task.startTime}" pattern="yyyy-MM-dd"/>">
				-
				<input type="text" onfocus="WdatePicker()" id="datemax" class="input-text Wdate" style="width:120px;" value="<fmt:formatDate value="${task.endTime}" pattern="yyyy-MM-dd"/>">
			</div>
	</div> --%>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>发布终端：</label>
			<div class="formControls col-xs-8 col-sm-9">
			   <input type="hidden" id="devices" name="devices" value="${task.devices }">
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