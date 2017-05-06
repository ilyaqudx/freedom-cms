<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="js/game/gameAdd.js"></script>
<title>添加游戏</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 游戏管理 <span class="c-gray en">&gt;</span> ${game.name}<span class="c-gray en">&gt;</span>基本配置 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<article class="page-container">
	
	<form action="game/add" method="post" class="form form-horizontal" id="form-admin-add" enctype="multipart/form-data">
	<input type="hidden" id="gameId" name="id" value="${game.id }">
	<input type="hidden" id="gameCode" name ="gameCode" value="${game.code }">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>编号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" min="0" value="${game.code }" placeholder="" id="code" name="code" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>游戏名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${game.name }" placeholder="" id="gameName" name="name">
		</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>对应能力：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="ability" name="ability" size="1">
				<c:forEach var="item" items="${abilityList }">
						<c:if test="${item.id == game.ability }">
							<option value="${item.id }" selected="selected">${item.name}</option>
						</c:if>
						<c:if test="${item.id!=game.ability }">
							<option value="${item.id }">${item.name }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图标：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${game.icon }" width="60px" height="40px" id="icon">
			<input type="file" name="fileIcon" id="fileIcon">
			 </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>链接（高）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${game.url }" placeholder="" id="gameUrl" name="url">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>链接（低）：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${game.urlLow }" placeholder="" id="gameUrl2" name="urlLow">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>宽屏：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${game.urlWide }" placeholder="" id="urlWide" name="urlWide">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>版本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${game.version }" placeholder="" id="version" name="version">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>封面：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${game.cover }" width="60px" height="40px" id="cover">
			<input type="file" name="fileCover" id="fileCover">
		 </div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea rows="2" cols="45" id="description" name="description">${game.description }</textarea>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="status" name="status" size="1">
				<c:forEach var="item" items="${status }">
						<c:if test="${item.status == game.status }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!=game.status }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专项训练：</label>
			<div class="formControls col-xs-8 col-sm-9"><span class="select-box" style="width:150px;">
				<select class="select" id="advancedPlanGame" name="advancedPlanGame" size="1">
				<c:forEach var="item" items="${statuAd }">
						<c:if test="${item.status == game.advancedPlanGame }">
							<option value="${item.status }" selected="selected">${item.statusName}</option>
						</c:if>
						<c:if test="${item.status!=game.advancedPlanGame }">
							<option value="${item.status }">${item.statusName }</option>
						</c:if>
				</c:forEach>
			</select></span>
			</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>背景适配图：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<img src="${game.bgAdapter }" width="60px" height="40px" id="bgAdapter">
			<input type="file" name="filebg" id="filebg">
		 </div>
	</div>
	
	<div id = "configTableContainer"  class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>配置表：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="configTable" name="configTable" value="${game.configTable }">
			</div>
	</div>
	<div id = "logTableContainer" class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>日志表：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="logTable" name="logTable" value="${game.logTable }">
			</div>
	</div>

	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script> 
	if (${game.code > 47}) {
		$("#configTableContainer").css({display: "none"});
		$("#configTableContainer").attr("ignore", "true");
		$("#logTableContainer").css({display: "none"});
		$("#logTableContainer").attr("ignore", "true");
	}
</script>
</body>
</html>