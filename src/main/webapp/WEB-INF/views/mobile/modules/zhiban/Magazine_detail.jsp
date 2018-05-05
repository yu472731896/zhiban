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
		<%@include file="/WEB-INF/views/include/head.jsp" %>
		<%@include file="/WEB-INF/views/include/zhibanHead.jsp" %>
	</head>
	<body>
		<!--资讯详情-->
		<div class="Magazine Magazine_bg_white">
			<div class="information_title">${baseNews.title}</div>
			<div class="information_time">
				<img src="${ctxStatic}/zhiban/img/icon_time.png" /><span><fmt:formatDate value="${baseNews.updateDate}"></fmt:formatDate> </span>
			</div>
			<div class="information_text">
				${baseNews.content}
			</div>

			<a href="javascript:scroll(0,0)">
				<svg class="icon return_top" aria-hidden="true">
					<use xlink:href="#icon-gototop"></use>
				</svg>
			</a>
		</div>
	</body>

</html>