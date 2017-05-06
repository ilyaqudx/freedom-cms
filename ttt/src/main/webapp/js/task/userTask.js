/*****************商品添加和修改************************/
function userTask_edit(title,url,w,h){
	layer_show(title,url,w,h);
}

/*********************删除*****************************/
function userTask_del(obj,id){	
	layer.confirm('确认要删除吗？',function(index){
		$.post("userTask/del",{'id':id}, function(data){  				
   					layer.msg("已删除",{icon:1,time:1000});
   					location.reload();  				  			
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
		        	  
		        	   data:null,
		        	   title:"<input type='checkbox' name='' />",
		        	   orderable:true
		           },
		           {//第二列，ID
		        	   name:"id",
		        	   data:"id",
		        	   title:"ID",
		        	   orderable:true
		           },
		           {//第三列，
		        	   name:"userId",
		        	   data:"userId",
		        	   title:"用户ID",
		        	   orderable:false
		           },
		           {//第4列，
		        	   name:"name",
		        	   data:"name",
		        	   title:"任务名",
		        	   orderable:false
		           },
		           {//第5列，
		        	   name:"gold",
		        	   data:"gold",
		        	   title:"金币",
		        	   orderable:false
		           },
		           {//第6列，
		        	   name:"statusName",
		        	   data:"statusName",
		        	   title:"状态",
		        	   orderable:false
		           },
		           {//第7列，
		        	   name:"createTime",
		        	   data:"createTime",
		        	   title:"创建时间",
		        	   orderable:false
		           },
		           {//第8列，
		        	   name:"finishTime",
		        	   data:"finishTime",
		        	   title:"完成时间",
		        	   orderable:false
		           },
		           {//第9列，操作		 	   
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
					                {// 设置列统一的值，
										targets : 0,
										render : function(data, type, row, meta) {
											return '<input type="checkbox" name="" value="'+ row.id + '" />';
										}

									},
		                           
		                           {
					        	        targets: 6,
					        	        render: function(data, type, row, meta) {
					        	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
					        	        }
					        	    },
					        	    {
					        	    	targets: 7,
					        	    	render: function(data, type, row, meta) {
					        	    		if(data !=null)
					        	    		return new Date(data).format('yyyy-MM-dd hh:mm:ss');
					        	    	}
					        	    },
		                          
		                           {
		                        	   targets:8,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="userTask_edit(\'用户任务编辑\',\'userTask/edit?id='+row.id+'\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="userTask_del(this,'+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
		debugger;
		// 任务名称
		var name = $("#name").val();
		if(name != null && name != ""){
			params['name'] = name;
		}
		// 开始时间的最小值
		var logmin = $("#logmin").val();
		if(logmin != null && logmin != ""){
			params['logmin'] = logmin;
		}
		// 开始时间的最大值
		var logmax = $("#logmax").val();
		if(logmax != null && logmax != ""){
			params['logmax'] = logmax;
		}
		return params;
	}
	
	
});