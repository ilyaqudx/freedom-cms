<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/admin/admin-role-add.js"></script>
<title>新建网站角色 - 管理员管理</title>
</head>
<body>
<article class="page-container">
	<input type="hidden" id="roleId" value="${role.id }">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${role.name }" placeholder="" id="roleName" name="roleName" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${role.description }" placeholder="" id="description" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">网站角色：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<c:forEach var="item" items="${resources.childNodes }" varStatus="status1">
				<dl class="permission-list">
					<dt>
						<label>
							<input type="checkbox" value="${item.id }" name="user-Character-${status1.index }" id="user-Character-${status1.index }" <c:if test="${item.checkstate==1 }">checked="checked"</c:if>>
							${item.text }</label>
					</dt>
					<dd>
					<c:forEach var="itemChild" items="${item.childNodes }" varStatus="status2">
						<dl class="cl permission-list2">
							<dt>
								<label class="">
									<input type="checkbox" value="${itemChild.id }" name="user-Character-${status1.index }-${status2.index }" id="user-Character-${status1.index }-${status2.index }" <c:if test="${itemChild.checkstate==1 }">checked="checked"</c:if>>
									${itemChild.text }</label>
							</dt>
							<dd>
							<c:forEach var="itemChild2" items="${itemChild.childNodes }" varStatus="status3">
								<label class="">
									<input type="checkbox" value="${itemChild2.id }" name="user-Character-${status1.index }-${status2.index }-${status3.index }" id="user-Character-${status1.index }-${status2.index }-${status3.index }" <c:if test="${itemChild2.checkstate==1 }">checked="checked"</c:if>>
									${itemChild2.text }</label>
							</c:forEach>
							</dd>
						</dl>
					</c:forEach>
					</dd>
				</dl>
			</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="button" class="btn btn-success radius" id="admin-role-save"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>