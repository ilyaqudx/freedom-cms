$(function() {
	
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
	
	
	
	/*******************类型为送栗子，栗子数输入框出现*********************/
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
	/********************选择APP，后面可选****************************/
	$("#selecctApp").click(function() {
		if($("#selecctApp").prop("checked")){
		    $("input[name='terminal']").removeAttr("disabled");
		}else{
		    $("input[name='terminal']").removeAttr("checked");
		    $("input[name='terminal']").attr("disabled",true);
		}
	});
	
	/********************提交数据****************************/
	$("#submit").click(function() {
		//终端设备
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
		
		var type = $("#type").val();
		var attachment = $("#attachment").val();
		
		var messageTypeId = $("#messageTypeId").val();
		var status = $("#status").val();
		var startTime = $("#datemin").val();
		var endTime = $("#datemax").val();
		var id = $("#id").val();
		var url;
		var wxContent = $("#wxContent").val();
		var params = {
				type : type,
				messageTypeId : messageTypeId,
				title : title,
				content : content,
				wxContent : wxContent,
				status : status,
				startTime : startTime,
				endTime : endTime,
				devices :devices
		};
		if(type == 2){
			params['attachment'] = attachment;
		}
		if(id != null && id != ""){
			params['id'] = id;
			url = "message/edit";
		}else{
			url = "message/add";
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