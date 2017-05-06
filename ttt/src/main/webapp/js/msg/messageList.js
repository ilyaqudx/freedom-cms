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
	layer.confirm('消息删除须谨慎，确认要删除吗？', function(index) {
		$.post("message/del", {
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
									name : "id",
									data : "id",
									title : "编号",
									orderable : true
								}, {// 第2
									name : "typeName",
									data : "typeName",
									title : "类型",
									orderable : false
								}, {// 第3
									name : "attachment",
									data : "attachment",
									title : "栗子数",
									orderable : false
								}, {// 第4
									name : "messageTypeName",
									data : "messageTypeName",
									title : "消息类型",
									orderable : false
								},{// 第5
									name : "title",
									data : "title",
									title : "标题",
									orderable : false
								}, {// 第6
									name : "content",
									data : "content",
									title : "APP内容",
									orderable : false
								}, {// 第6
									name : "wxContent",
									data : "wxContent",
									title : "微信内容",
									orderable : false
								}, {// 第7
									name : "statusName",
									data : "statusName",
									title : "状态",
									orderable : false
								}, {// 第8
									name : "devicesName",
									data : "devicesName",
									title : "推送设备",
									orderable : false
								}, {// 第9
									name : "startTime",
									data : "startTime",
									title : "有效开始时间",
									orderable : false
								}, {// 第10
									name : "endTime",
									data : "endTime",
									title : "有效结束时间",
									orderable : false
								}, {// 第11
									name : "createTime",
									data : "createTime",
									title : "创建时间",
									orderable : false
								}, {// 第12
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
								},{// 设置列统一的值，
									targets : 9,
									render: function(data, type, row, meta) {
										if(data != null){
							        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
							        }
								},{// 设置列统一的值，
									targets : 10,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
							        }
								},{// 设置列统一的值，
									targets : 11,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
									}
								},{
									targets : 12,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="edit(\'测评编辑\',\'message/edit?id='
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
		var id = $("#id").val();
		if(id != null && id != ""){
			params['id'] = id;
		}
		var datemin = $("#datemin").val();
		if(datemin != null && datemin != ""){
			params['datemin'] = datemin;
		}
		var datemax = $("#datemax").val();
		if(datemax != null && datemax != ""){
			params['datemax'] = datemax + ' 23:59:59';
		}
		return params;
	}

});