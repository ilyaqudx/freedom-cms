$(function(){
	/************************去掉select 重复的选择************************/
	$("select option").each(function() {
		text = $(this).text();
		if($("select option:contains("+text+")").length > 1)
			$("select option:contains("+text+"):gt(0)").remove();
	});
	$("#submit").click(function() {
		var status = $("#orderStatus").val();//状态
		var id = $("#orderId").val();//ID
		debugger
		$.ajax({
			type:'POST',
			url:'order/edit',
			data:{'id':id,'status':status},
			dataType:'json',
			success:function(data){
				layer.msg('修改成功！');
				parent.location.reload();
			}
		});
	});
});