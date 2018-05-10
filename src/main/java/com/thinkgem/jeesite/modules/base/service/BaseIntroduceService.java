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
import com.thinkgem.jeesite.modules.base.entity.BaseIntroduce;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.base.dao.BaseIntroduceDao;

/**
 * 介绍Service
 * @author minghui
 * @version 2018-04-02
 */
@Service
@Transactional(readOnly = true)
public class BaseIntroduceService extends CrudService<BaseIntroduceDao, BaseIntroduce> {

	public BaseIntroduce get(String id) {
		return super.get(id);
	}
	
	public List<BaseIntroduce> findList(BaseIntroduce baseIntroduce) {
		User currUser = new User();
		if(null != currUser && StringUtils.isNoneBlank(currUser.getId())){
			baseIntroduce.setUser(currUser);
		}
		return super.findList(baseIntroduce);
	}
	
	public Page<BaseIntroduce> findPage(Page<BaseIntroduce> page, BaseIntroduce baseIntroduce) {
		return super.findPage(page, baseIntroduce);
	}
	
	@Transactional(readOnly = false)
	public void save(BaseIntroduce baseIntroduce) {
		super.save(baseIntroduce);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaseIntroduce baseIntroduce) {
		super.delete(baseIntroduce);
	}
	
}