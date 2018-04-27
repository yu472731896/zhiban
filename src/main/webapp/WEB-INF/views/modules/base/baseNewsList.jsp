<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>我的资讯管理</title>
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
		<li class="active"><a href="${ctx}/base/baseNews/list">我的资讯列表</a></li>
		<shiro:hasPermission name="base:baseNews:edit"><li><a href="${ctx}/base/baseNews/form">我的资讯添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="baseNews" action="${ctx}/base/baseNews/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${baseNews.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${baseNews.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>用户名称：</label>
				<form:input path="user.name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>图片</th>
				<th>内容</th>
				<th>更新时间</th>
				<!-- <th>用户主键</th> -->
				<shiro:hasPermission name="base:baseNews:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="baseNews">
			<tr>
				<td><a href="${ctx}/base/baseNews/form?id=${baseNews.id}">
					${baseNews.title}</a>
				</td>
				<td>
					<!--简单图片展示 -->
				 	<c:choose>
						<c:when test="${baseNews.path == null||baseNews.path == ''}">
							暂无图片 
			            </c:when>
			            <c:otherwise>
			                  <input type=button value="预览" onclick="open_win('${baseNews.path}')" />
			                  <script>
				                  
				                  function open_win(patch){
				                	  while(patch.indexOf("|")!=-1){
				                		  patch = patch.replace("|","~");
				                	  }
				                	  var url = 'iframe:${ctxStatic}/viewer/imgview.jsp?imgStr='+patch;
				                	  top.$.jBox.open(url, "图片预览", 700, 600);
				                  }
							 </script>
			            </c:otherwise>
	            	</c:choose> 
				</td>
				<td>
					${baseNews.content}
				</td>
				<td>
					<fmt:formatDate value="${baseNews.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					${baseNews.user.id}
				</td> --%>
				<shiro:hasPermission name="base:baseNews:edit"><td>
    				<a href="${ctx}/base/baseNews/form?id=${baseNews.id}">修改</a>
					<a href="${ctx}/base/baseNews/delete?id=${baseNews.id}" onclick="return confirmx('确认要删除该我的资讯吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>