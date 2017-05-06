<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="js/plan/userPlan.js"></script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>计划名库</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 计划管理 <span class="c-gray en">&gt;</span> 计划名库 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c" >
	 <select id="schools" size="1" style="width: 150px;height: 30px;"><!--  学校-->
	  <option value="0">选择学校</option>
	  <c:forEach var="item" items="${schools }">
	   <option value="${item }">${item }</option>
	  </c:forEach>
	 </select>
	 <select id="grades" size="1" style="width: 100px;height: 30px;"><!-- 年级 -->
	 <option value="0">选择年级</option>
	   <c:forEach var="g" begin="1" end="12">
	   <option value="${g }">${g}年级</option>
	   </c:forEach>
	 </select>
	 <select id="classes" size="1" style="width: 100px;height: 30px;margin-right: 20px;"><!-- 班级 -->
	 <option value="0">选择班级</option>
	   <c:forEach var="c" begin="1" end="12">
	   <option value="${c }">${c}班</option>
	   </c:forEach>
	 </select>  
	 成员创建时间：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')||\'%y-%M-%d\'}'})" id="startTime" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',maxDate:'%y-%M-%d'})" id="endTime" class="input-text Wdate" style="width:120px;">
		<input type="text" name="name" id="name" placeholder="用户昵称" style="width:150px" class="input-text">
		<input type="text" name="phone" id="phone" placeholder="用户电话" style="width:150px" class="input-text">
		<button name="search" id="search" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜计划</button>
	</div>
	
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" style="text_align:center;">			
		</table>
	</div>
</div>


</body>

</html>