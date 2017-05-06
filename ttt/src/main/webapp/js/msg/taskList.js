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
		$.post("task/del", {
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

var trueOrFalse = function(f){
	return f == -999 ? "不限" : (f == 0 ? "否" :"是");
}

var containsAndInsertStr = function(arr){
	var array = JSON.parse(arr);
	var list = [];
	for ( var int = 0; int < array.length; int++) {
		var v = array[int];
		var s = v == 1 ? 'iphone' : (v == 2 ? 'ipad' : (v == 3 ? 'android ipad' : (v == 4 ? 'android iphone' : null)));
		if(v)
			list.push(s);
	}
	return list;
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
									name : "name",
									data : "name",
									title : "名称",
									orderable : false
								}, {// 第3
									name : "title",
									data : "title",
									title : "标题",
									orderable : false
								}, {// 第4
									name : "content",
									data : "content",
									title : "内容",
									width : 100,
									orderable : false
								},{// 第5
									name : "eventType",
									data : "eventType",
									title : "事件",
									width : 50,
									orderable : false
								}, {// 第6
									name : "eventParams",
									data : "eventParams",
									title : "事件参数",
									width : 50,
									orderable : false
								}, {// 第6
									name : "userType",
									data : "userType",
									title : "用户类型",
									orderable : false
								}, {// 第7
									name : "vip",
									data : "vip",
									title : "是否VIP",
									orderable : false
								}, {// 第8
									name : "newAdd",
									data : "newAdd",
									title : "新增",
									orderable : false
								}, {// 第9
									name : "newAddDays",
									data : "newAddDays",
									title : "新增天数",
									orderable : false
								}, {// 第10
									name : "taskExecuteType",
									data : "taskExecuteType",
									title : "执行方式",
									orderable : false
								}, {// 第11
									name : "oneTimeTask",
									data : "oneTimeTask",
									title : "一次性任务",
									orderable : false
								}, {// 第12
									name : "taskExecuteFrequency",
									data : "taskExecuteFrequency",
									title : "执行频率",
									orderable : false
								}, {// 第13
									name : "taskFirstExecuteDate",
									data : "taskFirstExecuteDate",
									title : "首发日期",
									orderable : false
								}, {// 第14
									name : "taskExecuteTime",
									data : "taskExecuteTime",
									title : "执行时间段",
									orderable : false
								}, {// 第15
									name : "taskLastExecuteDate",
									data : "taskLastExecuteDate",
									title : "截止日期",
									orderable : false
								}, {// 第16
									name : "pushTime",
									data : "pushTime",
									title : "推送时间",
									orderable : false
								}, {// 第17
									name : "status",
									data : "status",
									title : "状态",
									orderable : false
								}, {// 第18
									name : "devices",
									data : "devices",
									title : "设备",
									orderable : false
								}, {// 第19
									name : "showType",
									data : "showType",
									title : "展现方式",
									orderable : false
								}, {// 第20
									name : "actionType",
									data : "actionType",
									title : "执行动作",
									orderable : false
								}, {// 第21
									name : "action",
									data : "action",
									title : "动作参数",
									orderable : false
								}, {// 第22
									name : "createTime",
									data : "createTime",
									title : "创建时间",
									orderable : false
								}, {// 第23
									name : "updateTime",
									data : "updateTime",
									title : "更新时间",
									orderable : false
								}, {// 第24
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
									targets : 13,
									render: function(data, type, row, meta) {
										if(data != null){
							        	 return new Date(data).format('yyyy-MM-dd');
										}
							        }
								},{// 设置列统一的值，
									targets : 14,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('hh:mm:ss');
										}
							        }
								},{// 设置列统一的值，
									targets : 15,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd');
										}
									}
								},{// 设置列统一的值，
									targets : 16,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
									}
								},
								{// 设置列统一的值，
									targets : 22,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
									}
								},
								{// 设置列统一的值，
									targets : 23,
									render: function(data, type, row, meta) {
										if(data != null){
								        	 return new Date(data).format('yyyy-MM-dd hh:mm');
										}
									}
								},{
									targets : 24,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="edit(\'测评编辑\',\'task/edit?id='
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
							debugger;
							var postdata = {};
							var postSize = aoData.length;
							for ( var i = 0; i < postSize; i++) {
								aoData[i].value = JSON.stringify(aoData[i].value);
							}
							$.ajax({
								"dataType" : 'json',
								"type" : "POST",
								"url" : sSource,
								"data" : aoData,
								"success" : function(data){
									console.debug(data);
									var list = data.data;
									for ( var int = 0; int < list.length; int++) {
										var task = list[int];
										task.newAdd   = trueOrFalse(task.newAdd);
										task.vip      = trueOrFalse(task.vip);
										task.userType = task.userType == 0 ? '游客' : task.userType == 1 ? '注册用户' : '不限';
										task.taskExecuteType = task.taskExecuteType == 0 ? '后台定时' : 
											(task.taskExecuteType == 1 ? '后台即时' : '程序事件触发');
										task.oneTimeTask = trueOrFalse(task.oneTimeTask);
										task.showType = "通知";
										if(task.actionType == 2){
											//指定页面
											task.action = task.action == 1 ? 'VIP页面' : (task.action == 4 ? '手机绑定页面' : '未知页面');
										}else if(task.actionType  < 2)
											task.action = '无';
										task.actionType = task.actionType == 0 ? "无动作" : 
											(task.actionType == 1 ? '打开app' : (task.actionType == 2 ? '跳转指定页面' : '打开URL'));
										task.devices = containsAndInsertStr(task.devices);
									}
									fnCallback(data);
								}
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