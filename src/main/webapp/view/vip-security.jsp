<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0047)http://osd.greenleafgroup.cn/member/updpwd.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js-before.jsp"/>
<link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
    <script src="/js/formValidator.js"></script>
    <script src="/js/formValidatorRegex.js"></script>
    <script type="text/javascript">
      
    	function toChange(type){
			var data;
			if(type == 1){
			var oldLoginPwd = $("#oldLoginPassword").val();
			var newLoginPwd = $("#newLoginPassword").val();
				if(!oldLoginPwd || oldLoginPwd.length != 6){
					alert("请输入6位数的字母或者数字组合");
					return;
				}
				if(!newLoginPwd || newLoginPwd.length != 6){
					alert("请输入6位数的字母或者数字组合");
					return;
				}
				data = {
						oldLoginPassword : oldLoginPwd,
						newLoginPassword : newLoginPwd,
						changeType      : type
				}
			}else if(type == 2){
				var oldPayPwd = $("#oldPayPassword").val();
				var newPayPwd = $("#newPayPassword").val();
				if(!oldPayPwd || oldPayPwd.length != 6){
					alert("请输入6位数的字母或者数字组合");
					return;
				}
				if(!newPayPwd || newPayPwd.length != 6){
					alert("请输入6位数的字母或者数字组合");
					return;
				}
				data = {
						oldPayPassword : oldPayPwd,
						newPayPassword : newPayPwd,
						changeType      : type
				}
			}
			//验证成功
			$.ajax({
				type:'POST',
				data : data,
				url:"/user/changePassword",
				dataType:'json',
				success:function(data){
					if(data.code == 0){
						$("#oldLoginPassword").val('');
						$("#newLoginPassword").val('');
						$("#oldPayPassword").val('');
						$("#newPayPassword").val('');
						alert(data.result);
					}else{
						alert(data.msg);
					}
				}
			});
			return false;
    	}
				</script>
</head>
<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/updpwd.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/updpwd.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/updpwd.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/updpwd.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/updpwd.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="http://osd.greenleafgroup.cn/member/updpwd.aspx" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="4f68fc0c-6343-4ba0-ae05-059075900a7b">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="123815.91406">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTM5ODQyNjA1OQ9kFgICAw9kFgQCAQ9kFhICAQ8WAh4Fc3R5bGUFEGRpc3BsYXk6ZGlzcGxheTtkAgIPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCAw8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIEDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgUPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBg8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIHDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAggPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCCQ8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIDD2QWBgIBDxYCHgtfIUl0ZW1Db3VudAIFFgpmD2QWAmYPFQMDMTY2D+WVhuWfjuWNleWFrOWRihEyMDE3LzUvNiAxMTowNTo1MGQCAQ9kFgJmDxUDAzE2NA81LjHmlL7lgYflhazlkYoSMjAxNy80LzE4IDEwOjQ2OjIxZAICD2QWAmYPFQMDMTYzDOe+juWYieWFrOWRihIyMDE3LzQvMTQgMTI6NDg6MTBkAgMPZBYCZg8VAwMxNjE25YWz5LqO5pS26LSn5rOo5oSP5LqL6aG55Y+K44CK5pS26LSn5byC5bi46KGo44CL5aGr5YaZETIwMTcvNC81IDE0OjM5OjM1ZAIED2QWAmYPFQMDMTYwHTIwMTflubQ05pyI5L+D6ZSA5rS75Yqo6YCa55+lETIwMTcvNC8yIDEwOjQzOjI4ZAIDDxYCHglpbm5lcmh0bWwFBuWnmuWFsGQCBA8WAh8CBQbkvJrlkZhkZJPuWecGWPnUGsKLZKfXRySS/ZfP">
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBwLRuu6VDAK0vbTICwL7mOLEAQLCi9reAwK949qPDALE46rPCwL4kvGdCPrxSaKYPrrKXfa/675RNvQzjqFk">
</div>
        <section>
            
<jsp:include page="header.jsp"/>

            <div class="main-content">
                
<jsp:include page="top.jsp"/>
                <div id="page-wrapper">
                    <div class="graphs">


                        <div class="row">
                            <!-- Start Panel -->
                            <div class="col-md-12">
                                <div class="panel">

                                    <div class="panel-body form-horizontal">
                                    	<form name="form1" method="post" action="/user/changePassword" id="form1">
                                        <div class="form-group">
                                            <label for="input3" class="col-sm-2 control-label form-label">旧一级密码</label>
                                            <div class="col-sm-6">
                                                <input name="oldLoginPassword" type="password" id="oldLoginPassword" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input3" class="col-sm-2 control-label form-label">新一级密码</label>
                                            <div class="col-sm-6">
                                                <input name="newLoginPassword" type="password" id="newLoginPassword" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label"></label>
                                            <div class="col-sm-10">
                                                <input type="button" name="btnSubmit" value="提交" onclick="toChange(1)" id="btnSubmit" class="btn btn-default">
                                            </div>
                                        </div>
                                        </form>
                                        <form name="form2" method="post" action="/user/changePassword" id="form1">
                                        <div class="form-group">
                                            <label for="input3" class="col-sm-2 control-label form-label">旧二级密码</label>
                                            <div class="col-sm-6">
                                                <input name="oldPayPassword" type="password" id="oldPayPassword" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input3" class="col-sm-2 control-label form-label">新二级密码</label>
                                            <div class="col-sm-6">
                                                <input name="newPayPassword" type="password" id="newPayPassword" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label"></label>
                                            <div class="col-sm-10">
                                                <input type="button" name="btnUpd" value="提交" onclick="toChange(2)" id="btnUpd" class="btn btn-default">
                                            </div>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
         <script
	<jsp:include page="js-after.jsp"/>
        <script type="text/javascript">
        	$(function(){
        		var error = $("#error").val();
        		if(error){
        			alert(error);
        		}
        	})
        </script>
<div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 506px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1536px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; left: 49px; height: 711px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99); top: 708px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>



<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div></body></html>