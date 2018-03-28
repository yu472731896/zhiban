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
import com.thinkgem.jeesite.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.base.entity.BaseNovelUser;
import com.thinkgem.jeesite.modules.base.service.BaseNovelUserService;

/**
 * 小说用户表信息表Controller
 * @author minghui
 * @version 2018-02-22
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseNovelUser")
public class BaseNovelUserController extends BaseController {

	@Autowired
	private BaseNovelUserService baseNovelUserService;
	@Autowired
	private SessionDAO sessionDAO;
	
	
	@ModelAttribute
	public BaseNovelUser get(@RequestParam(required=false) String id) {
		BaseNovelUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseNovelUserService.get(id);
		}
		if (entity == null){
			entity = new BaseNovelUser();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseNovelUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseNovelUser baseNovelUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseNovelUser> page = baseNovelUserService.findPage(new Page<BaseNovelUser>(request, response), baseNovelUser); 
		model.addAttribute("page", page);
		return "modules/base/baseNovelUserList";
	}

	@RequiresPermissions("base:baseNovelUser:view")
	@RequestMapping(value = "form")
	public String form(BaseNovelUser baseNovelUser, Model model) {
		model.addAttribute("baseNovelUser", baseNovelUser);
		return "modules/base/baseNovelUserForm";
	}

	@RequiresPermissions("base:baseNovelUser:edit")
	@RequestMapping(value = "save")
	public String save(BaseNovelUser baseNovelUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseNovelUser)){
			return form(baseNovelUser, model);
		}
		baseNovelUserService.save(baseNovelUser);
		addMessage(redirectAttributes, "保存小说用户表信息表成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNovelUser/?repage";
	}
	
	@RequiresPermissions("base:baseNovelUser:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseNovelUser baseNovelUser, RedirectAttributes redirectAttributes) {
		baseNovelUserService.delete(baseNovelUser);
		addMessage(redirectAttributes, "删除小说用户表信息表成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNovelUser/?repage";
	}
	
	
	/***************************************以上为监管端******************************************/
	
	/***************************************下面为用户端******************************************/
	
	

}