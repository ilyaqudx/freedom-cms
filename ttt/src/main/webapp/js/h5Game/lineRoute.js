  function uploadCallback(data) { 
       if (data.code == 0) { 
    	   layer.msg("导入成功！");
    	   location.reload();
       }else{
    	   layer.msg("导入失败！"); 
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
								}, {// 第2
									name : "id",
									data : "id",
									title : "关卡ID",
									orderable : true
								}, {// 第3
									name : "routeImg",
									data : "routeImg",
									title : "线路图名称",
									orderable : true
								}, {// 第4
									name : "diff",
									data : "diff",
									title : "难度",
									orderable : false
								},{// 第5
									name : "entryId",
									data : "entryId",
									title : "入口编号",
									orderable : false
								}, {// 第6
									name : "gap1_1",
									data : "gap1_1",
									title : "缺口1-1",
									orderable : false
								}, {// 第7
									name : "gap1_2",
									data : "gap1_2",
									title : "缺口1-2",
									orderable : false
								}, {// 第8
									name : "gap1_3",
									data : "gap1_3",
									title : "缺口1-3",
									orderable : false
								}, {// 第9
									name : "gap2_1",
									data : "gap2_1",
									title : "缺口2-1",
									orderable : false
								}, {// 第10
									name : "gap2_2",
									data : "gap2_2",
									title : "缺口2-2",
									orderable : false
								}, {// 第11
									name : "gap2_3",
									data : "gap2_3",
									title : "缺口2-3",
									orderable : false
								}, {// 第12
									name : "gap3_1",
									data : "gap3_1",
									title : "缺口3-1",
									orderable : false
								}, {// 第13
									name : "gap3_2",
									data : "gap3_2",
									title : "缺口3-2",
									orderable : false
								}, {// 第14
									name : "gap3_3",
									data : "gap3_3",
									title : "缺口3-3",
									orderable : false
								}, {// 第15
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
									targets : 14,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'lineRoute/edit?id='
												+ row.id + '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> ';
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