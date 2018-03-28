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
		<li class="active"><a href="${ctx}/base/baseNovelUser/">小说用户表信息表列表</a></li>
		<shiro:hasPermission name="base:baseNovelUser:edit"><li><a href="${ctx}/base/baseNovelUser/form">小说用户表信息表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baseNovelUser" action="${ctx}/base/baseNovelUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>登陆名：</label>
				<form:input path="loginName" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
				<form:input path="realName" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>用户名：</label>
				<form:input path="userName" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>电话号：</label>
				<form:input path="phoneNumber" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>小说用户类型：</label>
				<form:input path="novelUserType" htmlEscape="false" maxlength="1" class="input-medium"/>
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
				<th>登陆名</th>
				<th>真实姓名</th>
				<th>头像</th>
				<th>用户名</th>
				<th>电话号</th>
				<th>小说用户类型</th>
				<shiro:hasPermission name="base:baseNovelUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baseNovelUser">
			<tr>
				<td><a href="${ctx}/base/baseNovelUser/form?id=${baseNovelUser.id}">
					<fmt:formatDate value="${baseNovelUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${baseNovelUser.remarks}
				</td>
				<td>
					${baseNovelUser.loginName}
				</td>
				<td>
					${baseNovelUser.realName}
				</td>
				<td>
					${baseNovelUser.path}
				</td>
				<td>
					${baseNovelUser.userName}
				</td>
				<td>
					${baseNovelUser.phoneNumber}
				</td>
				<td>
					${baseNovelUser.novelUserType}
				</td>
				<shiro:hasPermission name="base:baseNovelUser:edit"><td>
    				<a href="${ctx}/base/baseNovelUser/form?id=${baseNovelUser.id}">修改</a>
					<a href="${ctx}/base/baseNovelUser/delete?id=${baseNovelUser.id}" onclick="return confirmx('确认要删除该小说用户表信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>