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
import com.thinkgem.jeesite.modules.base.entity.BaseTurnPicture;
import com.thinkgem.jeesite.modules.base.service.BaseTurnPictureService;

/**
 * 轮播图Controller
 * @author minghui
 * @version 2018-04-02
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseTurnPicture")
public class BaseTurnPictureController extends BaseController {

	@Autowired
	private BaseTurnPictureService baseTurnPictureService;
	
	@ModelAttribute
	public BaseTurnPicture get(@RequestParam(required=false) String id) {
		BaseTurnPicture entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseTurnPictureService.get(id);
		}
		if (entity == null){
			entity = new BaseTurnPicture();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseTurnPicture:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseTurnPicture baseTurnPicture, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseTurnPicture> page = baseTurnPictureService.findPage(new Page<BaseTurnPicture>(request, response), baseTurnPicture); 
		model.addAttribute("page", page);
		return "modules/base/baseTurnPictureList";
	}

	@RequiresPermissions("base:baseTurnPicture:view")
	@RequestMapping(value = "form")
	public String form(BaseTurnPicture baseTurnPicture, Model model) {
		model.addAttribute("baseTurnPicture", baseTurnPicture);
		return "modules/base/baseTurnPictureForm";
	}

	@RequiresPermissions("base:baseTurnPicture:edit")
	@RequestMapping(value = "save")
	public String save(BaseTurnPicture baseTurnPicture, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseTurnPicture)){
			return form(baseTurnPicture, model);
		}
		baseTurnPictureService.save(baseTurnPicture);
		addMessage(redirectAttributes, "保存轮播图成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseTurnPicture/?repage";
	}
	
	@RequiresPermissions("base:baseTurnPicture:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseTurnPicture baseTurnPicture, RedirectAttributes redirectAttributes) {
		baseTurnPictureService.delete(baseTurnPicture);
		addMessage(redirectAttributes, "删除轮播图成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseTurnPicture/?repage";
	}

}