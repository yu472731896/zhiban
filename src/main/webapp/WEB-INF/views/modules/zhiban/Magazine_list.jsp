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
		<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		</script>
	</head>
	<body>
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<!--资讯-->
		<div class="Magazine Magazine_bg_white">
			<div class="Magazinelist_title">
				<img class="bg_Magazinelist_title" src="${ctxStatic}/zhiban/img/bg_index_01.jpg"/>
				<p class="Magazinelist_title_text">智伴介绍</p>
			</div>
			<!--<div class="Magazine_type">
				</div>-->
			<ul class="Magazine_lists">
				<c:forEach items="${page.list}" var="baseNews">
					<li class="news_box">
						<a href="${fctx}/core/mobileform?id=${baseNews.id}">
							<p class="nwes_title">${baseNews.title}</p></a>
						<img class="news_backcover" src="<c:out value="${baseNews.path}"/>"/>
						<%-- <img class="news_backcover" src="<c:out value="${fn:replace('${baseNews.path}', '|','')}"/>"/> --%>
					</li>
				</c:forEach>
			
				<!-- <li class="news_box">
					<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
					<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
				</li>
				<li class="news_box">
					<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
					<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
				</li>
				<li class="news_box">
					<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
					<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
				</li>
				<li class="news_box">
					<p class="nwes_title">1-14岁孩子成长密码，耶鲁大学跟踪研究40年的成果</p>
					<img class="news_backcover" src="http://7xk5td.com1.z0.glb.clouddn.com/weixin_LTE4ODA2NTI3ODk=0.jpg-img200112" />
				</li> -->
			</ul>
			<div class="pagination">${page}</div>
<!-- <div class="loadData">没有更多了</div> -->
		</div>
	</body>

</html>