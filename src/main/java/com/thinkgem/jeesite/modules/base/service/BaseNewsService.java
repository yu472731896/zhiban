/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.base.entity.BaseNews;
import com.thinkgem.jeesite.modules.base.dao.BaseNewsDao;

/**
 * 我的资讯Service
 * @author minghui
 * @version 2018-04-02
 */
@Service
@Transactional(readOnly = true)
public class BaseNewsService extends CrudService<BaseNewsDao, BaseNews> {

	public BaseNews get(String id) {
		return super.get(id);
	}
	
	public List<BaseNews> findList(BaseNews baseNews) {
		return super.findList(baseNews);
	}
	
	public Page<BaseNews> findPage(Page<BaseNews> page, BaseNews baseNews) {
		return super.findPage(page, baseNews);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseNews baseNews) {
		super.save(baseNews);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseNews baseNews) {
		super.delete(baseNews);
	}
	
}