/*****************修改************************/
function prop_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*********************表格数据显示**********************/
$(function(){
	var t=$('.table').dataTable({//得到表格
		colReorder:false,//是否允许你列拖动
		serverSide:true,//是否需要服务器支持
		bFilter:false,//是否过滤数据
		"columns":[//具体的列			     
		           {//2，订单号
		        	   name:"userId",
		        	   data:"userId",
		        	   title:"用户ID",
		        	   orderable:false
		           },
		           {//3，用户ID
		        	   name:"userName",
		        	   data:"userName",
		        	   title:"用户名",
		        	   orderable:false
		           },
		           {//4，用户ID
		        	   name:"propName",
		        	   data:"propName",
		        	   title:"道具名",
		        	   orderable:false
		           },
		           {//5
		        	   name:"count",
		        	   data:"count",
		        	   title:"数量",
		        	   orderable:false
		           },
		           {//8，操作		 	   
		        	   data:null,
		        	   title:"操作",
		        	   orderable:false
		           }	           
		           ],
		           "aaSorting":[0,"asc"],//默认第几个排序，ID列升序
		           "bStateSave":true,
		           "aoColumnDefs":[
		                         
		                        	   {
						                   sDefaultContent: '', 
							               aTargets: [ '_all' ] 
						                },
		                           {
		                        	   targets:4,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="prop_edit(\'道具编辑\',\'userProp/edit?userId='+row.userId+'&propId='+row.propId+'\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
		                        	   }
		                           }
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
		var userId = $("#userId").val();
		if(userId != null && userId != ""){
			params['userId'] = userId;
		}
		return params;
	}
	
	
});