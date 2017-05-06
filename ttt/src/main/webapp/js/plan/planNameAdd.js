function check(){
	if ($("#id").val() == '') {
		$("#id").val(0);
	}
	var planName = $("#planName").val();// 获取计划名
	var s = $('input[type="checkbox"]');// 得到checkbox列表
	//var imgPath = $("#src").src;
	if (planName == "") {
		alert('计划名不能为空！');
		return false;
	}else{
		$.post("plan/getByName", {'name' : planName}, function(data) {//							
			var obj = JSON.parse(data);
			if (obj != null) {
				if($("#id").val() == 0 || $("#id").val() != obj.id){// 添加页面
					alert('此计划名已存在！');
					return false;
				}
			}
		});
		
		
	}
	var m = [];// 数组
	for ( var i = 0; i < s.length; i++) {
		if (s[i].checked == true) {
			m.push(parseInt(s[i].value));// 将选中的checkbox的value值添加到数组里面
		};
	};
	if (m.length <= 0) {
		alert('需要选择能力！');
		return false;
	}else{
		var abilityJSON = JSON.stringify(m);// json数组转换成json字符串
		$("#abilitysJ").val(abilityJSON);
	}

	if ($("#imgFile").val() =='') {	
		 if($("#id").val() !=0){
			 return true;
		 }
			alert('需要图片！');
			return false;
    }	
}

/** ***************增加，修改********************** */
$(function() {
	var hiedenId = $("#id").val();// 得到隐藏域里面ID的值

	/** *******************获取能力列表添加复选框************************* */
	$.post("plan/abilityList", function(data) {//
		var jsonObj = eval(data);
		for ( var i = 0; i < jsonObj.length; i++) {
			$("#abilitys").append(
					"<input type='checkbox' value=" + jsonObj[i].id
							+ " name='ability'/>" + jsonObj[i].name + "    ");

		};
		/** *****************************修改页面时********************************* */

		var abilitysJs = $("#abilitysJ").val();// 得到能力值
		var boxVal = eval(abilitysJs);// 得到能力具体的值
		var s = $('input[type="checkbox"]');// 得到checkbox列表
		if (hiedenId != '') {// 修改页面时
			for ( var i = 0; i < boxVal.length; i++) {
				for ( var j = 0; j < s.length; j++) {

					if (boxVal[i] == s[j].value) {
						s[j].checked = true;
					}
				}

			}
		}// 修改页面
	});

	/** *********************点击取消****************************** */
	$("#cancel").click(function() {
		parent.location.href = "plan/planName";// 返回到父级页面
	});
	$("#imgFile").bind(
			'change',
			function() {
				var fileObj = $('#imgFile').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
						&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('imgFile').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('imgShow').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
			});
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

});
