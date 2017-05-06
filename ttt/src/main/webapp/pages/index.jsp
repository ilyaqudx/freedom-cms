<%@page import="com.iquizoo.manage.web.admin.po.Resource"%>
<%@page import="com.iquizoo.manage.base.context.AppContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="/header.jsp"></jsp:include>
<title>iquizoo.admin v1.0</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">iquizoo.admin</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li>超级管理员</li>
					<li class="dropDown dropDown_hover"> <a class="dropDown_A">
					<c:if test="${sessionScope.ADMIN.realName == null }">
						${sessionScope.ADMIN.name }
					</c:if>
					<c:if test="${sessionScope.ADMIN.realName != null }">
						${sessionScope.ADMIN.realName }
					</c:if>
					<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a>个人信息</a></li>
							<!-- <li><a href="#">切换账户</a></li> -->
							<li><a href="admin/logout">退出</a></li>
						</ul>
					</li>
					<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		<%
			List<Resource> resources = AppContext.getCategory();
			for(Resource r : resources){
				if(!AppContext.getAuthority().contains(r.getUrl())){
					continue;
				}
				if(r.getParentId() == 0){//一级菜单
					String icon = r.getIcon();
					if(icon.startsWith("/")){
						icon = icon.substring(1, icon.length());
					}
					out.println("<dl id=\"menu-game\">");
					out.println("<dt><img width=\"14\" height=\"14\" src=\""+icon+"\"> "+r.getName()+"<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>");
					out.println("<dd>");
					out.println("<ul>");
					for(Resource c : resources){
						if(!AppContext.getAuthority().contains(c.getUrl())){
							continue;
						}
						if(c.getParentId().intValue() == r.getId()){
							StringBuilder li = new StringBuilder();
							li.append("<li><a _href=\"");
							StringBuilder childUrl = new StringBuilder(c.getUrl());
							if(childUrl.charAt(0) == '/'){
								childUrl.delete(0, 1);
							}
							li.append(childUrl);
							li.append("\" data-title=\"");
							li.append(c.getName());
							li.append("\" href=\"javascript:void(0)\">");
							li.append(c.getName());
							li.append("</a></li>");
							out.println(li.toString());
						}
					}
					out.println("</ul>");
					out.println("</dd>");
					out.println("</dl>");
				}
			}
		%>
		<!-- <dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="user/list" data-title="会员列表" href="javascript:;">会员列表</a></li>
					<li><a _href="member-del.html" data-title="删除的会员" href="javascript:;">删除的会员</a></li>
					<li><a _href="member-level.html" data-title="等级管理" href="javascript:;">等级管理</a></li>
					<li><a _href="member-scoreoperation.html" data-title="积分管理" href="javascript:;">积分管理</a></li>
					<li><a _href="member-record-browse.html" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
					<li><a _href="member-record-download.html" data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
					<li><a _href="member-record-share.html" data-title="分享记录" href="javascript:void(0)">分享记录</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="admin/list" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
					<li><a _href="role/list" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					<li><a _href="resource/list" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
					<li><a _href="category/list" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
					<li><a _href="system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
					<li><a _href="system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
					<li><a _href="system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-plan">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 计划管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>				
					<li><a _href="plan/list" data-title="计划" href="javascript:void(0)">计划</a></li>
					<li><a _href="plan/planName" data-title="计划名库" href="javascript:void(0)">计划名库</a></li>
					<li><a _href="evaluation/list" data-title="测评" href="javascript:void(0)">测评</a></li>
				    <li><a _href="evaluationExam/list" data-title="试卷" href="javascript:void(0)">试卷 </a></li>
				    <li><a _href="exercise/list" data-title="试题" href="javascript:void(0)">试题 </a></li>		
				  		
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe62e;</i>商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>				
					<li><a _href="product/list" data-title="计划" href="javascript:void(0)">商品</a></li>
					<li><a _href="order/list" data-title="计划名库" href="javascript:void(0)">商品订单</a></li>
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-user">
			<dt><i class="Hui-iconfont">&#xe62e;</i>用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>				
					  <li><a _href="userPlan/list" data-title="用户计划" href="javascript:void(0)">用户计划 </a></li>
					  <li><a _href="userTask/list" data-title="用户任务" href="javascript:void(0)">用户任务 </a></li>
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-game">
			<dt><img alt="" width="14" height="14" src="static/icon/game.png"> 游戏管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>				
					<li><a _href="game/list" data-title="游戏" href="javascript:void(0)">游戏列表</a></li>
				</ul>
			</dd>
		</dl> -->
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
		</div>
	</div>
</section>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 
<script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s)})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" :  " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>