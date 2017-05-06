<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/product/orderEdit.js"></script>
<title>新建网站角色 - 管理员管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="orderId" value="${order.id }">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${order.orderNo }" placeholder="" id="orderNo" name="orderNo" disabled="disabled">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="orderStatus" name="orderStatus" size="1">
				<c:forEach var="item" items="${statusList }">
				          <c:if test="${order != null }">							
								<c:if test="${item.status==order.status }">
									<option value="${item.status }" selected="selected">${item.statusName}</option>
								</c:if>	
								
								<option value="${item.status }">${item.statusName}</option>
								</c:if>
								

						</c:forEach>
			</select>
			</span>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="button" class="btn btn-success radius" id="submit"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>