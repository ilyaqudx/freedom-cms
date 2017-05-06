
var t;

$(document).ready(function(){
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
        	data: "message",
            title: "操作",
            orderable: false
	  	},{
        	data: "createTime",
            title: "时间",
            orderable: true
	  	}],
		"aaSorting": [[ 4, "desc" ]],//默认第几个排序
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
			targets:[4],
			render: function(data, type, row, meta){
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

		return params;
	}

});
