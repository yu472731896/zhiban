package com.thinkgem.jeesite.modules.base.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}/manage")
public class ManageController {


	/**
	 * 我的名片查看
	 * @return
	 */
	@RequestMapping("/myView")
	public String myView( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		User currUser = UserUtils.getUser();
		model.addAttribute("user",currUser);
			
		return "modules/zhiban/myView";
	}
}
