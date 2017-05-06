<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<link href="static/h-ui/js/H-ui.js" rel="stylesheet" type="text/css" />
<title>错误</title>
</head>
<body>
<article class="page-container">
	<div class="loginWraper">
	        <label>系统错误： ${errorMsg}</label>
	</div>
</article>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
</body>
</html>