<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>新管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/productCategoryTree/">新列表</a></li>
		<shiro:hasPermission name="test:productCategoryTree:edit"><li><a href="${ctx}/test/productCategoryTree/form">新添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="productCategoryTree" action="${ctx}/test/productCategoryTree/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="test:productCategoryTree:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="productCategoryTree">
			<tr>
				<td><a href="${ctx}/test/productCategoryTree/form?id=${productCategoryTree.id}">
					${productCategoryTree.name}
				</a></td>
				<td>
					<fmt:formatDate value="${productCategoryTree.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${productCategoryTree.remarks}
				</td>
				<shiro:hasPermission name="test:productCategoryTree:edit"><td>
    				<a href="${ctx}/test/productCategoryTree/form?id=${productCategoryTree.id}">修改</a>
					<a href="${ctx}/test/productCategoryTree/delete?id=${productCategoryTree.id}" onclick="return confirmx('确认要删除该新吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>