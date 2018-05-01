<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>我的资讯管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					var html = ue.getContent();
					console.log("html2222--->"+html);
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
		<li><a href="${ctx}/base/baseNews/list">我的资讯列表</a></li>
		<li class="active"><a href="${ctx}/base/baseNews/form?id=${baseNews.id}">我的资讯<shiro:hasPermission name="base:baseNews:edit">${not empty baseNews.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="base:baseNews:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="baseNews" action="${ctx}/base/baseNews/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片路径：</label>
			<div class="controls">
				<form:hidden id="path" path="path" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="path" type="files" uploadPath="/base/baseNews" selectMultiple="true"/>
			</div>
		</div>
		<!-- 加载编辑器的容器 -->
	    <script id="container" name="content" type="text/plain">
        	请输入新闻内容
    	</script>
	    <!-- 配置文件 -->
	    <script type="text/javascript" src="${ctxStatic}/ueditor/ueditor.config.js"></script>
	    <!-- 编辑器源码文件 -->
	    <script type="text/javascript" src="${ctxStatic}/ueditor/ueditor.all.js"></script>
	    <!-- 实例化编辑器 -->
	    <script type="text/javascript">
	    
	        var ue = UE.getEditor('container');
	      	//对编辑器的操作最好在编辑器ready之后再做
	      	ue.ready(function() {
	          	//设置编辑器的内容
	          	ue.setContent('${baseNews.content}', false);
	          	//获取html内容，返回: <p>hello</p>
	          	var html = ue.getContent();
	          	//获取纯文本内容，返回: hello
	          	var txt = ue.getContentTxt();
	      	});
	      	
	      	ue.Editor.prototype._bkGetActionUrl = ue.Editor.prototype.getActionUrl;  
	      	ue.Editor.prototype.getActionUrl = function(action){  
	             if(action == '/f/core/saveFile'){  
	                 return '${ctx}'+'/f/core/saveFile';  
	             }else{  
	                 return this._bkGetActionUrl.call(this, action);  
	             }  
	         }  
	      	
	    </script>
		<div class="control-group">
			<label class="control-label">内容：</label>
			<div class="controls">
				<%-- <form:textarea path="content" htmlEscape="false" rows="4" maxlength="3000" class="input-xxlarge "/> --%>
				${baseNews.content}
				
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="base:baseNews:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>