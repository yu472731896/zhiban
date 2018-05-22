<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>智能陪伴，快乐成长</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<!--微信不缓存东西  start-->
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<!--微信不缓存东西  end-->
		<%@include file="/WEB-INF/views/include/zhibanHead.jsp" %>
	</head>

	<body class="bg_index" style="text-align: center;">
		<p class="register_success">恭喜你已经成功定制个人名片，请使用电脑登录后台管理系统（网址：www.baidu.com）完善相关资料并管理名片。<br/>
		用户名：HYY<br/>密码：123456
		</p>
		
		<a href="${fctx}/core/showMe" style="color: #fff"><span>查看我的名片→</span></a>
	</body>

</html>