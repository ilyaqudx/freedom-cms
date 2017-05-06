/** ***************计划名编辑********************** */
function edit(title, url, w, h) {
	layer_show(title, url, w, h);
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
								 {// 第1列，ID
									name : "id",
									data : "id",
									title : "编号",
									orderable : true
								}, {// 第2
									name : "client",
									data : "client",
									title : "客户端",
									orderable : false
								}, {// 第3
									name : "name",
									data : "name",
									title : "名称",
									orderable : false
								}, {// 第4
									name : "updateMsg",
									data : "updateMsg",
									title : "更新消息",
									orderable : false
								},{// 第5
									name : "updateUrl",
									data : "updateUrl",
									title : "更新路径",
									orderable : false
								}, {// 第6
									name : "forceVersion",
									data : "forceVersion",
									title : "强制更新版本",
									orderable : false
								}, {// 第7
									name : "latestVersion",
									data : "latestVersion",
									title : "最新版本",
									orderable : false
								}, {// 第8
									name : "lastUpdateTime",
									data : "lastUpdateTime",
									title : "最后更新时间",
									orderable : false
								}, {// 第9
									name : "realName",
									data : "realName",
									title : "操作者",
									orderable : false
								}, {// 第10
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
								},{// 设置列统一的值，
									targets : 7,
									render: function(data, type, row, meta) {
										if(data != null){
							        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
							        }
								},{// 设置列统一的值，
									targets : 9,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="edit(\'修改版本\',\'appConfig/edit?id='
												+ row.id
												+ '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none">修改</a>';
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
		
		return params;
	}

});