  function uploadCallback(data) { 
       if (data.code == "0") { 
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
									name : "flyPestType",
									data : "flyPestType",
									title : "有几种飞行害虫",
									orderable : false
								},

								{// 第4列，试卷
									name : "creepPestType",
									data : "creepPestType",
									title : "有几种爬行害虫",
									orderable : false
								}, {// 第5列，
									name : "newPest",
									data : "newPest",
									title : "中途新增害虫数量",
									orderable : false
								}, {// 第6
									name : "pestNum",
									data : "pestNum",
									title : "每种害虫出现数量",
									orderable : false
								}, {// 第7
									name : "shellType",
									data : "shellType",
									title : "炮弹种类",
									orderable : false
								}, {// 第8
									name : "shellRate",
									data : "shellRate",
									title : "炮弹数量倍率",
									orderable : false
								}, {// 第9
									name : "minTipInterval",
									data : "minTipInterval",
									title : "新增间隔害虫数最小值",
									orderable : false
								}, {// 第10
									name : "maxTipInterval",
									data : "maxTipInterval",
									title : "新增间隔害虫最大值",
									orderable : false
								}, {// 第11
									name : "minShowInterval",
									data : "minShowInterval",
									title : "到出现的间隔害虫最小值",
									orderable : false
								}, {// 第12
									name : "maxShowInterval",
									data : "maxShowInterval",
									title : "到出现的间隔害虫最大值",
									orderable : false
								}, {// 第13
									name : "tipsTime",
									data : "tipsTime",
									title : "关卡开始提示时间",
									orderable : false
								}, {// 第14
									name : "overScreen",
									data : "overScreen",
									title : "害虫过屏时间",
									orderable : false
								}, {// 第15
									name : "minPestInterval",
									data : "minPestInterval",
									title : "害虫出现间隔最小值",
									orderable : false
								}, {// 第16
									name : "maxPestInterval",
									data : "maxPestInterval",
									title : "害虫出现间隔最大值",
									orderable : false
								}, {// 第17
									name : "killPestNum",
									data : "killPestNum",
									title : "消灭害虫",
									orderable : false
								}, {// 第18
									name : "perfectNum",
									data : "perfectNum",
									title : "完美个数",
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
										return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'garden/edit?id='
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