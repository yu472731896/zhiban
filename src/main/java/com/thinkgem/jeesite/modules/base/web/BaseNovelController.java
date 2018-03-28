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
import com.thinkgem.jeesite.modules.base.entity.BaseNovel;
import com.thinkgem.jeesite.modules.base.service.BaseNovelService;

/**
 * 小说用户表信息表Controller
 * @author minghui
 * @version 2018-02-22
 */
@Controller
@RequestMapping(value = "${adminPath}/base/baseNovel")
public class BaseNovelController extends BaseController {

	@Autowired
	private BaseNovelService baseNovelService;
	
	@ModelAttribute
	public BaseNovel get(@RequestParam(required=false) String id) {
		BaseNovel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baseNovelService.get(id);
		}
		if (entity == null){
			entity = new BaseNovel();
		}
		return entity;
	}
	
	@RequiresPermissions("base:baseNovel:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaseNovel baseNovel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaseNovel> page = baseNovelService.findPage(new Page<BaseNovel>(request, response), baseNovel); 
		model.addAttribute("page", page);
		return "modules/base/baseNovelList";
	}

	@RequiresPermissions("base:baseNovel:view")
	@RequestMapping(value = "form")
	public String form(BaseNovel baseNovel, Model model) {
		model.addAttribute("baseNovel", baseNovel);
		return "modules/base/baseNovelForm";
	}

	@RequiresPermissions("base:baseNovel:edit")
	@RequestMapping(value = "save")
	public String save(BaseNovel baseNovel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baseNovel)){
			return form(baseNovel, model);
		}
		baseNovelService.save(baseNovel);
		addMessage(redirectAttributes, "保存小说用户表信息表成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNovel/?repage";
	}
	
	@RequiresPermissions("base:baseNovel:edit")
	@RequestMapping(value = "delete")
	public String delete(BaseNovel baseNovel, RedirectAttributes redirectAttributes) {
		baseNovelService.delete(baseNovel);
		addMessage(redirectAttributes, "删除小说用户表信息表成功");
		return "redirect:"+Global.getAdminPath()+"/base/baseNovel/?repage";
	}
	
	
	

}