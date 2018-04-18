<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户基础信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/base/baseUserInfo/">用户基础信息列表</a></li>
		<li class="active"><a href="${ctx}/base/baseUserInfo/form?id=${baseUserInfo.id}">用户基础信息<shiro:hasPermission name="base:baseUserInfo:edit">${not empty baseUserInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="base:baseUserInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="baseUserInfo" action="${ctx}/base/baseUserInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		
		
		<div class="control-group">
			<label class="control-label">企业名称：</label>
			<div class="controls">
				<form:input path="entName" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">职位：</label>
			<div class="controls">
				<form:input path="position" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">标题信息：</label>
			<div class="controls">
				<form:textarea path="titleInfo" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">微信号：</label>
			<div class="controls">
				<form:input path="weixin" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微信二维码图片：</label>
			<div class="controls">
				<form:hidden id="weixinMa" path="weixinMa" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="weixinMa" type="files" uploadPath="/base/baseUserInfo" selectMultiple="true"/>
			</div>
		</div>
		
		
		
		<div class="control-group">
			<label class="control-label">背景音乐：</label>
			<div class="controls">
				<form:hidden id="musicFile" path="musicFile" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="musicFile" type="music" uploadPath="/base/baseUserInfo" selectMultiple="true"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="base:baseUserInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>