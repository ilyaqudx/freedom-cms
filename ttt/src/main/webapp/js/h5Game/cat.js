 function uploadCallback(data) { 
       if (data.code == 0) { 
    	   layer.msg("上传成功！");
    	   location.reload();
       }else{
    	   layer.msg("上传失败！"); 
       }
   }
/*************打开excel******************/
 function openExcel(){ 
	 var table = $("#table").val();
	 window.location.href = "config/download?table=" + table;
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

/** *******************表格数据显示********************* */
$(function() {
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.full(index);
	var t = $('.table')
			.dataTable(
					{// 得到表格
						colReorder : false,// 是否允许你列拖动
						serverSide : true,// 是否需要服务器支持
						bFilter : false,// 是否过滤数据
						"columns" : [// 具体的列
								{// 第一列，复选框
									data : null,
									title : "<input type='checkbox' name='' value=''/>",
									orderable : false
								}, {// 第二列，ID
									name : "id",
									data : "id",
									title : "关卡ID",
									orderable : true
								}, {// 第三列，名称
									name : "taskType",
									data : "taskType",
									title : "任务类型",
									orderable : false
								},

								{// 第4列，试卷
									name : "tools",
									data : "tools",
									title : "道具",
									orderable : false
								}, {// 第5列，
									name : "gainTools",
									data : "gainTools",
									title : "增益道具几率",
									orderable : false
								}, {// 第6
									name : "debuff",
									data : "debuff",
									title : "减益道具几率",
									orderable : false
								}, {// 第7
									name : "animalSpeed",
									data : "animalSpeed",
									title : "猫下落时间",
									orderable : false
								}, {// 第8
									name : "monsterSpeed",
									data : "monsterSpeed",
									title : "怪物下落时间",
									orderable : false
								}, {// 第9
									name : "animalInterval",
									data : "animalInterval",
									title : "友方间隔时间",
									orderable : false
								}, {// 第10
									name : "animalBeed",
									data : "animalBeed",
									title : "友方频率",
									orderable : false
								}, {// 第11
									name : "animalNumber",
									data : "animalNumber",
									title : "友方数量",
									orderable : false
								}, {// 第12
									name : "monsterInterval",
									data : "monsterInterval",
									title : "敌方间隔",
									orderable : false
								}, {// 第13
									name : "monsterBeed",
									data : "monsterBeed",
									title : "敌方频率",
									orderable : false
								}, {// 第14
									name : "monsterNumber",
									data : "monsterNumber",
									title : "敌方数量",
									orderable : false
								}, {// 第15
									name : "score",
									data : "score",
									title : "分数",
									orderable : false
								}, {// 第16
									name : "pick",
									data : "pick",
									title : "错误扣分",
									orderable : false
								}, {// 第17
									name : "ordinaryDegree",
									data : "ordinaryDegree",
									title : "普通通关",
									orderable : false
								}, {// 第18
									name : "perfectDegree",
									data : "perfectDegree",
									title : "完美通关",
									orderable : false
								}, {// 第19
									data : null,
									title : "操作",
									orderable : false
								} ],
						"aaSorting" : [ 1, "asc" ],// 默认第几个排序，ID列升序
						"bStateSave" : true,
						"aoColumnDefs" : [

								{
									sDefaultContent : '',
									aTargets : [ '_all' ]
								},
								{// 设置列统一的值，
									targets : 0,
									render : function(data, type, row, meta) {
										return '<input type="checkbox" name="" value="'
												+ row.id + '" />';
									}

								},
								{
									targets : 18,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'cat/edit?id='
												+ row.id + '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
									}
								} ],

						fnServerData : function(sSource, aoData, fnCallback) {
							// 加入额外的参数
							aoData.push({
								"name" : "params",
								"value" : getParams()
							});
							var postdata = {};
							var postSize = aoData.length;
							for ( var i = 0; i < postSize; i++) {
								aoData[i].value = JSON
										.stringify(aoData[i].value);
							}
							
							$.ajax({
								"dataType" : 'json',
								"type" : "POST",
								"url" : sSource,
								"data" : aoData,
								"success" : fnCallback
							});
						}
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