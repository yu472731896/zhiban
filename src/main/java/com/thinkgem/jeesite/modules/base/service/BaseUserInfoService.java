/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.base.entity.BaseUserInfo;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.base.dao.BaseUserInfoDao;

/**
 * 用户基础信息Service
 * @author minghui
 * @version 2018-04-13
 */
@Service
@Transactional(readOnly = true)
public class BaseUserInfoService extends CrudService<BaseUserInfoDao, BaseUserInfo> {

	public BaseUserInfo get(String id) {
		return super.get(id);
	}
	
	public List<BaseUserInfo> findList(BaseUserInfo baseUserInfo) {
		User currUser = new User();
		if(null != currUser && StringUtils.isNoneBlank(currUser.getId())){
			baseUserInfo.setUser(currUser);
		}
		
		return super.findList(baseUserInfo);
	}
	
	public Page<BaseUserInfo> findPage(Page<BaseUserInfo> page, BaseUserInfo baseUserInfo) {
		return super.findPage(page, baseUserInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseUserInfo baseUserInfo) {
		super.save(baseUserInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseUserInfo baseUserInfo) {
		super.delete(baseUserInfo);
	}
	
}