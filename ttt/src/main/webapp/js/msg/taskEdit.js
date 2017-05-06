function IsURL (str_url) {
	var strRegex = '^((https|http|ftp|rtsp|mms)?://)'
	+ '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' // ftp的user@
	+ '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
	+ '|' // 允许IP和DOMAIN（域名）
	+ '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
	+ '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
	+ '[a-z]{2,6})' // first level domain- .com or .museum
	+ '(:[0-9]{1,4})?' // 端口- :80
	+ '((/?)|' // a slash isn't required if there is no file name
	+ '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$'; 
	var re=new RegExp(strRegex); 
	// re.test()
	if (re.test(str_url)) { 
	return (true); 
	} else { 
	return (false); 
	} 
}


var actionTypeChange = function(){
	var actionType = $("#actionType").val();
	if(actionType == 0 || actionType == 1){
		$("#openUrl").hide();
		$("#jumpView").hide();
	}else if(actionType == 2){
		$("#openUrl").hide();
		$("#jumpView").show();
	}else if(actionType == 3){
		$("#openUrl").show();
		$("#jumpView").hide();
	}
}

var newAddChange = function(){
	var newAdd = $("#newAdd").val();
	if(newAdd == 0){
		$("#newAddDaysDiv").hide();
	}else {
		$("#newAddDaysDiv").show();
	}
}

var selectChange = function(obj){
	var index  = obj.selectedIndex;// 当前选中的OPTION索引
	var options = $(obj).find("option");
	for ( var int = 0; int < options.length; int++) {
		$(options[int]).removeAttr('selected');
	}
	$(options[index]).attr('selected','selected');
}

$(function() {
	
	actionTypeChange();
	$("#actionType").bind('change',actionTypeChange);
	newAddChange();
	$("#newAdd").bind("change",newAddChange);
	
	
	// 修改时加载 选择哪些终端设备1。获取 2.解析。3.判断
	var devices = $("#devices").val();
	var checkboxs = $('input[type="checkbox"]');// 得到checkbox列表
	if(devices != null && devices!=""){
		var devicesObj = JSON.parse(devices);
		for(var i in devicesObj){
			if(devicesObj[i] == 1 || devicesObj[i] == 2 || devicesObj[i] == 3 || devicesObj[i] == 4){
				$("#selecctApp").attr("checked",true);
				$("input[name='terminal']").removeAttr("disabled");
			}
			for(var j in checkboxs){
				if(devicesObj[i] == checkboxs[j].value){
					 checkboxs[j].checked = true;
				}
			}
		}
	}
	
	
	
	/** *****************类型为送栗子，栗子数输入框出现******************** */
	// 加载的时候如果类型为送栗子显示，其他隐藏
	if($("#type").val() == 2){
		$("#gold").show();
	}else{
		$("#gold").hide();
	}
	
	$("#type").bind('change',function(){
		if($("#type").val() == 2){
			$("#gold").show();
		}else{
			$("#gold").hide();
		}
	});
	/** ******************选择APP，后面可选*************************** */
	$("#selecctApp").click(function() {
		if($("#selecctApp").prop("checked")){
		    $("input[name='terminal']").removeAttr("disabled");
		}else{
		    $("input[name='terminal']").removeAttr("checked");
		    $("input[name='terminal']").attr("disabled",true);
		}
	});
	
	/** ******************提交数据*************************** */
	$("#submit").click(function() {
		// 终端设备
		var obj = [];
		for(var i in checkboxs){
			if(checkboxs[i].checked == true){
				if(checkboxs[i].value == 0){
					continue;
				}
				obj.push(parseInt(checkboxs[i].value));
			}
		}
		devices = JSON.stringify(obj);
		if(obj.length <= 0){
			layer.msg("必须选择设备");
			return;
		}
		
		var title = $("#title").val();
		if(title == null || title == ""){
			layer.msg("标题不能为空");
			return;
		}
		
		var content = $("#content").val();
		if(content == null || content == ""){
			layer.msg("消息内容不能为空");
			return;
		}
		
		var id = $('#id').val();
		var name = $('#name').val();
		var title = $('#title').val();
		var content = $('#content').val();
		var updateData = $('#updateData').val();
		var eventType = $('#eventType').val();
		var eventParams = $('#eventParams').val();
		var userType = $('#userType').val();
		var vip = $('#vip').val();
		var newAdd = $('#newAdd').val();
		var newAddDays = $('#newAddDays').val();
		var taskExecuteType = $('#taskExecuteType').val();
		var oneTimeTask = $('#oneTimeTask').val();
		var taskExecuteFrequency = $('#taskExecuteFrequency').val();
		var taskFirstExecuteDate = $('#taskFirstExecuteDate').val();
		var taskExecuteTime = $('#taskExecuteTime').val();
		var taskLastExecuteDate = $('#taskLastExecuteDate').val();
		var pushTime = $('#pushTime').val();
		var status = $('#status').val();
		var showType = $('#showType').val();
		var actionType = $('#actionType').val();
		var jumpView = $("#jumpView").find("[cmd=jumpView]").val();
		var openUrl  = $('#openUrl').find("[cmd=openUrl]").val();
		debugger;
		if(actionType == 3){
			if(openUrl.length < 10 || !IsURL(openUrl)){
				layer.msg("url不合法");
				return;
			}
		}
		var action = actionType == 3 ? openUrl : jumpView;
		var createTime = $('#createTime').val();
		var updateTime = $('#updateTime').val();
		var params = {
				id : id,
				name : content,
				title : title,
				content : content,
				updateData : updateData,
				eventType : eventType,
				eventParams : eventParams,
				userType : userType,
				vip : vip,
				newAdd : newAdd,
				newAddDays : newAddDays,
				taskExecuteType : taskExecuteType,
				oneTimeTask : oneTimeTask,
				taskExecuteFrequency : taskExecuteFrequency,
				taskFirstExecuteDate : taskFirstExecuteDate,
				taskExecuteTime : taskExecuteTime,
				taskLastExecuteDate : taskLastExecuteDate,
				pushTime : pushTime,
				status : status,
				devices : devices,
				showType : showType,
				actionType : actionType,
				action : action,
				createTime : createTime,
				updateTime : updateTime
				};
		if(id != null && id != ""){
			params['id'] = id;
			url = "task/edit";
		}else{
			url = "task/add";
		}
		$.ajax({
			type : 'POST',
			url : url,
			data : 'params=' + JSON.stringify(params),
			dataType : 'json',
			success:function(data){
				layer.msg("操作成功");
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
	});

});