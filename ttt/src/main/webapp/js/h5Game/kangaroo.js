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
								}, {// 第二列，ID
									name : "id",
									data : "id",
									title : "关卡ID",
									orderable : true
								}, {// 第三列，名称
									name : "time",
									data : "time",
									title : "单关时长",
									orderable : false
								},{// 第4列，试卷
									name : "goodFruit",
									data : "goodFruit",
									title : "好水果几率",
									orderable : false
								}, {// 第5列，
									name : "wolf",
									data : "wolf",
									title : "大灰狼几率",
									orderable : false
								}, {// 第6
									name : "badFruit",
									data : "badFruit",
									title : "坏水果几率",
									orderable : false
								}, {// 第7
									name : "poop",
									data : "poop",
									title : "便便几率",
									orderable : false
								}, {// 第8
									name : "eventOne",
									data : "eventOne",
									title : "事件1几率",
									orderable : false
								}, {// 第9
									name : "oneTime",
									data : "oneTime",
									title : "事件1存在时间",
									orderable : false
								}, {// 第10
									name : "eventTwo",
									data : "eventTwo",
									title : "事件2几率",
									orderable : false
								}, {// 第11
									name : "twoTime",
									data : "twoTime",
									title : "事件2存在时间",
									orderable : false
								}, {// 第12
									name : "minStop",
									data : "minStop",
									title : "停留时间min",
									orderable : false
								}, {// 第13
									name : "maxStop",
									data : "maxStop",
									title : "停留时间max",
									orderable : false
								}, {// 第14
									name : "minRefrain",
									data : "minRefrain",
									title : "抑制时间min",
									orderable : false
								}, {// 第15
									name : "maxRefrain",
									data : "maxRefrain",
									title : "抑制时间max",
									orderable : false
								}, {// 第16
									name : "minInterval",
									data : "minInterval",
									title : "间隔时间min",
									orderable : false
								}, {// 第17
									name : "maxInterval",
									data : "maxInterval",
									title : "间隔时间max",
									orderable : false
								}, {// 第18
									name : "tips",
									data : "tips",
									title : "是否提示",
									orderable : false
								}, {// 第19
									name : "rightScore",
									data : "rightScore",
									title : "单次正确得分",
									orderable : false
								}, {// 第20
									name : "errorScore",
									data : "errorScore",
									title : "单次错误扣分",
									orderable : false
								}, {// 第21
									name : "perfectScore",
									data : "perfectScore",
									title : "完美通关得分",
									orderable : false
								}, {// 第22
									name : "ordinaryScore",
									data : "ordinaryScore",
									title : "普通通关得分",
									orderable : false
								}, {// 第23
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
									targets : 22,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'kangaroo/edit?id='
												+ row.id
												+ '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> ';
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