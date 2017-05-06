<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="js/product/product.js"></script>
<title>商品管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 商品管理 <span class="c-gray en">&gt;</span> 商品 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --> 
	<a href="javascript:;" onclick="product_add('添加商品','product/add','800','800')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加商品</a></span>  </div>
	
	<table class="table table-border table-bordered table-bg table-hover table-sort">
	</table>
</div>

</body>
</html>