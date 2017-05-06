/*****************修改************************/
function order_edit(title,url,w,h){
	layer_show(title,url,w,h);
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
		        	   name:"orderNo",
		        	   data:"orderNo",
		        	   title:"订单号",
		        	   orderable:false
		           },
		           {//3，用户ID
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
		           {//4
		        	   name:"accountId",
		        	   data:"accountId",
		        	   title:"账户ID",
		        	   orderable:false
		           },
		           {//4
		        	   name:"phone",
		        	   data:"phone",
		        	   title:"电话",
		        	   orderable:false
		           },
		           {//5
		        	   name:"productName",
		        	   data:"productName",
		        	   title:"商品名",
		        	   orderable:false
		           },
		           {//6，数量
		        	   name:"num",
		        	   data:"num",
		        	   title:"数量",
		        	   orderable:false
		           },
		           {//7，支付代码
		        	   name:"amount",
		        	   data:"amount",
		        	   title:"金额",
		        	   orderable:false
		           },
		           {//8，状态
		        	   name:"statusName",
		        	   data:"statusName",
		        	   title:"状态",
		        	   orderable:false
		           },
		           {//9
		        	   name:"clientName",
		        	   data:"clientName",
		        	   title:"客户端类型",
		        	   orderable:false
		           },
		           {//10，
		        	   name:"payTypeName",
		        	   data:"payTypeName",
		        	   title:"支付类型",
		        	   orderable:false
		           },
		           {//11，
		        	   name:"createTime",
		        	   data:"createTime",
		        	   title:"创建时间",
		        	   orderable:false
		           },
		           {//12，
		        	   name:"updateTime",
		        	   data:"updateTime",
		        	   title:"处理时间",
		        	   orderable:false
		           },
		           {//13，操作		 	   
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
					        	        targets: 12,
					        	        render: function(data, type, row, meta) {
					        	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
					        	        }
					        	      },
					        	      {
					        	        targets: 13,
					        	        render: function(data, type, row, meta) {
					        	        	if(data !=null){
					        	        		return new Date(data).format('yyyy-MM-dd hh:mm:ss');
					        	        	}
					        	        	
					        	        	
					        	        }
					        	      },
		                          
		                           {
		                        	   targets:14,
		                        	   render:function(data,type,row,meta){
		                        		   return '<a title="编辑" href="javascript:;" onclick="order_edit(\'商品订单编辑\',\'order/edit?id='+row.id+'\',\'800\',\'800\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> ';
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
		var status = $("#status").val();
		if(status != null && status != ''){
			params['status'] = status;
		}
		var phone = $("#phone").val();
		if(phone != null && phone != ''){
			params['phone'] = phone;
		}
		var datemin = $('#datemin').val();
		if(datemin != null && datemin != ''){
			params['datemin']=datemin;
		}
		var datemax = $('#datemax').val();
		if(datemax != null && datemax != ''){
			params['datemax']=datemax + ' 23:59:59';
		}
		return params;
	}
	
	
});