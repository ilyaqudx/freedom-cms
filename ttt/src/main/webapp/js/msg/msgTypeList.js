/** ***************添加计划名*********************** */
function add(title, url, w, h) {
	layer_show(title, url, w, h);
}
/** ***************计划名编辑********************** */
function edit(title, url, w, h) {
	layer_show(title, url, w, h);
}
/****************导出日志表******************************/
function del(obj, id) {
	layer.confirm('删除之前先修改和此相关的消息记录，确认要删除吗？', function(index) {
		$.post("msgType/del", {
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
	var t = $('.table')
			.dataTable(
					{// 得到表格
						colReorder : false,// 是否允许你列拖动
						serverSide : true,// 是否需要服务器支持
						bFilter : false,// 是否过滤数据
						"columns" : [// 具体的列
								 {// 第1列，ID
									name : "type",
									data : "type",
									title : "编号",
									orderable : true
								}, {// 第2
									name : "name",
									data : "name",
									title : "名称",
									orderable : false
								}, {// 第3
									name : "groupName",
									data : "groupName",
									title : "组名",
									orderable : false
								}, {// 第4
									data : null,
									title : "基本操作",
									orderable : false
								} ],
						"aaSorting" : [ 0, "asc" ],// 默认第几个排序，ID列升序
						"bStateSave" : true,
						"aoColumnDefs" : [

								{
									sDefaultContent : '',
									aTargets : [ '_all' ]
								},{
									targets : 3,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="edit(\'测评编辑\',\'msgType/edit?id='
												+ row.id
												+ '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="del(this,'
												+ row.id
												+ ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
		var type = $("#type").val();
		if(type != null && type != ""){
			params['type'] = type;
		}
		return params;
	}

});