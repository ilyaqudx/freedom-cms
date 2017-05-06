
/********************更新试卷********************/
function updateExam(){
	layer.confirm('更新所有的试卷吗？',function(index){
		var spId = 280;
		$.post("evaluation/del",{'spId':spId}, function(data){
			var jsonobj=jQuery.parseJSON(data);
   				$.post("")		
   			});
	});
}

/*********************表格数据显示**********************/
$(function(){
	var t=$('.table').dataTable({//得到表格
		colReorder:false,//是否允许你列拖动
		serverSide:true,//是否需要服务器支持
		bFilter:false,//是否过滤数据
		"columns":[//具体的列
		   
		           {//第二列，ID
		        	   name:"id",
		        	   data:"id",
		        	   title:"ID",
		        	   orderable:true
		           },
		           {//第三列，名称
		        	   name:"name",
		        	   data:"name",
		        	   title:"测评名称",
		        	   orderable:false
		           },
		   
		           ],
		           "aaSorting":[1,"asc"],//默认第几个排序，ID列升序
		           "bStateSave":true,
		           "aoColumnDefs":[
		                     
		                           ],
		                           
		                           fnServerData: function ( sSource, aoData, fnCallback ) {
		                   			//加入额外的参数
		                   			aoData.push({
		                   				"name": "params", 
		                   				"value": getParams()
		                   			});
		                   			var postdata={};
		                   			var postSize = aoData.length;
		                   			for(var i=0; i<postSize; i++){
		                   				aoData[i].value = JSON.stringify(aoData[i].value);
		                   			}
		                   			$.ajax( {
		                   			"dataType": 'json',
		                   			"type": "POST",
		                   			"url": sSource,
		                   			"data": aoData,
		                   			"success": fnCallback
		                   			} );
		                   		}
	});
	
	
	$('#search').on('click',function(){
		t.fnDraw();
	});
	
	function getParams(){
		var params = {};

		return params;
	}
	
	
});