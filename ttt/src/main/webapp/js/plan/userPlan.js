/*****************商品添加和修改************************/
function userPlan_edit(title,url,w,h){
	layer_show(title,url,w,h);
}

/*********************删除*****************************/
function userPlan_del(obj,id){	
	layer.confirm('确认要删除吗？',function(index){
		$.post("userPlan/del",{'id':id}, function(data){  				
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
		           
		           {//1
		        	   name:"id",
		        	   data:"id",
		        	   title:"ID",
		        	   orderable:true
		           },
		           {//2
		        	   name:"phone",
		        	   data:"phone",
		        	   title:"账号",
		        	   orderable:false
		           },
		           {//3
		        	   name:"userName",
		        	   data:"userName",
		        	   title:"用户名",
		        	   orderable:false
		           },
		           {//4
		        	   name:"freeFinishNum",
		        	   data:"freeFinishNum",
		        	   title:"已完成计划",
		        	   orderable:false
		           },
		           {//5
		        	   name:"goldFinishInfo",
		        	   data:"goldFinishInfo",
		        	   title:"专项计划",
		        	   orderable:false
		           },
		           {//6
		        	   name:"name",
		        	   data:"name",
		        	   title:"当前计划",
		        	   orderable:false
		           },
		           {//7，
		        	   name:"needCycle",
		        	   data:"needCycle",
		        	   title:"所需天数",
		        	   orderable:false
		           },
		           {//8
		        	   name:"dailySequnce",
		        	   data:"dailySequnce",
		        	   title:"完成天数",
		        	   orderable:false
		           },
		           {//9
		        	   name:"abilityNames",
		        	   data:"abilityNames",
		        	   title:"能力",
		        	   orderable:false
		           },
		           {//10
		        	   name:"gameNames",
		        	   data:"gameNames",
		        	   title:"训练游戏",
		        	   orderable:false
		           },
		           {//11
		        	   name:"evaluationFinish",
		        	   data:"evaluationFinish",
		        	   title:"完成测评",
		        	   orderable:false
		           },
		           {//12
		        	   name:"todayFinish",
		        	   data:"todayFinish",
		        	   title:"今日完成",
		        	   orderable:false
		           },
		           {//13
		        	   name:"createTime",
		        	   data:"createTime",
		        	   title:"开始日期",
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
		                           {//设置列统一的值，
		                        	   targets:10,
		                        	   render: function(data,type,row,meta){
		                        		   var finish ="";
		                        		   if(row.trainingFinish == 1){
		                        			   finish ="是";
		                        		   }else{
		                        			   finish = "否";
		                        		   }
		                        		   return ''+finish+'';
		                        	   }
		                           
		                           },
		                           {//设置列统一的值，
		                        	   targets:11,
		                        	   render: function(data,type,row,meta){
		                        		   var finish ="";
		                        			   if(row.evaluationFinish == 1){
		                        				   finish ="是";
		                        			   }else{
		                        				   finish = "否";
		                        			   }
		                        		   return ''+finish+'';
		                        	   }
		                           
		                           },
		                           {
					        	        targets: 12,
					        	        render: function(data, type, row, meta) {
					        	        	return new Date(data).format('yyyy-MM-dd');
					        	        }
					        	    },
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
		var myreg = /^1[34578]\d{9}$/; 
		if(!myreg.test($("#phone").val())&& $("#phone").val().trim()!="") 
		{ 
			layer.msg('请输入有效的手机号码！'); 
		    return; 
		} 
		t.fnDraw();
	});
	
	function getParams(){
		var params = {};
		debugger;
		// 用户昵称
		var name = $("#name").val();
		if(name != null && name != ""){
			params['name'] = name;
		}
		// 用户电话
		var  phone = $("#phone").val();
		if(phone != null && phone != ""){
			params['phone'] = phone;
		}
		// 班级
		var classes = $("#classes").val();
		if(classes != null && classes != 0){
			params['classes'] = classes;
		}
		// 年级
		var grades = $("#grades").val();
		if(grades != null && grades != 0){
			params['grades'] = grades;
		}
		// 学校
		var schools = $("#schools").val();
		if(schools != null && schools != 0){
			params['schools'] = schools;
		}
		// 开始时间的最小值
		var startTime = $("#startTime").val();
		if(startTime != null && startTime != ""){
			params['startTime'] = startTime;
		}
		// 开始时间的最小值
		var endTime = $("#endTime").val();
		if(endTime != null && endTime != ""){
			params['endTime'] = endTime + ' 23:59:59';
		}
		return params;
	}
	
	
});