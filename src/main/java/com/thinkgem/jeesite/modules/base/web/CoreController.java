package com.thinkgem.jeesite.modules.base.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${frontPath}/core")
public class CoreController {

	
/*	@ModelAttribute
	public BaseIntroduce get(@RequestParam(required=false) String id) {
		BaseIntroduce entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseIntroduceService.get(id);
		}
		if (entity == null){
			entity = new BaseIntroduce();
		}
		return entity;
	}*/
	
	@RequestMapping(value = {"view", ""})
	public String list(String userid, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		return "modules/zhiban/index";
	}
}
