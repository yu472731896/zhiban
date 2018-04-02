/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.base.entity.BaseTurnPicture;
import com.thinkgem.jeesite.modules.base.dao.BaseTurnPictureDao;

/**
 * 轮播图Service
 * @author minghui
 * @version 2018-04-02
 */
@Service
@Transactional(readOnly = true)
public class BaseTurnPictureService extends CrudService<BaseTurnPictureDao, BaseTurnPicture> {

	public BaseTurnPicture get(String id) {
		return super.get(id);
	}
	
	public List<BaseTurnPicture> findList(BaseTurnPicture baseTurnPicture) {
		return super.findList(baseTurnPicture);
	}
	
	public Page<BaseTurnPicture> findPage(Page<BaseTurnPicture> page, BaseTurnPicture baseTurnPicture) {
		return super.findPage(page, baseTurnPicture);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseTurnPicture baseTurnPicture) {
		super.save(baseTurnPicture);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseTurnPicture baseTurnPicture) {
		super.delete(baseTurnPicture);
	}
	
}