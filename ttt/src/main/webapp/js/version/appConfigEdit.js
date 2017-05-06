$(function() {
	//点击上传按钮
	$("#uploadAPK").click(function() {
		$("#file").trigger('click');
	});
	// 检测只能上传apk包
	$("#file").bind('change',function(){
		debugger
		var fileName = 	$("#file").val();
		var suffix = fileName.substring(fileName.lastIndexOf("."));
		if(suffix != ".apk"){
			layer.msg("只能上传APK包");
			return;
		}else{// 上传服务器
			
			return false;
		}
	});
	$("#submit").click(function() {
		debugger;
		var latestVersion = $("#latestVersion").val();
		if(latestVersion == null || latestVersion == ""){
		 layer.msg("最新版本不能为空");	
		 return ;
		}
		var forceVersion = $("#forceVersion").val();
		if(forceVersion == null || forceVersion == ""){
			 layer.msg("最低版本不能为空");	
			 return ;
		}
		var updateMsg = $("#updateMsg").val();
		if(updateMsg == null || updateMsg == ""){
			 layer.msg("最低版本不能为空");	
			 return ;
		}
		var id = $("#id").val();
		var param = {
			id : id,
			updateMsg : updateMsg,
			forceVersion : forceVersion,
			latestVersion : latestVersion
			
		};
		var formData = new FormData();
		var file = "";
		if($("#file").get(0) != null){
			file = $("#file").get(0).files[0];
			formData.append("file",file);
		}
		formData.append("param",JSON.stringify(param));
		$.ajax({
			type:'POST',
			url : "appConfig/edit", 
			data : formData, 
			contentType: false, //必须false才会避开jQuery对 formdata 的默认处理 XMLHttpRequest会对 formdata 进行正确的处理  
			processData: false, //必须false才会自动加上正确的Content-Type
			success : function(data) {
				layer.msg("上传成功");
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			},
			error : function(data) {
				layer.msg("上传出现问题");
			}
		});
	});
});