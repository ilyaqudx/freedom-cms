<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0051)http://osd.greenleafgroup.cn/member/member/add.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1"><link href="/js/bootstrap.min.css" rel="stylesheet" type="text/css"><link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>

    <script src="/js/formValidator.js" type="text/javascript"></script>
    <script src="/js/formValidatorRegex.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $.formValidator.initConfig({ onError: function (msg) { alert(msg) } });
            $("#recommender").formValidator().InputValidator({ min: 2, max: 20, onerror: "请输入2-20位的推荐人编号" });
            //$("#code").formValidator().InputValidator({ min: 6, max: 20, onerror: "你输入的手机号有问题,请修改" })
            //    .RegexValidator({ regexp: "mobile", datatype: "enum", onerror: "手机格式不正确，此为必填项" });
            $("#settler").formValidator().InputValidator({ min: 2, max: 20, onerror: "请输入2-20位的安置人编号" });
            $("#name").formValidator().InputValidator({ min: 2, max: 30, onerror: "请输入2-30位的会员姓名" });
            $("#code").formValidator().InputValidator({ min: 5, max: 20, onerror: "请输入5-20位的会员编号" });
            $("#phone").formValidator().InputValidator({ min: 6, max: 20, onerror: "你输入的手机号有问题,请修改" })
                .RegexValidator({ regexp: "mobile", datatype: "enum", onerror: "手机格式不正确，此为必填项" });

            $("#identityCode").formValidator().InputValidator({ min: 10, max: 18, onerror: "请输入18位的身份证号" });
            $("#loginPassword").formValidator().InputValidator({ min: 6,max:6, onerror: "请输入6位数的密码" });
            $("#loginPassword2").formValidator().InputValidator({ min: 1, onerror: "一级确认密码不能为空,请确认" })
                .CompareValidator({ desID: "loginPassword", operateor: "=", onerror: "一级两次输入不一致,请修正" });
            $("#payPassword").formValidator().InputValidator({ min: 6,max:6, onerror: "请输入6位数的二级密码" });
            $("#payPassword2").formValidator().InputValidator({ min: 1, onerror: "二级确认密码密码不能为空,请修改" })
                .CompareValidator({ desID: "payPassword", operateor: "=", onerror: "二级密码二次输入不一致,请确认" });

            $("#bankAccount").formValidator().InputValidator({ min: 5, max: 25, onerror: "请输入5-25位的银行账号" });
            $("#bankAccountName").formValidator().InputValidator({ min: 2, max: 30, onerror: "请输入2-30位的开户姓名" });
            $("#bankAddress").formValidator().InputValidator({ min: 5, max: 30, onerror: "请输入5-30位的开户地址" });

            $("#receivingAddress").formValidator().InputValidator({ min:4, max: 30, onerror: "请输入4-60位的收货地址" });


        });
        function checkForm() {
            var bn = false;
            if (jQuery.formValidator.PageIsValid('1')) {
                var rloginName = $("#code").val();
                var idNumber = $("#phone").val();
                var name = $("#name").val();

                if (window.confirm('帐号:' + rloginName + '\r姓名:' + name + '\手机号:' +
                    idNumber + '\r确认提交吗？')) {
                    bn = true;
                }
            }
            return bn;
        }
        
        function refreshCode()
        {
        	$.ajax({
    			type:'POST',
    			url:"/user/refreshCode",
    			dataType:'json',
    			success:function(data){
    				if(data.code == 0){
    					$("#code").val(data.result);
    				}else{
    				}
    			}
    		});
        }
        
        //验证推荐人或安置人编号是否存在
        function checkCodeIsExist(type){
        	//type : 1-推荐人验证，2-安置人验证
        	var code;
        	if(type == 1){
        		code = $("#recommender").val();
        		if(!code)
        		{
        			alert("请输入推荐人编号");		
        			return;	
        		}
        	}else if(type == 2){
        		code = $("#settler").val();
	        	if(!code){
	        		alert("请输入安置人编号");
	        		return;
	        	}
        	}else if(type == 3){
        		code = $("code").val();
        	}
        	
        	var params = "type="+type+"&code="+code;
        	$.ajax({
    			type:'POST',
    			url:"/user/checkCode?"+params,
    			dataType:'json',
    			success:function(data){
    				if(data.code == 0){
    					if(type == 1){
    						alert("推荐人编号有效");
    					}
    					else if(type == 2){
    						alert("安置人编号有效");
    					}else{
    						alert("会员编号有效");
    					}
    				}else{
    					if(type == 1){
    						alert("推荐人编号无效");
    					}
    					else if(type == 2){
    						alert("安置人编号无效");
    					}else{
    						alert("会员编号无效");
    					}
    				}
    			}
    		});
        }
        
        function cascadeRegion(type,obj){
        	var value = $(obj).find('option:selected').val();
        	alert(value);
        	
        	$.ajax({
    			type:'POST',
    			url:"/region/cascade?regionName="+value,
    			dataType:'json',
    			success:function(data){
    				if(data.code == 0){
    					if(type == 1){
    						//市
    						$("#city option").remove();
    						
    						//添加
    						var citys = JSON.parse(data.result);
    						$("#city").append("<option value='-1'>选择城市</option>");
    						for(var i = 0;i < citys.length;i++){
    							var city = citys[i];
    							$("#city").append("<option value='"+city+"'>"+city+"</option>");
    						}
    					}
    				}else{
    					
    				}
    			}
    		});
        }
    </script>
</head>
<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/member/add.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/member/add.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/member/add.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/member/add.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/member/add.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    <form name="form1" method="post" action="/user/add" id="form1">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="2465e4fa-f7bc-4fec-83ad-b57a7a0fcb22">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="113448.04771">
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="">
<input type="hidden" name="__LASTFOCUS" id="__LASTFOCUS" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTI4NzYzNTgzMA9kFgICAw9kFg4CAw9kFhICAQ8WAh4Fc3R5bGUFEGRpc3BsYXk6ZGlzcGxheTtkAgIPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCAw8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIEDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgUPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBg8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIHDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAggPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCCQ8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIFD2QWCAIBDxYCHgtfIUl0ZW1Db3VudAIFFgpmD2QWAmYPFQMDMTY2D+WVhuWfjuWNleWFrOWRihEyMDE3LzUvNiAxMTowNTo1MGQCAQ9kFgJmDxUDAzE2NA81LjHmlL7lgYflhazlkYoSMjAxNy80LzE4IDEwOjQ2OjIxZAICD2QWAmYPFQMDMTYzDOe+juWYieWFrOWRihIyMDE3LzQvMTQgMTI6NDg6MTBkAgMPZBYCZg8VAwMxNjE25YWz5LqO5pS26LSn5rOo5oSP5LqL6aG55Y+K44CK5pS26LSn5byC5bi46KGo44CL5aGr5YaZETIwMTcvNC81IDE0OjM5OjM1ZAIED2QWAmYPFQMDMTYwHTIwMTflubQ05pyI5L+D6ZSA5rS75Yqo6YCa55+lETIwMTcvNC8yIDEwOjQzOjI4ZAIDDxYCHwFmZAIFDxYCHglpbm5lcmh0bWwFBuWnmuWFsGQCBg8WAh8CBQbkvJrlkZhkAg8PEGQPFgJmAgEWAhAFB0HluILlnLoFATFnEAUHQuW4guWcugUBMmdkZAIRDxAPFgYeDURhdGFUZXh0RmllbGQFCUxldmVsTmFtZR4ORGF0YVZhbHVlRmllbGQFAklEHgtfIURhdGFCb3VuZGdkEBUBBuS8muWRmBUBATEUKwMBZ2RkAhMPDxYCHgRUZXh0BQdhMDc2NTMzZGQCHw8QDxYGHwMFC0NvbmZpZ1ZhbHVlHwQFC0NvbmZpZ1ZhbHVlHwVnZBAVDRLkuK3lm73lhpzkuJrpk7booYwS5Lit5Zu95bu66K6+6ZO26KGMDOS4reWbvemTtuihjBLkuK3lm73lt6XllYbpk7booYwS5Lit5Zu95Lqk6YCa6ZO26KGMDOaLm+WVhumTtuihjAzpgq7mlL/lgqjok4QM5rWm5Y+R6ZO26KGMDOW5s+WuiemTtuihjAzlhYnlpKfpk7booYwM5rCR55Sf6ZO26KGMDOW5v+WPkemTtuihjAzkuK3kv6Hpk7booYwVDRLkuK3lm73lhpzkuJrpk7booYwS5Lit5Zu95bu66K6+6ZO26KGMDOS4reWbvemTtuihjBLkuK3lm73lt6XllYbpk7booYwS5Lit5Zu95Lqk6YCa6ZO26KGMDOaLm+WVhumTtuihjAzpgq7mlL/lgqjok4QM5rWm5Y+R6ZO26KGMDOW5s+WuiemTtuihjAzlhYnlpKfpk7booYwM5rCR55Sf6ZO26KGMDOW5v+WPkemTtuihjAzkuK3kv6Hpk7booYwUKwMNZ2dnZ2dnZ2dnZ2dnZ2RkAicPZBYCZg9kFgYCAQ8QDxYGHwMFBXNoZW5nHwQFBXNoZW5nHwVnZBAVIwzpgInmi6nnnIHku70G5YyX5LqsBuWkqea0pQbkuIrmtbcG6YeN5bqGBuays+WMlwblsbHopb8G6L695a6BBuWQieaelwnpu5HpvpnmsZ8G5rGf6IuPBua1meaxnwblronlvr0G56aP5bu6Buaxn+ilvwblsbHkuJwG5rKz5Y2XBua5luWMlwbmuZbljZcG5bm/5LicBua1t+WNlwblm5vlt50G6LS15beeBuS6keWNlwbpmZXopb8G55SY6IKDBumdkua1twnlhoXokpnlj6QG5bm/6KW/Builv+iXjwblroHlpI8G5paw55aGBummmea4rwbmvrPpl6gG5Y+w5rm+FSMCLTEG5YyX5LqsBuWkqea0pQbkuIrmtbcG6YeN5bqGBuays+WMlwblsbHopb8G6L695a6BBuWQieaelwnpu5HpvpnmsZ8G5rGf6IuPBua1meaxnwblronlvr0G56aP5bu6Buaxn+ilvwblsbHkuJwG5rKz5Y2XBua5luWMlwbmuZbljZcG5bm/5LicBua1t+WNlwblm5vlt50G6LS15beeBuS6keWNlwbpmZXopb8G55SY6IKDBumdkua1twnlhoXokpnlj6QG5bm/6KW/Builv+iXjwblroHlpI8G5paw55aGBummmea4rwbmvrPpl6gG5Y+w5rm+FCsDI2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnFgFmZAIDDxAPFgYfAwUDc2hpHwQFA3NoaR8FZ2QQFQEM6YCJ5oup5Z+O5biCFQECLTEUKwMBZxYBZmQCBQ8QDxYGHwMFBHhpYW4fBAUEeGlhbh8FZ2QQFQEN6YCJ5oup5Y6/L+WMuhUBAi0xFCsDAWdkZGR1YzS8XJyWpm/vCm1jP70xvpS0aw==">
</div>

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<script src="/js/WebResource.axd" type="text/javascript"></script>


<script src="/js/ScriptResource.axd" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
if (typeof(Sys) === 'undefined') throw new Error('ASP.NET Ajax 客户端框架未能加载。');
//]]>
</script>

<script src="/js/ScriptResource(1).axd" type="text/javascript"></script>
<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWSwLt38HTAgLZycrPBgLymsLnBgKy+/aQCgKM8ov8CwLFlpm0DgLElpm0DgLf74uIBQKpwK/OBgLi/d63BALAn+vmDALEhISFCwKxhYrZCQKRiffwAwLdkf73CgLLrPeYCwLVv56nBgKQ6auABAL1y9DeCALb5/WbBgLe2IQbApz4gc4FAuOervAFAsmA9v4FAoH6iRwC556OzgUC1b/O0AQClI/H4QwCyO7plAECvoysnwgCnPv8sQ4Cn5Sa3AICtarHqA8Cm6brtAECuoCztgEC/7fsqw4Ckc2zxwEC06yTlgsCj4PYgw4Cu7yzYwLS37/BAQLtzNPNCgLrzpOhAQK7m4ugDgK95/+tDgLtzJOWCwLTrIevDwKRzbPJAQL2wLPHAQL2wLPJAQLNoIevDwLVzrPJAQLpsYu1DgKXjoy1DgKzgbPJAQL3sJCWCwKk/uPbCgLysrC2AQKNwNCVBgLNoJOWCwLNhtD1CgKDm9OXDgKM3+/zAwKrp9CsAQKRw7fyDQLMq4+uAQKIwfGaBQKLrpf3CQKYlNKEBwLv7ITZAgLW44bXBAKFqK2XBgLvl/62CQLvl4q3CQKLk6mvApVfhmybViZpp2DT8+wUpQ5CTIKi">
</div>
        <script type="text/javascript">
//<![CDATA[
Sys.WebForms.PageRequestManager._initialize('ac1', document.getElementById('form1'));
Sys.WebForms.PageRequestManager.getInstance()._updateControls(['tup1'], [], [], 90);
//]]>
</script>

        <section>
            
<div class="left-side sticky-left-side" tabindex="5000" style="overflow: hidden; outline: none;">
    <div class="logo">
        <h1><a href="http://osd.greenleafgroup.cn/member/index.aspx">会员管理系统</a></h1>
    </div>
    <div class="logo-icon text-center">
        <a href="http://osd.greenleafgroup.cn/member/index.aspx"><i class="lnr lnr-home"></i></a>
    </div>

    <div class="left-side-inner">
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#"><i class="lnr lnr-envelope"></i><span>新闻公告</span></a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/message/notice.aspx">新闻公告</a> </li>
                    <li><a href="http://osd.greenleafgroup.cn/member/message/consulting.aspx">申诉反馈</a></li>
                </ul>
            </li>
            <li><a href="http://osd.greenleafgroup.cn/member/member/team.aspx">
                <i class="lnr lnr-bus"></i><span>团队信息</span></a>
            </li>

            

            
            
            
            
            
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#"><i class="lnr lnr-user"></i>
                    <span>专卖店管理</span></a>
                <ul class="sub-menu-list">
                    <li id="left_li_ask" style="display: none"><a href="http://osd.greenleafgroup.cn/member/member/ask.aspx">开店申请</a></li>
                    <li id="left_li_shop_1" style="display:display;"><a href="/user/add">会员注册</a></li>
                    <li id="left_li_shop_2" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/auditing.aspx">会员激活</a></li>
                    <li id="left_li_shop_5" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/slist.aspx">会员激活列表</a></li>

                </ul>
            </li>

            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#">
                    <i class="lnr lnr-cart"></i><span>购物管理</span>
                </a>
                <ul class="sub-menu-list">
                    <li id="left_li_shop_7" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/order/auditing.aspx">待审核订单</a></li>
                    <li id="left_li_shop_6" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/order/send.aspx">待发货订单</a></li>
                    <li id="left_li_shop_8" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/order/list.aspx">已发货订单</a></li>
                    <li id="left_li_shop_3" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/order/regOrder1.aspx">商城购物</a></li>
                    <li id="left_li_shop_4" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/up.aspx">复消录入</a></li>
                    <li id="left_li_shop_9" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/upList.aspx">复消录入记录</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/member/upList1.aspx">复消记录</a></li>
                </ul>
            </li>
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#">
                    <i class="lnr lnr-sun"></i><span>财务管理</span>
                </a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/recharge/add.aspx">汇款操作</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/recharge/list.aspx">汇款记录</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx">提现操作</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx">提现记录</a></li>
                </ul>
            </li>
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#">
                    <i class="lnr lnr-moon"></i><span>货币管理</span>
                </a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/transform/add.aspx">货币转换操作</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/transform/list.aspx">货币转换记录</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/transfer/add.aspx">会员转账</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/transfer/list.aspx">转账记录</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/bonus/water.aspx">财务流水</a></li>
                </ul>
            </li>


            <li><a href="http://osd.greenleafgroup.cn/member/bonus/bonusday.aspx">
                <i class="lnr lnr-pie-chart"></i><span>奖金记录</span></a>
            </li>

            <li class="menu-list"><a href="http://osd.greenleafgroup.cn/member/member/add.aspx#">
                <i class="lnr lnr-cog"></i><span>帐号管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/info.aspx">个人资料</a></li>
                    <li><a href="http://osd.greenleafgroup.cn/member/updpwd.aspx">安全设置</a></li>
                </ul>
            </li>

            <li><a href="http://osd.greenleafgroup.cn/member/layout.aspx">
                <i class="lnr lnr-exit"></i><span>安全退出</span></a>
            </li>

        </ul>

    </div>
</div>

            <div class="main-content">
                
<div class="header-section">
    <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
    <div class="menu-right">

        <div class="user-panel-top">
            <div class="profile_details_left">
                <ul class="nofitications-dropdown">

                    
                   
                    <li class="dropdown">
                        <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                             <span>最新公告</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="notification_header">
                                    <h3>最新公告</h3>
                                </div>
                            </li>
                            
                                    <li>
                                        <a href="javascript:void(0)" onclick="showMessaggeInfo(166)">
                                            <div class="notification_desc">
                                                <p>商城单公告</p>
                                                <p><span>2017/5/6 11:05:50</span></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </a>
                                    </li>
                                
                                    <li>
                                        <a href="javascript:void(0)" onclick="showMessaggeInfo(164)">
                                            <div class="notification_desc">
                                                <p>5.1放假公告</p>
                                                <p><span>2017/4/18 10:46:21</span></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </a>
                                    </li>
                                
                                    <li>
                                        <a href="javascript:void(0)" onclick="showMessaggeInfo(163)">
                                            <div class="notification_desc">
                                                <p>美嘉公告</p>
                                                <p><span>2017/4/14 12:48:10</span></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </a>
                                    </li>
                                
                                    <li>
                                        <a href="javascript:void(0)" onclick="showMessaggeInfo(161)">
                                            <div class="notification_desc">
                                                <p>关于收货注意事项及《收货异常表》填写</p>
                                                <p><span>2017/4/5 14:39:35</span></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </a>
                                    </li>
                                
                                    <li>
                                        <a href="javascript:void(0)" onclick="showMessaggeInfo(160)">
                                            <div class="notification_desc">
                                                <p>2017年4月促销活动通知</p>
                                                <p><span>2017/4/2 10:43:28</span></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </a>
                                    </li>
                                
                            <li>
                                <div class="notification_bottom">
                                    <a href="http://osd.greenleafgroup.cn/member/message/notice.aspx">查看更多</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="http://osd.greenleafgroup.cn/member/member/add.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span>申诉</span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="notification_header">
                                    <h3>最新申诉</h3>
                                </div>
                            </li>
                            
                            
                        </ul>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="profile_details">
                <div class="profile_img">
                    <span style="background: url(/member/images/8.jpg) no-repeat center"></span>
                    <div class="user-name">
                        <p><b id="top_p_name">姚兰</b><span id="top_p_level">会员</span></p>
                    </div>
                    <div class="clearfix"></div>
                </div>

                <div class="clearfix"></div>
            </div>
           
            <div class="clearfix"></div>
        </div>

    </div>
</div>

                <div id="page-wrapper">
                    <div class="graphs">
                        <div class="content">
                            <div class="container-padding">
                                <!-- Start Row -->
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-body form-horizontal">
                                                <div class="form-group">
                                                    <label for="input002" class="col-sm-2 control-label form-label">推荐人编号*</label>
                                                    <div class="col-sm-6">
                                                        <input name="recommender" type="text" id="recommender" class="form-control">
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="button" onclick="checkCodeIsExist(1,this)" name="btnCheckRecommend" value="验证" id="btnCheckRecommend" class="btn btn-default">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input002" class="col-sm-2 control-label form-label">安置人编号*</label>
                                                    <div class="col-sm-6">
                                                        <input name="settler" type="text" id="settler" class="form-control">
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="button" onclick="checkCodeIsExist(2,this)" name="btnCheckAZ" value="验证" id="btnCheckAZ" class="btn btn-default">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input2" class="col-sm-2 control-label form-label">市场位置*</label>
                                                    <div class="col-sm-6">
                                                        <select name="ddlLocation" id="ddlLocation" class="selectpicker" style="height:30px;">
	<option selected="selected" value="1">A市场</option>
	<option value="2">B市场</option>

</select>
                                                    </div>
                                                </div>
                                                <div class="form-group" style="display:none;">
                                                    <label for="input2" class="col-sm-2 control-label form-label">注册级别*</label>
                                                    <div class="col-sm-6">
                                                        <select name="ddlLevel" id="ddlLevel" class="selectpicker" style="height:30px;">
	<option selected="selected" value="1">会员</option>

</select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="input002" class="col-sm-2 control-label form-label">会员编号*</label>
                                                    <div class="col-sm-6">
                                                        <input name="code" type="text" value="${user.code }" id="code" readonly="readonly" class="form-control">
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="button" onclick="checkCodeIsExist(3)" name="btnCheckLoginName" value="验证" id="btnCheckLoginName" class="btn btn-default">
                                                        <input type="button" onclick="refreshCode()" name="btnRefresh" value="刷新" id="btnRefresh" class="btn btn-default">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">会员姓名*</label>
                                                    <div class="col-sm-6">
                                                        <input name="name" value="${user.name }" type="text" onchange="javascript:setTimeout(&#39;__doPostBack(\&#39;name\&#39;,\&#39;\&#39;)&#39;, 0)" onkeypress="if (WebForm_TextBoxKeyHandler(event) == false) return false;" id="name" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">联系手机*</label>
                                                    <div class="col-sm-6">
                                                        <input name="phone" value="${user.phone }" type="text" id="phone" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">身份证号*</label>
                                                    <div class="col-sm-6">
                                                        <input name="identityCode" type="text" value="${user.identityCode }" id="identityCode" class="form-control">
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <label for="input2" class="col-sm-2 control-label form-label">银行名称*</label>
                                                    <div class="col-sm-6">
                                                        <select name="bank" id="bank" class="selectpicker" style="height:30px;">
	<!-- <option selected="selected" value="中国农业银行">中国农业银行</option>
	<option value="中国建设银行">中国建设银行</option>
	<option value="中国银行">中国银行</option>
	<option value="中国工商银行">中国工商银行</option>
	<option value="中国交通银行">中国交通银行</option>
	<option value="招商银行">招商银行</option>
	<option value="邮政储蓄">邮政储蓄</option>
	<option value="浦发银行">浦发银行</option>
	<option value="平安银行">平安银行</option>
	<option value="光大银行">光大银行</option>
	<option value="民生银行">民生银行</option>
	<option value="广发银行">广发银行</option>
	<option value="中信银行">中信银行</option> -->
	<c:forEach items="${banks}" var="bank" >
		<option value="${ bank.name}">${bank.name }</option>
	</c:forEach>
</select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">银行帐号*</label>
                                                    <div class="col-sm-6">
                                                        <input value="${user.bankAccount }" name="bankAccount" type="text" id="bankAccount" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">开户人*</label>
                                                    <div class="col-sm-6">
                                                        <input name="bankAccountName" value="林磊" type="text" id="bankAccountName" readonly="readonly" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">开户行地址*</label>
                                                    <div class="col-sm-6">
                                                        <input name="bankAddress" type="text" id="bankAddress" class="form-control">
                                                    </div>
                                                </div>
                                                <div id="up1">
	
                                                        <div class="form-group">
                                                            <label for="input2" class="col-sm-2 control-label form-label">省市区*</label>
                                                            <div class="col-sm-6">
                                                                <select id="province" name="province" onchange="cascadeRegion(this)" style="height:30px;">
		<option selected="selected" value="-1">选择省份</option>
		<c:forEach items="${ provinces}" var="province">
			<option value="${province }">${province }</option>
		</c:forEach>
	</select>
                                                                <select id="city" name="city" onchange="cascadeRegion(this)" style="height:30px;">
		<option selected="selected" value="-1">选择城市</option>

	</select>
                                                                <select id="area" name="area" id="area" style="height:30px;">
		<option selected="selected" value="-1">选择县/区</option>

	</select>
                                                            </div>
                                                        </div>                                   
                                                    
</div>
                                                <div class="form-group">
                                                    <label for="input001" class="col-sm-2 control-label form-label">收货地址</label>
                                                    <div class="col-sm-6">
                                                        <input name="receivingAddress" type="text" id="receivingAddress" class="form-control">
                                                    </div>
                                                </div>
                                               

                                                <div class="form-group">
                                                    <label for="input3" class="col-sm-2 control-label form-label">一级密码*</label>
                                                    <div class="col-sm-6">
                                                        <input name="loginPassword" type="password" id="loginPassword" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input3" class="col-sm-2 control-label form-label">一级密码确认*</label>
                                                    <div class="col-sm-6">
                                                        <input name="loginPassword2" type="password" id="loginPassword2" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input3" class="col-sm-2 control-label form-label">二级密码*</label>
                                                    <div class="col-sm-6">
                                                        <input name="payPassword" type="password" id="payPassword" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="input3" class="col-sm-2 control-label form-label">二级密码确认*</label>
                                                    <div class="col-sm-6">
                                                        <input name="payPassword2" type="password" id="payPassword2" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label form-label"></label>
                                                    <div class="col-sm-10">
                                                        <input type="submit" name="btnReg" value="确认注册" onclick="return checkForm();" id="btnReg" class="btn btn-default">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <!-- End Row -->

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
        <script src="/js/jquery.nicescroll.js"></script>
        <script src="/js/scripts.js"></script>
        <script src="/js/bootstrap.min.js"></script>
    

<script type="text/javascript">
//<![CDATA[
Sys.Application.initialize();
//]]>
</script>
</form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 5px; height: 429px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 5px; width: 1366px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; cursor: default; position: fixed; top: 0px; left: 49px; height: 667px; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; top: 664px; left: 0px; position: fixed; cursor: default; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 3px; width: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; pointer-events: none; background: rgb(255, 255, 255);"></div></body></html>