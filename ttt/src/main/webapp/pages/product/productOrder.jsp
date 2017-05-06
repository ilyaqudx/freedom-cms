<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="js/product/order.js"></script>
<title>商品订单管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 商品管理 <span class="c-gray en">&gt;</span> 商品订单<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
   <div class="text-c">
  <input type="text" class="input-text" style="width:250px" placeholder="电话号码" id="phone" name="">  
    日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<select class="input-text" style="width:250px" id="status">
		  <option value="">请选择状态</option>
		  <option value="0">处理中</option>
		  <option value="1">成功</option>
		  <option value="2">失败</option>
		</select>
		<button type="submit" class="btn btn-success" id="search" name="" accesskey=""><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"></span> <!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --> 	
	<table class="table table-border table-bordered table-bg table-hover table-sort">
	</table>
</div>
</div>
</body>
</html>