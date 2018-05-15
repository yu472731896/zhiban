package com.thinkgem.jeesite.modules.zhiban.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class F_IndexControl {
	
	/**
	 * 登录成功，进入管理首页
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "${frontPath}/fFndex")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "modules/zhiban/fIndex";
	}
	

}
