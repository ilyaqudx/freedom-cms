$(function(){
	var t = $('.table').dataTable({
		//是否允许列拖动
		colReorder: false,
		//服务器支持，即从服务器获取数据
		serverSide: true,
		//是否过滤数据
		bFilter: false,
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
                title: "姓名",
                orderable: false
	  		},{
                data: "gender",
                title: "性别",
                orderable: false
	  		},{
            	data: "phone",
                title: "手机",
                orderable: false 
	  		},{
            	data: "type",
                title: "成员类型",
                orderable: false
	  		},{
                data: "createTime",
                title: "创建时间",
                orderable: true
	  		},{
            	data: "gold",
                title: "金币",
                orderable: false
	  		},{
            	data: "status",
                title: "状态",
                orderable: false
	  		},{
            	data: null,
                title: "操作",
                orderable: false
	  		}],
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
	        targets: 3,
	        render: function(data, type, row, meta) {
	        	return data==0 ? '未知' : data==1 ? '男' : '女';
	        }
		},{
	        targets: 5,
	        render: function(data, type, row, meta) {
	        	return data==1?'会员':'游客';
	        }
	    },{
	        targets: 6,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
	        }
	    },{
	        targets: 8,
	        render: function(data, type, row, meta) {
	        	return data==0?'<span class="label label-success radius">已启用</span>':'<span class="label radius">已停用</span>';
	        }
	    },{
	        targets: 9,
	        render: function(data, type, row, meta) {
	        	var html = '';
	        	if(row.status == 0){
	        		html += '<a style="text-decoration:none" authority="/user/stop" onClick="member_stop('+row.id+')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>';
	        	}else{
	        		html += '<a style="text-decoration:none" authority="/user/start" onClick="member_start('+row.id+')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe615;</i></a>';
	        	}
	            html += ' <a title="编辑" href="javascript:;" authority="/user/edit" onclick="member_edit(\'编辑\',\'member-add.html\',\'4\',\'\',\'510\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
	            html += ' <a style="text-decoration:none" authority="/user/updatePass" class="ml-5" onClick="change_password(\'修改密码\','+row.id+',\'600\',\'270\')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a>';
	            html += ' <a title="删除" href="javascript:;" authority="/user/delete" onclick="member_del('+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
	            return html;
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
		var name = $('#name').val();
		if(name != null && name != ''){
			params['name']=name;
		}
		var phone = $('#phone').val();
		if(phone != null && phone != ''){
			params['phone']=phone;
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
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type:'POST',
			url:'user/stop',
			data:'userId='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已停用!',{icon: 5,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg(data.msg);
				}
			}
		});
	});
}

/*用户-启用*/
function member_start(id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type:'POST',
			url:'user/start',
			data:'userId='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已启用!',{icon: 6,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg(data.msg);
				}
			}
		});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,id,w,h){
	layer_show(title,'user/updatePass?userId='+id,w,h);	
}
/*用户-删除*/
function member_del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'user/delete',
			data:'userId='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
					layer.msg('已删除!',{icon:1,time:1000},function(){
						window.location.reload();
					});
				}else{
					layer.msg(data.msg);
				}
			}
		});
	});
}

/*用户-发送消息*/
function sendMsg(){
	var checkBoxs = $("table tbody input:checkbox:checked");
	var length = checkBoxs.length;
	if(length > 0){
		//得到用户们的id
		var ids = '';
		for(var i=0; i<length; i++){
			ids += checkBoxs[i].value + ',';
		}
		layer_show('发送消息','user/sendMsg?userIds='+ids,800,500);
	}else{
		layer.msg('未选择用户！');
	}
}