/** ***************添加计划名*********************** */
function game_config(title, url, w, h) {
	layer_show(title, url, w, h);
}
/** ***************添加计划名*********************** */
function game_add(title, url, w, h) {
	layer_show(title, url, w, h);
}
/** ***************计划名编辑********************** */
function game_edit(title, url, w, h) {
	layer_show(title, url, w, h);
}
/****************导出日志表******************************/
function game_log(id){
	 window.location.href = "log/download?id=" + id;
}
function game_del(obj, id) {
	layer.confirm('游戏删除须谨慎，确认要删除吗？', function(index) {
		$.post("game/del", {
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

function uploadCallback(data) { 
    if (data.code == 0) { 
 	   layer.msg("上传成功！"); 	   
    }else{
 	   layer.msg("上传失败！" + data.msg); 
    }
    
    setTimeout(function(){
    	location.reload();
    }, 2000);    
}

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

/** *******************表格数据显示********************* */
$(function() {
	// 老游戏中，游戏编号最大的值
	var maxOldGameCode = 46;
	
	var t = $('.table')
			.dataTable(
					{// 得到表格
						colReorder : false,// 是否允许你列拖动
						serverSide : true,// 是否需要服务器支持
						bFilter : false,// 是否过滤数据
						"columns" : [// 具体的列
								 {// 1
									name : "code",
									data : "code",
									title : "编号",
									orderable : true
								}, {// 2
									name : "name",
									data : "name",
									title : "游戏名",
									orderable : false
								}, {// 3
									name : "abilityName",
									data : "abilityName",
									title : "对应能力",
									orderable : false
								},{// 4
									name : "icon",
									data : "icon",
									title : "图标",
									orderable : false
								}, {// 5，
									name : "version",
									data : "version",
									title : "版本",
									orderable : false
								}, {// 6
									name : "url",
									data : "url",
									title : "链接（高）",
									orderable : false
								}, {// 7
									name : "urlLow",
									data : "urlLow",
									title : "链接（低）",
									orderable : false
								}, {// 8
									name : "urlWide",
									data : "urlWide",
									title : "宽屏",
									orderable : false
								}, {// 9
									name : "cover",
									data : "cover",
									title : "封面",
									orderable : false
								}, {// 10
									name : "description",
									data : "description",
									title : "描述",
									orderable : false
								}, {// 11
									name : "statusName",
									data : "statusName",
									title : "状态",
									orderable : false
								}, {// 12
									name : "advancedName",
									data : "advancedName",
									title : "专项训练",
									orderable : false
								}, {// 13
									name : "bgAdapter",
									data : "bgAdapter",
									title : "背景适配图",
									orderable : false
								}, {// 14
									data : null,
									title : "关卡配置",
									orderable : false
								}, {// 15
									data : "hasRelation",
									title : "关联表",
									orderable : false
								}, {// 16
									data : null,
									title : "算分规则",
									orderable : false
								},{// 17
									data : null,
									title : "提交字段",
									orderable : false
								}, {// 18
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
								},
								{// 设置列统一的值，
									targets : 3,
									render : function(data, type, row, meta) {
										return '<img src="'
												+ row.icon
												+ '" width="50px" height="30px" />';
									}

								},
								{// 设置列统一的值，
									targets : 8,
									render : function(data, type, row, meta) {
										return '<img src="'
												+ row.cover
												+ '" width="50px" height="30px" />';
									}

								},
								{// 设置列统一的值，
									targets : 12,
									render : function(data, type, row, meta) {
										return '<img src="'
										+ row.bgAdapter
										+ '" width="50px" height="30px" />';
									}
								
								},

								{
									targets : 13,
									render : function(data, type, row, meta) {
										
										if (row.code > maxOldGameCode ) {
											return '<a  href="javascript:;" onclick="layer_show(\'关卡配置表\',\'game/stage/list?gameId='
											+ row.id
											+ '\',\'1712\',\'300\')" class="ml-5" style="text-decoration:none">关卡表</a>';
										} else {
											// old game config
											return '<a  href="javascript:;" onclick="game_config(\'关卡配置表\',\'h5GameConfig?id='
											+ row.id
											+ '\',\'1712\',\'500\')" class="ml-5" style="text-decoration:none">关卡表</a>';
										}
									}
								},
								{
									targets : 14,
									render : function(data, type, row, meta) {
										if (row.code > maxOldGameCode ) {
											if (row.hasRelation) {
												return '<a  href="javascript:;" onclick="layer_show(\'关联表\',\'game/relation/list?gameId='
													+ row.id
													+ '\',\'1712\',\'300\')" class="ml-5" style="text-decoration:none">关联表</a>';
											} else {
												return "";
											}
										}
									}
								},
								{
									targets : 15,
									render : function(data, type, row, meta) {
										if (row.code > maxOldGameCode ) {
											return '<a  href="javascript:;" onclick="layer_show(\'算分规则\',\'game/score/rule?gameId='
											+ row.id
											+ '\',\'800\',\'400\')" class="ml-5" style="text-decoration:none">规则</a>';
										}
									}
								},
								{
									targets : 16,
									render : function(data, type, row, meta) {
										
										if (row.code > maxOldGameCode ) {
											return '<a  href="javascript:;" onclick="layer_show(\'Play游戏后提交的字段\',\'game/playrecord/fields/page?gameId='
											+ row.id
											+ '\',\'800\',\'400\')" class="ml-5" style="text-decoration:none">字段</a>';
										}
									}
								},
								{
									targets : 17,
									render : function(data, type, row, meta) {
										return '<a title="编辑" href="javascript:;" onclick="game_edit(\'游戏基本配置\',\'game/edit?id='
												+ row.id
												+ '\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="game_del(this,'
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
		var code = $("#gameCode").val();
		if(code != null && code != ""){
			params['code'] = code;
		}
		return params;
	}

});