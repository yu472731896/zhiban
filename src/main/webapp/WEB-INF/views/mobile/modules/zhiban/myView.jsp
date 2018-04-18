<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>我的名片</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#myViewForm").submit();
		});
	</script>
</head>
<body>
	<form id="myViewForm" name="myViewForm" action="${fctx}/core/view/<c:out value="${user.id}"/>" method="post" target="myViewFrame">
	
	</form>
	
	<div id="right">
		<iframe id="myViewFrame" name="myViewFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
	</div>
</body>
</html>