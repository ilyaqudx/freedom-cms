var t;

$(function(){
	t = $('.table').dataTable({
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
	  	"columns": [
	  			{
	  				data: null,
	        		title: "<input type='checkbox' name='' value=''/>",
	        		orderable: false
	  			},
	            {
	  				name: "id",
	            	data: "id",
	                title: "ID",
	                orderable: true
	            },
	            { 
	            	name: "name",
	            	data: "name",
	                title: "角色名",
	                orderable: false
	            },
	            { 
	            	name: "createTime",
	            	data: "createTime",
	                title: "创建时间",
	                orderable: false},
	            {
	                name: "updateTime",
	                data: "updateTime",
	                title: "更新时间",
	                orderable: false
	            },
	            { 
	            	name: "description",
	            	data: "description",
	                title: "描述",
	                orderable: false
	            },
	            { 
	            	data: null,
	                title: "操作",
	                orderable: false
	            }
	        ],
		"aaSorting": [[ 1, "asc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
//		  {"orderable":true,"aTargets":[0,1,3,4]},// 制定列不参与排序
		  {
		    sDefaultContent: '',
		    aTargets: [ '_all' ]
		  },
		  {
	        //   指定第一列，从0开始，0表示第一列，1表示第二列……
	        targets: 0,
	        render: function(data, type, row, meta) {
	            return '<input type="checkbox" name="" value="' + row.id + '" />';
	        }
	      },
	      {
	        targets: 3,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
	        }
	      },
	      {
	        targets: 4,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
	        }
	      },
	      {
	        targets: 6,
	        render: function(data, type, row, meta) {
	            return '<a title="编辑" href="javascript:;" onclick="admin_role_edit(\'角色编辑\',\'role/edit?id='+row.id+'\',\'4\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_role_del(this,'+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
	        }
	      }
		],
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
//		var realName = $('#_realName').val();
//		if(realName != null && realName != ''){
//			params['realName']=realName;
//		}
		return params;
	}
});

/*管理员-角色-添加*/
function admin_role_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function admin_role_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-删除*/
function admin_role_del(obj,rowId){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'role/delete',
			data:'id='+rowId,
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