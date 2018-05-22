<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
		<%@include file="/WEB-INF/views/include/zhibanHead.jsp" %>
		
		<script type="text/javascript">
		$(document).ready(function() {
			/* $("#no").focus(); */
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${fctx}/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')}
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
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
	<body class="bg_login">
		<form:form id="inputForm" modelAttribute="user" action="${fctx}/user/save" method="post" class="user_login_box" >
			<div style="text-align: center;">
				<svg class="icon" aria-hidden="true" style="width: 40px;height: 40px;">
					<use xlink:href="#icon-login_user"></use>
				</svg>
			</div>
			<h2 class="login_title">注册</h2>
			
			<div class="controls">
				<label class="control-label"><font color="red">* </font>登录名</label>
				<form:input path="loginName" htmlEscape="false" maxlength="50" class="required"/>
			</div>
			<div class="controls">
				<label class="control-label"><font color="red">* </font>姓名</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
			</div>
			<div class="controls">
				<label class="control-label">手机号码</label>
				<form:input path="mobile" htmlEscape="false" maxlength="100"/>
			</div>
			
			<div class="controls">
				<label class="control-label"><font color="red">* </font>密码</label>
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
			</div>
			<div class="controls">
				<label class="control-label"><font color="red">* </font>确认密码</label>
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" class="required" equalTo="#newPassword"/>
			</div>
			
			<p class="small_operation">
				<a style="float: right;" href="${fctx}/core/login">已有账号，立即登录&gt;</a>
			</p>
			<!-- <button class="common_btn"></button> -->
			<button id="btnSubmit" class="btn btn-primary common_btn" type="submit">注册</button>
		</form:form>
	</body>

</html>