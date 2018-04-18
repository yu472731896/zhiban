package com.thinkgem.jeesite.modules.base.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.base.entity.BaseNews;
import com.thinkgem.jeesite.modules.base.entity.BaseUserInfo;
import com.thinkgem.jeesite.modules.base.service.BaseNewsService;
import com.thinkgem.jeesite.modules.base.service.BaseUserInfoService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.security.FormAuthenticationFilter;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${frontPath}/core")
public class CoreController extends BaseController {

	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	
	@Autowired
	private BaseNewsService baseNewsService;
	
	
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
	
	/*@RequestMapping(value = {"view", ""})
	public String list(String userid, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		return "modules/zhiban/index";
	}*/
	
	@RequestMapping("/view/{userId}")
	public String list(@PathVariable("userId") String userId , HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//获取用户信息
		BaseUserInfo newUserInfo = new BaseUserInfo();
		List<BaseUserInfo> userInfoList= baseUserInfoService.findList(newUserInfo);
		//获取新闻列表
		BaseNews baseNews = new BaseNews();
		List<BaseNews> newsList = baseNewsService.findList(baseNews);
		
		BaseUserInfo userInfo = userInfoList.get(0);
		
		//替换二维码地址中的 "|" 符号
		if(userInfo != null && StringUtils.isNoneBlank(userInfo.getWeixinMa())){
			String weixinMa = userInfo.getWeixinMa();
			userInfo.setWeixinMa(weixinMa.replace("|", "")); 
		}
		
		//替换二维码地址中的 "|" 符号
		if(userInfo != null && StringUtils.isNoneBlank(userInfo.getMusicFile())){
			String musicFile = userInfo.getMusicFile();
			userInfo.setMusicFile(musicFile.replace("|", "")); 
		}
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("newsList", newsList);
		
		return "modules/zhiban/moban";
	}
	
	
	
	//登陆跳转页面
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "modules/zhiban/userLogin";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginIn(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		
	Principal principal = UserUtils.getPrincipal();
		
		// 如果已经登录，则跳转到管理首页
		if(principal != null){
			/*return "redirect:" + adminPath;*/
			return "redirect:"+Global.getFrontPath()+"/core";
		}

		String username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
		boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
		boolean mobile = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
		String exception = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String message = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
		
		if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")){
			message = "用户或密码错误, 请重试.";
		}

		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_MOBILE_PARAM, mobile);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, exception);
		model.addAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_PARAM, message);
		
		if (logger.isDebugEnabled()){
			logger.debug("login fail, active session size: {}, message: {}, exception: {}", 
					sessionDAO.getActiveSessions(false).size(), message, exception);
		}
		
		/*// 非授权异常，登录失败，验证码加1。
		if (!UnauthorizedException.class.getName().equals(exception)){
			model.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
		}
		
		// 验证失败清空验证码
		request.getSession().setAttribute(ValidateCodeServlet.VALIDATE_CODE, IdGen.uuid());*/
		
		// 如果是手机登录，则返回JSON字符串
		if (mobile){
	        return renderString(response, model);
		}
		
		/*return "modules/sys/sysLogin";*/
		return "modules/zhiban/userLogin";
	}
	
	//注册跳转页面
	@RequestMapping(value = "register")
	public String register(String userid, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "modules/zhiban/userRegister";
	}
	
	/**
	 * 是否是验证码登录
	 * @param useruame 用户名
	 * @param isFail 计数加1
	 * @param clean 计数清零
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean){
		Map<String, Integer> loginFailMap = (Map<String, Integer>)CacheUtils.get("loginFailMap");
		if (loginFailMap==null){
			loginFailMap = Maps.newHashMap();
			CacheUtils.put("loginFailMap", loginFailMap);
		}
		Integer loginFailNum = loginFailMap.get(useruame);
		if (loginFailNum==null){
			loginFailNum = 0;
		}
		if (isFail){
			loginFailNum++;
			loginFailMap.put(useruame, loginFailNum);
		}
		if (clean){
			loginFailMap.remove(useruame);
		}
		return loginFailNum >= 3;
	}
	
}
