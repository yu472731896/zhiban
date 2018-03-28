/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.base.entity.BaseNovel;
import com.thinkgem.jeesite.modules.base.dao.BaseNovelDao;

/**
 * 小说用户表信息表Service
 * @author minghui
 * @version 2018-02-22
 */
@Service
@Transactional(readOnly = true)
public class BaseNovelService extends CrudService<BaseNovelDao, BaseNovel> {

	public BaseNovel get(String id) {
		return super.get(id);
	}
	
	public List<BaseNovel> findList(BaseNovel baseNovel) {
		return super.findList(baseNovel);
	}
	
	public Page<BaseNovel> findPage(Page<BaseNovel> page, BaseNovel baseNovel) {
		return super.findPage(page, baseNovel);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseNovel baseNovel) {
		super.save(baseNovel);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseNovel baseNovel) {
		super.delete(baseNovel);
	}
	
}