<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/header.jsp"></jsp:include>
    <script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="js/vip/accountVip.js"></script>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <title>会员期限</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 会员管理 <span class="c-gray en">&gt;</span> 会员期限 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="text-l cl pd-5 bg-1 bk-gray">
        日期范围：
        <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
        <input type="text" name="phone" id="phone" placeholder=" 手机号" style="width:250px" class="input-text">
        <button name="search" id="search" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
        <a class="btn btn-primary radius f-r" onclick="add('手动添加会员记录','accountVip/edit','600','320')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 手动添加记录</a></span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort" style="text_align:center;">
        </table>
    </div>
</div>
</body>
</html>