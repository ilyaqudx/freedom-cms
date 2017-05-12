<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0046)http://osd.greenleafgroup.cn/member/index.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml" class="" style="overflow: hidden;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	会员管理系统
</title><meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="js-before.jsp"/>
	<link href="/js/style.css" rel="stylesheet" type="text/css">
<link href="/js/font-awesome.css" rel="stylesheet">
<link href="/js/icon-font.min.css" rel="stylesheet" type="text/css">
<link href="/js/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="/js/wow.min.js"></script>
<!-- <script src="/js/jquery-1.10.2.min.js"></script> -->
<script src="/js/lhgdialog.js"></script>
<link href="/js/idialog.css" rel="stylesheet">
<script src="/js/public.js"></script>
</head>

<body class="sticky-header left-side-collapsed"><div style="display: none; position: absolute;" class=""><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons"><a class="ui_min" href="http://osd.greenleafgroup.cn/member/index.aspx###" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a><a class="ui_rese" href="http://osd.greenleafgroup.cn/member/index.aspx###" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a><a class="ui_max" href="http://osd.greenleafgroup.cn/member/index.aspx###" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a><a class="ui_res" href="http://osd.greenleafgroup.cn/member/index.aspx###" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a><a class="ui_close" href="http://osd.greenleafgroup.cn/member/index.aspx###" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon"><img src="" class="ui_icon_bg"></td><td class="ui_main" style="width: 1084px; height: 351px;"><div class="ui_content" style="padding: 0px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div>
    <form name="form1" method="post" action="http://osd.greenleafgroup.cn/member/index.aspx" id="form1">
<div>
<input type="hidden" name="__RefreshPageGuid" id="__RefreshPageGuid" value="42745c25-1744-419d-aab9-260e1a3c96a3">
<input type="hidden" name="__RefreshHiddenField" id="__RefreshHiddenField" value="101616.71759">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTk5MzY1NTU5Ng9kFgICAw9kFjICAQ9kFhICAQ8WAh4Fc3R5bGUFEGRpc3BsYXk6ZGlzcGxheTtkAgIPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCAw8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIEDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAgUPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCBg8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIHDxYCHwAFEGRpc3BsYXk6ZGlzcGxheTtkAggPFgIfAAUQZGlzcGxheTpkaXNwbGF5O2QCCQ8WAh8ABRBkaXNwbGF5OmRpc3BsYXk7ZAIDD2QWCAIBDxYCHgtfIUl0ZW1Db3VudAIFFgpmD2QWAmYPFQMDMTY2D+WVhuWfjuWNleWFrOWRihEyMDE3LzUvNiAxMTowNTo1MGQCAQ9kFgJmDxUDAzE2NA81LjHmlL7lgYflhazlkYoSMjAxNy80LzE4IDEwOjQ2OjIxZAICD2QWAmYPFQMDMTYzDOe+juWYieWFrOWRihIyMDE3LzQvMTQgMTI6NDg6MTBkAgMPZBYCZg8VAwMxNjE25YWz5LqO5pS26LSn5rOo5oSP5LqL6aG55Y+K44CK5pS26LSn5byC5bi46KGo44CL5aGr5YaZETIwMTcvNC81IDE0OjM5OjM1ZAIED2QWAmYPFQMDMTYwHTIwMTflubQ05pyI5L+D6ZSA5rS75Yqo6YCa55+lETIwMTcvNC8yIDEwOjQzOjI4ZAIDDxYCHwFmZAIFDxYCHglpbm5lcmh0bWwFBuWnmuWFsGQCBg8WAh8CBQbkvJrlkZhkAgUPFgIfAgUIMTA0ODYuMjZkAgcPFgIfAgUlMeS4h+Wkjea2iOW3suaIkOWKn++8jOWQiOagvOS4k+WNluW6l2QCCQ8WAh8CBQdhMDYyMDUwZAILDxYCHwIFBuWnmuWFsGQCDQ8WAh8CBQsxNTI4NDcxMjQxM2QCDw8WAh8CZGQCEQ8WAh8CBQdhNTg1MzgxZAITDxYCHwIFB2E1ODUzODFkAhUPFgIfAgURMjAxNy80LzQgMjE6MjM6MTVkAhcPFgIfAgUEMy43NGQCGQ8WAh8CBQgxMDQ4Ni4yNmQCGw8WAh8CBQYxOTcuNTBkAh0PFgIfAgUHMjUwMi4wMGQCHw8WAh8CBQY1NTQuMDBkAiEPFgIfAgUHYTIxNTMxMGQCIw8WAh8CBQdhODIwNTI3ZAIlDxYCHwIFBuS8muWRmGQCJw8WAh8CBQY0OTguMDBkAikPFgIfAgUBMWQCKw8WAh8CBQEyZAItDxYCHwIFAjE1ZAIvDxYCHwIFBTE0LjAwZAIxDxYCHwIFBDEuMDBkZIWVkmqAn4lzXx8P1LgHadmihvpc">
</div>

        <section>
            
<jsp:include page="header.jsp"/>

            <div class="main-content">
                
<jsp:include page="top.jsp"/>

                <div id="page-wrapper">
                    <div class="graphs">
                        
                        <div class="col_1">

                            <div class="col-md-6">
                                <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                    <div class="panel-heading" style="background-color: #6495ED">
                                        <h2>会员信息</h2>
                                        <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
                                            <span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span>
                                        </div>
                                    </div>
                                    <div class="email-list1">
                                        <ul class="collection">
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">近三个月电子币复消单业绩累计</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="p_pv" class="new badge1 red">10486.26</span></a>
                                                <div class="clearfix"></div>
                                            </li>
										    <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">专卖店开店审核情况</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="p_shopmemo" class="new badge1 red">1万复消已成功，合格专卖店</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">会员账号</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="p_loginName" class="new badge1 blue1">a062050</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">会员姓名</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="p_name" class="new badge1 blue1">姚兰</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">联系手机</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_mobile" class="new badge1 blue2">15284712413</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">奖衔级别</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="spanlevelone" class="new badge1 blue2"></span></a>
                                                <div class="clearfix"></div>
                                            </li>

                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">推荐人账号</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_p" class="new badge1 blue2">a585381</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">安置人账号</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_danbaoren" class="new badge1 blue2">a585381</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                           
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">注册日期</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_d" class="new badge1 blue2">2017/4/4 21:23:15</span></a>
                                                <div class="clearfix"></div>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>



                            <div class="col-md-6">
                                <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
                                    <div class="panel-heading" style="background-color: #6495ED">
                                        <h2>其他信息</h2>
                                        <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
                                            <span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span>
                                        </div>
                                    </div>
                                    <div class="email-list1">
                                        <ul class="collection">
										    
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">电子币</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="Span1" class="new badge1 blue2">3.74</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">复消币</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="Span2" class="new badge1 blue2">10486.26</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">奖金币</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="Span3" class="new badge1 blue2">197.50</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">报单购物币</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="Span4" class="new badge1 blue2">2502.00</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">报单币</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="Span5" class="new badge1 blue2">554.00</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            
                                             <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">左区底层会员</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_left_code" class="new badge1 blue2">a215310</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">右区底层会员</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_right_code" class="new badge1 blue2">a820527</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread">
                                                <div class="avatar_left">
                                                    <span class="email-title">会员级别</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_g" class="new badge1 blue2">会员</span></a>
                                                <div class="clearfix"></div>
                                            </li>

                                          


                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">消费总额</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="span_xiaofeizonge" class="new badge1 gray">498.00</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">累计单数</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="spanTotalUnit" class="new badge1 gray">1</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">直推人数</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="zhituirenshu" class="new badge1 gray">2</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">安置团队人数</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="tuijiantuanduirenshu" class="new badge1 gray">15</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">左区剩余业绩</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_left_yu" class="new badge1 gray">14.00</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                            <li class="collection-item avatar email-unread" style="display:none">
                                                <div class="avatar_left">
                                                    <span class="email-title">左区剩余业绩</span>
                                                </div>
                                                <a href="javascript:void(0)" class="secondary-content"><span id="b_right_yu" class="new badge1 gray">1.00</span></a>
                                                <div class="clearfix"></div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- <script src="/js/jquery.nicescroll.js"></script> -->
        <jsp:include page="js-after.jsp"/>
    
<script>showMessaggeInfo(166)</script></form><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 5px; height: 388px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 5px; width: 1366px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; cursor: default; position: fixed; top: 0px; left: 49px; height: 623px; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; top: 620px; left: 0px; position: fixed; cursor: default; display: none; background: rgb(66, 79, 99);"><div style="position: relative; top: 0px; height: 3px; width: 0px; border: 0px; border-radius: 10px; background-color: rgb(39, 204, 228); background-clip: padding-box;"></div></div><div style="position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; overflow: hidden; opacity: 0.6; z-index: 1976; display: none; background: rgb(220, 226, 241);"></div>


<div id="dragMask" style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; pointer-events: none; background: rgb(255, 255, 255);"></div></body></html>