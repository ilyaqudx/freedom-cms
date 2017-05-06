
/*导出数据*/
function exportData(id){
	var url = "exportGame/export?type=2&id="+id;
	layer_show("导出数据",url,600,400);
}
/** *******************表格数据显示********************* */
$(function() {
	var t = $('.table')
			.dataTable(
					{// 得到表格
						colReorder : false,// 是否允许你列拖动
						serverSide : true,// 是否需要服务器支持
						bFilter : false,// 是否过滤数据
						"columns" : [// 具体的列
								 {// 第1
									name : "code",
									data : "code",
									title : "编号",
									orderable : true
								}, {// 第2
									name : "name",
									data : "name",
									title : "游戏名",
									orderable : false
								}, {// 第3
									name : "abilityName",
									data : "abilityName",
									title : "对应能力",
									orderable : false
								},{// 第4列，试卷
									name : "icon",
									data : "icon",
									title : "图标",
									orderable : false
								}, {// 第5
									data : null,
									title : "操作",
									orderable : false
								} ],
						"aaSorting" : [ 0, "asc" ],// 默认第几个排序，ID列升序
						"bStateSave" : true,
						"aoColumnDefs" : [

								{
									sDefaultContent : '',
									aTargets : [ '_all' ]
								},
								{// 设置列统一的值，
									targets : 3,
									render : function(data, type, row, meta) {
										return '<img src="'
												+ row.icon
												+ '" width="50px" height="30px" />';
									}

								},
								{
									targets : 4,
									render : function(data, type, row, meta) {
										var html = '';
							    		  html += ' <a title="导出数据" href="javascript:;" authority="/exportGame/export" onclick="exportData('+row.id+')" class="ml-5" style="text-decoration:none"><img alt="" width="14" height="14" src="static/icon/exporticon.png"></a>';
							    		  return html;
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
		var code = $("#gameCode").val();
		if(code != null && code != ""){
			params['code'] = code;
		}
		return params;
	}

});