/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,w,h){
	layer_show(title,url,w,h);	
}
/*管理员-删除*/
function admin_del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'admin/delete',
			data:'id='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已删除!',{icon:1,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg('服务器内部错误！');
				}
			}
		});
	});
}
/*管理员-编辑*/
function admin_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type:'POST',
			url:'admin/stop',
			data:'id='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已停用!',{icon: 5,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg('服务器内部错误！');
				}
			}
		});
	});
}

/*管理员-启用*/
function admin_start(id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type:'POST',
			url:'admin/start',
			data:'id='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已启用!', {icon: 6,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg('服务器内部错误！');
				}
			}
		});
	});
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
	            	data: "name",
	                title: "账号",
	                orderable: false
	            },{
	                data: "realName",
	                title: "真实姓名",
	                orderable: false
	            },{
	            	data: "phone",
	                title: "手机",
	                orderable: false 
	            },{
	            	name: "createTime",
	            	data: "createTime",
	                title: "创建时间",
	                orderable: false
	            },{
	            	data: "updateTime",
	                title: "更新时间",
	                orderable: false
	            },{
	            	data: "description",
	                title: "描述",
	                orderable: false
	            },{
	            	data: "status",
	                title: "状态",
	                orderable: false 
	            },{ 
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
	      },{
	        targets: 5,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
	        }
	      },
	      {
	        targets: 6,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
	        }
	      },{
		        targets: 8,
		        render: function(data, type, row, meta) {
		        	return data==1?'<span class="label label-success radius">已启用</span>':'<span class="label radius">已停用</span>';
		        }
		  },{
	        targets: 9,
	        render: function(data, type, row, meta) {
	        	var html = '';
	        	if(row.status == 1){
	        		html += '<a style="text-decoration:none" authority="/admin/stop" onClick="admin_stop('+row.id+')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>';
	        	}else{
	        		html += '<a style="text-decoration:none" authority="/admin/start" onClick="admin_start('+row.id+')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe615;</i></a>';
	        	}
	            html += ' <a title="编辑" href="javascript:;" authority="/admin/edit" onclick="admin_edit(\'管理员编辑\',\'admin/edit?id='+row.id+'\',\'800\',\'600\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
	            html += ' <a style="text-decoration:none" authority="/admin/editPass" class="ml-5" onClick="change_password(\'修改密码\',\'admin/editPass?id='+row.id+'\',\'600\',\'270\')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a>';
	            html += ' <a title="删除" href="javascript:;" authority="/admin/delete" onclick="admin_del('+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
	            return html;
	        }
	      }
		],
		//重写从服务器获取数据的方法
		fnServerData: function (sSource, aoData, fnCallback) {
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
			$.ajax({
				"dataType": 'json',
				"type": "POST",
				"url": sSource,
				"data": aoData,
				"success": fnCallback
			});
		},
		initComplete: function(settings, json){
			var auth = ['/admin/stop','/admin/start','/admin/edit','/admin/editPass','/admin/delete','/admin/add'];
			context.authority(auth);
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