/*****************商品添加和修改************************/
function product_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*********************删除*****************************/
function product_del(obj,id){	
	layer.confirm('确认要删除吗？',function(index){
		$.post("product/del",{'id':id}, function(data){  				
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
		           {//第三列，类型
		        	   name:"typeName",
		        	   data:"typeName",
		        	   title:"类型",
		        	   orderable:false
		           },
		           {//第四列，商品名）
		        	   name:"name",
		        	   data:"name",
		        	   title:"商品名",
		        	   orderable:false
		           },
		           {//第五列，价格
		        	   name:"price",
		        	   data:"price",
		        	   title:"价格",
		        	   orderable:false
		           },
		           {//第十二列，原价
		        	   name:"originalPrice",
		        	   data:"originalPrice",
		        	   title:"原价",
		        	   orderable:false
		           },
		           {//第六列，IOS价格
		        	   name:"iosPrice",
		        	   data:"iosPrice",
		        	   title:"ios价格",
		        	   orderable:false
		           },
		         
		           {//第十三列，IOS原价
		        	   name:"iosOriginalPrice",
		        	   data:"iosOriginalPrice",
		        	   title:"ios原价",
		        	   orderable:false
		           },
		           {//第七列，数量
		        	   name:"count",
		        	   data:"count",
		        	   title:"数量",
		        	   orderable:false
		           },
		           {//第八列，支付代码
		        	   name:"payCode",
		        	   data:"payCode",
		        	   title:"支付代码（iOS）",
		        	   orderable:false
		           },
		           {//第九列，状态
		        	   name:"statusName",
		        	   data:"statusName",
		        	   title:"状态",
		        	   orderable:false
		           },
		           {//第十列，描述
		        	   name:"description",
		        	   data:"description",
		        	   title:"描述",
		        	   orderable:false
		           },
		           {//第十一列，产品标识
		        	   name:"codeName",
		        	   data:"codeName",
		        	   title:"产品标识",
		        	   orderable:false
		           },
		           
		           {//第十四列，操作		 	   
		        	   data:null,
		        	   title:"操作",
		        	   orderable:false
		           }	           
		           ],
		           "aaSorting":[1,"asc"],//默认第几个排序，ID列升序
		           "bStateSave":true,
		           "aoColumnDefs":[
		                           {
					                   sDefaultContent: '', 
						               aTargets: [ '_all' ] 
					                },
		                           {//设置列统一的值，
		                        	   targets:0,
		                        	   render: function(data,type,row,meta){
		                        		   return '<input type="checkbox" name="" value="'+row.id+'" />';
		                        	   }
		                        	   
		                           },
		                          
		                           {
		                        	   targets:13,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="product_add(\'商品编辑\',\'product/add?id='+row.id+'\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="product_del(this,'+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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