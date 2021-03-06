<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <!--微信不缓存东西  start-->
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <!--微信不缓存东西  end-->
		<%@include file="/WEB-INF/views/include/head.jsp" %>
		<script src="//at.alicdn.com/t/font_583524_fowoce8mkx6o5hfr.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body class="bg_login">
		<form class="user_login_box" action="return flase" method="post">
			<div style="text-align: center;">
				<svg class="icon" aria-hidden="true" style="width: 40px;height: 40px;">
					<use xlink:href="#icon-login_user"></use>
				</svg>
			</div>
			<h2 class="login_title">注册</h2>
			<input type="text" name="" value="" placeholder="请输入用户名" />
			<input type="tel" name="" value="" placeholder="请输入手机号码" />
			<input type="password" name="" value="" placeholder="请输入密码" />
			<p class="small_operation">
				<a style="float: right;" href="${ctx}/f/core/login">已有账号，立即登录&gt;</a>
			</p>
			<button class="common_btn">登录</button>
		</form>

	</body>

</html>