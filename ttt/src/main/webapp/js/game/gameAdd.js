$(function() {
	$("#submit").click(function() {
		    var gameId = $('#gameId').val();
		    var gameCode = $('#gameCode').val();
			var code = $('#code').val();
			if (code == '' || code == null) {
				layer.msg('编号不能为空！');
				return false;
			}
			
			
			var gameName = $('#gameName').val();
			if (gameName == '' || gameName == null) {
				layer.msg('游戏名不能为空！');
				return false;
			}
			
			var fileIcon = $('#fileIcon').val();
			if ((gameId == '' || gameId == null) && (fileIcon == '' || fileIcon == null)) {
				layer.msg('需要添加图标！');
				return false;
			}
			var gameUrl = $('#gameUrl').val();
			if (gameUrl == '' || gameUrl == null) {
				layer.msg('链接（高）不能为空！');
				return false;
			}
			var gameUrl2 = $('#gameUrl2').val();
			if (gameUrl2 == '' || gameUrl2 == null) {
				layer.msg('链接（低）不能为空！');
				return false;
			}
			var urlWide = $('#urlWide').val();
			if (urlWide == '' || urlWide == null) {
				layer.msg('宽屏不能为空！');
				return false;
			}
			var version = $('#version').val();
			if (version == '' || version == null) {
				layer.msg('版本不能为空！');
				return false;
			}
			var fileCover = $('#fileCover').val();
			if ((gameId == '' || gameId == null) && (fileCover == '' || fileCover == null))
			{
				layer.msg('需要添加封面！');
				return false;
			}
			var description = $('#description').val();
			if (description == '' || description == null) {
				layer.msg('描述不能为空！');
				return false;
			}
			var configTable = $('#configTable').val();
			if (configTable == '' || configTable == null) {
				if (!$("#configTableContainer").attr("ignore")) {
					layer.msg('配置表不能为空！');
					return false;
				}
				
			}
			var logTable = $('#logTable').val();
			if (logTable == '' || logTable == null) {
				if (!$("#logTableContainer").attr("ignore")) {
					layer.msg('日志表不能为空！');
					return false;
				}
			}

			if(gameId == '' || gameId == null){
				$('#gameId').val(0);
			}
			if(gameCode == '' || gameCode == null){
				$('#gameCode').val(0);
			}
		});
	
	/***********************校验编号*******************************/
	$("#code").blur(function() {
		var gameId = $('#gameId').val();
	    var gameCode = $('#gameCode').val();
	    var code = $('#code').val();
		if((gameId == '' || gameId == null) || gameCode != code){
			$.post("game/checkCode",{'code':code},function(data){
				var obj = eval('('+data+')');
				if(obj.code == 1){
					alert(obj.msg);
				}
				
			});
		}
	});
	/*************************图片预览****************************/
	$("#fileIcon").bind(
			'change',
			function() {
				var fileObj = $('#fileIcon').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
						&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('fileIcon').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('icon').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
			});
	$("#fileCover").bind(
			'change',
			function() {
				var fileObj = $('#fileCover').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
					&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('fileCover').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('cover').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
			});
	$("#filebg").bind(
			'change',
			function() {
				var fileObj = $('#filebg').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
					&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('filebg').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('bgAdapter').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
			});
	
});