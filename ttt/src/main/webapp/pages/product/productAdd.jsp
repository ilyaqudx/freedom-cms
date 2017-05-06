<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/product/productAdd.js"></script>
<title>商品添加</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="productId" value="${product.id }">
	<form class="form form-horizontal" id="form-admin-add">
	  
	<div class="row cl"><!-- 类型 -->
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" id="productType" name="productType" size="1">
				<c:forEach var="item" items="${types }">
							<c:if test="${product != null }">
								<c:if test="${item.status == product.type }">
									<option value="${item.status }" selected="selected">${item.statusName}</option>
								</c:if>
								<c:if test="${item.status!=product.type }">
									<option value="${item.status }">${item.statusName }</option>
								</c:if>
							</c:if>
							<c:if test="${product == null }">
								<option value="${item.status }">${item.statusName }</option>
							</c:if>

						</c:forEach>
			</select>
			</span>
		 </div>
	</div><!-- 类型end -->
	
	<div class="row cl"><!-- 商品名 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>商品名：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="text" class="input-text" value="${product.name }" id="ProductName" name="ProductName">
			</div>
	</div><!-- 商品名end -->
		
	<div class="row cl"><!-- 价格 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格(￥)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${product.price }" placeholder="" id="price1" name="price">
			</div>
	</div><!-- 价格end -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>IOS价格(￥)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" min="0" value="${product.iosPrice }" placeholder="" id="iosPrice" name="iosPrice">
			</div>
		</div>

	<div class="row cl"><!-- 数量 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${product.count }" min="0" placeholder="" id="count" name="count">
			</div>
	</div><!-- 数量end -->
	
	<div class="row cl"><!--  支付代码-->
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>支付代码（IOS）：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${product.payCode }" placeholder="" id="payCode" name="parCode">
			</div>
	</div><!-- 支付代码end -->
	
	<div class="row cl"><!--状态  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="productStatus" name="productStatus" size="1">
					<c:forEach var="item" items="${statuses }">
						<c:if test="${product != null }">
							<c:if test="${item.status==product.status }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status!=product.status }">
								<option value="${item.status }">${item.statusName }</option>
							</c:if>
						</c:if>
						<c:if test="${product == null }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea rows="2" cols="45" id=description name="description">${product.description }</textarea>
			</div>
	</div>

    <div class="row cl"><!--产品标识  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>产品标识：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="productCode" name="productCode" size="1">
					<c:forEach var="item" items="${codes }">
						<c:if test="${product != null }">
							<c:if test="${item.status == product.code }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status != product.code }">
								<option value="${item.status }">${item.statusName }</option>
							</c:if>
						</c:if>
						<c:if test="${product == null }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
   	</div><!-- 产品标识end -->
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原价(￥)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${product.originalPrice }" name="originalPrice" id="originalPrice">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>ios原价(￥)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${product.iosOriginalPrice }" name="iosOriginalPrice" id="iosOriginalPrice">
			</div>
		</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<button id="submit" style="width: 100px;height: 35px; background-color: silver; border-radius:10px;">确定</button>&nbsp;&nbsp;
			<button id="cancel" style="width: 100px;height: 35px; background-color: silver; border-radius:10px;">取消</button>
		</div>
	</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>