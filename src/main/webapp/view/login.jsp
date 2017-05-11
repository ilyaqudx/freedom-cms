<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0039)http://osd.greenleafgroup.cn/login.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="description"><meta name="author">
 
    <!-- CSS -->

    <link rel="stylesheet" href="/js/supersized.css"><link rel="stylesheet" href="/js/login.css"><link href="/js/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" src="/js/tooltips.js"></script>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/formValidator.js" type="text/javascript"></script>
    <script src="/js/formValidatorRegex.js" type="text/javascript"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script type="text/javascript">
        $(document).ready(function () {
           
					$.formValidator.initConfig({
							onError : function(msg) {
								alert(msg)
							},
							onSuccess : function(){
								var code = $("#code").val();
								var pwd  = $("#loginPassword").val();
								var kaptcha = $("#kaptcha").val();
								var params = {
										code : code,
										loginPassword : pwd,
										kaptcha : kaptcha
								}
								$.ajax({
									type:'POST',
									data : JSON.stringify(params),
									url:"/user/login",
									dataType:'json',
									contentType : "application/json",
									success:function(data){
										if(data.code == 0){
											window.location.href="/";
										}else{
											alert(data.msg);
										}
									}
								});
								
								
								
								return false;
							}
						});
						$("#code").formValidator().InputValidator({
							min : 2,
							max : 20,
							onerror : "请输入2-20位的用户名"
						});
						$("#loginPassword").formValidator().InputValidator({
							min : 1,
							max : 20,
							onerror : "请输入密码"
						});
						$("#kaptcha").formValidator().InputValidator({
							min : 4,
							max : 4,
							onerror : "请输入4个字符长度的验证码"
						});
						return false;
					});
				</script>
    <script type="text/javascript">
		   
	    function refresh(obj) {
	        //var num = Math.ceil(Math.random() * 100);
	        //obj.src = "yzm.aspx?Num=" + num;
	    	$.ajax({
				type:'POST',
				url:"/refreshCode",
				dataType:'json',
				success:function(data){
					if(data.code == 0){
						obj.src = "/verify-code/" + data.result;
					}else{
					}
				}
			});
	    }
    </script>
</head>
<body><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/login.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/login.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/login.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/login.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/login.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="http://osd.greenleafgroup.cn/login.aspx" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    <form name="form1" method="post" action="/user/login" id="form1">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="fa616666-74a9-42ee-9819-0f5a33eb2541">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="011704.10895">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTU3MjE0NzQzMWRkLkAUPZSenysGYwW+nHPoWxly1K4=">
<input type="hidden" id="error" value="${error}"/>
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBQLNu+SRCgLMv+OiBQK1qbSRCwKn34LlBALCi9reA+OgGOv90g4CFydH0ifvKtGpK0kc">
</div>
        <div class="page-container">
            <div class="main_box">
                <div class="login_box">
                    <div class="login_logo">
					<h1>购物平台</h1>
                        <!--<img src="images/logo.png" style="width:100%">-->
                    </div>
                    
                    <div class="login_form">
                        
                            <div class="form-group">
                                <label for="j_username" class="t"><font color="black">会员编号：</font></label>
                                <input name="code" type="text" id="code" tabindex="1" class="form-control x319 in">

                            </div>
                            <div class="form-group">
                                <label for="j_password" class="t"><font color="black">登陆密码：</font></label>
                                <input name="loginPassword" type="password" id="loginPassword" class="password form-control x319 in" tabindex="2">
                            </div>
                            <div class="form-group">
                                <label for="j_captcha" class="t"><font color="black">验证码：</font></label>
                                <input name="kaptcha" type="text" id="kaptcha" maxlength="4" tabindex="3" class="form-control x164 in">
                                <img src="/verify-code/${code}" onclick="refresh(this)" class="m" title="看不清楚？点击换一个" alt="看不清楚？点击换一个" style="height: 32px; width: 80px; border-width: 0px;">
                            </div>

                            <div class="form-group space">
                                <input type="submit" name="btnSubmit" value=" 登 录 " onclick="return jQuery.formValidator.PageIsValid(1);" id="btnSubmit" tabindex="4" src="images/login.jpg" class="btn btn-primary btn-lg" style="margin-left:100px;">
                               <!-- &nbsp;&nbsp;&nbsp;&nbsp;
                                 <a class="btn btn-primary btn-lg" href="javascript:void(0)" onclick="$.dialog({id: 'a3_3' ,title: '找回密码',content: 'url:/m_zhaohui.aspx',max:false,min:false,width: '400px', height: '300px',lock:true,padding:0});">找回密码</a>
                                -->
							</div>
                        
                    </div>
                </div>
                <div class="bottom"></div>
            </div>
        </div></form>

        <!-- Javascript -->

        <script src="/js/supersized.3.2.7.min.js"></script>
        <script src="/js/supersized-init.js"></script>
        <script src="/js/scripts.js"></script>
        <div style="text-align: center;">
            <p></p>
        </div>

    

<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div><ul id="supersized" class="quality" style="visibility: visible;"><li class="slide-0 activeslide"><a target="_blank"><img src="/js/3.jpg" style="height: 721.92px; width: 1536px; left: 0px; top: -5.5px;"></a></li></ul></body></html>