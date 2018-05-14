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
import com.thinkgem.jeesite.common.persistence.Page;
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
import com.thinkgem.jeesite.modules.sys.service.SystemService;
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
	
	@Autowired
	private SystemService systemService;
	
	
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
		
		BaseUserInfo newUserInfo = new BaseUserInfo();
		BaseNews baseNews = new BaseNews();
		User user = new User();
		if(StringUtils.isNoneBlank(userId)){
			//获取用户信息
			user = UserUtils.get(userId);
		}else{
			user= UserUtils.getUser();
		}
		
		newUserInfo.setUser(user);
		baseNews.setUser(user);
		//获取新闻列表
		Page<BaseNews> newsPageList = baseNewsService.findPage(new Page<BaseNews>(0, 5), baseNews);
		
		//获取用户基础信息
		List<BaseUserInfo> userInfoList= baseUserInfoService.findList(newUserInfo);
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
		
		model.addAttribute("user", user);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("newsList", newsPageList.getList());
		
		return "modules/zhiban/moban";
	}
	
	/**
	 *新闻详细 
	 */
	@RequestMapping(value = "mobileform")
	public String mobileform(BaseNews baseNews, Model model) {
		baseNews = baseNewsService.get(baseNews);
		model.addAttribute("baseNews", baseNews);
		return "modules/zhiban/Magazine_detail";
	}
	/**
	 *新闻列表 
	 */
	@RequestMapping(value = "userNewsList")
	public String userNewsList(BaseNews baseNews,HttpServletRequest request, HttpServletResponse response, Model model){
		
		User curruser = UserUtils.getUser();
		if(null != curruser && StringUtils.isNoneBlank(curruser.getId())) {
			baseNews.setUser(curruser);
		}
		
		Page<BaseNews> NewsPage= baseNewsService.findPage(new Page<BaseNews>(request, response), baseNews);
		model.addAttribute("page", NewsPage);
		return "modules/zhiban/Magazine_list";
	}
	
	/**
	 *查看我的名片 
	 * @return
	 */
	@RequestMapping(value = "showMe")
	public String userNewsList(HttpServletRequest request, HttpServletResponse response, Model model){
		
		User curruser = UserUtils.getUser();
		if(null != curruser && StringUtils.isNoneBlank(curruser.getId())) {
			return "redirect:"+Global.getFrontPath()+"/core/view/"+curruser.getId();
		}
		
		return "modules/zhiban/userLogin";
	}
	
	//登陆跳转页面
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "modules/zhiban/userLogin";
	}
	 
	
	//注册跳转页面
	@RequestMapping(value = "register")
	public String register(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		model.addAttribute("user", user);
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
	
	
	/**
	 * 图片上传方法
	 */
	@RequestMapping(value = "saveFile")
	public void saveFile(HttpServletRequest request, HttpServletResponse response, Model model){
		System.out.println("进行文件保存--->");
	}
	
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
