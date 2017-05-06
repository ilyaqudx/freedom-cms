/** ***************试题编辑********************** */
function exercise_edit(id,novice){
	if(novice!=0){
		novice=0;
	}else if(novice==0){
		novice=1;
	}
	$.ajax({//将得到的试题添加到数据库
		type : 'POST',
		url : 'exercise/update',
		data : {'id':id,'novice':novice},
		dataType : 'json',
		success : function(data){
			if(data.code == 1){
				layer.msg(data.msg);
				//location.reload();
				document.getElementById("novice"+id).checked = false;
				return;
				
			}else{
				location.reload();
			}
			
		}
	});
	
};



/** *******************表格数据显示********************* */
$(function() {
	
	
	/** ***************全部更新*********************** */
	$("#selectExams").bind('change',function() {
		
		var id = $("#selectExams").children('option:selected').val();
		if (id != 0) {
			$.ajax({
				type : 'GET',
				url : context.evalClientUrl+'/exam/getExcercises',
				data : 'id=' + id,
				dataType : 'json',
				success : function(data) {
				    var m=data.excercises;
					for ( var i = 0; i < m.length; i++) {
						m[i].examId=id;
					}
					var excerciseJSON = JSON.stringify(m);
					$.ajax({//将得到的试题添加到数据库
						type : 'POST',
						url : 'exercise/add',
						data : {'excerciseJSON': excerciseJSON},
						dataType : 'json',
						success : function(data){
							layer.msg("已完成,请选择新手题");
							location.reload();
						}
					});
				}
			});
		}
	});

	var t = $('.table').dataTable(
					{// 得到表格
						colReorder : false,// 是否允许你列拖动
						serverSide : true,// 是否需要服务器支持
						bFilter : false,// 是否过滤数据
						"columns" : [// 具体的列
							    {// 第二列，ID
									name : "id",
									data : "id",
									title : "ID",
									orderable : true
								}, {// 第三列，名称
									name : "name",
									data : "name",
									title : "试题名称",
									orderable : false
								}, {// 第四列，类型
									name : "examName",
									data : "examName",
									title : "试卷名称",
									orderable : false
								}, {// 第四列，类型
									name : "abilityName",
									data : "abilityName",
									title : "对应能力",
									orderable : false
								},{// 第六列，操作
									data : null,
									title : "是否首发",
									orderable : false
								} ],
						"aaSorting" : [ 0, "asc" ],// 默认第几个排序，ID列升序
						"bStateSave" : true,
						"aoColumnDefs" : [
						                 
						        {
						            sDefaultContent: '', 
							        aTargets: [ '_all' ] 
						        },         
								{
									targets : 4,
									render : function(data, type, row, meta) {
										var checked = '';
										if(data.novice == 1){
											 checked = "checked = 'checked'";
										}
										return '<input type="checkbox" id="novice'+data.id+'" name="novice"' +checked + ' value="'+data.novice+'" onchange="exercise_edit('+data.id+','+data.novice+')"/>是' ;
										
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