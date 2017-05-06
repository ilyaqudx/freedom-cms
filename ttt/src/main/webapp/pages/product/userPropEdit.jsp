<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/product/userPropEdit.js"></script>
<title>道具管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="originalCount" value="${userProp.count }">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		
		<div class="row cl"><!-- 道具名 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户ID：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="number" class="input-text" value="${userProp.userId }" id="userId" name="userId" readonly="readonly">
			</div>
	   </div><!-- 名end -->
		<div class="row cl"><!-- 描述-->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>道具：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="number" class="input-text" value="${userProp.propId}" id="propId" name="propId" readonly="readonly">
			</div>
	   </div><!-- 名end -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="number" class="input-text" value="${userProp.count}" id="count" name="count">
			</div>
	   </div>
	   
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="button" class="btn btn-success radius" id="submit"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>