$(function(){
	//加载的时候判断哪些被选中
	var abilities = $("#improveAbilitys").val();//能力列表
	var games = $("#trainingGames").val();//游戏列表

	var aVal = eval(abilities);// 得到能力具体的值
	var gVal = eval(games);// 得到能力具体的值
	var a = $('input[name="abilityNames"]');// 得到checkbox列表
	var g = $('input[name="games"]');// 得到checkbox列表
	for ( var i = 0; i < aVal.length; i++) {
		for ( var j = 0; j < a.length; j++) {
			if (aVal[i] == a[j].value) {
				a[j].checked = true;
			}
		}

	}
	for ( var i = 0; i < gVal.length; i++) {
		for ( var j = 0; j < g.length; j++) {
			if (gVal[i] == g[j].value) {
				g[j].checked = true;
			}
		}
		
	}
	/****************************图片预览***********************/
	$("#file").bind(
			'change',
			function() {
				var fileObj = $('#file').val();// 获取图片路径
				var suffix = fileObj.substr(fileObj.lastIndexOf('.'));
				var ext = suffix.toUpperCase();
				if (ext != '.BMP' && ext != '.PNG' && ext != '.GIF'
						&& ext != '.JPG' && ext != '.JPEG') {
					alert("图片限于png,gif,jpeg,jpg格式");
				} else {
					var f = document.getElementById('file').files[0];
					var src = window.URL.createObjectURL(f);
					document.getElementById('icon').src = src;
					//$('#imgShow').src = window.URL.createObjectURL($('#imgFile').files[0]);
				}
			});

	/****************************传参数*****************************/
	var m = [];// 数组
	for ( var i = 0; i < a.length; i++) {
		if (a[i].checked == true) {
			m.push(parseInt(a[i].value));// 将选中的checkbox的value值添加到数组里面
		};
	};
	var n = [];// 数组
	for ( var i = 0; i < g.length; i++) {
		if (g[i].checked == true) {
			n.push(parseInt(g[i].value));// 将选中的checkbox的value值添加到数组里面
		};
	};
	$("#improveAbilitys").val(JSON.stringify(m));//选中的能力
	$("#trainingGames").val(JSON.stringify(n));//选中的游戏
	
	$("#submit").click(function(){		
		var dailySequnce = $("#dailySequnce").val();
		if(dailySequnce == '' || dailySequnce == null){
			layer.msg('训练到第几不能为空！');return false;
		}
		var finishDailySeq = $('#finishDailySeq').val();
		if(finishDailySeq == '' || finishDailySeq == null){
			layer.msg('剩余天数不能为空！');return false;
		}
		var name = $('#name').val();//训练周期
		if(name == '' || name == null){
			layer.msg('计划名不能为空！');return false;
		}
		
		if(m.length<1){
			layer.msg('必须选择能力！');return false;
		}
		
		if(n.length<1){
			layer.msg('必须选择游戏！');return false;
		}
	});
	
	/***************************点击取消********************************/
	$("#cancel").click(function(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	
});