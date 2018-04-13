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
import com.thinkgem.jeesite.modules.base.entity.BaseUserInfo;
import com.thinkgem.jeesite.modules.base.service.BaseUserInfoService;

/**
 * 用户基础信息Controller
 * @author minghui
 * @version 2018-04-13
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseUserInfo")
public class BaseUserInfoController extends BaseController {

	@Autowired
	private BaseUserInfoService baseUserInfoService;
	
	@ModelAttribute
	public BaseUserInfo get(@RequestParam(required=false) String id) {
		BaseUserInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseUserInfoService.get(id);
		}
		if (entity == null){
			entity = new BaseUserInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseUserInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseUserInfo baseUserInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseUserInfo> page = baseUserInfoService.findPage(new Page<BaseUserInfo>(request, response), baseUserInfo); 
		model.addAttribute("page", page);
		return "modules/base/baseUserInfoList";
	}

	@RequiresPermissions("base:baseUserInfo:view")
	@RequestMapping(value = "form")
	public String form(BaseUserInfo baseUserInfo, Model model) {
		model.addAttribute("baseUserInfo", baseUserInfo);
		return "modules/base/baseUserInfoForm";
	}

	@RequiresPermissions("base:baseUserInfo:edit")
	@RequestMapping(value = "save")
	public String save(BaseUserInfo baseUserInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseUserInfo)){
			return form(baseUserInfo, model);
		}
		baseUserInfoService.save(baseUserInfo);
		addMessage(redirectAttributes, "保存用户基础信息成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseUserInfo/?repage";
	}
	
	@RequiresPermissions("base:baseUserInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseUserInfo baseUserInfo, RedirectAttributes redirectAttributes) {
		baseUserInfoService.delete(baseUserInfo);
		addMessage(redirectAttributes, "删除用户基础信息成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseUserInfo/?repage";
	}

}