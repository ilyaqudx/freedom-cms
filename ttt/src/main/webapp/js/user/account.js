$(function(){
	var t = $('.table').dataTable({
		//是否允许列拖动
		colReorder: false,
		//服务器支持，即从服务器获取数据
		serverSide: true,
		//是否过滤数据
		bFilter: false,
	  	"columns": [{//1
		  		data: null,
		  		title: "<input type='checkbox' name='' value=''/>",
		  		orderable: false
	  		},{//2
	  			data: "id",
	  			title: "编号",
	  			orderable: true
	  		},{//3
	  			data: "phone",
                title: "手机号",
                orderable: false
	  		},{//4
                data: "name",
                title: "姓名",
                orderable: false
	  		},{//5
            	data: "typeName",
                title: "类型",
                orderable: false 
	  		},{//6
            	data: "createTime",
                title: "创建时间",
                orderable: false
	  		},{//7
                data: "members",
                title: "子成员数",
                orderable: true
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
	        targets: 5,
	        render: function(data, type, row, meta) {
	        	return new Date(data).format('yyyy-MM-dd hh:mm:ss');
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
		var phone = $('#phone').val();
		if(phone != null && phone != ''){
			params['phone']=phone;
		}
		var type = $('#selectType').val();
		if(type != 0 && type != null){
			params['type']=type;
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