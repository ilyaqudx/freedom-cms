$(function(){
	
	$('#submit').click(function(){
		var planName = $('#planName').val();
		if(planName == '' || planName == null){
			layer.msg('计划名不能为空！');return;
		}
		var templateId = $('#templateId').val();
		if(templateId == '' || templateId == null){
			layer.msg('类型不能为空！');return;
		}
		var sequence = $('#sequence').val();
		if(sequence == '' || sequence == null){
			layer.msg('排序不能为空！');return;
		}
		var cycle = $('#cycle').val();//训练周期
		if(cycle == '' || cycle == null){
			layer.msg('训练周期不能为空！');return;
		}
		var freeDays = $('#freeDays').val();//免费天数
		if(freeDays == '' || freeDays == null){
			layer.msg('免费天数不能为空！');return;
		}
		var originalGold = $('#originalGold').val();//原价
		if(originalGold == '' || originalGold == null){
			layer.msg('原价不能为空！');return;
		}
		var gold = $('#gold').val();//现价
		if(gold == '' || gold == null){
			layer.msg('现价不能为空！');return;
		}
		var trainingPassStar = $('#trainingPassStar').val();//通关需要星星数
		if(trainingPassStar == '' || trainingPassStar == null){
			layer.msg('通关需要星星数不能为空！');return;
		}
		var trainingAbilityCount = $('#trainingAbilityCount').val();//通关需要星星数
		if(trainingAbilityCount == '' || trainingAbilityCount == null){
			layer.msg('训练能力数不能为空！');return;
		}
		var evaluationAbilityCount = $('#evaluationAbilityCount').val();//通关需要星星数
		if(evaluationAbilityCount == '' || evaluationAbilityCount == null){
			layer.msg('测评能力数不能为空！');return;
		}
		var params = {
				name:planName,
				templateId:templateId,
				sequence:sequence,
				cycle:cycle,
				freeDays:freeDays,
				originalGold:originalGold,
				gold:gold,
				trainingPassStar:trainingPassStar,
				trainingAbilityCount:trainingAbilityCount,
				evaluationAbilityCount:evaluationAbilityCount
		};
		var planId = $('#planId').val();
		var url = 'plan/add';
		if(planId != null && planId != ''){
			url = 'plan/edit';
			params['id'] = planId;
		}
		$.ajax({
			type:'POST',
			url:url,
			data:'params='+JSON.stringify(params),
			dataType:'json',
			success:function(data){
				parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});
	});
});