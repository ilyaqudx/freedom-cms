<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/product/propEdit.js"></script>
<title>道具管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="propId" value="${prop.id }">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="type" name="type" size="1">
					<option value="1" selected="selected">食物</option>
					<option value="2" >卡片</option>
			    </select>
			</span>
			</div>
		</div>
		<div class="row cl"><!-- 道具名 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>道具名称：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="text" class="input-text" value="${prop.name }" id="name" name="name">
			</div>
	   </div><!-- 名end -->
		<div class="row cl"><!-- 描述-->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="text" class="input-text" value="${prop.description }" id="description" name="description">
			</div>
	   </div><!-- 名end -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图片：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<img alt="图片" id="imageShow" src="${prop.image}" width="60px" height="40px">
				<input type="file" id="image" name="image" multiple="multiple">
			</div>
	   </div>
	   <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否可以随机获取：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="random" name="random" size="1">
					<option value="0" selected="selected">否</option>
					<option value="1" >是</option>
			    </select>
			</span>
			</div>
		</div>
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>增加宠物经验值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${prop.petExp }" placeholder="" id="petExp" name="petExp" >
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