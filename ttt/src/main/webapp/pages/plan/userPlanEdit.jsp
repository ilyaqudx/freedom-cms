<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/plan/userPlanEdit.js"></script>
<title>用户计划</title>
</head>
<body>

<article class="page-container">
<form action="userPlan/edit" method="post" enctype="multipart/form-data" class="form form-horizontal" id="form-admin-add">
	<input type="hidden" id="userPlanId" name="id" value="${userPlan.id }">
	<input type="hidden" id="improveAbilitys" name="improveAbilitys" value="${userPlan.improveAbilitys }">
	<input type="hidden" id="trainingGames" name="trainingGames" value="${userPlan.trainingGames }">
	
	 <div class="row cl"><!-- userID -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${userPlan.userId }" placeholder="" id="userId" name="userId" >
			</div>
	</div><!-- userID end -->
    <div class="row cl"><!-- 图标 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<img src="${userPlan.icon }" id="icon" name="icon" style="width: 50px;height: 30px;">
			    <input type="file" name="file" id="file"/>
			</div>
	</div><!-- 图标 end -->
	<div class="row cl"><!-- 计划子项  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>计划模板：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="templateId" name="templateId" size="1">
					<c:forEach var="item" items="${templates }">
							<c:if test="${item.id == userPlan.templateId }">
								<option value="${item.id }" selected="selected">${item.name}</option>
							</c:if>
							<c:if test="${item.id != userPlan.templateId }">
								<option value="${item.id }">${item.name}</option>
							</c:if>
						
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	
	<div class="row cl"><!-- 价格 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>第几天：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${userPlan.dailySequnce }" placeholder="" id="dailySequnce" name="dailySequnce" min="1">
			</div>
	</div><!-- 价格end -->
	<div class="row cl"><!-- 价格 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>最后 天数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${userPlan.finishDailySeq }" placeholder="" id="finishDailySeq" name="finishDailySeq" min="0">
			</div>
	</div><!-- 价格end -->
	<div class="row cl"><!-- 商品名 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>计划名：</label>
			<div class="formControls col-xs-8 col-sm-9">			 
				<input type="text" class="input-text" value="${userPlan.name }" id="name" name="name">
			</div>
	</div><!-- 商品名end -->
		
	<div class="row cl"><!-- 价格 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>能力：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach var="item" items="${abilities }">		
			     	<input type="checkbox" value="${item.id }" placeholder="" name="abilityNames">${item.name}			
				</c:forEach>
			</div>
	</div><!-- 价格end -->
	<div class="row cl"><!-- 价格 -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>游戏：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:forEach var="item" items="${games }">		
			     	<input type="checkbox" value="${item.id }" placeholder="" name="games">${item.name}			
				</c:forEach>
			</div>
	</div><!-- 价格end -->

	
	<div class="row cl"><!-- 计划子项  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>计划子项：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="planItemId" name="planItemId" size="1">
					<c:forEach var="item" items="${planitems }">
							<c:if test="${item.id == userPlan.planItemId }">
								<option value="${item.id }" selected="selected">${item.name}</option>
							</c:if>
							<c:if test="${item.id != userPlan.planItemId }">
								<option value="${item.id }">${item.name}</option>
							</c:if>
						
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	<div class="row cl"><!-- userID -->
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>测评ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="number" class="input-text" value="${userPlan.evaluationId }" placeholder="" id="evaluationId" name="evaluationId">
			</div>
	</div><!-- userID end -->
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea rows="2" cols="45" id=description name="description">${userPlan.description }</textarea>
			</div>
	</div>
	<div class="row cl"><!--状态  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>打开状态：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="openFlag" name="openFlag" size="1">
					<c:forEach var="item" items="${openFlags }">
							<c:if test="${item.openFlag == userPlan.openFlag }">
								<option value="${item.openFlag }" selected="selected">${item.openFlagName}</option>
							</c:if>
							<c:if test="${item.openFlag != userPlan.openFlag }">
								<option value="${item.openFlag }">${item.openFlagName}</option>					
					     	</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	
	<div class="row cl"><!-- 训练完成  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>训练完成：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="trainingFinish" name="trainingFinish" size="1">
					<c:forEach var="item" items="${status }">
							<c:if test="${item.status == userPlan.trainingFinish }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status != userPlan.trainingFinish }">
								<option value="${item.status }">${item.statusName}</option>
							</c:if>
						
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	<div class="row cl"><!-- 训练完成  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>测评完成：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="evaluationFinish" name="evaluationFinish" size="1">
					<c:forEach var="item" items="${status }">
							<c:if test="${item.status == userPlan.evaluationFinish }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status != userPlan.evaluationFinish }">
								<option value="${item.status}">${item.statusName }</option>
						    </c:if>
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	<div class="row cl"><!-- 训练完成  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>当天训练完成：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id=todayFinish name="todayFinish" size="1">
					<c:forEach var="item" items="${status }">
							<c:if test="${item.status == userPlan.todayFinish }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status != userPlan.todayFinish }">
								<option value="${item.status }">${item.statusName}</option>
							</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	<div class="row cl"><!-- 训练完成  -->
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否完成：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
				<select class="select" id="finish" name="finish" size="1">
					<c:forEach var="item" items="${status }">
							<c:if test="${item.status == userPlan.finish }">
								<option value="${item.status }" selected="selected">${item.statusName}</option>
							</c:if>
							<c:if test="${item.status != userPlan.finish }">
								<option value="${item.status }">${item.statusName}</option>
							</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
	</div><!-- 状态 end -->
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input type="submit" id="submit" value="确定" style="width: 100px;height: 35px; background-color: silver; border-radius:10px;">&nbsp;&nbsp;
			<button id="cancel" style="width: 100px;height: 35px; background-color: silver; border-radius:10px;">取消</button>
		</div>
	</div>
	</form>
</article>

<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
</body>
</html>