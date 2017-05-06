<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/system/system-category.js"></script>
<title>产品分类</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 栏目管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
	<tr>
		<td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
		<td class="va-t">
			<input type="hidden" id="pId" value="${pId }">
			<div class="page-container">
<!-- 				<div class="text-c">
					<form class="Huiform" method="post" action="" target="_self">
						<input type="text" class="input-text" style="width:250px" placeholder="权限名称" id="" name="">
						<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜权限节点</button>
					</form>
				</div> -->
				<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --><a href="javascript:;" onclick="system_category_add('添加栏目','','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加栏目</a></span></div>
				<table id="table" class="table table-border table-bordered table-bg">
				</table>
			</div>
		</td>
	</tr>
</table>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>