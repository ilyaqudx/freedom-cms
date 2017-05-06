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
									name : "timeForPer",
									data : "timeForPer",
									title : "单关时长",
									orderable : false
								},{// 第4列，试卷
									name : "mapId",
									data : "mapId",
									title : "地图ID",
									orderable : false
								}, {// 第5列，
									name : "disturbNum",
									data : "disturbNum",
									title : "干扰物数量",
									orderable : false
								}, {// 第6
									name : "planetId",
									data : "planetId",
									title : "卫星ID",
									orderable : false
								}, {// 第7
									name : "planetNum",
									data : "planetNum",
									title : "卫星个数",
									orderable : false
								}, {// 第8
									name : "batteryNum",
									data : "batteryNum",
									title : "电池数量",
									orderable : false
								}, {// 第9
									name : "perfectNum",
									data : "perfectNum",
									title : "完美通关正确次数",
									orderable : false
								}, {// 第10
									name : "ordinaryNum",
									data : "ordinaryNum",
									title : "普通通关正确次数",
									orderable : false
								}, {// 第11
									name : "minStop",
									data : "minStop",
									title : "冷却时间最小值",
									orderable : false
								}, {// 第12
									name : "maxStop",
									data : "maxStop",
									title : "冷却时间最大值",
									orderable : false
								}, {// 第13
									name : "speed",
									data : "speed",
									title : "速度",
									orderable : false
								}, {// 第14
									name : "totalTurns",
									data : "totalTurns",
									title : "总轮数",
									orderable : false
								}, {// 第15
									name : "perfectTurns",
									data : "perfectTurns",
									title : "完美通关正确轮数",
									orderable : false
								}, {// 第16
									name : "ordinaryTurns",
									data : "ordinaryTurns",
									title : "普通通关正确轮数",
									orderable : false
								}, {// 第17
									name : "passNum",
									data : "passNum",
									title : "单轮正确个数",
									orderable : false
								}, {// 第18
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
									targets : 17,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="stage_edit(\'关卡编辑\',\'space/edit?id='
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