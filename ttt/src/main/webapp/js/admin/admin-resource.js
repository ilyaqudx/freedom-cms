var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	async: {
		enable: true,
		url:"resource/tree",
		autoParam:["id", "name=n", "level=lv"],
		otherParam:{"pId":$('#pId').val()},
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		dataType:'text',
		dataFilter: null
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			/* if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else { */
//			demoIframe.attr("src","resource/list?pId=" + treeNode.id);
			$('#pId').val(treeNode.id);
			t.fnDraw();
			return true;
			/* } */
		}
	}
};

var zNodes;

//function loadTree(){
//	$.ajax({
//		type:'POST',
//		url:'resource/tree',
//		data:'',
//		dataType:'text',
//		async:false,
//		success:function(data){
//			zNodes = data;
//			return data;
//		}
//	});
//}
		
var code;
var tree;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

var t;

$(document).ready(function(){
	t = $('#table').dataTable({
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
            title: "名称",
            orderable: false
	  	},{
        	data: "url",
            title: "地址",
            orderable: false
	  	},{
	  		data:"icon",
	  		title:'图标',
	  		orderable:false
	  	},{
        	data: "description",
            title: "描述",
            orderable: false
	  	},{
        	data: "log",
            title: "记录日志",
            orderable: false
	  	},{
        	data: "authority",
            title: "权限控制",
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
	        //   指定第一列，从0开始，0表示第一列，1表示第二列……
	        targets: 0,
	        render: function(data, type, row, meta) {
	            return '<input type="checkbox" name="" value="' + row.id + '" />';
	        }
		},{
			targets:4,
			render:function(data, type, row, meta){
	        	if(data == 'undefined' || data == ''){
	        		return '';
	        	}
				return '<img alt="" width="14" height="14" src="'+data+'">';
			}
		},{
			targets:[7,6],
			render: function(data, type, row, meta){
				if(data == 1){
					return '是';
				}
				return '否';
			}
		},{
	        targets: 8,
	        render: function(data, type, row, meta) {
	        	var html = '';
	            html += ' <a title="编辑" href="javascript:;" onclick="resource_edit(\'权限编辑\','+row.id+',\'800\',\'600\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
	            html += ' <a title="删除" disabled="disabled" href="javascript:;" onclick="resource_del('+row.id+')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
		var pId = $('#pId').val();
		if(pId != null && pId != ''){
			params['pId']=pId;
		}
		return params;
	}

	tree = $("#treeDemo");
	tree = $.fn.zTree.init(tree, setting);
//	demoIframe = $("#testIframe");
//	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
//	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});

function admin_permission_add(title,w,h){
	layer_show(title,'resource/add?pId='+$('#pId').val(),w,h);
}

function resource_edit(title,id,w,h){
	layer_show(title,'resource/edit?id='+id,w,h);
}

function resource_del(id){
	layer.confirm('确定要删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'resource/delete',
			data:'id='+id,
			dataType:'json',
			success:function(data){
				if(data.code == 0){
//					layer.msg('已删除!',{icon:1,time:1000},function(){
						t.fnDraw();
						var node = tree.getNodeByParam("id", pId, null);//得到当前节点
						tree.reAsyncChildNodes(node, "refresh");//重新加载节点
//					});
				}else{
					layer.msg('服务器内部错误！');
				}
			}
		});
	});
}

function updateCache(){
	$.ajax({
		type:'POST',
		url:'resource/updateCache',
		data:'',
		dataType:'json',
		success:function(data){
			if(data.code == 0){
				layer.msg('已更新！');
			}else{
				layer.msg('服务器内部错误！');
			}
		}
	});
}