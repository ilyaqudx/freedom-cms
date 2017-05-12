<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0053)http://osd.greenleafgroup.cn/member/withdraw/add.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="js-before.jsp"/>
	<link href="/js/style.css" rel="stylesheet" type="text/css">
	<link href="/js/font-awesome.css" rel="stylesheet">
	<link href="/js/icon-font.min.css" rel="stylesheet" type="text/css">
	<link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
    <script src="/js/WdatePicker.js"></script><link href="/js/WdatePicker.css" rel="stylesheet" type="text/css">

     <script src="/js/formValidator.js" type="text/javascript"></script>
    <script src="/js/formValidatorRegex.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.formValidator.initConfig({ onError: function (msg) { alert(msg) } });

            $("#payPassword").formValidator().InputValidator({ min: 1, onerror: "请输入二级密码" });
            $("#amount").formValidator().InputValidator({ min: 1, onerror: "请输入提现金额" });
            $("#amount").formValidator().InputValidator({ min: 2, max: 8, onerror: "你输入的提现金额有问题,请修改" })
                 .RegexValidator({ regexp: "^[1-9][0-9]*0{2}$",onerror: "提现金额必须是100的整数倍，请重新输入！"});
            //$("#txtMemo").formValidator().InputValidator({ min: 1, onerror: "请输入提现描述" });
            
            var error = "${error}";
            if(error){
            	alert(error);
            }
        });

    </script>
</head>

<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/withdraw/add.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="http://osd.greenleafgroup.cn/member/withdraw/add.aspx" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div><div style="position: absolute; z-index: 19700; top: -1970px; left: -1970px; display: none;"><iframe src="/js/My97DatePicker.html" frameborder="0" border="0" scrolling="no" style="width: 186px; height: 198px;"></iframe></div>
    <form name="form2" method="post" action="/order/add" id="form2">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="57a29d42-b8c0-4037-814d-83cd31d6427f">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="104021.50444">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTc2MzM4OTI3Mg9kFgICAw9kFg4CAQ9kFhICAQ8WAh4Fc3R5bGUFEGRpc3BsYXk6ZGlzcGxheTtkAgIPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCAw8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIEDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgUPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBg8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIHDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAggPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCCQ8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIDD2QWBgIBDxYCHgtfIUl0ZW1Db3VudAIFFgpmD2QWAmYPFQMDMTY2D+WVhuWfjuWNleWFrOWRihEyMDE3LzUvNiAxMTowNTo1MGQCAQ9kFgJmDxUDAzE2NA81LjHmlL7lgYflhazlkYoSMjAxNy80LzE4IDEwOjQ2OjIxZAICD2QWAmYPFQMDMTYzDOe+juWYieWFrOWRihIyMDE3LzQvMTQgMTI6NDg6MTBkAgMPZBYCZg8VAwMxNjE25YWz5LqO5pS26LSn5rOo5oSP5LqL6aG55Y+K44CK5pS26LSn5byC5bi46KGo44CL5aGr5YaZETIwMTcvNC81IDE0OjM5OjM1ZAIED2QWAmYPFQMDMTYwHTIwMTflubQ05pyI5L+D6ZSA5rS75Yqo6YCa55+lETIwMTcvNC8yIDEwOjQzOjI4ZAIDDxYCHglpbm5lcmh0bWwFBuWnmuWFsGQCBA8WAh8CBQbkvJrlkZhkAgUPDxYCHgRUZXh0BQYxOTcuNTBkZAILDw8WAh8DBRLkuK3lm73lhpzkuJrpk7booYxkZAINDw8WAh8DBRM2MjI4NDgzODU4OTkxODUwMDcyZGQCDw8PFgIfAwUG5aea5YWwZGQCEQ8PFgIfAwUM5be05Lit5pSv6KGMZGRkzYYz1TROXdbPXpzRJuCMjS0G/IE=">
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWCQLukfbTBALyl+jzBwLvl8K2CQLChNiQDAKT0NmrDALlnIiMAwKjp9jUDgKdxIzyBwLCi9reA8Xfoy0lL9D8TeQWdTBG1paB9IXR">
</div>
        <section>
            
<jsp:include page="header.jsp"/>

            <div class="main-content">
                
<jsp:include page="top.jsp"/>
                <div id="page-wrapper">
                    <div class="graphs">

                        <div class="col_12">
                            <div class="row">
                                <!-- 钱包信息 -->
                                <div class="col-md-12 col-lg-12">
                                    <div class="panel panel-widget">
										<input type="hidden" id="userId" name="userId" value="${user.id }"/>
                                        <div class="panel-body form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-6 control-label form-label"><b style="font-size: 18px">提现操作</b></label>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">奖金币</label>
                                                <div class="col-sm-6">
                                                    <input name="txtM3Balance" type="text" value="197.50" id="txtM3Balance" disabled="disabled" class="form-control">
                                                </div>
                                            </div>
                                           
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">二级密码</label>
                                                <div class="col-sm-6">
                                                   <input name="payPassword" type="password" id="payPassword" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">提现金额</label>
                                                <div class="col-sm-6">
                                                    <input name="amount" type="text" id="amount" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">开户行</label>
                                                <div class="col-sm-6">
                                                    <input name="bank" type="text" value="${user.bank }" id="bank" disabled="disabled" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">银行帐号</label>
                                                <div class="col-sm-6">
                                                    <input name="bankAccount" type="text" value="${user.bankAccount }" id="bankAccount" disabled="disabled" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">开户人</label>
                                                <div class="col-sm-6">
                                                    <input name="bankAccountName" type="text" value="${user.bankAccountName }" id="bankAccountName" disabled="disabled" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">银行地址</label>
                                                <div class="col-sm-6">
                                                    <input name="bankAddress" type="text" value="${user.bankAddress }" id="bankAddress" disabled="disabled" class="form-control">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label form-label"></label>
                                                <div class="col-sm-10">
                                                    <input type="submit" name="btnSubmit" value="提交" onclick="return jQuery.formValidator.PageIsValid(&#39;1&#39;);" id="btnSubmit" class="btn btn-default">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="js-after.jsp"/>
    </form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 506px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1536px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; left: 49px; height: 711px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99); top: 708px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div></body></html>