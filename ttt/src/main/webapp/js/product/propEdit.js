$(function(){
	$("#image").bind(
			'change',
			function() {
				var fileObj = $('#image').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
						&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('image').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('imageShow').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
	});
	/************************提交数据**************************************/
	$('#submit').click(function(){
		var name = $('#name').val();
		if(name == '' || name == null){
			layer.msg('名称不能为空！');return;
		}			
		var description = $("#description").val();
		if(description == '' || description == null){
			layer.msg('描述不能为空！');return;
		}
		var petExp = $('#petExp').val();
		if(petExp == '' || petExp == null){
			layer.msg('经验值不能为空！');return;
		}
		var random = $('#random').val();// 随机
		var type = $('#type').val();// 随机
		var image = $("#image").get(0).files[0]; //获取file控件中的内容
		var fd = new FormData();
		
		var params = {				
				type:type,
				name:name,
				description:description,
				random:random,
				petExp:petExp
		};
		var id = $('#propId').val();//ID
		var url ;
		if(id == "" || id == null){
			url = 'prop/add';
		}else{
			url = 'prop/edit';
			params['id'] = id;
		}
		
		fd.append("params", JSON.stringify(params));
		fd.append("image", image);//图片
		$.ajax({
		        type: "POST",
		        contentType:false, //必须false才会避开jQuery对 formdata 的默认处理 , XMLHttpRequest会对 formdata 进行正确的处理
		        processData: false, //必须false才会自动加上正确的Content-Type 
		        url: url,
		        data: fd,
		        success: function (data) {
		        	parent.location.reload();
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
		        }
		 });
	});
});