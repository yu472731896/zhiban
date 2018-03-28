/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.base.entity.BaseNovelUser;
import com.thinkgem.jeesite.modules.base.dao.BaseNovelUserDao;

/**
 * 小说用户表信息表Service
 * @author minghui
 * @version 2018-02-22
 */
@Service
@Transactional(readOnly = true)
public class BaseNovelUserService extends CrudService<BaseNovelUserDao, BaseNovelUser> {

	public BaseNovelUser get(String id) {
		return super.get(id);
	}
	
	public List<BaseNovelUser> findList(BaseNovelUser baseNovelUser) {
		return super.findList(baseNovelUser);
	}
	
	public Page<BaseNovelUser> findPage(Page<BaseNovelUser> page, BaseNovelUser baseNovelUser) {
		return super.findPage(page, baseNovelUser);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseNovelUser baseNovelUser) {
		super.save(baseNovelUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseNovelUser baseNovelUser) {
		super.delete(baseNovelUser);
	}
	
}