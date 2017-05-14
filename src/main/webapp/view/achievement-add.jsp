<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0053)javascript:void(0) -->
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
            $("#code").formValidator().InputValidator({ min: 7, onerror: "请输入会员编号" });
            $("#electronicCoin").formValidator().InputValidator({ min: 1, onerror: "请输入电子币金额" });
            $("#repeatSaleCoin").formValidator().InputValidator({ min: 1, onerror: "请输入复消金额" });
            $("#bonusCoin").formValidator().InputValidator({ min: 1, onerror: "请输入奖金币金额" });
            $("#baoDanCoin").formValidator().InputValidator({ min: 1, onerror: "请输入报单金额" });
            $("#baoDanGouWuCoin").formValidator().InputValidator({ min: 1, onerror: "请输入报单购物金额" });
            $("#electCoinCumulative").formValidator().InputValidator({ min: 1, onerror: "请输入三个月电子币复消单累计金额" });
            //$("#leftChild").formValidator().InputValidator({ min: 7, onerror: "请输入左区底层会员编号" });
            //$("#rightChild").formValidator().InputValidator({ min: 7, onerror: "请输入右区底层会员编号" });
            //$("#amount").formValidator().InputValidator({ min: 1, onerror: "请输入提现金额" });
            //$("#amount").formValidator().InputValidator({ min: 2, max: 8, onerror: "你输入的金额有问题,请修改" })
                 //.RegexValidator({ regexp: "^[1-9][0-9]$",onerror: "提现金额必须是100的整数倍，请重新输入！"});
            //$("#txtMemo").formValidator().InputValidator({ min: 1, onerror: "请输入提现描述" });
            
            var error = "${error}";
            if(error){
            	alert(error);
            }
        });

    </script>
</head>

<body class="sticky-header left-side-collapsed"><div class="" style="display: none; position: absolute;"><div class="ui_outer"><table class="ui_border"><tbody><tr><td class="ui_lt"></td><td class="ui_t"></td><td class="ui_rt"></td></tr><tr><td class="ui_l"></td><td class="ui_c"><div class="ui_inner"><table class="ui_dialog"><tbody><tr><td colspan="2" class="ui_header"><div class="ui_title_bar"><div class="ui_title" unselectable="on" style="cursor: move;"><span class="ui_title_icon"></span><b class="ui_title_txt" unselectable="on"></b></div><div class="ui_title_buttons">
<a class="ui_min" href="javascript:void(0)" title="最小化" style="display: inline-block;"><b class="ui_min_b"></b></a>
<a class="ui_rese" href="javascript:void(0)" title="恢复"><b class="ui_rese_b"></b><b class="ui_rese_t"></b></a>
<a class="ui_max" href="javascript:void(0)" title="最大化" style="display: inline-block;"><b class="ui_max_b"></b></a>
<a class="ui_res" href="javascript:void(0)" title="还原"><b class="ui_res_b"></b><b class="ui_res_t"></b></a>
<a class="ui_close" href="javascript:void(0)" title="关闭(esc键)" style="display: inline-block;">×</a></div></div></td></tr><tr><td class="ui_icon">
<img src="javascript:void(0)" class="ui_icon_bg"></td><td class="ui_main" style="width: auto; height: auto;"><div class="ui_content" style="padding: 10px;"></div></td></tr><tr><td colspan="2" class="ui_footer"><div class="ui_buttons" style="display: none;"></div></td></tr></tbody></table></div></td><td class="ui_r"></td></tr><tr><td class="ui_lb"></td><td class="ui_b"></td><td class="ui_rb" style="cursor: se-resize;"></td></tr></tbody></table></div></div><div style="position: absolute; z-index: 19700; top: -1970px; left: -1970px; display: none;"><iframe src="/js/My97DatePicker.html" frameborder="0" border="0" scrolling="no" style="width: 186px; height: 198px;"></iframe></div>
    <form name="form2" method="post" action="/achievement/add" id="form2">
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
                                        <div class="panel-body form-horizontal">
                                        	<input name="id" type="hidden" value="${a.id }" id="id" class="form-control">
                                            <div class="form-group">
                                                <label class="col-sm-6 control-label form-label"><b style="font-size: 18px">业绩操作</b></label>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">会员编号</label>
                                                <div class="col-sm-6">
                                                    <input name="code" type="text" value="${a.code }" id="code" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">电子币</label>
                                                <div class="col-sm-6">
                                                    <input name="electronicCoin" type="text" value="${a.electronicCoin }" id="electronicCoin" class="form-control">
                                                </div>
                                            </div>
                                           
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">复消币</label>
                                                <div class="col-sm-6">
                                                   <input name="repeatSaleCoin" type="text" value="${a.repeatSaleCoin }" id="repeatSaleCoin" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">奖金币</label>
                                                <div class="col-sm-6">
                                                   <input name="bonusCoin" type="text" value="${a.bonusCoin }" id="bonusCoin" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">报单币</label>
                                                <div class="col-sm-6">
                                                   <input name="baoDanCoin" type="text" value="${a.baoDanCoin }" id="baoDanCoin" class="form-control">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">报单购物币</label>
                                                <div class="col-sm-6">
                                                   <input name="baoDanGouWuCoin" type="text" value="${a.baoDanGouWuCoin }"  id="baoDanGouWuCoin" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">左区底层会员</label>
                                                <div class="col-sm-6">
                                                    <input ${a.leftChild == null ? '' : "disabled='disabled'" } name="leftChild" type="text" value="${a.leftChild }" id="leftChild" class="form-control">
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">右区底层会员</label>
                                                <div class="col-sm-6">
                                                    <input ${a.rightChild == null ? '' : "disabled='disabled'" } name="rightChild" type="text" value="${a.rightChild }" id="rightChild" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">会员级别</label>
                                                <div class="col-sm-6">
                                                    <input name="level" type="text" value="会员" id="level" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">近三个月电子币复消单业绩累计</label>
                                                <div class="col-sm-6">
                                                    <input name="electCoinCumulative" type="text" value="${a.electCoinCumulative }" id="level" class="form-control">
                                                </div>
                                            </div>
                                             <div class="form-group">
                                                <label for="input001" class="col-sm-2 control-label form-label">专卖店开店审核情况</label>
                                                <div class="col-sm-6">
                                                    <input name="openShopStatus" type="text" value="${a.openShopStatus }" id="level" class="form-control">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label form-label"></label>
                                                <div class="col-sm-10">
                                                    <input type="submit" name="btnSubmit" value="提交" onclick="return jQuery.formValidator.PageIsValid(1);" id="btnSubmit" class="btn btn-default">
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