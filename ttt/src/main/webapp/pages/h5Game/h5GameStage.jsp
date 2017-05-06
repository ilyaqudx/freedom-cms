<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<!-- <script type="text/javascript" src="js/h5Game/h5game.js"></script> -->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>游戏关卡配置</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 游戏管理 <span class="c-gray en">&gt;</span> ${game.name}<span class="c-gray en">&gt;</span>关卡配置 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!-- <div class="text-c">
		<input type="text" name="" id="stageId" placeholder=" 关卡" style="width:250px" class="input-text">
		<button name="" id="search" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜关卡</button>
	</div> -->
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	
     <form target="uploadCallback" action="game/stage/config/upload" enctype="multipart/form-data" method="post" id="autoSubmit">
	      <input type="file" id="file" name="file" onchange="getFilePath()" style="filter:alpha(opacity=0);opacity:0;width: 0;height: 0;" />  
	       　　 <input type="hidden" id="gameCode" name="gameCode" value="${game.code}">
	       <input type="button" class="btn btn-primary radius" value="导入关卡配置(Excel)" onclick="upload()">　
	     <a class="btn btn-primary radius" id="openExcel" onclick="openExcel()">下载关卡配置(Excel)</a>
	      　      
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
<script type="text/javascript">

 function uploadCallback(data) { 
       if (data.code == 0) { 
    	   layer.msg("上传成功！");
       }else{
    	   layer.msg("上传失败！" + data.msg); 
       }
       
       setTimeout( function(){
       		location.reload();
       }, 1500);
   }
   
/*************打开excel******************/
 function openExcel(){ 
	 var gameCode = $("#gameCode").val();
	 window.location.href = "game/stage/config/download?gameCode=" + gameCode;
}

 /* 获取 文件的路径 ，用于测试*/  
 function getFilePath(){  
	 filePath = $("#file").val();
	 if(filePath != ''){
		 suffix = filePath.substring(filePath.lastIndexOf('.')).toLowerCase();
		 if(suffix != ".xlsx"){
			 layer.msg("目前只支持excel2007文件");
		 }else{
			 layer.msg("正在上传");
			$("#autoSubmit").submit();
		 }
	 }
 }
 
 function upload(){
	 $("#file").trigger("click");
 }
/** ***************计划名编辑********************** */
function stage_edit(title, url, w, h) {
	layer_show(title, url, w, h);
}

function stage_del(obj, id) {
	layer.confirm('关卡删除须谨慎，确认要删除吗？', function(index) {
		$.post("gamestage/del", {
			'id' : id
		}, function(data) {
			location.reload();
			layer.msg("已删除", {
				icon : 1,
				time : 1000
			});
		});
	});
}
/** *******************表格数据显示********************* */
$(function() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.full(index);
	
	// 1. get game stageFileds
	var fileds = [];
	$.get("game/stage/fields?gameCode=" + ${game.code}, function(filedsText){
		var fileds = JSON.parse(filedsText);
		
		if (fileds.code) {
			layer.msg("获取关卡字段失败！" + fileds.msg);
			return;
		}
		
		// 2. get stage values
		$.get("game/stage/list/value?gameCode=" + ${game.code}, function(valueText){
			// 3.init table
			var columns = [];
			for (var attr in fileds) {
				columns.push({
					name: attr,
					data: attr,
					title: fileds[attr],
					orderable: attr === "id"
				});
			}
			
			// add modify column
			columns.push({
				data : null,
				title : "操作",
				orderable : false
			});
			
			var stageValues = JSON.parse(valueText);
			if (stageValues.code) {
				layer.msg("获取关卡配置数据！" + stageValues.msg);
				return;
			}
			
			/*
			for (var index = 0, len = stageValues.length; index < len; index++) {
				stageValues[index] = JSON.parse(stageValues[index]);
			}*/

			$('.table').dataTable({
				columns: columns,
				data: stageValues,
				aoColumnDefs: [{
					targets: columns.length - 1,
					render : function(data, type, row, meta) {
						return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'game/stage/one?gameCode=${game.code}&stageId='
								+ row.id + '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
					}
				}]
			});
		});
	});
	
	$('#search').on('click', function() {
		debugger
		t.fnDraw();
	});

	function getParams() {
		var params = {};

		var table = $("#table").val();
		params['table'] = table;
		var stageId = $("#stageId").val();
		if(stageId != null && stageId != ""){
			params['id'] = stageId;
		}
		return params;
	}

});


</script>
</html>