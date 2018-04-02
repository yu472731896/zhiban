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
import com.thinkgem.jeesite.modules.base.entity.BaseNews;
import com.thinkgem.jeesite.modules.base.service.BaseNewsService;

/**
 * 我的资讯Controller
 * @author minghui
 * @version 2018-04-02
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseNews")
public class BaseNewsController extends BaseController {

	@Autowired
	private BaseNewsService baseNewsService;
	
	@ModelAttribute
	public BaseNews get(@RequestParam(required=false) String id) {
		BaseNews entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseNewsService.get(id);
		}
		if (entity == null){
			entity = new BaseNews();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseNews:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseNews baseNews, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseNews> page = baseNewsService.findPage(new Page<BaseNews>(request, response), baseNews); 
		model.addAttribute("page", page);
		return "modules/base/baseNewsList";
	}

	@RequiresPermissions("base:baseNews:view")
	@RequestMapping(value = "form")
	public String form(BaseNews baseNews, Model model) {
		model.addAttribute("baseNews", baseNews);
		return "modules/base/baseNewsForm";
	}

	@RequiresPermissions("base:baseNews:edit")
	@RequestMapping(value = "save")
	public String save(BaseNews baseNews, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseNews)){
			return form(baseNews, model);
		}
		baseNewsService.save(baseNews);
		addMessage(redirectAttributes, "保存我的资讯成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNews/?repage";
	}
	
	@RequiresPermissions("base:baseNews:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseNews baseNews, RedirectAttributes redirectAttributes) {
		baseNewsService.delete(baseNews);
		addMessage(redirectAttributes, "删除我的资讯成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNews/?repage";
	}

}