/*****************修改************************/
function prop_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*****************修改************************/
function prop_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
function prop_del(obj, id) {
	layer.confirm('道具删除须谨慎，确认要删除吗？', function(index) {
		$.post("prop/del", {
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
/*********************表格数据显示**********************/
$(function(){
	var t=$('.table').dataTable({//得到表格
		colReorder:false,//是否允许你列拖动
		serverSide:true,//是否需要服务器支持
		bFilter:false,//是否过滤数据
		"columns":[//具体的列			     
		           {//1，ID
		        	   name:"id",
		        	   data:"id",
		        	   title:"ID",
		        	   orderable:true
		           },
		           {//2，订单号
		        	   name:"typeName",
		        	   data:"typeName",
		        	   title:"类型",
		        	   orderable:false
		           },
		           {//3，用户ID
		        	   name:"name",
		        	   data:"name",
		        	   title:"道名称",
		        	   orderable:false
		           },
		           {//4，用户ID
		        	   name:"description",
		        	   data:"description",
		        	   title:"描述",
		        	   orderable:false
		           },
		           {//5
		        	   name:"image",
		        	   data:"image",
		        	   title:"图片",
		        	   orderable:false
		           },
		           {//5
		        	   name:"subName",
		        	   data:"subName",
		        	   title:"子类型",
		        	   orderable:false
		           },
		           {//6
		        	   name:"randomName",
		        	   data:"randomName",
		        	   title:"是否可随机获取",
		        	   orderable:false
		           },
		           {//7，数量
		        	   name:"petExp",
		        	   data:"petExp",
		        	   title:"增加宠物经验值",
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
					        	        targets: 4,
					        	        render: function(data, type, row, meta) {
					        	        	return '<img src="'+row.image+'" width="60" height="40"/>';
					        	        }
					        	      },
		                           {
		                        	   targets:8,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="prop_edit(\'道具编辑\',\'prop/edit?id='+row.id+'\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a><a title="删除" href="javascript:;" onclick="prop_del(this,'
											+ row.id
											+ ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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