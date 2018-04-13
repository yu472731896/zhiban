<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
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
		<form class="user_login_box" action="${ctx}/zhiban/core/login" method="post">
			<div style="text-align: center;">
				<svg class="icon" aria-hidden="true" style="width: 40px;height: 40px;">
					<use xlink:href="#icon-login_user"></use>
				</svg>
			</div>
			<h2 class="login_title">登录</h2>
			<input id="username" name="username" type="text" value="" placeholder="请输入用户名或手机号码" />
			<input id="password" name="password"  type="password" value="" placeholder="请输入密码" />
			<p class="small_operation">
				<!-- <a href="user_password.html">修改密码</a> -->
				<a style="float: right;" href="${ctx}/f/core/login">还没有账号，去注册&gt;</a>
			</p>
			<button type="submit"  class="common_btn">登录</button>
		</form>

	</body>

</html>