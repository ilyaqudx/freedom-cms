/*****************添加计划名************************/
function evaluation_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*****************计划名编辑***********************/
function evaluation_edit(title,url,w,h){
	layer_show(title,url,w,h);
}

function evaluation_del(obj,id){	
	layer.confirm('确认要删除吗？',function(index){
		$.post("evaluation/del",{'id':id}, function(data){
			var jsonobj=jQuery.parseJSON(data);
   				if(jsonobj.msg==1){
   					location.reload();
   					layer.msg("已删除",{icon:1,time:1000});
   				}
   				else{
   					alert("删除不了");
   					location.href="plan/evaluation";
   				}   			
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
		           {//第一列，复选框
		        	   data:null,
		        	   title:"<input type='checkbox' name='' value=''/>",
		        	   orderable:false
		           },
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
		           {//第四列，类型
		        	   name:"typeName",
		        	   data:"typeName",
		        	   title:"类型",
		        	   orderable:false
		           },
		           {//第五列列，试卷
		        	   name:"examName",
		        	   data:"examName",
		        	   title:"试卷",
		        	   orderable:false
		           },
		           {//第六列，操作
		        	   data:null,
		        	   title:"操作",
		        	   orderable:false
		           }
		           ],
		           "aaSorting":[1,"asc"],//默认第几个排序，ID列升序
		           "bStateSave":true,
		           "aoColumnDefs":[
		                           {//设置列统一的值，
		                        	   targets:0,
		                        	   render: function(data,type,row,meta){
		                        		   return '<input type="checkbox" name="" value="'+row.id+'" />';
		                        	   }
		                        	   
		                           },
		                           
		                           {
		                        	   targets:5,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="evaluation_edit(\'测评编辑\',\'evaluation/add?id='+row.id+'\',\'800\',\'500\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="evaluation_del(this,'+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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

		return params;
	}
	
	
});