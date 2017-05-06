<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/plan/planNameAdd.js"></script>
<title>添加游戏</title>
</head>
<body>
<article class="page-container">
	
	<form class="form form-horizontal" id="form-admin-add" action="plan/planNameAdd" method="post" enctype="multipart/form-data" onsubmit="return check()" target="_self">
	
	<input type="hidden" name="id" value="${plan.id}" id="id"/>
	<input type="hidden" name="abilitysJSON" value="${plan.abilitysJSON}" id="abilitysJ"/>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>计划名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${plan.name }" placeholder="" id="planName" name="name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3" ><span class="c-red">*</span>维度：</label>
		<div class="formControls col-xs-8 col-sm-9" id="abilitys">
			
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图片：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${plan.img }" width="60px" height="40px" id="imgShow">
			<input type="file" name="file" id="imgFile">
			 </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>横幅：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${plan.banner }" width="60px" height="40px" id="icon">
			<input type="file" name="fileIcon" id="fileIcon">
			 </div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" id="sure" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		    <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;取消&nbsp;&nbsp;" id="cancel"/>
		</div>
	</div>
	
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>