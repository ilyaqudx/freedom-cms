<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/header.jsp"></jsp:include>
    <script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="js/marketing/sharedAccount.js"></script>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <title>分享列表统计</title>
    <style>
        .dataTables_length { display: none; }
    </style>
</head>
<body>
<div class="page-container">
    <div class="text-c" style="text-align: left;">
        <input type="hidden" id="id" value="${id}">
        <input type="text" id="phones" name="phones" placeholder="请输入邀请人的手机号，多个手机号以逗号分隔。" class="input-text" style="width: 400px;" />
        <button name="btn-add" onclick="add();" id="btn-add" class="btn btn-success" type="submit">添加关联</button>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort" style="text_align:center;">
        </table>
    </div>
</div>
</body>
</html>