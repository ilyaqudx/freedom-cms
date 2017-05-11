<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0045)http://osd.greenleafgroup.cn/member/info.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1"><link href="/js/bootstrap.min.css" rel="stylesheet" type="text/css"><link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
</head>

<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/info.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/info.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/info.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/info.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/info.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="http://osd.greenleafgroup.cn/member/info.aspx" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
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
                <a href="http://osd.greenleafgroup.cn/member/info.aspx#"><i class="lnr lnr-envelope"></i><span>新闻公告</span></a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/message/notice.aspx">新闻公告</a> </li>
                    
                </ul>
            </li>
            <li><a href="http://osd.greenleafgroup.cn/member/member/team.aspx">
                <i class="lnr lnr-bus"></i><span>团队信息</span></a>
            </li>

            

            
            
            
            
            
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/info.aspx#"><i class="lnr lnr-user"></i>
                    <span>专卖店管理</span></a>
                <ul class="sub-menu-list">
                    <li id="left_li_ask" style="display: none"><a href="http://osd.greenleafgroup.cn/member/member/ask.aspx">开店申请</a></li>
                    <li id="left_li_shop_1" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/add.aspx">会员注册</a></li>
                    <li id="left_li_shop_2" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/auditing.aspx">会员激活</a></li>
                    <li id="left_li_shop_5" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/slist.aspx">会员激活列表</a></li>

                </ul>
            </li>

            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/info.aspx#">
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
                <a href="http://osd.greenleafgroup.cn/member/info.aspx#">
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
                <a href="http://osd.greenleafgroup.cn/member/info.aspx#">
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

            <li class="menu-list"><a href="http://osd.greenleafgroup.cn/member/info.aspx#">
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
                        <a href="http://osd.greenleafgroup.cn/member/info.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
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
        <script src="/js/jquery.nicescroll.js"></script>
        <script src="/js/scripts.js"></script>
        <script src="/js/bootstrap.min.js"></script>
    </form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 506px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1536px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; left: 49px; height: 711px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99); top: 708px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div></body></html>