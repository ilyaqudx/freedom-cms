<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/vip/accountVipAdd.js"></script>
<title>会员期间</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="accountVipId" value="${accountVip.id }">
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
		<label class="col-xs-4 col-sm-3 text-r"><span class="c-red">*</span>电话：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" style="width: 253px;" min="0" value="${phone}" placeholder="" id="phone" name="phone">
			<br />
			<span style="color: red;font-size: 14px;" id="tips1"></span>
			<span style="color: red;font-size: 14px;" id="tips2"></span>
		</div>
	</div>
	<div class="row cl">
		<label class="col-xs-4 col-sm-3 text-r"><span class="c-red">*</span>时间范围：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" onfocus="WdatePicker({minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'datemax\')}'})" id="datemin" class="input-text Wdate" style="width:120px;">
			-
			<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:120px;">
		</div>
	</div>
	<div class="row cl">
		<label class="col-xs-4 col-sm-3 text-r"><span class="c-red">*</span>备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" min="0" value="${accountVip.mark }" placeholder="备注必须写以便以后有据可查" id="mark" name="mark" style="width: 253px;">
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