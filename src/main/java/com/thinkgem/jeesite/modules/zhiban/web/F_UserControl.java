package com.thinkgem.jeesite.modules.zhiban.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

@Controller
@RequestMapping(value="${frontPath}/user")
public class F_UserControl  extends BaseController {

	@Autowired
	private SystemService systemService;
	
	/**
	 * 注册保存
	 */
	@RequestMapping(value="save")
	public String save(User user, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes){
		try {
			Office office = new Office();
			office.setId("2018");
			user.setOffice(office);
			user.setCompany(office);
			
			if (StringUtils.isNotBlank(user.getNewPassword())) {
				user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
			}
			List<Role> roleList = Lists.newArrayList();
			Role role = new Role();
			role.setId("2");
			roleList.add(role);
			user.setRoleList(roleList);
			
			User u = new User();
			u.setId("1");
			user.setCreateBy(u);
			user.setUpdateBy(u);
			
			systemService.saveUser(user);
		} catch (Exception e) {
			logger.debug("手机页面注册出错："+e.getMessage());
		}
		//
		return "redirect:" + frontPath + "/fIndex";
	}
	
	
	/**
	 * 验证登录名是否有效
	 * @param oldLoginName
	 * @param loginName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkLoginName")
	public String checkLoginName(String oldLoginName, String loginName) {
		if (loginName !=null && loginName.equals(oldLoginName)) {
			return "true";
		} else if (loginName !=null && systemService.getUserByLoginName(loginName) == null) {
			return "true";
		}
		return "false";
	}
	
}
