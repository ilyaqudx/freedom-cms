/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function plan_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-删除*/
function plan_del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'plan/delete',
			data:'id='+id,
			dataType:'json',
			success:function(data){
				if(data.code > 0){
					layer.msg(data.msg,{icon:1,time:1000});
				}else{
					layer.msg('已删除!',{icon:1,time:1000},function(){
						window.location.reload();
					});
				}
			}
		});
	});
}
/*管理员-编辑*/
function plan_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

$(function(){
	var t = $('.table').dataTable({
//		"draw": 1,
//	  	"recordsTotal": page.count,
//	  	"recordsFiltered": page.pageSize,
//	  	"data": page.data,
		//是否允许列拖动
		colReorder: false,
		//服务器支持，即从服务器获取数据
		serverSide: true,
		//是否过滤数据
		bFilter: false,
		/*ajax: {
	        url: 'admin/list',
	        type: 'POST'
	    },*/
	  	"columns": [{
	  				data: null,
	        		title: "<input type='checkbox' name='' value=''/>",
	        		orderable: false
	  			},{
	            	data: "id",
	                title: "ID",
	                orderable: true
	            },{
	            	data:'name',
	            	title:'计划名',
	            	orderable:false
	            },{ 
	            	data: "templateName",
	                title: "类型",
	                orderable: false
	            },{ 
	                data: "sequence",
	                title: "排序",
	                orderable: true
	            },{ 
	            	data: "cycle",
	                title: "训练周期",
	                orderable: false
	            },{
	                data: "freeDays",
	                title: "免费天数",
	                orderable: false
	            },{
	            	data: "originalGold",
	                title: "原价",
	                orderable: false
	            },{
	            	data: "gold",
	                title: "现价",
	                orderable: false 
	            },{
	            	data: "trainingPassStar",
	                title: "通关最低星星数",
	                orderable: false 
	            },{
	            	data: "trainingAbilityCount",
	            	title: "训练能力数",
	            	orderable: false 
	            },{
	            	data: "evaluationAbilityCount",
	            	title: "测评能力数",
	            	orderable: false 
	            },{
	            	data: null,
	                title: "操作",
	                orderable: false
	            }
	        ],
		"aaSorting": [[ 1, "asc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [{
			sDefaultContent: '',
			aTargets: [ '_all' ]
		},{
			targets: 0,
			render: function(data, type, row, meta) {
	            return '<input type="checkbox" name="" value="' + row.id + '" />';
	        }
		},{
			targets:12,
			render: function(data, type, row, meta) {
				return '<a title="编辑" href="javascript:;" onclick="plan_edit(\'计划编辑\',\'plan/edit?id='+row.id+'\',\'1\',\'800\',\'600\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a><a title="删除" href="javascript:;" onclick="plan_del('+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
			}
		}],
		//重写从服务器获取数据的方法
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
		//向服务器发送额外的参数
		/*fnServerParams: function ( aoData ) {
			aoData['params']={"name": "more_data", "value": "my_value"};
        }*/
	});
	
	$('#search').on('click',function(){
		t.fnDraw();
	});
	
	function getParams(){
		var params = {};
		var realName = $('#_realName').val();
		if(realName != null && realName != ''){
			params['realName']=realName;
		}
		return params;
	}
});