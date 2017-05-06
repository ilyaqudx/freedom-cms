<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="js/version/appConfigEdit.js"></script>
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<title>版本修改</title>
<style type="text/css">
progress::-webkit-progress-bar{
    height:15px;
    display:block;
    background-color:red;
    width:0;
    -webkit-border-radius: 8px;
    border-radius:8px;
    color: green;
    -webkit-transition:width .8s ease;
    -moz-transition:width .8s ease;
    transition:width .8s ease;
    -webkit-animation:progressbar 7s infinite;
    animation:progressbar 7s infinite
}
progress::-moz-progress-bar {
    height:15px;
    display:block;
    background-color:red;
    width:0;
    -webkit-border-radius: 8px;
    border-radius:8px;
    color: green;
    -webkit-transition:width .8s ease;
    -moz-transition:width .8s ease;
    transition:width .8s ease;
    -webkit-animation:progressbar 7s infinite;
    animation:progressbar 7s infinite
    }
</style>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add" enctype="multipart/form-data">
	<input type="hidden" id="id" value="${appConfig.id }">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>最新版本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" style="width: 150px;" value="${appConfig.latestVersion }" placeholder="" id="latestVersion" name="latestVersion">
             <input type="file" id="file" name="file" style="filter:alpha(opacity=0);opacity:0;width: 0;height: 0;" />
		    <input type="button" class="btn btn-primary radius" value="上传APK" id="uploadAPK">
        </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>最低版本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" style="width: 150px;" value="${appConfig.forceVersion }" placeholder="" id="forceVersion" name="forceVersion">
           
        </div>
	</div>
	
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>更新消息：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${appConfig.updateMsg }" placeholder="" id="updateMsg" name="updateMsg">
			</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" id="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;
		</div>
	</div>
	<br>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<progress value="50" max="100"></progress>
		</div>
	</div>
	</form>
</article>

</body>
</html>