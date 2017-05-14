<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="left-side sticky-left-side" tabindex="5000"
	style="overflow: hidden; outline: none;">
	<div class="logo">
		<h1>
			<a href="/">会员管理系统</a>
		</h1>
	</div>
	<div class="logo-icon text-center">
		<a href="/"><i
			class="lnr lnr-home"></i></a>
	</div>

	<div class="left-side-inner">
		<ul class="nav nav-pills nav-stacked custom-nav">
			<li class="menu-list"><a
				href="javascript:void(0)"><i
					class="lnr lnr-envelope"></i><span>新闻公告</span></a>
				<ul class="sub-menu-list">
					<li><a
						href="javascript:void(0)">新闻公告</a>
					</li>
					<li><a
						href="javascript:void(0)">申诉反馈</a></li>
				</ul></li>
			<li><a
				href="javascript:void(0)"> <i
					class="lnr lnr-bus"></i><span>团队信息</span></a></li>








			<li class="menu-list"><a
				href="/#"><i
					class="lnr lnr-user"></i> <span>专卖店管理</span></a>
				<ul class="sub-menu-list">
					<li id="left_li_ask" style="display: none"><a
						href="javascript:void(0)">开店申请</a></li>
					<!-- 以下5个功能为管理员功能列表,才会显示 -->
					<c:if test="${user.admin == 1 }">
					<li id="left_li_shop_1" style="display: display;"><a
						href="/user/add">会员注册</a></li>
					<li id="left_li_shop_2" style="display: display;"><a
						href="javascript:void(0)">会员激活</a></li>
					<li id="left_li_shop_5" style="display: display;"><a
						href="/user/list">会员激活列表</a></li>
					<li id="left_li_shop_5" style="display: display;"><a
						href="/achievement/add">添加会员业绩</a></li>
					<li id="left_li_shop_5" style="display: display;"><a
						href="/achievement/list">查看会员业绩</a></li>
					</c:if>
					<c:if test="${user.admin != 1 }">
						<li id="left_li_shop_5" style="display: display;"><a
						href="/user/list">会员激活列表</a></li>
					</c:if>
					<!-- 以上5个功能为管理员功能列表,才会显示 -->
				</ul></li>

			<li class="menu-list"><a
				href="/#"> <i
					class="lnr lnr-cart"></i><span>购物管理</span>
			</a>
				<ul class="sub-menu-list">
					<!-- 以下记录只有管理员才会显示  -->
					<c:if test="${user.admin == 1 }">
					<li id="left_li_shop_7" style="display: display;"><a
						href="javascript:void(0)">待审核订单</a></li>
					<li id="left_li_shop_6" style="display: display;"><a
						href="javascript:void(0)">待发货订单</a></li>
					<li id="left_li_shop_8" style="display: display;"><a
						href="javascript:void(0)">已发货订单</a></li>
					<li id="left_li_shop_3" style="display: display;"><a
						href="javascript:void(0)">商城购物</a></li>
					<li id="left_li_shop_4" style="display: display;"><a
						href="javascript:void(0)">复消录入</a></li>
					<li id="left_li_shop_9" style="display: display;"><a
						href="javascript:void(0)">复消录入记录</a></li>
					</c:if>
					<!-- 以上记录只有管理员才会显示  -->
					<li><a
						href="javascript:void(0)">复消记录</a></li>
				</ul></li>
			<li class="menu-list"><a
				href="/#"> <i
					class="lnr lnr-sun"></i><span>财务管理</span>
			</a>
				<ul class="sub-menu-list">
					<li><a
						href="javascript:void(0)">汇款操作</a></li>
					<li><a
						href="javascript:void(0)">汇款记录</a></li>
					<li><a href="/order/add">提现操作</a></li>
					<li><a href="/order/list">提现记录</a></li>
				</ul></li>
			<li class="menu-list"><a
				href="/#"> <i
					class="lnr lnr-moon"></i><span>货币管理</span>
			</a>
				<ul class="sub-menu-list">
					<li><a
						href="javascript:void(0)">货币转换操作</a></li>
					<li><a
						href="javascript:void(0)">货币转换记录</a></li>
					<li><a
						href="javascript:void(0)">会员转账</a></li>
					<li><a
						href="javascript:void(0)">转账记录</a></li>
					<li><a
						href="javascript:void(0)">财务流水</a></li>
				</ul></li>


			<li><a
				href="javascript:void(0)">
					<i class="lnr lnr-pie-chart"></i><span>奖金记录</span>
			</a></li>

			<li class="menu-list"><a
				href="/#"> <i
					class="lnr lnr-cog"></i><span>帐号管理</span></a>
				<ul class="sub-menu-list">
					<li><a href="/user/edit">个人资料</a></li>
					<li><a href="/user/security">安全设置</a></li>
				</ul></li>

			<li><a href="/user/logout">
					<i class="lnr lnr-exit"></i><span>安全退出</span>
			</a></li>
		</ul>
	</div>
</div>