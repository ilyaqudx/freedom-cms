<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0053)http://osd.greenleafgroup.cn/member/member/slist.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js-before.jsp"/>
<link href="/js/style.css" rel="stylesheet" type="text/css"><link href="/js/font-awesome.css" rel="stylesheet"><link href="/js/icon-font.min.css" rel="stylesheet" type="text/css"><link href="/js/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="/js/wow.min.js"></script>
    <script src="/js/lhgdialog.js"></script><link href="/js/idialog.css" rel="stylesheet">
    <script src="/js/public.js"></script>
    <script src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <!-- <link href="/js/WdatePicker.css" rel="stylesheet" type="text/css"> -->
</head>

<body class="sticky-header left-side-collapsed">
<div class="" style="display: none; position: absolute;">
<div class="ui_outer"><table class="ui_border">
<tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="/user/list###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/member/slist.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/member/slist.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/member/slist.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/member/slist.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div><div style="position: absolute; z-index: 19700; top: 133px; left: 329px; display: none;">
</div>
    <form name="form1" method="post" action="/user/list" id="form1">

<div>
	<input type="hidden" name="" id="" value="" cmd="">
	<input type="hidden" name="" id="" value="">
	<input type="hidden" name="" id="" value="">
</div>
        <section>
            
<jsp:include page="header.jsp"/>

            <div class="main-content">
                
<div class="header-section">
    <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
    <div class="menu-right">

        <div class="user-panel-top">
            <div class="profile_details_left">
                <ul class="nofitications-dropdown">

                    
                   
                    <li class="dropdown">
                        <a href="http://osd.greenleafgroup.cn/member/member/slist.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
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
                        <a href="http://osd.greenleafgroup.cn/member/member/slist.aspx#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span>申诉</span></a>
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
                        <div class="panel panel-widget col_12">

                            <div class="panel-body form-horizontal">
                                <div class="form-group">

                                        <input type="hidden" name="pageNum" value="${p.currentPage }" type="text" id="pageNum" class="form-control" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" realvalue=""/>
                                    <div class="col-sm-2">
                                        <input name="startTime" value="${q.startTime }" type="text" id="startTime" class="form-control" placeholder="起始时间" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" realvalue=""/>
                                    </div>
                                    <div class="col-sm-2">
                                        <input name="endTime" value="${q.endTime }" type="text" id="endTime" class="form-control" placeholder="截止时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" realvalue=""/>
                                    </div>
                                    <div class="col-sm-2">
                                        <input name="code" value="${q.code }" type="text" id="code" class="form-control" placeholder="会员账号">
                                    </div>
                                    <div class="col-sm-2">
                                        <input name="name" value="${q.name }" type="text" id="name" class="form-control" placeholder="会员姓名">
                                    </div>
                                    <div class="col-sm-2">
                                        <input name="phone" value="${q.phone }" type="text" id="phone" class="form-control" placeholder="联系手机">
                                    </div>


                                    <div class="col-sm-2">
                                        <input type="submit" name="btnSearch" value="数据查询" id="btnSearch" class="btn btn-default">
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="col_12">
                            <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                <div class="panel-heading" style="background-color: #3B5998">
                                    <h2>会员激活列表</h2>
                                    <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
                                        <span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span>
                                    </div>
                                </div>
                                <div class="panel-body no-padding table-responsive">
                                    
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr class="warning">
												<th>序号</th>
												<th>会员编号</th>
												<th>会员姓名</th>
												<th>联系电话</th>
												<th>注册时间</th>
												<th>推荐人卡号</th>
												<th>推荐人姓名</th>
												<th>接点人卡号</th>
												<th>接点人姓名</th>
												<th>报单金额</th>
											</tr>
                                                </thead>
                                                <tbody>
                                            <c:forEach  items="${users }" var="user" varStatus="status">
	                                            <tr>
													<td><b>${ status.index + 1}</b></td>
													<td>${user.code }</td>
													<td>${user.name }</td>
													<td>${user.phone }</td>
													<td><fmt:formatDate value="${user.createTime }" pattern="yyyy/MM/dd HH:mm:ss" /> </td>
													<td>${user.recommender }</td>
													<td>${user.recommenderName }</td>
													<td>${user.settler }</td>
													<td>${user.settlerName }</td>
													<td>498.00</td>
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
        <jsp:include page="js-after.jsp"/>
    
<script type="text/javascript">


function query(currentPage,requestPage){
	debugger;
	
	if(currentPage != requestPage)
	{
		$("#pageNum").val(requestPage);
		$("#form1").submit();
	}
	
}

//<![CDATA[
/* var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
} */
//]]>
</script>

</form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 5px; height: 388px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 5px; width: 1366px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; cursor: default; position: fixed; top: 0px; left: 49px; height: 623px; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; top: 620px; left: 0px; position: fixed; cursor: default; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 3px; width: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; pointer-events: none; background: rgb(255, 255, 255);"></div>
</body></html>