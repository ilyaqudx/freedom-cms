<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0045)javascript:void(0) -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js-before.jsp"/>
<link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
</head>

<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="javascript:void(0)###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="javascript:void(0)###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="javascript:void(0)###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="javascript:void(0)###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="javascript:void(0)###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="javascript:void(0)" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    <form name="form1" method="post" action="/user/update" id="form1">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="7e0be8d1-311a-4400-a7fc-56c3d4f21a90">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="113816.76934">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwULLTIwODU0MDc4NDcPZBYCAgMPZBYcAgEPZBYSAgEPFgIeBXN0eWxlBRBkaXNwbGF5OmRpc3BsYXk7ZAICDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgMPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBA8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIFDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgYPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBw8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIIDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgkPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCAw9kFgYCAQ8WAh4LXyFJdGVtQ291bnQCBRYKZg9kFgJmDxUDAzE2Ng/llYbln47ljZXlhazlkYoRMjAxNy81LzYgMTE6MDU6NTBkAgEPZBYCZg8VAwMxNjQPNS4x5pS+5YGH5YWs5ZGKEjIwMTcvNC8xOCAxMDo0NjoyMWQCAg9kFgJmDxUDAzE2Mwznvo7lmInlhazlkYoSMjAxNy80LzE0IDEyOjQ4OjEwZAIDD2QWAmYPFQMDMTYxNuWFs+S6juaUtui0p+azqOaEj+S6i+mhueWPiuOAiuaUtui0p+W8guW4uOihqOOAi+Whq+WGmREyMDE3LzQvNSAxNDozOTozNWQCBA9kFgJmDxUDAzE2MB0yMDE35bm0NOaciOS/g+mUgOa0u+WKqOmAmuefpREyMDE3LzQvMiAxMDo0MzoyOGQCAw8WAh4JaW5uZXJodG1sBQblp5rlhbBkAgQPFgIfAgUG5Lya5ZGYZAIFDxYCHwIFB2EwNjIwNTBkAgcPFgIfAgUHYTU4NTM4MWQCCQ8WAh8CBQdhNTg1MzgxZAILDxYCHwIFBuS8muWRmGQCDQ8WAh8CBREyMDE3LzQvNCAyMToyMzoxNWQCDw8WAh8CBREyMDE3LzQvNCAyMToyMzoyOWQCEQ8PFgIeBFRleHQFEjUxMzcwMTE5ODEwOCoqKioqKmRkAhUPDxYCHwMFBuWnmuWFsGRkAhcPEA8WBh4NRGF0YVRleHRGaWVsZAULQ29uZmlnVmFsdWUeDkRhdGFWYWx1ZUZpZWxkBQtDb25maWdWYWx1ZR4LXyFEYXRhQm91bmRnZBAVDRLkuK3lm73lhpzkuJrpk7booYwS5Lit5Zu95bu66K6+6ZO26KGMDOS4reWbvemTtuihjBLkuK3lm73lt6XllYbpk7booYwS5Lit5Zu95Lqk6YCa6ZO26KGMDOaLm+WVhumTtuihjAzpgq7mlL/lgqjok4QM5rWm5Y+R6ZO26KGMDOW5s+WuiemTtuihjAzlhYnlpKfpk7booYwM5rCR55Sf6ZO26KGMDOW5v+WPkemTtuihjAzkuK3kv6Hpk7booYwVDRLkuK3lm73lhpzkuJrpk7booYwS5Lit5Zu95bu66K6+6ZO26KGMDOS4reWbvemTtuihjBLkuK3lm73lt6XllYbpk7booYwS5Lit5Zu95Lqk6YCa6ZO26KGMDOaLm+WVhumTtuihjAzpgq7mlL/lgqjok4QM5rWm5Y+R6ZO26KGMDOW5s+WuiemTtuihjAzlhYnlpKfpk7booYwM5rCR55Sf6ZO26KGMDOW5v+WPkemTtuihjAzkuK3kv6Hpk7booYwUKwMNZ2dnZ2dnZ2dnZ2dnZ2RkAhsPDxYCHwMFBuWnmuWFsGRkAh8PFgIfAgUY5Zub5bed5be05Lit5biC5be05bee5Yy6ZAIhDw8WAh8DBRLkuInlsI/lrabmoKHlkI7pl6hkZGTsMrQcBerXZzRUDU4n9NLE+klRbw==">
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWFwLImIr6AQLxkvfwAwLrlNDEDgLEhISFCwLdkf73CgLLrPeYCwLVv56nBgKQ6auABAL1y9DeCALb5/WbBgLe2IQbApz4gc4FAuOervAFAsmA9v4FAoH6iRwC556OzgUC1b/O0AQClI/H4QwCyO7plAECvoysnwgC7+yE2QICi5OprwICtrXFsAqBo2knhacYWiHkDtRlgSNvWLkpJg==">
</div>
        <section>
            
<jsp:include page="header.jsp"/>

            <div class="main-content">
                
<jsp:include page="top.jsp"/>
                <div id="page-wrapper">
                    <div class="graphs">
                        <!-- Start Row -->
                        <div class="row">

                            <div class="col-md-12">
                                <div class="panel panel-default">

                                    <div class="panel-body form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">会员编号</label>
                                            <div class="col-sm-10">
                                                <p id="code" class="form-control-static">${user.code }</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">推荐人编号</label>
                                            <div class="col-sm-10">
                                                <p id="recommender" class="form-control-static">${user.recommender }</p>
                                            </div>
                                        </div>
                                          <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">安置人编号</label>
                                            <div class="col-sm-10">
                                                <p id="settler" class="form-control-static">${user.settler }</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">当前级别</label>
                                            <div class="col-sm-10">
                                                <p id="p_level" class="form-control-static">会员</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">注册日期</label>
                                            <div class="col-sm-10">
                                                <p id="createTime" class="form-control-static">
                                                	<fmt:formatDate value="${user.createTime }" pattern="yyyy/MM/dd HH:mm:ss"/>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">激活日期</label>
                                            <div class="col-sm-10">
                                                <p id="p_auditing_time" class="form-control-static">
                                                <fmt:formatDate value="${user.activationTime }" pattern="yyyy/MM/dd HH:mm:ss"/>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">身份证号</label>
                                            <div class="col-sm-6">
                                            	<input type="hidden" value="${user.id }" name="id"/>
                                                <input type="text" value="${user.identityCode }" id="identityCode" disabled="disabled" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">联系手机</label>
                                            <div class="col-sm-6">
                                                <input name="phone" type="text" value="${user.phone }" id="phone" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input001" class="col-sm-2 control-label form-label">会员姓名</label>
                                            <div class="col-sm-6">
                                                <input name="name" type="text" value="${user.name }" id="name" disabled="disabled" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input2" class="col-sm-2 control-label form-label">银行名称</label>
                                            <div class="col-sm-6">
                                                <select name="bank" id="bank" class="selectpicker" style="height:30px;">
                                                <c:forEach items="${banks }" var="bank">
	<option ${user.bank == bank.name ? "selected='selected'" : '' } value="${bank.name }">${bank.name }</option>
	</c:forEach>
</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input001" class="col-sm-2 control-label form-label">银行帐号</label>
                                            <div class="col-sm-6">
                                                <input name="bankAccount" type="text" value="${user.bankAccount }" id="bankAccount" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input001" class="col-sm-2 control-label form-label">开户人姓名</label>
                                            <div class="col-sm-6">
                                                <input name="bankAccountName" type="text" value="${user.bankAccountName }" id="bankAccountName" disabled="disabled" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="input001" class="col-sm-2 control-label form-label">开户行地址</label>
                                            <div class="col-sm-6">
                                                <input name="bankAddress" type="text" value="${user.bankAddress }" id="bankAddress" class="form-control">
                                            </div>
                                        </div>
                                         <div class="form-group">
                                            <label class="col-sm-2 control-label form-label">省市区</label>
                                            <div class="col-sm-10">
                                                <p id="p_Province" class="form-control-static">${user.province }${user.city }${user.area }</p>
                                            </div>
                                        </div>
                                         <div class="form-group">
                                            <label for="input001" class="col-sm-2 control-label form-label">详细地址</label>
                                            <div class="col-sm-6">
                                                <input name="receivingAddress" type="text" value="${user.receivingAddress }" id="receivingAddress" disabled="disabled" class="form-control">
                                            </div>
                                        </div>
                                       
                                       
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label form-label"></label>
                                            <div class="col-sm-10">
                                                <input type="submit" name="btnReg" value="确认修改" onclick="return jQuery.formValidator.PageIsValid(&#39;1&#39;);" id="btnReg" class="btn btn-default">
                                            </div>
                                        </div>


                                    </div>

                                </div>
                            </div>

                        </div>
                        <!-- End Row -->
                        <input type="hidden" name="hidCode" id="hidCode">
                    </div>
                </div>
            </div>

            <script src="/js/formValidator.js" type="text/javascript"></script>
            <script src="/js/formValidatorRegex.js" type="text/javascript"></script>

            <script type="text/javascript">
                $(document).ready(function () {

                    $.formValidator.initConfig({ onError: function (msg) { alert(msg) } });
                    $("#txtAccount").formValidator().InputValidator({ min: 5, max: 25, onerror: "请输入5-25位的银行账号" });
                    $("#txtAccountName").formValidator().InputValidator({ min: 2, max: 30, onerror: "请输入2-10位的开户姓名" });
                    $("#txtBankAddress").formValidator().InputValidator({ min: 5, max: 30, onerror: "请输入5-30位的开户地址" });
                    $("#txtAddress").formValidator().InputValidator({ min: 1, onerror: "请输入您的详细地址" });
                    //$("#txtZhifuBao").formValidator().InputValidator({ min: 1, onerror: "请输入您的支付宝帐号" });
                });
            </script>
            
        </section>
        <jsp:include page="js-after.jsp"/>
    </form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 506px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1536px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; left: 49px; height: 711px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99); top: 708px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div></body></html>