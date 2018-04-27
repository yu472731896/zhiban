/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.base.entity.BaseIntroduce;
import com.thinkgem.jeesite.modules.base.service.BaseIntroduceService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 介绍Controller
 * @author minghui
 * @version 2018-04-02
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseIntroduce")
public class BaseIntroduceController extends BaseController {

	@Autowired
	private BaseIntroduceService baseIntroduceService;
	
	@ModelAttribute
	public BaseIntroduce get(@RequestParam(required=false) String id) {
		BaseIntroduce entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseIntroduceService.get(id);
		}
		if (entity == null){
			entity = new BaseIntroduce();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseIntroduce:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseIntroduce baseIntroduce, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseIntroduce> page = baseIntroduceService.findPage(new Page<BaseIntroduce>(request, response), baseIntroduce); 
		model.addAttribute("page", page);
		return "modules/base/baseIntroduceList";
	}

	@RequiresPermissions("base:baseIntroduce:view")
	@RequestMapping(value = "form")
	public String form(BaseIntroduce baseIntroduce, Model model) {
		model.addAttribute("baseIntroduce", baseIntroduce);
		return "modules/base/baseIntroduceForm";
	}

	@RequiresPermissions("base:baseIntroduce:edit")
	@RequestMapping(value = "save")
	public String save(BaseIntroduce baseIntroduce, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseIntroduce)){
			return form(baseIntroduce, model);
		}
		baseIntroduce.setUser(UserUtils.getUser());	
		baseIntroduceService.save(baseIntroduce);
		addMessage(redirectAttributes, "保存介绍成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseIntroduce/?repage";
	}
	
	@RequiresPermissions("base:baseIntroduce:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseIntroduce baseIntroduce, RedirectAttributes redirectAttributes) {
		baseIntroduceService.delete(baseIntroduce);
		addMessage(redirectAttributes, "删除介绍成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseIntroduce/?repage";
	}

}