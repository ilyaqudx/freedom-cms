<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/header.jsp"></jsp:include>
    <script type="text/javascript" src="js/user/account.js"></script>
    <title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray text-l">
        日期范围：
        <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入电话号码" id="phone" name="">
        <select size="1" id="selectType" style="width: 100px;" class="input-text">
            <option value="0">全部</option>
            <option value="1">会员</option>
            <option value="2">游客</option>
        </select>
        <button type="submit" class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
        </table>
    </div>
</div>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
</body>
</html>