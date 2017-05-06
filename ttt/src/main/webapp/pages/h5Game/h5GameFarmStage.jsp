<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="js/h5Game/farm.js"></script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>游戏列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 游戏管理 <span class="c-gray en">&gt;</span> ${game.name}<span class="c-gray en">&gt;</span>关卡配置<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" name="" id="stageId" placeholder=" 关卡" style="width:250px" class="input-text">
		<button name="" id="search" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜关卡</button>
	</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	
     <form target="uploadCallback" action="config/upload" enctype="multipart/form-data" method="post" id="autoSubmit">
	      <input type="file" id="file" name="file" onchange="getFilePath()" style="filter:alpha(opacity=0);opacity:0;width: 0;height: 0;" />  
	       　　 <input type="hidden" id="table" name="table" value="${table}">
	       　　 <input type="hidden" id="code" name="code" value="${game.code}">
	       <a class="btn btn-primary radius" id="openExcel" onclick="openExcel()">下载Excel</a>
	      <input type="button" class="btn btn-primary radius" value="上传Excel" onclick="upload()">　　      
	 </form>
   
   </span>
   </div>

	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" style="text_align:center;">			
		</table>
	</div>
</div>

<iframe id="uploadCallback" name="uploadCallback" style="visibility: hidden"></iframe>
</body>
</html>