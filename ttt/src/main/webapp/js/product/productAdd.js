$(function(){
	
/*	*//************************去掉select 重复的选择************************//*
		$("select option").each(function() {
			text = $(this).text();
			if($("select option:contains("+text+")").length > 1)
				$("select option:contains("+text+"):gt(0)").remove();
		});
		*/
	/************************提交数据**************************************/
		$('#submit').click(function(){
			var ProductName = $('#ProductName').val();
			if(ProductName == '' || ProductName == null){
				layer.msg('商品名不能为空！');return;
			}			
			var price = $("#price1").val();
			if(price == '' || price == null){
				layer.msg('价格不能为空！');return;
			}
			var iosPrice = $('#iosPrice').val();
			if(iosPrice == '' || iosPrice == null){
				layer.msg('ios价格不能为空！');return;
			}
			var count = $('#count').val();//训练周期
			if(count == '' || count == null){
				layer.msg('数量不能为空！');return;
			}
			var payCode = $('#payCode').val();//免费天数
			if(payCode == '' || payCode == null){
				layer.msg('支付代码不能为空！');return;
			}
			var description = $('#description').val();//原价
			if(description == '' || description == null){
				layer.msg('需要描述！');return;
			}
			var originalPrice = $('#originalPrice').val();//现价
			if(originalPrice == '' || originalPrice == null){
				layer.msg('原价不能为空！');return;
			}
			var iosOriginalPrice = $('#iosOriginalPrice').val();//通关需要星星数
			if(iosOriginalPrice == '' || iosOriginalPrice == null){
				layer.msg('IOS原价不能为空！');return;
			}
			var type = $("#productType").val();//类型
			var status = $("#productStatus").val();//状态
			var code = $("#productCode").val();
			var id = $('#productId').val();//ID
			var url = 'product/add';
			var params = {				
					type:type,
					name:ProductName,
					price:price,
					iosPrice:iosPrice,
					count:count,
					payCode:payCode,
					status:status,
					description:description,
					code:code,
					originalPrice:originalPrice,
					iosOriginalPrice:iosOriginalPrice				
			};
			if(id !=''&&id != null){
				url = 'product/update';
				params['id'] = id;
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
		
		
		$("#cancel").click(function(){
			parent.location.reload();
		});
	
});