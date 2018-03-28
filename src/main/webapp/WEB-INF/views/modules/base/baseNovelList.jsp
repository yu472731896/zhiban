<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小说用户表信息表管理</title>
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
		<li class="active"><a href="${ctx}/base/baseNovel/">小说用户表信息表列表</a></li>
		<shiro:hasPermission name="base:baseNovel:edit"><li><a href="${ctx}/base/baseNovel/form">小说用户表信息表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baseNovel" action="${ctx}/base/baseNovel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>小说名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>小说名称</th>
				<shiro:hasPermission name="base:baseNovel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baseNovel">
			<tr>
				<td><a href="${ctx}/base/baseNovel/form?id=${baseNovel.id}">
					<fmt:formatDate value="${baseNovel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${baseNovel.remarks}
				</td>
				<td>
					${baseNovel.name}
				</td>
				<shiro:hasPermission name="base:baseNovel:edit"><td>
    				<a href="${ctx}/base/baseNovel/form?id=${baseNovel.id}">修改</a>
					<a href="${ctx}/base/baseNovel/delete?id=${baseNovel.id}" onclick="return confirmx('确认要删除该小说用户表信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>