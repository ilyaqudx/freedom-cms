<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="js/plan/exercise.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<title>测评</title>
</head>

<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>计划管理 <span class="c-gray en">&gt;</span> 测评列表
	 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		  <span class="l">
			<select class="select" id="selectExams" name="selectExams" size="1">
			<option value="0" selected="selected">请选择试卷</option>
				<c:forEach var="item" items="${exams }">				         														
							<option value="${item.id }">${item.name}</option>
						</c:forEach>
			</select>
         </span>
         <!-- <span style="float: right;">
         <input type="hidden" id="addId">
		 <button class="btn btn-primary radius" id="submit">确定选择</button>
		 </span> --> 
		</div>
			<table class="table table-border table-bordered table-bg table-hover table-sort">
	</table>

	</div>

</body>
</html>
