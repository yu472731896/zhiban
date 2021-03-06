<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>我的资讯管理</title>
	<meta name="decorator" content="default"/>
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					
					var html = ue.getContent();
					console.log("html-->"+html);
					
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
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge req"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片路径：</label>
			<div class="controls">
				<form:hidden id="path" path="path" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<sys:ckfinder input="path" type="files" uploadPath="/base/baseNews" selectMultiple="false"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<!-- 加载编辑器的容器 -->
	    <script id="container" name="content"  style="width:100%;height:350px;" type="text/plain">
        	
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
	      		
	      		/* document.getElementById("mydiv").innerHTML = '${baseNews.content}'; */
	          	//设置编辑器的内容
	       	 /*  ue.setContent(${baseNews.content},false); */
	           ue.setContent('${baseNews.content}');
	          	//获取html内容，返回: <p>hello</p>
	          	var html = ue.getContent();
	          	//获取纯文本内容，返回: hello
	          	var txt = ue.getContentTxt();
	      	});
	      	
	      	 //请求自己的接口上传文件
		    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
		    UE.Editor.prototype.getActionUrl = function (action) {
		        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo') {
		            return '${ctx}/ueditor/uploadFile';
		        } else {
		            return this._bkGetActionUrl.call(this, action);
		        }
		    };
	    </script>
	    
	    
		<%-- <div class="control-group">
			<label class="control-label">内容：</label>
			<div id="mydiv" class="controls">
				<form:textarea path="content" htmlEscape="false" rows="4" maxlength="3000" class="input-xxlarge "/>
			</div>
		</div> --%>
		
		<div class="form-actions">
			<shiro:hasPermission name="base:baseNews:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>