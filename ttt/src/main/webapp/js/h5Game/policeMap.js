 function uploadCallback(data) { 
       if (data.code == "0") { 
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
									name : "row1",
									data : "row1",
									title : "第1行障碍",
									orderable : false
								},

								{// 第4列，试卷
									name : "row2",
									data : "row2",
									title : "第2行障碍",
									orderable : false
								}, {// 第5列，
									name : "row3",
									data : "row3",
									title : "第3行障碍",
									orderable : false
								}, {// 第5列，
									name : "row4",
									data : "row4",
									title : "第4行障碍",
									orderable : false
								}, {// 第5列，
									name : "row5",
									data : "row5",
									title : "第5行障碍",
									orderable : false
								}, {// 第5列，
									name : "row6",
									data : "row6",
									title : "第6行障碍",
									orderable : false
								}, {// 第5列，
									name : "row7",
									data : "row7",
									title : "第7行障碍",
									orderable : false
								}, {// 第5列，
									name : "row8",
									data : "row8",
									title : "第8行障碍",
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

								}],

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
		return params;
	}

});