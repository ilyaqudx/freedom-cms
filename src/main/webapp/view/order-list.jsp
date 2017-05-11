<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0054)http://osd.greenleafgroup.cn/member/withdraw/list.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1"><link href="/js/bootstrap.min.css" rel="stylesheet" type="text/css"><link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
</head>

<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="http://osd.greenleafgroup.cn/member/withdraw/list.aspx" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    <form name="form1" method="post" action="/order/list" id="form1">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
<input type="hidden" name="pageNum" value="${p.currentPage }" type="text" id="pageNum" class="form-control" />
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
                <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#"><i class="lnr lnr-envelope"></i><span>新闻公告</span></a>
                <ul class="sub-menu-list">
                    <li><a href="http://osd.greenleafgroup.cn/member/message/notice.aspx">新闻公告</a> </li>
                    
                </ul>
            </li>
            <li><a href="http://osd.greenleafgroup.cn/member/member/team.aspx">
                <i class="lnr lnr-bus"></i><span>团队信息</span></a>
            </li>

            

            
            
            
            
            
            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#"><i class="lnr lnr-user"></i>
                    <span>专卖店管理</span></a>
                <ul class="sub-menu-list">
                    <li id="left_li_ask" style="display: none"><a href="http://osd.greenleafgroup.cn/member/member/ask.aspx">开店申请</a></li>
                    <li id="left_li_shop_1" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/add.aspx">会员注册</a></li>
                    <li id="left_li_shop_2" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/auditing.aspx">会员激活</a></li>
                    <li id="left_li_shop_5" style="display:display;"><a href="http://osd.greenleafgroup.cn/member/member/slist.aspx">会员激活列表</a></li>

                </ul>
            </li>

            <li class="menu-list">
                <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#">
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
                <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#">
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
                <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#">
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

            <li class="menu-list"><a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#">
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
                        <a href="http://osd.greenleafgroup.cn/member/withdraw/list.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
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

                        <div class="col_12">
                            <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                <div class="panel-heading" style="background-color: #3B5998">
                                    <h2>提现记录</h2>
                                    <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
                                        <span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span>
                                    </div>
                                </div>
                                <div class="panel-body no-padding table-responsive">
                                    
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr class="warning">
												<th>序号</th>
												<th>提现金额</th>
												<th>实发金额</th>
												<th>申请时间</th>
												<th>类型</th>
												<th>状态</th>
											</tr>
                                                </thead>
                                                <tbody>
                                        	<c:forEach items="${orders }" var="order" varStatus="status">
                                            <tr>
												<td>${status.index + 1 }</td>
												<td>${order.amount }</td>
												<td>${order.actualAmount }</td>
												<td><fmt:formatDate value="${order.createTime }" pattern="yyyy/MM/dd HH:mm:ss"/> </td>
												<td><i class="require-red"> 奖金币 </i></td>
												<td>
													<i class="require-red"> 
														${order.status == 0 ? '审核中' : '已发放' }
												 	</i>
												 </td>
											</tr>
                                        	</c:forEach>
                                            </tbody>
                                            </table>
                                        
                                    
<!-- AspNetPager 7.3.2  Copyright:2003-2010 Webdiyer (www.webdiyer.com) -->
<div id="anp1" class="pages">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tbody><tr>
		<td class="pages" valign="bottom" nowrap="true"
														style="width: 60%;">
														<a style="margin-right: 5px;" href="javascript:query(${p.currentPage },1)">首页</a>
														<a style="margin-right: 5px;" href="javascript:query(${p.currentPage },${p.prePage })">上一页</a><a
														href="javascript:query(${p.currentPage },${p.getNextPage() })"
														style="margin-right: 5px;">下一页</a><a
														href="javascript:query(${p.currentPage },${p.getLastPage() })"
														style="margin-right: 5px;">尾页</a></td>
													<td class="pages" valign="bottom" nowrap="true"
														style="width: 40%;">当前第${p.currentPage}页,共${p.totalPage}页</td>
	</tr>
</tbody></table>
</div>
<!-- AspNetPager 7.3.2  Copyright:2003-2010 Webdiyer (www.webdiyer.com) -->


                                </div>
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
        	
        function query(currentPage,requestPage){
        	debugger;
        	
        	if(currentPage != requestPage)
        	{
        		$("#pageNum").val(requestPage);
        		$("#form1").submit();
        	}
        	
        }
        	
        </script>
        
        
    </form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 506px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(66, 79, 99); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1536px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99); cursor: default; position: fixed; top: 0px; left: 49px; height: 711px; display: none;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99); top: 708px; left: 0px; position: fixed; cursor: default; display: none;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(39, 204, 228); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255); pointer-events: none;"></div></body></html>