/** ***************选择状态事件*********************** */
function select_status(id) {// 提交操作数据
	var param = {
			id:id
	};
	// 获取终端
	if(document.getElementById("enableApp"+id).checked == true){// 选择了APP
		param['enableApp'] = 1;
	}else{
		param['enableApp'] = 0;
	}
	if(document.getElementById("enableWx"+id).checked == true){
		param['enableWx'] = 1;
	}else{
		param['enableWx'] = 0;
	}
	// 获取状态
	if(document.getElementById("status"+id).checked == true){
		param['status'] = 1;
	}else{
		param['status'] = 0;
	}
	// 获取类型
	if(document.getElementById("enableApp"+id).checked == false && document.getElementById("enableWx"+id).checked == true){
		param['showType'] = 0;
	}else{
		var radios = document.getElementsByName("showType"+id);
		for (var i = 0; i < radios.length; i++) 
		{
			if( radios[i].checked == true){
				param['showType'] = radios[i].value;
			}
		}
		if(param['showType'] == null){
			param['showType'] = 0;
		}
	}
	// 没有选择终端是不能发布
	if(document.getElementById("enableApp"+id).checked == false && document.getElementById("enableWx"+id).checked == false){
	layer.msg("必须选择一个终端");
	document.getElementById("status"+id).checked = false;
	return;
	}
	if(param['enableApp'] == 1 && param['showType'] == 0){
		layer.msg("必须选择一种推送方式");
		document.getElementById("status"+id).checked = false;
		return;
	}
		// 传输数据
	$.ajax({
		type:'POST',
		url:'msgSetting/edit',
		data : 'param=' + JSON.stringify(param),
		dataType : 'json',
		success:function(data){
			layer.msg("修改成功");
		}
	});
	
}
/** ***************选择终端事件********************** */
function select_enable(id) {
	var radios = document.getElementsByName("showType"+id);
	// 选择了APP时  只选择了微信
	if(document.getElementById("enableApp"+id).checked == false && document.getElementById("enableWx"+id).checked == true){
		for (var i = 0; i < radios.length; i++) 
		{
		 radios[i].disabled = true;
		}
	}else{
		for (var i = 0; i < radios.length; i++) 
		{
		 radios[i].disabled = false;
		}
	}
	
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
					            	 name : "id",
					            	 data : "id",
					            	 title : "编号",
					            	 orderable : true
					             }, {// 第2
									name : "typeName",
									data : "typeName",
									title : "消息类型",
									orderable : false
								}, {// 第3
									data : null,
									title : "发布终端",
									orderable : false
								}, {// 第4
									data : null,
									title : "消息推送方式",
									orderable : false
								} ],
						"aaSorting" : [ 0, "asc" ],// 默认第几个排序，ID列升序
						"bStateSave" : true,
						"aoColumnDefs" : [

								{
									sDefaultContent : '',
									aTargets : [ '_all' ]
								},{// 设置列统一的值，
									targets : 1,
									render: function(data, type, row, meta) {
										var checked = '';
										if(row.status == 1){
										 checked = 'checked = "checked"';
										}
							        	 return '<input id="status'+row.id+'" type="checkbox" '+checked+' value="'+row.messageTypeId+'" onchange="select_status('+row.id+')">'+row.typeName+'';
										
							        }
								},{// 设置列统一的值，
									targets : 2,
									render: function(data, type, row, meta) {
										var checked1 = '';
										var checked2 = '';
										if(row.enableApp == 1){
										 checked1 = 'checked = "checked"';
										}
										if(row.enableWx == 1){
											 checked2 = 'checked = "checked"';
										}
										return '<input type="checkbox" name="enable"'+checked1+' onchange="select_status('+row.id+')" id="enableApp'+row.id+'" value="1">APP <input type="checkbox" name="enable" '+checked2+' onchange="select_status('+row.id+')" id="enableWx'+row.id+'" value="2">微信';
							        }
								},{// 设置列统一的值，
									targets : 3,
									render: function(data, type, row, meta) {
										var disabled ='';
										var checked1 = '';
										var checked2 = '';
										var checked3 = '';
										if(row.showType == 1){
											checked1 = 'checked = "checked"';
										}else if(row.showType == 2){
											checked2 = 'checked = "checked"';
										}else if(row.showType == 3){
											checked3 = 'checked = "checked"';
										}
										if(row.enableWx == 1 && row.enableApp == 0){
											disabled = 'disabled = "disabled"';
										}
										return '<input name="showType'+row.id+'" type="radio"'+checked1+''+disabled+' value="1" onchange="select_status('+row.id+')">应用内弹窗提醒<input name="showType'+row.id+'" type="radio" '+checked2+''+disabled+' value="2" onchange="select_status('+row.id+')">应用内红点提醒<input name="showType'+row.id+'" type="radio" '+checked3+''+disabled+' value="3" onchange="select_status('+row.id+')">应用外标题栏推送';
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