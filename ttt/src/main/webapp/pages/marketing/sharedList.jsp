<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/header.jsp"></jsp:include>
    <script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="js/marketing/sharedList.js"></script>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <title>分享列表统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 推广管理 <span class="c-gray en">&gt;</span> 分享统计 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c" style="text-align: left;">
        <input type="text" id="search-text" placeholder="请输入邀请人的手机号，多个手机号以逗号分隔。" class="input-text" style="width: 400px;" />
        <button name="search" id="search" class="btn btn-success" type="submit"><i class="Hui-search">&#xe665;</i>搜索</button>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort" style="text_align:center;">
        </table>
    </div>
</div>
</body>
</html>